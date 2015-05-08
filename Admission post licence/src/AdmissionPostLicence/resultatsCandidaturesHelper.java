package AdmissionPostLicence;

/** 
 * Helper class for : resultatsCandidatures
 *  
 * @author OpenORB Compiler
 */ 
public class resultatsCandidaturesHelper
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
     * Insert resultatsCandidatures into an any
     * @param a an any
     * @param t resultatsCandidatures value
     */
    public static void insert(org.omg.CORBA.Any a, AdmissionPostLicence.resultatCandidature[] t)
    {
        a.insert_Streamable(new AdmissionPostLicence.resultatsCandidaturesHolder(t));
    }

    /**
     * Extract resultatsCandidatures from an any
     * @param a an any
     * @return the extracted resultatsCandidatures value
     */
    public static AdmissionPostLicence.resultatCandidature[] extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if(HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof AdmissionPostLicence.resultatsCandidaturesHolder)
                    return ((AdmissionPostLicence.resultatsCandidaturesHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            AdmissionPostLicence.resultatsCandidaturesHolder h = new AdmissionPostLicence.resultatsCandidaturesHolder(read(a.create_input_stream()));
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
     * Return the resultatsCandidatures TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_alias_tc(id(),"resultatsCandidatures",orb.create_sequence_tc(0,AdmissionPostLicence.resultatCandidatureHelper.type()));
        }
        return _tc;
    }

    /**
     * Return the resultatsCandidatures IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:AdmissionPostLicence/resultatsCandidatures:1.0";

    /**
     * Read resultatsCandidatures from a marshalled stream
     * @param istream the input stream
     * @return the readed resultatsCandidatures value
     */
    public static AdmissionPostLicence.resultatCandidature[] read(org.omg.CORBA.portable.InputStream istream)
    {
        AdmissionPostLicence.resultatCandidature[] new_one;
        {
        int size7 = istream.read_ulong();
        new_one = new AdmissionPostLicence.resultatCandidature[size7];
        for (int i7=0; i7<new_one.length; i7++)
         {
            new_one[i7] = AdmissionPostLicence.resultatCandidatureHelper.read(istream);

         }
        }

        return new_one;
    }

    /**
     * Write resultatsCandidatures into a marshalled stream
     * @param ostream the output stream
     * @param value resultatsCandidatures value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, AdmissionPostLicence.resultatCandidature[] value)
    {
        ostream.write_ulong(value.length);
        for (int i7=0; i7<value.length; i7++)
        {
            AdmissionPostLicence.resultatCandidatureHelper.write(ostream,value[i7]);

        }
    }

}
