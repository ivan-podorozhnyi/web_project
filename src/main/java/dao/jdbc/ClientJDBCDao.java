package dao.jdbc;

import dao.ClientDao;
import domain.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ClientJDBCDao extends JDBCDao implements ClientDao {

    @Override
    public boolean createClient(Client client) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement preparedStatement = connection.prepareStatement("insert into clients(NAME, LASTNAME, AGE, PHONE, EMAIL) values(?,?,?,?,?)")) {
            preparedStatement.setString(1, client.getName());
            preparedStatement.setString(2, client.getLastName());
            preparedStatement.setInt(3, client.getAge());
            preparedStatement.setString(4, client.getPhone());
            preparedStatement.setString(5, client.getEmail());

            return preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Client was not created.");
        }
        return false;
    }

    @Override
    public boolean editClient(int id, String newName, String newPhone, String newLastName, int newAge, String newEmail) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement preparedStatement = connection.prepareStatement("update clients set NAME = ?, LASTNAME=?, AGE=?, PHONE=?, EMAIL=? where id = ?")) {
            preparedStatement.setString(1, newName);
            preparedStatement.setString(2, newLastName);
            preparedStatement.setInt(3, newAge);
            preparedStatement.setString(4, newPhone);
            preparedStatement.setString(5, newEmail);
            preparedStatement.setInt(6, id);

            return preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Client was not updated.");
        }
        return false;
    }


    @Override
    public boolean removeClient(int id) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement preparedStatement = connection.prepareStatement("delete from clients where id = ?")) {
            preparedStatement.setInt(1, id);
            return preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Client was not removed.");
        }
        return false;
    }

    @Override
    public List<Client> getAllClients() {
        List<Client> clients = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USER, PASS);
             ResultSet resultSet = connection.createStatement().executeQuery("select * from CLIENTS")) {
            while (resultSet.next()) {
                String name = resultSet.getString(1);
                String lastName = resultSet.getString(2);
                int age = resultSet.getInt(3);
                String phone = resultSet.getString(4);
                String email = resultSet.getString(5);

                clients.add(new Client(name, lastName, age, phone, email));
            }
        } catch (SQLException e) {
            System.out.println("Can't get the clients from database.");
        }
        return clients;
    }

    @Override
    public Client getClientById(int id) {
        Client client = null;
        try (Connection connection = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement preparedStatement = connection.prepareStatement("select * from CLIENTS where id = ?")) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            String name = resultSet.getString(1);
            String lastName = resultSet.getString(2);
            int age = resultSet.getInt(3);
            String phone = resultSet.getString(4);
            String email = resultSet.getString(5);

            client = new Client(name, lastName, age, phone, email);
            resultSet.close();
        } catch (SQLException e) {
            System.out.println("Can't get the client from database.");
        }
        return client;
    }
}
