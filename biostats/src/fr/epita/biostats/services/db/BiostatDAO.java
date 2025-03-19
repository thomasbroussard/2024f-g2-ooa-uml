package fr.epita.biostats.services.db;

import fr.epita.biostats.datamodel.BiostatEntry;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import fr.epita.biostats.services.ConfigurationService;
import fr.epita.biostats.services.exception.CreationException;

public class BiostatDAO {


    private final ConfigurationService configurationService;

    /**
     * <strong>be careful</strong> while using this constructor, it creates a connection and attempts to create the biostats table
     *
     * @throws SQLException
     */
    public BiostatDAO() throws SQLException {
        this.configurationService = ConfigurationService.getInstance();
        Connection connection = getConnection();
        PreparedStatement createTableStmt = connection.prepareStatement("CREATE TABLE IF NOT EXISTS BIOSTATS (NAME varchar(255), GENDER CHAR, AGE INT, HEIGHT INT, WEIGHT INT)");
        createTableStmt.execute();
    }

    public void create(BiostatEntry entry) throws CreationException {

        try (Connection connection = getConnection()){
            PreparedStatement insertStatement = connection
                    .prepareStatement("INSERT INTO BIOSTATS (NAME, GENDER, AGE, HEIGHT, WEIGHT) VALUES (?, ?, ?, ?, ?)");
            insertStatement.setString(1, entry.getName());
            insertStatement.setString(2, entry.getSex());
            insertStatement.setInt(3, entry.getAge());
            insertStatement.setInt(4, entry.getHeight());
            insertStatement.setInt(5, entry.getWeight());
            insertStatement.execute();
        } catch (SQLException sqle){
            //if this a connection issue maybe we can retry
            CreationException creationException = new CreationException("creation of record could not complete");
            creationException.initCause(sqle);
            throw creationException;

        }

    }

    public void update(BiostatEntry entry) throws SQLException {
        Connection connection = getConnection();

        PreparedStatement updateStatement = connection
                .prepareStatement("""
                           UPDATE BIOSTATS SET GENDER = ?, 
                               AGE = ?,
                               HEIGHT = ?,
                               WEIGHT = ?
                            WHERE NAME = ?
                        """);
        updateStatement.setString(1, entry.getSex());
        updateStatement.setInt(2, entry.getAge());
        updateStatement.setInt(3, entry.getHeight());
        updateStatement.setInt(4, entry.getWeight());
        updateStatement.setString(5, entry.getName());
        updateStatement.execute();


        connection.close();
    }

    public void delete(BiostatEntry entry) throws SQLException {
        Connection connection = getConnection();

        PreparedStatement deleteStatement = connection
                .prepareStatement("""
                           DELETE FROM BIOSTATS WHERE NAME = ?
                        """);
        deleteStatement.setString(1, entry.getName());
        deleteStatement.execute();


        connection.close();
    }


    public List<BiostatEntry> search(BiostatEntry qube) throws SQLException {
        List<BiostatEntry> entries = new ArrayList<>();
        String sqlSearch = """
                SELECT * FROM BIOSTATS
                WHERE
                    (? IS NULL OR NAME = ?)
                    AND (? IS NULL OR AGE = ?)
                    AND (? IS NULL OR GENDER = ?)
                    AND (? IS NULL OR HEIGHT = ?)
                    AND (? IS NULL OR WEIGHT = ?)
                """;
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(sqlSearch);
        statement.setObject(1, qube.getName(), JDBCType.VARCHAR);
        statement.setObject(2, qube.getName(), JDBCType.VARCHAR);
        statement.setObject(3, qube.getAge(), JDBCType.INTEGER);
        statement.setObject(4, qube.getAge(), JDBCType.INTEGER);
        statement.setObject(5, qube.getSex(), JDBCType.VARCHAR);
        statement.setObject(6, qube.getSex(), JDBCType.VARCHAR);
        statement.setObject(7, qube.getHeight(), JDBCType.INTEGER);
        statement.setObject(8, qube.getHeight(), JDBCType.INTEGER);
        statement.setObject(9, qube.getWeight(), JDBCType.INTEGER);
        statement.setObject(10, qube.getWeight(), JDBCType.INTEGER);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            String gender = resultSet.getString("gender");
            Integer age = resultSet.getInt("age");
            Integer height = resultSet.getInt("height");
            Integer weight = resultSet.getInt("weight");
            entries.add(new BiostatEntry(name, gender, age, height, weight));
        }
        connection.close();
        return entries;
    }

    public List<BiostatEntry> readAll() throws SQLException {
        List<BiostatEntry> result = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement selectStmt
                = connection.prepareStatement("SELECT * FROM BIOSTATS");

        ResultSet resultSet = selectStmt.executeQuery();
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            String gender = resultSet.getString("gender");
            Integer age = resultSet.getInt("age");
            Integer height = resultSet.getInt("height");
            Integer weight = resultSet.getInt("weight");
            result.add(new BiostatEntry(name, gender, age, height, weight));
        }

        connection.close();
        return result;

    }


    private Connection getConnection() throws SQLException {

        Connection connection = DriverManager
                .getConnection(configurationService.getProperty("db.url"),
                        configurationService.getProperty("db.user"),
                        configurationService.getProperty("db.password")
                );
        return connection;
    }
}
