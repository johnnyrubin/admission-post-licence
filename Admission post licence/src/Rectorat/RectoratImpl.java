package Rectorat;

import AdmissionPostLicence.CandidatureInconnu;
import AdmissionPostLicence.EtudiantInconnu;
import AdmissionPostLicence.GestionEtudiant;
import AdmissionPostLicence.Master;
import AdmissionPostLicence.MasterInconnu;
import AdmissionPostLicence.RectoratPOA;
import AdmissionPostLicence.candidature;
import AdmissionPostLicence.identite;
import Rectorat.database.CandidatureDAO;
import Rectorat.pojo.Candidature;
import Util.GetObjectCorba;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Teddy
 */
public class RectoratImpl extends RectoratPOA{

    //La liste des candidatures du rectorat
    private List<Candidature> lesCandidatures = new ArrayList<Candidature>();
    
    //La liste des gestions étudiants
    private List<GestionEtudiant> lesGestionEtu = new ArrayList<GestionEtudiant>();
    
    //La liste des masters
    private List<Master> lesMasters = new ArrayList<Master>();
    
    /** Nom du Rectorat */
    private String nom;
    
    public RectoratImpl(String aNom){
        this.nom = aNom;
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
    public void modifierCandidature(candidature candidature) throws CandidatureInconnu {
        boolean trouve=false;
        for(int i=0;i<lesCandidatures.size()&&!trouve;i++){
            //Si je rentre dans le if c'est que j'ai trouvé le resultatCandidature
            if(lesCandidatures.get(i).getEtu().getIne().equals(candidature.etudiant.ine) && 
                    lesCandidatures.get(i).getMaster().equals(candidature.master)){
                //Je le modifie alors
                lesCandidatures.set(i, CandidatureMapper.candidatureCorbaToCandidature(candidature));
                trouve=true;
            }
        }
        //Si on a pas trouvé la candidature alors on l'ajoute
        /*if(!trouve){
            lesResultatsCandidatures.add(CandidatureMapper.resultatCandidatureCorbaToResultatCandidature(candidature));
        }*/
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
    
    /*private candidature searchCandidature(candidature c){
        candidature rc = null;
        for(int i=0;i<lesResultatsCandidatures.size();i++){
            //Si je rentre dans le if c'est que j'ai trouvé le resultatCandidature
            if(lesResultatsCandidatures.get(i).getCandidature().getEtu().getIne().equals(c.etudiant.ine) && 
               lesResultatsCandidatures.get(i).getCandidature().getMaster().equals(c.master)){
                rc=CandidatureMapper.candidatureToCandidatureCorba(lesResultatsCandidatures.get(i));
            }
        }
        return rc;
    }*/
    
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
    /*private resultatCandidature[] addResultatCandidature(resultatCandidature[] oldArray,resultatCandidature newValue){
        //define the new array
        resultatCandidature[] newArray = new resultatCandidature[oldArray.length + 1];
        //copy values into new array
        System.arraycopy(oldArray, 0, newArray, 0, oldArray.length);
        //add new value to the new array
        newArray[newArray.length-1] = newValue;
        
        return newArray;
    }*/

    @Override
    public String nom() {
        return this.nom;
    }
    
    @Override
    public GestionEtudiant[] getListeGestEtu() {
        GestionEtudiant[] ge = null;
        return lesGestionEtu.toArray(ge);
    }

    @Override
    public void enregistrerGE(GestionEtudiant ge) {
        lesGestionEtu.add(ge);
    }

    @Override
    public void enregistrerMaster(Master m) {
        lesMasters.add(m);
    }

    @Override
    public Master[] getListeMaster(String u) {
        // TODO modif pour filtrer par universite
        Master[] m = null;
        return lesMasters.toArray(m);
    }

    @Override
    public String[] getListeUniversite() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
