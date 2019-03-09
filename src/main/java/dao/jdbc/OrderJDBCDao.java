package dao.jdbc;

import dao.OrderDao;
import domain.Order;
import domain.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderJDBCDao extends JDBCDao implements OrderDao {

    @Override
    public boolean createOrder(Order order) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement preparedStatement = connection.prepareStatement("insert into ORDERS(CLIENTID, PRODUCTS_IDS) values(?,?)")) {
            preparedStatement.setInt(1, order.getClientId());
            StringBuilder productsString = new StringBuilder();
            for (Product product : order.getProducts()) {
                productsString.append(product.getId());
                productsString.append(", ");
            }
            preparedStatement.setInt(1, order.getClientId());
            preparedStatement.setString(2, String.valueOf(productsString));

            return preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Order was not created.");
        }
        return false;
    }

    @Override
    public boolean editOrder(int orderId, List<Integer> productIdsList) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement preparedStatement = connection.prepareStatement("update ORDERS set PRODUCTS_IDS=? where id = ?")) {
            preparedStatement.setInt(1, orderId);
            String listString = productIdsList.toString();
            preparedStatement.setString(2, listString.substring(1, listString.length() - 1));
            return preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Order was not updated.");
        }
        return false;
    }

    @Override
    public boolean removeOrder(int orderId) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement preparedStatement = connection.prepareStatement("delete from ORDERS where id = ?")) {
            preparedStatement.setInt(1, orderId);
            return preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Order was not removed.");
        }
        return false;
    }

    @Override
    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USER, PASS);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from ORDERS");

            while (resultSet.next()) {
                List<Product> products = new ArrayList<>();
                int id = resultSet.getInt(1);
                int clientId = resultSet.getInt(2);
                for (String productName : resultSet.getString(3).split(",")) {
                    products.add(new Product(productName));
                }

                orders.add(new Order(id, clientId, products));
            }
            resultSet.close();
        } catch (SQLException e) {
            System.out.println("Can't get the orders from database.");
        }
        return orders;
    }
}
