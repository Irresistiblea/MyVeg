package com.myveg.demo.domain;

public class Location {
    long id;
    String location_name;
    float lat;
    float lon;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLocation_name() {
        return location_name;
    }

    public void setLocation_name(String location_name) {
        this.location_name = location_name;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", location_name='" + location_name + '\'' +
                ", lat=" + lat +
                ", lon=" + lon +
                '}';
    }
}
