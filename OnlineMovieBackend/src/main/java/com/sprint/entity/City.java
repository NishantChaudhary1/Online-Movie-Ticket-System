 package com.sprint.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="tableCity")
@EntityListeners(AuditingEntityListener.class)
public class City {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long cityId;	
	@Column(nullable=false)
	
	private String cityName;

	private String cityPincode;

	private String cityState;
	
	@OneToMany(mappedBy="city")
	@OnDelete(action=OnDeleteAction.CASCADE) 
	private List<Theater> theTheater;

	public long getCityId() {
		return cityId;
	}

	public void setCityId(long cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCityPincode() {
		return cityPincode;
	}

	public void setCityPincode(String cityPincode) {
		this.cityPincode = cityPincode;
	}

	public String getCityState() {
		return cityState;
	}

	public void setCityState(String cityState) {
		this.cityState = cityState;
	}

	public List<Theater> getTheTheater() {
		return theTheater;
	}

	public void setTheTheater(List<Theater> theTheater) {
		this.theTheater = theTheater;
	}

}
