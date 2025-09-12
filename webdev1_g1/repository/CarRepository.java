
package com.johnverz.webdev1_g1.repository;

import com.johnverz.webdev1_g1.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {
}
