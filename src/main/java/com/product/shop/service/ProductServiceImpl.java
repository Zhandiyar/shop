package com.product.shop.service;

import com.product.shop.Repository.ProductRepository;
import com.product.shop.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;

    @Override
    public Optional<Product> getById(Long id) {
        log.info("IN ProductServiceImpl getById {}",id);
        return productRepository.findById(id);
    }

    @Override
    public Product save(Product product) {
        log.info("IN ProductServiceImpl save {}",product);
        return productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        log.info("IN ProductServiceImpl delete {}",id);
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> getAll() {
        log.info("IN ProductServiceImpl getAll{}");
        return productRepository.findAll();
    }
}
