package com.niit.Vehicle.repository;

import com.niit.Vehicle.domain.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VehicleRepository extends MongoRepository<Vehicle,Integer> {



}
