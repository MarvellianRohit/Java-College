package com.playground.libraries;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.base.Preconditions;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class GuavaDemo {
    private static final Logger logger = LoggerFactory.getLogger(GuavaDemo.class);

    public static void runDemo() {
        logger.info("--- Starting Google Guava Demo ---");

        // 1. Multimap (Multiple values per key)
        Multimap<String, String> departmentMembers = HashMultimap.create();
        departmentMembers.put("IT", "Alice");
        departmentMembers.put("IT", "Bob");
        departmentMembers.put("HR", "Charlie");
        
        logger.info("IT Department Members: {}", departmentMembers.get("IT"));
        logger.info("All departments: {}", departmentMembers.keySet());

        // 2. BiMap (Bidirectional Map: Keys and Values are unique and invertible)
        BiMap<String, Integer> countryCodes = HashBiMap.create();
        countryCodes.put("USA", 1);
        countryCodes.put("India", 91);
        countryCodes.put("UK", 44);

        logger.info("Code for India: {}", countryCodes.get("India"));
        // Inverse mapping
        logger.info("Country with code 91: {}", countryCodes.inverse().get(91));

        // 3. Preconditions
        try {
            logger.info("Validating positive value check with Preconditions...");
            int age = -5;
            Preconditions.checkArgument(age >= 0, "Age cannot be negative: %s", age);
        } catch (IllegalArgumentException e) {
            logger.info("Preconditions validation successfully caught negative age: {}", e.getMessage());
        }

        // 4. Loading Cache
        LoadingCache<String, String> upperCaseCache = CacheBuilder.newBuilder()
            .maximumSize(100)
            .expireAfterWrite(10, TimeUnit.MINUTES)
            .build(new CacheLoader<>() {
                @Override
                public String load(String key) {
                    logger.info("Cache miss! Calculating upper-case value for: {}", key);
                    return key.toUpperCase();
                }
            });

        try {
            logger.info("Fetching 'java': {}", upperCaseCache.get("java")); // Cache miss
            logger.info("Fetching 'java' again: {}", upperCaseCache.get("java")); // Cache hit
        } catch (Exception e) {
            logger.error("Cache loading failed", e);
        }

        // 5. Joiner & Splitter
        String joined = Joiner.on(", ").skipNulls().join("Apple", null, "Banana", "Cherry");
        logger.info("Joined string: {}", joined);

        Iterable<String> split = Splitter.on(',')
            .trimResults()
            .omitEmptyStrings()
            .split("one, two, , three");
        logger.info("Split strings: {}", split);

        logger.info("--- Google Guava Demo Completed ---\n");
    }
}
