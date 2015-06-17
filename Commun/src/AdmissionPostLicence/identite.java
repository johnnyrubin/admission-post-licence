package AdmissionPostLicence;

/**
 * Struct definition : identite
 * 
 * @author OpenORB Compiler
*/
public final class identite implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member ine
     */
    public String ine;

    /**
     * Struct member nom
     */
    public String nom;

    /**
     * Struct member prenom
     */
    public String prenom;

    /**
     * Struct member universite
     */
    public String universite;

    /**
     * Struct member licence
     */
    public String licence;

    /**
     * Default constructor
     */
    public identite()
    { }

    /**
     * Constructor with fields initialization
     * @param ine ine struct member
     * @param nom nom struct member
     * @param prenom prenom struct member
     * @param universite universite struct member
     * @param licence licence struct member
     */
    public identite(String ine, String nom, String prenom, String universite, String licence)
    {
        this.ine = ine;
        this.nom = nom;
        this.prenom = prenom;
        this.universite = universite;
        this.licence = licence;
    }

}
