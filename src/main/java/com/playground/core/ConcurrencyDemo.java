package com.playground.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ConcurrencyDemo {
    private static final Logger logger = LoggerFactory.getLogger(ConcurrencyDemo.class);

    public static void runDemo() {
        logger.info("--- Starting Concurrency Demo ---");

        // 1. CompletableFuture for Asynchronous Pipelines
        logger.info("Triggering CompletableFuture async tasks...");
        CompletableFuture<String> pipeline = CompletableFuture.supplyAsync(() -> {
            logger.info("Task 1: Fetching database configurations...");
            sleep(100);
            return "DB_Config_Set";
        }).thenApplyAsync(config -> {
            logger.info("Task 2: Authenticating with config: {}", config);
            sleep(50);
            return "User_Session_Active";
        });

        try {
            String result = pipeline.get(2, TimeUnit.SECONDS);
            logger.info("Pipeline completed with status: {}", result);
        } catch (Exception e) {
            logger.error("CompletableFuture pipeline failed", e);
        }

        // 2. Modern Java Virtual Threads (Java 21+)
        // Virtual threads are extremely lightweight threads backed by a fork-join pool.
        // We can spin up thousands of tasks without worrying about operating system threads.
        int taskCount = 1000;
        logger.info("Launching {} concurrent tasks using a Virtual Thread Executor...", taskCount);

        Instant start = Instant.now();

        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            List<Callable<Integer>> tasks = new ArrayList<>();
            for (int i = 0; i < taskCount; i++) {
                final int taskId = i;
                tasks.add(() -> {
                    // Simulating microsecond I/O blocking
                    Thread.sleep(Duration.ofMillis(10));
                    return taskId;
                });
            }

            // Execute all tasks and wait for them to finish
            List<Future<Integer>> futures = executor.invokeAll(tasks);
            
            // Just double check a few values
            long completedCount = futures.stream()
                .filter(Future::isDone)
                .count();

            Instant end = Instant.now();
            logger.info("Virtual Threads: Completed {}/{} tasks in {} ms", 
                completedCount, taskCount, Duration.between(start, end).toMillis());
        } catch (InterruptedException e) {
            logger.error("Virtual thread execution interrupted", e);
            Thread.currentThread().interrupt();
        }

        logger.info("--- Concurrency Demo Completed ---\n");
    }

    private static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
