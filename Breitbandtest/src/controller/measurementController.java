package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import model.Main;
import model.Measurement;

import java.util.ArrayList;

public class measurementController {

    ArrayList<Measurement> t;
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
    void goback(ActionEvent event) {

    }

    public void setList(ArrayList<Measurement> t) {
        this.t = t;

        showonChart();
    }

    private void showonChart() {
        XYChart.Series series = new XYChart.Series();
        System.out.println("Size: " +t.size());
        for (int i = 0; i < t.size(); i++) {
            series.getData().add(new XYChart.Data(t.get(i).getTimestamp(), t.get(i).getSpeed()));
        }

        lineChart.getData().add(series);
    }

    public void setModel(Main model) {
        this.model = model;
    }




}
