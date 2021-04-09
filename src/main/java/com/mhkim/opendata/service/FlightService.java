package com.mhkim.opendata.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.DefaultUriBuilderFactory.EncodingMode;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class FlightService {

    public static final String SERVICE_KEY = "service_key";

    public void getFlightInfo() {

        DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory("http://openapi.tago.go.kr/openapi/service");
        factory.setEncodingMode(EncodingMode.VALUES_ONLY);

        WebClient client = WebClient.builder().uriBuilderFactory(factory)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

        Mono<String> result = client.get()
                .uri(uriBuilder -> uriBuilder.path("/DmstcFlightNvgInfoService/getFlightOpratInfoList")
                        .queryParam("serviceKey", SERVICE_KEY)
                        .queryParam("numOfRows", "10")
                        .queryParam("pageNo", "1")
                        .queryParam("depAirportId", "NAARKSS")
                        .queryParam("arrAirportId", "NAARKPC")
                        .queryParam("depPlandTime", "20210601")
                        .queryParams(null)
                        //.queryParam("airlineId", "JJA")
                        .build()
                ).accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(String.class);

        result.subscribe(data -> log.debug("{}", data));
    }

}
