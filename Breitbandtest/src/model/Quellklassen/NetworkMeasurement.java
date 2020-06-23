package model.Quellklassen;

import model.DatabaseCommunication;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Florakis Mathias on IntelliJ IDEA 2019.2.5
 */
public class NetworkMeasurement {
    private int measurementID;
    private Date date;
    private Clients clients;
    private ArrayList<NetworkTest> tests;

    public NetworkMeasurement(int measurementID, Date date, Clients clients, ArrayList<NetworkTest> tests) {
        this.measurementID = measurementID;
        this.date = date;
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

    public ArrayList<NetworkTest> getTests() { return tests; }

    public void setTests(ArrayList<NetworkTest> tests) {
        this.tests = tests;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Messung vom: "+this.date;
    }
}
