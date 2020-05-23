package com.sprint.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sprint.entity.Movie;
import com.sprint.entity.Show;
import com.sprint.repository.ShowRepository;

@Repository
public class ShowDao {

	@Autowired
	private ShowRepository showRepository ;
	
	public Show addShow(Show show) {
		return showRepository.save(show) ;
	}

	public List<Show> getShow() {
		return showRepository.findAll() ;
	}

	public String deleteShow(long s) {
		showRepository.deleteById(s);
		return "Show Deleted Successfully!" ;
	}
	
	public Optional<Show> findById(long showId) {
		return showRepository.findById(showId) ;
		//returns optional datatype
	}
	
	public Show findOne(long Id){
		return showRepository.findById(Id).get() ;
	}//directly called by controller

	public Show save(Show s) {
		return showRepository.save(s) ;
	}

	public List<Show> findBytheMovie(Movie m) {
		return showRepository.findBytheMovie(m) ;
	}

	public Show getOne(long id) {
		// TODO Auto-generated method stub
		
		return showRepository.getOne(id);
	}

}