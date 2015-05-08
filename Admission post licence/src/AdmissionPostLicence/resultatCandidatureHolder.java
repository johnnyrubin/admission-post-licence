package AdmissionPostLicence;

/**
 * Holder class for : resultatCandidature
 * 
 * @author OpenORB Compiler
 */
final public class resultatCandidatureHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal resultatCandidature value
     */
    public AdmissionPostLicence.resultatCandidature value;

    /**
     * Default constructor
     */
    public resultatCandidatureHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public resultatCandidatureHolder(AdmissionPostLicence.resultatCandidature initial)
    {
        value = initial;
    }

    /**
     * Read resultatCandidature from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = resultatCandidatureHelper.read(istream);
    }

    /**
     * Write resultatCandidature into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        resultatCandidatureHelper.write(ostream,value);
    }

    /**
     * Return the resultatCandidature TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return resultatCandidatureHelper.type();
    }

}
