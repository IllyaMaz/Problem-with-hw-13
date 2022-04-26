package com.company;

public class Address {
    String street;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Geo getGeo() {
        return geo;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }

    String suite;
    String city;
    String zipcode;
    Geo geo = new Geo();

    @Override
    public String toString() {
        return "{" + "\n"+
                "    street=" + street + ",\n" +
                "    suite=" + suite + ",\n" +
                "    city=" + city + ",\n" +
                "    zipcode=" + zipcode + ",\n" +
                "    geo" + geo + "\n"+
                 "  },\n";
    }
}
