package dao.jdbc;

import dao.ClientDao;
import domain.Client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ClientEMDao implements ClientDao {
    private EntityManager entityManager;

    public ClientEMDao() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence-unit");
        this.entityManager = factory.createEntityManager();
    }

    @Override
    public boolean createClient(Client client) {
        entityManager.getTransaction().begin();
        entityManager.persist(client);
        entityManager.getTransaction().commit();
        entityManager.close();
        return true;
    }

    @Override
    public boolean editClient(int id, String newName, String newPhone, String newLastName, int newAge, String newEmail) {
        return false;
    }

    @Override
    public boolean removeClient(int id) {
        return false;
    }

    @Override
    public List<Client> getAllClients() {
        entityManager.getTransaction().begin();
        List<Client> resultList = entityManager.createQuery("from Client", Client.class).getResultList();
        entityManager.getTransaction().commit();
        return resultList;
    }

    @Override
    public Client getClientById(int id) {
        return null;
    }


}
