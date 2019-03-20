package domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "ORDERS")
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id &&
                clientId == order.clientId &&
                Objects.equals(products, order.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clientId, products);
    }
}
