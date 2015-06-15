package AdmissionPostLicence;

/**
 * Interface definition : Ministere
 * 
 * @author OpenORB Compiler
 */
public interface MinistereOperations
{
    /**
     * Read accessor for periodeEnCours attribute
     * @return the attribute value
     */
    public AdmissionPostLicence.periode periodeEnCours();

    /**
     * Write accessor for periodeEnCours attribute
     * @param value the attribute value
     */
    public void periodeEnCours(AdmissionPostLicence.periode value);

    /**
     * Operation recupererAccreditations
     */
    public AdmissionPostLicence.accreditation[] recupererAccreditations();

    /**
     * Operation transfererCandidature
     */
    public void transfererCandidature(AdmissionPostLicence.candidature c, String decision);

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
