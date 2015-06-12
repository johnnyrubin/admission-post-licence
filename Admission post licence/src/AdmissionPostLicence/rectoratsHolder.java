package AdmissionPostLicence;

/**
 * Holder class for : rectorats
 * 
 * @author OpenORB Compiler
 */
final public class rectoratsHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal rectorats value
     */
    public AdmissionPostLicence.Rectorat[] value;

    /**
     * Default constructor
     */
    public rectoratsHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public rectoratsHolder(AdmissionPostLicence.Rectorat[] initial)
    {
        value = initial;
    }

    /**
     * Read rectorats from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = rectoratsHelper.read(istream);
    }

    /**
     * Write rectorats into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        rectoratsHelper.write(ostream,value);
    }

    /**
     * Return the rectorats TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return rectoratsHelper.type();
    }

}
