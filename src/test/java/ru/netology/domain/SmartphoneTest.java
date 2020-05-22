package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class SmartphoneTest {

    @Test
    void shouldMatchByManufacturer() {
        Smartphone smart = new Smartphone(6, 30000, "iPhone SE", "Apple");
        boolean actual = smart.matches("Apple");
        assertTrue(actual);

    }

    @Test
    void shouldMatchByName() {
        Smartphone smart = new Smartphone(4, 80000, "Galaxy Note 10", "Samsung");
        boolean actual = smart.matches("Galaxy Note 10");
        assertTrue(actual);
    }

    @Test
    void shouldNotMatchByManufacturer() {
        Smartphone smart = new Smartphone(5, 15000, "K 10000", "Oukitel");
        boolean actual = smart.matches("Apple");
        assertFalse(actual);
    }

    @Test
    void shouldNotMatchByName() {
        Smartphone smart = new Smartphone(6, 30000, "iPhone SE", "Apple");
        boolean actual = smart.matches("K 10000");
        assertFalse(actual);
    }
}
