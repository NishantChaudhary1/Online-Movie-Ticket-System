package com.sprint.controller;


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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.entity.Movie;
import com.sprint.entity.Show;
import com.sprint.entity.Theater;
import com.sprint.service.MovieService;
import com.sprint.service.ShowService;

@RestController
@CrossOrigin("*")
@RequestMapping("/show")
public class ShowController {

	@Autowired
	private ShowService showService ;
	
	@Autowired
	private MovieService movieService ;
	
//	Get Available Show for a particular movie 	
	@GetMapping("/movie/{id}")
	public List<Show> geShowByMovieId(@PathVariable(value ="id") long id){
		
		Movie theMovie = showService.findOne(id);
	
		return showService.fetchByMovie(theMovie);
	}
	
//	adding show for a theater and movie
	@PostMapping("/{theaterId}/{movieId}")
	public Show addingShow(@PathVariable(value ="theaterId") long theaterId,@PathVariable(value ="movieId") long movieId, @Valid @RequestBody Show requestData) {
		Theater theTheater = showService.findOneById(theaterId);
		Movie theMovie = showService.findOne(movieId);
		Show theShow = new Show();
		theShow.setShow_time(requestData.getShow_time());
		theShow.setTheMovie(theMovie);
		theShow.setTheTheater(theTheater);
		return showService.addShow(theShow);
	}
	
//	Get show By MovieId
	@GetMapping("/show/{movieId}")
	public Show getShow(@PathVariable(value = "movieId") long movieId) {
		Movie movie = movieService.findOne(movieId) ;
		List<Show> s = movie.getShow() ;
		return s.get(0) ;
	}
	
//	Delete Show By Id
	@DeleteMapping("/delete/{Id}")
	public ResponseEntity<String> deleteMovie(@PathVariable(value= "Id") long Id){
		return new ResponseEntity<String>(showService.deleteShow(Id), HttpStatus.OK) ;
	}
}