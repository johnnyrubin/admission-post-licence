package AdmissionPostLicence;

/**
 * Interface definition : GestionEtudiant
 * 
 * @author OpenORB Compiler
 */
public class GestionEtudiantPOATie extends GestionEtudiantPOA
{

    //
    // Private reference to implementation object
    //
    private GestionEtudiantOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public GestionEtudiantPOATie(GestionEtudiantOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public GestionEtudiantPOATie(GestionEtudiantOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public GestionEtudiantOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(GestionEtudiantOperations delegate_)
    {
        _tie = delegate_;
    }

    /**
     * _default_POA method
     */
    public org.omg.PortableServer.POA _default_POA()
    {
        if (_poa != null)
            return _poa;
        else
            return super._default_POA();
    }

    /**
     * Read accessor for nom attribute
     */
    public String nom()
    {
        return _tie.nom();
    }

    /**
     * Operation soumettreCandidature
     */
    public void soumettreCandidature(AdmissionPostLicence.candidature c)
        throws AdmissionPostLicence.MasterInconnu
    {
        _tie.soumettreCandidature( c);
    }

    /**
     * Operation recupererResultats
     */
    public AdmissionPostLicence.resultatsEtudiant recupererResultats(AdmissionPostLicence.identite etudiant)
        throws AdmissionPostLicence.EtudiantInconnu
    {
        return _tie.recupererResultats( etudiant);
    }

    /**
     * Operation consulterEtatVoeux
     */
    public AdmissionPostLicence.candidature[] consulterEtatVoeux(AdmissionPostLicence.identite etudiant)
        throws AdmissionPostLicence.EtudiantInconnu
    {
        return _tie.consulterEtatVoeux( etudiant);
    }

    /**
     * Operation modifierDecision
     */
    public void modifierDecision(AdmissionPostLicence.candidature c, AdmissionPostLicence.decisionCandidat dc)
    {
        _tie.modifierDecision( c,  dc);
    }

    /**
     * Operation seConnecter
     */
    public AdmissionPostLicence.identite seConnecter(String ine, String mdp)
        throws AdmissionPostLicence.EtudiantInconnu
    {
        return _tie.seConnecter( ine,  mdp);
    }

}
