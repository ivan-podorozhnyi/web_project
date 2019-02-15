package services.impl;

import dao.ClientDao;
import dao.Impl.ClientDaoImpl;
import dao.Impl.ProductDaoImpl;
import dao.OrderDao;
import dao.Impl.OrderDaoImpl;
import dao.ProductDao;
import domain.Client;
import domain.Order;
import domain.Product;
import exceptions.BusinessException;
import services.ClientService;
import validators.Impl.ValidationServiceImpl;
import validators.ValidationService;

import java.util.List;

public class ClientServiceImpl implements ClientService {
    private ClientDao clientDao;


    public ClientServiceImpl() {
        this.clientDao = ClientDaoImpl.getInstance();
    }

    public ClientServiceImpl(ClientDao clientDao) {
        this.clientDao = clientDao;
        this.validationService = new ValidationServiceImpl();
    }

    @Override
    public void createClient(String name, String lastName, String phone) {
        this.createClient(name, lastName, phone, 0, null);
    }

    @Override
    public void createClient(String name, String lastName, String phone, int age, String email) {

        Client client = new Client(name, lastName, phone);
        boolean result = clientDao.createClient(client);
        if (result) {
            System.out.println(String.format("Client %s %s was created", client.getName(), client.getLastName()));
        }
    }

    @Override
    public void editClient(int id, String newName, String newLastName, String newPhone) {
        this.editClient(id, newName, newLastName, newPhone, 0, null);
    }

    @Override
    public void editClient(int id, String newName, String newLastName, String newPhone, int newAge, String newEmail) {
        boolean result = clientDao.editClient(id, newName, newLastName, newPhone, newAge, newEmail);
        if (result) {
            System.out.println("Client %s was created");
        }
    }

    @Override
    public void removeClient(int id) {
        boolean result = clientDao.removeClient(id);
        if (result) {
            System.out.println("Client was removed");
        }
    }

    @Override
    public List<Client> getAllClients() {
        return clientDao.getAllClients();
    }

    @Override
    public Client getClientById(int id) {
        return clientDao.getClientById(id);
    }
}
