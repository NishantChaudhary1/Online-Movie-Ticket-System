/**
 * 
 */
package com.sprint.movie;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sprint.dao.MovieDao;
import com.sprint.entity.Movie;
import com.sprint.service.MovieService;

/**
 * @author Nishant
 * This class performs unit testing using junit5
 * for the movie service class.
 *
 */
@SpringBootTest
public class TestMovie {

	@Autowired
	private MovieService movieService ;
	
	@MockBean
	private MovieDao movieDao ;
	
	@Test
	public void testAllMovies() {
		when(movieDao.getMovie()).thenReturn(Stream.of(new Movie("MelbMovie", "MelbDir", "MilbDesc", "MelbImg"),
				new Movie("SelbMovie", "SelbDir", "SilbDesc", "SelbImg")).
				collect(Collectors.toList())) ;
		
		assertEquals(2, movieService.getMovie().size());
	}
	
	@Test
	public void testGetOneMovie() {
		long id = 200 ;
		Movie movie = new Movie(200,"MelbMovie", "MelbDir", "MilbDesc", "MelbImg") ;
		Optional<Movie> movieOptional = Optional.of(movie) ;
		when(movieDao.findById(id)).thenReturn(movieOptional) ;
		assertEquals(movieOptional.get(), movieService.findOne(id)) ;
	}
	
	@Test
	public void testDeleteMovie() {
		long id = 200 ;
		Movie movie = new Movie(200,"MelbMovie", "MelbDir", "MilbDesc", "MelbImg") ;
		Optional<Movie> movieOptional = Optional.of(movie) ;		
		when(movieDao.findById(id)).thenReturn(movieOptional) ;
		
		movieService.deleteMovie(id) ;
		
		verify(movieDao, times(1)).deleteMovie(id) ;	
	}
	
}
