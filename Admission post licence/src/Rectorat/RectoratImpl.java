package Rectorat;

import AdmissionPostLicence.CandidatureInconnu;
import AdmissionPostLicence.EtudiantInconnu;
import AdmissionPostLicence.GestionEtudiant;
import AdmissionPostLicence.Master;
import AdmissionPostLicence.MasterInconnu;
import AdmissionPostLicence.Ministere;
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
    
    //La liste des gestions étudiants
    private final List<String> lesGestionEtu = new ArrayList<>();
    
    //La liste des masters
    private final List<String> lesMasters = new ArrayList<>();
    
    // La liste des universités
    private final List<String> lesUniversites = new ArrayList<>();
    
    /** Nom du Rectorat */
    private final String nom;
    
    public RectoratImpl(String aNom){
        this.nom = aNom;
        
        enregistrerSurMinistere();
    }
    
    @Override
    public void creerCandidature(candidature c) {
        Candidature candidature= CandidatureMapper.candidatureCorbaToCandidature(c);
        // Récupération du master
        //Master m = GetObjectCorba.getMasterCorba(candidature.getMaster(),candidature.getUniversite(),ServerRectorat.orb);
        
        //Je regarde si l'université cible fait partit de ma liste d'université
        for(String universite : lesUniversites){
            if(universite.equals(c.universite)){
                // Récupération de la liste des masters
                Master m=null;
                boolean trouve=false;
                for(int i=0;i<lesMasters.size()&&trouve==false;i++) {
                    m = GetObjectCorba.getMasterCorba(lesMasters.get(i), ServerRectorat.orb);
                    if( m != null) {
                        if(m.nom().equals(c.master)){
                            trouve=true;
                        }
                    }
                }
                try {
                    if(m != null) {
                        //Vérification des pré requis
                        if(m.verifierPrerequis(candidature.getEtu().getLicence())){
                            //Enregistrer candidature
                            //lesCandidatures.add(candidature);
                            CandidatureDAO.ajoutCandidature(candidature, this.nom);
                        }  
                    }
                } catch (MasterInconnu ex) {
                    Logger.getLogger(RectoratImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                Ministere ministere = GetObjectCorba.getMinistereCorba(ServerRectorat.orb);
                ministere.transfererCandidature(c,"creerCandidature");
            }
        }
    }

    @Override
    public candidature[] recupererCandidaturesMaster(String universite, String master) throws MasterInconnu {
        return CandidatureMapper.candidaturesCorbaToListCandidature(CandidatureDAO.getCandidaturesMaster(universite, master, nom));
    }

    @Override
    public candidature[] recupererCandidaturesEtudiant(identite etudiant) throws EtudiantInconnu {
        return CandidatureMapper.candidaturesCorbaToListCandidature(CandidatureDAO.getCandidaturesEtudiant(etudiant.ine, nom));
    }

    @Override
    public void modifierCandidature(candidature c) throws CandidatureInconnu {
        Candidature candidature= CandidatureMapper.candidatureCorbaToCandidature(c);
        // Récupération du master
        //Master m = GetObjectCorba.getMasterCorba(candidature.getMaster(),candidature.getUniversite(),ServerRectorat.orb);
        
        //Je regarde si l'université cible fait partit de ma liste d'université
        for(String universite : lesUniversites){
            if(universite.equals(c.universite)){
                // Récupération de la liste des masters
                Master m=null;
                boolean trouve=false;
                for(int i=0;i<lesMasters.size()&&trouve==false;i++) {
                    m = GetObjectCorba.getMasterCorba(lesMasters.get(i), ServerRectorat.orb);
                    if( m != null) {
                        if(m.nom().equals(c.master)){
                            trouve=true;
                        }
                    }
                }
                if(m != null) {
                    CandidatureDAO.modifierCandidature(candidature, this.nom);
                }
            }
            else{
                Ministere ministere = GetObjectCorba.getMinistereCorba(ServerRectorat.orb);
                ministere.transfererCandidature(c,"modifierCandidature");
            }
        }
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

    @Override
    public String nom() {
        return this.nom;
    }
    
    @Override
    public String[] getListeGestEtu() {
        String[] ge = new String[lesGestionEtu.size()];
        for(int i=0;i<lesGestionEtu.size();i++){
            ge[i]=lesGestionEtu.get(i);
        }
        return  ge;
    }

    @Override
    public void enregistrerGE(String ior, String universite) {
        if(!lesGestionEtu.contains(ior)){
            lesGestionEtu.add(ior);
        }
        if(!lesUniversites.contains(universite)){
            lesUniversites.add(universite);
        }
    }

    @Override
    public void enregistrerMaster(String ior) {
        if(!lesMasters.contains(ior)){
            lesMasters.add(ior);
        }
    }

    @Override
    public String[] getListeMaster(String u) {
        String[] m = new String[lesMasters.size()];
        int i = 0;
        for (String ior : lesMasters) {
            Master master = GetObjectCorba.getMasterCorba(ior, ServerRectorat.orb);
            if(master.universite().equals(u)) {
                m[i] = ior;
                i++;
            }
        }
        return m;
    }

    @Override
    public String[] getListeUniversite() {
        String[] u = new String[lesUniversites.size()];
        for(int i=0;i<lesUniversites.size();i++){
            u[i]=lesUniversites.get(i);
        }
        return  u;
    }
    
    /**
     * Permet d'enregistrer le rectorat auprès du ministère
     */
    private void enregistrerSurMinistere() {
        System.out.println("Méthode RectoratImpl.enregistrerSurMinistere : Début");
        
        // Récupération du ministère
        Ministere m = GetObjectCorba.getMinistereCorba(ServerRectorat.orb);
        
        m.enregistrerRectorat(ServerRectorat.getIorFromObject(this));
        
        System.out.println("Méthode RectoratImpl.enregistrerSurMinistere : Fin");
    }

    @Override
    public String getGestEtu(String universite) {
        String gestEtu = null;
        for (String ior : lesGestionEtu) {
            GestionEtudiant g = GetObjectCorba.getGestionEtudiantCorba(ServerRectorat.orb, ior);
            if(g.nom().equals(universite)) {
                gestEtu = ior;
            }
        }
        return gestEtu;
    }

    @Override
    public void supprimerCandidature(candidature c) throws CandidatureInconnu {
        Candidature candidature= CandidatureMapper.candidatureCorbaToCandidature(c);

        //Je regarde si l'université cible fait partit de ma liste d'université
        for(String universite : lesUniversites){
            if(universite.equals(c.universite)){
                // Récupération de la liste des masters
                Master m=null;
                boolean trouve=false;
                for(int i=0;i<lesMasters.size()&&trouve==false;i++) {
                    m = GetObjectCorba.getMasterCorba(lesMasters.get(i), ServerRectorat.orb);
                    if( m != null) {
                        if(m.nom().equals(c.master)){
                            trouve=true;
                        }
                    }
                }
                if(m != null) {
                    CandidatureDAO.supprimerCandidature(candidature, this.nom);
                }
            }
            else{
                Ministere ministere = GetObjectCorba.getMinistereCorba(ServerRectorat.orb);
                ministere.transfererCandidature(c,"supprimerCandidature");
            }
        }    }
    
}
