package web.services;

import org.springframework.stereotype.Service;
import web.models.Car;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    private final List<Car> cars;

    public CarServiceImpl() {
        this.cars = List.of(
                new Car("Lada", 100, 150),
                new Car("BMW", 200, 250),
                new Car("Mercedes", 250, 300),
                new Car("Mazda", 180, 220),
                new Car("Volga", 120, 180));
    }

    @Override
    public List<Car> getNumberOfCars(Integer count) {
        return cars.stream()
                .limit(Math.min(count, cars.size()))
                .collect(Collectors.toList());
    }
}
