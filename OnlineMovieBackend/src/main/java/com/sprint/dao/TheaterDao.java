package com.sprint.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sprint.entity.City;
import com.sprint.entity.Theater;
import com.sprint.repository.TheaterRepository;

@Repository
public class TheaterDao {

	@Autowired
	TheaterRepository theTheaterRepository;
	
	//Save Theater
	public Theater save(Theater t) {
		return theTheaterRepository.save(t);
	}
	
//	get all theater 
	public List<Theater> getTheater(){
		return theTheaterRepository.findAll();
	}
	
//	get Theater by ID
	
	public Theater findOne(long ID){
		
		return theTheaterRepository.getOne(ID);
		
	}
	
//	Delete theater
	public String deleteTheater(Theater t) {
		theTheaterRepository.deleteById(t.getTheaterId());
		return "Theater Deleted";
	}
	
//	Find theater by city ID
	public List<Theater> getTheaterByCityId(City c){
		return theTheaterRepository.findByCity(c);
	}
	
// Find Theater by Id
	public Optional<Theater> findById(long id) {
		return theTheaterRepository.findById(id);

}
}