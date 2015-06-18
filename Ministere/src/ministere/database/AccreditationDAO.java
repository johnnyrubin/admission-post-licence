package ministere.database;

import Pojo.Accreditation;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * 
 */
public class AccreditationDAO {
    /** Connexion à la base de données Ministere */
    private static ConnexionMinistere conn;
    
    public static List<Accreditation> getAccreditations(){
        List<Accreditation> lesAccreditation = new ArrayList<>();
        Accreditation a=null;
        String universite;
        String diplome;
        try {
            // Connexion à la base de données
            conn = new ConnexionMinistere("Ministere.db");
            conn.connect();
            
            // Exécution de la requête
            String sql = "SELECT UNIVERSITE, DIPLOME FROM DIPLOME D, UNIVERSITE U, ACCREDITATIONS A WHERE D.IDDIPLOME=A.IDDIPLOME AND "
                    + "U.IDUNIVERSITE=A.IDUNIVERSITE ORDER BY UNIVERSITE;";
            ResultSet rs = conn.statement.executeQuery(sql);
                    
            while(rs.next()) {
                // Traitement du résultat
                System.out.println(rs.getString("UNIVERSITE") + " " + rs.getString("DIPLOME"));
                universite=rs.getString("UNIVERSITE");
                diplome = rs.getString("DIPLOME");
                if(a==null || !a.getUniversite().equals(universite)){
                    a = new Accreditation(universite);
                    a.addDiplome(diplome);
                    lesAccreditation.add(a);
                }
                else if(a.getUniversite().equals(universite)){
                    a.addDiplome(diplome);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccreditationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            // Fermeture de la connexion
            conn.close();  
        }
        return lesAccreditation;
    }
}
