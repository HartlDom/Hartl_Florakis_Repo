package model;

import controller.mainMenueController;
import controller.measurementController;
import controller.newTestController;
import controller.showAllResultsController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Quellklassen.NetworkTest;
import model.Quellklassen.NetworkMeasurement;

import java.util.ArrayList;

public class Main extends Application {
    Stage primaryStage = null;
    DatabaseCommunication dc = new DatabaseCommunication();
    private ArrayList<NetworkMeasurement> allNetworkMeasurements;


    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../view/mainmenue.fxml"));
        Parent root = loader.load();
        mainMenueController mainController = loader.getController();

        mainController.setMainmodel(this);

        primaryStage.setTitle("Bandbreitentester");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }

    @Override
    public void init() throws Exception {
        dc.setDefaultSchema();
        allNetworkMeasurements = dc.getAllMeasurements();
    }

    public void createTest() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../view/newTest.fxml"));
        Parent root = loader.load();
        newTestController newTest = loader.getController();

        newTest.setTestModel(this);
        primaryStage.setTitle("Neuer Test");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void showResults() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../view/showAllResults.fxml"));
        Parent root = loader.load();
        showAllResultsController showResults = loader.getController();

        showResults.setModel(this);
        showResults.printToListView();
        primaryStage.setTitle("Alle Ergebnisse");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }

    public void showDetails(ArrayList<NetworkTest> t) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../view/measurement.fxml"));
        Parent root = loader.load();
        measurementController measurement = loader.getController();

        measurement.setModel(this);
        measurement.setList(t);
        primaryStage.setTitle("Test");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void back() {
        try {
            start(primaryStage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public ArrayList<NetworkMeasurement> getAllNetworkMeasurements() {
        return allNetworkMeasurements;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
