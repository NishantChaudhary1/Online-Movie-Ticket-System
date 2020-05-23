package com.sprint.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.dao.TheaterDao;
import com.sprint.entity.City;
import com.sprint.entity.Theater;
import com.sprint.exceptions.TheaterNotFoundException;



@Service
@Transactional
public class TheaterServiceImpl implements TheaterService{
	@Autowired 
	private TheaterDao theaterdao;

	@Override
	public Theater saveTheater(Theater t) {
		return theaterdao.save(t);
	}

	@Override
	public List<Theater> getTheater() {
		return theaterdao.getTheater();
	}

	@Override
	public Theater findOne(long ID) {
		return theaterdao.findOne(ID);
	}

	@Override
	public String deleteTheater(Theater t) {
		Optional<Theater> th= theaterdao.findById(t.getTheaterId());
		 if(!th.isPresent())
		 {
			 throw new TheaterNotFoundException("Theater not found");
		 }
		
		return theaterdao.deleteTheater(t);
		
	}

	@Override
	public List<Theater> getTheaterByCityId(City c) {
		return theaterdao.getTheaterByCityId(c);		
	}
	
}