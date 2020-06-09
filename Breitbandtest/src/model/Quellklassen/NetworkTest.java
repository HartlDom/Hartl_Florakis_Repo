package model.Quellklassen;

/**
 * Created by Florakis Mathias on IntelliJ IDEA 2019.2.5
 */
public class NetworkTest {
    private int testID;
    private float networkSpeed;
    private float transferedValue;
    private float bandwith;
    private String timestamp;

    public NetworkTest(int testID, float networkSpeed, float transferedValue, float bandwith, String timestamp) {
        this.testID = testID;
        this.networkSpeed = networkSpeed;
        this.transferedValue = transferedValue;
        this.bandwith = bandwith;
        this.timestamp = timestamp;
    }

    public int getTestID() {
        return testID;
    }

    public void setTestID(int testID) {
        this.testID = testID;
    }

    public float getNetworkSpeed() {
        return networkSpeed;
    }

    public void setNetworkSpeed(float networkSpeed) {
        this.networkSpeed = networkSpeed;
    }

    public float getTransferedValue() {
        return transferedValue;
    }

    public void setTransferedValue(float transferedValue) {
        this.transferedValue = transferedValue;
    }

    public float getBandwith() {
        return bandwith;
    }

    public void setBandwith(float bandwith) {
        this.bandwith = bandwith;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "NetworkTest{" +
                "testID=" + testID +
                ", networkSpeed=" + networkSpeed +
                ", transferedValue=" + transferedValue +
                ", bandwith=" + bandwith +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}


