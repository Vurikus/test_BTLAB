package app;

import app.DAO.ImplProductDAO;
import app.domain.Product;

import java.util.List;

public class Main {
    //Field

    //Constructor

    //Function
    public static void main(String[] args) {
        ImplProductDAO implProductDAO = new ImplProductDAO();
        List<Product> allProduct = implProductDAO.getAllProduct();
        System.out.println(allProduct.get(0).toString());
    }

    //Getter and Setter
}
