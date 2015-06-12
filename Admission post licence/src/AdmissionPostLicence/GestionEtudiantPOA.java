package AdmissionPostLicence;

/**
 * Interface definition : GestionEtudiant
 * 
 * @author OpenORB Compiler
 */
public abstract class GestionEtudiantPOA extends org.omg.PortableServer.Servant
        implements GestionEtudiantOperations, org.omg.CORBA.portable.InvokeHandler
{
    public GestionEtudiant _this()
    {
        return GestionEtudiantHelper.narrow(_this_object());
    }

    public GestionEtudiant _this(org.omg.CORBA.ORB orb)
    {
        return GestionEtudiantHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:AdmissionPostLicence/GestionEtudiant:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("_get_nom")) {
                return _invoke__get_nom(_is, handler);
        } else if (opName.equals("consulterEtatVoeux")) {
                return _invoke_consulterEtatVoeux(_is, handler);
        } else if (opName.equals("modifierDecision")) {
                return _invoke_modifierDecision(_is, handler);
        } else if (opName.equals("recupererResultats")) {
                return _invoke_recupererResultats(_is, handler);
        } else if (opName.equals("seConnecter")) {
                return _invoke_seConnecter(_is, handler);
        } else if (opName.equals("soumettreCandidature")) {
                return _invoke_soumettreCandidature(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke__get_nom(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg = nom();
        _output = handler.createReply();
        _output.write_string(arg);
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_soumettreCandidature(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        AdmissionPostLicence.candidature arg0_in = AdmissionPostLicence.candidatureHelper.read(_is);

        try
        {
            soumettreCandidature(arg0_in);

            _output = handler.createReply();

        }
        catch (AdmissionPostLicence.MasterInconnu _exception)
        {
            _output = handler.createExceptionReply();
            AdmissionPostLicence.MasterInconnuHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_recupererResultats(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        AdmissionPostLicence.identite arg0_in = AdmissionPostLicence.identiteHelper.read(_is);

        try
        {
            AdmissionPostLicence.resultatsEtudiant _arg_result = recupererResultats(arg0_in);

            _output = handler.createReply();
            AdmissionPostLicence.resultatsEtudiantHelper.write(_output,_arg_result);

        }
        catch (AdmissionPostLicence.EtudiantInconnu _exception)
        {
            _output = handler.createExceptionReply();
            AdmissionPostLicence.EtudiantInconnuHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_consulterEtatVoeux(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        AdmissionPostLicence.identite arg0_in = AdmissionPostLicence.identiteHelper.read(_is);

        try
        {
            AdmissionPostLicence.candidature[] _arg_result = consulterEtatVoeux(arg0_in);

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

    private org.omg.CORBA.portable.OutputStream _invoke_modifierDecision(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        AdmissionPostLicence.candidature arg0_in = AdmissionPostLicence.candidatureHelper.read(_is);
        AdmissionPostLicence.decisionCandidat arg1_in = AdmissionPostLicence.decisionCandidatHelper.read(_is);

        modifierDecision(arg0_in, arg1_in);

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_seConnecter(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        String arg1_in = _is.read_string();

        try
        {
            AdmissionPostLicence.identite _arg_result = seConnecter(arg0_in, arg1_in);

            _output = handler.createReply();
            AdmissionPostLicence.identiteHelper.write(_output,_arg_result);

        }
        catch (AdmissionPostLicence.EtudiantInconnu _exception)
        {
            _output = handler.createExceptionReply();
            AdmissionPostLicence.EtudiantInconnuHelper.write(_output,_exception);
        }
        return _output;
    }

}
