package com.belatrix.springboot.mariano.controller;

import java.util.HashMap;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.belatrix.springboot.mariano.MarianoApplication;
import com.belatrix.springboot.mariano.model.Vehiculo;

@RestController
@RequestMapping(value = "/rest/vehiculo")
public class VehiculoController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public HashMap<Long, Vehiculo> getAllVehiculo() {
		return MarianoApplication.hmVehiculo;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Vehiculo addVehiculo(@RequestParam(value = "marca") String marca,
			@RequestParam(value = "modelo", defaultValue = "unknown") String modelo) {

		Vehiculo vehiculo = new Vehiculo(marca, modelo);
		MarianoApplication.hmVehiculo.put(new Long(vehiculo.getId()), vehiculo);
		return vehiculo;

	}
	
	@RequestMapping(value="/update",method = RequestMethod.PUT)
	public Vehiculo updateVehiculo(@RequestBody Vehiculo vehiculo) throws Exception {
	 
	   if(MarianoApplication.hmVehiculo.containsKey(new Long(vehiculo.getId()))){
		   MarianoApplication.hmVehiculo.put(new Long(vehiculo.getId()),vehiculo);
	   }else{
	      throw new Exception("Vehiculo "+vehiculo.getId()+" no existe");
	   }
	 
	   return vehiculo;
	}
	
	@RequestMapping(value="/delete/{id}",method = RequestMethod.DELETE)
	public Vehiculo deleteVehiculo(@PathVariable long id) throws Exception {

	   Vehiculo vehiculo;

	   if(MarianoApplication.hmVehiculo.containsKey(new Long(id))){
	      vehiculo=MarianoApplication.hmVehiculo.get(new Long(id));
	      MarianoApplication.hmVehiculo.remove(new Long(id));
	   }else{
	      throw new Exception("Vehiculo "+id+" no existe");
	   }
	   return vehiculo;
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Vehiculo getVehiculo(@PathVariable long id){
	   return MarianoApplication.hmVehiculo.get(new Long(id));
	}

}