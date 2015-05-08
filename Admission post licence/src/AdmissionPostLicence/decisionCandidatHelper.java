package AdmissionPostLicence;

/** 
 * Helper class for : decisionCandidat
 *  
 * @author OpenORB Compiler
 */ 
public class decisionCandidatHelper
{
    /**
     * Insert decisionCandidat into an any
     * @param a an any
     * @param t decisionCandidat value
     */
    public static void insert(org.omg.CORBA.Any a, AdmissionPostLicence.decisionCandidat t)
    {
        a.type(type());
        write(a.create_output_stream(),t);
    }

    /**
     * Extract decisionCandidat from an any
     * @param a an any
     * @return the extracted decisionCandidat value
     */
    public static AdmissionPostLicence.decisionCandidat extract(org.omg.CORBA.Any a)
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
     * Return the decisionCandidat TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            String []_members = new String[4];
            _members[0] = "ouiDefinitif";
            _members[1] = "ouiMais";
            _members[2] = "nonMais";
            _members[3] = "nonDefinitif";
            _tc = orb.create_enum_tc(id(),"decisionCandidat",_members);
        }
        return _tc;
    }

    /**
     * Return the decisionCandidat IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:AdmissionPostLicence/decisionCandidat:1.0";

    /**
     * Read decisionCandidat from a marshalled stream
     * @param istream the input stream
     * @return the readed decisionCandidat value
     */
    public static AdmissionPostLicence.decisionCandidat read(org.omg.CORBA.portable.InputStream istream)
    {
        return decisionCandidat.from_int(istream.read_ulong());
    }

    /**
     * Write decisionCandidat into a marshalled stream
     * @param ostream the output stream
     * @param value decisionCandidat value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, AdmissionPostLicence.decisionCandidat value)
    {
        ostream.write_ulong(value.value());
    }

}
