package edu.miu.service;

import edu.miu.aop.ExecutionTime;
import edu.miu.domain.Product;
import edu.miu.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    @ExecutionTime(startTime = 0L)
    public Product addProduct(Product product) {
        productRepository.save(product);
        return product;
    }
}
