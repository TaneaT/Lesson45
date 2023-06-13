package com.tekwill.Lesson45;

import com.tekwill.Lesson45.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lesson45Application implements CommandLineRunner {

	@Autowired
	DriverService driverService;

	public static void main(String[] args) {
		SpringApplication.run(Lesson45Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		driverService.createTable();

//		Driver driver = new Driver("Ion","Rusu",3);
//		Driver driver1 = new Driver("Valentin","Popov",7);
//
//		driverService.addDriver(driver);
//		driverService.addDriver(driver1);

		System.out.println(driverService.getDriverById(1));

		System.out.println(driverService.getAllDrivers());

	}
}
