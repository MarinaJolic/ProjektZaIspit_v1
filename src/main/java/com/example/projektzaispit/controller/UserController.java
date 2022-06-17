package com.example.projektzaispit.controller;

import com.example.projektzaispit.Program;
import com.example.projektzaispit.models.Table;
import com.example.projektzaispit.models.departments;
import com.example.projektzaispit.models.employees;
import com.example.projektzaispit.models.jobs;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class UserController implements Initializable {



    @FXML
    TextField firstNameTxt;

    @FXML
    TextField lastNameTxt;

    @FXML
    TextField emailTxt;

    @FXML
    TextField phoneNumberTxt;

    @FXML
    ComboBox<jobs> jobsCbx;

    @FXML
    ComboBox<departments> depCbx;

    @FXML
    TableColumn TableColumnFirstName;

    @FXML
    TableColumn TableColumnLastName;

    @FXML
    TableColumn TableColumnEmail;

    @FXML
    TableColumn TableColumnPhoneNumber;

    @FXML
    TableColumn TableColumnJobsCbx;

    @FXML
    TableColumn TableColumnDepCbx;

    @FXML
    TableView<employees> tableViewEmployee;

    @FXML
    Button DeleteBtn;

    employees selectedEmployees;

    @FXML
    protected void SelectedEmployees (){
        this.selectedEmployees= this.tableViewEmployee.getSelectionModel().getSelectedItem();
        this.DeleteBtn.setDisable(false);
        this.firstNameTxt.setText(this.selectedEmployees.getFirstName());
        this.lastNameTxt.setText(this.selectedEmployees.getLastName());
        this.emailTxt.setText(this.selectedEmployees.getEmail());
        this.phoneNumberTxt.setText(this.selectedEmployees.getPhoneNumber());
        /*this.jobsCbx.setValue(this.selectedEmployees.getJobs_id());
        this.depCbx.setValue(this.selectedEmployees.getDepartments_id());*/
    }


    @FXML
    protected void deleteEmpoyees () throws Exception{
        if(this.selectedEmployees != null){
            this.selectedEmployees.delete();
            this.fillEmployee();
        }
    }

    @FXML
    protected void saveEmployees() throws Exception {
        if(this.selectedEmployees == null) {
            employees newEmployees = new employees();
            newEmployees.setFirstName(this.firstNameTxt.getText());
            newEmployees.setLastName(this.lastNameTxt.getText());
            newEmployees.setEmail(this.emailTxt.getText());
            newEmployees.setPhoneNumber(this.phoneNumberTxt.getText());
            newEmployees.setJobs_id(this.jobsCbx.getValue().getId());
            newEmployees.setDepartments_id(this.depCbx.getValue().getId());
            newEmployees.save();
        }else{
            this.selectedEmployees.setFirstName(this.firstNameTxt.getText());
            this.selectedEmployees.setLastName(this.lastNameTxt.getText());
            this.selectedEmployees.setEmail(this.emailTxt.getText());
            this.selectedEmployees.setPhoneNumber(this.phoneNumberTxt.getText());
            this.selectedEmployees.setJobs_id(this.jobsCbx.getValue().getId());
            this.selectedEmployees.setDepartments_id(this.depCbx.getValue().getId());
            this.selectedEmployees.update();
            this.selectedEmployees=null;
        }
        this.DeleteBtn.setDisable(true);
        this.fillEmployee();
        this.firstNameTxt.setText("");
        this.lastNameTxt.setText("");
        this.emailTxt.setText("");
        this.phoneNumberTxt.setText("");
        this.jobsCbx.setValue(null);
        this.depCbx.setValue(null);

    }

    @FXML
    public void  natrag (ActionEvent evt){
        Stage stage =(Stage) ((Node) evt.getSource()).getScene().getWindow();
        Program.swapScene(stage,"intro-view.fxml");
    }

    private void fillEmployee() {
        try {
            ObservableList<employees> employees = (ObservableList<employees>)FXCollections.observableList(Table.list(employees.class));
            this.tableViewEmployee.setItems(employees);
        } catch (Exception e) {
            System.out.println("Nastala je greška: " + e.getMessage());
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            this.jobsCbx.setItems((ObservableList<jobs>) FXCollections.observableArrayList(Table.list(jobs.class)));
            this.depCbx.setItems((ObservableList<departments>)FXCollections.observableArrayList(Table.list(departments.class)));
        } catch (Exception e) {
            e.printStackTrace();
        }


        this.TableColumnFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        this.TableColumnLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        this.TableColumnEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        this.TableColumnPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        this.TableColumnJobsCbx.setCellValueFactory(new PropertyValueFactory<>("jobs_id"));
        this.TableColumnDepCbx.setCellValueFactory(new PropertyValueFactory<>("departments_id"));
        this.fillEmployee();

    }


}

