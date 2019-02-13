package dao;

import domain.Client;

public class ClientDaoImpl implements ClientDao {

    @Override
    public boolean saveClient(Client client) {
        System.out.println("Client saved.");
        return true;
    }
}
