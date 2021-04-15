package com.mhkim.opendata.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class FlightItem {

    private String airlineNm;
    private String arrAirportNm;
    private String arrPlandTime;
    private String depAirportNm;
    private String depPlandTime;
    private String vihicleId;

}
