package app.controllers;

import app.domain.Product;
import app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {
    //Field
    @Autowired
    private ProductService productService;

//    Function
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("products", productService.getAllProduct());
        return "products";
    }

    @GetMapping("/products/add")
    public String createProduct(Model model) {
        model.addAttribute("product", new Product());
        return "edit";
    }

    @PostMapping("/products")
    public String saveProduct(Product product) {
        productService.addProduct(product);
        return "redirect:/";
    }

    @GetMapping("/products/edit/{id}")
    public String editProduct(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("product", productService.getProduct(id));
        return "edit";
    }

    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") int id) {
        productService.removeProduct(id);
        return "redirect:/products";
    }
}
