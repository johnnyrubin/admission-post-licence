package rectorat.database;

import AdmissionPostLicence.decisionMaster;
import AdmissionPostLicence.etatCandidature;
import java.sql.SQLException;

/**
 *
 */
public class InitDbRectorat {
    /** Connexion à la base de données Rectorat */
    private static ConnexionRectorat conn;
    
    /**
     * 
     * @param args 
     */
    public static void main(String[] args) {
        
        // Connexion à la base de données
        conn = new ConnexionRectorat("RectoratToulouse.db");
        conn.connect();
        try {
            initTableRectorat();
            initTableCandidatures();
            initTableEtudiant();
        } catch (SQLException ex) {
            System.out.println("Erreur lors de l'insertion des données");
        }
        finally{
            // Fermeture de la connexion
            conn.close();  
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
        sql = "INSERT INTO RECTORAT VALUES (1, 'RectoratToulouse')";
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
        
        // Insertion des candidatures dans la table
        String[] jeuxDonnees = {
            "Insert into CANDIDATURES VALUES ('123456E', 'MIAGE', 'Paul Sabatier', 1, "+etatCandidature.valide.value() +" , 0, "
                + decisionMaster.listeAttente.value() +")",
            "Insert into CANDIDATURES VALUES ('123456E', 'INFO', 'Paul Sabatier', 2, "+etatCandidature.valide.value() +" , 0, "
                + decisionMaster.admis.value() +")",
            "Insert into CANDIDATURES VALUES ('123456E', 'BIO', 'Paul Sabatier', 3, "+etatCandidature.nonValide.value() +" , 0, "
                + decisionMaster.refuser.value() +")"
        };
        
        for(String req : jeuxDonnees) {
            conn.statement.executeUpdate(req);
        }
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
        
        String[] jeuxDonnees = {
            "INSERT INTO ETUDIANT VALUES ('123456E', 'dupond', 'jean', 'Paul sabatier', 'INFO');",
            "INSERT INTO ETUDIANT VALUES ('E001', 'RUBIN', 'Johnny', 'Paul sabatier', 'MIAGE');",
            "INSERT INTO ETUDIANT VALUES ('E002', 'VIGNEAUX', 'Vincent', 'Paul sabatier', 'MUSICOLOGIE');",
            "INSERT INTO ETUDIANT VALUES ('E004', 'TACSIN', 'Teddy', 'Paul sabatier', 'MIAGE');",
            "INSERT INTO ETUDIANT VALUES ('E003', 'DESPRATS', 'Thierry', 'Bordeaux 1', 'INFO');"
        };
        
        // Insertion des étudiants
        for(String req : jeuxDonnees) {
            conn.statement.executeUpdate(req);
        }
    }
    
}
