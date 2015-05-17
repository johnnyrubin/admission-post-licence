package Rectorat;

import AdmissionPostLicence.CandidatureInconnu;
import AdmissionPostLicence.EtudiantInconnu;
import AdmissionPostLicence.Master;
import AdmissionPostLicence.MasterHelper;
import AdmissionPostLicence.MasterInconnu;
import AdmissionPostLicence.RectoratPOA;
import AdmissionPostLicence.candidature;
import AdmissionPostLicence.identite;
import AdmissionPostLicence.resultatCandidature;
import Rectorat.database.CandidatureDb;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

/**
 *
 * @author Teddy
 */
public class RectoratImpl extends RectoratPOA{

    //La liste des candidatures du rectorat
    private candidature[] lesCandidatures;

    /** Nom du Rectorat */
    private String nom;
    
    /**
     * Retourne le nom du Rectorat
     * 
     * @return le nom
     */
    public String getNom() {
        return nom;
    }
    
    /**
     * Définit le nom du Rectorat
     * 
     * @param aNom 
     */
    public void setNom(String aNom) {
        nom = aNom;
    }

    public RectoratImpl(String nom){
        this.nom=nom;
    }
    
    @Override
    public void creerCandidature(candidature c) {
        // Récupération du rectorat
        Master m = getMasterCorba(c.master);
        try {
            if(m != null) {
                //Vérification des pré requis
                if(m.verifierPrerequis(c.etudiant.licence)){
                    //Enregistrer candidature
                    lesCandidatures=addElement(lesCandidatures, c);
                    CandidatureDb.ajoutCandidature(c, this.nom);
                }  
            }
        } catch (MasterInconnu ex) {
            Logger.getLogger(RectoratImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public candidature[] recupererCandidaturesMaster(String master) throws MasterInconnu {
        candidature[] candidatures={};

        for(int i=0;i<lesCandidatures.length;i++){
           //Si les deux string master sont identique, alors on garde cette candidature 
           if(lesCandidatures[i].master.equals(master)){
               candidatures=addElement(candidatures, lesCandidatures[i]);
           }
        }
        return candidatures;
    }

    @Override
    public candidature[] recupererCandidaturesEtudiant(identite etudiant) throws EtudiantInconnu {
        candidature[] candidatures={};

        for(int i=0;i<lesCandidatures.length;i++){
           //Si les deux string master sont identique, alors on garde cette candidature 
           if(lesCandidatures[i].etudiant.ine.equals(etudiant.ine)){
               candidatures=addElement(candidatures, lesCandidatures[i]);
           }
        }
        return candidatures;
    }

    @Override
    public resultatCandidature[] consulterEtatCandidatures(candidature[] c) throws CandidatureInconnu {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifierCandidature(resultatCandidature candidature) throws CandidatureInconnu {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private Master getMasterCorba(String master) {
        // Initialisation de la variable de retour
        Master r = null;
        
        try {
            NamingContext root = org.omg.CosNaming.NamingContextHelper.narrow(ServerRectorat.orb.resolve_initial_references("NameService"));
            org.omg.CosNaming.NameComponent[] nameToFind = new org.omg.CosNaming.NameComponent[1];
            
            // On récupère le rectorat
            nameToFind[0] = new org.omg.CosNaming.NameComponent(master, "");
            org.omg.CORBA.Object remoteRef = root.resolve(nameToFind);
            r = MasterHelper.narrow(remoteRef);
            
            return r;
        } catch (InvalidName | NotFound | CannotProceed | org.omg.CosNaming.NamingContextPackage.InvalidName ex) {
            Logger.getLogger(RectoratImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return r;
    }
    
    private candidature[] addElement(candidature[] oldArray,candidature newValue){
        //define the new array
        candidature[] newArray = new candidature[oldArray.length + 1];
        //copy values into new array
        for(int i=0;i < oldArray.length;i++)
            newArray[i] = oldArray[i];
        //add new value to the new array
        newArray[newArray.length-1] = newValue;
        
        return newArray;
    }
    
}
