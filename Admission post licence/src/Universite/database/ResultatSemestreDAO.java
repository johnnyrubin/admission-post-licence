package Universite.database;

import java.util.List;
import Universite.pojo.ResultatSemestre;
import Universite.pojo.Etudiant;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe d'accès aux données des résultats scolaires dans la BD
 * 
 * @author Teddy
 */
public class ResultatSemestreDAO {
    
    /**
     * Récupère les résultats de l'étudiant fourni
     * 
     * @param etudiant
     * @return {@link List}<{@link ResultatSemestre}>
     */
    public static List<ResultatSemestre> getFromEtudiant(Etudiant etudiant) {
        // Initialisation de la variable de retour
        List<ResultatSemestre> resultats = new ArrayList<>();
        
        // Connexion à la base de données
        ConnexionUniversite conn = new ConnexionUniversite("default.db");
        conn.connect();
            
        try {
            // Récupération des résultats scolaire de l'étudiant
            String sql = "SELECT * FROM RESULTATSEMESTRE WHERE INE_ETUDIANT = '" + etudiant.getIne() + "';";
            ResultSet rs = conn.statement.executeQuery(sql);
            
            ResultatSemestre resultat;
            
            while(rs.next()) {
                resultat = new ResultatSemestre();
                resultat.setCode(rs.getString("CODE"));
                resultat.setMoyenne(rs.getDouble("MOYENNE"));
                resultat.setPosition(rs.getInt("POSITION"));
                
                resultats.add(resultat);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ResultatSemestreDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Fermeture de la connexion
            conn.close();
        }
        
        return resultats;
    }
    
}
