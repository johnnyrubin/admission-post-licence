package AdmissionPostLicence;

/** 
 * Helper class for : resultatsEtudiant
 *  
 * @author OpenORB Compiler
 */ 
public class resultatsEtudiantHelper
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
     * Insert resultatsEtudiant into an any
     * @param a an any
     * @param t resultatsEtudiant value
     */
    public static void insert(org.omg.CORBA.Any a, AdmissionPostLicence.resultatsEtudiant t)
    {
        a.insert_Streamable(new AdmissionPostLicence.resultatsEtudiantHolder(t));
    }

    /**
     * Extract resultatsEtudiant from an any
     * @param a an any
     * @return the extracted resultatsEtudiant value
     */
    public static AdmissionPostLicence.resultatsEtudiant extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof AdmissionPostLicence.resultatsEtudiantHolder)
                    return ((AdmissionPostLicence.resultatsEtudiantHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            AdmissionPostLicence.resultatsEtudiantHolder h = new AdmissionPostLicence.resultatsEtudiantHolder(read(a.create_input_stream()));
            a.insert_Streamable(h);
            return h.value;
        }
        return read(a.create_input_stream());
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;
    private static boolean _working = false;

    /**
     * Return the resultatsEtudiant TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            synchronized(org.omg.CORBA.TypeCode.class) {
                if (_tc != null)
                    return _tc;
                if (_working)
                    return org.omg.CORBA.ORB.init().create_recursive_tc(id());
                _working = true;
                org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
                org.omg.CORBA.StructMember []_members = new org.omg.CORBA.StructMember[2];

                _members[0] = new org.omg.CORBA.StructMember();
                _members[0].name = "etudiant";
                _members[0].type = AdmissionPostLicence.identiteHelper.type();
                _members[1] = new org.omg.CORBA.StructMember();
                _members[1].name = "resultatsSemestres";
                _members[1].type = AdmissionPostLicence.resultatsHelper.type();
                _tc = orb.create_struct_tc(id(),"resultatsEtudiant",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the resultatsEtudiant IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:AdmissionPostLicence/resultatsEtudiant:1.0";

    /**
     * Read resultatsEtudiant from a marshalled stream
     * @param istream the input stream
     * @return the readed resultatsEtudiant value
     */
    public static AdmissionPostLicence.resultatsEtudiant read(org.omg.CORBA.portable.InputStream istream)
    {
        AdmissionPostLicence.resultatsEtudiant new_one = new AdmissionPostLicence.resultatsEtudiant();

        new_one.etudiant = AdmissionPostLicence.identiteHelper.read(istream);
        new_one.resultatsSemestres = AdmissionPostLicence.resultatsHelper.read(istream);

        return new_one;
    }

    /**
     * Write resultatsEtudiant into a marshalled stream
     * @param ostream the output stream
     * @param value resultatsEtudiant value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, AdmissionPostLicence.resultatsEtudiant value)
    {
        AdmissionPostLicence.identiteHelper.write(ostream,value.etudiant);
        AdmissionPostLicence.resultatsHelper.write(ostream,value.resultatsSemestres);
    }

}
