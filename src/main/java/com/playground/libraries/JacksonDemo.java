package com.playground.libraries;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class JacksonDemo {
    private static final Logger logger = LoggerFactory.getLogger(JacksonDemo.class);

    // Record structure representing a user profile
    public record UserProfile(String username, int age, List<String> roles, boolean active) {}

    public static void runDemo() {
        logger.info("--- Starting Jackson JSON Demo ---");

        // 1. Initialize ObjectMapper and configure pretty print
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        UserProfile profile = new UserProfile(
            "alice_coder", 
            28, 
            List.of("Developer", "Admin"), 
            true
        );

        try {
            // 2. Serialization (Object -> JSON String)
            String jsonOutput = mapper.writeValueAsString(profile);
            logger.info("Serialized JSON Output:\n{}", jsonOutput);

            // 3. Deserialization (JSON String -> Object)
            String rawJson = """
                {
                  "username" : "bob_tester",
                  "age" : 32,
                  "roles" : [ "QA", "User" ],
                  "active" : false
                }
                """;
            
            UserProfile deserializedUser = mapper.readValue(rawJson, UserProfile.class);
            logger.info("Deserialized Object: User={}, Age={}, Active={}, Roles={}", 
                deserializedUser.username(),
                deserializedUser.age(),
                deserializedUser.active(),
                deserializedUser.roles()
            );

        } catch (Exception e) {
            logger.error("Jackson operation failed", e);
        }

        logger.info("--- Jackson JSON Demo Completed ---\n");
    }
}
