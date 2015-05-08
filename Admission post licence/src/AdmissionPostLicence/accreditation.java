package AdmissionPostLicence;

/**
 * Struct definition : accreditation
 * 
 * @author OpenORB Compiler
*/
public final class accreditation implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member universite
     */
    public String universite;

    /**
     * Struct member master
     */
    public String master;

    /**
     * Default constructor
     */
    public accreditation()
    { }

    /**
     * Constructor with fields initialization
     * @param universite universite struct member
     * @param master master struct member
     */
    public accreditation(String universite, String master)
    {
        this.universite = universite;
        this.master = master;
    }

}
