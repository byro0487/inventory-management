package org.inventory.management.helpers.interceptors;

import io.grpc.*;
import io.jsonwebtoken.*;
import org.inventory.management.config.Configurations;
/**
 * Interceptor for JWT-based authentication on gRPC server calls.
 * This interceptor extracts the JWT token from the metadata, validates it,
 * and sets the user's client ID in the context if the token is valid.
 */
public class JwtServerInterceptor  implements ServerInterceptor{

    private final JwtParser parser = Jwts.parser().setSigningKey(Configurations.JWT_SIGNING_KEY);
    /**
     * Intercepts the incoming server call to perform JWT authentication.
     *
     * @param serverCall the server call being intercepted
     * @param metadata the metadata associated with the call
     * @param serverCallHandler the handler for the call
     * @return a listener for the call, either continuing the call chain or terminating it if authentication fails
     */
    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> serverCall, Metadata metadata, ServerCallHandler<ReqT, RespT> serverCallHandler) {
        // Note:
        // ideally this would be a call to auth service with the given token
        // we can also use claims to add roles per user and then do the authorization for the calls.

        String value = metadata.get(Configurations.AUTHORIZATION_METADATA_KEY);

        Status status = Status.OK;
        if (value == null) {
            status = Status.UNAUTHENTICATED.withDescription("Authorization token is missing");
        } else if (!value.startsWith(Configurations.BEARER_TYPE)) {
            status = Status.UNAUTHENTICATED.withDescription("Unknown authorization type");
        } else {
            Jws<Claims> claims = null;
            // remove authorization type prefix
            String token = value.substring(Configurations.BEARER_TYPE.length()).trim();
            try {
                // verify token signature and parse claims
                claims = parser.parseClaimsJws(token);
            } catch (JwtException e) {
                status = Status.UNAUTHENTICATED.withDescription(e.getMessage()).withCause(e);
            }
            if (claims != null) {
                // set client id into current context
                Context ctx = Context.current()
                        .withValue(Configurations.CLIENT_ID_CONTEXT_KEY, claims.getBody().getSubject());

                return Contexts.interceptCall(ctx, serverCall, metadata, serverCallHandler);
            }
        }

        serverCall.close(status, new Metadata());
        return new ServerCall.Listener<ReqT>() {
            // noop
        };
    }
}
