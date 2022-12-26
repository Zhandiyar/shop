package com.product.shop.service;

import com.product.shop.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Optional<Product> getById(Long id);

    Product save(Product product);

    void delete(Long id);

    List<Product> getAll();
}
