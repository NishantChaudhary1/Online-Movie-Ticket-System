package com.sprint.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.entity.City;
import com.sprint.entity.Theater;

@Repository
public interface TheaterRepository extends JpaRepository<Theater, Long> {

	public List<Theater> findByCity(City c);
}