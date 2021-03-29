package de.thunderfrog;

/*
 *  Alle Klassen, die mit Datenbanken zu tun haben,
 *  liegen im Package java.sql
 */
import java.sql.*;

public class DBConnector {

    //  DBConnector
    private Connection conn;

    //  ConnectionString
    private final String connectionString = "jdbc:mysql://127.0.0.1/";

    //  Database Config
    private String dbUser;
    private String dbPassword;
    private String database;

    //  Constructor
    public DBConnector(String dbUser, String dbPassword, String database) {
        this.dbUser = dbUser;
        this.dbPassword = dbPassword;
        this.database = database;

        //  Connection-Object initialisiert
        try {
            conn = DriverManager.getConnection(connectionString + database , dbUser , dbPassword);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //  GETTER & SETTER
    public String getDbUser() {
        return dbUser;
    }

    public void setDbUser(String dbUser) {
        this.dbUser = dbUser;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getConnectionString() {
        return connectionString;
    }
}
