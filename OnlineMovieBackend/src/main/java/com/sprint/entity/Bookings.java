package com.sprint.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Bookings {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator="seqgen")
	@SequenceGenerator(name="seqgen",sequenceName="seqNmae")
	private long bookingId;
	
	private String seat;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@OnDelete(action=OnDeleteAction.CASCADE) 
	private Show show;

	public long getBookingId() {
		return bookingId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	public Show getShow() {
		return show;
	}

	public void setShow(Show show) {
		this.show = show;
	}

	/**
	 * @param totalSeat
	 * @param show
	 */
	public Bookings(String seat, Show show) {
		super();
		this.seat = seat;
		this.show = show;
	}
	
	public Bookings()
	{
		super();
	}
	
}
