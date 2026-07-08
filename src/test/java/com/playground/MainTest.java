package com.playground;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.playground.core.StreamsDemo.Product;
import com.playground.libraries.JacksonDemo.UserProfile;
import com.playground.libraries.LombokDemo.Employee;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    public void testLombokDataAndBuilder() {
        Employee emp = Employee.builder()
            .id(501)
            .name("Jane Doe")
            .department("Research")
            .salary(150000.0)
            .skills(List.of("Java", "JUnit"))
            .build();

        assertNotNull(emp);
        assertEquals(501, emp.getId());
        assertEquals("Jane Doe", emp.getName());
        assertEquals("Research", emp.getDepartment());
        assertEquals(150000.0, emp.getSalary());
        assertEquals(2, emp.getSkills().size());
    }

    @Test
    public void testGuavaBiMap() {
        BiMap<String, Integer> map = HashBiMap.create();
        map.put("A", 1);
        map.put("B", 2);

        assertEquals(1, map.get("A"));
        assertEquals("B", map.inverse().get(2));
    }

    @Test
    public void testJacksonSerialization() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        UserProfile user = new UserProfile("tester", 25, List.of("User"), true);

        String json = mapper.writeValueAsString(user);
        assertTrue(json.contains("\"username\":\"tester\""));
        assertTrue(json.contains("\"age\":25"));

        UserProfile deserialized = mapper.readValue(json, UserProfile.class);
        assertEquals("tester", deserialized.username());
        assertEquals(25, deserialized.age());
    }

    @Test
    public void testJavaRecordStreams() {
        List<Product> products = List.of(
            new Product("A", "Category1", 10.0),
            new Product("B", "Category2", 20.0),
            new Product("C", "Category1", 30.0)
        );

        List<Product> filtered = products.stream()
            .filter(p -> p.category().equals("Category1"))
            .toList();

        assertEquals(2, filtered.size());
        assertEquals("A", filtered.get(0).name());
        assertEquals("C", filtered.get(1).name());
    }
}
