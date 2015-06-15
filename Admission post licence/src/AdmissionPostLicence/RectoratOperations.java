package AdmissionPostLicence;

/**
 * Interface definition : Rectorat
 * 
 * @author OpenORB Compiler
 */
public interface RectoratOperations
{
    /**
     * Read accessor for nom attribute
     * @return the attribute value
     */
    public String nom();

    /**
     * Operation creerCandidature
     */
    public void creerCandidature(AdmissionPostLicence.candidature c);

    /**
     * Operation supprimerCandidature
     */
    public void supprimerCandidature(AdmissionPostLicence.candidature c)
        throws AdmissionPostLicence.CandidatureInconnu;

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
     * Operation modifierCandidature
     */
    public void modifierCandidature(AdmissionPostLicence.candidature c)
        throws AdmissionPostLicence.CandidatureInconnu;

    /**
     * Operation getListeGestEtu
     */
    public String[] getListeGestEtu();

    /**
     * Operation enregistrerGE
     */
    public void enregistrerGE(String ior, String universite);

    /**
     * Operation getGestEtu
     */
    public String getGestEtu(String universite);

    /**
     * Operation getListeMaster
     */
    public String[] getListeMaster(String u);

    /**
     * Operation enregistrerMaster
     */
    public void enregistrerMaster(String ior);

    /**
     * Operation getListeUniversite
     */
    public String[] getListeUniversite();

}
