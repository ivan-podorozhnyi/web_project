package services.impl;

import dao.Impl.ProductDaoImpl;
import dao.ProductDao;
import domain.Product;
import services.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductDao productDao;

    public ProductServiceImpl() {
        this.productDao = ProductDaoImpl.getInstance();
    }

    @Override
    public void createProduct(String name, int price) {
        Product product = new Product(name, price);
        boolean result = productDao.createProduct(product);
        if (result) {
            System.out.println(String.format("Product %s was created", product.getName()));
        }
    }

    @Override
    public void editProduct(String name, int newPrice) {
        boolean result = productDao.editProduct(name, newPrice);
        if (result) {
            System.out.println("Product was edited");
        }
    }

    @Override
    public void removeProduct(String productName) {
        boolean result = productDao.removeProduct(productName);
        if (result) {
            System.out.println("Product was removed");
        }
    }

    @Override
    public List<Product> getAllProducts() {
        return productDao.getAllProducts();
    }
}
