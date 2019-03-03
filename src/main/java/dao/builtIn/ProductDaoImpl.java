package dao.builtIn;

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
    public boolean editProduct(int productId, String newProductName, int newPrice) {
        for (Product product : productsList) {
            if (product.getId() == productId){
                product.setName(newProductName);
                product.setPrice(newPrice);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeProduct(int productId) {
        for (Product product : productsList) {
            if (product.getId() == productId){
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

    @Override
    public Product getProduct(int productId) {
        Product product;
        for (Product iter : productsList) {
            if (iter.getId() == productId){
                product = new Product(iter.getId(), iter.getName(), iter.getPrice());
                return product;
            }
        }
        System.out.println("Product with current id does not exist!");
        return null;
    }
}
