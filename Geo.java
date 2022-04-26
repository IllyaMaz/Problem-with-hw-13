package com.company;

public class Geo {
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

    String lat;
    String lng;

    @Override
    public String toString() {
        return "{" +"\n"+
                "      lat=" + lat + ",\n" +
                "      lng=" + lng + "\n" +
                "    }";
    }
}
