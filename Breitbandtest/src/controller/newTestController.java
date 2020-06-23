package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import model.Main;
import model.ReadProperties;

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
            String os = System.getProperties().getProperty("os.name");

            if (!os.contains("Windows")) {
                ReadProperties rp = new ReadProperties();

                String cmd = rp.readCommand();

                Process proc = Runtime.getRuntime().exec(cmd);

                BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));

                String line = "";
                while ((line = reader.readLine())!= null) {
                    System.out.println(line);
                }

                proc.waitFor();
            }

            else {
                System.out.println("Du musst auf Linux sein");
            }
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
