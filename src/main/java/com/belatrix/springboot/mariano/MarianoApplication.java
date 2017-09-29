package com.belatrix.springboot.mariano;

import java.util.HashMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.belatrix.springboot.mariano.model.Vehiculo;

@SpringBootApplication
public class MarianoApplication {

	public static HashMap<Long, Vehiculo> hmVehiculo;

	public static void main(String[] args) {

		hmVehiculo = new HashMap<Long, Vehiculo>();

		Vehiculo one = new Vehiculo("Toyota", "Corolla");
		hmVehiculo.put(new Long(one.getId()), one);
		SpringApplication.run(MarianoApplication.class, args);

		Vehiculo two = new Vehiculo("Ferrari", "F50");
		hmVehiculo.put(new Long(two.getId()), two);

	}
}
