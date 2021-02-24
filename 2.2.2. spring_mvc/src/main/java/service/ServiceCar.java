package service;

import model.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceCar {

    List<Car> carList = new ArrayList<>();

    public ServiceCar() {
        carList.add(new Car("BMW", "3", 2000));
        carList.add(new Car("Volvo", "S40", 2004));
        carList.add(new Car("Nissan", "Juke", 2014));
        carList.add(new Car("Renault", "Duster", 2018));
        carList.add(new Car("Toyota", "Camry", 2019));

    }

    public List<Car> getCarList(int count) {
        return carList.stream().limit(count).collect(Collectors.toList());
    }

}
