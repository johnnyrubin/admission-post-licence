/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

/**
 *
 * @author johnny
 */
public class GetObjectCorba {
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
            NamingContext root = org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));
            org.omg.CosNaming.NameComponent[] nameToFind = new org.omg.CosNaming.NameComponent[1];
            
            // On récupère le rectorat
            nameToFind[0] = new org.omg.CosNaming.NameComponent(name, "");
            org.omg.CORBA.Object remoteRef = root.resolve(nameToFind);
            r = RectoratHelper.narrow(remoteRef);
        } catch (InvalidName ex) {
            Logger.getLogger(GetObjectCorba.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotFound ex) {
            Logger.getLogger(GetObjectCorba.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CannotProceed ex) {
            Logger.getLogger(GetObjectCorba.class.getName()).log(Level.SEVERE, null, ex);
        } catch (org.omg.CosNaming.NamingContextPackage.InvalidName ex) {
            Logger.getLogger(GetObjectCorba.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
    
     /**
     * Permet de récupérer l'objet CORBA du master de l'université
     * 
     * @param master
     * @param universite
     * @param orb
     * @return {@link Master}
     */
    public static Master getMasterCorba(String master,String universite, org.omg.CORBA.ORB orb) {
        // Initialisation de la variable de retour
        Master r = null;
        
        try {
            NamingContext root = org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));
            org.omg.CosNaming.NameComponent[] nameToFind = new org.omg.CosNaming.NameComponent[1];
            
            // On récupère le rectorat
            nameToFind[0] = new org.omg.CosNaming.NameComponent(master+"-"+universite, "");
            org.omg.CORBA.Object remoteRef = root.resolve(nameToFind);
            r = MasterHelper.narrow(remoteRef);
        
        } catch (InvalidName | NotFound | CannotProceed | org.omg.CosNaming.NamingContextPackage.InvalidName ex) {
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
        
        System.out.println("Méthode GetObjectCorba.getMinistereCorba : Début");
        
        // Initialisation de la variable de retour
        Ministere m = null;
        
        try {
            NamingContext root = org.omg.CosNaming.NamingContextHelper.narrow(orb.string_to_object("corbaloc:iiop:1.2@192.168.0.13:2001/NameService"));
            org.omg.CosNaming.NameComponent[] nameToFind = new org.omg.CosNaming.NameComponent[1];
            
            // On récupère le ministère
            nameToFind[0] = new org.omg.CosNaming.NameComponent("Ministere", "");
            org.omg.CORBA.Object remoteRef = root.resolve(nameToFind);
            m = MinistereHelper.narrow(remoteRef);
            
        } catch (NotFound | CannotProceed | org.omg.CosNaming.NamingContextPackage.InvalidName ex) {
            Logger.getLogger(GetObjectCorba.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Méthode GetObjectCorba.getMinistereCorba : Fin");
        
        return m;
    }
    
    public static Master getMasterCorba(String ior, org.omg.CORBA.ORB orb) {
        return MasterHelper.narrow(orb.string_to_object(ior)); 
    }
    
    public static Rectorat getRectoratCorba(org.omg.CORBA.ORB orb, String ior) {
        return RectoratHelper.narrow(orb.string_to_object(ior)); 
    }
    
    public static GestionEtudiant getGestionEtudiantCorba(org.omg.CORBA.ORB orb, String ior) {
        return GestionEtudiantHelper.narrow(orb.string_to_object(ior)); 
    }
}
