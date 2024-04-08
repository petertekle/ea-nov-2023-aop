package edu.miu.controller;

import edu.miu.domain.Product;
import edu.miu.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/products")
    public Product addProduct(Product product) {
        return productService.addProduct(product);
    }
}
