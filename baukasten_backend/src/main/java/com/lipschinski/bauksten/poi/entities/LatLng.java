package com.lipschinski.bauksten.poi.entities;

import lombok.Data;

@Data
public class LatLng {

    String lat;
    String lng;

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }
}
