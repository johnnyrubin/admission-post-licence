package AdmissionPostLicence;

/**
 * Exception definition : CandidatureInconnu
 * 
 * @author OpenORB Compiler
 */
public final class CandidatureInconnu extends org.omg.CORBA.UserException
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
    public CandidatureInconnu()
    {
        super(CandidatureInconnuHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param raison raison exception member
     * @param id id exception member
     */
    public CandidatureInconnu(String raison, int id)
    {
        super(CandidatureInconnuHelper.id());
        this.raison = raison;
        this.id = id;
    }

    /**
     * Full constructor with fields initialization
     * @param raison raison exception member
     * @param id id exception member
     */
    public CandidatureInconnu(String orb_reason, String raison, int id)
    {
        super(CandidatureInconnuHelper.id() +" " +  orb_reason);
        this.raison = raison;
        this.id = id;
    }

}
