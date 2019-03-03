package domain;

import java.util.List;
import java.util.Objects;

public class Order {
    private int id;
    private int clientId;
    private List<Product> products;

    public Order(int clientId, List<Product> products) {
        this.clientId = clientId;
        this.products = products;
    }

    public Order(int id, int clientId, List<Product> products) {
        this.id = id;
        this.clientId = clientId;
        this.products = products;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return clientId == order.clientId &&
                Objects.equals(products, order.products);
    }

    @Override
    public int hashCode() {

        return Objects.hash(clientId, products);
    }
}
