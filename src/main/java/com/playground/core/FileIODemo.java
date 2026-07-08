package com.playground.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileIODemo {
    private static final Logger logger = LoggerFactory.getLogger(FileIODemo.class);

    public static void runDemo() {
        logger.info("--- Starting File I/O Demo (NIO.2) ---");

        try {
            // 1. Create a Temporary File
            Path tempFile = Files.createTempFile("java_playground_", ".txt");
            logger.info("Created temporary file at: {}", tempFile);

            // 2. Writing content (Java 11+ writeString)
            String textContent = "Hello from the Java 25 Playground!\nLine 2: Built-in NIO.2 is fast.\n";
            Files.writeString(tempFile, textContent);
            logger.info("Successfully wrote string contents to file.");

            // Appending content
            Files.writeString(tempFile, "Line 3: Appended log line.\n", StandardOpenOption.APPEND);

            // 3. Reading contents (Java 11+ readString and readAllLines)
            String fullContent = Files.readString(tempFile);
            logger.info("File contents read via readString():\n{}", fullContent.trim());

            List<String> lines = Files.readAllLines(tempFile);
            logger.info("Total lines read: {}", lines.size());

            // 4. Checking file properties/attributes
            boolean exists = Files.exists(tempFile);
            long bytes = Files.size(tempFile);
            boolean isRegular = Files.isRegularFile(tempFile);

            logger.info("File verification -> Exists: {}, Size: {} bytes, Regular file: {}", 
                exists, bytes, isRegular);

            // 5. Cleanup
            Files.delete(tempFile);
            logger.info("Successfully deleted temporary file: {}", tempFile);

        } catch (IOException e) {
            logger.error("Error occurred during File I/O operations", e);
        }

        logger.info("--- File I/O Demo Completed ---\n");
    }
}
