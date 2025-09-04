package com.johnverz.webdev1_g1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @GetMapping
    public String listCars(Model model) {
        List<Car> cars = carRepository.findAll();
        model.addAttribute("cars", cars);
        return "cars/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("car", new Car());
        return "cars/add";
    }

    @PostMapping("/add")
    public String addCar(@ModelAttribute Car car) {
        carRepository.save(car);
        return "redirect:/cars";
    }

    @GetMapping("/view/{id}")
    public String viewCar(@PathVariable int id, Model model) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid car ID: " + id));
        model.addAttribute("car", car);
        return "cars/view";
    }

    @GetMapping("/show/{id}")
    public String showCar(@PathVariable int id, Model model) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid car ID: " + id));
        model.addAttribute("car", car);
        return "cars/show";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("car", new Car());
        return "cars/create";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid car ID: " + id));
        model.addAttribute("car", car);
        return "cars/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateCar(@PathVariable int id, @ModelAttribute Car car) {
        car.setId(id);
        carRepository.save(car);
        return "redirect:/cars";
    }

    @GetMapping("/delete/{id}")
    public String deleteCar(@PathVariable int id) {
        carRepository.deleteById(id);
        return "redirect:/cars";
    }
}

