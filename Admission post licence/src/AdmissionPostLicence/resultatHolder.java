package AdmissionPostLicence;

/**
 * Holder class for : resultat
 * 
 * @author OpenORB Compiler
 */
final public class resultatHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal resultat value
     */
    public AdmissionPostLicence.resultat value;

    /**
     * Default constructor
     */
    public resultatHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public resultatHolder(AdmissionPostLicence.resultat initial)
    {
        value = initial;
    }

    /**
     * Read resultat from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = resultatHelper.read(istream);
    }

    /**
     * Write resultat into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        resultatHelper.write(ostream,value);
    }

    /**
     * Return the resultat TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return resultatHelper.type();
    }

}
