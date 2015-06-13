package AdmissionPostLicence;

/**
 * Interface definition : Ministere
 * 
 * @author OpenORB Compiler
 */
public abstract class MinisterePOA extends org.omg.PortableServer.Servant
        implements MinistereOperations, org.omg.CORBA.portable.InvokeHandler
{
    public Ministere _this()
    {
        return MinistereHelper.narrow(_this_object());
    }

    public Ministere _this(org.omg.CORBA.ORB orb)
    {
        return MinistereHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:AdmissionPostLicence/Ministere:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("enregistrerRectorat")) {
                return _invoke_enregistrerRectorat(_is, handler);
        } else if (opName.equals("getListeRectorat")) {
                return _invoke_getListeRectorat(_is, handler);
        } else if (opName.equals("recupererAccreditations")) {
                return _invoke_recupererAccreditations(_is, handler);
        } else if (opName.equals("transfererCandidature")) {
                return _invoke_transfererCandidature(_is, handler);
        } else if (opName.equals("transfererDecision")) {
                return _invoke_transfererDecision(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_recupererAccreditations(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        AdmissionPostLicence.accreditation[] _arg_result = recupererAccreditations();

        _output = handler.createReply();
        AdmissionPostLicence.accreditationsHelper.write(_output,_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_transfererCandidature(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        AdmissionPostLicence.candidature arg0_in = AdmissionPostLicence.candidatureHelper.read(_is);

        transfererCandidature(arg0_in);

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_transfererDecision(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        AdmissionPostLicence.candidature arg0_in = AdmissionPostLicence.candidatureHelper.read(_is);

        try
        {
            transfererDecision(arg0_in);

            _output = handler.createReply();

        }
        catch (AdmissionPostLicence.CandidatureInconnu _exception)
        {
            _output = handler.createExceptionReply();
            AdmissionPostLicence.CandidatureInconnuHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_getListeRectorat(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        String[] _arg_result = getListeRectorat();

        _output = handler.createReply();
        AdmissionPostLicence.rectoratsHelper.write(_output,_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_enregistrerRectorat(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();

        enregistrerRectorat(arg0_in);

        _output = handler.createReply();

        return _output;
    }

}
