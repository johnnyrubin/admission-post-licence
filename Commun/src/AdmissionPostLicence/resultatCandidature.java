package AdmissionPostLicence;

/**
 * Struct definition : resultatCandidature
 * 
 * @author OpenORB Compiler
*/
public final class resultatCandidature implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member c
     */
    public AdmissionPostLicence.candidature c;

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
    public resultatCandidature()
    { }

    /**
     * Constructor with fields initialization
     * @param c c struct member
     * @param etat etat struct member
     * @param decisionC decisionC struct member
     * @param decisionM decisionM struct member
     */
    public resultatCandidature(AdmissionPostLicence.candidature c, AdmissionPostLicence.etatCandidature etat, AdmissionPostLicence.decisionCandidat decisionC, AdmissionPostLicence.decisionMaster decisionM)
    {
        this.c = c;
        this.etat = etat;
        this.decisionC = decisionC;
        this.decisionM = decisionM;
    }

}
