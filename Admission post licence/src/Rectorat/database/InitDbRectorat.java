/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Rectorat.database;

import AdmissionPostLicence.EtudiantInconnu;
import AdmissionPostLicence.Rectorat;
import AdmissionPostLicence.RectoratHelper;
import AdmissionPostLicence.candidature;
import AdmissionPostLicence.identite;
import Rectorat.ServerRectorat;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.NotFound;

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
        conn = new ConnexionRectorat("toulouse.db");
        conn.connect();
        try {
            initTableRectorat();
            initTableCandidatures();
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
                "NOM TEXT NOT NULL)";

        // Création de la table RECTORAT
        conn.statement.executeUpdate(sql);
        
        // Insertion des rectorats dans la table
        // TODO voir avec Vincent pour les données
    }
    
    /**
     * Création de la table CANDIDATURES
     * 
     * @throws SQLException 
     */
    private static void initTableCandidatures() throws SQLException{
    // Suppression de la table CANDIDATURES
        String sql = "DROP TABLE IF EXISTS CANDIDATURES;";

        conn.statement.executeUpdate(sql);

        sql = "CREATE TABLE CANDIDATURES " +
                "(INE TEXT," +
                "IDMASTER TEXT,"+
                "UNIVERSITE TEXT NOT NULL,"+
                "ORDRE NUMBER NOT NULL,"+
                "PRIMARY KEY(INE,IDMASTER)"
                + ")";

        // Création de la table CANDIDATURES
        conn.statement.executeUpdate(sql);
        
        // Insertion des candidatures dans la table
        // TODO voir avec Vincent pour les données
    }
    
    
    
}
