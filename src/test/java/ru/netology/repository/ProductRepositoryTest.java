package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();

    private Product item1 = new Book(1, 200, "The Hound of the Baskervilles", "Arthur Conan Doyle");
    private Product item2 = new Book(2, 400, "Rogue Lawyer", "John Grisham");
    private Product item3 = new Book(3, 500, "The Martian Chronicles", "Ray Bradbury");
    private Product item4 = new Smartphone(4, 80000, "Galaxy Note 10", "Samsung");
    private Product item5 = new Smartphone(5, 15000, "K 10000", "Oukitel");
    private Product item6 = new Smartphone(6, 30000, "iPhone SE", "Apple");

    private Product addItem = new Book(50, 450, "The Great Gatsy", "F. Scott Fitzgerald");

    @BeforeEach
    void setUp() {
        repository.save(item1);
        repository.save(item2);
        repository.save(item3);
        repository.save(item4);
        repository.save(item5);
        repository.save(item6);
    }

    @Test
    void shouldSave() {
        repository.save(addItem);
        Product[] actual = repository.findAll();
        Product[] expected = {
                item1,
                item2,
                item3,
                item4,
                item5,
                item6,
                addItem
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindById() {
        Product actual = repository.findById(1);
        Product expected = item1;
        assertEquals(expected, actual);
    }

    @Test
    void shouldNotFindById() {
        Product actual = repository.findById(100);
        assertNull(actual);
    }

    @Test
    void shouldRemoveById() {
        repository.removeById(1);
        Product[] actual = repository.findAll();
        Product[] expected = {
                item2,
                item3,
                item4,
                item5,
                item6
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotRemoveById() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> repository.removeById(11111));
    }
}
