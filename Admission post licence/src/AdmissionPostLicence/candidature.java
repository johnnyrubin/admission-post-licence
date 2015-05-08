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
     */
    public candidature(AdmissionPostLicence.identite etudiant, String master, String universite, short ordre)
    {
        this.etudiant = etudiant;
        this.master = master;
        this.universite = universite;
        this.ordre = ordre;
    }

}
