package org.inventory.management.external;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.inventory.management.config.Configurations;

public class AuthService {

    public static  String getTokenData(String subject) {

        final String jwt =
                Jwts.builder()
                        .setSubject(subject)
                        .signWith(SignatureAlgorithm.HS256, Configurations.JWT_SIGNING_KEY)
                        .compact();
        return String.format("%s %s", Configurations.BEARER_TYPE, jwt);
    }


}
