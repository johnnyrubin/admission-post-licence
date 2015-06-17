package AdmissionPostLicence;

/**
 * Holder class for : identite
 * 
 * @author OpenORB Compiler
 */
final public class identiteHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal identite value
     */
    public AdmissionPostLicence.identite value;

    /**
     * Default constructor
     */
    public identiteHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public identiteHolder(AdmissionPostLicence.identite initial)
    {
        value = initial;
    }

    /**
     * Read identite from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = identiteHelper.read(istream);
    }

    /**
     * Write identite into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        identiteHelper.write(ostream,value);
    }

    /**
     * Return the identite TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return identiteHelper.type();
    }

}
