package AdmissionPostLicence;

/** 
 * Helper class for : gestionEtudiants
 *  
 * @author OpenORB Compiler
 */ 
public class gestionEtudiantsHelper
{
    private static final boolean HAS_OPENORB;
    static {
        boolean hasOpenORB = false;
        try {
            Thread.currentThread().getContextClassLoader().loadClass("org.openorb.CORBA.Any");
            hasOpenORB = true;
        }
        catch(ClassNotFoundException ex) {
        }
        HAS_OPENORB = hasOpenORB;
    }
    /**
     * Insert gestionEtudiants into an any
     * @param a an any
     * @param t gestionEtudiants value
     */
    public static void insert(org.omg.CORBA.Any a, AdmissionPostLicence.GestionEtudiant[] t)
    {
        a.insert_Streamable(new AdmissionPostLicence.gestionEtudiantsHolder(t));
    }

    /**
     * Extract gestionEtudiants from an any
     * @param a an any
     * @return the extracted gestionEtudiants value
     */
    public static AdmissionPostLicence.GestionEtudiant[] extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if(HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof AdmissionPostLicence.gestionEtudiantsHolder)
                    return ((AdmissionPostLicence.gestionEtudiantsHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            AdmissionPostLicence.gestionEtudiantsHolder h = new AdmissionPostLicence.gestionEtudiantsHolder(read(a.create_input_stream()));
            a.insert_Streamable(h);
            return h.value;
        }
        return read(a.create_input_stream());
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the gestionEtudiants TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_alias_tc(id(),"gestionEtudiants",orb.create_sequence_tc(0,AdmissionPostLicence.GestionEtudiantHelper.type()));
        }
        return _tc;
    }

    /**
     * Return the gestionEtudiants IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:AdmissionPostLicence/gestionEtudiants:1.0";

    /**
     * Read gestionEtudiants from a marshalled stream
     * @param istream the input stream
     * @return the readed gestionEtudiants value
     */
    public static AdmissionPostLicence.GestionEtudiant[] read(org.omg.CORBA.portable.InputStream istream)
    {
        AdmissionPostLicence.GestionEtudiant[] new_one;
        {
        int size7 = istream.read_ulong();
        new_one = new AdmissionPostLicence.GestionEtudiant[size7];
        for (int i7=0; i7<new_one.length; i7++)
         {
            new_one[i7] = AdmissionPostLicence.GestionEtudiantHelper.read(istream);

         }
        }

        return new_one;
    }

    /**
     * Write gestionEtudiants into a marshalled stream
     * @param ostream the output stream
     * @param value gestionEtudiants value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, AdmissionPostLicence.GestionEtudiant[] value)
    {
        ostream.write_ulong(value.length);
        for (int i7=0; i7<value.length; i7++)
        {
            AdmissionPostLicence.GestionEtudiantHelper.write(ostream,value[i7]);

        }
    }

}
