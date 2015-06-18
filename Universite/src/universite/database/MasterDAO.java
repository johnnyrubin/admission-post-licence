/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universite.database;

import Pojo.Licence;
import Pojo.Master;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Universite.database.LicenceDAO;


public class MasterDAO extends UniversiteDAO {

    public MasterDAO(String unNomUniversite) {
        super(unNomUniversite);
    }
    
    /**
     * Récupère les données d'un master à partir de son nom
     * 
     * @param aNom
     * @return {@link Master}
     */
    public Master getFromNom(String aNom) {
        // Initialisation de la variable de retour
        Master master = null;
            
        try {
            // Exécution de la requête de récupération du master
            String sql = "SELECT * FROM MASTER WHERE NOM = '" + aNom + "';";
            ResultSet rs = conn.statement.executeQuery(sql);
            
            if(rs.next()) {
                // Traitement du résultat
                master = new Master();
                master.setId(rs.getInt("ID"));
                master.setNom(rs.getString("NOM"));
                
                // Récupération de la liste des licence prérequise
                LicenceDAO dao = new LicenceDAO(nomUniversite);
                List<Licence> licences = dao.getPrerequisFromMaster(master);
                
                master.setPrerequis(licences);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MasterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return master;
    }
    
    /**
     * Retourne la liste des masters de l'universite
     * 
     * @return List<{@link Master}>
     */
    public List<Master> getAll() {        
        // Initialisation de la variable de retour
        List<Master> masters = new ArrayList<>();
        
        try {
            // Exécution de la requête de récupération du master
            String sql = "SELECT * FROM MASTER;";
            ResultSet rs = this.conn.statement.executeQuery(sql);
            
            while(rs.next()) {
                // Traitement du résultat
                Master m = new Master();
                m.setId(rs.getInt("ID"));
                m.setNom(rs.getString("NOM"));
                
                // Récupération de la liste des licence prérequise
                LicenceDAO dao = new LicenceDAO(nomUniversite);
                List<Licence> licences = dao.getPrerequisFromMaster(m);
                m.setPrerequis(licences);
                
                masters.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MasterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return masters;
    }
}
