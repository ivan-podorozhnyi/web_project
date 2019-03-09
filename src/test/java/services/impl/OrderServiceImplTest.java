package services.impl;

import dao.OrderDao;
import dao.ProductDao;
import domain.Order;
import domain.Product;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import services.OrderService;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

public class OrderServiceImplTest {

    private OrderService orderService;
    private OrderDao orderDao = Mockito.mock(OrderDao.class);
    private ProductDao productDao = Mockito.mock(ProductDao.class);

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUp() {
        orderService = new OrderServiceImpl(orderDao, productDao);
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void tearDown() {
        orderService = null;
        System.setOut(originalOut);
    }

    @Test
    public void testCreateOrder() {
        //GIVEN
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1, "apple", 10));
        productList.add(new Product(2, "tomato", 5));
        productList.add(new Product(3, "potato", 4));

        when(productDao.getProduct(1)).thenReturn(productList.get(0));
        when(productDao.getProduct(2)).thenReturn(productList.get(1));
        when(productDao.getProduct(3)).thenReturn(productList.get(2));

        List<Integer> productIds = new ArrayList<>();
        productIds.add(1);
        productIds.add(2);
        productIds.add(3);

        int clientId = 5;
        Order order = new Order(clientId, productList);
        when(orderDao.createOrder(order)).thenReturn(true);

        String expectedOutput = "Order was created";

        //WHEN
        orderService.createOrder(clientId, productIds);

        //THEN
        Mockito.verify(orderDao).createOrder(order);
        Mockito.verifyNoMoreInteractions(orderDao);
        Mockito.verify(productDao).getProduct(1);
        Mockito.verify(productDao).getProduct(2);
        Mockito.verify(productDao).getProduct(3);
        assertThat(outContent.toString(), containsString(expectedOutput));
    }

    @Test
    public void testEditOrder() {
        //GIVEN
        List<Integer> productIds = new ArrayList<>();
        productIds.add(1);
        productIds.add(2);
        productIds.add(3);

        int clientId = 5;

        when(orderDao.editOrder(clientId, productIds)).thenReturn(true);

        String expectedOutput = "Order was edited";

        //WHEN
        orderService.editOrder(clientId, productIds);

        //THEN
        Mockito.verify(orderDao).editOrder(clientId, productIds);
        Mockito.verifyNoMoreInteractions(orderDao);
        assertThat(outContent.toString(), containsString(expectedOutput));
    }

    @Test
    public void testRemoveOrder() {
        //GIVEN
        int orderId = 2;

        when(orderDao.removeOrder(orderId)).thenReturn(true);

        String expectedOutput = "Order was removed";

        //WHEN
        orderService.removeOrder(orderId);

        //THEN
        Mockito.verify(orderDao).removeOrder(orderId);
        Mockito.verifyNoMoreInteractions(orderDao);
        assertThat(outContent.toString(), containsString(expectedOutput));
    }

    @Test
    public void testShowAllOrders() {
        //GIVEN
        List<Product> productList1 = new ArrayList<>();
        productList1.add(new Product(1, "apple", 10));
        productList1.add(new Product(2, "tomato", 5));
        productList1.add(new Product(3, "potato", 4));

        List<Product> productList2 = new ArrayList<>();
        productList2.add(new Product(1, "apple", 10));
        productList2.add(new Product(2, "tomato", 5));
        productList2.add(new Product(3, "potato", 4));

        int clientId = 5;
        List<Order> orderList = new ArrayList<>();
        orderList.add(new Order(clientId, productList1));
        orderList.add(new Order(clientId, productList2));

        when(orderDao.getAllOrders()).thenReturn(orderList);

        //WHEN
        List<Order> resultOrderList = orderService.showAllOrders();

        //THEN
        Mockito.verify(orderDao).getAllOrders();
        Mockito.verifyNoMoreInteractions(orderDao);
        Assert.assertEquals(orderList, resultOrderList);
    }

    @Test
    public void testNegativeCreateOrder() {
        //GIVEN
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(4, "apple", 10));
        productList.add(new Product(5, "tomato", 5));
        productList.add(new Product(6, "potato", 4));

        List<Integer> productIds = new ArrayList<>();
        productIds.add(4);
        productIds.add(5);
        productIds.add(6);

        int clientId = 1;
        Order order = new Order(clientId, productList);

        when(orderDao.createOrder(order)).thenReturn(false);

        String expectedOutput = "Could not create order with client id 1";

        //WHEN
        orderService.createOrder(clientId, productIds);

        //THEN
        Mockito.verify(orderDao).createOrder(Mockito.any(Order.class));
        Mockito.verifyNoMoreInteractions(orderDao);
        assertThat(outContent.toString(), containsString(expectedOutput));
    }

    @Test
    public void testNegativeEditOrder() {
        //GIVEN
        List<Integer> productIds = new ArrayList<>();
        productIds.add(4);
        productIds.add(5);
        productIds.add(6);

        int orderId = 1;

        when(orderDao.editOrder(orderId, productIds)).thenReturn(false);

        String expectedOutput = "Could not update order with id 1";

        //WHEN
        orderService.editOrder(orderId, productIds);

        //THEN
        Mockito.verify(orderDao).editOrder(orderId, productIds);
        Mockito.verifyNoMoreInteractions(orderDao);
        assertThat(outContent.toString(), containsString(expectedOutput));
    }

    @Test
    public void testNegativeRemoveOrder() {
        //GIVEN
        int orderId = 5;

        when(orderDao.removeOrder(orderId)).thenReturn(false);

        String expectedOutput = "Could not remove order with id 5";

        //WHEN
        orderService.removeOrder(orderId);

        //THEN
        Mockito.verify(orderDao).removeOrder(orderId);
        Mockito.verifyNoMoreInteractions(orderDao);
        assertThat(outContent.toString(), containsString(expectedOutput));
    }
}