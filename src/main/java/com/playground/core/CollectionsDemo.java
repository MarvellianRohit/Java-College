package com.playground.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class CollectionsDemo {
    private static final Logger logger = LoggerFactory.getLogger(CollectionsDemo.class);

    public static void runDemo() {
        logger.info("--- Starting Collections Framework Demo ---");

        // 1. Modern Unmodifiable Collections (Java 9+)
        List<String> fruits = List.of("Apple", "Banana", "Cherry");
        Set<Integer> numbers = Set.of(1, 2, 3, 4, 5);
        Map<String, Integer> fruitInventory = Map.of(
            "Apple", 10,
            "Banana", 20,
            "Cherry", 15
        );

        logger.info("Immutable List: {}", fruits);
        logger.info("Immutable Set: {}", numbers);
        logger.info("Immutable Map: {}", fruitInventory);

        // 2. Modifying Collections
        List<String> mutableFruits = new ArrayList<>(fruits);
        mutableFruits.add("Dragonfruit");
        mutableFruits.add("Elderberry");
        
        // Sorting with Comparator
        mutableFruits.sort(Comparator.comparingInt(String::length));
        logger.info("Sorted mutable list by length: {}", mutableFruits);

        // 3. Deque / Queue (Double Ended Queue)
        Deque<String> deque = new ArrayDeque<>();
        deque.addLast("Task 2");
        deque.addFirst("Task 1");
        deque.addLast("Task 3");
        
        logger.info("Deque state: {}", deque);
        logger.info("Polled from front: {}", deque.pollFirst()); // Task 1
        logger.info("Polled from back: {}", deque.pollLast());   // Task 3
        logger.info("Remaining Deque: {}", deque);

        // 4. Thread-Safe / Concurrent Collections
        Map<String, String> concurrentMap = new ConcurrentHashMap<>();
        concurrentMap.put("Key1", "Value1");
        concurrentMap.put("Key2", "Value2");
        
        // computeIfAbsent is an atomic check-and-insert operation
        concurrentMap.computeIfAbsent("Key3", k -> "Computed_" + k);
        logger.info("Concurrent Map entry for Key3: {}", concurrentMap.get("Key3"));

        logger.info("--- Collections Framework Demo Completed ---\n");
    }
}
