package model.Quellklassen;

import java.util.ArrayList;

/**
 * Created by Florakis Mathias on IntelliJ IDEA 2019.2.5
 */
public class NetworkMeasurement {
    private int measurementID;
    private Clients clients;
    private ArrayList<NetworkTest> tests;

    public NetworkMeasurement(int measurementID, Clients clients, ArrayList<NetworkTest> tests) {
        this.measurementID = measurementID;
        this.clients = clients;
        this.tests = tests;
    }

    public int getMeasurementID() {
        return measurementID;
    }

    public void setMeasurementID(int measurementID) {
        this.measurementID = measurementID;
    }

    public Clients getClients() {
        return clients;
    }

    public void setClients(Clients clients) {
        this.clients = clients;
    }

    public ArrayList<NetworkTest> getTests() {
        return tests;
    }

    public void setTests(ArrayList<NetworkTest> tests) {
        this.tests = tests;
    }

    @Override
    public String toString() {
        return "Test vom 25.2.2020";
    }
}
