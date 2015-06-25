package ministere.database;

import AdmissionPostLicence.periode;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 */
public class PeriodeDAO {
    /** Connexion à la base de données Ministere */
    private static ConnexionMinistere conn;
    
    public static int getPeriode(){
        int periode=-1;
        try {
            // Connexion à la base de données
            conn = new ConnexionMinistere("Ministere.db");
            conn.connect();
            
            // Exécution de la requête
            String sql = "SELECT periode from Ministere where IDMINISTERE=1;";
            ResultSet rs = conn.statement.executeQuery(sql);
            
            if(rs.next()) {
                periode=rs.getInt("periode");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PeriodeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.close();
        }
        
        return periode;
    }
    
    public static void setPeriode(periode unePeriode) {
        try {
            // Connexion à la base de données
            conn = new ConnexionMinistere("Ministere.db");
            conn.connect();
            
            // Exécution de la requête
            String sql = "UPDATE Ministere SET periode = " + unePeriode.value() + " where IDMINISTERE=1;";
            conn.statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(PeriodeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.close();
        }
    }
}
