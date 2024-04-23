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
 * CallCredentials implementation, which carries the JWT value that will be propagated to the
 * server in the request metadata with the "Authorization" key and the "Bearer" prefix.
 */
public class JwtCredential {

    private final String subject;

    @Getter
    public String token;
    public JwtCredential(String subject) {
        this.subject = subject;
        this.token = getTokenData();
    }
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
