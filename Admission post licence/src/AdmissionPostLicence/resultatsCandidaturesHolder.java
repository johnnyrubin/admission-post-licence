package AdmissionPostLicence;

/**
 * Holder class for : resultatsCandidatures
 * 
 * @author OpenORB Compiler
 */
final public class resultatsCandidaturesHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal resultatsCandidatures value
     */
    public AdmissionPostLicence.resultatCandidature[] value;

    /**
     * Default constructor
     */
    public resultatsCandidaturesHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public resultatsCandidaturesHolder(AdmissionPostLicence.resultatCandidature[] initial)
    {
        value = initial;
    }

    /**
     * Read resultatsCandidatures from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = resultatsCandidaturesHelper.read(istream);
    }

    /**
     * Write resultatsCandidatures into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        resultatsCandidaturesHelper.write(ostream,value);
    }

    /**
     * Return the resultatsCandidatures TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return resultatsCandidaturesHelper.type();
    }

}
