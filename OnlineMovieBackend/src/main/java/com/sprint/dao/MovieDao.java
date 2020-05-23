package com.sprint.dao;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sprint.entity.Movie;
import com.sprint.repository.MovieRepository;


 /**
 * This is data Access Layer that directly interacts with 
 * the Movie Repository Interface which implements JPARepository.
 */
@Repository
public class MovieDao {

	@Autowired
	private MovieRepository movieRepository ;
	
	public Movie addMovie(Movie movie) {
		return movieRepository.save(movie) ;
	}

	public List<Movie> getMovie() {
		List<Movie> movies = movieRepository.findAll() ;
		Collections.reverse(movies) ;
		return movies;
	}

	public String deleteMovie(long Id) {
		movieRepository.deleteById(Id);
		return "Movie Deleted Successfully!" ;
	}
	
	public Optional<Movie> findById(long id) {
		return movieRepository.findById(id) ;
	}
	
	public Movie save(Movie m) {
		return movieRepository.save(m) ;
	}

	public Movie findOne(long Id){
		return movieRepository.findById(Id).get();
	}
}