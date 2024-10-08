package org.fnxexample.catalogue.service;

import lombok.RequiredArgsConstructor;
import org.fnxexample.catalogue.entity.Product;
import org.fnxexample.catalogue.repository.ProductRepository;
import org.springframework.stereotype.Service;


import java.util.NoSuchElementException;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class DefaultProductService implements ProductService {
    private final ProductRepository productRepository;
    @Override
    public Iterable<Product> findAllProducts() {
        return this.productRepository.findAll();
    }
    @Override
    public Product createProduct(String title, String details) {
        return this.productRepository.save(new Product(null, title, details));
    }
    @Override
    public Optional<Product> findProduct(int productId) {
        return this.productRepository.findById(productId);
    }
    @Override
    public void updateProduct(Integer id, String title, String details) {
        this.productRepository.findById(id)
                .ifPresentOrElse(product -> {
                    product.setTitle(title);
                    product.setDetails(details);
                }, () -> {
                    throw new NoSuchElementException();
                });
    }
    @Override
    public void deleteProduct(Integer id) {
        this.productRepository.deleteById(id);
    }
}