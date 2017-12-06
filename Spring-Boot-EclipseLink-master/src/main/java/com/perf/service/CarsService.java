package com.perf.service;

import java.util.List;

import com.perf.bean.Car;

public interface CarsService {

    public void saveCar(Car car);

    public Car findCarByName(String name);

    public List<Car> findAll();
}
