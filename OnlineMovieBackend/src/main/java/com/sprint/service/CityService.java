package com.sprint.service;

import java.util.List;

import com.sprint.entity.City;

public interface CityService {

	public City addCity(City city) ;
	
	public List<City> getCity() ;
	
	public String deleteCity(City city) ;
	
	public City findOne(long Id) ;
}