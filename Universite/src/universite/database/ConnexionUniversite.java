package Universite.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * 
 */
public class ConnexionUniversite {
    
    private final String DBPath;
    private Connection connection = null;
    public Statement statement = null;
 
    /**
     * 
     * @param dBPath 
     */
    public ConnexionUniversite(String dBPath) {
        DBPath = "universite-"+dBPath;
    }
 
    /**
     * Lance la connexion à la base de données SQLite
     */
    public void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + DBPath);
            statement = connection.createStatement();
            System.out.println("Connexion a " + DBPath + " avec succès");
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            System.out.println("Erreur de connexion");
        }
    }
 
    /**
     * Ferme la connexion à la base de données SQLite
     */
    public void close() {
        try {
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
