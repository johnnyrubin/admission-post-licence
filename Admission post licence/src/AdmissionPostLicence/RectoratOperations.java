package AdmissionPostLicence;

/**
 * Interface definition : Rectorat
 * 
 * @author OpenORB Compiler
 */
public interface RectoratOperations
{
    /**
     * Operation creerCandidature
     */
    public void creerCandidature(AdmissionPostLicence.candidature c);

    /**
     * Operation recupererCandidaturesMaster
     */
    public AdmissionPostLicence.candidature[] recupererCandidaturesMaster(String master)
        throws AdmissionPostLicence.MasterInconnu;

    /**
     * Operation recupererCandidaturesEtudiant
     */
    public AdmissionPostLicence.candidature[] recupererCandidaturesEtudiant(AdmissionPostLicence.identite etudiant)
        throws AdmissionPostLicence.EtudiantInconnu;

    /**
     * Operation consulterEtatCandidatures
     */
    public AdmissionPostLicence.resultatCandidature[] consulterEtatCandidatures(AdmissionPostLicence.candidature[] c)
        throws AdmissionPostLicence.CandidatureInconnu;

    /**
     * Operation modifierCandidature
     */
    public void modifierCandidature(AdmissionPostLicence.resultatCandidature candidature)
        throws AdmissionPostLicence.CandidatureInconnu;

}
