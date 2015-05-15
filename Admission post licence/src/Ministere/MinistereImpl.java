package Ministere;

import AdmissionPostLicence.CandidatureInconnu;
import AdmissionPostLicence.MinisterePOA;
import AdmissionPostLicence.accreditation;
import AdmissionPostLicence.candidature;
import AdmissionPostLicence.resultatCandidature;

/**
 *
 * @author Teddy
 */
public class MinistereImpl extends MinisterePOA{
    private accreditation[] mesAccredidations;
    
    public MinistereImpl(){
        accreditation[] arrayTemp= {new accreditation("Paul Sabatier","MIAGE"),new accreditation("Paul Sabatier","Fonda"),
            new accreditation("UT1","MIAGE"),new accreditation("UT1","Droits")};
        mesAccredidations=arrayTemp;
    }
    
    @Override
    public accreditation[] recupererAccreditations() {
        return mesAccredidations;
    }

    @Override
    public void transfererCandidature(candidature c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void transfererDecision(resultatCandidature r) throws CandidatureInconnu {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
