package com.techie.microservices.product.service;

import com.techie.microservices.product.dto.ProductRequest;
import com.techie.microservices.product.dto.ProductResponse;
import com.techie.microservices.product.model.Product;
import com.techie.microservices.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;
    public ProductResponse createProduct(ProductRequest productRequest)
    {
        Product product=Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .build();
        productRepository.save(product);
        log.info("product created successfully");
        return new ProductResponse(product.getId(),product.getName(),product.getDescription(),product.getPrice());
    }

    public List<ProductResponse> getALlProducts() {
        return productRepository.findAll()
                .stream()
                .map(product -> new ProductResponse(product.getId(),product.getName(),product.getDescription(),product.getPrice()))
                .toList();
    }
}
