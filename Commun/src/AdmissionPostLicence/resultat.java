package AdmissionPostLicence;

/**
 * Struct definition : resultat
 * 
 * @author OpenORB Compiler
*/
public final class resultat implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member code
     */
    public String code;

    /**
     * Struct member moyenne
     */
    public float moyenne;

    /**
     * Struct member position
     */
    public short position;

    /**
     * Default constructor
     */
    public resultat()
    { }

    /**
     * Constructor with fields initialization
     * @param code code struct member
     * @param moyenne moyenne struct member
     * @param position position struct member
     */
    public resultat(String code, float moyenne, short position)
    {
        this.code = code;
        this.moyenne = moyenne;
        this.position = position;
    }

}
