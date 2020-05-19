package model;

/**
 * Created by Florakis Mathias on IntelliJ IDEA 2019.2.5
 */
public class Measurement {
    private int speed;
    private String timestamp;

    public Measurement(int speed, String timestamp) {
        this.speed = speed;
        this.timestamp = timestamp;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Measurement{" +
                "speed=" + speed +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}


