package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.entity.Movie;
@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer>{

}
