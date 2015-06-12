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
                AdmissionPostLicence.RectoratOperations _self = (AdmissionPostLicence.RectoratOperations) _so.servant;
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
     * Operation modifierCandidature
     */
    public void modifierCandidature(AdmissionPostLicence.candidature candidature)
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
                    AdmissionPostLicence.candidatureHelper.write(_output,candidature);
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

    /**
     * Operation getListeGestEtu
     */
    public AdmissionPostLicence.GestionEtudiant[] getListeGestEtu()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("getListeGestEtu",true);
                    _input = this._invoke(_output);
                    AdmissionPostLicence.GestionEtudiant[] _arg_ret = AdmissionPostLicence.gestionEtudiantsHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getListeGestEtu",_opsClass);
                if (_so == null)
                   continue;
                AdmissionPostLicence.RectoratOperations _self = (AdmissionPostLicence.RectoratOperations) _so.servant;
                try
                {
                    return _self.getListeGestEtu();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation enregistrerGE
     */
    public void enregistrerGE(AdmissionPostLicence.GestionEtudiant ge)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("enregistrerGE",true);
                    AdmissionPostLicence.GestionEtudiantHelper.write(_output,ge);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("enregistrerGE",_opsClass);
                if (_so == null)
                   continue;
                AdmissionPostLicence.RectoratOperations _self = (AdmissionPostLicence.RectoratOperations) _so.servant;
                try
                {
                    _self.enregistrerGE( ge);
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
     * Operation getListeMaster
     */
    public AdmissionPostLicence.Master[] getListeMaster(String u)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("getListeMaster",true);
                    _output.write_string(u);
                    _input = this._invoke(_output);
                    AdmissionPostLicence.Master[] _arg_ret = AdmissionPostLicence.mastersHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getListeMaster",_opsClass);
                if (_so == null)
                   continue;
                AdmissionPostLicence.RectoratOperations _self = (AdmissionPostLicence.RectoratOperations) _so.servant;
                try
                {
                    return _self.getListeMaster( u);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation enregistrerMaster
     */
    public void enregistrerMaster(AdmissionPostLicence.Master m)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("enregistrerMaster",true);
                    AdmissionPostLicence.MasterHelper.write(_output,m);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("enregistrerMaster",_opsClass);
                if (_so == null)
                   continue;
                AdmissionPostLicence.RectoratOperations _self = (AdmissionPostLicence.RectoratOperations) _so.servant;
                try
                {
                    _self.enregistrerMaster( m);
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
     * Operation getListeUniversite
     */
    public String[] getListeUniversite()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("getListeUniversite",true);
                    _input = this._invoke(_output);
                    String[] _arg_ret = AdmissionPostLicence.universitesHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getListeUniversite",_opsClass);
                if (_so == null)
                   continue;
                AdmissionPostLicence.RectoratOperations _self = (AdmissionPostLicence.RectoratOperations) _so.servant;
                try
                {
                    return _self.getListeUniversite();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

}
