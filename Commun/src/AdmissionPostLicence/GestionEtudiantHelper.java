package AdmissionPostLicence;

/** 
 * Helper class for : GestionEtudiant
 *  
 * @author OpenORB Compiler
 */ 
public class GestionEtudiantHelper
{
    /**
     * Insert GestionEtudiant into an any
     * @param a an any
     * @param t GestionEtudiant value
     */
    public static void insert(org.omg.CORBA.Any a, AdmissionPostLicence.GestionEtudiant t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract GestionEtudiant from an any
     * @param a an any
     * @return the extracted GestionEtudiant value
     */
    public static AdmissionPostLicence.GestionEtudiant extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return AdmissionPostLicence.GestionEtudiantHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the GestionEtudiant TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"GestionEtudiant");
        }
        return _tc;
    }

    /**
     * Return the GestionEtudiant IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:AdmissionPostLicence/GestionEtudiant:1.0";

    /**
     * Read GestionEtudiant from a marshalled stream
     * @param istream the input stream
     * @return the readed GestionEtudiant value
     */
    public static AdmissionPostLicence.GestionEtudiant read(org.omg.CORBA.portable.InputStream istream)
    {
        return(AdmissionPostLicence.GestionEtudiant)istream.read_Object(AdmissionPostLicence._GestionEtudiantStub.class);
    }

    /**
     * Write GestionEtudiant into a marshalled stream
     * @param ostream the output stream
     * @param value GestionEtudiant value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, AdmissionPostLicence.GestionEtudiant value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to GestionEtudiant
     * @param obj the CORBA Object
     * @return GestionEtudiant Object
     */
    public static GestionEtudiant narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof GestionEtudiant)
            return (GestionEtudiant)obj;

        if (obj._is_a(id()))
        {
            _GestionEtudiantStub stub = new _GestionEtudiantStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to GestionEtudiant
     * @param obj the CORBA Object
     * @return GestionEtudiant Object
     */
    public static GestionEtudiant unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof GestionEtudiant)
            return (GestionEtudiant)obj;

        _GestionEtudiantStub stub = new _GestionEtudiantStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
