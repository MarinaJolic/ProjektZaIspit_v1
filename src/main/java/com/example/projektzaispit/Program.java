package com.example.projektzaispit;

import com.example.projektzaispit.models.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class Program extends Application {
    @Override


    public void start(Stage stage) throws Exception {

/*
        try {
            Table.create(regions.class);
            Table.create(jobs.class);
            Table.create(countries.class);
            Table.create(locations.class);
            Table.create(departments.class);
            Table.create(employees.class);
        } catch (SQLException e) {
            System.out.println("Nastala je greška" + e.getMessage());
        }

        jobs jobs= new jobs();
        jobs.setJobTitle("QA enginers");
        jobs.setMinSalary(1000);
        jobs.setMaxSalary(10000);
        jobs.save();

        jobs jobs= new jobs();
        jobs.setJobTitle("Software Developer");
        jobs.setMinSalary(8000);
        jobs.setMaxSalary(10000);
        jobs.save();

        jobs jobs= new jobs();
        jobs.setJobTitle("Mrežni inžinjer");
        jobs.setMinSalary(5000);
        jobs.setMaxSalary(8000);
        jobs.save();

        jobs jobs= new jobs();
        jobs.setJobTitle("Agent za tehničku podršku");
        jobs.setMinSalary(3000);
        jobs.setMaxSalary(5000);
        jobs.save();


        regions regions=new regions();
        regions.setRegion_name("Zadarska županija");
        regions.save();

        countries countries=new countries();
        countries.setCountryName("Hrvatska");
        countries.setRegions_id(1);
        countries.save();

        locations locations= new locations();
        locations.setStreetAddress("kralja Tvrtka 12");
        locations.setPostalCode("10001");
        locations.setCity("Zadar");
        locations.setCountries_id(1);
        locations.save();

        departments departments= new departments();
        departments.setDepartmentsName("IT");
        departments.setLocations_id(1);
        departments.save();

        departments departments= new departments();
        departments.setDepartmentsName("Tehnička podrška");
        departments.setLocations_id(1);
        departments.save();

        departments departments= new departments();
        departments.setDepartmentsName("Sigurnost mreža");
        departments.setLocations_id(1);
        departments.save();

        departments departments= new departments();
        departments.setDepartmentsName("Software");
        departments.setLocations_id(1);
        departments.save();

*/
        FXMLLoader fxmlLoader = new FXMLLoader(Program.class.getResource("intro-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void swapScene (Stage stage, String viewName, String title){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Program.class.getResource(viewName));
            Scene scene = new Scene(fxmlLoader.load(), 350, 270);
            stage.setTitle(title);
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Nastala je pogreška: " + e.getMessage());
        }
    }

    public static void swapScene (Stage stage, String viewName){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Program.class.getResource(viewName));
            Scene scene = new Scene(fxmlLoader.load(), 350, 270);
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Nastala je pogreška: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch();
    }
}