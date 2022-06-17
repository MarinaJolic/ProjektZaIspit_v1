package com.example.projektzaispit.controller;

import com.example.projektzaispit.Program;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class IntroController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void userAdministration (ActionEvent evt){
        Stage stage=(Stage) ((Node) evt.getSource()).getScene().getWindow();
        Program.swapScene(stage, "user-view.fxml", "Administracija korisnika");
    }
}