package AdmissionPostLicence;

/**
 * Holder class for : resultatsEtudiant
 * 
 * @author OpenORB Compiler
 */
final public class resultatsEtudiantHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal resultatsEtudiant value
     */
    public AdmissionPostLicence.resultatsEtudiant value;

    /**
     * Default constructor
     */
    public resultatsEtudiantHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public resultatsEtudiantHolder(AdmissionPostLicence.resultatsEtudiant initial)
    {
        value = initial;
    }

    /**
     * Read resultatsEtudiant from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = resultatsEtudiantHelper.read(istream);
    }

    /**
     * Write resultatsEtudiant into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        resultatsEtudiantHelper.write(ostream,value);
    }

    /**
     * Return the resultatsEtudiant TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return resultatsEtudiantHelper.type();
    }

}
