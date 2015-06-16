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
            initTableDiplomes();
            initTableAccreditations();
            initTableUniversite();
            AccreditationDAO.getAccreditations();
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
    
    
    
    /**
     * Création de la table Diplome qui stockera tous les diplomes
     * @throws SQLException 
     */
    private static void initTableDiplomes() throws SQLException{
        // Suppression de la table LIAISON
        String sql = "DROP TABLE IF EXISTS DIPLOME;";

        conn.statement.executeUpdate(sql);

        sql = "CREATE TABLE DIPLOME " +
                "(IDDIPLOME NUMBER PRIMARY KEY," +
                "DIPLOME TEXT NOT NULL)";

        // Création de la table DIPLOME
        conn.statement.executeUpdate(sql);
        // TODO voir avec Vincent pour les données
        sql = "Insert into DIPLOME values ( 1, 'MIAGE')";
        conn.statement.executeUpdate(sql);
        sql = "Insert into DIPLOME values ( 2, 'Fonda')";
        conn.statement.executeUpdate(sql);
        sql = "Insert into DIPLOME values ( 3, 'Droits')";
        conn.statement.executeUpdate(sql);
        sql = "Insert into DIPLOME values ( 4, 'Bio')";
        conn.statement.executeUpdate(sql);
    }
    
    /**
     * Création de la table Universite qui stockera tous les UNIVERSITÉS
     * @throws SQLException 
     */
    private static void initTableUniversite() throws SQLException{
        // Suppression de la table LIAISON
        String sql = "DROP TABLE IF EXISTS UNIVERSITE;";

        conn.statement.executeUpdate(sql);

        sql = "CREATE TABLE UNIVERSITE " +
                "(IDUNIVERSITE NUMBER PRIMARY KEY," +
                "UNIVERSITE TEXT NOT NULL)";

        // Création de la table UNIVERSITE
        conn.statement.executeUpdate(sql);
        // TODO voir avec Vincent pour les données
        sql = "Insert into UNIVERSITE values ( 1, 'Paul Sabatier')";
        conn.statement.executeUpdate(sql);
        sql = "Insert into UNIVERSITE values ( 2, 'UT1')";
        conn.statement.executeUpdate(sql);
    }
    
    
    /**
     * Création de la table Accreditations qui stockera tous les Accreditations
     * @throws SQLException 
     */
    private static void initTableAccreditations() throws SQLException{
        // Suppression de la table LIAISON
        String sql = "DROP TABLE IF EXISTS ACCREDITATIONS;";

        conn.statement.executeUpdate(sql);

        sql = "CREATE TABLE ACCREDITATIONS " +
                "(IDUNIVERSITE NUMBER," +
                "IDDIPLOME NUMBER,"+
                "PRIMARY KEY(IDUNIVERSITE,IDDIPLOME))";

        // Création de la table ACCREDITATIONS
        conn.statement.executeUpdate(sql);
        // TODO voir avec Vincent pour les données
        sql = "Insert into ACCREDITATIONS values (1, 1)";
        conn.statement.executeUpdate(sql);
        sql = "Insert into ACCREDITATIONS values (2, 3)";
        conn.statement.executeUpdate(sql);
        sql = "Insert into ACCREDITATIONS values (1, 2)";
        conn.statement.executeUpdate(sql);
        sql = "Insert into ACCREDITATIONS values (1, 4)";
        conn.statement.executeUpdate(sql);
    }
}
