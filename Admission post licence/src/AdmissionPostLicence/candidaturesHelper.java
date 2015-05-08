package AdmissionPostLicence;

/** 
 * Helper class for : candidatures
 *  
 * @author OpenORB Compiler
 */ 
public class candidaturesHelper
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
     * Insert candidatures into an any
     * @param a an any
     * @param t candidatures value
     */
    public static void insert(org.omg.CORBA.Any a, AdmissionPostLicence.candidature[] t)
    {
        a.insert_Streamable(new AdmissionPostLicence.candidaturesHolder(t));
    }

    /**
     * Extract candidatures from an any
     * @param a an any
     * @return the extracted candidatures value
     */
    public static AdmissionPostLicence.candidature[] extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if(HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof AdmissionPostLicence.candidaturesHolder)
                    return ((AdmissionPostLicence.candidaturesHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            AdmissionPostLicence.candidaturesHolder h = new AdmissionPostLicence.candidaturesHolder(read(a.create_input_stream()));
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
     * Return the candidatures TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_alias_tc(id(),"candidatures",orb.create_sequence_tc(0,AdmissionPostLicence.candidatureHelper.type()));
        }
        return _tc;
    }

    /**
     * Return the candidatures IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:AdmissionPostLicence/candidatures:1.0";

    /**
     * Read candidatures from a marshalled stream
     * @param istream the input stream
     * @return the readed candidatures value
     */
    public static AdmissionPostLicence.candidature[] read(org.omg.CORBA.portable.InputStream istream)
    {
        AdmissionPostLicence.candidature[] new_one;
        {
        int size7 = istream.read_ulong();
        new_one = new AdmissionPostLicence.candidature[size7];
        for (int i7=0; i7<new_one.length; i7++)
         {
            new_one[i7] = AdmissionPostLicence.candidatureHelper.read(istream);

         }
        }

        return new_one;
    }

    /**
     * Write candidatures into a marshalled stream
     * @param ostream the output stream
     * @param value candidatures value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, AdmissionPostLicence.candidature[] value)
    {
        ostream.write_ulong(value.length);
        for (int i7=0; i7<value.length; i7++)
        {
            AdmissionPostLicence.candidatureHelper.write(ostream,value[i7]);

        }
    }

}
