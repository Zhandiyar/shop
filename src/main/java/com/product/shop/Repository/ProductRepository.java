package com.product.shop.Repository;

import com.product.shop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {


//    public List<Products> findAll();
//
//    List<Products> findAllById(int id);
//
//    List<Products> saveAllAndFlush(Products products);
//
//    void deleteAllByIdInBatch(int id);

}
