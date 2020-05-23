/**
 * 
 */
package com.sprint.movie;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.sprint.entity.Movie;


/**
 * @author Nishant
 *
 */
@SpringBootTest
public class TestMovieController {
	
	RestTemplate restTemp ;
	
	@BeforeEach
	public void setup() {
		restTemp = new RestTemplate() ;
	}
	
	@Test
	public void testAddMovie() {
		Movie movie = new Movie("SelbMovie", "SelbDir", "SilbDesc", "SelbImg") ;
		
		ResponseEntity<Movie> movieResp = restTemp.postForEntity("http://localhost:9090/movie/addMovie", movie, Movie.class) ;
		
		assertEquals(201 , movieResp.getStatusCodeValue());		
	}
	
	@Test
	public void testAllMovie() {
		
		ResponseEntity<Movie> movieResp = restTemp.getForEntity("http://localhost:9090/movie/allMovies", Movie.class) ;
		
		assertEquals(200, movieResp.getStatusCodeValue());
	}

}
