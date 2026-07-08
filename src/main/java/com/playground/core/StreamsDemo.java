package com.playground.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamsDemo {
    private static final Logger logger = LoggerFactory.getLogger(StreamsDemo.class);

    // Modern Java Record (Java 14+) for data holding
    public record Product(String name, String category, double price) {}

    public static void runDemo() {
        logger.info("--- Starting Streams API Demo ---");

        List<Product> products = List.of(
            new Product("Laptop", "Electronics", 1200.00),
            new Product("Smartphone", "Electronics", 800.00),
            new Product("Coffee Maker", "Home", 99.99),
            new Product("Desk Chair", "Furniture", 199.99),
            new Product("Headphones", "Electronics", 150.00),
            new Product("Toaster", "Home", 49.99)
        );

        // 1. Filtering, Mapping, and Sorting
        List<String> premiumElectronics = products.stream()
            .filter(p -> p.category().equals("Electronics"))
            .filter(p -> p.price() > 500)
            .map(Product::name)
            .sorted()
            .toList(); // Modern Java 16+ shorthand instead of collect(Collectors.toList())

        logger.info("Premium electronics (> $500) sorted: {}", premiumElectronics);

        // 2. Map-Reduce (Total Inventory Value)
        double totalValue = products.stream()
            .mapToDouble(Product::price)
            .reduce(0, Double::sum);

        logger.info("Total value of all items: ${}", String.format("%.2f", totalValue));

        // 3. Grouping By Category
        Map<String, List<Product>> byCategory = products.stream()
            .collect(Collectors.groupingBy(Product::category));

        byCategory.forEach((category, list) -> 
            logger.info("Category '{}' items: {}", category, list.stream().map(Product::name).toList())
        );

        // 4. Partitioning By Price (e.g. Budget vs Premium items)
        Map<Boolean, List<Product>> budgetVsPremium = products.stream()
            .collect(Collectors.partitioningBy(p -> p.price() < 150.00));

        logger.info("Budget items (< $150): {}", 
            budgetVsPremium.get(true).stream().map(Product::name).toList()
        );
        logger.info("Premium items (>= $150): {}", 
            budgetVsPremium.get(false).stream().map(Product::name).toList()
        );

        logger.info("--- Streams API Demo Completed ---\n");
    }
}
