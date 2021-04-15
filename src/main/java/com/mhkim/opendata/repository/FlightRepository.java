package com.mhkim.opendata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mhkim.opendata.entity.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
}
