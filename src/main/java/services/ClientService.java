package services;

import domain.Client;

import java.util.List;

public interface ClientService {
    /**
     * Create Client instance.
     *
     * @param name     Client name.
     * @param lastName Client last name.
     * @param phone    Client phone.
     */
    void createClient(String name, String lastName, String phone);

    /**
     * Create Client instance.
     *
     * @param name     Client name.
     * @param lastName Client last name.
     * @param phone    Client phone.
     * @param age      Client age.
     * @param email    Client email.
     */
    void createClient(String name, String lastName, String phone, int age, String email);

    /**
     * Update Client.
     *
     * @param newName     new Client name.
     * @param newLastName new Client last name.
     * @param newPhone    new Client phone.
     */
    void editClient(int id, String newName, String newLastName, String newPhone);

    /**
     * Update Client.
     *
     * @param id          id of Client which will be modified.
     * @param newName     new Client name.
     * @param newLastName new Client last name.
     * @param newPhone    new Client phone.
     * @param newAge      new Client age.
     * @param newEmail    new Client email.
     */
    void editClient(int id, String newName, String newPhone, String newLastName, int newAge, String newEmail);

    /**
     * Remove Client.
     *
     * @param id id of Client instance to be removed.
     */
    void removeClient(int id);

    /**
     * Show list of all existing clients.
     */
    List<Client> getAllClients();
}
