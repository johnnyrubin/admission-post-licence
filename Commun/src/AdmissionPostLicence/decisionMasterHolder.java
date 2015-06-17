package AdmissionPostLicence;

/**
 * Holder class for : decisionMaster
 * 
 * @author OpenORB Compiler
 */
final public class decisionMasterHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal decisionMaster value
     */
    public AdmissionPostLicence.decisionMaster value;

    /**
     * Default constructor
     */
    public decisionMasterHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public decisionMasterHolder(AdmissionPostLicence.decisionMaster initial)
    {
        value = initial;
    }

    /**
     * Read decisionMaster from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = decisionMasterHelper.read(istream);
    }

    /**
     * Write decisionMaster into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        decisionMasterHelper.write(ostream,value);
    }

    /**
     * Return the decisionMaster TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return decisionMasterHelper.type();
    }

}
