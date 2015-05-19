/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rectorat.database;

import AdmissionPostLicence.candidature;
import Universite.GestionEtudiant.GestionEtudiantImpl;
import java.sql.ResultSet;
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
            
            // Création de la candidature
            lineAffected=conn.statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(CandidatureDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            // Fermeture de la connexion
            conn.close();  
        }
        return (lineAffected!=0);
    }
    
    public static candidature[] importCandidatures(String nomRectorat){
        candidature[] candidatures=new candidature[0];
        // Connexion à la base de données
        conn = new ConnexionRectorat(nomRectorat+".db");
        conn.connect();
        String sql = "select count(*) from candidatures";
        int compteur=0;
        try {
            ResultSet rs = conn.statement.executeQuery(sql);
            rs.next();
            //récupération du premier resultat, soit le count
            int nb = (int)rs.getObject(0);
            //Initialisation du tableau avec le nombre de candidatures dans la table
            candidatures=new candidature[nb];
            //maintenant on récupère à proprement dit les datas
            sql = "select * from candidatures";
            rs = conn.statement.executeQuery(sql);
            while(rs.next()){
                String INE = rs.getString("INE");
                String IDMASTER = rs.getString("IDMASTER");
                String UNIVERSITE = rs.getString("UNIVERSITE");
                short ordre = (short)rs.getInt("ORDRE");
                //TODO Ajouter la récupération de l'objet identite lié à cet INE (Teddy)
                candidatures[compteur]=new candidature(GestionEtudiantImpl.getEtudiant(INE),IDMASTER,UNIVERSITE,ordre);
            }
        } catch (SQLException ex) {
            Logger.getLogger(InitDbRectorat.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            // Fermeture de la connexion
            conn.close();  
        }
        return candidatures;
    }
}
