package com.product.mongowebdemo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.product.mongowebdemo.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
}
