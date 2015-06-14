package AdmissionPostLicence;

/** 
 * Helper class for : etatCandidature
 *  
 * @author OpenORB Compiler
 */ 
public class etatCandidatureHelper
{
    /**
     * Insert etatCandidature into an any
     * @param a an any
     * @param t etatCandidature value
     */
    public static void insert(org.omg.CORBA.Any a, AdmissionPostLicence.etatCandidature t)
    {
        a.type(type());
        write(a.create_output_stream(),t);
    }

    /**
     * Extract etatCandidature from an any
     * @param a an any
     * @return the extracted etatCandidature value
     */
    public static AdmissionPostLicence.etatCandidature extract(org.omg.CORBA.Any a)
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
     * Return the etatCandidature TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            String []_members = new String[4];
            _members[0] = "nonTraite";
            _members[1] = "nonValide";
            _members[2] = "valide";
            _members[3] = "cloture";
            _tc = orb.create_enum_tc(id(),"etatCandidature",_members);
        }
        return _tc;
    }

    /**
     * Return the etatCandidature IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:AdmissionPostLicence/etatCandidature:1.0";

    /**
     * Read etatCandidature from a marshalled stream
     * @param istream the input stream
     * @return the readed etatCandidature value
     */
    public static AdmissionPostLicence.etatCandidature read(org.omg.CORBA.portable.InputStream istream)
    {
        return etatCandidature.from_int(istream.read_ulong());
    }

    /**
     * Write etatCandidature into a marshalled stream
     * @param ostream the output stream
     * @param value etatCandidature value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, AdmissionPostLicence.etatCandidature value)
    {
        ostream.write_ulong(value.value());
    }

}
