package com.example.projektzaispit.models;

public class locations extends Table{

    @Entity(type = "INTEGER", size = 32, primary = true)
    int id;

    @Entity(type = "VARCHAR", size=50)
    String streetAddress;

    @Entity(type = "VARCHAR", size=50)
    String postalCode;

    @Entity(type = "VARCHAR", size=50)
    String city;

    @ForeignKey(table = "countries", attribute = "id")
    @Entity(type = "INTEGER", size = 32)
    int countries_id;

    public int getId() {
        return id;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCountries_id() {
        return countries_id;
    }

    public void setCountries_id(int countries_id) {
        this.countries_id = countries_id;
    }
}
