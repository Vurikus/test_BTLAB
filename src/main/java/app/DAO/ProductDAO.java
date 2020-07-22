package app.DAO;

import app.domain.Product;

import java.util.List;

public interface ProductDAO {

    public void addProduct(Product product);
    public void removeProduct(Product product);
    public void updateProduct(Product product);
    public Product getProduct(int id);
    public List<Product> getAllProduct();
}
