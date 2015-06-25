package rectorat;

import Database.Connexion;
import Server.Server;
import java.io.File;
import rectorat.database.InitDbRectorat;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

/**
 * Classe principale d'un serveur rectorat
 * 
 */
public class ServerRectorat extends Server {
    
    /** Nom du rectorat */
    private static String nomRectorat;
    
    public static void main(String[] args) {
        try {
            // Chargement du fichier de config
            loadConfigFile();
            
            // Récupération des paramètres spécifiques au serveur rectorat
            if(serverConfig.containsKey("nomRectorat")) {
                nomRectorat = serverConfig.getProperty("nomRectorat");
            }
            
            // On enleve les espaces dans le nom du rectorat pour nommer le fichier db
            String nomRectoratDb =  nomRectorat.replaceAll("\\s", "").toLowerCase();
            String nomDbFile = "rectorat-" + nomRectoratDb + ".db";
            
            // Vérifie si la BD du serveur existe déjà
            File dbFile = new File(nomDbFile);
            boolean dbFileExists = false;
            if(dbFile.exists() && !dbFile.isDirectory()) {
                dbFileExists = true;
            }
            
            // Connexion à la base de données
            conn = new Connexion(nomDbFile);
            conn.connect();
            
            // Initialisation de la base de données si nécessaire
            if(!dbFileExists) {
                InitDbRectorat.run(conn, nomRectorat);
            }
            
            // Intialisation de l'ORB
            orb = org.omg.CORBA.ORB.init(args, null);
            orb.string_to_object("corbaloc:iiop:1.2@" + ipNamingService + ":2001/NameService");
            
            // Récupération du POA
            rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            
            // Création du servant pour la gestion des étudiants
            RectoratImpl rectorat = new RectoratImpl(nomRectorat);
            
            // Activer le POA manager
            rootPOA.the_POAManager().activate();
            
            // Récupération du naming service
            NamingContext nameRoot = org.omg.CosNaming.NamingContextHelper.narrow(orb.string_to_object("corbaloc:iiop:1.2@" + ipNamingService + ":2001/NameService"));
            
            // Construction du nom à enregistrer
            org.omg.CosNaming.NameComponent[] nameToRegister = new org.omg.CosNaming.NameComponent[1];
            nameToRegister[0] = new org.omg.CosNaming.NameComponent(nomRectorat, "");
            
            // Enregistrement de l'objet CORBA dans le service de noms
            nameRoot.rebind(nameToRegister, rootPOA.servant_to_reference(rectorat));
            System.out.println("==> Nom \"" + nomRectorat + "\" est enregistré dans l'espace de noms");
            
            String IORServant = orb.object_to_string(rootPOA.servant_to_reference(rectorat));
            System.out.println("L'objet possède la référence suivante : ");
            System.out.println(IORServant);
            
            // Lancement de l'ORB et mise en attente de la requête
            orb.run();
            
             // Traitement à réaliser lors de l'extinction du serveur
            shutdown();
            
        } catch(InvalidName | ServantNotActive | WrongPolicy | NotFound | CannotProceed | org.omg.CosNaming.NamingContextPackage.InvalidName | AdapterInactive ex) {
            Logger.getLogger(ServerRectorat.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /**
     * Surcharge de la méthode shutdown afin de fermer la connexion à la BD
     */
    protected static void shutdown() {
        Server.shutdown();
        
        if(conn != null) {
            // Fermeture de la connexion
            conn.close();
        }
    }
}
