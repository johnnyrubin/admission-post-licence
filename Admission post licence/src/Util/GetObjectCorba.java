/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import AdmissionPostLicence.GestionEtudiant;
import AdmissionPostLicence.GestionEtudiantHelper;
import AdmissionPostLicence.Rectorat;
import AdmissionPostLicence.RectoratHelper;
import Universite.GestionEtudiant.GestionEtudiantImpl;
import Universite.pojo.Etudiant;
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
     * @return {@link Rectorat}
     */
    public static Rectorat getRectoratCorba(String name,org.omg.CORBA.ORB orb) {
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
     * Permet de récupérer l'etudiant de GestionEtudiant CORBA
     * 
     * @return {@link Etudiant}
     */
    public static Etudiant getEtudiant(String universite,String ine,org.omg.CORBA.ORB orb) {
        // Initialisation de la variable de retour
        GestionEtudiantImpl g = null;
        try {
            NamingContext root = org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));
            org.omg.CosNaming.NameComponent[] nameToFind = new org.omg.CosNaming.NameComponent[1];
            
            // On récupère le rectorat
            nameToFind[0] = new org.omg.CosNaming.NameComponent("GestionEtudiant-"+universite, "");
            org.omg.CORBA.Object remoteRef = root.resolve(nameToFind);
            g = (GestionEtudiantImpl)GestionEtudiantHelper.narrow(remoteRef);
        } catch (InvalidName ex) {
            Logger.getLogger(GetObjectCorba.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotFound ex) {
            Logger.getLogger(GetObjectCorba.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CannotProceed ex) {
            Logger.getLogger(GetObjectCorba.class.getName()).log(Level.SEVERE, null, ex);
        } catch (org.omg.CosNaming.NamingContextPackage.InvalidName ex) {
            Logger.getLogger(GetObjectCorba.class.getName()).log(Level.SEVERE, null, ex);
        }
        return g.getEtudiant(ine);
    }
}
