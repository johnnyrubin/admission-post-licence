package AdmissionPostLicence;

/**
 * Holder class for : accreditations
 * 
 * @author OpenORB Compiler
 */
final public class accreditationsHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal accreditations value
     */
    public AdmissionPostLicence.accreditation[] value;

    /**
     * Default constructor
     */
    public accreditationsHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public accreditationsHolder(AdmissionPostLicence.accreditation[] initial)
    {
        value = initial;
    }

    /**
     * Read accreditations from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = accreditationsHelper.read(istream);
    }

    /**
     * Write accreditations into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        accreditationsHelper.write(ostream,value);
    }

    /**
     * Return the accreditations TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return accreditationsHelper.type();
    }

}
