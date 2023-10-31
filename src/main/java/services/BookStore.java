/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.Book;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 *
 * @author Luciano
 */
public class BookStore {

    public static Book get(DBConnection db, int id) {
        String query = "SELECT * FROM libro WHERE id = ?";
        db.open();

        try {
            PreparedStatement statement = db.connection.prepareStatement(query);
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet result = statement.executeQuery();
            result.next();

            String name = result.getString("nombre");
            String author = result.getString("autor");
            String description = result.getString("descripcion");
            String tag = result.getString("genero");

            Book book = new Book(id, name, author, description, tag);

            return book;
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    public static ResultSet getAll(DBConnection db) {
        try {

            db.open();

            String query = "SELECT * FROM libro";

            PreparedStatement statement = db.connection.prepareStatement(query);
            ResultSet result = statement.executeQuery();

            return result;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public static void save(DBConnection db, Book book) {
        String query = "INSERT INTO libro (nombre, autor, descripcion, genero) VALUES (?, ?, ?, ?)";

        try {
            db.open();
            PreparedStatement statement = db.connection.prepareStatement(query);
            statement.setString(1, book.name);
            statement.setString(2, book.author);
            statement.setString(3, book.description);
            statement.setString(4, book.tag);
            statement.execute();
            db.close();
        } catch (SQLException ex) {

        }
    }

    public static void delete(DBConnection db, int id) {
        String query = "DELETE FROM libro WHERE id = ?";
        try {
            PreparedStatement statement = db.connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.execute();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
