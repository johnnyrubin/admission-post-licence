package AdmissionPostLicence;

/** 
 * Helper class for : identite
 *  
 * @author OpenORB Compiler
 */ 
public class identiteHelper
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
     * Insert identite into an any
     * @param a an any
     * @param t identite value
     */
    public static void insert(org.omg.CORBA.Any a, AdmissionPostLicence.identite t)
    {
        a.insert_Streamable(new AdmissionPostLicence.identiteHolder(t));
    }

    /**
     * Extract identite from an any
     * @param a an any
     * @return the extracted identite value
     */
    public static AdmissionPostLicence.identite extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof AdmissionPostLicence.identiteHolder)
                    return ((AdmissionPostLicence.identiteHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            AdmissionPostLicence.identiteHolder h = new AdmissionPostLicence.identiteHolder(read(a.create_input_stream()));
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
     * Return the identite TypeCode
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
                org.omg.CORBA.StructMember []_members = new org.omg.CORBA.StructMember[5];

                _members[0] = new org.omg.CORBA.StructMember();
                _members[0].name = "ine";
                _members[0].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _members[1] = new org.omg.CORBA.StructMember();
                _members[1].name = "nom";
                _members[1].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _members[2] = new org.omg.CORBA.StructMember();
                _members[2].name = "prenom";
                _members[2].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _members[3] = new org.omg.CORBA.StructMember();
                _members[3].name = "universite";
                _members[3].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _members[4] = new org.omg.CORBA.StructMember();
                _members[4].name = "licence";
                _members[4].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _tc = orb.create_struct_tc(id(),"identite",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the identite IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:AdmissionPostLicence/identite:1.0";

    /**
     * Read identite from a marshalled stream
     * @param istream the input stream
     * @return the readed identite value
     */
    public static AdmissionPostLicence.identite read(org.omg.CORBA.portable.InputStream istream)
    {
        AdmissionPostLicence.identite new_one = new AdmissionPostLicence.identite();

        new_one.ine = istream.read_string();
        new_one.nom = istream.read_string();
        new_one.prenom = istream.read_string();
        new_one.universite = istream.read_string();
        new_one.licence = istream.read_string();

        return new_one;
    }

    /**
     * Write identite into a marshalled stream
     * @param ostream the output stream
     * @param value identite value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, AdmissionPostLicence.identite value)
    {
        ostream.write_string(value.ine);
        ostream.write_string(value.nom);
        ostream.write_string(value.prenom);
        ostream.write_string(value.universite);
        ostream.write_string(value.licence);
    }

}
