package AdmissionPostLicence;

/** 
 * Helper class for : MasterInconnu
 *  
 * @author OpenORB Compiler
 */ 
public class MasterInconnuHelper
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
     * Insert MasterInconnu into an any
     * @param a an any
     * @param t MasterInconnu value
     */
    public static void insert(org.omg.CORBA.Any a, AdmissionPostLicence.MasterInconnu t)
    {
        a.insert_Streamable(new AdmissionPostLicence.MasterInconnuHolder(t));
    }

    /**
     * Extract MasterInconnu from an any
     * @param a an any
     * @return the extracted MasterInconnu value
     */
    public static AdmissionPostLicence.MasterInconnu extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof AdmissionPostLicence.MasterInconnuHolder)
                    return ((AdmissionPostLicence.MasterInconnuHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            AdmissionPostLicence.MasterInconnuHolder h = new AdmissionPostLicence.MasterInconnuHolder(read(a.create_input_stream()));
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
     * Return the MasterInconnu TypeCode
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
                _members[0].name = "raison";
                _members[0].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _members[1] = new org.omg.CORBA.StructMember();
                _members[1].name = "id";
                _members[1].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_long);
                _tc = orb.create_exception_tc(id(),"MasterInconnu",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the MasterInconnu IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:AdmissionPostLicence/MasterInconnu:1.0";

    /**
     * Read MasterInconnu from a marshalled stream
     * @param istream the input stream
     * @return the readed MasterInconnu value
     */
    public static AdmissionPostLicence.MasterInconnu read(org.omg.CORBA.portable.InputStream istream)
    {
        AdmissionPostLicence.MasterInconnu new_one = new AdmissionPostLicence.MasterInconnu();

        if (!istream.read_string().equals(id()))
         throw new org.omg.CORBA.MARSHAL();
        new_one.raison = istream.read_string();
        new_one.id = istream.read_long();

        return new_one;
    }

    /**
     * Write MasterInconnu into a marshalled stream
     * @param ostream the output stream
     * @param value MasterInconnu value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, AdmissionPostLicence.MasterInconnu value)
    {
        ostream.write_string(id());
        ostream.write_string(value.raison);
        ostream.write_long(value.id);
    }

}
