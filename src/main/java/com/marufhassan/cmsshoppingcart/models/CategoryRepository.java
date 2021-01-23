package com.marufhassan.cmsshoppingcart.models;

import com.marufhassan.cmsshoppingcart.models.data.Category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findByName(String name);
}
