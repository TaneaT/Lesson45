package com.tekwill.Lesson45.repository;

import com.tekwill.Lesson45.Driver;
import com.tekwill.Lesson45.repository.DriverRepository;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class DriverRepositoryImpl implements DriverRepository {

    @Override
    public void createTable() throws SQLException {
        String url = ""; //url to db
        try(Connection connection = DriverManager.getConnection(url)){

            PreparedStatement createTable = connection.prepareStatement("CREATE TABLE driver(\n" +
                    "   id BIGINT AUTO_INCREMENT,\n" +
                            "   first_name VARCHAR(40),\n" +
                            "   last_name VARCHAR(40),\n" +
                            "   experience INT,\n" +
                            "   PRIMARY KEY(id)\n" +
                            "); ");

        createTable.execute();
        createTable.close();


        }
    }

    @Override
    public void createDriver(com.tekwill.Lesson45.Driver driver) throws SQLException {
        String url = "";
        try (Connection connection = DriverManager.getConnection(url)) {

            PreparedStatement createDriver = connection.prepareStatement("INSERT INTO driver(first_name,last_name,experience) VALUES (?,?,?);");

            createDriver.setString(1, driver.getFirst_name());
            createDriver.setString(2, driver.getLast_name());
            createDriver.setInt(3, driver.getExperience());

            createDriver.executeUpdate();
            createDriver.close();


        }
    }

    @Override
    public com.tekwill.Lesson45.Driver getDriverById(long driverId) throws SQLException {
        String url = "";
        try (Connection connection = DriverManager.getConnection(url)) {
            PreparedStatement getDriverById = connection.prepareStatement("SELECT * FROM driver WHERE id = ?;");
//            PreparedStatement delete = connection.prepareStatement("DELETE FROM driver WHERE id IN(3,4,5,6,7,8); ");
//            delete.executeUpdate();
//            delete.close();                  //I've runned the program several times so I had the same pople in DB so I deleted them



            getDriverById.setLong(1, driverId);

            ResultSet resultSet = getDriverById.executeQuery();

            com.tekwill.Lesson45.Driver driver = null;

            while (resultSet.next()) {
                long id = resultSet.getLong(1);
                String first_name = resultSet.getString(2);
                String last_name = resultSet.getString(3);
                Integer experience = resultSet.getInt(4);

                driver = new com.tekwill.Lesson45.Driver(id, first_name, last_name, experience);
            }

            getDriverById.close();

            return driver;
        }
    }

    @Override
    public List<com.tekwill.Lesson45.Driver> getAllDrivers() throws SQLException {
        String url = "";
        try (Connection connection = DriverManager.getConnection(url)) {

            PreparedStatement getAllDrivers = connection.prepareStatement("SELECT * FROM driver;");

            ResultSet resultSet = getAllDrivers.executeQuery();

            List<com.tekwill.Lesson45.Driver> drivers = new ArrayList<>();

            while(resultSet.next()){
                long id = resultSet.getLong(1);
                String first_name = resultSet.getString(2);
                String last_name = resultSet.getString(3);
                Integer experience = resultSet.getInt(4);

                com.tekwill.Lesson45.Driver driver = new Driver(id, first_name, last_name, experience);

                drivers.add(driver);
            }
            getAllDrivers.close();

            return drivers;
        }
    }
}
