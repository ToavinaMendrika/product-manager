package com.esti.productmanager.repositories;

import com.esti.productmanager.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findAllByUsername(String username);
}
