package com.example.mvcproducts.controllers;

import com.example.mvcproducts.domain.Cart;
import com.example.mvcproducts.domain.Product;
import com.example.mvcproducts.domain.User;
import com.example.mvcproducts.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("cart")
@RequestMapping("/cart")
public class CartController {
    private final ProductService productService;

    public CartController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/add")
    public String addToCart(@RequestParam Long pid, @ModelAttribute("cart") Cart cart) {
        cart.getProducts().add(productService.findById(pid).get());
        System.out.println(cart.getProducts());
        return "redirect:/products";
    }

    @GetMapping
    public String seeCart() {
        return "cart";
    }

    @ModelAttribute("cart")
    public Cart cart() {
        return new Cart();
    }
}