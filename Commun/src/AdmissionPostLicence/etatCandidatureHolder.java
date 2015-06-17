package AdmissionPostLicence;

/**
 * Holder class for : etatCandidature
 * 
 * @author OpenORB Compiler
 */
final public class etatCandidatureHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal etatCandidature value
     */
    public AdmissionPostLicence.etatCandidature value;

    /**
     * Default constructor
     */
    public etatCandidatureHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public etatCandidatureHolder(AdmissionPostLicence.etatCandidature initial)
    {
        value = initial;
    }

    /**
     * Read etatCandidature from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = etatCandidatureHelper.read(istream);
    }

    /**
     * Write etatCandidature into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        etatCandidatureHelper.write(ostream,value);
    }

    /**
     * Return the etatCandidature TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return etatCandidatureHelper.type();
    }

}
