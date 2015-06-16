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
     * Read accessor for universite attribute
     * @return the attribute value
     */
    public String universite();

    /**
     * Read accessor for rectorat attribute
     * @return the attribute value
     */
    public String rectorat();

    /**
     * Operation consulterEtatCandidatures
     */
    public AdmissionPostLicence.candidature[] consulterEtatCandidatures();

    /**
     * Operation modifierDecision
     */
    public void modifierDecision(AdmissionPostLicence.candidature c)
        throws AdmissionPostLicence.CandidatureInconnu;

    /**
     * Operation verifierPrerequis
     */
    public boolean verifierPrerequis(String licence)
        throws AdmissionPostLicence.MasterInconnu;

}
