package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TagStore {
    public static ArrayList<String> getAll(DBConnection db) {
        try {

            db.open();

            String query = "SELECT * FROM genero";

            PreparedStatement statement = db.connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            ArrayList<String> tags = new ArrayList();
            while (resultSet.next()) {
                String tag = resultSet.getString(2);
                tags.add(tag);
            }
            
            db.close();
            
            return tags;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }
}
