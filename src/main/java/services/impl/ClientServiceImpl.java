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
    private ValidationService validationService;

    public ClientServiceImpl() {
        this.clientDao = ClientDaoImpl.getInstance();
        this.validationService = new ValidationServiceImpl();
    }

    @Override
    public void createClient(String name, String lastName, String phone) {
        this.createClient(name, lastName, phone, 0, null);
    }

    @Override
    public void createClient(String name, String lastName, String phone, int age, String email) {
        try {
            validateInput(phone, age, email);
            Client client = new Client(name, lastName, phone);
            boolean result = clientDao.createClient(client);
            if (result) {
                System.out.println(String.format("Client %s %s was created", client.getName(), client.getLastName()));
            }
        } catch (BusinessException e) {
            System.out.println("Please retry");
        }
    }

    @Override
    public void editClient(int id, String newName, String newLastName, String newPhone) {
        this.editClient(id, newName, newLastName, newPhone, 0, null);
    }

    @Override
    public void editClient(int id, String newName, String newLastName, String newPhone, int newAge, String newEmail) {
        try {
            validateInput(newPhone, newAge, newEmail);
        } catch (BusinessException e) {
            System.out.println("Please retry");
        }
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

    private void validateInput(String phone, int age, String email) throws BusinessException {
        validationService.validateAge(age);
        validationService.validatePhone(phone);
        validationService.validateEmail(email);
    }
}
