/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.Book;
import entities.Member;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 *
 * @author Luciano
 */
public class MemberStore {

    public static Member get(DBConnection db, String dni) {
        String query = "SELECT * FROM socio WHERE dni = ?";
        db.open();

        try {
            PreparedStatement statement = db.connection.prepareStatement(query);
            statement.setString(1, dni);
            
            ResultSet result = statement.executeQuery();
            result.next();

            String name = result.getString("nombre");
            String surname = result.getString("apellido");
            
            Member member = new Member(dni, name, surname);

            return member;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    public static ResultSet getAll(DBConnection db) {
        try {
            db.open();

            String query = "SELECT * FROM socio";

            PreparedStatement statement = db.connection.prepareStatement(query);
            ResultSet result = statement.executeQuery();

            return result;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public static void save(DBConnection db, Member member) {
        String query = "INSERT INTO socio (dni, nombre, apellido) VALUES (?, ?, ?)";

        try {
            db.open();
            PreparedStatement statement = db.connection.prepareStatement(query);
            statement.setString(1, member.dni);
            statement.setString(2, member.name);
            statement.setString(3, member.surname);
            statement.execute();
            db.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public static void delete(DBConnection db, String dni) {
        String query = "DELETE FROM socio WHERE dni = ?";
        try {
            PreparedStatement statement = db.connection.prepareStatement(query);
            statement.setString(1, dni);
            statement.execute();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
