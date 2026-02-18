package com.madhu.ecommerce.controller;

import com.madhu.ecommerce.entity.Product;
import com.madhu.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String index(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        model.addAttribute("categories", productService.getAllCategories());
        return "index";
    }

    @GetMapping("/products")
    public String listProducts(@RequestParam(required = false) Long categoryId, 
                             @RequestParam(required = false) String search, 
                             Model model) {
        List<Product> products;
        if (categoryId != null) {
            products = productService.getProductsByCategory(categoryId);
        } else if (search != null && !search.isEmpty()) {
            products = productService.searchProducts(search);
        } else {
            products = productService.getAllProducts();
        }
        model.addAttribute("products", products);
        model.addAttribute("categories", productService.getAllCategories());
        return "products";
    }

    @GetMapping("/product-details")
    public String productDetails(@RequestParam Long id, Model model) {
        Product product = productService.getProductById(id);
        if (product == null) return "redirect:/";
        model.addAttribute("product", product);
        return "product-details";
    }
}
