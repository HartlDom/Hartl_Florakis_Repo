package controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import model.Main;

public class mainMenueController {
    private Main mainmodel;

    @FXML
    void doTest(ActionEvent event) {
        try {
            mainmodel.createTest();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void showResults(ActionEvent event) {
        try {
            mainmodel.showResults();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setMainmodel(Main mainmodel) {
        this.mainmodel = mainmodel;
    }
}
