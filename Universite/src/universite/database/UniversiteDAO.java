package universite.database;

import Database.Connexion;

/**
 *
 * 
 */
public class UniversiteDAO {
    
    /** Nom de l'université */
    protected String nomUniversite;
    
    /** Connexion à la base de données universitaire */
    protected Connexion conn;
    
    /**
     * 
     * @param unNomUniversite 
     * @param uneConn 
     */
    public UniversiteDAO(String unNomUniversite, Connexion uneConn) {
        // On enlève les espaces présents dans le nom de l'université
        nomUniversite =  unNomUniversite.replaceAll("\\s", "").toLowerCase();

        // Connexion à la base de données
        conn = uneConn;
    }
    
}
