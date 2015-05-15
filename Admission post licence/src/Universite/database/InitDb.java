package Universite.database;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe utilisée pour initialiser la base de données de l'université.
 * Cela comprend la création des tables et l'insertion des jeux de données initiaux
 * 
 * @author Teddy
 */
public class InitDb {
    
    /** Connexion à la base de données universitaire */
    private static ConnexionUniversite conn;
    
    /**
     * 
     * @param args 
     */
    public static void main(String[] args) {
        
        // Connexion à la base de données
        conn = new ConnexionUniversite("default.db");
        conn.connect();
            
        try {
            initTableEtudiant();
            
            initTableResultatSemestre();
            
            initTableMaster();
            
            initTableLicence();
            
            initTablePrerequis();
            
        } catch (SQLException ex) {
            Logger.getLogger(InitDb.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Fermeture de la connexion
            conn.close();
        }
    }
    
    /**
     * Création de la table ETUDIANT
     * 
     * @throws SQLException 
     */
    private static void initTableEtudiant() throws SQLException {
        // Suppression de la table ETUDIANT
        String sql = "DROP TABLE IF EXISTS ETUDIANT;";

        conn.statement.executeUpdate(sql);

        sql = "CREATE TABLE ETUDIANT " +
                "(INE TEXT PRIMARY KEY," +
                "NOM TEXT NOT NULL," +
                "PRENOM TEXT NOT NULL," +
                "MDP TEXT NOT NULL)";

        // Création de la table ETUDIANT
        conn.statement.executeUpdate(sql);
        
        // Insertion des étudiants dans la table
        // TODO voir avec Vincent pour les données
    }
    
    /**
     * Création de la table RESULTATSEMESTRE
     * 
     * @throws SQLException 
     */
    private static void initTableResultatSemestre() throws SQLException {
        // Suppression de la table RESULTATSEMESTRE
        String sql = "DROP TABLE IF EXISTS RESULTATSEMESTRE;";

        conn.statement.executeUpdate(sql);

        sql = "CREATE TABLE RESULTATSEMESTRE " +
                "(CODE TEXT PRIMARY KEY," +
                "MOYENNE REAL NOT NULL," +
                "POSITION INTEGER NOT NULL," +
                "INE_ETUDIANT TEXT NOT NULL)";

        // Création de la table MASTER
        conn.statement.executeUpdate(sql);
    }
    
    /**
     * Création de la table MASTER
     * 
     * @throws SQLException 
     */
    private static void initTableMaster() throws SQLException {
        // Suppression de la table MASTER
        String sql = "DROP TABLE IF EXISTS MASTER;";

        conn.statement.executeUpdate(sql);

        sql = "CREATE TABLE MASTER " +
                "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "NOM TEXT NOT NULL)";

        // Création de la table MASTER
        conn.statement.executeUpdate(sql);
    }
    
    /**
     * Création de la table LICENCE
     * 
     * @throws SQLException 
     */
    private static void initTableLicence() throws SQLException {
        // Suppression de la table LICENCE
        String sql = "DROP TABLE IF EXISTS LICENCE;";

        conn.statement.executeUpdate(sql);

        sql = "CREATE TABLE LICENCE " +
                "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "NOM TEXT NOT NULL)";

        // Création de la table LICENCE
        conn.statement.executeUpdate(sql);
    }
    
    /**
     * Création de la table PREREQUIS
     * 
     * @throws SQLException 
     */
    private static void initTablePrerequis() throws SQLException {
        // Suppression de la table PREREQUIS
        String sql = "DROP TABLE IF EXISTS PREREQUIS;";

        conn.statement.executeUpdate(sql);

        sql = "CREATE TABLE PREREQUIS " +
                "(ID_MASTER INTEGER NOT NULL," +
                "ID_LICENCE INTEGER NOT NULL," +
                "PRIMARY KEY (ID_MASTER, ID_LICENCE))";

        // Création de la table PREREQUIS
        conn.statement.executeUpdate(sql);
    }
    
}
