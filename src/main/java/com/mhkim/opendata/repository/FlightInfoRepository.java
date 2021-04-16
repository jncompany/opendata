package com.mhkim.opendata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mhkim.opendata.entity.FlightInfo;

@Repository
public interface FlightInfoRepository extends JpaRepository<FlightInfo, Long> {
}
