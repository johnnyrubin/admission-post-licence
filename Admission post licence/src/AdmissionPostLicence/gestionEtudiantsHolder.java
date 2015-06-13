package AdmissionPostLicence;

/**
 * Holder class for : gestionEtudiants
 * 
 * @author OpenORB Compiler
 */
final public class gestionEtudiantsHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal gestionEtudiants value
     */
    public String[] value;

    /**
     * Default constructor
     */
    public gestionEtudiantsHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public gestionEtudiantsHolder(String[] initial)
    {
        value = initial;
    }

    /**
     * Read gestionEtudiants from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = gestionEtudiantsHelper.read(istream);
    }

    /**
     * Write gestionEtudiants into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        gestionEtudiantsHelper.write(ostream,value);
    }

    /**
     * Return the gestionEtudiants TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return gestionEtudiantsHelper.type();
    }

}
