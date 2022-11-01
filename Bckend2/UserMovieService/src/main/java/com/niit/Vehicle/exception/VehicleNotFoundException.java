package com.niit.Vehicle.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND , reason = "Movie Not Found")
public class VehicleNotFoundException extends Exception{

}
