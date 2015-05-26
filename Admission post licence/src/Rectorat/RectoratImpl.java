package Rectorat;

import AdmissionPostLicence.CandidatureInconnu;
import AdmissionPostLicence.EtudiantInconnu;
import AdmissionPostLicence.Master;
import AdmissionPostLicence.MasterHelper;
import AdmissionPostLicence.MasterInconnu;
import AdmissionPostLicence.RectoratPOA;
import AdmissionPostLicence.candidature;
import AdmissionPostLicence.identite;
import AdmissionPostLicence.resultatCandidature;
import Rectorat.database.CandidatureDAO;
import Rectorat.pojo.Candidature;
import Rectorat.pojo.ResultatCandidature;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

/**
 *
 * @author Teddy
 */
public class RectoratImpl extends RectoratPOA{

    //La liste des candidatures du rectorat ayant pour clé l'INE de l'étudiant
    private HashMap<String,Candidature> lesCandidatures;
    
    //La liste des resultats des candidatures
    private HashMap<String,ResultatCandidature> lesResultatsCandidatures;

    /** Nom du Rectorat */
    private String nom;
    
    /**
     * Retourne le nom du Rectorat
     * 
     * @return le nom
     */
    public String getNom() {
        return nom;
    }
    
    /**
     * Définit le nom du Rectorat
     * 
     * @param aNom 
     */
    public void setNom(String aNom) {
        nom = aNom;
    }

    public RectoratImpl(String nom){
        this.nom=nom;
    }

    public HashMap<String,Candidature> getLesCandidatures() {
        return lesCandidatures;
    }
    
    @Override
    public void creerCandidature(candidature c) {
        Candidature candidature= CandidatureMapper.candidatureCorbaToCandidature(c);
        // Récupération du rectorat
        Master m = getMasterCorba(candidature.getMaster().getNom());
        try {
            if(m != null) {
                //Vérification des pré requis
                if(m.verifierPrerequis(candidature.getEtu().getLicence())){
                    //Enregistrer candidature
                    lesCandidatures.put(candidature.getEtu().getIne(), candidature);
                    CandidatureDAO.ajoutCandidature(candidature, this.nom);
                    //TODO créer resultatCandidature a blanc pour pouvoir mettre en place l'exception
                }  
            }
        } catch (MasterInconnu ex) {
            Logger.getLogger(RectoratImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public candidature[] recupererCandidaturesMaster(String master) throws MasterInconnu {
        candidature[] candidatures={};

        for(int i=0;i<lesCandidatures.length;i++){
           //Si les deux string master sont identique, alors on garde cette candidature 
           if(lesCandidatures[i].master.equals(master)){
               candidatures=addCandidature(candidatures, lesCandidatures[i]);
           }
        }
        return candidatures;
    }

    @Override
    public candidature[] recupererCandidaturesEtudiant(identite etudiant) throws EtudiantInconnu {
        candidature[] candidatures={};

        for(int i=0;i<lesCandidatures.length;i++){
           //Si les deux string master sont identique, alors on garde cette candidature 
           if(lesCandidatures[i].etudiant.ine.equals(etudiant.ine)){
               candidatures=addCandidature(candidatures, lesCandidatures[i]);
           }
        }
        return candidatures;
    }

    @Override
    public resultatCandidature[] consulterEtatCandidatures(candidature[] c) throws CandidatureInconnu {
        resultatCandidature[] rcs=null;
        resultatCandidature rc;
        /*Boucler sur chaque candidature et dans la boucle aller chercher le resultat dans les résultats locaux
        puis insérer dans la varible résultatCandidature a renvoyer*/
        for(int i=0;i<c.length;i++){
            rc=searchCandidature(c[i]);
            addResultatCandidature(rcs, rc);
        }
        return rcs;
    }

    @Override
    public void modifierCandidature(resultatCandidature candidature) throws CandidatureInconnu {
        boolean trouve=false;
        for(int i=0;i<lesResultatsCandidatures.length&&!trouve;i++){
            //Si je rentre dans le if c'est que j'ai trouvé le resultatCandidature
            if(lesResultatsCandidatures[i].c.etudiant.ine.equals(candidature.c.etudiant.ine) && 
                    lesResultatsCandidatures[i].c.master.equals(candidature.c.master)){
                //Je le modifie alors
                lesResultatsCandidatures[i]=candidature;
                trouve=true;
            }
        }
        //Si on a pas trouvé la candidature alors on l'ajoute
        if(!trouve){
            addResultatCandidature(lesResultatsCandidatures,candidature);
        }
    }
    
    private Master getMasterCorba(String master) {
        // Initialisation de la variable de retour
        Master r = null;
        
        try {
            NamingContext root = org.omg.CosNaming.NamingContextHelper.narrow(ServerRectorat.orb.resolve_initial_references("NameService"));
            org.omg.CosNaming.NameComponent[] nameToFind = new org.omg.CosNaming.NameComponent[1];
            
            // On récupère le rectorat
            nameToFind[0] = new org.omg.CosNaming.NameComponent(master, "");
            org.omg.CORBA.Object remoteRef = root.resolve(nameToFind);
            r = MasterHelper.narrow(remoteRef);
            
            return r;
        } catch (InvalidName | NotFound | CannotProceed | org.omg.CosNaming.NamingContextPackage.InvalidName ex) {
            Logger.getLogger(RectoratImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return r;
    }
    
    private resultatCandidature searchCandidature(candidature c){
        resultatCandidature rc = null;
        for(int i=0;i<lesResultatsCandidatures.length;i++){
            //Si je rentre dans le if c'est que j'ai trouvé le resultatCandidature
            if(lesResultatsCandidatures[i].c.etudiant.ine.equals(c.etudiant.ine) && 
                    lesResultatsCandidatures[i].c.master.equals(c.master)){
                rc=lesResultatsCandidatures[i];
            }
        }
        return rc;
    }
    
    /**
     * Ajoute la nouvelle valeur dans le tableau
     * @param oldArray
     * @param newValue
     * @return 
     */
    private candidature[] addCandidature(candidature[] oldArray,candidature newValue){
        //define the new array
        candidature[] newArray = new candidature[oldArray.length + 1];
        //copy values into new array
        for(int i=0;i < oldArray.length;i++)
            newArray[i] = oldArray[i];
        //add new value to the new array
        newArray[newArray.length-1] = newValue;
        
        return newArray;
    }
    
    /**
     * Ajoute la nouvelle valeur dans le tableau
     * @param oldArray
     * @param newValue
     * @return 
     */
    private resultatCandidature[] addResultatCandidature(resultatCandidature[] oldArray,resultatCandidature newValue){
        //define the new array
        resultatCandidature[] newArray = new resultatCandidature[oldArray.length + 1];
        //copy values into new array
        for(int i=0;i < oldArray.length;i++)
            newArray[i] = oldArray[i];
        //add new value to the new array
        newArray[newArray.length-1] = newValue;
        
        return newArray;
    }
    
}
