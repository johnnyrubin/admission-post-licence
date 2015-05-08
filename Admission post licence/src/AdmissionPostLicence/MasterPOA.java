package AdmissionPostLicence;

/**
 * Interface definition : Master
 * 
 * @author OpenORB Compiler
 */
public abstract class MasterPOA extends org.omg.PortableServer.Servant
        implements MasterOperations, org.omg.CORBA.portable.InvokeHandler
{
    public Master _this()
    {
        return MasterHelper.narrow(_this_object());
    }

    public Master _this(org.omg.CORBA.ORB orb)
    {
        return MasterHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:AdmissionPostLicence/Master:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("consulterEtatCandidatures")) {
                return _invoke_consulterEtatCandidatures(_is, handler);
        } else if (opName.equals("modifierDecision")) {
                return _invoke_modifierDecision(_is, handler);
        } else if (opName.equals("verifierPrerequis")) {
                return _invoke_verifierPrerequis(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_consulterEtatCandidatures(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        AdmissionPostLicence.resultatCandidature[] _arg_result = consulterEtatCandidatures();

        _output = handler.createReply();
        AdmissionPostLicence.resultatsCandidaturesHelper.write(_output,_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_modifierDecision(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        AdmissionPostLicence.candidature arg0_in = AdmissionPostLicence.candidatureHelper.read(_is);
        AdmissionPostLicence.decisionMaster arg1_in = AdmissionPostLicence.decisionMasterHelper.read(_is);

        modifierDecision(arg0_in, arg1_in);

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_verifierPrerequis(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();

        try
        {
            boolean _arg_result = verifierPrerequis(arg0_in);

            _output = handler.createReply();
            _output.write_boolean(_arg_result);

        }
        catch (AdmissionPostLicence.MasterInconnu _exception)
        {
            _output = handler.createExceptionReply();
            AdmissionPostLicence.MasterInconnuHelper.write(_output,_exception);
        }
        return _output;
    }

}
