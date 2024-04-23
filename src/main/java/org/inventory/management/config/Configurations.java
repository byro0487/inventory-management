package org.inventory.management.config;

import io.grpc.Context;
import io.grpc.Metadata;
/**
 * Contains configuration constants used throughout the application.
 * This includes security keys, database connection details, and gRPC metadata configurations.
 * This will be replaced/loaded from zookeeper where we can store the config.
 */
public class Configurations {
    /** The key used for signing and verifying JWT tokens. */
    public static final String JWT_SIGNING_KEY = "L8hHXsaQOUjk5rg7XPGv4eL36anlCrkMz8CJ0i/8E/0=";
    /** The type of the bearer token. */
    public static final String BEARER_TYPE = "Bearer";
    /** Metadata key for accessing the Authorization header in gRPC calls. */
    public static final Metadata.Key<String> AUTHORIZATION_METADATA_KEY = Metadata.Key.of("Authorization", Metadata.ASCII_STRING_MARSHALLER);
    /** Context key for storing client ID in gRPC context. */
    public static final Context.Key<String> CLIENT_ID_CONTEXT_KEY = Context.key("clientId");
    /** JDBC connection URL for the H2 in-memory database. */
    public static final String DB_CONNECTION_URL = "jdbc:h2:mem:testdb";
    /** Default username for the database connection. */
    public static final String DB_USER_NAME = "sa";
    /** Default password for the database connection. */
    public static final String DB_PASSWORD = "";


}
