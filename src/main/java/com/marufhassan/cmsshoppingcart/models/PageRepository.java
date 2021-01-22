package com.marufhassan.cmsshoppingcart.models;

import com.marufhassan.cmsshoppingcart.models.data.Page;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PageRepository extends JpaRepository<Page, Integer> {
    
    Page findBySlug(String slug);
}
