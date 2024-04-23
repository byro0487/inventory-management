package org.inventory.management.helpers.interceptors;
/*
 * Copyright 2019 The gRPC Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import io.grpc.CallCredentials;
import io.grpc.Metadata;
import io.grpc.Status;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Getter;
import org.inventory.management.config.Configurations;

import java.util.concurrent.Executor;

/**
 * Provides JWT-based credentials for gRPC calls. This class encapsulates the generation
 * and formatting of a JWT token using a specified subject.
 */
public class JwtCredential {
    // The subject for which the JWT is generated.
    private final String subject;
    // The JWT token formatted as 'Bearer {token}'.
    @Getter
    public String token;
    /**
     * Constructs a JwtCredential instance for the specified subject.
     * @param subject the subject to be used in the JWT.
     */
    public JwtCredential(String subject) {
        this.subject = subject;
        this.token = getTokenData();
    }
    /**
     * Generates a JWT token, signs it with the configured key, and formats it with the 'Bearer' prefix.
     * @return the formatted JWT token.
     */
    private String getTokenData() {

        final String jwt =
                Jwts.builder()
                        .setSubject(subject)
                        .signWith(SignatureAlgorithm.HS256, Configurations.JWT_SIGNING_KEY)
                        .compact();
        token=String.format("%s %s", Configurations.BEARER_TYPE, jwt);
        return token;
    }
}
