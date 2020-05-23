package com.sprint.controller;

import java.util.Date;
import java.util.List;

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
import com.sprint.entity.Theater;
import com.sprint.model.Response;
import com.sprint.service.CityService;
import com.sprint.service.TheaterService;

@RestController
@CrossOrigin("*")
@RequestMapping("/theater")
public class TheaterController {
	@Autowired
	private TheaterService service;

	@Autowired
	private CityService cservice;

	@PostMapping("/addTheater")
	public ResponseEntity<Response> createTheater(@Valid @RequestBody Theater theater) {
		return ResponseEntity.status(HttpStatus.OK).body(new Response(service.saveTheater(theater), new Date()));

	}

	@DeleteMapping("/deletetheater/{ID}")
	public ResponseEntity<Theater> deleteTheater(@PathVariable(value = "ID") long ID) {
		Theater theTheater = service.findOne(ID);
		if (theTheater == null) {
			return ResponseEntity.notFound().build();
		}
		service.deleteTheater(theTheater);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/updatetheater/{ID}")
	public ResponseEntity<Theater> updatetheater(@PathVariable(value = "ID") long ID, @Valid @RequestBody Theater t) {

		Theater theTheater = service.findOne(ID);
		if (theTheater == null) {
			return ResponseEntity.notFound().build();
		}
		theTheater.setTheaterName(t.getTheaterName());
		theTheater.setTheaterArea(t.getTheaterArea());

		Theater updatedTheater = service.saveTheater(theTheater);
		return ResponseEntity.ok().body(updatedTheater);

	}

	@GetMapping("/alltheaters")
	public ResponseEntity<Response> getTheater() {
		return ResponseEntity.status(HttpStatus.OK)
		.body(new Response(service.getTheater(), new Date()));
	}
	
	@PutMapping("/{cityId}/{Id}")
	public Theater createTheater(@PathVariable("cityId") long cityId, @PathVariable("Id") long Id) {

		// return service
		Theater theTheater = service.findOne(Id) ;
		City theCity = cservice.findOne(cityId);
		theTheater.setCity(theCity);
		return service.saveTheater(theTheater);
	}

	@GetMapping("/theater/{ID}")
	public ResponseEntity<Theater> getOneTheater(@PathVariable(value = "ID") long ID) {
		Theater theTheater = service.findOne(ID);
		if (theTheater == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(theTheater);
	}

	@GetMapping("/TheaterByCity/{ID}")
	public List<Theater> getTheaterInCity(@PathVariable(value = "ID") long ID) {

		City theCity = cservice.findOne(ID);

		return service.getTheaterByCityId(theCity);
	}

}