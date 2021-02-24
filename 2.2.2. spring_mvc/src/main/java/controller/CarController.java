package controller;

import model.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.ServiceCar;


import java.util.List;

@Controller
public class CarController {

    @GetMapping(value = "/cars")
    public String getCars(@RequestParam(value = "count", defaultValue = "0") int count, Model model) {
        ServiceCar serviceCar = new ServiceCar();
        List<Car> carList = serviceCar.getCarList(count);
        model.addAttribute("cars", carList);
        return "cars";
    }

}


