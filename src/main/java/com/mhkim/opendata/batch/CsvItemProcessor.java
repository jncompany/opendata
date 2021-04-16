package com.mhkim.opendata.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Configuration;

import com.mhkim.opendata.dto.RoomInfoDto;
import com.mhkim.opendata.entity.RoomInfo;

@Configuration
public class CsvItemProcessor implements ItemProcessor<RoomInfoDto, RoomInfo> {

    @Override
    public RoomInfo process(RoomInfoDto item) throws Exception {
        return RoomInfo.builder()
                .name(item.getName())
                .count(item.getCount())
                .checkIn(item.getCheckIn())
                .checkOut(item.getCheckOut())
                .build();
    }

}
