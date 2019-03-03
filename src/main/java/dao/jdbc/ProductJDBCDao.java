package dao.jdbc;

import dao.ProductDao;
import domain.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductJDBCDao extends JDBCDao implements ProductDao {

    @Override
    public boolean createProduct(Product product) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement preparedStatement = connection.prepareStatement("insert into PRODUCTS(NAME, PRICE) values(?,?)")) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getPrice());

            return preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Product was not created.");
        }
        return false;
    }

    @Override
    public boolean editProduct(int productId, String newName, int newPrice) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement preparedStatement = connection.prepareStatement("update PRODUCTS set NAME = ?, PRICE = ?  where ID = ?")) {
            preparedStatement.setString(1, newName);
            preparedStatement.setInt(2, newPrice);
            preparedStatement.setInt(3, productId);

            return preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Product was not updated.");
        }
        return false;
    }


    @Override
    public boolean removeProduct(int productId) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement preparedStatement = connection.prepareStatement("delete from PRODUCTS where ID = ?")) {
            preparedStatement.setInt(1, productId);
            return preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Product was not removed.");
        }
        return false;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USER, PASS);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from PRODUCTS");

            while (resultSet.next()) {
                String name = resultSet.getString(1);
                int price = resultSet.getInt(3);

                products.add(new Product(name, price));
            }
            resultSet.close();
        } catch (SQLException e) {
            System.out.println("Can't get the products from database.");
        }
        return products;
    }

    @Override
    public Product getProduct(int productId) {
        Product product = null;
        try (Connection connection = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement preparedStatement = connection.prepareStatement("select * from PRODUCTS where ID = ?")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            String name = resultSet.getString(1);
            int price = resultSet.getInt(2);

            product = new Product(name, price);
            resultSet.close();
        } catch (SQLException e) {
            System.out.println("Can't get the product from database.");
        }
        return product;
    }
}
