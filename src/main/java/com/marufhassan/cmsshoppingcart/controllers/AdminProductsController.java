package com.marufhassan.cmsshoppingcart.controllers;

import java.util.List;

import com.marufhassan.cmsshoppingcart.models.ProductRepository;
import com.marufhassan.cmsshoppingcart.models.data.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/products")
public class AdminProductsController {
    @Autowired
    private ProductRepository productRepo;

    @GetMapping
    public String index(Model model) {
        List<Product> products = productRepo.findAll();
        model.addAttribute("products", products);
        return "admin/products/index";
    }
}
