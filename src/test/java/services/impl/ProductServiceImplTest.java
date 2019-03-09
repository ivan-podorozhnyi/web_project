package services.impl;

import dao.ProductDao;
import domain.Product;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import services.ProductService;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

public class ProductServiceImplTest {

    private ProductService productService;
    private ProductDao productDao = Mockito.mock(ProductDao.class);

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUp() {
        productService = new ProductServiceImpl(productDao);
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void tearDown() {
        productService = null;
        System.setOut(originalOut);
    }

    @Test
    public void createProduct() {
        //GIVEN
        String productName = "Apple";
        int productPrice = 10;
        Product product = new Product(productName, productPrice);

        when(productDao.createProduct(product)).thenReturn(true);

        String expectedOutput = "Product Apple was created";

        //WHEN
        productService.createProduct(productName, productPrice);

        //THEN
        Mockito.verify(productDao).createProduct(product);
        Mockito.verifyNoMoreInteractions(productDao);
        assertThat(outContent.toString(), containsString(expectedOutput));
    }

    @Test
    public void editProduct() {
        //GIVEN
        int productId = 1;
        String productName = "Big Apple";
        int productPrice = 100;

        when(productDao.editProduct(productId, productName, productPrice)).thenReturn(true);

        String expectedOutput = "Product was edited";

        //WHEN
        productService.editProduct(productId, productName, productPrice);

        //THEN
        Mockito.verify(productDao).editProduct(productId, productName, productPrice);
        Mockito.verifyNoMoreInteractions(productDao);
        assertThat(outContent.toString(), containsString(expectedOutput));
    }

    @Test
    public void removeProduct() {
        //GIVEN
        int productId = 6;

        when(productDao.removeProduct(productId)).thenReturn(true);

        String expectedOutput = "Product was removed";

        //WHEN
        productService.removeProduct(productId);

        //THEN
        Mockito.verify(productDao).removeProduct(productId);
        Mockito.verifyNoMoreInteractions(productDao);
        assertThat(outContent.toString(), containsString(expectedOutput));
    }

    @Test
    public void getAllProducts() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1, "apple", 10));
        productList.add(new Product(2, "tomato", 5));
        productList.add(new Product(3, "potato", 4));

        when(productDao.getAllProducts()).thenReturn(productList);

        //WHEN
        List<Product> resultProductList = productService.getAllProducts();

        //THEN
        Mockito.verify(productDao).getAllProducts();
        Mockito.verifyNoMoreInteractions(productDao);
        Assert.assertEquals(productList, resultProductList);
    }

    @Test
    public void testNegativeCreateOrder() {
        //GIVEN
        String productName = "Big Apple";
        int productPrice = 100;
        Product product = new Product(productName,productPrice);

        when(productDao.createProduct(product)).thenReturn(false);

        String expectedOutput = "Could not create product with name Big Apple";

        //WHEN
        productService.createProduct(productName,productPrice);

        //THEN
        Mockito.verify(productDao).createProduct(product);
        Mockito.verifyNoMoreInteractions(productDao);
        assertThat(outContent.toString(), containsString(expectedOutput));
    }

    @Test
    public void testNegativeEditOrder() {
        //GIVEN
        int productId = 1;
        String productName = "Big Apple";
        int productPrice = 100;

        when(productDao.editProduct(productId, productName, productPrice)).thenReturn(false);

        String expectedOutput = "Could not update product with id 1";

        //WHEN
        productService.editProduct(productId,productName,productPrice);

        //THEN
        Mockito.verify(productDao).editProduct(productId,productName,productPrice);
        Mockito.verifyNoMoreInteractions(productDao);
        assertThat(outContent.toString(), containsString(expectedOutput));
    }
    @Test
    public void testNegativeRemoveProduct() {
        //GIVEN
        int productId = 2;
        String productName = "Apple";
        int productPrice = 10;

        when(productDao.removeProduct(productId)).thenReturn(false);

        String expectedOutput = "Could not remove product with id 2";

        //WHEN
        productService.removeProduct(productId);

        //THEN
        Mockito.verify(productDao).removeProduct(productId);
        Mockito.verifyNoMoreInteractions(productDao);
        assertThat(outContent.toString(), containsString(expectedOutput));
    }
}