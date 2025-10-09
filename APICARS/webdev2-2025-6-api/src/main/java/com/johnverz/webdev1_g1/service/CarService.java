package com.johnverz.webdev1_g1.service;

import com.johnverz.webdev1_g1.dto.CarDTO;
import com.johnverz.webdev1_g1.exception.ResourceNotFoundException;
import com.johnverz.webdev1_g1.model.Car;
import com.johnverz.webdev1_g1.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private final CarRepository repository;

    public CarService(CarRepository repository){
        this.repository = repository;
    }

    public List<Car> findAll(){
        return repository.findAll();
    }

    public Car findById(int id){
        return repository.findById(id).orElse(null);
    }

    public Car save(CarDTO car){
        Car newCar = new Car();
        newCar.setModel(car.getModel());
        newCar.setYear(car.getYear());
        newCar.setColor(car.getColor());
        newCar.setMake(car.getMake());
        return repository.save(newCar);
    }

    public Car updateCar(Car car, CarDTO carDTO){
        car.setModel(carDTO.getModel());
        car.setYear(carDTO.getYear());
        car.setColor(carDTO.getColor());
        car.setMake(carDTO.getMake());
        return repository.save(car);
    }

    public void deleteCar(int id){
        repository.deleteById(id);
    }
}
