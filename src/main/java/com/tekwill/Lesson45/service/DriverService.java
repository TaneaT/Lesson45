package com.tekwill.Lesson45.service;

import com.tekwill.Lesson45.Driver;

import java.util.List;

public interface DriverService {

    void createTable();

    void addDriver(Driver driver);

    Driver getDriverById(long id);

    List<Driver> getAllDrivers();
}
