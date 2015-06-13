package AdmissionPostLicence;

/**
 * Interface definition : Ministere
 * 
 * @author OpenORB Compiler
 */
public interface MinistereOperations
{
    /**
     * Operation recupererAccreditations
     */
    public AdmissionPostLicence.accreditation[] recupererAccreditations();

    /**
     * Operation transfererCandidature
     */
    public void transfererCandidature(AdmissionPostLicence.candidature c);

    /**
     * Operation transfererDecision
     */
    public void transfererDecision(AdmissionPostLicence.candidature r)
        throws AdmissionPostLicence.CandidatureInconnu;

    /**
     * Operation getListeRectorat
     */
    public String[] getListeRectorat();

    /**
     * Operation enregistrerRectorat
     */
    public void enregistrerRectorat(String ior);

}
