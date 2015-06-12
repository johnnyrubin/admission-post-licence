package AdmissionPostLicence;

/**
 * Interface definition : GestionEtudiant
 * 
 * @author OpenORB Compiler
 */
public class _GestionEtudiantStub extends org.omg.CORBA.portable.ObjectImpl
        implements GestionEtudiant
{
    static final String[] _ids_list =
    {
        "IDL:AdmissionPostLicence/GestionEtudiant:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = AdmissionPostLicence.GestionEtudiantOperations.class;

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
                AdmissionPostLicence.GestionEtudiantOperations _self = (AdmissionPostLicence.GestionEtudiantOperations) _so.servant;
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
     * Operation soumettreCandidature
     */
    public void soumettreCandidature(AdmissionPostLicence.candidature c)
        throws AdmissionPostLicence.MasterInconnu
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("soumettreCandidature",true);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("soumettreCandidature",_opsClass);
                if (_so == null)
                   continue;
                AdmissionPostLicence.GestionEtudiantOperations _self = (AdmissionPostLicence.GestionEtudiantOperations) _so.servant;
                try
                {
                    _self.soumettreCandidature( c);
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
     * Operation recupererResultats
     */
    public AdmissionPostLicence.resultatsEtudiant recupererResultats(AdmissionPostLicence.identite etudiant)
        throws AdmissionPostLicence.EtudiantInconnu
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("recupererResultats",true);
                    AdmissionPostLicence.identiteHelper.write(_output,etudiant);
                    _input = this._invoke(_output);
                    AdmissionPostLicence.resultatsEtudiant _arg_ret = AdmissionPostLicence.resultatsEtudiantHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("recupererResultats",_opsClass);
                if (_so == null)
                   continue;
                AdmissionPostLicence.GestionEtudiantOperations _self = (AdmissionPostLicence.GestionEtudiantOperations) _so.servant;
                try
                {
                    return _self.recupererResultats( etudiant);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation consulterEtatVoeux
     */
    public AdmissionPostLicence.candidature[] consulterEtatVoeux(AdmissionPostLicence.identite etudiant)
        throws AdmissionPostLicence.EtudiantInconnu
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("consulterEtatVoeux",true);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("consulterEtatVoeux",_opsClass);
                if (_so == null)
                   continue;
                AdmissionPostLicence.GestionEtudiantOperations _self = (AdmissionPostLicence.GestionEtudiantOperations) _so.servant;
                try
                {
                    return _self.consulterEtatVoeux( etudiant);
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
    public void modifierDecision(AdmissionPostLicence.candidature c, AdmissionPostLicence.decisionCandidat dc)
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
                    AdmissionPostLicence.decisionCandidatHelper.write(_output,dc);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("modifierDecision",_opsClass);
                if (_so == null)
                   continue;
                AdmissionPostLicence.GestionEtudiantOperations _self = (AdmissionPostLicence.GestionEtudiantOperations) _so.servant;
                try
                {
                    _self.modifierDecision( c,  dc);
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
     * Operation seConnecter
     */
    public AdmissionPostLicence.identite seConnecter(String ine, String mdp)
        throws AdmissionPostLicence.EtudiantInconnu
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("seConnecter",true);
                    _output.write_string(ine);
                    _output.write_string(mdp);
                    _input = this._invoke(_output);
                    AdmissionPostLicence.identite _arg_ret = AdmissionPostLicence.identiteHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("seConnecter",_opsClass);
                if (_so == null)
                   continue;
                AdmissionPostLicence.GestionEtudiantOperations _self = (AdmissionPostLicence.GestionEtudiantOperations) _so.servant;
                try
                {
                    return _self.seConnecter( ine,  mdp);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

}
