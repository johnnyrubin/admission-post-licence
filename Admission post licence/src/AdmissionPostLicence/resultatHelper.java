package AdmissionPostLicence;

/** 
 * Helper class for : resultat
 *  
 * @author OpenORB Compiler
 */ 
public class resultatHelper
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
     * Insert resultat into an any
     * @param a an any
     * @param t resultat value
     */
    public static void insert(org.omg.CORBA.Any a, AdmissionPostLicence.resultat t)
    {
        a.insert_Streamable(new AdmissionPostLicence.resultatHolder(t));
    }

    /**
     * Extract resultat from an any
     * @param a an any
     * @return the extracted resultat value
     */
    public static AdmissionPostLicence.resultat extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof AdmissionPostLicence.resultatHolder)
                    return ((AdmissionPostLicence.resultatHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            AdmissionPostLicence.resultatHolder h = new AdmissionPostLicence.resultatHolder(read(a.create_input_stream()));
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
     * Return the resultat TypeCode
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
                org.omg.CORBA.StructMember []_members = new org.omg.CORBA.StructMember[3];

                _members[0] = new org.omg.CORBA.StructMember();
                _members[0].name = "code";
                _members[0].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _members[1] = new org.omg.CORBA.StructMember();
                _members[1].name = "moyenne";
                _members[1].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_float);
                _members[2] = new org.omg.CORBA.StructMember();
                _members[2].name = "position";
                _members[2].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_short);
                _tc = orb.create_struct_tc(id(),"resultat",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the resultat IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:AdmissionPostLicence/resultat:1.0";

    /**
     * Read resultat from a marshalled stream
     * @param istream the input stream
     * @return the readed resultat value
     */
    public static AdmissionPostLicence.resultat read(org.omg.CORBA.portable.InputStream istream)
    {
        AdmissionPostLicence.resultat new_one = new AdmissionPostLicence.resultat();

        new_one.code = istream.read_string();
        new_one.moyenne = istream.read_float();
        new_one.position = istream.read_short();

        return new_one;
    }

    /**
     * Write resultat into a marshalled stream
     * @param ostream the output stream
     * @param value resultat value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, AdmissionPostLicence.resultat value)
    {
        ostream.write_string(value.code);
        ostream.write_float(value.moyenne);
        ostream.write_short(value.position);
    }

}
