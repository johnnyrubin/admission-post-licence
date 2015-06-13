package AdmissionPostLicence;

/**
 * Interface definition : Ministere
 * 
 * @author OpenORB Compiler
 */
public class _MinistereStub extends org.omg.CORBA.portable.ObjectImpl
        implements Ministere
{
    static final String[] _ids_list =
    {
        "IDL:AdmissionPostLicence/Ministere:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = AdmissionPostLicence.MinistereOperations.class;

    /**
     * Operation recupererAccreditations
     */
    public AdmissionPostLicence.accreditation[] recupererAccreditations()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("recupererAccreditations",true);
                    _input = this._invoke(_output);
                    AdmissionPostLicence.accreditation[] _arg_ret = AdmissionPostLicence.accreditationsHelper.read(_input);
                    return _arg_ret;
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("recupererAccreditations",_opsClass);
                if (_so == null)
                   continue;
                AdmissionPostLicence.MinistereOperations _self = (AdmissionPostLicence.MinistereOperations) _so.servant;
                try
                {
                    return _self.recupererAccreditations();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation transfererCandidature
     */
    public void transfererCandidature(AdmissionPostLicence.candidature c)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("transfererCandidature",true);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("transfererCandidature",_opsClass);
                if (_so == null)
                   continue;
                AdmissionPostLicence.MinistereOperations _self = (AdmissionPostLicence.MinistereOperations) _so.servant;
                try
                {
                    _self.transfererCandidature( c);
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
     * Operation transfererDecision
     */
    public void transfererDecision(AdmissionPostLicence.candidature r)
        throws AdmissionPostLicence.CandidatureInconnu
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("transfererDecision",true);
                    AdmissionPostLicence.candidatureHelper.write(_output,r);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("transfererDecision",_opsClass);
                if (_so == null)
                   continue;
                AdmissionPostLicence.MinistereOperations _self = (AdmissionPostLicence.MinistereOperations) _so.servant;
                try
                {
                    _self.transfererDecision( r);
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
     * Operation getListeRectorat
     */
    public String[] getListeRectorat()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("getListeRectorat",true);
                    _input = this._invoke(_output);
                    String[] _arg_ret = AdmissionPostLicence.rectoratsHelper.read(_input);
                    return _arg_ret;
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getListeRectorat",_opsClass);
                if (_so == null)
                   continue;
                AdmissionPostLicence.MinistereOperations _self = (AdmissionPostLicence.MinistereOperations) _so.servant;
                try
                {
                    return _self.getListeRectorat();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation enregistrerRectorat
     */
    public void enregistrerRectorat(String ior)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("enregistrerRectorat",true);
                    _output.write_string(ior);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("enregistrerRectorat",_opsClass);
                if (_so == null)
                   continue;
                AdmissionPostLicence.MinistereOperations _self = (AdmissionPostLicence.MinistereOperations) _so.servant;
                try
                {
                    _self.enregistrerRectorat( ior);
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
