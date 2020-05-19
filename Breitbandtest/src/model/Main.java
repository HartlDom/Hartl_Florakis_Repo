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
import java.util.ArrayList;

public class Main extends Application {
    Stage primaryStage = null;
    private ArrayList<Test> allTests;


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

    public void showDetails(ArrayList<Measurement> t) throws Exception{
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

    @Override
    public void init() throws Exception {
        allTests = new ArrayList<Test>();
        Test t = new Test();

        //TODO hier wird von der Datenbank eingelesen, diese Eingaben per Hand dienen zum Veranschaulichung
        t.addMeasurementToTest(new Measurement(40, "08:30"));
        t.addMeasurementToTest(new Measurement(35, "09:00"));
        t.addMeasurementToTest(new Measurement(30, "09:30"));
        t.addMeasurementToTest(new Measurement(25, "10:00"));
        t.addMeasurementToTest(new Measurement(20, "10:30"));
        allTests.add(t);


    }

    public ArrayList<Test> getAllTests() {
        return allTests;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
