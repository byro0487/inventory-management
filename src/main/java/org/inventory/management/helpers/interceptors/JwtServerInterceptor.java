package org.inventory.management.helpers.interceptors;

import io.grpc.*;
import io.jsonwebtoken.*;
import org.inventory.management.config.Configurations;

public class JwtServerInterceptor  implements ServerInterceptor{

    private final JwtParser parser = Jwts.parser().setSigningKey(Configurations.JWT_SIGNING_KEY);
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
