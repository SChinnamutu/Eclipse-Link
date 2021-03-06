package com.perf.client;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import com.perf.bean.Car;
import com.perf.service.CarsService;

@Component
public class MyRunner implements CommandLineRunner {

    @Autowired
    private CarsService crs;

    @Override
    public void run(String... args) throws Exception {
        try {
            Car car = crs.findCarByName("Citroen");
            System.out.printf("ID: %d%n", car.getId());
            System.out.printf("Name: %s%n", car.getName());
            System.out.printf("Price: %d%n", car.getPrice());
            
        } catch (EmptyResultDataAccessException e) {
            System.out.println("Car was not found");
        }
        List<Car> cars = crs.findAll();
        for (Car car: cars) {
            System.out.printf("%d ", car.getId());
            System.out.printf("%s ", car.getName());
            System.out.println(car.getPrice());
        }
    }
}