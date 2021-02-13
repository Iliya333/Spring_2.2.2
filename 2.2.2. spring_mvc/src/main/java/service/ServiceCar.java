package service;

import model.Car;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceCar {


    public List<Car> getCarOfNumber(int count) {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("BMW", "3", 2000));
        carList.add(new Car("Volvo", "S40", 2004));
        carList.add(new Car("Nissan", "Juke", 2014));
        carList.add(new Car("Renault", "Duster", 2018));
        carList.add(new Car("Toyota", "Camry", 2019));
        if (count < 1 || count >= 5) {
            return carList;
        } else
            return carList.stream().limit(count).collect(Collectors.toList());
    }



}
