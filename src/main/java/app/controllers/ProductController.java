package app.controllers;

import app.domain.Product;
import app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ProductController {
    //Field
    @Autowired
    private ProductService productService;

    //Function
    @GetMapping
    public String getStartPage(Model model){
        List<Product> allProduct = productService.getAllProduct();
        model.addAttribute("allProduct", allProduct);
        return "index";
    }

    @RequestMapping(value = "products", method = RequestMethod.GET)
    public String listBooks(Model model){
        model.addAttribute("product", new Product());
        model.addAttribute("listProducts", productService.getAllProduct());
        return "books";
    }

    @RequestMapping(value = "/product/add", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("product") Product product){
        if(product.getId() == 0){
            productService.addProduct(product);
        }else {
            productService.updateProduct(product);
        }
        return "redirect:/products";
    }

}
