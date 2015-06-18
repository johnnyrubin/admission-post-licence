package Util;

import AdmissionPostLicence.GestionEtudiant;
import AdmissionPostLicence.GestionEtudiantHelper;
import AdmissionPostLicence.Master;
import AdmissionPostLicence.MasterHelper;
import AdmissionPostLicence.Ministere;
import AdmissionPostLicence.MinistereHelper;
import AdmissionPostLicence.Rectorat;
import AdmissionPostLicence.RectoratHelper;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

/**
 *
 * 
 */
public class GetObjectCorba {
    
    private static final String ipServeur = "192.168.0.12";
    
    /**
     * Permet de récupérer l'objet CORBA du rectorat de l'université de ce master
     * 
     * @param name
     * @param orb
     * @return {@link Rectorat}
     */
    public static Rectorat getRectoratCorba(String name, org.omg.CORBA.ORB orb) {
        // Initialisation de la variable de retour
        Rectorat r = null;
        try {
            NamingContext root = org.omg.CosNaming.NamingContextHelper.narrow(orb.string_to_object("corbaloc:iiop:1.2@" + ipServeur + ":2001/NameService"));
            org.omg.CosNaming.NameComponent[] nameToFind = new org.omg.CosNaming.NameComponent[1];
            
            // On récupère le rectorat
            nameToFind[0] = new org.omg.CosNaming.NameComponent(name, "");
            org.omg.CORBA.Object remoteRef = root.resolve(nameToFind);
            r = RectoratHelper.narrow(remoteRef);
        } catch (NotFound | CannotProceed | org.omg.CosNaming.NamingContextPackage.InvalidName ex) {
            Logger.getLogger(GetObjectCorba.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
    
    /**
     * Permet de récupérer l'objet CORBA du ministère
     * 
     * @param orb
     * @return {@link Ministere}
     */
    public static Ministere getMinistereCorba(org.omg.CORBA.ORB orb) {        
        // Initialisation de la variable de retour
        Ministere m = null;
        
        try {
            NamingContext root = org.omg.CosNaming.NamingContextHelper.narrow(orb.string_to_object("corbaloc:iiop:1.2@" + ipServeur + ":2001/NameService"));
            org.omg.CosNaming.NameComponent[] nameToFind = new org.omg.CosNaming.NameComponent[1];
            
            // On récupère le ministère
            nameToFind[0] = new org.omg.CosNaming.NameComponent("Ministere", "");
            org.omg.CORBA.Object remoteRef = root.resolve(nameToFind);
            m = MinistereHelper.narrow(remoteRef);
            
        } catch (NotFound | CannotProceed | org.omg.CosNaming.NamingContextPackage.InvalidName ex) {
            Logger.getLogger(GetObjectCorba.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return m;
    }
    
    /**
     * Permet de récupérer l'objet CORBA de l'ior d'un master
     * 
     * @param ior
     * @param orb
     * @return {@link Master}
     */
    public static Master getMasterCorba(String ior, org.omg.CORBA.ORB orb) {        
        return MasterHelper.narrow(orb.string_to_object(ior)); 
    }
    
    /**
     * Permet de récupérer l'objet CORBA de l'ior d'un rectorat
     * 
     * @param orb
     * @param ior
     * @return {@link Rectorat}
     */
    public static Rectorat getRectoratCorba(org.omg.CORBA.ORB orb, String ior) {
        return RectoratHelper.narrow(orb.string_to_object(ior)); 
    }
    
    /**
     * Permet de récupérer l'objet CORBA de l'ior d'une gestion étudiant
     * 
     * @param orb
     * @param ior
     * @return 
     */
    public static GestionEtudiant getGestionEtudiantCorba(org.omg.CORBA.ORB orb, String ior) {
        return GestionEtudiantHelper.narrow(orb.string_to_object(ior)); 
    }
    
    /**
     * 
     * @return ipServeur
     */
    public static String getIpServeur() {
        return ipServeur;
    }
}
