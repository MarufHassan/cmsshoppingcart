package com.marufhassan.cmsshoppingcart.models;

import org.springframework.data.jpa.repository.JpaRepository;
import com.marufhassan.cmsshoppingcart.models.data.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
