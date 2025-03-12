package fr.epita.biostats.services.db;

import fr.epita.biostats.datamodel.BiostatEntry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

    private static Connection getConnection() throws SQLException {
        Connection connection = DriverManager
                .getConnection("jdbc:h2:mem:test", "user", "password");
        return connection;
    }
}
