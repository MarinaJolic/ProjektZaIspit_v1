package com.example.projektzaispit.models;

public class departments extends Table{

    @Entity(type = "INTEGER", size = 32, primary = true)
    int id;

    @Entity(type = "VARCHAR", size=50)
    String departmentsName;

    @ForeignKey(table = "locations", attribute = "id")
    @Entity(type = "INTEGER", size = 32)
    int locations_id;

    public int getId() {
        return id;
    }

    public String getDepartmentsName() {
        return departmentsName;
    }

    public void setDepartmentsName(String departmentsName) {
        this.departmentsName = departmentsName;
    }

    public int getLocations_id() {
        return locations_id;
    }

    public void setLocations_id(int locations_id) {
        this.locations_id = locations_id;
    }

    @Override
    public String toString(){return this.departmentsName;}
}
