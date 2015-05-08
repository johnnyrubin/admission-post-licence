package AdmissionPostLicence;

/**
 * Holder class for : GestionEtudiant
 * 
 * @author OpenORB Compiler
 */
final public class GestionEtudiantHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal GestionEtudiant value
     */
    public AdmissionPostLicence.GestionEtudiant value;

    /**
     * Default constructor
     */
    public GestionEtudiantHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public GestionEtudiantHolder(AdmissionPostLicence.GestionEtudiant initial)
    {
        value = initial;
    }

    /**
     * Read GestionEtudiant from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = GestionEtudiantHelper.read(istream);
    }

    /**
     * Write GestionEtudiant into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        GestionEtudiantHelper.write(ostream,value);
    }

    /**
     * Return the GestionEtudiant TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return GestionEtudiantHelper.type();
    }

}
