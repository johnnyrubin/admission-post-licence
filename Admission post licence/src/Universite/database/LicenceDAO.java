package Universite.database;

import java.util.List;
import Universite.pojo.Licence;
import Universite.pojo.Master;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe d'accès aux données des licences dans la BD
 * 
 * @author Teddy
 */
public class LicenceDAO {
    
    /**
     * Récupère les licences qui sont requises pour candidater à un master
     * 
     * @param master
     * @return {@link List}<{@link Licence}>
     */
    public static List<Licence> getPrerequisFromMaster(Master master) {
        // Initialisation de la variable de retour
        List<Licence> licences = new ArrayList<>();
        
        // Connexion à la base de données
        ConnexionUniversite conn = new ConnexionUniversite("default.db");
        conn.connect();
        
        try {
            // Récupération de la liste des licence prérequise
            String sql = "SELECT L.* FROM LICENCE L, PREREQUIS P WHERE L.ID = P.ID_LICENCE AND P.ID_MASTER = " + master.getId() + ";";
            ResultSet rs = conn.statement.executeQuery(sql);

            Licence licence;
            
            while(rs.next()) {
                licence = new Licence();
                licence.setId(rs.getInt("ID"));
                licence.setNom(rs.getString("NOM"));
                
                licences.add(licence);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MasterDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Fermeture de la connexion
            conn.close();
        }
        
        return licences;
    }
    
}
