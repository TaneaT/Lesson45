package com.tekwill.Lesson45;

import com.tekwill.Lesson45.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DriverController {

    @Autowired
    DriverService driverService;

    @PostMapping("/driver/add")
    public void createDriver(@RequestBody Driver driver){
        driverService.addDriver(driver);
    }

@GetMapping("/driver/get")
    public List<Driver> getAllDrivers(){
        return driverService.getAllDrivers();
    }
}
