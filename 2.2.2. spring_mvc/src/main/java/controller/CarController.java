package controller;

import model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.ServiceCar;

import javax.servlet.http.HttpServletRequest;
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
    public String getCars(HttpServletRequest request, ModelMap modelMap) {
         int count = 0;
        String value =request.getParameter("count");
        if (value != null) {
            count += Integer.parseInt(value);
        }
        List<Car> cars = serviceCar.getCarOfNumber(count);
        modelMap.addAttribute("cars", cars);
        return "cars";
    }
}
