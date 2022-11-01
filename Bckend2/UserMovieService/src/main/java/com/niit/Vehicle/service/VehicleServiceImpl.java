package com.niit.Vehicle.service;



import com.niit.Vehicle.domain.Vehicle;
import com.niit.Vehicle.exception.VehicleAlreadyExistsException;

import com.niit.Vehicle.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {

    private VehicleRepository vehicleRepository;

    @Autowired
    public VehicleServiceImpl(VehicleRepository vehicleRepository) {

        this.vehicleRepository = vehicleRepository;
    }


    @Override
    public Vehicle saveVehicleDetail(Vehicle vehicle) throws Exception {
        {
            if(vehicleRepository.findById(vehicle.getId()).isPresent())
            {
                throw new VehicleAlreadyExistsException();
            }
            return vehicleRepository.save(vehicle);
        }
    }

    @Override
    public boolean deleteVehicle(int id) throws Exception {
        return false;
    }

    @Override
    public List<Vehicle> getAllVehicleDetail() {
        return vehicleRepository.findAll();
    }

    @Override
    public Optional<Vehicle> getVehicleById(int id) {
        return vehicleRepository.findById(id);
    }

    @Override
    public Vehicle updateVehicle(Vehicle vehicle, int id) {
        if (vehicleRepository.findById(id).isEmpty())
        {
            return null;
        }
        return vehicleRepository.save(vehicle);
    }
}
