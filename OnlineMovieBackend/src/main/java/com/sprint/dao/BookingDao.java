package com.sprint.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sprint.entity.Bookings;
import com.sprint.entity.Show;
import com.sprint.repository.BookingsRepository;

@Repository
public class BookingDao {
	
	@Autowired
	BookingsRepository bookingRepository;
	
	public List<Bookings> addBookingByShowId(Show show){
		return bookingRepository.findByShow(show);
	}
	
	public Bookings saveBook(Bookings b) {
		return bookingRepository.save(b);
	}
	
	public Bookings findOne(long ID){
		
		return bookingRepository.getOne(ID);
	}
	
//	Delete theater
	public String deleteBooking(Bookings b) {
		bookingRepository.deleteById(b.getBookingId());
		return "Booking Deleted";
	}
	
// Find Theater by Id
	public Optional<Bookings> findById(long id) {
		return bookingRepository.findById(id);	
	}
	
//	get all theater 
	public List<Bookings> getBooking(){
		return bookingRepository.findAll();
	}
}
