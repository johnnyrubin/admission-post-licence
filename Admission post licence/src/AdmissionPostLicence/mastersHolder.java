package AdmissionPostLicence;

/**
 * Holder class for : masters
 * 
 * @author OpenORB Compiler
 */
final public class mastersHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal masters value
     */
    public String[] value;

    /**
     * Default constructor
     */
    public mastersHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public mastersHolder(String[] initial)
    {
        value = initial;
    }

    /**
     * Read masters from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = mastersHelper.read(istream);
    }

    /**
     * Write masters into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        mastersHelper.write(ostream,value);
    }

    /**
     * Return the masters TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return mastersHelper.type();
    }

}
