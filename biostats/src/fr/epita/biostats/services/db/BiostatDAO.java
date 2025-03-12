package fr.epita.biostats.services.db;

import fr.epita.biostats.datamodel.BiostatEntry;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BiostatDAO {


    /**
     * <strong>be careful</strong> while using this constructor, it creates a connection and attempts to create the biostats table
     * @throws SQLException
     */
    public BiostatDAO() throws SQLException {
        Connection connection = getConnection();
        PreparedStatement createTableStmt = connection.prepareStatement("CREATE TABLE IF NOT EXISTS BIOSTATS (NAME varchar(255), GENDER CHAR, AGE INT, HEIGHT INT, WEIGHT INT)");
        createTableStmt.execute();

    }

    public void create(BiostatEntry entry) throws SQLException {
        Connection connection = getConnection();

        PreparedStatement insertStatement = connection
                .prepareStatement("INSERT INTO BIOSTATS (NAME, GENDER, AGE, HEIGHT, WEIGHT) VALUES (?, ?, ?, ?, ?)");
        insertStatement.setString(1, entry.getName());
        insertStatement.setString(2, entry.getSex());
        insertStatement.setInt(3, entry.getAge());
        insertStatement.setInt(4, entry.getHeight());
        insertStatement.setInt(5, entry.getWeight());
        insertStatement.execute();
    }

    public List<BiostatEntry> readAll() throws SQLException {
        List<BiostatEntry> result = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement selectStmt
                = connection.prepareStatement("SELECT * FROM BIOSTATS");

        ResultSet resultSet = selectStmt.executeQuery();
        while (resultSet.next()){
            String name = resultSet.getString("name");
            String gender = resultSet.getString("gender");
            Integer age = resultSet.getInt("age");
            Integer height = resultSet.getInt("height");
            Integer weight = resultSet.getInt("weight");
            result.add(new BiostatEntry(name, gender, age, height, weight));
        }

        return result;

    }


    private static Connection getConnection() throws SQLException {
        Connection connection = DriverManager
                .getConnection("jdbc:h2:mem:test", "user", "password");
        return connection;
    }
}
