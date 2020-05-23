package com.sprint.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.entity.Movie;
import com.sprint.exceptions.MovieAlreadyPresent;
import com.sprint.exceptions.MovieNotFound;
import com.sprint.model.Response;
import com.sprint.service.MovieService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/movie")
public class MovieController {

	@Autowired
	private MovieService movieService;

	/**
	 * This is the Post method to add new movie. 
	 * Adds new movie only if it has unique ID.
	 * @param movie This is the new movie object.
	 * @return response It consists of movie object and current time stamp.
	 */	
	@ExceptionHandler(MovieAlreadyPresent.class)
	@PostMapping("/addMovie")
	public ResponseEntity<?> createMovie(@Valid @RequestBody Movie movie)  {
		try {
		return ResponseEntity.status(HttpStatus.CREATED).body(new Response(movieService.addMovie(movie), new Date()));
		}
		catch(MovieAlreadyPresent ex) {
			return new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT) ;
		}
	}

	/**
	 * This is the Delete method to delete existing movie by ID.
	 * 
	 * @param Id Takes movieId from url.
	 */
	@ExceptionHandler(MovieNotFound.class)
	@DeleteMapping("/delete/{Id}")
	public ResponseEntity<?> deleteMovie(@PathVariable(value = "Id") long Id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(new Response(movieService.deleteMovie(Id), new Date()));
		}
		catch(Exception ex) {
			return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND) ;
		}
	}

	/**
	 * This is Get method to retrieve all movies.
	 */
	@GetMapping("/allMovies")
	public ResponseEntity<Response> getAllMovies() {
		return ResponseEntity.status(HttpStatus.OK).body(new Response(movieService.getMovie(), new Date()));
	}

	/**
	 * This is Put method to update an existing movie. It updates the movie by
	 * matching movie Id.
	 * 
	 * @param ID    It is movieId from url.
	 * @param movie It is movie object.
	 * @return Response It consists of updated movie object and current time stamp.
	 * @exception MovieNotFoundException On movie not found.
	 */
	@PutMapping("/update/{ID}")
	public ResponseEntity<Response> updateMovie(@PathVariable(value = "ID") long ID, @Valid @RequestBody Movie m) {
		Movie theMovie = movieService.findOne(ID);
		theMovie.setMovieName(m.getMovieName());
		theMovie.setMovieDirector(m.getMovieDirector());
		theMovie.setMovieDescription(m.getMovieDescription());
		theMovie.setMovieImg(m.getMovieImg());
		return ResponseEntity.status(HttpStatus.OK).body(new Response(movieService.addMovie(theMovie), new Date()));
	}

	/**
	 * This get method is used to retrieve all movie details.
	 * 
	 * @param ID It is movie Id.
	 */
	@ExceptionHandler(MovieNotFound.class)
	@GetMapping("/{ID}")
	public ResponseEntity<?> getOneMovie(@PathVariable(value = "ID") long ID) {
		try {
		return ResponseEntity.status(HttpStatus.OK).body(new Response(movieService.findOne(ID), new Date()));
		}
		catch(Exception ex) {
			return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND) ;
		}
	}

}