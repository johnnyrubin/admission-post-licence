package Universite;

import Universite.GestionEtudiant.GestionEtudiantImpl;
import Universite.Master.MasterImpl;
import org.omg.CosNaming.NamingContext;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

/**
 * Classe principale d'un serveur universitaire
 * 
 * @author Teddy
 */
public class ServerUniversite {
    
    /** Contient l'orb accessible par les autres classes */
    public static org.omg.CORBA.ORB orb;
    
    public static void main(String[] args) {
        //TODO remplacer le nom en dur par args[0] ou args[1] je sais plus lequel contient la donnée
        String nameUniversite = "Paul Sabatier";
        
        // TODO remplacer par args
        String nameRectorat = "Toulouse";
        
        try {
            
            // Intialisation de l'ORB
            orb = org.omg.CORBA.ORB.init(args, null);
            
            // Récupération du POA
            POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            
            // Création du servant pour la gestion des étudiants
            GestionEtudiantImpl gestEtu = new GestionEtudiantImpl(nameUniversite, nameRectorat);
            
            // Activer le POA manager
            rootPOA.the_POAManager().activate();
            
            // Activer le servant au sein du POA et récupérer son ID
            rootPOA.activate_object(gestEtu);
            
            // Récupération du naming service
            NamingContext nameRoot = org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));
            
            // Construction du nom à enregistrer
            org.omg.CosNaming.NameComponent[] nameToRegister = new org.omg.CosNaming.NameComponent[1];
            nameToRegister[0] = new org.omg.CosNaming.NameComponent("GestionEtudiant-"+nameUniversite, "");
            
            // Enregistrement de l'objet CORBA dans le service de noms
            nameRoot.rebind(nameToRegister, rootPOA.servant_to_reference(gestEtu));
            System.out.println("==> Nom \"GestionEtudiant\" est enregistré dans l'espace de noms");
            
            String IORServant = orb.object_to_string(rootPOA.servant_to_reference(gestEtu));
            System.out.println("L'objet possède la référence suivante : ");
            System.out.println(IORServant);
            
            // Création du servant pour le master
            // (du coup il peut y en avoir plusieurs ici)
            MasterImpl unMaster = new MasterImpl(nameUniversite, nameRectorat);
            
            // Activer le servant au sein du POA et récupérer son ID
            rootPOA.activate_object(unMaster);
            
            nameToRegister[0] = new org.omg.CosNaming.NameComponent("UnMaster-"+nameUniversite, "");
            
            // Enregistrement de l'objet CORBA dans le service de noms
            nameRoot.rebind(nameToRegister, rootPOA.servant_to_reference(unMaster));
            System.out.println("==> Nom \"UnMaster\" est enregistré dans l'espace de noms");
            
            IORServant = orb.object_to_string(rootPOA.servant_to_reference(unMaster));
            System.out.println("L'objet possède la référence suivante : ");
            System.out.println(IORServant);
            
            // Lancement de l'ORB et mise en attente de la requête
            orb.run();
            
        } catch(Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
