package br.com.avelar.bac.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.avelar.bac.car.Car;
import br.com.avelar.bac.car.CarService;

@RestController
@RequestMapping("/car")
public class CarController {

    private CarService service;

    @Autowired
    public CarController(CarService service) {
        this.service = service;
    }

    @CrossOrigin
    @RequestMapping("/license/{license}")
    public ResponseEntity<Car> findByLicense(@PathVariable String license) {
        Car Car = service.findOne(license);

        if (Car == null) {
            return new ResponseEntity<Car>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Car>(Car, HttpStatus.OK);

    }

    @CrossOrigin
    @RequestMapping("/description/{description}")
    public ResponseEntity<List<Car>> findByDescription(@PathVariable String description) {
        List<Car> cars = service.findByDescription(description);
        return new ResponseEntity<List<Car>>(cars, HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping("/model/{model}")
    public ResponseEntity<List<Car>> findByModel(@PathVariable("model") String model) {
        List<Car> cars = service.findByModel(model);
        return new ResponseEntity<List<Car>>(cars, HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping("/all")
    public ResponseEntity<List<Car>> findAll() {
        return new ResponseEntity<List<Car>>(service.findAll(), HttpStatus.OK);
    }

}
