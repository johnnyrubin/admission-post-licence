package ministere;

import Mapper.AccreditationMapper;
import AdmissionPostLicence.CandidatureInconnu;
import AdmissionPostLicence.MinisterePOA;
import AdmissionPostLicence.Rectorat;
import AdmissionPostLicence.accreditation;
import AdmissionPostLicence.candidature;
import AdmissionPostLicence.periode;
import ministere.database.AccreditationDAO;
import Util.GetObjectCorba;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import ministere.database.PeriodeDAO;

/**
 *
 * 
 */
public class MinistereImpl extends MinisterePOA {
    
    //Liste qui permet de savoir à quel rectorat appartient une université, la clé est l'université
    //et la valeur l'ior du rectorat
    private HashMap<String,String> liaisons;
    
    //Liste des rectorats
    private final ArrayList<String> rectorats = new ArrayList<>();
    
    // Période en cours
    private periode periodeEnCours;

    public MinistereImpl() {
        this.periodeEnCours = periode.from_int(PeriodeDAO.getPeriode()-1);
    }
    
    /**
     * 
     * @param desLiaisons 
     */
    public void setLesLiaisons(HashMap<String, String> desLiaisons) {
        this.liaisons = desLiaisons;
    }
    
    @Override
    public accreditation[] recupererAccreditations() {
        System.out.println("Appel Méthode MinistereImpl.recupererAccreditations");
        
        return AccreditationMapper.accreditationsCorbaToListAccredidation(AccreditationDAO.getAccreditations());
    }

    @Override
    public void transfererCandidature(candidature c, String action) {
        System.out.println("Appel Méthode MinistereImpl.transfererCandidature");
        
        Rectorat r = null;
        boolean trouve = false;
        
        // Récupération du rectorat concerné par la candidature
        for(int i = 0; i < rectorats.size() && trouve == false; i++) {
            r = GetObjectCorba.getRectoratCorba(ServerMinistere.orb, rectorats.get(i));
            
            if(r != null) {
                for(String universite : r.getListeUniversite()) {
                    if(universite.equals(c.universite)) {
                        trouve = true;
                    }
                }
            }
        }
        
        if(r != null) {
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
    }

    @Override
    public void transfererDecision(candidature c) throws CandidatureInconnu {
        System.out.println("Appel Méthode MinistereImpl.transfererDecision");
        
        try{
            Rectorat r;
            for (String ior : rectorats) {
                r = GetObjectCorba.getRectoratCorba(ServerMinistere.orb, ior);
                
                if (r.nom().equals(liaisons.get(c.universite))) {
                    r.modifierCandidature(c);
                }
            }
        } catch (CandidatureInconnu ex) {
            Logger.getLogger(MinistereImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public String[] getListeRectorat() {
        System.out.println("Appel méthode MinistereImpl.getListeRectorat");
        
        String[] r = new String[rectorats.size()];
        for(int i = 0; i < rectorats.size(); i++){
            r[i] = rectorats.get(i);
        }
        return  r;
    }

    @Override
    public void enregistrerRectorat(String ior) {
        System.out.println("Appel méthode MinistereImpl.enregistrerRectorat");
        System.out.println("Méthode MinistereImpl.enregistrerRectorat : ior => " + ior);
        
        if(!rectorats.contains(ior)) {
            rectorats.add(ior);
        }
    }

    @Override
    public periode periodeEnCours() {
        return periodeEnCours;
    }

    @Override
    public void periodeEnCours(periode value) {
        periodeEnCours = value;
        
        // Persistance
        PeriodeDAO.setPeriode(periodeEnCours);
    }
    
}
