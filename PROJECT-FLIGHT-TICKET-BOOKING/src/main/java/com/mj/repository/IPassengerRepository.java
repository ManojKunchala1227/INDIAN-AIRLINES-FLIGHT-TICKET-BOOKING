package com.mj.repository;

import org.springframework.data.repository.CrudRepository;

import com.mj.model.Passenger;

public interface IPassengerRepository extends CrudRepository<Passenger, Integer> {

}
