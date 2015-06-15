/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rectorat.database;

import Rectorat.pojo.Candidature;
import Universite.pojo.Etudiant;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author johnny
 */
public class CandidatureDAO {
    
    /** Connexion à la base de données Rectorat */
    private static ConnexionRectorat conn;
    
    /**
     * Ajout d'une candidature dans la base de donnée pour la persistance des données
     * @param c
     * @param nomRectorat
     * @return 
     */
    public static boolean ajoutCandidature(Candidature c,String nomRectorat){
        int lineAffected=0;
        try {
            // Connexion à la base de données
            conn = new ConnexionRectorat(nomRectorat+".db");
            conn.connect();
            String sql = "Insert into CANDIDATURES values" +
                    "('"+c.getEtu().getIne()+"','"+c.getMaster()+"','"+c.getUniversite()+"',"+c.getOrdre()+
                    ","+c.getEtatCandidature()+","+c.getDecisionCandidat()+","+c.getDecisionMaster()+")";
            System.out.println(sql);
            // Création de la candidature
            lineAffected=conn.statement.executeUpdate(sql);
            sql = "select count(*) as tot from ETUDIANT where INE='" + c.getEtu().getIne() + "';";
            ResultSet rs = conn.statement.executeQuery(sql);

            if(!rs.next()) {
                sql = "Insert into ETUDIANT values" +
                        "('"+c.getEtu().getIne()+"','"+c.getEtu().getNom()+"','"+c.getEtu().getPrenom()+"','"+c.getEtu().getUniversite()+
                        "','"+c.getEtu().getLicence()+"')";
                System.out.println(sql);
                // Création de la candidature
                conn.statement.executeUpdate(sql);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CandidatureDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            // Fermeture de la connexion
            conn.close();  
        }
        return (lineAffected!=0);
    }
    
    public static List<Candidature> getCandidaturesEtudiant(String ine,String nomRectorat){
        List<Candidature> lesCandidatures = new ArrayList<>();
        Candidature c;
        Etudiant e;
        try {
            // Connexion à la base de données
            conn = new ConnexionRectorat(nomRectorat+".db");
            conn.connect();
            
            // Exécution de la requête
                String sql = "SELECT E.INE as INE, NOM, PRENOM, LICENCE,E.UNIVERSITE as UNIVERSITEETU, "
                        + "IDMASTER, C.UNIVERSITE as UNIVERSITE, ORDRE, ETAT, DECISIONCANDIDAT,"
                        + "DECISIONMASTER FROM CANDIDATURES C, ETUDIANT E WHERE C.INE=E.INE AND C.INE = '" + ine + "';";
                ResultSet rs = conn.statement.executeQuery(sql);

                while(rs.next()) {
                    // Traitement du résultat
                    e = new Etudiant();
                    e.setIne(rs.getString("INE"));
                    e.setNom(rs.getString("NOM"));
                    e.setPrenom(rs.getString("PRENOM"));
                    e.setLicence(rs.getString("LICENCE"));
                    e.setUniversite(rs.getString("UNIVERSITEETU"));
                    c = new Candidature(e,rs.getString("IDMASTER"),rs.getString("UNIVERSITE"),
                            rs.getInt("ORDRE"),rs.getInt("ETAT"),rs.getInt("DECISIONCANDIDAT"),rs.getInt("DECISIONMASTER"));
                    System.out.println("CandidatureDAO.getCandidatureEtudiant Candidature => "+c);
                    lesCandidatures.add(c);
                }
        } catch (SQLException ex) {
            Logger.getLogger(CandidatureDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            // Fermeture de la connexion
            conn.close();  
        }
        return lesCandidatures;
    }
    
    public static void modifierCandidature(Candidature c,String nomRectorat){
        try {
            // Connexion à la base de données
            conn = new ConnexionRectorat(nomRectorat+".db");
            conn.connect();
            String sql = "update CANDIDATURES set UNIVERSITE='"+c.getUniversite()+"', ORDRE="+c.getOrdre()+
                    ", Etat="+c.getEtatCandidature()+", DecisionCandidat="+c.getDecisionCandidat()+", DecisionMaster="+c.getDecisionMaster()+
                    " where INE='"+c.getEtu().getIne()+"' AND IDMASTER='"+c.getMaster()+"';";
            System.out.println(sql);
            // Création de la candidature
            conn.statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(CandidatureDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
    public static void supprimerCandidature(Candidature c,String nomRectorat){
        try {
            // Connexion à la base de données
            conn = new ConnexionRectorat(nomRectorat+".db");
            conn.connect();
            String sql = "delete from CANDIDATURES where INE='"+c.getEtu().getIne()+"' AND IDMASTER='"+c.getMaster()+"';";
            System.out.println(sql);
            // Création de la candidature
            conn.statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(CandidatureDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
}
