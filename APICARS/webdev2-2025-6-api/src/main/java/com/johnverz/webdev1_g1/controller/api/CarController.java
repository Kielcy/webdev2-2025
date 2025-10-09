package com.johnverz.webdev1_g1.controller.api;

import com.johnverz.webdev1_g1.dto.CarDTO;
import com.johnverz.webdev1_g1.model.Car;
import com.johnverz.webdev1_g1.repository.CarRepository;
import com.johnverz.webdev1_g1.service.CarService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    //localhost:8000/api/cars
    @GetMapping("/cars")
    public List<Car> getAllCars(){
        return carService.findAll();
    }

    @PostMapping("/cars")
    public Car newCar(@Valid @RequestBody CarDTO car){
        return carService.save(car);
    }

    @PutMapping("/cars/{id}")
    public Car updateCar(@PathVariable int id, @Valid @RequestBody CarDTO car){
        Car updateCar = carService.findById(id);
        if (updateCar == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Car with ID "+ id + " not found.");
        }
        return carService.updateCar(updateCar, car);
    }

    @DeleteMapping("/cars/{id}")
    public void deleteCar(@PathVariable int id){
        if(carService.findById(id) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Car with ID "+ id + " not found.");
        }
        carService.deleteCar(id);
    }

}
