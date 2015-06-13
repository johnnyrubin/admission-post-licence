package AdmissionPostLicence;

/** 
 * Helper class for : accreditation
 *  
 * @author OpenORB Compiler
 */ 
public class accreditationHelper
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
     * Insert accreditation into an any
     * @param a an any
     * @param t accreditation value
     */
    public static void insert(org.omg.CORBA.Any a, AdmissionPostLicence.accreditation t)
    {
        a.insert_Streamable(new AdmissionPostLicence.accreditationHolder(t));
    }

    /**
     * Extract accreditation from an any
     * @param a an any
     * @return the extracted accreditation value
     */
    public static AdmissionPostLicence.accreditation extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof AdmissionPostLicence.accreditationHolder)
                    return ((AdmissionPostLicence.accreditationHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            AdmissionPostLicence.accreditationHolder h = new AdmissionPostLicence.accreditationHolder(read(a.create_input_stream()));
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
     * Return the accreditation TypeCode
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
                _members[0].name = "universite";
                _members[0].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _members[1] = new org.omg.CORBA.StructMember();
                _members[1].name = "master";
                _members[1].type = AdmissionPostLicence.listeMastersHelper.type();
                _tc = orb.create_struct_tc(id(),"accreditation",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the accreditation IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:AdmissionPostLicence/accreditation:1.0";

    /**
     * Read accreditation from a marshalled stream
     * @param istream the input stream
     * @return the readed accreditation value
     */
    public static AdmissionPostLicence.accreditation read(org.omg.CORBA.portable.InputStream istream)
    {
        AdmissionPostLicence.accreditation new_one = new AdmissionPostLicence.accreditation();

        new_one.universite = istream.read_string();
        new_one.master = AdmissionPostLicence.listeMastersHelper.read(istream);

        return new_one;
    }

    /**
     * Write accreditation into a marshalled stream
     * @param ostream the output stream
     * @param value accreditation value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, AdmissionPostLicence.accreditation value)
    {
        ostream.write_string(value.universite);
        AdmissionPostLicence.listeMastersHelper.write(ostream,value.master);
    }

}
