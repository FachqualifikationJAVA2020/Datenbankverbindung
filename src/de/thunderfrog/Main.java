package de.thunderfrog;

public class Main {

    public static void main(String[] args) {
	DBConnector db = new DBConnector("KingKhaos","dead1987","webshop");
    DBHandler dbHandler = new DBHandler(db);

    dbHandler.selectQuery("SELECT * FROM plz;");
    }
}
