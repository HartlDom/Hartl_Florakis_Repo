package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Florakis Mathias on IntelliJ IDEA 2019.2.5
 */
public class Test {
    private ArrayList<Measurement> test = new ArrayList<>();

    public void addMeasurementToTest(Measurement m) {
        test.add(m);
    }

    public ArrayList<Measurement> getMeasurements() {
        return test;
    }

    @Override
    public String toString() {
        return "Test vom 25.2.2020";
    }
}
