/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rectorat.database;

import AdmissionPostLicence.candidature;
import Rectorat.ServerRectorat;
import Rectorat.pojo.Candidature;
import Universite.GestionEtudiant.EtudiantMapper;
import Util.GetObjectCorba;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            
            // Création de la candidature
            lineAffected=conn.statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(CandidatureDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            // Fermeture de la connexion
            conn.close();  
        }
        return (lineAffected!=0);
    }
    
    public static candidature[] getCandidatureEtudiant(String ine,String nomRectorat){
        candidature[] cs;
        candidature c;
        try {
            // Connexion à la base de données
            conn = new ConnexionRectorat(nomRectorat+".db");
            conn.connect();
            
            // Exécution de la requête
                String sql = "SELECT * FROM CANDIDATURES WHERE INE = '" + ine + "';";
                ResultSet rs = conn.statement.executeQuery(sql);

                if(rs.next()) {
                    // Traitement du résultat
                    c = new candidature(rs.getString("INE"),rs.getString("MASTER"),rs.getString("UNIVERSITE"),rs.getInt("ORDRE"),rs.getInt("ETAT"),rs.getInt("DECISIONCANDIDAT"),rs.getInt("DECISIONMASTER"));
                    
                    // Récupération des résultats scolaires de l'étudiant
                    List<ResultatSemestre> resultats = ResultatSemestreDAO.getFromEtudiant(etudiant);
                    
                    etudiant.setResultats(resultats);
                }
        } catch (SQLException ex) {
            Logger.getLogger(CandidatureDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            // Fermeture de la connexion
            conn.close();  
        }
    }
    
    /*public static candidature[] importCandidatures(String nomRectorat){
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
                //on ajoute au tableau des candidature, la candidature récupérée
                candidatures[compteur]=new candidature(EtudiantMapper.etudiantToIdentiteCorba(GetObjectCorba.getEtudiant("UniversitePaulSab", INE, ServerRectorat.orb)),
                        IDMASTER,UNIVERSITE,ordre);
            }
        } catch (SQLException ex) {
            Logger.getLogger(InitDbRectorat.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            // Fermeture de la connexion
            conn.close();  
        }
        return candidatures;
    }*/
}
