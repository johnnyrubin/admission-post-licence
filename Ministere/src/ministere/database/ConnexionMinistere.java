package ministere.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * 
 */
public class ConnexionMinistere {
    private final String DBPath;
    private Connection connection = null;
    public Statement statement = null;
 
    public ConnexionMinistere(String dBPath) {
        DBPath = "ministere-"+dBPath;
    }
 
    public void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + DBPath);
            statement = connection.createStatement();
            System.out.println("Connexion a " + DBPath + " avec succès");
        } catch (ClassNotFoundException | SQLException notFoundException) {
            System.out.println("Erreur de connexion");
        }
    }
 
    public void close() {
        try {
            statement.close();
            connection.close();
        } catch (SQLException e) {
        }
    }
}
