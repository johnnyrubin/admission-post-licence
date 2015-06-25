package rectorat.database;

import Database.Connexion;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * Classe utilisée pour initialiser la base de données du rectorat.
 * Cela comprend la création des tables et l'insertion des jeux de données initiaux
 * 
 */
public class InitDbRectorat {
    
    /** Connexion à la base de données Rectorat */
    private static Connexion conn;
    
    private static String rectorat;
    
    /**
     * 
     * @param uneConn 
     * @param unRectorat 
     */
    public static void run(Connexion uneConn, String unRectorat) {
        
        if(uneConn != null && unRectorat != null) {
            rectorat = unRectorat;
            
            // Connexion à la base de données
            conn = uneConn;

            try {
                initTableRectorat();
                initTableCandidatures();
                initTableEtudiant();
            } catch (SQLException ex) {
                System.out.println("Erreur lors de l'initialisation de la base de données");
            }
        }
    }
    
    /**
     * Création de la table RECTORAT
     * 
     * @throws SQLException 
     */
    private static void initTableRectorat() throws SQLException {
        // Suppression de la table RECTORAT
        String sql = "DROP TABLE IF EXISTS RECTORAT;";

        conn.statement.executeUpdate(sql);

        sql = "CREATE TABLE RECTORAT " +
                "(ID TEXT PRIMARY KEY," +
                "NOM TEXT NOT NULL)";

        // Création de la table RECTORAT
        conn.statement.executeUpdate(sql);
        
        // Insertion des rectorats dans la table
        // TODO voir avec Vincent pour les données
        sql = "INSERT INTO RECTORAT VALUES (1, '" + rectorat + "')";
        conn.statement.executeUpdate(sql);
    }
    
    /**
     * Création de la table CANDIDATURES
     * 
     * @throws SQLException 
     */
    private static void initTableCandidatures() throws SQLException{
    // Suppression de la table CANDIDATURES
        String sql = "DROP TABLE IF EXISTS CANDIDATURES;";

        conn.statement.executeUpdate(sql);

        sql = "CREATE TABLE CANDIDATURES " +
                "(INE TEXT," +
                "IDMASTER TEXT,"+
                "UNIVERSITE TEXT NOT NULL,"+
                "ORDRE NUMBER NOT NULL,"+
                "ETAT NUMBER NOT NULL,"+
                "DECISIONCANDIDAT NUMBER NOT NULL,"+
                "DECISIONMASTER NUMBER NOT NULL,"+
                "PRIMARY KEY(INE,IDMASTER,UNIVERSITE))";
        
        // Création de la table CANDIDATURES
        conn.statement.executeUpdate(sql);
    }
    
    /**
     * Création de la table ETUDIANT
     * 
     * @throws SQLException 
     */
    private static void initTableEtudiant() throws SQLException {
        // Suppression de la table ETUDIANT
        String sql = "DROP TABLE IF EXISTS ETUDIANT;";

        conn.statement.executeUpdate(sql);

        sql = "CREATE TABLE ETUDIANT " +
                "(INE TEXT PRIMARY KEY," +
                "NOM TEXT NOT NULL," +
                "PRENOM TEXT NOT NULL," +
                "UNIVERSITE TEXT NOT NULL,"+
                "LICENCE TEXT NOT NULL)";

        // Création de la table ETUDIANT
        conn.statement.executeUpdate(sql);
        
        // Création jeux de données
        HashMap<String, String[]> jeuxDonnees = new HashMap<>();
        
        String[] jeuxDonneesToulouse = {
            "INSERT INTO ETUDIANT VALUES ('123456E', 'dupond', 'jean', 'Paul Sabatier', 'INFO');",
            "INSERT INTO ETUDIANT VALUES ('E001', 'RUBIN', 'Johnny', 'Paul Sabatier', 'MIAGE');",
            "INSERT INTO ETUDIANT VALUES ('E002', 'VIGNEAUX', 'Vincent', 'Paul Sabatier', 'MUSICOLOGIE');",
            "INSERT INTO ETUDIANT VALUES ('E004', 'TACSIN', 'Teddy', 'Paul Sabatier', 'MIAGE');",
        };
        
        String[] jeuxDonneesBordeaux = {
            "INSERT INTO ETUDIANT VALUES ('E003', 'DESPRATS', 'Thierry', 'Bordeaux 1', 'INFO');"
        };
        
        jeuxDonnees.put("RectoratToulouse", jeuxDonneesToulouse);
        jeuxDonnees.put("RectoratBordeaux", jeuxDonneesBordeaux);
        
        // Insertion des étudiants
        for(String req : jeuxDonnees.get(rectorat)) {
            conn.statement.executeUpdate(req);
        }
    }
    
}
