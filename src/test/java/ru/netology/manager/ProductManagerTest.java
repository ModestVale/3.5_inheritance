package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class ProductManagerTest {

    @Mock
    private ProductRepository repository;

    @InjectMocks
    private ProductManager productManager;

    private Book book = new Book(5, "Title", "Book");
    private Smartphone smartphone = new Smartphone(10, "Smartphone", "htc");
    private Smartphone smartphone1 = new Smartphone(11, "Smartphone next", "super8");
    private Book book1 = new Book(6, "Mega title", "Book author");

    @Test
    public void shouldFoundBooksIfExists() {
        createRepositoryMock();

        Product[] expected = new Product[2];
        expected[0] = book;
        expected[1] = book1;

        Product[] actual = productManager.searchBy("Book");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFoundSmartphonesIfExists() {
        createRepositoryMock();

        Product[] expectedSmartphone = new Product[2];
        expectedSmartphone[0] = smartphone;
        expectedSmartphone[1] = smartphone1;

        Product[] actualSmartphones = productManager.searchBy("Smartphone");
        assertArrayEquals(expectedSmartphone, actualSmartphones);
    }

    @Test
    public void shouldFoundSmartphoneByManufactureIfExists() {
        createRepositoryMock();

        Product[] expectedSmartphoneWithManufacture = new Product[1];
        expectedSmartphoneWithManufacture[0] = smartphone1;

        Product[] actualSmartphoneWithManufacture = productManager.searchBy("super");
        assertArrayEquals(expectedSmartphoneWithManufacture, actualSmartphoneWithManufacture);
    }

    @Test
    public void shouldFoundBookByNameIfExists() {
        createRepositoryMock();

        Product[] expectedBookWithAuthor = new Product[1];
        expectedBookWithAuthor[0] = book1;

        Product[] actualBookWithAuthor = productManager.searchBy("Mega");
        assertArrayEquals(expectedBookWithAuthor, actualBookWithAuthor);
    }

    private void createRepositoryMock() {
        Product[] products = new Product[4];
        products[0] = book;
        products[1] = book1;
        products[2] = smartphone;
        products[3] = smartphone1;

        doReturn(products).when(repository).findAll();
    }

    @Test
    public void shouldNotFoundProductIfNotExists() {
        createRepositoryMock();

        Product[] actualNotFound = productManager.searchBy("44");
        assertEquals(0, actualNotFound.length);
    }

}
