package AdmissionPostLicence;

/**
 * Interface definition : Master
 * 
 * @author OpenORB Compiler
 */
public interface MasterOperations
{
    /**
     * Operation consulterEtatCandidatures
     */
    public AdmissionPostLicence.resultatCandidature[] consulterEtatCandidatures();

    /**
     * Operation modifierDecision
     */
    public void modifierDecision(AdmissionPostLicence.candidature c, AdmissionPostLicence.decisionMaster dm);

    /**
     * Operation verifierPrerequis
     */
    public boolean verifierPrerequis(String licence)
        throws AdmissionPostLicence.MasterInconnu;

}
