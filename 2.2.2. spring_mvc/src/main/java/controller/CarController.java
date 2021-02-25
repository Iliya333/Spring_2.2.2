package controller;

import model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.ServiceCar;


import java.util.List;

@Controller
public class CarController {

    @Autowired
    private  ServiceCar serviceCar;

    @GetMapping(value = "/cars")
    public String getCars(@RequestParam(value = "count") int count, Model model) {
        List<Car> carList = serviceCar.getCarList(count);
        model.addAttribute("cars", carList);
        return "cars";
    }

}


