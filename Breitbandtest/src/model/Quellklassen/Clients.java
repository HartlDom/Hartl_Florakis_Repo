package model.Quellklassen;

/**
 * Created by Florakis Mathias on IntelliJ IDEA 2019.2.5
 */
public class Clients {
    private String ip1;
    private String ip2;

    public Clients(String ip1, String ip2) {
        this.ip1 = ip1;
        this.ip2 = ip2;
    }

    public String getIp1() {
        return ip1;
    }

    public void setIp1(String ip1) {
        this.ip1 = ip1;
    }

    public String getIp2() {
        return ip2;
    }

    public void setIp2(String ip2) {
        this.ip2 = ip2;
    }

    @Override
    public String toString() {
        return ip1 + ";" + ip2;
    }
}
