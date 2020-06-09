package model;

import java.io.*;

/**
 * Created by Florakis Mathias on IntelliJ IDEA 2019.2.5
 */
public class ReadProperties {

    public String readURL() {
        try(BufferedReader br = new BufferedReader(new FileReader(new File("./src/properties.txt")))) {
            String url = "";
             url = br.readLine().split(": ")[1];
            return url;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String readSchema() {
        try(BufferedReader br = new BufferedReader(new FileReader(new File("./src/properties.txt")))) {
            String schema = "";

            br.readLine();
            schema = br.readLine().split(": ")[1];
            return schema;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String readUser() {
        try(BufferedReader br = new BufferedReader(new FileReader(new File("./src/properties.txt")))) {
            String user = "";

            br.readLine();
            br.readLine();
            user = br.readLine().split(": ")[1];
            return  user;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String readPwd() {
        try(BufferedReader br = new BufferedReader(new FileReader(new File("./src/properties.txt")))) {
            String pwd = "";

            br.readLine();
            br.readLine();
            br.readLine();

            pwd = br.readLine().split(": ")[1];
            return  pwd;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
