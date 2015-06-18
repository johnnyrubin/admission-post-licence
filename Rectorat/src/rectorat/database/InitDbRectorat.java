package rectorat.database;

import AdmissionPostLicence.decisionMaster;
import AdmissionPostLicence.etatCandidature;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
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
            displayInfo();
        } catch (SQLException ex) {
            Logger.getLogger(InitDbRectorat.class.getName()).log(Level.SEVERE, null, ex);
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
        sql = "Insert into RECTORAT values ( 1, 'Rectorat' )";
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
                "PRIMARY KEY(INE,IDMASTER)"
                + ")";
        
        // Création de la table CANDIDATURES
        conn.statement.executeUpdate(sql);
        
        // Insertion des candidatures dans la table
        // TODO voir avec Vincent pour les données
        sql = "Insert into CANDIDATURES values ( '123456E', 'MIAGE', 'Paul Sabatier', 1, "+etatCandidature.valide.value() +" , 0 , "
                + decisionMaster.listeAttente.value() +" )";
        conn.statement.executeUpdate(sql);
        sql = "Insert into CANDIDATURES values ( '123456E', 'Fonda', 'Paul Sabatier', 2, "+etatCandidature.valide.value() +" , 0 , "
                + decisionMaster.refuser.value() +" )";
        conn.statement.executeUpdate(sql);
        sql = "Insert into CANDIDATURES values ( '123456E', 'Bio', 'Paul Sabatier', 3, "+etatCandidature.nonValide.value() +" , 0 , "
                + decisionMaster.refuser.value() +" )";
        conn.statement.executeUpdate(sql);
        sql = "Insert into CANDIDATURES values ( '123456E', 'Test', 'Paul Sabatier', 4, "+etatCandidature.valide.value() +" , 0 , "
                + decisionMaster.admis.value() +" )";
        conn.statement.executeUpdate(sql);
        sql = "Insert into CANDIDATURES values ( '123456E', 'Titi', 'Paul Sabatier', 5, "+etatCandidature.valide.value() +" , 0 , "
                + decisionMaster.refuser.value() +" )";
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
        
        // Insertion des étudiants dans la table
        // TODO voir avec Vincent pour les données
        
        sql = "INSERT INTO ETUDIANT VALUES ('123456E', 'dupond', 'jean','Paul sabatier','info');";
        conn.statement.executeUpdate(sql);
    }
    
    private static void displayInfo(){
        String sql = "select * from candidatures";
        try {
            ResultSet rs = conn.statement.executeQuery(sql);
            while(rs.next()){
                String INE = rs.getString("INE");
                String IDMASTER = rs.getString("IDMASTER");
                String UNIVERSITE = rs.getString("UNIVERSITE");
                int ordre = rs.getInt("ORDRE");
                System.out.println("Candidatures : " + INE + " " + IDMASTER + " " +  UNIVERSITE +  " " + ordre);
            }
            sql = "select * from etudiant";
            rs = conn.statement.executeQuery(sql);
            while(rs.next()){
                String ID = rs.getString("INE");
                String NOM = rs.getString("NOM");
                String PRENOM = rs.getString("PRENOM");
                System.out.println("Etudiant : " + ID + " " + NOM + " " + PRENOM);
            }
            sql = "select * from rectorat";
            rs = conn.statement.executeQuery(sql);
            while(rs.next()){
                String ID = rs.getString("ID");
                String NOM = rs.getString("NOM");
                System.out.println("Rectorat : " + ID + " " + NOM);
            }
        } catch (SQLException ex) {
            Logger.getLogger(InitDbRectorat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
