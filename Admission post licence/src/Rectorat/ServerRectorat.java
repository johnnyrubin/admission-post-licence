/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rectorat;

import Rectorat.database.InitDbRectorat;
import Universite.ServerUniversite;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantAlreadyActive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;
import org.omg.PortableServer.Servant;

/**
 *
 * @author johnny
 */
public class ServerRectorat {
    /** Contient l'orb accessible par les autres classes */
    public static org.omg.CORBA.ORB orb;
    
    private static POA rootPOA;
    
    public static void main(String[] args) {
        try {
            
            // Intialisation de l'ORB
            orb = org.omg.CORBA.ORB.init(args, null);
            
            // Récupération du POA
            rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            
            // Création du servant pour la gestion des étudiants
            RectoratImpl rectorat = new RectoratImpl("RectoratToulouse");
            
            orb.string_to_object("corbaloc:iiop:1.2@192.168.0.28:2001/NameService");

            InitDbRectorat.main(args);
            //Import des données de la base
            //TODO
            
            // Activer le servant au sein du POA et récupérer son ID
            //byte[] rectoratId = rootPOA.activate_object(rectorat);
            
            // Activer le POA manager
            rootPOA.the_POAManager().activate();
            
            // Récupération du naming service
            NamingContext nameRoot = org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));
            
            // Construction du nom à enregistrer
            org.omg.CosNaming.NameComponent[] nameToRegister = new org.omg.CosNaming.NameComponent[1];
            nameToRegister[0] = new org.omg.CosNaming.NameComponent("RectoratToulouse", "");
            
            // Enregistrement de l'objet CORBA dans le service de noms
            nameRoot.rebind(nameToRegister, rootPOA.servant_to_reference(rectorat));
            System.out.println("==> Nom \"Rectorat\" est enregistré dans l'espace de noms");
            
            String IORServant = orb.object_to_string(rootPOA.servant_to_reference(rectorat));
            System.out.println("L'objet possède la référence suivante : ");
            System.out.println(IORServant);
            
            // Lancement de l'ORB et mise en attente de la requête
            orb.run();
        } catch(InvalidName e) {
        } catch (ServantNotActive | WrongPolicy | NotFound | CannotProceed | org.omg.CosNaming.NamingContextPackage.InvalidName | AdapterInactive ex) {
            Logger.getLogger(ServerRectorat.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static String getIorFromObject(Servant o) {
        System.out.println("Méthode ServerRectorat.getIorFromObject : Début");
        String retour = null;
        if(o != null) {
            try {
                retour = orb.object_to_string(rootPOA.servant_to_reference(o));
            } catch (ServantNotActive | WrongPolicy ex) {
                Logger.getLogger(ServerUniversite.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        System.out.println("Méthode ServerRectorat.getIorFromObject : retour => " + retour);
        System.out.println("Méthode ServerRectorat.getIorFromObject : Fin");
        return retour;
    }
}
