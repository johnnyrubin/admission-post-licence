package Universite.GestionEtudiant;

import AdmissionPostLicence.CandidatureInconnu;
import AdmissionPostLicence.EtudiantInconnu;
import AdmissionPostLicence.GestionEtudiantPOA;
import AdmissionPostLicence.MasterInconnu;
import AdmissionPostLicence.Rectorat;
import AdmissionPostLicence.RectoratHelper;
import AdmissionPostLicence.candidature;
import AdmissionPostLicence.decisionCandidat;
import AdmissionPostLicence.identite;
import AdmissionPostLicence.resultatCandidature;
import AdmissionPostLicence.resultatsEtudiant;
import Universite.ServerUniversite;
import Universite.pojo.Etudiant;
import Universite.database.EtudiantDAO;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

/**
 * Classe d'implémentation permettant de gérer les étudiants d'une université
 * 
 * @author Teddy
 */
public class GestionEtudiantImpl extends GestionEtudiantPOA {
    
    /** Liste de ses étudiants ayant pour clé l'ine de l'étudiant **/
    private static Hashtable<String,identite> lesEtudiants;

    /**
     * Retourne la liste des étudiants
     * @return la liste des étudiants
     */
    public static Hashtable<String, identite> getLesEtudiants() {
        return lesEtudiants;
    }

    /**
     * Définit la liste des étudiants
     * @param lesEtudiants 
     */
    public static void setLesEtudiants(Hashtable<String, identite> lesEtudiants) {
        GestionEtudiantImpl.lesEtudiants = lesEtudiants;
    }
    
    /**
     * Ajoute un étudiant à la liste
     * @param i 
     */
    public static void addEtudiant(identite i){
       GestionEtudiantImpl.lesEtudiants.put(i.ine, i);
    }
    
    /**
     * Retourne l'objet identité lié à cet INE
     * @param ine
     * @return objet identite de l'étudiant 
     */
    public static identite getEtudiant(String ine){
        return GestionEtudiantImpl.lesEtudiants.get(ine);
    }
    
    /** Le nom du rectorat auquel appartient l'université de cette gestion étudiant */
    private String rectorat;
    
    /**
     * Retourne le nom du rectorat
     * 
     * @return
     */
    public String getRectorat() {
        return rectorat;
    }
    
    /**
     * Définit le nom du rectorat
     * 
     * @param aRectorat 
     */
    public void setRectorat(String aRectorat) {
        rectorat = aRectorat;
    }

    @Override
    public void soumettreCandidature(candidature c) throws MasterInconnu {
        // Récupération du rectorat
        Rectorat r = getRectoratCorba();

        // Création de la candidature
        if(r != null) {
            r.creerCandidature(c);
        }
    }

    @Override
    public resultatsEtudiant recupererResultats(identite etudiant) throws EtudiantInconnu {
        // Initialisation de la variable de retour
        resultatsEtudiant resultats = null;        

        // Récupération de l'étudiant dans la base de données de l'université
        Etudiant e = EtudiantDAO.getFromIne(etudiant.ine);        
        
        if(e != null) {
            // On convertit les données obtenues en bd en objets utilisés par corba
            resultats = EtudiantMapper.etudiantToResultatsEtudiantCorba(e);
        } else {
            throw new EtudiantInconnu();
        }
        
        return resultats;
    }

    @Override
    public resultatCandidature[] consulterEtatVoeux(identite etudiant) throws EtudiantInconnu {
        // Initialisation de la variable de retour
        resultatCandidature[] resultats = null;
        
        // Récupération de l'étudiant dans la base de données de l'université
        Etudiant e = EtudiantDAO.getFromIne(etudiant.ine);
        
        if(e != null) {
            // Récupération du rectorat
            Rectorat r = getRectoratCorba();
            
            if(r != null) {
                // Récupation des candidatures de l'étudiant
                candidature[] candidaturesEtudiant = r.recupererCandidaturesEtudiant(etudiant);
                
                try {
                    // Puis on récupère l'état des candidatures l'état des candidatures
                    if(candidaturesEtudiant != null) {
                        resultats = r.consulterEtatCandidatures(candidaturesEtudiant);
                    }
                } catch (CandidatureInconnu ex) {
                    Logger.getLogger(GestionEtudiantImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            throw new EtudiantInconnu();
        }
        
        return resultats;
    }

    @Override
    public void modifierDecision(candidature c, decisionCandidat dc) {
        // Récupération du rectorat
        Rectorat r = getRectoratCorba();
        
        if(r != null) {
            // Création de l'obet resultatCandidature
            resultatCandidature res = new resultatCandidature(c, null, dc, null);
            
            try {
                // On transmet la décision de l'étudiant au rectorat
                r.modifierCandidature(res);
            } catch (CandidatureInconnu ex) {
                Logger.getLogger(GestionEtudiantImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public identite seConnecter(String ine, String mdp) throws EtudiantInconnu {
        
        System.out.println("GestionEtudiantImpl.seConnecter");
        
        // Initialisation de la variable de retour
        identite identite = null;
        
        // Récupération de l'étudiant dans la base de données de l'université
        Etudiant e = EtudiantDAO.getFromIne(ine);
        
        if(e != null) {
            // On compare les mots de passe
            if(e.getMdp().equals(mdp)) {
                identite = EtudiantMapper.etudiantToIdentiteCorba(e);
            }
        } else {
            throw new EtudiantInconnu();
        }
        
        return identite;
    }
    
    /**
     * Permet de récupérer l'objet CORBA du rectorat de l'université de cette gestion étudiant
     * 
     * @return {@link Rectorat}
     */
    private Rectorat getRectoratCorba() {        
        // Initialisation de la variable de retour
        Rectorat r = null;
        
        try {
            NamingContext root = org.omg.CosNaming.NamingContextHelper.narrow(ServerUniversite.orb.resolve_initial_references("NameService"));
            org.omg.CosNaming.NameComponent[] nameToFind = new org.omg.CosNaming.NameComponent[1];
            
            // On récupère le rectorat
            nameToFind[0] = new org.omg.CosNaming.NameComponent(rectorat, "");
            org.omg.CORBA.Object remoteRef = root.resolve(nameToFind);
            r = RectoratHelper.narrow(remoteRef);
            
        } catch (InvalidName | NotFound | CannotProceed | org.omg.CosNaming.NamingContextPackage.InvalidName ex) {
            Logger.getLogger(GestionEtudiantImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return r;
    }
    
}
