package de.thunderfrog;

import java.sql.*;

public class DBHandler {
    //  DBConnector
    private DBConnector db;

    //  Connection
    private Connection conn;

    public DBHandler(DBConnector db) {
        this.db = db;
    }

    public void selectQuery(String sqlQuery) {
        //  Connection-Object initialisiert
        try {
            conn = DriverManager.getConnection(db.getConnectionString() + db.getDatabase(), db.getDbUser(), db.getDbPassword());

            //  Statement für unsere Connection
            Statement st = conn.createStatement();

            //  Statement-Object kann SQL-Befehle verarbeiten
            System.out.println("Mein SQL-Befehl: " + sqlQuery);

            /*
             *  Statement an die Datenbank schicken
             *  ResultSet ist die Menge aller Suchergebnisse aus der Datenbank
             *
             *  Rückgabewerte:
             *                  null
             *                  eins
             *                  viele Ergebnisse
             *
             *  ResultSet ist keine Collection
             */
            ResultSet rs = st.executeQuery(sqlQuery);

            /*
             *  Auf das nächste Element des ResultSet springen
             *
             *  Rückgabewert:
             *                  true = es gibt weitere Elemente
             *                  false = es gibt keine Elemente mehr
             *
             *  Mit einer Schleife können wir die Elemente auslesen
             */
            while (rs.next()) {
                //  .getString() holt einen String aus der angegebene Spalte
                String zipCode = rs.getString("PLZ");
                String cityName = rs.getString("Stadt");
                System.out.println("PLZ: " + zipCode + " Stadt: " + cityName);

            }

            //  Datenbankverbindung schließen
            conn.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}

