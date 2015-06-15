package Ministere;

import AdmissionPostLicence.CandidatureInconnu;
import AdmissionPostLicence.MinisterePOA;
import AdmissionPostLicence.Rectorat;
import AdmissionPostLicence.accreditation;
import AdmissionPostLicence.candidature;
import AdmissionPostLicence.periode;
import Ministere.database.AccreditationDAO;
import Util.GetObjectCorba;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Teddy
 */
public class MinistereImpl extends MinisterePOA{
    //Liste qui permet de savoir à quel rectorat appartient une université, la clé est l'université
    //et la valeur le rectorat
    private HashMap<String,String> lesLiaisons;
    //Liste des rectorats
    private ArrayList<String> lesRectorats = new ArrayList<String>();
    
    // Periode en cours
    private periode periodeEnCours;

    public void setLesLiaisons(HashMap<String, String> lesLiaisons) {
        this.lesLiaisons = lesLiaisons;
    }
    
    @Override
    public accreditation[] recupererAccreditations() {
        return AccreditationMapper.accreditationsCorbaToListAccredidation(AccreditationDAO.getAccreditations());
    }

    @Override
    public void transfererCandidature(candidature c, String action) {
        //L'orientation de transfert se fait à partir des variables universite et master qui se trouvent
        //dans la candidature
        //on récupère donc le rectorat
        //Rectorat r = GetObjectCorba.getRectoratCorba(lesLiaisons.get(c.universite),ServerMinistere.orb);
        Rectorat r=null;
        boolean trouve=false;
        for(int i=0;i<lesRectorats.size()&&trouve==false;i++) {
            r = GetObjectCorba.getRectoratCorba(ServerMinistere.orb, lesRectorats.get(i));
            if( r != null) {
                for(String universite : r.getListeUniversite()){
                    if(universite.equals(c.universite)){
                        trouve=true;
                    }
                }
            }
        }
        switch(action){
            case "creerCandidature":
                r.creerCandidature(c);
                break;
            case "modifierCandidature":
                try {
                    r.modifierCandidature(c);
                } catch (CandidatureInconnu ex) {
                    Logger.getLogger(MinistereImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "supprimerCandidature":
                try {
                    r.supprimerCandidature(c);
                } catch (CandidatureInconnu ex) {
                    Logger.getLogger(MinistereImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            default:
                break;
        } 
    }

    @Override
    public void transfererDecision(candidature c) throws CandidatureInconnu {
        try{
            Rectorat r;
            for (String ior : lesRectorats) {
                r = GetObjectCorba.getRectoratCorba(ServerMinistere.orb, ior);
                
                if (r.nom().equals(lesLiaisons.get(c.universite))) {
                    r.modifierCandidature(c);
                }
            }
        
        } catch (CandidatureInconnu ex) {
            Logger.getLogger(MinistereImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public String[] getListeRectorat() {
        
        System.out.println("Appel méthode MinistereImpl.getListeRectorat : Début");
        
        String[] r = new String[0];
//        int i = 0;lesRectorats.size()
//        for(Rectorat t : lesRectorats) {
//            System.out.println("Rectorat : " + t.nom());
//            r[i] = t;
//            i++;
//        }
        
        System.out.println("Appel méthode MinistereImpl.getListeRectorat : Fin");
        return lesRectorats.toArray(r);
    }

    @Override
    public void enregistrerRectorat(String ior) {
        System.out.println("Méthode MinistereImpl.enregistrerRectorat : Début");
        lesRectorats.add(ior);
        System.out.println("Méthode MinistereImpl.enregistrerRectorat : Fin");
    }

    @Override
    public periode periodeEnCours() {
        return periodeEnCours;
    }

    @Override
    public void periodeEnCours(periode value) {
        periodeEnCours = value;
    }
    
}
