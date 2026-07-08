package com.playground.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;

public class NetworkingDemo {
    private static final Logger logger = LoggerFactory.getLogger(NetworkingDemo.class);

    public static void runDemo() {
        logger.info("--- Starting Networking Demo (HttpClient) ---");

        // 1. Initialize modern HttpClient (configured with redirects and timeout)
        HttpClient client = HttpClient.newBuilder()
            .followRedirects(HttpClient.Redirect.NORMAL)
            .connectTimeout(Duration.ofSeconds(3))
            .build();

        // 2. Build a GET Request
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://httpbin.org/get?msg=HelloAntigravity"))
            .header("Accept", "application/json")
            .GET()
            .build();

        logger.info("Sending asynchronous HTTP GET request to httpbin.org...");

        // 3. Send request asynchronously
        CompletableFuture<HttpResponse<String>> futureResponse = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        futureResponse.thenAccept(response -> {
            int statusCode = response.statusCode();
            logger.info("HTTP Response Status Code: {}", statusCode);
            
            if (statusCode == 200) {
                // Truncate response body if it's long
                String body = response.body();
                String preview = body.length() > 200 ? body.substring(0, 200) + "..." : body;
                logger.info("HTTP Response Body Preview:\n{}", preview);
            } else {
                logger.warn("Unexpected status code: {}", statusCode);
            }
        }).exceptionally(ex -> {
            logger.warn("Could not connect to httpbin.org (might be offline). Error: {}", ex.getMessage());
            return null;
        }).join(); // Block main thread here only to ensure demo completes before exiting method

        logger.info("--- Networking Demo Completed ---\n");
    }
}
