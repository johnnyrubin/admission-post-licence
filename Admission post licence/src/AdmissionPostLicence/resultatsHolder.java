package AdmissionPostLicence;

/**
 * Holder class for : resultats
 * 
 * @author OpenORB Compiler
 */
final public class resultatsHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal resultats value
     */
    public AdmissionPostLicence.resultat[] value;

    /**
     * Default constructor
     */
    public resultatsHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public resultatsHolder(AdmissionPostLicence.resultat[] initial)
    {
        value = initial;
    }

    /**
     * Read resultats from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = resultatsHelper.read(istream);
    }

    /**
     * Write resultats into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        resultatsHelper.write(ostream,value);
    }

    /**
     * Return the resultats TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return resultatsHelper.type();
    }

}
