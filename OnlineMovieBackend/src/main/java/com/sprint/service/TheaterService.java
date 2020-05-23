package com.sprint.service;

import java.util.List;

import com.sprint.entity.City;
import com.sprint.entity.Theater;

public interface TheaterService {
	public Theater saveTheater(Theater t);
	public List<Theater> getTheater();
	public Theater findOne(long ID);
	public String deleteTheater(Theater t);
	public List<Theater> getTheaterByCityId(City c);

}