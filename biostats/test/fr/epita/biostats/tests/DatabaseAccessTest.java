package fr.epita.biostats.tests;

import fr.epita.biostats.datamodel.BiostatEntry;
import fr.epita.biostats.services.db.BiostatDAO;

import java.sql.*;

public class DatabaseAccessTest {

    public static void main(String[] args) throws SQLException {
        // we need a database
        // we need the url to access this db
        // user + password
        // driver

        // H2: three modes : in-memory, file, server
        // In case we need to contact a h2 standalone server
        // Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost:1234/test");

        Connection connection = DriverManager.getConnection("jdbc:h2:mem:test", "user", "password");
        String schema = connection.getSchema();
        System.out.println(schema);

        BiostatDAO dao = new BiostatDAO();
        BiostatEntry entry = new BiostatEntry("test", "F",22, 170, 70);
        dao.create(entry);

        //TODO: refactor this into a readAll method of the DAO
        PreparedStatement selectStmt
                = connection.prepareStatement("SELECT * FROM BIOSTATS");

        ResultSet resultSet = selectStmt.executeQuery();
        while (resultSet.next()){
            String name = resultSet.getString("name");
            String gender = resultSet.getString("gender");
            System.out.println(name);
            System.out.println(gender);
        }

    }
}
