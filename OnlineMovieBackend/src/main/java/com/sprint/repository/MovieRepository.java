package com.sprint.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{


}