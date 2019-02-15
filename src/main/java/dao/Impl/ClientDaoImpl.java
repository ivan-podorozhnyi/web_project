package dao.Impl;

import dao.ClientDao;
import domain.Client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ClientDaoImpl implements ClientDao {

    private Map<Integer, Client> clients = new HashMap<>();
    private static int clientCounter = 0;
    private static ClientDao clientDao;

    private ClientDaoImpl() {
    }

    @Override
    public boolean createClient(Client client) {
        client.setId(clientCounter++);
        clients.put(client.getId(), client);
        return true;
    }

    @Override
    public boolean editClient(int id, String newName, String newPhone, String newLastName, int newAge, String newEmail) {
        Client editable = clients.get(id);
        if (editable != null) {
            editable.setName(newName);
            editable.setLastName(newLastName);
            editable.setPhone(newPhone);
            editable.setAge(newAge);
            editable.setEmail(newEmail);
            editable.setName(newName);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeClient(int id) {
        Client removable = clients.get(id);
        if (removable != null) {
            clients.remove(removable.getId());
            return true;
        }
        return false;
    }

    @Override
    public List<Client> getAllClients() {
        return new ArrayList<>(clients.values());
    }

    public static ClientDao getInstance() {
        if (clientDao == null) {
            clientDao = new ClientDaoImpl();
        }
        return clientDao;
    }
}
