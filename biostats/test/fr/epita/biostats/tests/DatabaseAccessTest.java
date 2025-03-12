package fr.epita.biostats.tests;

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

        PreparedStatement createTableStmt = connection.prepareStatement("CREATE TABLE BIOSTATS (NAME varchar(255), GENDER CHAR)");
        createTableStmt.execute();

        PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO BIOSTATS (NAME, GENDER) VALUES ('test', 'F')");
        insertStatement.execute();

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
