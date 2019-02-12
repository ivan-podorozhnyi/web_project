package services;

import dao.ClientDao;
import domain.Client;

public class ClientServiceImpl implements ClientService {

    private final ClientDao clientDao;

    public ClientServiceImpl(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    @Override
    public void createClient(String name, String lastName, String phone) {
        Client client = new Client(name, lastName, phone);
        boolean result = clientDao.saveClient(client);
        if (result) {
            System.out.println("Client saved");
        }
    }
}
