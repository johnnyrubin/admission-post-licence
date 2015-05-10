package Rectorat;

import AdmissionPostLicence.CandidatureInconnu;
import AdmissionPostLicence.EtudiantInconnu;
import AdmissionPostLicence.MasterInconnu;
import AdmissionPostLicence.RectoratPOA;
import AdmissionPostLicence.candidature;
import AdmissionPostLicence.identite;
import AdmissionPostLicence.resultatCandidature;

/**
 *
 * @author Teddy
 */
public class RectoratImpl extends RectoratPOA{

    @Override
    public void creerCandidature(candidature c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public candidature[] recupererCandidaturesMaster(String master) throws MasterInconnu {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public candidature[] recupererCandidaturesEtudiant(identite etudiant) throws EtudiantInconnu {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public resultatCandidature[] consulterEtatCandidatures(candidature[] c) throws CandidatureInconnu {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifierCandidature(resultatCandidature candidature) throws CandidatureInconnu {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
