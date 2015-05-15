package Universite.database;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe utilisée pour initialiser la base de données de l'université.
 * Cela comprend la création des tables et l'insertion des jeux de données initiaux
 * 
 * @author Teddy
 */
public class InitDb {
    
    public static void main(String[] args) {
        
        try {
            // Connexion à la base de données
            ConnexionUniversite conn = new ConnexionUniversite("default.db");
            conn.connect();
            
            String sql = "DROP TABLE ETUDIANT;";
            
            conn.statement.executeUpdate(sql);
            
            sql = "CREATE TABLE ETUDIANT " +
                    "(INE TEXT PRIMARY KEY NOT NULL," +
                    "NOM TEXT NOT NULL," +
                    "PRENOM TEXT NOT NULL," +
                    "MDP TEXT NOT NULL)";
            
            // Création de la table ETUDIANT
            conn.statement.executeUpdate(sql);
            
            // Insertion des étudiants dans la table
            // TODO voir avec Vincent pour les données
            
            // Fermeture de la connexion
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(InitDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
