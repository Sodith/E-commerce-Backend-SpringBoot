package com.niit.Vehicle.service;


import com.niit.Vehicle.domain.Vehicle;

import java.util.List;
import java.util.Optional;

public interface VehicleService {


    Vehicle saveVehicleDetail(Vehicle vehicle) throws  Exception;
    boolean deleteVehicle(int id) throws Exception;
    List<Vehicle> getAllVehicleDetail();
    Optional<Vehicle> getVehicleById(int id);
    Vehicle  updateVehicle(Vehicle vehicle,int id);



}
