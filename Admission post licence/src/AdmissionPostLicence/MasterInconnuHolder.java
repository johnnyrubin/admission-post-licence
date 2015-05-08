package AdmissionPostLicence;

/**
 * Holder class for : MasterInconnu
 * 
 * @author OpenORB Compiler
 */
final public class MasterInconnuHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal MasterInconnu value
     */
    public AdmissionPostLicence.MasterInconnu value;

    /**
     * Default constructor
     */
    public MasterInconnuHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public MasterInconnuHolder(AdmissionPostLicence.MasterInconnu initial)
    {
        value = initial;
    }

    /**
     * Read MasterInconnu from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = MasterInconnuHelper.read(istream);
    }

    /**
     * Write MasterInconnu into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        MasterInconnuHelper.write(ostream,value);
    }

    /**
     * Return the MasterInconnu TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return MasterInconnuHelper.type();
    }

}
