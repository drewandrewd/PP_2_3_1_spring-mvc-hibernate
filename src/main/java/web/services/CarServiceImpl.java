package web.services;

import org.springframework.stereotype.Service;
import web.models.Car;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Override
    public List<Car> getNumberOfCars(List<Car> cars, int number) {
        if (number >= cars.size()) {
            return cars;
        }
        return cars.subList(0, number);
    }
}
