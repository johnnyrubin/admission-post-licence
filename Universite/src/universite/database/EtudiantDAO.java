package Universite.database;

import Pojo.Etudiant;
import Pojo.ResultatSemestre;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe d'accès aux données des étdiants enregistrés en base
 * 
 * 
 */
public class EtudiantDAO {
    
    /**
     * Permet de récupérer les informations d'un étudiant à partir de son numéro INE
     * 
     * @param aIne
     * @return {@link Etudiant}
     */
    public static Etudiant getFromIne(String aIne) {
        System.out.println("EtudiantDAO.getFromINE Début");
        // Initialisation de la variable de retour
        Etudiant etudiant = null;
        
        // Connexion à la base de données
        ConnexionUniversite conn = new ConnexionUniversite("default.db");
        conn.connect();
        
        try {
            if(aIne != null) {
                // Exécution de la requête
                String sql = "SELECT * FROM ETUDIANT WHERE INE = '" + aIne + "';";
                ResultSet rs = conn.statement.executeQuery(sql);

                if(rs.next()) {
                    // Traitement du résultat
                    etudiant = new Etudiant();
                    etudiant.setIne(rs.getString("INE"));
                    etudiant.setNom(rs.getString("NOM"));
                    etudiant.setPrenom(rs.getString("PRENOM"));
                    etudiant.setMdp(rs.getString("MDP"));
                    etudiant.setLicence(rs.getString("LICENCE"));
                    etudiant.setUniversite(rs.getString("UNIVERSITE"));
                    
                    // Récupération des résultats scolaires de l'étudiant
                    List<ResultatSemestre> resultats = ResultatSemestreDAO.getFromEtudiant(etudiant);
                    
                    etudiant.setResultats(resultats);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(EtudiantDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Fermeture de la connexion
            conn.close();
        }
        System.out.println("EtudiantDAO.getFromINE Etudiant => "+etudiant);
        return etudiant;
    }
    
}
