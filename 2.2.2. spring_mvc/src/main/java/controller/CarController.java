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

    public CarController() {
    }

    private ServiceCar serviceCar;

    @Autowired
    public CarController(ServiceCar serviceCar) {
        this.serviceCar = serviceCar;
    }

    @GetMapping(value = "/cars")
    public String getCars(@RequestParam(value = "count", defaultValue = "0") int count, Model model) {
        if (count == 0){
            count = serviceCar.getSize();
        }
        List<Car> carList = serviceCar.getCarList(count);
        model.addAttribute("cars", carList);
        return "cars";
    }

}


