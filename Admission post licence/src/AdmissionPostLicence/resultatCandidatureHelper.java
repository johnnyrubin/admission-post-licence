package AdmissionPostLicence;

/** 
 * Helper class for : resultatCandidature
 *  
 * @author OpenORB Compiler
 */ 
public class resultatCandidatureHelper
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
     * Insert resultatCandidature into an any
     * @param a an any
     * @param t resultatCandidature value
     */
    public static void insert(org.omg.CORBA.Any a, AdmissionPostLicence.resultatCandidature t)
    {
        a.insert_Streamable(new AdmissionPostLicence.resultatCandidatureHolder(t));
    }

    /**
     * Extract resultatCandidature from an any
     * @param a an any
     * @return the extracted resultatCandidature value
     */
    public static AdmissionPostLicence.resultatCandidature extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof AdmissionPostLicence.resultatCandidatureHolder)
                    return ((AdmissionPostLicence.resultatCandidatureHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            AdmissionPostLicence.resultatCandidatureHolder h = new AdmissionPostLicence.resultatCandidatureHolder(read(a.create_input_stream()));
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
     * Return the resultatCandidature TypeCode
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
                org.omg.CORBA.StructMember []_members = new org.omg.CORBA.StructMember[4];

                _members[0] = new org.omg.CORBA.StructMember();
                _members[0].name = "c";
                _members[0].type = AdmissionPostLicence.candidatureHelper.type();
                _members[1] = new org.omg.CORBA.StructMember();
                _members[1].name = "etat";
                _members[1].type = AdmissionPostLicence.etatCandidatureHelper.type();
                _members[2] = new org.omg.CORBA.StructMember();
                _members[2].name = "decisionC";
                _members[2].type = AdmissionPostLicence.decisionCandidatHelper.type();
                _members[3] = new org.omg.CORBA.StructMember();
                _members[3].name = "decisionM";
                _members[3].type = AdmissionPostLicence.decisionMasterHelper.type();
                _tc = orb.create_struct_tc(id(),"resultatCandidature",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the resultatCandidature IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:AdmissionPostLicence/resultatCandidature:1.0";

    /**
     * Read resultatCandidature from a marshalled stream
     * @param istream the input stream
     * @return the readed resultatCandidature value
     */
    public static AdmissionPostLicence.resultatCandidature read(org.omg.CORBA.portable.InputStream istream)
    {
        AdmissionPostLicence.resultatCandidature new_one = new AdmissionPostLicence.resultatCandidature();

        new_one.c = AdmissionPostLicence.candidatureHelper.read(istream);
        new_one.etat = AdmissionPostLicence.etatCandidatureHelper.read(istream);
        new_one.decisionC = AdmissionPostLicence.decisionCandidatHelper.read(istream);
        new_one.decisionM = AdmissionPostLicence.decisionMasterHelper.read(istream);

        return new_one;
    }

    /**
     * Write resultatCandidature into a marshalled stream
     * @param ostream the output stream
     * @param value resultatCandidature value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, AdmissionPostLicence.resultatCandidature value)
    {
        AdmissionPostLicence.candidatureHelper.write(ostream,value.c);
        AdmissionPostLicence.etatCandidatureHelper.write(ostream,value.etat);
        AdmissionPostLicence.decisionCandidatHelper.write(ostream,value.decisionC);
        AdmissionPostLicence.decisionMasterHelper.write(ostream,value.decisionM);
    }

}
