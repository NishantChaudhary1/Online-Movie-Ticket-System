package com.sprint.service;

import java.util.List;

import com.sprint.entity.Bookings;
import com.sprint.entity.Movie;
import com.sprint.entity.Show;
import com.sprint.entity.Theater;

public interface ShowService {
	

	public Show addShow(Show show) ;
	
	public List<Show> getShow() ;
	
	public String deleteShow(long s) ;
	
	public Movie findOne(long Id) ;
	
	public Show fetchById(long Id);
		
	public List<Show> fetchByMovie(Movie m) ;
	
	public Bookings getAvailableSeat(long showID);
	
	public Theater findOneById(long Id);
	
}