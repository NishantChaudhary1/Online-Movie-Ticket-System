package com.sprint.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sprint.entity.Bookings;
import com.sprint.entity.Show;

@Repository
public interface BookingsRepository extends JpaRepository<Bookings, Long>{

	public List<Bookings> findByShow(Show show);
}
