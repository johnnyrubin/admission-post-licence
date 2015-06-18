package universite.database;

/**
 *
 * 
 */
public class UniversiteDAO {
    
    /** Nom de l'université */
    protected String nomUniversite;
    
    /** Connexion à la base de données universitaire */
    protected ConnexionUniversite conn;
    
    /**
     * 
     * @param unNomUniversite 
     */
    public UniversiteDAO(String unNomUniversite) {
        // On enlève les espaces présents dans le nom de l'université
        nomUniversite =  unNomUniversite.replaceAll("\\s", "").toLowerCase();

        // Connexion à la base de données
        conn = new ConnexionUniversite(nomUniversite + ".db");
        conn.connect();
    }
    
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        
        if(conn != null) {
            // Fermeture de la connexion
            conn.close();
        }
    }
    
}
