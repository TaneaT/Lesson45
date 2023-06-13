package com.tekwill.Lesson45.service;

import com.tekwill.Lesson45.Driver;
import com.tekwill.Lesson45.repository.DriverRepository;
import com.tekwill.Lesson45.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class DriverServiceImpl implements DriverService {
@Autowired
DriverRepository driverRepository;

    @Override
    public void createTable() {
        try{
            driverRepository.createTable();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void addDriver(Driver driver) {
        if(driver.experience == 0){
            throw new RuntimeException("We don't hire drivers without experience!");
        }

        try{
            driverRepository.createDriver(driver);

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Driver added in DB");
    }

    @Override
    public Driver getDriverById(long id) {
        Driver driver = null;
        try{
        driver = driverRepository.getDriverById(id);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Getting driver by Id...");
        return driver;
    }

    @Override
    public List<Driver> getAllDrivers() {
        List<Driver> drivers = new ArrayList<>();
        try{
            drivers = driverRepository.getAllDrivers();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Getting all drivers from DB...");

        return drivers;
    }
}
