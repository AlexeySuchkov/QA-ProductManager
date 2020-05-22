package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void shouldMatchByAuthor() {
        Book book = new Book(3, 500, "The Martian Chronicles", "Ray Bradbury");
        boolean actual = book.matches("Ray Bradbury");
        assertTrue(actual);

    }

    @Test
    void shouldMatchByName() {
        Book book = new Book(2, 400, "Rogue Lawyer", "John Grisham");
        boolean actual = book.matches("Rogue Lawyer");
        assertTrue(actual);
    }

    @Test
    void shouldNotMatchByAuthor() {
        Book book = new Book(3, 500, "The Martian Chronicles", "Ray Bradbury");
        boolean actual = book.matches("John Grisham");
        assertFalse(actual);

    }

    @Test
    void shouldNotMatchByName() {
        Book book = new Book(3, 500, "The Martian Chronicles", "Ray Bradbury");
        boolean actual = book.matches("Rogue Lawyer");
        assertFalse(actual);
    }
}
