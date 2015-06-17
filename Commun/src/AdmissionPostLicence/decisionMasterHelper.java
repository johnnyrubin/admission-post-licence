package AdmissionPostLicence;

/** 
 * Helper class for : decisionMaster
 *  
 * @author OpenORB Compiler
 */ 
public class decisionMasterHelper
{
    /**
     * Insert decisionMaster into an any
     * @param a an any
     * @param t decisionMaster value
     */
    public static void insert(org.omg.CORBA.Any a, AdmissionPostLicence.decisionMaster t)
    {
        a.type(type());
        write(a.create_output_stream(),t);
    }

    /**
     * Extract decisionMaster from an any
     * @param a an any
     * @return the extracted decisionMaster value
     */
    public static AdmissionPostLicence.decisionMaster extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        return read(a.create_input_stream());
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the decisionMaster TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            String []_members = new String[4];
            _members[0] = "nonTraite";
            _members[1] = "admis";
            _members[2] = "listeAttente";
            _members[3] = "refuser";
            _tc = orb.create_enum_tc(id(),"decisionMaster",_members);
        }
        return _tc;
    }

    /**
     * Return the decisionMaster IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:AdmissionPostLicence/decisionMaster:1.0";

    /**
     * Read decisionMaster from a marshalled stream
     * @param istream the input stream
     * @return the readed decisionMaster value
     */
    public static AdmissionPostLicence.decisionMaster read(org.omg.CORBA.portable.InputStream istream)
    {
        return decisionMaster.from_int(istream.read_ulong());
    }

    /**
     * Write decisionMaster into a marshalled stream
     * @param ostream the output stream
     * @param value decisionMaster value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, AdmissionPostLicence.decisionMaster value)
    {
        ostream.write_ulong(value.value());
    }

}
