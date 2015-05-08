package AdmissionPostLicence;

/**
 * Holder class for : CandidatureInconnu
 * 
 * @author OpenORB Compiler
 */
final public class CandidatureInconnuHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal CandidatureInconnu value
     */
    public AdmissionPostLicence.CandidatureInconnu value;

    /**
     * Default constructor
     */
    public CandidatureInconnuHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public CandidatureInconnuHolder(AdmissionPostLicence.CandidatureInconnu initial)
    {
        value = initial;
    }

    /**
     * Read CandidatureInconnu from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = CandidatureInconnuHelper.read(istream);
    }

    /**
     * Write CandidatureInconnu into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        CandidatureInconnuHelper.write(ostream,value);
    }

    /**
     * Return the CandidatureInconnu TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return CandidatureInconnuHelper.type();
    }

}
