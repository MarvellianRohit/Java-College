package com.playground.libraries;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j // Automatically creates: private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(LombokDemo.class);
public class LombokDemo {

    // @Data generates getters, setters, toString, equals, hashCode, and a constructor for final fields.
    @Data
    @Builder
    public static class Employee {
        private final int id;
        @NonNull private String name; // Throws NullPointerException if set to null
        private String department;
        private double salary;
        private List<String> skills;
    }

    public static void runDemo() {
        log.info("--- Starting Lombok Demo ---");

        // 1. Showcase Lombok Builder Pattern
        Employee emp = Employee.builder()
            .id(101)
            .name("Jane Miller")
            .department("Engineering")
            .salary(125000.00)
            .skills(List.of("Java", "Docker", "AWS"))
            .build();

        log.info("Employee created using Builder: {}", emp);

        // 2. Showcase @Data Getters and Setters
        emp.setSalary(130000.00); // Setters generated for non-final fields
        log.info("Jane's updated salary: ${}", emp.getSalary());
        log.info("Jane's skills: {}", emp.getSkills());

        // 3. Showcase @NonNull Runtime Check
        try {
            log.info("Attempting to create an employee with a null name to trigger Lombok null check...");
            Employee.builder()
                .id(102)
                .name(null) // Should trigger NullPointerException
                .build();
        } catch (NullPointerException e) {
            log.info("Caught expected Lombok NullPointerException: {}", e.getMessage());
        }

        log.info("--- Lombok Demo Completed ---\n");
    }
}
