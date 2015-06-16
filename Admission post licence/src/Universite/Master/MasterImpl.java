package Universite.Master;

import AdmissionPostLicence.CandidatureInconnu;
import AdmissionPostLicence.MasterInconnu;
import AdmissionPostLicence.MasterPOA;
import AdmissionPostLicence.Rectorat;
import AdmissionPostLicence.candidature;
import AdmissionPostLicence.decisionMaster;
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
    
    /** Le nom du master */
    private final String nom;
    
    /** Le nom du rectorat auquel appartient l'université de ce master */
    private final String rectorat;
    
    /** Le nom de l'université d'appartenance */
    private final String universite;
    
    public MasterImpl(String aNom, String aRectorat, String aUniversite) {
        nom = aNom;
        rectorat = aRectorat;
        universite = aUniversite;
        
        // Enregistrement auprès du rectorat
        enregistrerSurRectorat();
    }

    @Override
    public void modifierDecision(candidature c, decisionMaster dm) {
        
        System.out.println("Appel de la méthode MasterImpl.modifierDecision");
        
        // Récupération du rectorat
        Rectorat r = GetObjectCorba.getRectoratCorba(rectorat, ServerUniversite.getOrb());
        
        if(r != null) {
            // Création de l'obet resultatCandidature
            candidature res = new candidature(c.etudiant, c.master, c.universite, c.ordre, c.etat, c.decisionC, dm);
            
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
        
        System.out.println("Appel de la méthode MasterImpl.verifierPrerequis");
        
        // On récupère les infos de notre master
        Master master = MasterDAO.getFromNom(nom());
        
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

    @Override
    public candidature[] consulterEtatCandidatures() {
        
        System.out.println("Appel de la méthode MasterImpl.consulterEtatCandidatures");
        
        // Initialisation de la variable de retour
        candidature[] resultats = null;
        
        // Récupération du rectorat
        Rectorat r = GetObjectCorba.getRectoratCorba(rectorat, ServerUniversite.getOrb());
        
        try {
            if(r != null) {
                // Récupération des candidatures
                resultats = r.recupererCandidaturesMaster(universite, nom);
            }
        } catch (MasterInconnu ex) {
            Logger.getLogger(MasterImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resultats;
    }
    
    @Override
    public String nom() {
        return nom;
    }
    
    /**
     * Permet d'enregistrer le master auprès du rectorat
     */
    private void enregistrerSurRectorat() {
        // Récupération du rectorat
        Rectorat r = GetObjectCorba.getRectoratCorba(rectorat, ServerUniversite.getOrb());
        
        r.enregistrerMaster(ServerUniversite.getIorFromObject(this));
    }

    @Override
    public String universite() {
        return universite;
    }

    @Override
    public String rectorat() {
        return rectorat;
    }
}
