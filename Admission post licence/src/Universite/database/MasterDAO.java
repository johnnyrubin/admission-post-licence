package Universite.database;

import Universite.pojo.Master;
import Universite.pojo.Licence;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe d'accès aux données des master dans la BD
 * 
 * @author Teddy
 */
public class MasterDAO {
    
    /**
     * Récupère les données d'un master à partir de son nom
     * 
     * @param aNom
     * @return {@link Master}
     */
    public static Master getFromNom(String aNom) {
        // Initialisation de la variable de retour
        Master master = null;
        
        // Connexion à la base de données
        ConnexionUniversite conn = new ConnexionUniversite("default.db");
        conn.connect();
            
        try {
            System.out.println("MasterDAO.getFromNom aNom => "+aNom);
            // Exécution de la requête de récupération du master
            String sql = "SELECT * FROM MASTER WHERE NOM = '" + aNom + "';";
            ResultSet rs = conn.statement.executeQuery(sql);
            
            if(rs.next()) {
                // Traitement du résultat
                master = new Master();
                master.setId(rs.getInt("ID"));
                master.setNom(rs.getString("NOM"));
                
                // Récupération de la liste des licence prérequise
                List<Licence> licences = LicenceDAO.getPrerequisFromMaster(master);
                
                master.setPrerequis(licences);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MasterDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Fermeture de la connexion
            conn.close();
        }
        
        return master;
    }
    
}
