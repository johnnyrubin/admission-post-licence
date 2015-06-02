package Universite.Master;

import AdmissionPostLicence.CandidatureInconnu;
import AdmissionPostLicence.MasterInconnu;
import AdmissionPostLicence.MasterPOA;
import AdmissionPostLicence.Rectorat;
import AdmissionPostLicence.candidature;
import AdmissionPostLicence.decisionMaster;
import AdmissionPostLicence.resultatCandidature;
import Universite.ServerUniversite;
import Universite.database.MasterDAO;
import Universite.pojo.Master;
import Universite.pojo.Licence;
import Util.GetObjectCorba;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe d'implémentation permettant la gestion d'un master
 * 
 * @author Teddy
 */
public class MasterImpl extends MasterPOA {
    
    /** Nom du master */
    private String nom;
    
    /**
     * Retourne le nom du master
     * 
     * @return le nom
     */
    public String getNom() {
        return nom;
    }
    
    /**
     * Définit le nom du master
     * 
     * @param aNom 
     */
    public void setNom(String aNom) {
        nom = aNom;
    }
    
    /** Le nom du rectorat auquel appartient l'université de ce master */
    private String rectorat;
    
    /**
     * Retourne le nom du rectorat
     * 
     * @return
     */
    public String getRectorat() {
        return rectorat;
    }
    
    /**
     * Définit le nom du rectorat
     * 
     * @param aRectorat 
     */
    public void setRectorat(String aRectorat) {
        rectorat = aRectorat;
    }

    @Override
    public resultatCandidature[] consulterEtatCandidatures() {
        // Initialisation de la variable de retour
        resultatCandidature[] resultats = null;
        
        // Récupération du rectorat
        Rectorat r = GetObjectCorba.getRectoratCorba("Toulouse",ServerUniversite.orb);
        
        try {
            if(r != null) {
                // Récupération des candidatures
                candidature[] candidatures = r.recupererCandidaturesMaster(nom);

                if(candidatures != null) {
                    // Récupération des résultats liés aux candidatures
                    resultats = r.consulterEtatCandidatures(candidatures);
                }
            }
        } catch (MasterInconnu | CandidatureInconnu ex) {
            Logger.getLogger(MasterImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resultats;
    }

    @Override
    public void modifierDecision(candidature c, decisionMaster dm) {
        // Récupération du rectorat
        Rectorat r = GetObjectCorba.getRectoratCorba("Toulouse",ServerUniversite.orb);
        
        if(r != null) {
            // Création de l'obet resultatCandidature
            resultatCandidature res = new resultatCandidature(c, null, null, dm);
            
            try {
                // On transmet la décision du responsable au rectorat
                r.modifierCandidature(res);
                
            } catch (CandidatureInconnu ex) {
                Logger.getLogger(MasterImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public boolean verifierPrerequis(String licence) throws MasterInconnu {
        // On récupère les infos de notre master
        Master master = MasterDAO.getFromNom(nom);
        
        // On vérifie maintenant que la licence soit présente dans la liste des prérequis du master
        boolean isPrerequisOk = false;
        
        for(Licence l : master.getPrerequis()) {
            if(l.getNom().equals(licence)) {
                isPrerequisOk = true;
                break;
            }
        }
        
        return isPrerequisOk;
    }

    /**
     * Permet de récupérer l'objet CORBA du rectorat de l'université de ce master
     * 
     * @return {@link Rectorat}
     *
    private Rectorat getRectoratCorba() {
        // Initialisation de la variable de retour
        Rectorat r = null;
        
        try {
            NamingContext root = org.omg.CosNaming.NamingContextHelper.narrow(ServerUniversite.orb.resolve_initial_references("NameService"));
            org.omg.CosNaming.NameComponent[] nameToFind = new org.omg.CosNaming.NameComponent[1];
            
            // On récupère le rectorat
            nameToFind[0] = new org.omg.CosNaming.NameComponent(rectorat, "");
            org.omg.CORBA.Object remoteRef = root.resolve(nameToFind);
            r = RectoratHelper.narrow(remoteRef);
            
        } catch (InvalidName | NotFound | CannotProceed | org.omg.CosNaming.NamingContextPackage.InvalidName ex) {
            Logger.getLogger(MasterImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return r;
    }*/
    
    
}
