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
    public void modifierCandidature(AdmissionPostLicence.candidature candidature)
        throws AdmissionPostLicence.CandidatureInconnu;

    /**
     * Operation getListeGestEtu
     */
    public AdmissionPostLicence.GestionEtudiant[] getListeGestEtu();

    /**
     * Operation enregistrerGE
     */
    public void enregistrerGE(AdmissionPostLicence.GestionEtudiant ge);

    /**
     * Operation getListeMaster
     */
    public AdmissionPostLicence.Master[] getListeMaster();

    /**
     * Operation enregistrerMaster
     */
    public void enregistrerMaster(AdmissionPostLicence.Master m);

}
