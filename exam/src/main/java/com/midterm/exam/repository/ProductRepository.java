package com.midterm.exam.repository;

import com.midterm.exam.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {}

