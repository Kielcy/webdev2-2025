package com.johnverz.webdev1_g1.repositories;

import com.johnverz.webdev1_g1.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {
}
