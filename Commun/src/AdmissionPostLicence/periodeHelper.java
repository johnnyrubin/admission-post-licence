package AdmissionPostLicence;

/** 
 * Helper class for : periode
 *  
 * @author OpenORB Compiler
 */ 
public class periodeHelper
{
    /**
     * Insert periode into an any
     * @param a an any
     * @param t periode value
     */
    public static void insert(org.omg.CORBA.Any a, AdmissionPostLicence.periode t)
    {
        a.type(type());
        write(a.create_output_stream(),t);
    }

    /**
     * Extract periode from an any
     * @param a an any
     * @return the extracted periode value
     */
    public static AdmissionPostLicence.periode extract(org.omg.CORBA.Any a)
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
     * Return the periode TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            String []_members = new String[4];
            _members[0] = "periode1";
            _members[1] = "periode2";
            _members[2] = "periode3";
            _members[3] = "periode4";
            _tc = orb.create_enum_tc(id(),"periode",_members);
        }
        return _tc;
    }

    /**
     * Return the periode IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:AdmissionPostLicence/periode:1.0";

    /**
     * Read periode from a marshalled stream
     * @param istream the input stream
     * @return the readed periode value
     */
    public static AdmissionPostLicence.periode read(org.omg.CORBA.portable.InputStream istream)
    {
        return periode.from_int(istream.read_ulong());
    }

    /**
     * Write periode into a marshalled stream
     * @param ostream the output stream
     * @param value periode value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, AdmissionPostLicence.periode value)
    {
        ostream.write_ulong(value.value());
    }

}
