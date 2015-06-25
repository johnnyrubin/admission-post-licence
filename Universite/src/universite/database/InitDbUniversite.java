package universite.database;

import Database.Connexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe utilisée pour initialiser la base de données de l'université.
 * Cela comprend la création des tables et l'insertion des jeux de données initiaux
 * 
 */
public class InitDbUniversite {
    
    /** Connexion à la base de données universitaire */
    private static Connexion conn;
    
    private static String universite;
    
    /**
     * 
     * @param uneConn
     * @param uneUniversite
     */
    public static void run(Connexion uneConn, String uneUniversite) {
        
        if(uneConn != null && uneUniversite != null) {  
            universite = uneUniversite;
            
            // Connexion à la base de données
            conn = uneConn;

            try {
                initTableEtudiant();

                initTableResultatSemestre();

                initTableMaster();

                initTableLicence();

                initTablePrerequis();

            } catch (SQLException ex) {
                Logger.getLogger(InitDbUniversite.class.getName()).log(Level.SEVERE, null, ex);
            }
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

        // Création de la table ETUDIANT
        sql = "CREATE TABLE ETUDIANT " +
                "(INE TEXT PRIMARY KEY," +
                "NOM TEXT NOT NULL," +
                "PRENOM TEXT NOT NULL," +
                "MDP TEXT NOT NULL,"+
                "UNIVERSITE TEXT NOT NULL,"+
                "LICENCE TEXT NOT NULL)";

        conn.statement.executeUpdate(sql);
        
        // Création jeux de données
        HashMap<String, String[]> jeuxDonnees = new HashMap<>();
        
        String[] jeuxDonneesToulouse = {
            "INSERT INTO ETUDIANT values ('123456E','dupond','jean','toto','Paul sabatier','INFO');",
            "INSERT INTO ETUDIANT values ('E001','RUBIN','Johnny','batman','Paul sabatier','MIAGE');",
            "INSERT INTO ETUDIANT values ('E002','VIGNEAUX','Vincent','bcp','Paul sabatier','MUSICOLOGIE');",
            "INSERT INTO ETUDIANT values ('E004','TACSIN','Teddy','corba','Paul sabatier','MIAGE');"
        };
        
        String[] jeuxDonneesBordeaux = {
            "INSERT INTO ETUDIANT values ('E003','DESPRATS','Thierry','udp', 'Bordeaux 1', 'INFO');"
        };
        
        jeuxDonnees.put("Paul Sabatier", jeuxDonneesToulouse);
        jeuxDonnees.put("Bordeaux 1", jeuxDonneesBordeaux);
        
        // Insertion des étudiants
        for(String req : jeuxDonnees.get(universite)) {
            conn.statement.executeUpdate(req);
        }
    }
    
    /**
     * Création de la table RESULTATSEMESTRE
     * 
     * @throws SQLException 
     */
    private static void initTableResultatSemestre() throws SQLException {
        // Suppression de la table RESULTATSEMESTRE
        String sql = "DROP TABLE IF EXISTS RESULTATSEMESTRE;";

        conn.statement.executeUpdate(sql);

        // Création de la table RESULTATSEMESTRE
        sql = "CREATE TABLE RESULTATSEMESTRE " +
                "(CODE TEXT PRIMARY KEY," +
                "SEMESTRE TEXT NOT NULL," +
                "MOYENNE REAL NOT NULL," +
                "POSITION INTEGER NOT NULL," +
                "INE_ETUDIANT TEXT NOT NULL," +
                "SESSION TEXT NOT NULL)";

        conn.statement.executeUpdate(sql);
        
        // Création jeux de données
        HashMap<String, String[]> jeuxDonnees = new HashMap<>();
        
        String[] jeuxDonneesToulouse = {
            "INSERT INTO ResultatSemestre values ('N1','S1',15,5,'E001','1');",
            "INSERT INTO ResultatSemestre values ('N2','S2',16,4,'E001','1');",
            "INSERT INTO ResultatSemestre values ('N3','S3',17,3,'E001','1');",
            "INSERT INTO ResultatSemestre values ('N4','S4',18,2,'E001','1');",
            "INSERT INTO ResultatSemestre values ('N5','S5',12,20,'E001','1');",
            "INSERT INTO ResultatSemestre values ('N6','S6',18,1,'E001','1');",
            "INSERT INTO ResultatSemestre values ('N7','S1',10,50,'E002','1');",
            "INSERT INTO ResultatSemestre values ('N8','S2',11,30,'E002','1');",
            "INSERT INTO ResultatSemestre values ('N9','S3',12,25,'E002','1');",
            "INSERT INTO ResultatSemestre values ('N10','S4',13,21,'E002','2');",
            "INSERT INTO ResultatSemestre values ('N11','S5',14,19,'E002','1');",
            "INSERT INTO ResultatSemestre values ('N12','S6',10,50,'E002','1');",
            "INSERT INTO ResultatSemestre values ('N13','S1',15,5,'123456E','1');",
            "INSERT INTO ResultatSemestre values ('N14','S2',16,4,'123456E','1');",
            "INSERT INTO ResultatSemestre values ('N15','S3',17,3,'123456E','1');",
            "INSERT INTO ResultatSemestre values ('N16','S4',18,2,'123456E','2');",
            "INSERT INTO ResultatSemestre values ('N17','S5',12,20,'123456E','1');",
            "INSERT INTO ResultatSemestre values ('N18','S6',18,1,'123456E','1');",
            "INSERT INTO ResultatSemestre values ('N19','S1',9,50,'E004','1');",
            "INSERT INTO ResultatSemestre values ('N20','S2',9,40,'E004','R');",
            "INSERT INTO ResultatSemestre values ('N21','S3',10,30,'E004','2');",
            "INSERT INTO ResultatSemestre values ('N22','S4',8,20,'E004','R');",
            "INSERT INTO ResultatSemestre values ('N23','S5',11,20,'E004','2');",
            "INSERT INTO ResultatSemestre values ('N24','S6',13,10,'E004','1');"
        };
        
        String[] jeuxDonneesBordeaux = {
            "INSERT INTO ResultatSemestre values ('N1','S1',15,5,'E003','1');",
            "INSERT INTO ResultatSemestre values ('N2','S2',16,4,'E003','1');",
            "INSERT INTO ResultatSemestre values ('N3','S3',17,3,'E003','1');",
            "INSERT INTO ResultatSemestre values ('N4','S4',18,2,'E003','1');",
            "INSERT INTO ResultatSemestre values ('N5','S5',15,12,'E003','1');",
            "INSERT INTO ResultatSemestre values ('N6','S6',18,1,'E003','1');"
        };
        
        jeuxDonnees.put("Paul Sabatier", jeuxDonneesToulouse);
        jeuxDonnees.put("Bordeaux 1", jeuxDonneesBordeaux);
        
        // Insertion des résultats
        for(String req : jeuxDonnees.get(universite)) {
            conn.statement.executeUpdate(req);
        }
    }
    
    /**
     * Création de la table MASTER
     * 
     * @throws SQLException 
     */
    private static void initTableMaster() throws SQLException {
        // Suppression de la table MASTER
        String sql = "DROP TABLE IF EXISTS MASTER;";
        conn.statement.executeUpdate(sql);

        // Création de la table MASTER
        sql = "CREATE TABLE MASTER " +
                "(ID INTEGER PRIMARY KEY," +
                "NOM TEXT NOT NULL)";
        conn.statement.executeUpdate(sql);
        
        // Création jeux de données
        HashMap<String, String[]> jeuxDonnees = new HashMap<>();
        
        String[] jeuxDonneesToulouse = {
            "INSERT INTO MASTER values (1, 'MIAGE');",
            "INSERT INTO MASTER values (2, 'INFO');",
            "INSERT INTO MASTER values (3, 'BIO');"
        };
        
        String[] jeuxDonneesBordeaux = {
            "INSERT INTO MASTER values (1, 'MIAGE');",
            "INSERT INTO MASTER values (2, 'DROIT');"
        };
        
        jeuxDonnees.put("Paul Sabatier", jeuxDonneesToulouse);
        jeuxDonnees.put("Bordeaux 1", jeuxDonneesBordeaux);
        
        // Insertion des masters
        for(String req : jeuxDonnees.get(universite)) {
            conn.statement.executeUpdate(req);
        }
        
        ResultSet set = conn.statement.executeQuery("SELECT * FROM MASTER;");
        while(set.next()) {
            System.out.println(set.getString("NOM"));
        }
    }
    
    /**
     * Création de la table LICENCE
     * 
     * @throws SQLException 
     */
    private static void initTableLicence() throws SQLException {
        // Suppression de la table LICENCE
        String sql = "DROP TABLE IF EXISTS LICENCE;";

        conn.statement.executeUpdate(sql);

        // Création de la table LICENCE
        sql = "CREATE TABLE LICENCE " +
                "(ID INTEGER PRIMARY KEY," +
                "NOM TEXT NOT NULL)";

        conn.statement.executeUpdate(sql);
        
        // Création jeux de données
        HashMap<String, String[]> jeuxDonnees = new HashMap<>();
        
        String[] jeuxDonneesToulouse = {
            "INSERT INTO Licence values (1,'MIAGE');",
            "INSERT INTO Licence values (2,'INFO');",
            "INSERT INTO Licence values (3,'MUSICOLOGIE');"
        };
        
        String[] jeuxDonneesBordeaux = {
            "INSERT INTO Licence values (1, 'INFO');",
            "INSERT INTO Licence values (2, 'DROIT');"
        };
        
        jeuxDonnees.put("Paul Sabatier", jeuxDonneesToulouse);
        jeuxDonnees.put("Bordeaux 1", jeuxDonneesBordeaux);
        
        // Insertion des licences
        for(String req : jeuxDonnees.get(universite)) {
            conn.statement.executeUpdate(req);
        }
    }
    
    /**
     * Création de la table PREREQUIS
     * 
     * @throws SQLException 
     */
    private static void initTablePrerequis() throws SQLException {
        // Suppression de la table PREREQUIS
        String sql = "DROP TABLE IF EXISTS PREREQUIS;";

        conn.statement.executeUpdate(sql);

        // Création de la table PREREQUIS
        sql = "CREATE TABLE PREREQUIS " +
                "(ID_MASTER INTEGER NOT NULL," +
                "ID_LICENCE INTEGER NOT NULL," +
                "PRIMARY KEY (ID_MASTER, ID_LICENCE))";

        conn.statement.executeUpdate(sql);
        
        // Création jeux de données
        HashMap<String, String[]> jeuxDonnees = new HashMap<>();
        
        String[] jeuxDonneesToulouse = {
            "INSERT INTO PREREQUIS values (1,'MIAGE');",
            "INSERT INTO PREREQUIS values (1,'INFO');",
            "INSERT INTO PREREQUIS values (2,'INFO');"
        };
        
        String[] jeuxDonneesBordeaux = {
            "INSERT INTO PREREQUIS values (1, 'MIAGE');",
            "INSERT INTO PREREQUIS values (1, 'INFO');",
            "INSERT INTO PREREQUIS values (2, 'DROIT');"
        };
        
        jeuxDonnees.put("Paul Sabatier", jeuxDonneesToulouse);
        jeuxDonnees.put("Bordeaux 1", jeuxDonneesBordeaux);
        
        // Insertion des licences
        for(String req : jeuxDonnees.get(universite)) {
            conn.statement.executeUpdate(req);
        }
    }
    
}
