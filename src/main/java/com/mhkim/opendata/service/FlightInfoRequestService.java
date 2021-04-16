package com.mhkim.opendata.service;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;

import com.mhkim.opendata.config.OpendataProp;
import com.mhkim.opendata.dto.FlightInfoItems;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class FlightInfoRequestService {

    private final WebClient tagoWebClient;
    private final OpendataProp opendataProp;

    public Mono<FlightInfoItems> requestFlightInfo(int pageNo) {
        MultiValueMap<String, String> queryParams = getQueryParams(pageNo);
        
        return tagoWebClient.get()
                .uri(uriBuilder -> uriBuilder.path(opendataProp.getServiceUrl())
                        .queryParams(queryParams)
                        .build()
                )
                .accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(String.class)
                .flatMap(data -> Mono.just(new FlightInfoItems(data)));
    }

    private MultiValueMap<String, String> getQueryParams(int pageNo) {
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();

        queryParams.add("serviceKey", opendataProp.getServiceKey());
        queryParams.add("numOfRows", opendataProp.getNumOfRows());
        queryParams.add("pageNo", String.valueOf(pageNo));
        queryParams.add("depAirportId", "NAARKPC");
        queryParams.add("arrAirportId", "NAARKSS");
        queryParams.add("depPlandTime", "20210521");

        return queryParams;
    }

}
