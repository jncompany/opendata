package com.mhkim.opendata.entity;

import static java.time.LocalDateTime.now;
import static org.apache.commons.lang3.ObjectUtils.defaultIfNull;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.PersistenceConstructor;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "flight")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long flightId;

    @Column(length = 100)
    private String airlineNm;

    @Column(length = 30)
    private String arrAirportNm;

    @Column(length = 14)
    private String arrPlandTime;

    @Column(length = 30)
    private String depAirportNm;

    @Column(length = 14)
    private String depPlandTime;

    @Column(length = 9)
    private String vihicleId;

    @Column
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime modifiedAt;

    @Builder
    @PersistenceConstructor
    public Flight(Long flightId, String airlineNm, String arrAirportNm, String arrPlandTime, String depAirportNm,
            String depPlandTime, String vihicleId, LocalDateTime createdAt, LocalDateTime modifiedAt) {

        this.flightId = flightId;
        this.airlineNm = airlineNm;
        this.arrAirportNm = arrAirportNm;
        this.arrAirportNm = arrPlandTime;
        this.depAirportNm = depAirportNm;
        this.depPlandTime = depPlandTime;
        this.vihicleId = vihicleId;
        this.createdAt = defaultIfNull(createdAt, now());
        this.modifiedAt = defaultIfNull(modifiedAt, now());
    }

}
