package rectorat.database;

import Database.Connexion;
import Pojo.Candidature;
import Pojo.Etudiant;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe d'accès aux données des candidatures enregistrées en base
 * 
 */
public class CandidatureDAO {
    
    /** Connexion à la base de données Rectorat */
    private final Connexion conn;

    /**
     * 
     * @param uneConn 
     */
    public CandidatureDAO(Connexion uneConn) {
        // Connexion à la base de données
        conn = uneConn;
    }
    
    /**
     * Ajout d'une candidature dans la base de donnée pour la persistance des données
     * 
     * @param c
     * @return boolean
     */
    public boolean ajoutCandidature(Candidature c) {
        int lineAffected=0;
        
        try {
            String sql = "Insert into CANDIDATURES values" +
                    "('"+c.getEtu().getIne()+"','"+c.getMaster()+"','"+c.getUniversite()+"',"+c.getOrdre()+
                    ","+c.getEtatCandidature()+","+c.getDecisionCandidat()+","+c.getDecisionMaster()+")";
            System.out.println(sql);
            
            // Création de la candidature
            lineAffected=conn.statement.executeUpdate(sql);
            sql = "select count(*) as tot from ETUDIANT where INE='" + c.getEtu().getIne() + "';";
            ResultSet rs = conn.statement.executeQuery(sql);
            rs.next();
            
            if(rs.getInt("tot") == 0) {
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
        
        return (lineAffected!=0);
    }
    
    /**
     * Récupère les candidatures de l'étudiant dont le numéro INE est fourni en paramètre
     * 
     * @param ine
     * @return List<{@link Candidature}>
     */
    public List<Candidature> getCandidaturesEtudiant(String ine) {
        
        List<Candidature> lesCandidatures = new ArrayList<>();
        Candidature c;
        Etudiant e;
        
        try {
            // Exécution de la requête
            String sql = "SELECT E.INE as INE, NOM, PRENOM, LICENCE,E.UNIVERSITE as UNIVERSITEETU, "
                    + "IDMASTER, C.UNIVERSITE as UNIVERSITE, ORDRE, ETAT, DECISIONCANDIDAT,"
                    + "DECISIONMASTER FROM CANDIDATURES C, ETUDIANT E WHERE C.INE=E.INE AND C.INE = '" + ine + "' ORDER BY ORDRE;";
            ResultSet rs = conn.statement.executeQuery(sql);
            System.out.println(sql);
            
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
        
        return lesCandidatures;
    }
    
    /**
     * Modifie la candidature en base
     * 
     * @param c 
     */
    public void modifierCandidature(Candidature c) {
        try {
            String sql = "update CANDIDATURES set UNIVERSITE='"+c.getUniversite()+"', ORDRE="+c.getOrdre()+
                    ", Etat="+c.getEtatCandidature()+", DecisionCandidat="+c.getDecisionCandidat()+", DecisionMaster="+c.getDecisionMaster()+
                    " where INE='"+c.getEtu().getIne()+"' AND IDMASTER='"+c.getMaster()+"';";
            System.out.println(sql);
            conn.statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(CandidatureDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Supprime la candidature de la BD
     * 
     * @param c 
     */
    public void supprimerCandidature(Candidature c) {
        try {
            String sql = "delete from CANDIDATURES where INE='"+c.getEtu().getIne()+"' AND IDMASTER='"+c.getMaster()+"';";
            System.out.println(sql);
            conn.statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(CandidatureDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
    /**
     * Récupère les candidatures faites au master fourni en paramètre
     * 
     * @param universite
     * @param master
     * @return List<{@link Candidature}>
     */
    public List<Candidature> getCandidaturesMaster(String universite, String master) {
        List<Candidature> lesCandidatures = new ArrayList<>();
        Candidature c;
        Etudiant e;
        
        try {            
            // Exécution de la requête
            String sql = "SELECT E.INE as INE, NOM, PRENOM, LICENCE,E.UNIVERSITE as UNIVERSITEETU, "
                    + "IDMASTER, C.UNIVERSITE as UNIVERSITE, ORDRE, ETAT, DECISIONCANDIDAT,"
                    + "DECISIONMASTER FROM CANDIDATURES C, ETUDIANT E WHERE C.INE = E.INE "
                    + "AND C.UNIVERSITE = '" + universite + "' AND IDMASTER = '" + master + "';";

            ResultSet rs = conn.statement.executeQuery(sql);

            while(rs.next()) {
                // Traitement du résultat
                e = new Etudiant();
                e.setIne(rs.getString("INE"));
                e.setNom(rs.getString("NOM"));
                e.setPrenom(rs.getString("PRENOM"));
                e.setLicence(rs.getString("LICENCE"));
                e.setUniversite(rs.getString("UNIVERSITEETU"));

                c = new Candidature(e,rs.getString("IDMASTER"), rs.getString("UNIVERSITE"),
                        rs.getInt("ORDRE"), rs.getInt("ETAT"), rs.getInt("DECISIONCANDIDAT"), rs.getInt("DECISIONMASTER"));

                System.out.println("CandidatureDAO.getCandidaturesMaster Candidature => " + c);

                lesCandidatures.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CandidatureDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lesCandidatures;
    }
}
