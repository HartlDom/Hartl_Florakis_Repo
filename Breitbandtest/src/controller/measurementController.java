package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import model.DatabaseCommunication;
import model.Main;
import model.Quellklassen.NetworkMeasurement;
import model.Quellklassen.NetworkTest;

import java.util.ArrayList;

public class measurementController {

    NetworkMeasurement networkMeasurement;
    ArrayList<NetworkTest> tests;
    private Main model;
    @FXML
    private Label headline;

    @FXML
    private LineChart lineChart;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;

    @FXML
    private Label pc1;

    @FXML
    private Label pc2;

    @FXML
    void goback(ActionEvent event) {
        try {
            model.showResults();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setList(NetworkMeasurement networkMeasurement) {
        this.networkMeasurement = networkMeasurement;
        tests = networkMeasurement.getTests();
        DatabaseCommunication dc = new DatabaseCommunication();

        pc1.setText(networkMeasurement.getClients().toString().split(";")[0]);
        pc2.setText(networkMeasurement.getClients().toString().split(";")[1]);

        headline.setText("Messung vom "+networkMeasurement.getDate());

        showonChart();
    }

    private void showonChart() {
        XYChart.Series series = new XYChart.Series();
        System.out.println("Size: " +tests.size());
        for (int i = 0; i < tests.size(); i++) {
            series.getData().add(new XYChart.Data(tests.get(i).getTimestamp(), tests.get(i).getNetworkSpeed()));
        }

        lineChart.getData().add(series);
    }

    public void setModel(Main model) {
        this.model = model;
    }




}
