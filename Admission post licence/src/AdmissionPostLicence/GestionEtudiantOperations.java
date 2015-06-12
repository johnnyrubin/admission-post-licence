package AdmissionPostLicence;

/**
 * Interface definition : GestionEtudiant
 * 
 * @author OpenORB Compiler
 */
public interface GestionEtudiantOperations
{
    /**
     * Read accessor for nom attribute
     * @return the attribute value
     */
    public String nom();

    /**
     * Operation soumettreCandidature
     */
    public void soumettreCandidature(AdmissionPostLicence.candidature c)
        throws AdmissionPostLicence.MasterInconnu;

    /**
     * Operation recupererResultats
     */
    public AdmissionPostLicence.resultatsEtudiant recupererResultats(AdmissionPostLicence.identite etudiant)
        throws AdmissionPostLicence.EtudiantInconnu;

    /**
     * Operation consulterEtatVoeux
     */
    public AdmissionPostLicence.candidature[] consulterEtatVoeux(AdmissionPostLicence.identite etudiant)
        throws AdmissionPostLicence.EtudiantInconnu;

    /**
     * Operation modifierDecision
     */
    public void modifierDecision(AdmissionPostLicence.candidature c, AdmissionPostLicence.decisionCandidat dc);

    /**
     * Operation seConnecter
     */
    public AdmissionPostLicence.identite seConnecter(String ine, String mdp)
        throws AdmissionPostLicence.EtudiantInconnu;

}
