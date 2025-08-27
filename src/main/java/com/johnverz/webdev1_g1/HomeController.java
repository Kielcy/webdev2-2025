package com.johnverz.webdev1_g1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {

    CarRepository carRepository;

    public HomeController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping("/")
    public String index(Model model){
        List<Car> cars = carRepository.findAll();
        model.addAttribute("cars",carRepository.findAll());
        cars.forEach(car -> {
            System.out.println(car.getMake());
        });
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model){
        Car car = new Car();
        model.addAttribute("car",car);
        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Car car){
        carRepository.save(car);
        return "redirect:/";


    }
}
