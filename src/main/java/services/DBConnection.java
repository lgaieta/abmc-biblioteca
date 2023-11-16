package services;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class DBConnection {
    String user = "root";
    String password = "982006";
    String host = "localhost";
    String port = "3306";
    String database_name = "biblioteca_tecnica";
    String connection_url = "jdbc:mysql://" + host + ":" + port + "/" + database_name;
    public Connection connection = null;

    public void open() {
        try {
            connection = DriverManager.getConnection(connection_url, user, password);
        } catch (SQLException ex) {
            System.out.println(ex); 
        }
    }
    
    public void close() {
        try {
            connection.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
