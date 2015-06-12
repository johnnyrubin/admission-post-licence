package AdmissionPostLicence;

/** 
 * Helper class for : candidature
 *  
 * @author OpenORB Compiler
 */ 
public class candidatureHelper
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
     * Insert candidature into an any
     * @param a an any
     * @param t candidature value
     */
    public static void insert(org.omg.CORBA.Any a, AdmissionPostLicence.candidature t)
    {
        a.insert_Streamable(new AdmissionPostLicence.candidatureHolder(t));
    }

    /**
     * Extract candidature from an any
     * @param a an any
     * @return the extracted candidature value
     */
    public static AdmissionPostLicence.candidature extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof AdmissionPostLicence.candidatureHolder)
                    return ((AdmissionPostLicence.candidatureHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            AdmissionPostLicence.candidatureHolder h = new AdmissionPostLicence.candidatureHolder(read(a.create_input_stream()));
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
     * Return the candidature TypeCode
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
                org.omg.CORBA.StructMember []_members = new org.omg.CORBA.StructMember[7];

                _members[0] = new org.omg.CORBA.StructMember();
                _members[0].name = "etudiant";
                _members[0].type = AdmissionPostLicence.identiteHelper.type();
                _members[1] = new org.omg.CORBA.StructMember();
                _members[1].name = "master";
                _members[1].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _members[2] = new org.omg.CORBA.StructMember();
                _members[2].name = "universite";
                _members[2].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _members[3] = new org.omg.CORBA.StructMember();
                _members[3].name = "ordre";
                _members[3].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_short);
                _members[4] = new org.omg.CORBA.StructMember();
                _members[4].name = "etat";
                _members[4].type = AdmissionPostLicence.etatCandidatureHelper.type();
                _members[5] = new org.omg.CORBA.StructMember();
                _members[5].name = "decisionC";
                _members[5].type = AdmissionPostLicence.decisionCandidatHelper.type();
                _members[6] = new org.omg.CORBA.StructMember();
                _members[6].name = "decisionM";
                _members[6].type = AdmissionPostLicence.decisionMasterHelper.type();
                _tc = orb.create_struct_tc(id(),"candidature",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the candidature IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:AdmissionPostLicence/candidature:1.0";

    /**
     * Read candidature from a marshalled stream
     * @param istream the input stream
     * @return the readed candidature value
     */
    public static AdmissionPostLicence.candidature read(org.omg.CORBA.portable.InputStream istream)
    {
        AdmissionPostLicence.candidature new_one = new AdmissionPostLicence.candidature();

        new_one.etudiant = AdmissionPostLicence.identiteHelper.read(istream);
        new_one.master = istream.read_string();
        new_one.universite = istream.read_string();
        new_one.ordre = istream.read_short();
        new_one.etat = AdmissionPostLicence.etatCandidatureHelper.read(istream);
        new_one.decisionC = AdmissionPostLicence.decisionCandidatHelper.read(istream);
        new_one.decisionM = AdmissionPostLicence.decisionMasterHelper.read(istream);

        return new_one;
    }

    /**
     * Write candidature into a marshalled stream
     * @param ostream the output stream
     * @param value candidature value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, AdmissionPostLicence.candidature value)
    {
        AdmissionPostLicence.identiteHelper.write(ostream,value.etudiant);
        ostream.write_string(value.master);
        ostream.write_string(value.universite);
        ostream.write_short(value.ordre);
        AdmissionPostLicence.etatCandidatureHelper.write(ostream,value.etat);
        AdmissionPostLicence.decisionCandidatHelper.write(ostream,value.decisionC);
        AdmissionPostLicence.decisionMasterHelper.write(ostream,value.decisionM);
    }

}
