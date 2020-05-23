package com.sprint.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.dao.MovieDao;
import com.sprint.entity.Movie;
import com.sprint.exceptions.MovieAlreadyPresent;
import com.sprint.exceptions.MovieNotFound;


@Service
public class MovieServiceImpl implements MovieService{

	@Autowired
	private MovieDao movieDao ;
	
	/**
	 * This method adds new movie into the Database. 
	 * New movie must have unique Id.
	 * @param movie It is movie object.
	 * @exception MovieAlreadyPresent On duplicate movie Id.
	 */	
	@Override
	public Movie addMovie(Movie m) {
//		Optional<Movie> movie = movieDao.findById(m.getMovieId()) ;
//		if(movie.isPresent()) {
//			throw new MovieAlreadyPresent("Movie Aleardy present for ID: " + m.getMovieId()) ;
//		}
		return movieDao.save(m) ;
	}

	/**
	 * This method gives the list of all movies.
	 * @return movies List of movies.
	 * @exception MovieNotFound On no movies available.
	 */
	@Override
	public List<Movie> getMovie() {
		List<Movie> movies = movieDao.getMovie() ;
		if(movies.size() == 0) {
			throw new MovieNotFound("Oops! No movies are avilable currently.") ;
		}
		return movies ;
	}

	/**
	 * This method gives movie by Id.
	 * @param Id It is movie ID.
	 * @exception MovieNotFound On no movie for given id.
	 */
	@Override
	public String deleteMovie(long Id) {
		Optional<Movie> m = movieDao.findById(Id) ;
		if(!m.isPresent()) {
			throw new MovieNotFound("No movie present for ID: " + Id) ;
		}
		return movieDao.deleteMovie(Id) ;
	}

	/**
	 * This fetches movie by movie Id.
	 * @param ID It is movie Id.
	 */
	@Override
	public Movie findOne(long Id){
		Optional<Movie> movie = movieDao.findById(Id) ;
		if(!movie.isPresent()) {
			throw new MovieNotFound("No movie present for ID: " + Id) ;
		}
		return movie.get() ;
	}

}