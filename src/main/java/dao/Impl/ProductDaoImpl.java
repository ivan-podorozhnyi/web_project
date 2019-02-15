package dao.Impl;

import dao.ProductDao;
import domain.Product;

import java.util.ArrayList;
import java.util.List;


public class ProductDaoImpl implements ProductDao {
    private List<Product> productsList = new ArrayList<>();
    private static ProductDao productDao;

    private ProductDaoImpl() {
        if (productDao != null) {
            productDao = new ProductDaoImpl();
        }
    }

    public static ProductDao getInstance() {
        if (productDao == null) {
            productDao = new ProductDaoImpl();
        }
        return productDao;
    }

    @Override
    public boolean createProduct(Product product) {
        productsList.add(product);
        return true;
    }

    @Override
    public boolean editProduct(String productName, int newPrice) {
        for (Product product : productsList) {
            if (product.getName().trim().contains(productName)){
                product.setPrice(newPrice);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeProduct(String productName) {
        for (Product product : productsList) {
            if (product.getName().trim().contains(productName)){
                productsList.remove(product);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Product> getAllProducts() {
        return productsList;
    }
}
