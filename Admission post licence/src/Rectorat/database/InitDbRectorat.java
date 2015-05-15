/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Rectorat.database;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author johnny
 */
public class InitDbRectorat {
    /** Connexion à la base de données Rectorat */
    private static ConnexionRectorat conn;
    
    /**
     * 
     * @param args 
     */
    public static void main(String[] args) {
        
        // Connexion à la base de données
        conn = new ConnexionRectorat("default.db");
        conn.connect();
        try {
            initTableRectorat();
        } catch (SQLException ex) {
            Logger.getLogger(InitDbRectorat.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            // Fermeture de la connexion
            conn.close();  
        }
    }
    
    /**
     * Création de la table RECTORAT
     * 
     * @throws SQLException 
     */
    private static void initTableRectorat() throws SQLException {
        // Suppression de la table RECTORAT
        String sql = "DROP TABLE IF EXISTS RECTORAT;";

        conn.statement.executeUpdate(sql);

        sql = "CREATE TABLE RECTORAT " +
                "(ID TEXT PRIMARY KEY," +
                "LIBELLE TEXT NOT NULL)";

        // Création de la table RECTORAT
        conn.statement.executeUpdate(sql);
        
        // Insertion des étudiants dans la table
        // TODO voir avec Vincent pour les données
    }
    
}
