package com.sprint.controller;

import java.util.Date;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.entity.City;
import com.sprint.model.Response;
import com.sprint.service.CityService;

@RestController
@CrossOrigin("*")
@RequestMapping("/city")
public class CityController {

	@Autowired
	private CityService cityService ;

	
	@GetMapping("/allCity")
	public ResponseEntity<Response> getAllCity(){
		return ResponseEntity.status(HttpStatus.OK)
				.body(new Response(cityService.getCity(), new Date()));
	}
	
	@PostMapping("/addCity")
	public ResponseEntity<Response> createCity(@Valid @RequestBody City city) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(new Response(cityService.addCity(city), new Date()));
	}
	
	
	@DeleteMapping("/delete/{Id}")
	public ResponseEntity<City> deleteCity(@PathVariable(value= "Id") long Id){
		City theCity = cityService.findOne(Id);
		if(theCity == null) {
			return ResponseEntity.notFound().build();
		}
		cityService.deleteCity(theCity);
		return ResponseEntity.ok().build();
	}
	
	
	@PutMapping("/update/{ID}")
	public ResponseEntity<City> updateCity(@PathVariable(value="ID") long ID,@Valid @RequestBody City c){
		City theCity = cityService.findOne(ID);
		if(theCity == null) {
			return ResponseEntity.notFound().build();
		}
		theCity.setCityName(c.getCityName());
		theCity.setCityPincode(c.getCityPincode());
		theCity.setCityState(c.getCityState());
		
		City updatedCity = cityService.addCity(theCity);
		return ResponseEntity.ok().body(updatedCity);
	}
	
}