package com.example.projektzaispit.models;

public class countries extends Table{

    @Entity(type = "INTEGER", size = 32, primary = true)
    int id;

    @Entity(type = "VARCHAR", size=50)
    String countryName;

    @ForeignKey(table = "regions", attribute = "id")
    @Entity(type = "INTEGER", size = 32)
    int regions_id;

    public int getId() {
        return id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getRegions_id() {
        return regions_id;
    }

    public void setRegions_id(int regions_id) {
        this.regions_id = regions_id;
    }
}
