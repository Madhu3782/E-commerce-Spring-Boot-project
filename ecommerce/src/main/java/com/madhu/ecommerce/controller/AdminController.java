package com.madhu.ecommerce.controller;

import com.madhu.ecommerce.entity.Product;
import com.madhu.ecommerce.entity.User;
import com.madhu.ecommerce.service.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ProductService productService;

    private static String UPLOAD_DIR = "src/main/resources/static/images/";

    @GetMapping
    public String adminHome(HttpSession session, Model model) {
        if (!isAdmin(session)) return "redirect:/login";
        model.addAttribute("products", productService.getAllProducts());
        return "admin/index";
    }

    @GetMapping("/product/add")
    public String addProductForm(HttpSession session, Model model) {
        if (!isAdmin(session)) return "redirect:/login";
        model.addAttribute("product", new Product());
        model.addAttribute("categories", productService.getAllCategories());
        return "admin/add-product";
    }

    @PostMapping("/product/add")
    public String addProduct(@ModelAttribute Product product, @RequestParam("imageFile") MultipartFile imageFile, HttpSession session) throws IOException {
        if (!isAdmin(session)) return "redirect:/login";

        if (!imageFile.isEmpty()) {
            String fileName = System.currentTimeMillis() + "_" + imageFile.getOriginalFilename();
            Path path = Paths.get(UPLOAD_DIR + fileName);
            Files.createDirectories(path.getParent());
            Files.write(path, imageFile.getBytes());
            product.setImagePath("/images/" + fileName);
        }
        productService.saveProduct(product);
        return "redirect:/admin";
    }

    @GetMapping("/product/edit/{id}")
    public String editProductForm(@PathVariable Long id, HttpSession session, Model model) {
        if (!isAdmin(session)) return "redirect:/login";
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        model.addAttribute("categories", productService.getAllCategories());
        return "admin/edit-product";
    }

    @PostMapping("/product/edit")
    public String editProduct(@ModelAttribute Product product, @RequestParam("imageFile") MultipartFile imageFile, HttpSession session) throws IOException {
        if (!isAdmin(session)) return "redirect:/login";
        
        if (!imageFile.isEmpty()) {
            String fileName = System.currentTimeMillis() + "_" + imageFile.getOriginalFilename();
            Path path = Paths.get(UPLOAD_DIR + fileName);
            Files.createDirectories(path.getParent());
            Files.write(path, imageFile.getBytes());
            product.setImagePath("/images/" + fileName);
        }
        productService.saveProduct(product);
        return "redirect:/admin";
    }

    @GetMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id, HttpSession session) {
        if (!isAdmin(session)) return "redirect:/login";
        productService.deleteProduct(id);
        return "redirect:/admin";
    }

    private boolean isAdmin(HttpSession session) {
        User user = (User) session.getAttribute("user");
        return user != null && "ADMIN".equals(user.getRole());
    }
}
