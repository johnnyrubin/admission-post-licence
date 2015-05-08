package AdmissionPostLicence;

/**
 * Holder class for : accreditation
 * 
 * @author OpenORB Compiler
 */
final public class accreditationHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal accreditation value
     */
    public AdmissionPostLicence.accreditation value;

    /**
     * Default constructor
     */
    public accreditationHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public accreditationHolder(AdmissionPostLicence.accreditation initial)
    {
        value = initial;
    }

    /**
     * Read accreditation from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = accreditationHelper.read(istream);
    }

    /**
     * Write accreditation into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        accreditationHelper.write(ostream,value);
    }

    /**
     * Return the accreditation TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return accreditationHelper.type();
    }

}
