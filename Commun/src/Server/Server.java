package Server;

import Database.Connexion;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;
import org.omg.PortableServer.Servant;

/**
 * Classe générique pour les serveurs
 * 
 */
public abstract class Server {
    
    /** Contient l'orb accessible par les autres classes */
    protected static org.omg.CORBA.ORB orb;
    
    /** Contient le POA utilisé entre autres pour récupérer les IOR des servants */
    protected static POA rootPOA;
    
    /** Adresse IP du NamingService CORBA */
    protected static  String ipNamingService;
    
    /** Fichier qui contient les propriétés du serveur */
    private static FileInputStream fileConfig;
    
    /** Propriétés issues du fichier de configuration */
    protected static Properties serverConfig;
    
    /** Connexion à la base de données du serveur */
    protected static Connexion conn;
    
    /**
     * 
     * @return {@link ORB}
     */
    public static org.omg.CORBA.ORB getOrb() {
        return orb;
    }
    
    /**
     * 
     * @return {@link Connexion}
     */
    public static Connexion getConnexionDb() {
        return conn;
    }
    
    /**
     * Retourne la chaine de caractère contenant l'IOR d'un servant CORBA
     * 
     * @param unServant
     * @return String
     */
    public static String getIorFromObject(Servant unServant) {
        String retour = null;
        
        if(unServant != null) {
            try {
                retour = orb.object_to_string(rootPOA.servant_to_reference(unServant));
            } catch (ServantNotActive | WrongPolicy ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
        return retour;
    }
    
    /**
     * Charge le contenu du fichier de configuration dans une variable de classe
     */
    protected static void loadConfigFile() {
        try {
            // Récupération des paramètres du serveur
            fileConfig = new FileInputStream("serverConfig.properties");
            serverConfig = new Properties();
            serverConfig.load(fileConfig);
            
            // Récupération de l'adresse IP du Naming Service CORBA
            if(serverConfig.containsKey("ipNamingService")) {
                ipNamingService = serverConfig.getProperty("ipNamingService");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Méthode qui doit être appelée à la fin du code d'un serveur
     */
    protected static void shutdown() {
        // Fermeture du fichier de configuration
        if(fileConfig != null) {
            try {
                fileConfig.close();
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(conn != null) {
            // Fermeture de la connexion
            conn.close();
        }
    }
    
}
