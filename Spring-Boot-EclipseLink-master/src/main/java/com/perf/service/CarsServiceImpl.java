package com.perf.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.perf.bean.Car;

@Component
public class CarsServiceImpl implements CarsService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void saveCar(Car car) {
        em.getTransaction().begin();
        em.persist(car);
        em.getTransaction().commit();
    }

    @Override
    public Car findCarByName(String name) {
        Query query = em.createNamedQuery("Car.findByName");
        query.setParameter("name", name);
        Car car = (Car) query.getSingleResult();
        return car;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Car> findAll() {
        Query query = em.createNamedQuery("Car.findAll");
		List<Car> cars = query.getResultList();
        return cars;
    }
}
