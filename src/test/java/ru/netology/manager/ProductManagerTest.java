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
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class ProductManagerTest {

    @Mock
    private ProductRepository repository;

    @InjectMocks
    private ProductManager productManager;

    @Test
    public void productManager_search()
    {
        Product[] products = new Product[3];
        Book book = new Book();
        book.setId(5);
        book.setName("Book");

        Smartphone smartphone = new Smartphone();
        smartphone.setId(10);
        smartphone.setName("Smartphone");
        smartphone.setManufacture("htc");

        Book book1 =  new Book();
        book1.setId(6);
        book1.setAuthor("Book author");

        products[0] = book;
        products[1] = book1;
        products[2] = smartphone;

        doReturn(products).when(repository).findAll();

        Product[] expected = new Product[2];
        expected[0] = book;
        expected[1] = book1;

        Product[] actual = productManager.searchBy("Book");

        assertArrayEquals(expected, actual);
    }

}
