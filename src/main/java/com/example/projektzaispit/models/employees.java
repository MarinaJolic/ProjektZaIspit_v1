package com.example.projektzaispit.models;

public class employees extends Table{

    @Entity(type = "INTEGER", size = 32, primary = true)
    int id;

    @Entity(type = "VARCHAR", size=50)
    String firstName;

    @Entity(type = "VARCHAR", size=50)
    String lastName;

    @Entity(type = "VARCHAR", size=50)
    String email;

    @Entity(type = "VARCHAR", size=20)
    String phoneNumber;

    @ForeignKey(table = "jobs", attribute = "id")
    @Entity(type = "INTEGER", size = 32)
    int jobs_id;

    @ForeignKey(table = "departments", attribute = "id")
    @Entity(type = "INTEGER", size = 32)
    int departments_id;

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getJobs_id() {
        return jobs_id;
    }

    public void setJobs_id(int jobs_id) {
        this.jobs_id = jobs_id;
    }

    public int getDepartments_id() {
        return departments_id;
    }

    public void setDepartments_id(int departments_id) {
        this.departments_id = departments_id;
    }
}

