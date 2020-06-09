package model;

import model.Quellklassen.Clients;
import model.Quellklassen.NetworkMeasurement;
import model.Quellklassen.NetworkTest;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Florakis Mathias on IntelliJ IDEA 2019.2.5
 */

public class DatabaseCommunication {
    ReadProperties rp = new ReadProperties();
    public void setDefaultSchema() {
        try(Connection con = DriverManager.getConnection(rp.readURL(), rp.readUser(), rp.readPwd())) {
            PreparedStatement prep = con.prepareStatement("USE ?");

            prep.setString(1, rp.readSchema());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public ArrayList<NetworkMeasurement> getAllMeasurements() {

        try(Connection con = DriverManager.getConnection(rp.readURL(), rp.readUser(), rp.readPwd())) {
            ArrayList<NetworkMeasurement> allMeasurements= new ArrayList<>();

            PreparedStatement prep = con.prepareStatement("SELECT * FROM ndb.networkmeasurements;",ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet measurements = prep.executeQuery();
            while (measurements.next()) {
                   ArrayList<NetworkTest> testFromThis = new ArrayList<NetworkTest>();
                   ArrayList<Clients> clientsFromThis = new ArrayList<Clients>();
                   int clientID = measurements.getInt(3);
                   int testID = measurements.getInt(4);


                   prep = con.prepareStatement("Select * from networktest where testID = ?",ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                   prep.setInt(1, testID);

                   ResultSet tests = prep.executeQuery();

                   while (tests.next()) {
                       testFromThis.add(new NetworkTest(tests.getInt(1), tests.getFloat(2), tests.getFloat(3), tests.getFloat(4), tests.getString(5)));
                   }

                   prep = con.prepareStatement("Select * from clients where clientsID = ?",ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                   prep.setInt(1, clientID);
                   ResultSet clients = prep.executeQuery();


                   clients.first();
                       Clients clients1 = new Clients(clients.getString(2), clients.getString(3));


                   allMeasurements.add(new NetworkMeasurement(measurements.getInt(1), clients1, testFromThis));

            }

            return allMeasurements;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
