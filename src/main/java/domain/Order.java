package domain;

import java.util.List;

public class Order {
    private long id;
    private Client client;
    private List<Product> products;

    public Order(long id, Client client, List<Product> products) {

        this.id = id;
        this.client = client;
        this.products = products;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != order.id) return false;
        if (!client.equals(order.client)) return false;
        return products.equals(order.products);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + client.hashCode();
        result = 31 * result + products.hashCode();
        return result;
    }
}
