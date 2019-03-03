package services.impl;

import dao.builtIn.ProductDaoImpl;
import dao.ProductDao;
import domain.Product;
import services.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductDao productDao;

    public ProductServiceImpl() {
        this.productDao = ProductDaoImpl.getInstance();
    }

    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
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
    public void editProduct(int productId, String newName, int newPrice) {
        boolean result = productDao.editProduct(productId, newName, newPrice);
        if (result) {
            System.out.println("Product was edited");
        }
    }

    @Override
    public void removeProduct(int productId) {
        boolean result = productDao.removeProduct(productId);
        if (result) {
            System.out.println("Product was removed");
        }
    }

    @Override
    public List<Product> getAllProducts() {
        return productDao.getAllProducts();
    }
}
