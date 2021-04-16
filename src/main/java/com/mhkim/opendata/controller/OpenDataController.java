package com.mhkim.opendata.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mhkim.opendata.service.FlightInfoService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/opendata")
public class OpenDataController {

    private final FlightInfoService flightService;

    @PostMapping(value = "/flightinfo/sync")
    public void syncFlightInfo() {
        flightService.syncFlightInfo();
    }

}
