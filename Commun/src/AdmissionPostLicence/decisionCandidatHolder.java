package AdmissionPostLicence;

/**
 * Holder class for : decisionCandidat
 * 
 * @author OpenORB Compiler
 */
final public class decisionCandidatHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal decisionCandidat value
     */
    public AdmissionPostLicence.decisionCandidat value;

    /**
     * Default constructor
     */
    public decisionCandidatHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public decisionCandidatHolder(AdmissionPostLicence.decisionCandidat initial)
    {
        value = initial;
    }

    /**
     * Read decisionCandidat from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = decisionCandidatHelper.read(istream);
    }

    /**
     * Write decisionCandidat into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        decisionCandidatHelper.write(ostream,value);
    }

    /**
     * Return the decisionCandidat TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return decisionCandidatHelper.type();
    }

}
