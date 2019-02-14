package services;

import domain.Client;
import domain.Order;
import domain.Product;

public interface AdminService {
    /**
     * Create Client instance.
     *
     * @param name      Client name.
     * @param lastName  Client last name.
     * @param phone     Client phone.
     */
    void createClient(String name, String lastName, String phone);

    /**
     * Create Client instance.
     *
     * @param name      Client name.
     * @param lastName  Client last name.
     * @param phone     Client phone.
     * @param age       Client age.
     * @param email     Client email.
     */
    void createClient(String name, String lastName, String phone, int age, String email);

    /**
     * Update Client.
     *
     * @param newName      new Client name.
     * @param newLastName  new Client last name.
     * @param newPhone     new Client phone.
     */
    void editClient(Client client, String newName, String newLastName, String newPhone);

    /**
     * Update Client.
     *
     * @param newName      new Client name.
     * @param newLastName  new Client last name.
     * @param newPhone     new Client phone.
     * @param newAge       new Client age.
     * @param newEmail     new Client email.
     */
    void editClient(Client client, String newName, String newPhone, String newLastName, int newAge, String newEmail);

    /**
     * Remove Client.
     *
     * @param client    Client instance to be removed.
     */
    void removeClient(Client client);

    /**
     * Create Order instance.
     */
    void addOrder();

    /**
     * Remove Order.
     *
     * @param order    Order instance to be removed.
     */
    void removeOrder(Order order);

    /**
     * Create Product instance.
     */
    void addProduct();

    /**
     * Remove Product.
     *
     * @param product    Product instance to be removed.
     */
    void removeProduct(Product product);
}
