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

    private static final java.util.Map operationMap = new java.util.HashMap();

    static {
            operationMap.put("_get_nom",
                    new Operation__get_nom());
            operationMap.put("creerCandidature",
                    new Operation_creerCandidature());
            operationMap.put("enregistrerGE",
                    new Operation_enregistrerGE());
            operationMap.put("enregistrerMaster",
                    new Operation_enregistrerMaster());
            operationMap.put("getGestEtu",
                    new Operation_getGestEtu());
            operationMap.put("getListeGestEtu",
                    new Operation_getListeGestEtu());
            operationMap.put("getListeMaster",
                    new Operation_getListeMaster());
            operationMap.put("getListeUniversite",
                    new Operation_getListeUniversite());
            operationMap.put("modifierCandidature",
                    new Operation_modifierCandidature());
            operationMap.put("recupererCandidaturesEtudiant",
                    new Operation_recupererCandidaturesEtudiant());
            operationMap.put("recupererCandidaturesMaster",
                    new Operation_recupererCandidaturesMaster());
            operationMap.put("supprimerCandidature",
                    new Operation_supprimerCandidature());
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        final AbstractOperation operation = (AbstractOperation)operationMap.get(opName);

        if (null == operation) {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }

        return operation.invoke(this, _is, handler);
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

    private org.omg.CORBA.portable.OutputStream _invoke_creerCandidature(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        AdmissionPostLicence.candidature arg0_in = AdmissionPostLicence.candidatureHelper.read(_is);

        creerCandidature(arg0_in);

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_supprimerCandidature(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        AdmissionPostLicence.candidature arg0_in = AdmissionPostLicence.candidatureHelper.read(_is);

        try
        {
            supprimerCandidature(arg0_in);

            _output = handler.createReply();

        }
        catch (AdmissionPostLicence.CandidatureInconnu _exception)
        {
            _output = handler.createExceptionReply();
            AdmissionPostLicence.CandidatureInconnuHelper.write(_output,_exception);
        }
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

    private org.omg.CORBA.portable.OutputStream _invoke_modifierCandidature(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        AdmissionPostLicence.candidature arg0_in = AdmissionPostLicence.candidatureHelper.read(_is);

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

    private org.omg.CORBA.portable.OutputStream _invoke_getListeGestEtu(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        String[] _arg_result = getListeGestEtu();

        _output = handler.createReply();
        AdmissionPostLicence.gestionEtudiantsHelper.write(_output,_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_enregistrerGE(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        String arg1_in = _is.read_string();

        enregistrerGE(arg0_in, arg1_in);

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_getGestEtu(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();

        String _arg_result = getGestEtu(arg0_in);

        _output = handler.createReply();
        _output.write_string(_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_getListeMaster(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();

        String[] _arg_result = getListeMaster(arg0_in);

        _output = handler.createReply();
        AdmissionPostLicence.mastersHelper.write(_output,_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_enregistrerMaster(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();

        enregistrerMaster(arg0_in);

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_getListeUniversite(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        String[] _arg_result = getListeUniversite();

        _output = handler.createReply();
        AdmissionPostLicence.universitesHelper.write(_output,_arg_result);

        return _output;
    }

    // operation classes
    private abstract static class AbstractOperation {
        protected abstract org.omg.CORBA.portable.OutputStream invoke(
                RectoratPOA target,
                org.omg.CORBA.portable.InputStream _is,
                org.omg.CORBA.portable.ResponseHandler handler);
    }

    private static final class Operation__get_nom extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final RectoratPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke__get_nom(_is, handler);
        }
    }

    private static final class Operation_creerCandidature extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final RectoratPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_creerCandidature(_is, handler);
        }
    }

    private static final class Operation_supprimerCandidature extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final RectoratPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_supprimerCandidature(_is, handler);
        }
    }

    private static final class Operation_recupererCandidaturesMaster extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final RectoratPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_recupererCandidaturesMaster(_is, handler);
        }
    }

    private static final class Operation_recupererCandidaturesEtudiant extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final RectoratPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_recupererCandidaturesEtudiant(_is, handler);
        }
    }

    private static final class Operation_modifierCandidature extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final RectoratPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_modifierCandidature(_is, handler);
        }
    }

    private static final class Operation_getListeGestEtu extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final RectoratPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_getListeGestEtu(_is, handler);
        }
    }

    private static final class Operation_enregistrerGE extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final RectoratPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_enregistrerGE(_is, handler);
        }
    }

    private static final class Operation_getGestEtu extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final RectoratPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_getGestEtu(_is, handler);
        }
    }

    private static final class Operation_getListeMaster extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final RectoratPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_getListeMaster(_is, handler);
        }
    }

    private static final class Operation_enregistrerMaster extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final RectoratPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_enregistrerMaster(_is, handler);
        }
    }

    private static final class Operation_getListeUniversite extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final RectoratPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_getListeUniversite(_is, handler);
        }
    }

}
