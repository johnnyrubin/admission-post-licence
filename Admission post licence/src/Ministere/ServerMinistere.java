/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Ministere;

import AdmissionPostLicence.accreditation;
import org.omg.CosNaming.NamingContext;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

/**
 *
 * @author johnny
 */
public class ServerMinistere {
    
    /** Contient l'orb accessible par les autres classes */
    public static org.omg.CORBA.ORB orb;
    
    public static void main(String[] args) {

        try {

            // Intialisation de l'ORB
            orb = org.omg.CORBA.ORB.init(args, null);

            // Récupération du POA
            POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));

            // Activer le POA manager
            rootPOA.the_POAManager().activate();

            // Récupération du naming service
            NamingContext nameRoot = org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));

            // Construction du nom à enregistrer
            org.omg.CosNaming.NameComponent[] nameToRegister = new org.omg.CosNaming.NameComponent[1];

            // Création du servant pour le ministere
            MinistereImpl Toulouse = new MinistereImpl();
            accreditation[] mesAccreditations={new accreditation("Paul Sabatier","MIAGE"),new accreditation("Paul Sabatier","Fonda"),
            new accreditation("UT1","MIAGE"),new accreditation("UT1","Droits")};
            Toulouse.setMesAccreditations(mesAccreditations);

            // Activer le servant au sein du POA et récupérer son ID
            // byte[] ToulouseId = rootPOA.activate_object(Toulouse);

            nameToRegister[0] = new org.omg.CosNaming.NameComponent("Toulouse", "");

            // Enregistrement de l'objet CORBA dans le service de noms
            nameRoot.rebind(nameToRegister, rootPOA.servant_to_reference(Toulouse));
            System.out.println("==> Nom \"Toulouse\" est enregistré dans l'espace de noms");

            String IORServant = orb.object_to_string(rootPOA.servant_to_reference(Toulouse));
            System.out.println("L'objet possède la référence suivante : ");
            System.out.println(IORServant);

            // Lancement de l'ORB et mise en attente de la requête
            orb.run();

        } catch(Exception e) {
            e.printStackTrace();
        }
        
    }
}
