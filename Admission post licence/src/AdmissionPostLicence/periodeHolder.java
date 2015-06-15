package AdmissionPostLicence;

/**
 * Holder class for : periode
 * 
 * @author OpenORB Compiler
 */
final public class periodeHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal periode value
     */
    public AdmissionPostLicence.periode value;

    /**
     * Default constructor
     */
    public periodeHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public periodeHolder(AdmissionPostLicence.periode initial)
    {
        value = initial;
    }

    /**
     * Read periode from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = periodeHelper.read(istream);
    }

    /**
     * Write periode into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        periodeHelper.write(ostream,value);
    }

    /**
     * Return the periode TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return periodeHelper.type();
    }

}
