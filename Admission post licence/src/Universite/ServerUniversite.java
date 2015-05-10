/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Universite;

import Universite.GestionEtudiant.GestionEtudiantImpl;
import Universite.Master.MasterImpl;
import org.omg.CosNaming.NamingContext;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

/**
 *
 * @author Teddy
 */
public class ServerUniversite {
    
    public static void main(String[] args) {
        
        try {
            
            // Intialisation de l'ORB
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);
            
            // Récupération du POA
            POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            
            // Création du servant pour la gestion des étudiants
            GestionEtudiantImpl gestEtu = new GestionEtudiantImpl();
            
            // Activer le servant au sein du POA et récupérer son ID
            // byte[] gestEtuId = rootPOA.activate_object(gestEtu);
            
            // Activer le POA manager
            rootPOA.the_POAManager().activate();
            
            // Récupération du naming service
            NamingContext nameRoot = org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));
            
            // Construction du nom à enregistrer
            org.omg.CosNaming.NameComponent[] nameToRegister = new org.omg.CosNaming.NameComponent[1];
            nameToRegister[0] = new org.omg.CosNaming.NameComponent("GestionEtudiant", "");
            
            // Enregistrement de l'objet CORBA dans le service de noms
            nameRoot.rebind(nameToRegister, rootPOA.servant_to_reference(gestEtu));
            System.out.println("==> Nom \"GestionEtudiant\" est enregistré dans l'espace de noms");
            
            String IORServant = orb.object_to_string(rootPOA.servant_to_reference(gestEtu));
            System.out.println("L'objet possède la référence suivante : ");
            System.out.println(IORServant);
            
            // Création du servant pour le master
            // (du coup il peut y en avoir plusieurs ici)
            MasterImpl unMaster = new MasterImpl();
            
            // Activer le servant au sein du POA et récupérer son ID
            // byte[] unMasterId = rootPOA.activate_object(unMaster);
            
            nameToRegister[0] = new org.omg.CosNaming.NameComponent("UnMaster", "");
            
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
