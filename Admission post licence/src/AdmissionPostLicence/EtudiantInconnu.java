package AdmissionPostLicence;

/**
 * Exception definition : EtudiantInconnu
 * 
 * @author OpenORB Compiler
 */
public final class EtudiantInconnu extends org.omg.CORBA.UserException
{
    /**
     * Exception member raison
     */
    public String raison;

    /**
     * Exception member id
     */
    public int id;

    /**
     * Default constructor
     */
    public EtudiantInconnu()
    {
        super(EtudiantInconnuHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param raison raison exception member
     * @param id id exception member
     */
    public EtudiantInconnu(String raison, int id)
    {
        super(EtudiantInconnuHelper.id());
        this.raison = raison;
        this.id = id;
    }

    /**
     * Full constructor with fields initialization
     * @param raison raison exception member
     * @param id id exception member
     */
    public EtudiantInconnu(String orb_reason, String raison, int id)
    {
        super(EtudiantInconnuHelper.id() +" " +  orb_reason);
        this.raison = raison;
        this.id = id;
    }

}
