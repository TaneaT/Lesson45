package com.tekwill.Lesson45.repository;

import com.tekwill.Lesson45.Driver;

import java.sql.SQLException;
import java.util.List;

public interface DriverRepository {

    void createTable() throws SQLException;

    void createDriver(Driver driver) throws SQLException;

    Driver getDriverById(long id) throws SQLException;

    List<Driver> getAllDrivers() throws SQLException;
}
