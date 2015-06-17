package AdmissionPostLicence;

/**
 * Holder class for : universites
 * 
 * @author OpenORB Compiler
 */
final public class universitesHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal universites value
     */
    public String[] value;

    /**
     * Default constructor
     */
    public universitesHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public universitesHolder(String[] initial)
    {
        value = initial;
    }

    /**
     * Read universites from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = universitesHelper.read(istream);
    }

    /**
     * Write universites into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        universitesHelper.write(ostream,value);
    }

    /**
     * Return the universites TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return universitesHelper.type();
    }

}
