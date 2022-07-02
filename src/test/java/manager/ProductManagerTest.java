package manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.ProductRepository;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Product book = new Book(1, "Вино из одуванчиков", 3, "Рэй Брэдбери");
    Product book1 = new Book(2, "Психология", 450, "Фрейд");
    Product smartphone = new Smartphone(3, "One Plus 6", 30_000, "BBK Electronics");
    Product book3 = new Book(3, "Библия", 0, "Бог");

    @BeforeEach
    public void SetUp() {
        manager.add(book);
        manager.add(book1);
        manager.add(smartphone);
        manager.add(book3);
    }

    @Test
    public void shouldFindAuthor() {
        Product[] expected = {book};
        Product[] actual = manager.searchBy("рэй брэдбери");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindNameBook() {
        Product[] expected = {book1};
        Product[] actual = manager.searchBy("психология");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindPhoneName() {
        Product[] expected = {smartphone};
        Product[] actual = manager.searchBy("one plus 6");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindPhoneManufacturer() {
        Product[] expected = {smartphone};
        Product[] actual = manager.searchBy("BBK Electronics");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindAuthor() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("рей бредбери");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindNull() {
        Product[] expected = {};
        Product[] actual = manager.searchBy(null);
        assertArrayEquals(expected, actual);
    }

}
