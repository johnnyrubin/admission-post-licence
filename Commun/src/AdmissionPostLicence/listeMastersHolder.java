package AdmissionPostLicence;

/**
 * Holder class for : listeMasters
 * 
 * @author OpenORB Compiler
 */
final public class listeMastersHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal listeMasters value
     */
    public String[] value;

    /**
     * Default constructor
     */
    public listeMastersHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public listeMastersHolder(String[] initial)
    {
        value = initial;
    }

    /**
     * Read listeMasters from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = listeMastersHelper.read(istream);
    }

    /**
     * Write listeMasters into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        listeMastersHelper.write(ostream,value);
    }

    /**
     * Return the listeMasters TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return listeMastersHelper.type();
    }

}
