package com.sprint.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tableTheater")
@EntityListeners(AuditingEntityListener.class)

public class Theater {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long theaterId;

	private String theaterName;

	private String theaterArea;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@OnDelete(action=OnDeleteAction.CASCADE) 
	private City city;
	
	@OneToMany(mappedBy = "theTheater")
	@OnDelete(action=OnDeleteAction.CASCADE) 
	private List<Show> theShow;
	
	

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public long getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(long theaterId) {
		this.theaterId = theaterId;
	}

	public String getTheaterName() {
		return theaterName;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

	public String getTheaterArea() {
		return theaterArea;
	}

	public void setTheaterArea(String theaterArea) {
		this.theaterArea = theaterArea;
	}

	public List<Show> getTheShow() {
		return theShow;
	}

	public void setTheShow(List<Show> theShow) {
		this.theShow = theShow;
	}

	
	

}
