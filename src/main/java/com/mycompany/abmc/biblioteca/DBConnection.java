package com.mycompany.abmc.biblioteca;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class DBConnection {
    String user = "root";
    String password = "";
    String host = "localhost";
    String port = "3306";
    String database_name = "biblioteca_tecnica";
    String connection_url = "jdbc:mysql://" + host + ":" + port + "/" + database_name;
    Connection connection = null;

    public void open() {
        try {
            connection = DriverManager.getConnection(connection_url, user, password);
        } catch (SQLException ex) {
            System.out.println(ex); 
        }
    }
}
