package AdmissionPostLicence;

/**
 * Interface definition : Rectorat
 * 
 * @author OpenORB Compiler
 */
public class RectoratPOATie extends RectoratPOA
{

    //
    // Private reference to implementation object
    //
    private RectoratOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public RectoratPOATie(RectoratOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public RectoratPOATie(RectoratOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public RectoratOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(RectoratOperations delegate_)
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
     * Operation creerCandidature
     */
    public void creerCandidature(AdmissionPostLicence.candidature c)
    {
        _tie.creerCandidature( c);
    }

    /**
     * Operation recupererCandidaturesMaster
     */
    public AdmissionPostLicence.candidature[] recupererCandidaturesMaster(String master)
        throws AdmissionPostLicence.MasterInconnu
    {
        return _tie.recupererCandidaturesMaster( master);
    }

    /**
     * Operation recupererCandidaturesEtudiant
     */
    public AdmissionPostLicence.candidature[] recupererCandidaturesEtudiant(AdmissionPostLicence.identite etudiant)
        throws AdmissionPostLicence.EtudiantInconnu
    {
        return _tie.recupererCandidaturesEtudiant( etudiant);
    }

    /**
     * Operation modifierCandidature
     */
    public void modifierCandidature(AdmissionPostLicence.candidature candidature)
        throws AdmissionPostLicence.CandidatureInconnu
    {
        _tie.modifierCandidature( candidature);
    }

    /**
     * Operation getListeGestEtu
     */
    public AdmissionPostLicence.GestionEtudiant[] getListeGestEtu()
    {
        return _tie.getListeGestEtu();
    }

    /**
     * Operation enregistrerGE
     */
    public void enregistrerGE(AdmissionPostLicence.GestionEtudiant ge)
    {
        _tie.enregistrerGE( ge);
    }

    /**
     * Operation getListeMaster
     */
    public AdmissionPostLicence.Master[] getListeMaster(String u)
    {
        return _tie.getListeMaster( u);
    }

    /**
     * Operation enregistrerMaster
     */
    public void enregistrerMaster(AdmissionPostLicence.Master m)
    {
        _tie.enregistrerMaster( m);
    }

    /**
     * Operation getListeUniversite
     */
    public String[] getListeUniversite()
    {
        return _tie.getListeUniversite();
    }

}
