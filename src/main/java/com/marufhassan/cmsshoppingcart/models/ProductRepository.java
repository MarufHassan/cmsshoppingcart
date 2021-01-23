package com.marufhassan.cmsshoppingcart.models;

import com.marufhassan.cmsshoppingcart.models.data.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}