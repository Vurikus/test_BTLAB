package app.service;

import app.DAO.ProductDAO;
import app.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    //Field
    @Autowired
    private ProductDAO productDAO;

    //Constructor

    //Function
    public void addProduct(Product product){
        productDAO.addProduct(product);
    }
    public void removeProduct(int id){
        productDAO.removeProduct(id);
    }
    public void updateProduct(Product product){
        productDAO.updateProduct(product);
    }
    public Product getProduct(int id){
        return productDAO.getProduct(id);
    }
    public List<Product> getAllProduct(){
        return productDAO.getAllProduct();
    }

    //Getter and Setter
}
