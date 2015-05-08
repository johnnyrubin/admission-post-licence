package Universite.Master;

import AdmissionPostLicence.EtudiantInconnu;
import AdmissionPostLicence.GestionEtudiantPOA;
import AdmissionPostLicence.MasterInconnu;
import AdmissionPostLicence.candidature;
import AdmissionPostLicence.decisionCandidat;
import AdmissionPostLicence.identite;
import AdmissionPostLicence.resultatCandidature;
import AdmissionPostLicence.resultatsEtudiant;

/**
 *
 * @author Teddy
 */
public class MasterImpl extends GestionEtudiantPOA {

    @Override
    public void soumettreCandidature(candidature c) throws MasterInconnu {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public resultatsEtudiant recupererResultats(identite etudiant) throws EtudiantInconnu {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public resultatCandidature[] consulterEtatVoeux(identite etudiant) throws EtudiantInconnu {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifierDecision(candidature c, decisionCandidat dc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public identite seConnecter(String ine, String mdp) throws EtudiantInconnu {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
