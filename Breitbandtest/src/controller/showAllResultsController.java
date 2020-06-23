package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import model.Main;
import model.Quellklassen.NetworkMeasurement;

import java.util.ArrayList;

public class showAllResultsController {
    private Main model;
    private ObservableList list;
    private ArrayList<NetworkMeasurement> temp;
    private int selected;

    @FXML
    private ListView<?> listView;

    @FXML
    void goback(ActionEvent event) {
        model.back();
    }


    public void printToListView() {

            listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            list = FXCollections.observableArrayList(model.getAllNetworkMeasurements());
            listView.setItems(list);

    }

    @FXML
    void showDetails(ActionEvent event) {

        try {
            selected = listView.getSelectionModel().getSelectedIndex();

            NetworkMeasurement t = (NetworkMeasurement) list.get(selected);


            model.showDetails(t);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void setModel(Main model) {
        this.model = model;
    }
}
