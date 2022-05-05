package ConnectJbdc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        System.out.println("_____ PostgreSQL " + "JDBC Connection Testing-----");

        try {

            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {


            System.out.println(" Where is your PostgreSQL JDBC Driver ? " + "Include in your library!");
            e.printStackTrace();
            return;
        }
        Connection connection;

        try {

            connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/mydatabase",
                    "myuser","1234");

        } catch (SQLException e) {
            System.out.println("Connection failed!  Check output console");
            e.printStackTrace();
            return;
        }
        if (connection !=null){
            System.out.println("You made it, take control your database now!");
        }
        else {
            System.out.println("Failed to make connection!");
        }
    }
}
