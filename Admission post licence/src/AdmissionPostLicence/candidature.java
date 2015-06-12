package AdmissionPostLicence;

/**
 * Struct definition : candidature
 * 
 * @author OpenORB Compiler
*/
public final class candidature implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member etudiant
     */
    public AdmissionPostLicence.identite etudiant;

    /**
     * Struct member master
     */
    public String master;

    /**
     * Struct member universite
     */
    public String universite;

    /**
     * Struct member ordre
     */
    public short ordre;

    /**
     * Struct member etat
     */
    public AdmissionPostLicence.etatCandidature etat;

    /**
     * Struct member decisionC
     */
    public AdmissionPostLicence.decisionCandidat decisionC;

    /**
     * Struct member decisionM
     */
    public AdmissionPostLicence.decisionMaster decisionM;

    /**
     * Default constructor
     */
    public candidature()
    { }

    /**
     * Constructor with fields initialization
     * @param etudiant etudiant struct member
     * @param master master struct member
     * @param universite universite struct member
     * @param ordre ordre struct member
     * @param etat etat struct member
     * @param decisionC decisionC struct member
     * @param decisionM decisionM struct member
     */
    public candidature(AdmissionPostLicence.identite etudiant, String master, String universite, short ordre, AdmissionPostLicence.etatCandidature etat, AdmissionPostLicence.decisionCandidat decisionC, AdmissionPostLicence.decisionMaster decisionM)
    {
        this.etudiant = etudiant;
        this.master = master;
        this.universite = universite;
        this.ordre = ordre;
        this.etat = etat;
        this.decisionC = decisionC;
        this.decisionM = decisionM;
    }

}
