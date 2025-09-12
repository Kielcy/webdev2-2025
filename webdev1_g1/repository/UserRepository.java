package com.johnverz.webdev1_g1.repository;

import com.johnverz.webdev1_g1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
