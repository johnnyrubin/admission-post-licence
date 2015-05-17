/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rectorat.database;

import AdmissionPostLicence.candidature;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author johnny
 */
public class CandidatureDb {
    
    /** Connexion à la base de données Rectorat */
    private static ConnexionRectorat conn;
    
    /**
     * Ajout d'une candidature dans la base de donnée pour la persistance des données
     * @param c
     * @param nomRectorat
     * @return 
     */
    public static boolean ajoutCandidature(candidature c,String nomRectorat){
        int lineAffected=0;
        try {
            // Connexion à la base de données
            conn = new ConnexionRectorat(nomRectorat+".db");
            conn.connect();
            String sql = "Insert into CANDIDATURES values" +
                    "('"+c.etudiant.ine+"','"+c.master+"','"+c.universite+"',"+c.ordre+")";
            
            // Création de la table RECTORAT
            lineAffected=conn.statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(CandidatureDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (lineAffected!=0);
    }
}
