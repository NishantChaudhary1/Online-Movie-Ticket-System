package com.sprint.service;

import java.util.List;


/**
 * Service for Movie Controller.
 * It consists of methods of add movie, delete movie,
 * get list of all movies, get movie by Id and 
 * get movies present in a particular theater.
*/
import com.sprint.entity.Movie;

public interface MovieService {

	public Movie addMovie(Movie movie) ;
	
	public List<Movie> getMovie() ;
	
	public String deleteMovie(long Id) ;
	
	public Movie findOne(long Id) ;
}