package Universite.database;

import Pojo.Master;
import Pojo.Licence;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe d'accès aux données des master dans la BD
 * 
 * 
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
    
    /**
     * Retourne la liste des masters d'une université
     * 
     * @param uneUniversite
     * @return List<{@link Master}>
     */
    public static List<Master> getFromUniversite(String aUniversite) {
        
        System.out.println("MasterDAO.getFromUniversite aUniversite => " + aUniversite);
        
        // Initialisation de la variable de retour
        List<Master> masters = new ArrayList<>();
        
        // Connexion à la base de données
        ConnexionUniversite conn = new ConnexionUniversite("default.db");
        conn.connect();
        
        try {
            // Exécution de la requête de récupération du master
            String sql = "SELECT * FROM MASTER;";
            ResultSet rs = conn.statement.executeQuery(sql);
            
            while(rs.next()) {
                // Traitement du résultat
                Master m = new Master();
                m.setId(rs.getInt("ID"));
                m.setNom(rs.getString("NOM"));
                
                // Récupération de la liste des licence prérequise
                List<Licence> licences = LicenceDAO.getPrerequisFromMaster(m);
                m.setPrerequis(licences);
                
                masters.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MasterDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Fermeture de la connexion
            conn.close();
        }
        
        return masters;
    }
    
}
