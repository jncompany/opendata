package com.mhkim.opendata.dto;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class FlightItems {

    private List<FlightItem> flightItems;
    private int numOfRows;
    private int pageNo;
    private int totalCount;

    public FlightItems(String jsonData) {
        JsonObject jsonObject = new Gson().fromJson(jsonData, JsonObject.class);
        JsonObject bodyObject = jsonObject.get("response").getAsJsonObject().get("body").getAsJsonObject();

        String itemJson = bodyObject.get("items").getAsJsonObject().get("item").toString();
        this.flightItems = new Gson().fromJson(itemJson, new TypeToken<List<FlightItem>>() {}.getType());

        this.numOfRows = bodyObject.get("numOfRows").getAsInt();
        this.pageNo = bodyObject.get("pageNo").getAsInt();
        this.totalCount = bodyObject.get("totalCount").getAsInt();
    }

}