package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    private Product item1 = new Book(1, 200, "The Hound of the Baskervilles", "Arthur Conan Doyle");
    private Product item2 = new Book(2, 400, "Rogue Lawyer", "John Grisham");
    private Product item3 = new Book(3, 500, "The Martian Chronicles", "Ray Bradbury");
    private Product item4 = new Smartphone(4, 80000, "Galaxy Note 10", "Samsung");
    private Product item5 = new Smartphone(5, 15000, "K 10000", "Oukitel");
    private Product item6 = new Smartphone(6, 30000, "iPhone SE", "Apple");

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
    void shouldSearchByAuthor() {
        Product[] expected = new Product[]{item2};
        Product[] actual = manager.searchBy("John Grisham");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByBookName() {
        Product[] expected = new Product[]{item3};
        Product[] actual = manager.searchBy("The Martian Chronicles");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByPhoneName() {
        Product[] expected = new Product[]{item6};
        Product[] actual = manager.searchBy("iPhone SE");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByManufacturer() {
        Product[] expected = new Product[]{item4};
        Product[] actual = manager.searchBy("Samsung");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByAuthorNegative() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("Agatha Christie");
        assertArrayEquals(expected, actual);
    }
}

