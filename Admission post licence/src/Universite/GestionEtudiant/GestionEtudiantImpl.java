package Universite.GestionEtudiant;

import AdmissionPostLicence.CandidatureInconnu;
import AdmissionPostLicence.EtudiantInconnu;
import AdmissionPostLicence.GestionEtudiantPOA;
import AdmissionPostLicence.MasterInconnu;
import AdmissionPostLicence.Rectorat;
import AdmissionPostLicence.candidature;
import AdmissionPostLicence.decisionCandidat;
import AdmissionPostLicence.identite;
import AdmissionPostLicence.resultatsEtudiant;
import Universite.ServerUniversite;
import Universite.pojo.Etudiant;
import Universite.database.EtudiantDAO;
import Util.GetObjectCorba;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe d'implémentation permettant de gérer les étudiants d'une université
 * 
 * @author Teddy
 */
public class GestionEtudiantImpl extends GestionEtudiantPOA {
    
    /** Nom de l'université que gère la gestion etudiant */
    private final String nom;
    
    /** Le nom du rectorat auquel appartient l'université de ce master */
    private final String rectorat;
    
    public GestionEtudiantImpl(String aNom, String aRectorat) {
        nom = aNom;
        rectorat = aRectorat;
        
        // Enregistrement auprès du rectorat
        enregistrerSurRectorat();
    }

    @Override
    public void soumettreCandidature(candidature c) throws MasterInconnu {
        
        System.out.println("Appel de la méthode GestionEtudiantImpl.soumettreCandidature");
        
        // Récupération du rectorat
        Rectorat r = GetObjectCorba.getRectoratCorba(rectorat, ServerUniversite.getOrb());
        
        // Création de la candidature
        if(r != null) {
            r.creerCandidature(c);
        }
    }

    @Override
    public resultatsEtudiant recupererResultats(identite etudiant) throws EtudiantInconnu {
        
        System.out.println("Appel de la méthode GestionEtudiantImpl.recupererResultats");
        
        // Initialisation de la variable de retour
        resultatsEtudiant resultats = null;        

        // Récupération de l'étudiant dans la base de données de l'université
        Etudiant e = EtudiantDAO.getFromIne(etudiant.ine);        
        
        if(e != null) {
            // On convertit les données obtenues en bd en objets utilisés par corba
            resultats = EtudiantMapper.etudiantToResultatsEtudiantCorba(e);
        } else {
            throw new EtudiantInconnu();
        }
        
        return resultats;
    }

    @Override
    public void modifierDecision(candidature c, decisionCandidat dc) {
        
        System.out.println("Appel de la méthode GestionEtudiantImpl.modifierDecision");
        
        // Récupération du rectorat
        Rectorat r = GetObjectCorba.getRectoratCorba(rectorat, ServerUniversite.getOrb());
        
        if(r != null) {
            // Création de l'obet resultatCandidature
            candidature res = new candidature(c.etudiant, c.master, c.universite, c.ordre, c.etat, dc, c.decisionM);
            
            try {
                // On transmet la décision de l'étudiant au rectorat
                r.modifierCandidature(res);
            } catch (CandidatureInconnu ex) {
                Logger.getLogger(GestionEtudiantImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public identite seConnecter(String ine, String mdp) throws EtudiantInconnu {
        
        System.out.println("Appel de la méthode GestionEtudiantImpl.seConnecter");
        
        // Initialisation de la variable de retour
        identite id = null;
        
        // Récupération de l'étudiant dans la base de données de l'université
        Etudiant e = EtudiantDAO.getFromIne(ine);
        
        if(e != null) {
            // On compare les mots de passe
            if(e.getMdp().equals(mdp)) {
                id = EtudiantMapper.etudiantToIdentiteCorba(e);
            }
        } else {
            throw new EtudiantInconnu();
        }
        return id;
    }

    @Override
    public candidature[] consulterEtatVoeux(identite etudiant) throws EtudiantInconnu {
        
        System.out.println("Appel de la méthode GestionEtudiantImpl.consulterEtatVoeux");
        
        // Initialisation de la variable de retour
        candidature[] resultats = null;
        
        // Récupération de l'étudiant dans la base de données de l'université
        Etudiant e = EtudiantDAO.getFromIne(etudiant.ine);
        
        if(e != null) {
            // Récupération du rectorat
            Rectorat r = GetObjectCorba.getRectoratCorba(rectorat, ServerUniversite.getOrb());
            
            if(r != null) {
                // Récupation des candidatures de l'étudiant
                resultats = r.recupererCandidaturesEtudiant(etudiant);
            }
        } else {
            throw new EtudiantInconnu();
        }
        
        return resultats;
    }

    @Override
    public String nom() {
        return nom;
    }
    
    /**
     * Permet d'enregistrer la gestion étudiant auprès du rectorat
     */
    private void enregistrerSurRectorat() {
        // Récupération du rectorat
        Rectorat r = GetObjectCorba.getRectoratCorba(rectorat, ServerUniversite.getOrb());
        
        r.enregistrerGE(ServerUniversite.getIorFromObject(this),nom);
    }
    
}
