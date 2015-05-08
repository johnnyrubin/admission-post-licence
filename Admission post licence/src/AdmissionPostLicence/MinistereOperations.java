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
    public void transfererDecision(AdmissionPostLicence.resultatCandidature r)
        throws AdmissionPostLicence.CandidatureInconnu;

}
