package AdmissionPostLicence;

/**
 * Interface definition : Rectorat
 * 
 * @author OpenORB Compiler
 */
public class _RectoratStub extends org.omg.CORBA.portable.ObjectImpl
        implements Rectorat
{
    static final String[] _ids_list =
    {
        "IDL:AdmissionPostLicence/Rectorat:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = AdmissionPostLicence.RectoratOperations.class;

    /**
     * Operation creerCandidature
     */
    public void creerCandidature(AdmissionPostLicence.candidature c)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("creerCandidature",true);
                    AdmissionPostLicence.candidatureHelper.write(_output,c);
                    _input = this._invoke(_output);
                    return;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("creerCandidature",_opsClass);
                if (_so == null)
                   continue;
                AdmissionPostLicence.RectoratOperations _self = (AdmissionPostLicence.RectoratOperations) _so.servant;
                try
                {
                    _self.creerCandidature( c);
                    return;
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation recupererCandidaturesMaster
     */
    public AdmissionPostLicence.candidature[] recupererCandidaturesMaster(String master)
        throws AdmissionPostLicence.MasterInconnu
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("recupererCandidaturesMaster",true);
                    _output.write_string(master);
                    _input = this._invoke(_output);
                    AdmissionPostLicence.candidature[] _arg_ret = AdmissionPostLicence.candidaturesHelper.read(_input);
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(AdmissionPostLicence.MasterInconnuHelper.id()))
                    {
                        throw AdmissionPostLicence.MasterInconnuHelper.read(_exception.getInputStream());
                    }

                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("recupererCandidaturesMaster",_opsClass);
                if (_so == null)
                   continue;
                AdmissionPostLicence.RectoratOperations _self = (AdmissionPostLicence.RectoratOperations) _so.servant;
                try
                {
                    return _self.recupererCandidaturesMaster( master);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation recupererCandidaturesEtudiant
     */
    public AdmissionPostLicence.candidature[] recupererCandidaturesEtudiant(AdmissionPostLicence.identite etudiant)
        throws AdmissionPostLicence.EtudiantInconnu
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("recupererCandidaturesEtudiant",true);
                    AdmissionPostLicence.identiteHelper.write(_output,etudiant);
                    _input = this._invoke(_output);
                    AdmissionPostLicence.candidature[] _arg_ret = AdmissionPostLicence.candidaturesHelper.read(_input);
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(AdmissionPostLicence.EtudiantInconnuHelper.id()))
                    {
                        throw AdmissionPostLicence.EtudiantInconnuHelper.read(_exception.getInputStream());
                    }

                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("recupererCandidaturesEtudiant",_opsClass);
                if (_so == null)
                   continue;
                AdmissionPostLicence.RectoratOperations _self = (AdmissionPostLicence.RectoratOperations) _so.servant;
                try
                {
                    return _self.recupererCandidaturesEtudiant( etudiant);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation consulterEtatCandidatures
     */
    public AdmissionPostLicence.resultatCandidature[] consulterEtatCandidatures(AdmissionPostLicence.candidature[] c)
        throws AdmissionPostLicence.CandidatureInconnu
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("consulterEtatCandidatures",true);
                    AdmissionPostLicence.candidaturesHelper.write(_output,c);
                    _input = this._invoke(_output);
                    AdmissionPostLicence.resultatCandidature[] _arg_ret = AdmissionPostLicence.resultatsCandidaturesHelper.read(_input);
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(AdmissionPostLicence.CandidatureInconnuHelper.id()))
                    {
                        throw AdmissionPostLicence.CandidatureInconnuHelper.read(_exception.getInputStream());
                    }

                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("consulterEtatCandidatures",_opsClass);
                if (_so == null)
                   continue;
                AdmissionPostLicence.RectoratOperations _self = (AdmissionPostLicence.RectoratOperations) _so.servant;
                try
                {
                    return _self.consulterEtatCandidatures( c);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation modifierCandidature
     */
    public void modifierCandidature(AdmissionPostLicence.resultatCandidature candidature)
        throws AdmissionPostLicence.CandidatureInconnu
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("modifierCandidature",true);
                    AdmissionPostLicence.resultatCandidatureHelper.write(_output,candidature);
                    _input = this._invoke(_output);
                    return;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(AdmissionPostLicence.CandidatureInconnuHelper.id()))
                    {
                        throw AdmissionPostLicence.CandidatureInconnuHelper.read(_exception.getInputStream());
                    }

                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("modifierCandidature",_opsClass);
                if (_so == null)
                   continue;
                AdmissionPostLicence.RectoratOperations _self = (AdmissionPostLicence.RectoratOperations) _so.servant;
                try
                {
                    _self.modifierCandidature( candidature);
                    return;
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

}
