package com.mhkim.opendata.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mhkim.opendata.service.FlightService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/opendata")
public class OpenDataController {

    private final FlightService flightService;

    @GetMapping(value = "/flight/info")
    public void getFlight() {

        flightService.getFlightInfo();
    }

}