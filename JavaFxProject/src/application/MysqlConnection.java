package application;

import java.sql.Connection;
import java.sql.DriverManager;


public class MysqlConnection {

    public static Connection connectDb() {

        try {

            Class.forName("com.mysql.jdbc.Driver");

            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/projectjava", "root", ""); // root is the default username while empty or null to the password
            return connect;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

        // NOW LETS OPEN OUR XAMPP : ) 
    }

}