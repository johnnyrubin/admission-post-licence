package Universite.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe d'accès aux données des étdiants enregistrée en base
 * 
 * @author Teddy
 */
public class EtudiantDAO {
    
    /**
     * Permet de récupérer les informations d'un étudiant à partir de son numéro INE
     * 
     * @param aIne
     * @return {@link Etudiant}
     */
    public static Etudiant getFromIne(String aIne) {
        // Initialisation de la variable de retour
        Etudiant etudiant = null;
        
        try {
            if(aIne != null) {
                // Connexion à la base de données
                ConnexionUniversite conn = new ConnexionUniversite("default.db");
                conn.connect();

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
                }
                
                // Fermeture de la connexion à la BD
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(EtudiantDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return etudiant;
    }
    
}
