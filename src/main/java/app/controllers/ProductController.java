package app.controllers;

import app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
    //Field
    @Autowired
    private ProductService productService;

    //Function
    @GetMapping
    public String getStartPage(){
        return "index";
    }

}
