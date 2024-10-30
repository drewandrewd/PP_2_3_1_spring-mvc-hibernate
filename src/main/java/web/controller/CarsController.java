package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.models.Car;
import web.services.CarService;

import java.util.List;

@Controller
public class CarsController {

    private final CarService carService;

    @Autowired
    public CarsController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/cars")
    public String printCars(@RequestParam(value = "count", required = false) Integer count, ModelMap model) {
        List<Car> cars = List.of(
                new Car("Lada", 100, 150),
                new Car("BMW", 200, 250),
                new Car("Mercedes", 250, 300),
                new Car("Mazda", 180, 220),
                new Car("Volga", 120, 180));
        int limit = (count == null || count >= cars.size()) ? cars.size() : count;
        model.addAttribute("cars", carService.getNumberOfCars(cars, limit));
        return "cars";
    }
}
