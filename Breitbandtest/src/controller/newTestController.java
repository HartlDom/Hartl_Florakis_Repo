package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import model.Main;

import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 * Created by Florakis Mathias on IntelliJ IDEA 2019.2.5
 */

public class newTestController {
    private Main testModel;

    @FXML
    private TextField ownIP;

    @FXML
    private TextField targetIP;

    @FXML
    private TextField period;

    @FXML
    private ChoiceBox<?> unit;

    @FXML
    void doTest(ActionEvent event) {
        try{
            String command = "dir";
            String input;
            Process p = Runtime.getRuntime().exec(command);
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((input = br.readLine()) != null) {
                //TODO Testen was hier heirrein kommt
            }
            p.waitFor();
            p.destroy();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void goback(ActionEvent event) {
        testModel.back();
    }

    public void setTestModel(Main testModel) {
        this.testModel = testModel;
    }
}
