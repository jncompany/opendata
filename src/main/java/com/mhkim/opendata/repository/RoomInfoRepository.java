package com.mhkim.opendata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mhkim.opendata.entity.RoomInfo;

@Repository
public interface RoomInfoRepository extends JpaRepository<RoomInfo, Long> {
}
