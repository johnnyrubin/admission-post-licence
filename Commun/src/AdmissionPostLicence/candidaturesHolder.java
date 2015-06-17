package AdmissionPostLicence;

/**
 * Holder class for : candidatures
 * 
 * @author OpenORB Compiler
 */
final public class candidaturesHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal candidatures value
     */
    public AdmissionPostLicence.candidature[] value;

    /**
     * Default constructor
     */
    public candidaturesHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public candidaturesHolder(AdmissionPostLicence.candidature[] initial)
    {
        value = initial;
    }

    /**
     * Read candidatures from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = candidaturesHelper.read(istream);
    }

    /**
     * Write candidatures into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        candidaturesHelper.write(ostream,value);
    }

    /**
     * Return the candidatures TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return candidaturesHelper.type();
    }

}
