package com.johnverz.webdev1_g1;

import com.johnverz.webdev1_g1.model.User;
import com.johnverz.webdev1_g1.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            // Check if default user exists
            if (userRepository.findByUsername("admin").isEmpty()) {
                // Create default admin user
                User admin = new User();
                admin.setUsername("admin");
                admin.setPassword(passwordEncoder.encode("admin123"));
                userRepository.save(admin);
                System.out.println("Default admin user created - Username: admin, Password: admin123");
            }

            // You can add more default users if needed
            if (userRepository.findByUsername("user").isEmpty()) {
                User user = new User();
                user.setUsername("user");
                user.setPassword(passwordEncoder.encode("user123"));
                userRepository.save(user);
                System.out.println("Default user created - Username: user, Password: user123");
            }
        };
    }
}