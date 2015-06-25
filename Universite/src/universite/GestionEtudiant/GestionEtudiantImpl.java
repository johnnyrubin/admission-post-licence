package universite.GestionEtudiant;

import Mapper.EtudiantMapper;
import AdmissionPostLicence.CandidatureInconnu;
import AdmissionPostLicence.EtudiantInconnu;
import AdmissionPostLicence.GestionEtudiantPOA;
import AdmissionPostLicence.MasterInconnu;
import AdmissionPostLicence.Rectorat;
import AdmissionPostLicence.candidature;
import AdmissionPostLicence.decisionCandidat;
import AdmissionPostLicence.identite;
import AdmissionPostLicence.resultatsEtudiant;
import universite.ServerUniversite;
import Pojo.Etudiant;
import universite.database.EtudiantDAO;
import Util.GetObjectCorba;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe d'implémentation permettant de gérer les étudiants d'une université
 * 
 */
public class GestionEtudiantImpl extends GestionEtudiantPOA {
    
    /** Nom de l'université que gère la gestion etudiant */
    private final String nom;
    
    /** Le rectorat auquel appartient l'université de ce master */
    private final Rectorat rectorat;
    
    private final EtudiantDAO etudiantDao;
    
    public GestionEtudiantImpl(String aNom, String aRectoratName) {
        nom = aNom;
        rectorat = GetObjectCorba.getRectoratCorba(aRectoratName, ServerUniversite.getOrb());
        
        etudiantDao = new EtudiantDAO(nom, ServerUniversite.getConnexionDb());
        
        // Enregistrement auprès du rectorat
        enregistrerSurRectorat();
    }

    @Override
    public void soumettreCandidature(candidature c) throws MasterInconnu {
        
        System.out.println("Appel de la méthode GestionEtudiantImpl.soumettreCandidature");
        
        // Création de la candidature
        if(rectorat != null) {
            rectorat.creerCandidature(c);
        }
    }

    @Override
    public resultatsEtudiant recupererResultats(identite etudiant) throws EtudiantInconnu {
        
        System.out.println("Appel de la méthode GestionEtudiantImpl.recupererResultats");
        
        // Initialisation de la variable de retour
        resultatsEtudiant resultats = null;        

        // Récupération de l'étudiant dans la base de données de l'université
        Etudiant e = etudiantDao.getFromIne(etudiant.ine);        
        
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
        
        if(rectorat != null) {
            // Création de l'obet resultatCandidature
            candidature res = new candidature(c.etudiant, c.master, c.universite, c.ordre, c.etat, dc, c.decisionM);
            
            try {
                // On transmet la décision de l'étudiant au rectorat
                rectorat.modifierCandidature(res);
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
        Etudiant e = etudiantDao.getFromIne(ine);
        
        if(e != null) {
            // On compare les mots de passe
            System.out.println(e.getMdp() + " = " + mdp);
            if(e.getMdp().equals(mdp)) {
                id = EtudiantMapper.etudiantToIdentiteCorba(e);
            }
        } else {
            throw new EtudiantInconnu();
        }
        
        System.out.println("Méthode GestionEtudiantImpl.seConnecter : identite => " + id);
        
        return id;
    }

    @Override
    public candidature[] consulterEtatVoeux(identite etudiant) throws EtudiantInconnu {
        
        System.out.println("Appel de la méthode GestionEtudiantImpl.consulterEtatVoeux");
        
        // Initialisation de la variable de retour
        candidature[] resultats = null;
        
        // Récupération de l'étudiant dans la base de données de l'université
        Etudiant e = etudiantDao.getFromIne(etudiant.ine);
        
        if(e != null) {            
            if(rectorat != null) {
                // Récupation des candidatures de l'étudiant
                resultats = rectorat.recupererCandidaturesEtudiant(etudiant);
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
        if(rectorat != null) {
            rectorat.enregistrerGE(ServerUniversite.getIorFromObject(this), nom);
        }
    }
    
}
