package com.mhkim.opendata.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mhkim.opendata.entity.RoomInfo;
import com.mhkim.opendata.repository.RoomInfoRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RoomInfoService {

    private final RoomInfoRepository roomInfoRepository;

    public Optional<RoomInfo> addRoomInfo(RoomInfo roomInfo) {
        return Optional.of(roomInfoRepository.save(roomInfo));
    }

}
