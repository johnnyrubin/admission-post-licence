package Rectorat;

import AdmissionPostLicence.CandidatureInconnu;
import AdmissionPostLicence.EtudiantInconnu;
import AdmissionPostLicence.Master;
import AdmissionPostLicence.MasterInconnu;
import AdmissionPostLicence.RectoratPOA;
import AdmissionPostLicence.candidature;
import AdmissionPostLicence.identite;
import AdmissionPostLicence.resultatCandidature;
import Rectorat.database.CandidatureDAO;
import Rectorat.pojo.Candidature;
import Rectorat.pojo.ResultatCandidature;
import Util.GetObjectCorba;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Teddy
 */
public class RectoratImpl extends RectoratPOA{

    //La liste des candidatures du rectorat
    private List<Candidature> lesCandidatures;
    
    //La liste des resultats des candidatures
    private List<ResultatCandidature> lesResultatsCandidatures;

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

    public List<Candidature> getLesCandidatures() {
        return lesCandidatures;
    }
    
    @Override
    public void creerCandidature(candidature c) {
        Candidature candidature= CandidatureMapper.candidatureCorbaToCandidature(c);
        // Récupération du rectorat
        Master m = GetObjectCorba.getMasterCorba(candidature.getMaster(),candidature.getUniversite(),ServerRectorat.orb);
        try {
            if(m != null) {
                //Vérification des pré requis
                if(m.verifierPrerequis(candidature.getEtu().getLicence())){
                    //Enregistrer candidature
                    lesCandidatures.add(candidature);
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

        for (Candidature lesCandidature : lesCandidatures) {
            //Si les deux string master sont identique, alors on garde cette candidature
            if (lesCandidature.getMaster().equals(master)) {
                candidatures = addCandidature(candidatures, CandidatureMapper.candidatureToCandidatureCorba(lesCandidature));
            }
        }
        return candidatures;
    }

    @Override
    public candidature[] recupererCandidaturesEtudiant(identite etudiant) throws EtudiantInconnu {
        candidature[] candidatures={};
        for (Candidature lesCandidature : lesCandidatures) {
            //Si les deux string master sont identique, alors on garde cette candidature
            if (lesCandidature.getEtu().getIne().equals(etudiant.ine)) {
                candidatures = addCandidature(candidatures, CandidatureMapper.candidatureToCandidatureCorba(lesCandidature));
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
        for (candidature c1 : c) {
            rc = searchCandidature(c1);
            addResultatCandidature(rcs, rc);
        }
        return rcs;
    }

    @Override
    public void modifierCandidature(resultatCandidature candidature) throws CandidatureInconnu {
        boolean trouve=false;
        for(int i=0;i<lesResultatsCandidatures.size()&&!trouve;i++){
            //Si je rentre dans le if c'est que j'ai trouvé le resultatCandidature
            if(lesResultatsCandidatures.get(i).getCandidature().getEtu().getIne().equals(candidature.c.etudiant.ine) && 
                    lesResultatsCandidatures.get(i).getCandidature().getMaster().equals(candidature.c.master)){
                //Je le modifie alors
                lesResultatsCandidatures.set(i, CandidatureMapper.resultatCandidatureCorbaToResultatCandidature(candidature));
                trouve=true;
            }
        }
        //Si on a pas trouvé la candidature alors on l'ajoute
        if(!trouve){
            lesResultatsCandidatures.add(CandidatureMapper.resultatCandidatureCorbaToResultatCandidature(candidature));
        }
    }
    
    /*private Master getMasterCorba(String master) {
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
    }*/
    
    private resultatCandidature searchCandidature(candidature c){
        resultatCandidature rc = null;
        for(int i=0;i<lesResultatsCandidatures.size();i++){
            //Si je rentre dans le if c'est que j'ai trouvé le resultatCandidature
            if(lesResultatsCandidatures.get(i).getCandidature().getEtu().getIne().equals(c.etudiant.ine) && 
               lesResultatsCandidatures.get(i).getCandidature().getMaster().equals(c.master)){
                rc=CandidatureMapper.resultatCandidatureToResultatCandidatureCorba(lesResultatsCandidatures.get(i));
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
        System.arraycopy(oldArray, 0, newArray, 0, oldArray.length);
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
        System.arraycopy(oldArray, 0, newArray, 0, oldArray.length);
        //add new value to the new array
        newArray[newArray.length-1] = newValue;
        
        return newArray;
    }
    
}
