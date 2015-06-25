package universite.database;

import Database.Connexion;
import java.util.List;
import Pojo.ResultatSemestre;
import Pojo.Etudiant;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe d'accès aux données des résultats scolaires dans la BD
 * 
 * 
 */
public class ResultatSemestreDAO extends UniversiteDAO {
    
    /**
     * 
     * @param unNomUniversite 
     * @param uneConn 
     */
    public ResultatSemestreDAO(String unNomUniversite, Connexion uneConn) {
        super(unNomUniversite, uneConn);
    }
    
    /**
     * Récupère les résultats de l'étudiant fourni
     * 
     * @param etudiant
     * @return {@link List}<{@link ResultatSemestre}>
     */
    public List<ResultatSemestre> getFromEtudiant(Etudiant etudiant) {
        // Initialisation de la variable de retour
        List<ResultatSemestre> resultats = new ArrayList<>();
            
        try {
            // Récupération des résultats scolaire de l'étudiant
            String sql = "SELECT * FROM RESULTATSEMESTRE WHERE INE_ETUDIANT = '" + etudiant.getIne() + "';";
            ResultSet rs = conn.statement.executeQuery(sql);
            
            ResultatSemestre resultat;
            
            while(rs.next()) {
                resultat = new ResultatSemestre();
                resultat.setCode(rs.getString("SEMESTRE"));
                resultat.setMoyenne(rs.getDouble("MOYENNE"));
                resultat.setPosition(rs.getInt("POSITION"));
                
                resultats.add(resultat);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ResultatSemestreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resultats;
    }
    
}
