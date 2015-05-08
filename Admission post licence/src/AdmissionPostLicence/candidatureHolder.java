package AdmissionPostLicence;

/**
 * Holder class for : candidature
 * 
 * @author OpenORB Compiler
 */
final public class candidatureHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal candidature value
     */
    public AdmissionPostLicence.candidature value;

    /**
     * Default constructor
     */
    public candidatureHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public candidatureHolder(AdmissionPostLicence.candidature initial)
    {
        value = initial;
    }

    /**
     * Read candidature from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = candidatureHelper.read(istream);
    }

    /**
     * Write candidature into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        candidatureHelper.write(ostream,value);
    }

    /**
     * Return the candidature TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return candidatureHelper.type();
    }

}
