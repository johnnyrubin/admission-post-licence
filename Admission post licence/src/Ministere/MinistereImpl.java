package Ministere;

import AdmissionPostLicence.CandidatureInconnu;
import AdmissionPostLicence.MinisterePOA;
import AdmissionPostLicence.Rectorat;
import AdmissionPostLicence.accreditation;
import AdmissionPostLicence.candidature;
import AdmissionPostLicence.resultatCandidature;
import Ministere.pojo.Accreditation;
import Rectorat.RectoratImpl;
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
    //Liste des accreditations
    private ArrayList<Accreditation> mesAccreditations;
    //Liste qui permet de savoir à quel rectorat appartient une université, la clé est l'université
    //et la valeur le rectorat
    private HashMap<String,String> lesLiaisons;
    //Liste des rectorats
    private ArrayList<Rectorat> lesRectorats = new ArrayList<Rectorat>();

    public void setLesLiaisons(HashMap<String, String> lesLiaisons) {
        this.lesLiaisons = lesLiaisons;
    }

    public void setMesAccreditations(ArrayList<Accreditation> mesAccredidations) {
        this.mesAccreditations = mesAccredidations;
    }
    
    @Override
    public accreditation[] recupererAccreditations() {
        return AccreditationMapper.accreditationsCorbaToListAccredidation(mesAccreditations);
    }

    @Override
    public void transfererCandidature(candidature c) {
        //L'orientation de transfert se fait à partir des variables universite et master qui se trouvent
        //dans la candidature
        //on récupère donc le rectorat
        Rectorat r = GetObjectCorba.getRectoratCorba(lesLiaisons.get(c.universite),ServerMinistere.orb);
        r.creerCandidature(c);
    }

    @Override
    public void transfererDecision(candidature c) throws CandidatureInconnu {
        try{
            for (Rectorat lesRectorat : lesRectorats) {
                if (lesRectorat.nom().equals(lesLiaisons.get(c.universite))) {
                    lesRectorat.modifierCandidature(c);
                }
            }
        
        } catch (CandidatureInconnu ex) {
            Logger.getLogger(MinistereImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public Rectorat[] getListeRectorat() {
        
        System.out.println("Appel méthode MinistereImpl.getListeRectorat : Début");
        //lesRectorats.add((Rectorat) new RectoratImpl("MDP"));
        
        Rectorat[] r = new Rectorat[0];
//        int i = 0;lesRectorats.size()
//        for(Rectorat t : lesRectorats) {
//            System.out.println("Rectorat : " + t.nom());
//            r[i] = t;
//            i++;
//        }
        
        System.out.println("Appel méthode MinistereImpl.getListeRectorat : Fin");
        return r;
    }

    @Override
    public void enregistrerRectorat(Rectorat r) {
        lesRectorats.add(r);
    }
    
    /**
     * Permet de récupérer l'objet CORBA du rectorat
     * 
     * @return {@link Rectorat}
     */
    /*private Rectorat getRectoratCorba(String nomRectorat) {
        // Initialisation de la variable de retour
        Rectorat r = null;
        try {
            
            NamingContext root = org.omg.CosNaming.NamingContextHelper.narrow(ServerMinistere.orb.resolve_initial_references("NameService"));
            org.omg.CosNaming.NameComponent[] nameToFind = new org.omg.CosNaming.NameComponent[1];
            
            // On récupère le rectorat
            nameToFind[0] = new org.omg.CosNaming.NameComponent(nomRectorat, "");
            org.omg.CORBA.Object remoteRef = root.resolve(nameToFind);
            r = RectoratHelper.narrow(remoteRef);
            
        } catch (org.omg.CORBA.ORBPackage.InvalidName ex) {
            Logger.getLogger(MinistereImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotFound ex) {
            Logger.getLogger(MinistereImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CannotProceed ex) {
            Logger.getLogger(MinistereImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidName ex) {
            Logger.getLogger(MinistereImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }*/
    
}
