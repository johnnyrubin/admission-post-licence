package AdmissionPostLicence;

/**
 * Interface definition : Rectorat
 * 
 * @author OpenORB Compiler
 */
public abstract class RectoratPOA extends org.omg.PortableServer.Servant
        implements RectoratOperations, org.omg.CORBA.portable.InvokeHandler
{
    public Rectorat _this()
    {
        return RectoratHelper.narrow(_this_object());
    }

    public Rectorat _this(org.omg.CORBA.ORB orb)
    {
        return RectoratHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:AdmissionPostLicence/Rectorat:1.0"
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
        } else if (opName.equals("creerCandidature")) {
                return _invoke_creerCandidature(_is, handler);
        } else if (opName.equals("modifierCandidature")) {
                return _invoke_modifierCandidature(_is, handler);
        } else if (opName.equals("recupererCandidaturesEtudiant")) {
                return _invoke_recupererCandidaturesEtudiant(_is, handler);
        } else if (opName.equals("recupererCandidaturesMaster")) {
                return _invoke_recupererCandidaturesMaster(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_creerCandidature(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        AdmissionPostLicence.candidature arg0_in = AdmissionPostLicence.candidatureHelper.read(_is);

        creerCandidature(arg0_in);

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_recupererCandidaturesMaster(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();

        try
        {
            AdmissionPostLicence.candidature[] _arg_result = recupererCandidaturesMaster(arg0_in);

            _output = handler.createReply();
            AdmissionPostLicence.candidaturesHelper.write(_output,_arg_result);

        }
        catch (AdmissionPostLicence.MasterInconnu _exception)
        {
            _output = handler.createExceptionReply();
            AdmissionPostLicence.MasterInconnuHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_recupererCandidaturesEtudiant(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        AdmissionPostLicence.identite arg0_in = AdmissionPostLicence.identiteHelper.read(_is);

        try
        {
            AdmissionPostLicence.candidature[] _arg_result = recupererCandidaturesEtudiant(arg0_in);

            _output = handler.createReply();
            AdmissionPostLicence.candidaturesHelper.write(_output,_arg_result);

        }
        catch (AdmissionPostLicence.EtudiantInconnu _exception)
        {
            _output = handler.createExceptionReply();
            AdmissionPostLicence.EtudiantInconnuHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_consulterEtatCandidatures(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        AdmissionPostLicence.candidature[] arg0_in = AdmissionPostLicence.candidaturesHelper.read(_is);

        try
        {
            AdmissionPostLicence.resultatCandidature[] _arg_result = consulterEtatCandidatures(arg0_in);

            _output = handler.createReply();
            AdmissionPostLicence.resultatsCandidaturesHelper.write(_output,_arg_result);

        }
        catch (AdmissionPostLicence.CandidatureInconnu _exception)
        {
            _output = handler.createExceptionReply();
            AdmissionPostLicence.CandidatureInconnuHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_modifierCandidature(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        AdmissionPostLicence.resultatCandidature arg0_in = AdmissionPostLicence.resultatCandidatureHelper.read(_is);

        try
        {
            modifierCandidature(arg0_in);

            _output = handler.createReply();

        }
        catch (AdmissionPostLicence.CandidatureInconnu _exception)
        {
            _output = handler.createExceptionReply();
            AdmissionPostLicence.CandidatureInconnuHelper.write(_output,_exception);
        }
        return _output;
    }

}
