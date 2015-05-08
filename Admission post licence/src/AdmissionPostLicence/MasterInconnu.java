package AdmissionPostLicence;

/**
 * Exception definition : MasterInconnu
 * 
 * @author OpenORB Compiler
 */
public final class MasterInconnu extends org.omg.CORBA.UserException
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
    public MasterInconnu()
    {
        super(MasterInconnuHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param raison raison exception member
     * @param id id exception member
     */
    public MasterInconnu(String raison, int id)
    {
        super(MasterInconnuHelper.id());
        this.raison = raison;
        this.id = id;
    }

    /**
     * Full constructor with fields initialization
     * @param raison raison exception member
     * @param id id exception member
     */
    public MasterInconnu(String orb_reason, String raison, int id)
    {
        super(MasterInconnuHelper.id() +" " +  orb_reason);
        this.raison = raison;
        this.id = id;
    }

}
