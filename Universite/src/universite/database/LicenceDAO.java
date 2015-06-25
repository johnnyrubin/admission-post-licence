package universite.database;

import Database.Connexion;
import java.util.List;
import Pojo.Licence;
import Pojo.Master;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe d'accès aux données des licences dans la BD
 * 
 * 
 */
public class LicenceDAO extends UniversiteDAO {
    
    /**
     * 
     * @param unNomUniversite 
     */
    public LicenceDAO(String unNomUniversite, Connexion uneConn) {
        super(unNomUniversite, uneConn);
    }
    
    /**
     * Récupère les licences qui sont requises pour candidater à un master
     * 
     * @param master
     * @return {@link List}<{@link Licence}>
     */
    public List<Licence> getPrerequisFromMaster(Master master) {
        // Initialisation de la variable de retour
        List<Licence> licences = new ArrayList<>();
        
        try {
            // Récupération de la liste des licence prérequise
            String sql = "SELECT * FROM PREREQUIS WHERE ID_MASTER = " + master.getId() + ";";
            ResultSet rs = conn.statement.executeQuery(sql);

            Licence licence;
            
            while(rs.next()) {
                licence = new Licence();
                licence.setId(0);
                licence.setNom(rs.getString("ID_LICENCE"));
                
                licences.add(licence);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LicenceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return licences;
    }
    
}
