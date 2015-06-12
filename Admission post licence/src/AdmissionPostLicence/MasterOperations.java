package AdmissionPostLicence;

/**
 * Interface definition : Master
 * 
 * @author OpenORB Compiler
 */
public interface MasterOperations
{
    /**
     * Read accessor for nom attribute
     * @return the attribute value
     */
    public String nom();

    /**
     * Operation consulterEtatCandidatures
     */
    public AdmissionPostLicence.candidature[] consulterEtatCandidatures();

    /**
     * Operation modifierDecision
     */
    public void modifierDecision(AdmissionPostLicence.candidature c, AdmissionPostLicence.decisionMaster dm)
        throws AdmissionPostLicence.CandidatureInconnu;

    /**
     * Operation verifierPrerequis
     */
    public boolean verifierPrerequis(String licence)
        throws AdmissionPostLicence.MasterInconnu;

}
