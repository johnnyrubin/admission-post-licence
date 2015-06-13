package AdmissionPostLicence;

/**
 * Interface definition : Master
 * 
 * @author OpenORB Compiler
 */
public class _MasterStub extends org.omg.CORBA.portable.ObjectImpl
        implements Master
{
    static final String[] _ids_list =
    {
        "IDL:AdmissionPostLicence/Master:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = AdmissionPostLicence.MasterOperations.class;

    /**
     * Read accessor for nom attribute
     * @return the attribute value
     */
    public String nom()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try {
                    org.omg.CORBA.portable.OutputStream _output = this._request("_get_nom",true);
                    _input = this._invoke(_output);
                    return _input.read_string();
                } catch (final org.omg.CORBA.portable.RemarshalException _exception) {
                    continue;
                } catch (final org.omg.CORBA.portable.ApplicationException _exception) {
                    final String _exception_id = _exception.getId();
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                } finally {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("_get_nom",_opsClass);
                if (_so == null)
                   continue;
                AdmissionPostLicence.MasterOperations _self = (AdmissionPostLicence.MasterOperations) _so.servant;
                try
                {
                    return _self.nom();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Read accessor for universite attribute
     * @return the attribute value
     */
    public String universite()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try {
                    org.omg.CORBA.portable.OutputStream _output = this._request("_get_universite",true);
                    _input = this._invoke(_output);
                    return _input.read_string();
                } catch (final org.omg.CORBA.portable.RemarshalException _exception) {
                    continue;
                } catch (final org.omg.CORBA.portable.ApplicationException _exception) {
                    final String _exception_id = _exception.getId();
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                } finally {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("_get_universite",_opsClass);
                if (_so == null)
                   continue;
                AdmissionPostLicence.MasterOperations _self = (AdmissionPostLicence.MasterOperations) _so.servant;
                try
                {
                    return _self.universite();
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
    public AdmissionPostLicence.candidature[] consulterEtatCandidatures()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("consulterEtatCandidatures",true);
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
                AdmissionPostLicence.MasterOperations _self = (AdmissionPostLicence.MasterOperations) _so.servant;
                try
                {
                    return _self.consulterEtatCandidatures();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation modifierDecision
     */
    public void modifierDecision(AdmissionPostLicence.candidature c, AdmissionPostLicence.decisionMaster dm)
        throws AdmissionPostLicence.CandidatureInconnu
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("modifierDecision",true);
                    AdmissionPostLicence.candidatureHelper.write(_output,c);
                    AdmissionPostLicence.decisionMasterHelper.write(_output,dm);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("modifierDecision",_opsClass);
                if (_so == null)
                   continue;
                AdmissionPostLicence.MasterOperations _self = (AdmissionPostLicence.MasterOperations) _so.servant;
                try
                {
                    _self.modifierDecision( c,  dm);
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
     * Operation verifierPrerequis
     */
    public boolean verifierPrerequis(String licence)
        throws AdmissionPostLicence.MasterInconnu
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("verifierPrerequis",true);
                    _output.write_string(licence);
                    _input = this._invoke(_output);
                    boolean _arg_ret = _input.read_boolean();
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("verifierPrerequis",_opsClass);
                if (_so == null)
                   continue;
                AdmissionPostLicence.MasterOperations _self = (AdmissionPostLicence.MasterOperations) _so.servant;
                try
                {
                    return _self.verifierPrerequis( licence);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

}
