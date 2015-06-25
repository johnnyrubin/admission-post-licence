package universite.Master;

import AdmissionPostLicence.CandidatureInconnu;
import AdmissionPostLicence.MasterInconnu;
import AdmissionPostLicence.MasterPOA;
import AdmissionPostLicence.Rectorat;
import AdmissionPostLicence.candidature;
import universite.ServerUniversite;
import universite.database.MasterDAO;
import Pojo.Master;
import Pojo.Licence;
import Util.GetObjectCorba;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe d'implémentation permettant la gestion d'un master
 * 
 * 
 */
public class MasterImpl extends MasterPOA {
    
    /** Le nom du master */
    private final String nom;
    
    /** Le rectorat auquel appartient l'université de ce master */
    private final Rectorat rectorat;
    
    /** Le nom de l'université d'appartenance */
    private final String universite;
    
    public MasterImpl(String aNom, String aRectoratName, String aUniversite) {
        nom = aNom;
        universite = aUniversite;
        
        // Récupération de l'objet corba du rectorat
        rectorat = GetObjectCorba.getRectoratCorba(aRectoratName, ServerUniversite.getOrb());
        
        // Enregistrement auprès du rectorat
        enregistrerSurRectorat();
    }

    @Override
    public void modifierDecision(candidature c) {
        
        System.out.println("Appel de la méthode MasterImpl.modifierDecision");
        
        if(rectorat != null) {            
            try {
                // On transmet la décision du responsable au rectorat
                rectorat.modifierCandidature(c);
                
            } catch (CandidatureInconnu ex) {
                Logger.getLogger(MasterImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public boolean verifierPrerequis(String licence) throws MasterInconnu {
        
        System.out.println("Appel de la méthode MasterImpl.verifierPrerequis");
        
        // On récupère les infos de notre master
        MasterDAO dao = new MasterDAO(universite, ServerUniversite.getConnexionDb());
        Master master = dao.getFromNom(nom());
        
        // On vérifie maintenant que la licence soit présente dans la liste des prérequis du master
        boolean isPrerequisOk = false;
        
        for(Licence l : master.getPrerequis()) {
            System.out.println(l.getNom() +" = " +licence);
            if(l.getNom().equals(licence)) {
                isPrerequisOk = true;
                break;
            }
        }
        
        System.out.println("Méthode MasterImpl.verifierPrerequis isPrerequisOk => " + isPrerequisOk);
        
        return isPrerequisOk;
    }

    @Override
    public candidature[] consulterEtatCandidatures() {
        
        System.out.println("Appel de la méthode MasterImpl.consulterEtatCandidatures");
        
        // Initialisation de la variable de retour
        candidature[] resultats = null;
        
        try {
            if(rectorat != null) {
                // Récupération des candidatures
                resultats = rectorat.recupererCandidaturesMaster(universite, nom);
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
        if(rectorat != null) {
            rectorat.enregistrerMaster(ServerUniversite.getIorFromObject(this));
        }
    }

    @Override
    public String universite() {
        return universite;
    }
}
