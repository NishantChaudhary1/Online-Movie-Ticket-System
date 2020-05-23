package com.sprint.service;

import java.util.List;

import com.sprint.entity.Bookings;
import com.sprint.entity.Show;

public interface BookingsService {

	public List<Bookings> getBookingByShowId(Show show);
	public Bookings saveBooking(Bookings b);
	public Bookings findOne(long ID);
	public String deleteBooking(Bookings b);
	public List<Bookings> getBooking();


}
