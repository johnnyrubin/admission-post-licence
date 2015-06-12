package AdmissionPostLicence;

/** 
 * Helper class for : rectorats
 *  
 * @author OpenORB Compiler
 */ 
public class rectoratsHelper
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
     * Insert rectorats into an any
     * @param a an any
     * @param t rectorats value
     */
    public static void insert(org.omg.CORBA.Any a, AdmissionPostLicence.Rectorat[] t)
    {
        a.insert_Streamable(new AdmissionPostLicence.rectoratsHolder(t));
    }

    /**
     * Extract rectorats from an any
     * @param a an any
     * @return the extracted rectorats value
     */
    public static AdmissionPostLicence.Rectorat[] extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if(HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof AdmissionPostLicence.rectoratsHolder)
                    return ((AdmissionPostLicence.rectoratsHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            AdmissionPostLicence.rectoratsHolder h = new AdmissionPostLicence.rectoratsHolder(read(a.create_input_stream()));
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
     * Return the rectorats TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_alias_tc(id(),"rectorats",orb.create_sequence_tc(0,AdmissionPostLicence.RectoratHelper.type()));
        }
        return _tc;
    }

    /**
     * Return the rectorats IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:AdmissionPostLicence/rectorats:1.0";

    /**
     * Read rectorats from a marshalled stream
     * @param istream the input stream
     * @return the readed rectorats value
     */
    public static AdmissionPostLicence.Rectorat[] read(org.omg.CORBA.portable.InputStream istream)
    {
        AdmissionPostLicence.Rectorat[] new_one;
        {
        int size7 = istream.read_ulong();
        new_one = new AdmissionPostLicence.Rectorat[size7];
        for (int i7=0; i7<new_one.length; i7++)
         {
            new_one[i7] = AdmissionPostLicence.RectoratHelper.read(istream);

         }
        }

        return new_one;
    }

    /**
     * Write rectorats into a marshalled stream
     * @param ostream the output stream
     * @param value rectorats value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, AdmissionPostLicence.Rectorat[] value)
    {
        ostream.write_ulong(value.length);
        for (int i7=0; i7<value.length; i7++)
        {
            AdmissionPostLicence.RectoratHelper.write(ostream,value[i7]);

        }
    }

}