package dao;

import domain.Client;

import java.util.List;

public interface ClientDao {
    boolean createClient(Client client);

    boolean editClient(int id, String newName, String newPhone, String newLastName, int newAge, String newEmail);

    boolean removeClient(int id);

    List<Client> getAllClients();

}
