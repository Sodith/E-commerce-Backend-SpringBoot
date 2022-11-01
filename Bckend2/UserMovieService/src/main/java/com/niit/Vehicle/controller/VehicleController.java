package com.niit.Vehicle.controller;

import com.niit.Vehicle.domain.Vehicle;
import com.niit.Vehicle.exception.VehicleAlreadyExistsException;
import com.niit.Vehicle.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/")
public class VehicleController {

    private VehicleService vehicleService;
    private ResponseEntity<?> responseEntity;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("vehicle")
    public ResponseEntity<?> saveVehicle(@RequestBody Vehicle vehicle) throws VehicleAlreadyExistsException {
        try {
            vehicleService.saveVehicleDetail(vehicle);
            responseEntity = new ResponseEntity<>(vehicle, HttpStatus.CREATED);
        } catch (VehicleAlreadyExistsException e) {
            throw new VehicleAlreadyExistsException();
        } catch (Exception e) {
            responseEntity = new ResponseEntity<>("Error !!! Try again later", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @GetMapping("vehicles")
    public ResponseEntity<?> getAllVehicle() {
        try {
            responseEntity = new ResponseEntity<>(vehicleService.getAllVehicleDetail(), HttpStatus.OK);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<>("Error !!! Try After Sometime.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
    @GetMapping("vehicle/{id}")
    public ResponseEntity<?> getVehicleById(@PathVariable int id)
    {
        return responseEntity=new ResponseEntity(vehicleService.getVehicleById(id),HttpStatus.OK);
    }

    @PutMapping("vehicle/{id}")
    public ResponseEntity<?> updateVehicle(@RequestBody Vehicle vehicle,@PathVariable int id) {

        return new ResponseEntity<>(vehicleService.updateVehicle(vehicle,id), HttpStatus.OK);
    }


}
