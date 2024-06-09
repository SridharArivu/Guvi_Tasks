package com.example.day19.controllers;
import com.example.day19.entity.Product;
import com.example.day19.services.Impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product savedProduct = productService.addProduct(product);
        return ResponseEntity.ok(savedProduct);
    }

    @GetMapping
    public ResponseEntity<List<Product>> viewProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    // Thymeleaf endpoint to render HTML view of products
    @GetMapping("/view")
    public String viewProductsPage(Model model) {
        List<Product> products = productService.getAllProducts();
        if(!products.isEmpty()){
            model.addAttribute("products", products);
            return "products";
        }
        return "tableEmpty";
    }
    // Thymeleaf endpoint to render HTML form for adding a product
    @GetMapping("/add")
    public String addProductPage(Model model) {
        model.addAttribute("product", new Product());
        return "add-product";
    }
    @PostMapping("/add")
    public String addProductForm(Product product) {
        productService.addProduct(product);
        return "redirect:/products/view";
    }
}
