package com.mhkim.opendata.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mhkim.opendata.dto.FlightItem;
import com.mhkim.opendata.dto.FlightItems;
import com.mhkim.opendata.entity.Flight;
import com.mhkim.opendata.repository.FlightRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
@RequiredArgsConstructor
@Service
public class FlightService {

    private final FlightRepository flightRepository;
    private final FlightRequestService flightRequestService;

    public void syncFlight() {

        flightRequestService.requestFlight(1).subscribe(flightInfo -> {
            log.debug("flightInfo: {}", flightInfo);

            int total = flightInfo.getTotalCount();
            int numOfRows = flightInfo.getNumOfRows();
            int maxPage = total / numOfRows;
            if (total % numOfRows > 0)
                maxPage++;

            Flux<FlightItems> flightItems = Flux.range(1, maxPage).flatMap(pageNo -> {
                log.debug("pageNo: {}", pageNo);
                return flightRequestService.requestFlight(pageNo);
            });

            flightItems.subscribe(items ->
                items.getFlightItems().forEach(item -> {
                    log.debug("item: {}", items.toString());
                    addBoard(item);
                })
            );
        });
    }

    public Optional<Flight> addBoard(FlightItem item) {
        Flight flight = Flight.builder()
                .airlineNm(item.getAirlineNm())
                .arrAirportNm(item.getArrAirportNm())
                .arrPlandTime(item.getArrPlandTime())
                .depAirportNm(item.getDepAirportNm())
                .depPlandTime(item.getDepPlandTime())
                .vihicleId(item.getVihicleId())
                .build();
        flightRepository.save(flight);
        return Optional.of(flightRepository.save(flight));
    }

}
