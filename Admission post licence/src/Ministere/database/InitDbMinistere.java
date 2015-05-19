/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ministere.database;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author johnny
 */
public class InitDbMinistere {
    /** Connexion à la base de données Ministere */
    private static ConnexionMinistere conn;
    
    /**
     * 
     * @param args 
     */
    public static void main(String[] args) {
        // Connexion à la base de données
        conn = new ConnexionMinistere("Ministere.db");
        conn.connect();
        try {
            initTableMinistere();
            initTableLiaisonUniversiteRectorat();
        } catch (SQLException ex) {
            Logger.getLogger(InitDbMinistere.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            // Fermeture de la connexion
            conn.close(); 
        }
    }
    
    /**
     * Créarion de la table MINISTERE
     * @throws SQLException 
     */
    private static void initTableMinistere() throws SQLException{
        // Suppression de la table MINISTERE
        String sql = "DROP TABLE IF EXISTS MINISTERE;";

        conn.statement.executeUpdate(sql);

        sql = "CREATE TABLE MINISTERE " +
                "(IDMINISTERE TEXT PRIMARY KEY," +
                "NOM TEXT NOT NULL)";

        // Création de la table MINISTERE
        conn.statement.executeUpdate(sql);
        
        // Insertion des ministeres dans la table
        // TODO voir avec Vincent pour les données
    }
    
    /**
     * Création de la table Liaison qui permettra de savoir dans
     * quel rectorat se trouve une université
     * @throws SQLException 
     */
    private static void initTableLiaisonUniversiteRectorat() throws SQLException{
        // Suppression de la table LIAISON
        String sql = "DROP TABLE IF EXISTS LIAISON;";

        conn.statement.executeUpdate(sql);

        sql = "CREATE TABLE LIAISON " +
                "(IDLIAISON TEXT PRIMARY KEY," +
                "UNIVERSITE TEXT NOT NULL,"+
                "RECTORAT TEXT NOT NULL)";

        // Création de la table LIAISON
        conn.statement.executeUpdate(sql);
        
        // Insertion des liaisons dans la table
        // TODO voir avec Vincent pour les données
    }
}
