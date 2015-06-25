package rectorat;

import Mapper.CandidatureMapper;
import AdmissionPostLicence.CandidatureInconnu;
import AdmissionPostLicence.EtudiantInconnu;
import AdmissionPostLicence.GestionEtudiant;
import AdmissionPostLicence.Master;
import AdmissionPostLicence.MasterInconnu;
import AdmissionPostLicence.Ministere;
import AdmissionPostLicence.RectoratPOA;
import AdmissionPostLicence.candidature;
import AdmissionPostLicence.etatCandidature;
import AdmissionPostLicence.identite;
import rectorat.database.CandidatureDAO;
import Pojo.Candidature;
import Util.GetObjectCorba;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * 
 */
public class RectoratImpl extends RectoratPOA {
    
    /** Liste des gestions étudiants enregistrés sur le rectorat */
    private final List<String> gestionsEtudiant = new ArrayList<>();
    
    /** Liste des masters enregistrés sur le rectorat */
    private final List<String> masters = new ArrayList<>();
    
    /** Liste des universités enregistrés sur le rectorat */
    private final List<String> universites = new ArrayList<>();
    
    /** Nom du Rectorat */
    private final String nom;
    
    /** Ministère */
    private final Ministere ministere;
    
    /**
     * 
     * @param aNom 
     */
    public RectoratImpl(String aNom) {
        this.nom = aNom;
        
        // Récupération du ministère
        ministere = GetObjectCorba.getMinistereCorba(ServerRectorat.getOrb());
        
        enregistrerSurMinistere();
    }
    
    @Override
    public void creerCandidature(candidature c) {
        System.out.println("Appel méthode RectoratImpl.creerCandidature");
        
        Candidature candidature = CandidatureMapper.candidatureCorbaToCandidature(c);
        System.out.println("Méthode RectoratImpl.creerCandidature : candidature => " + candidature);
        
        boolean trouve = false;
        
        //Je regarde si l'université cible fait partit de ma liste d'université
        for(String universite : universites) {
            if(universite.equals(c.universite)) {
                // Récupération de la liste des masters
                Master m = null;
                
                for(int i = 0; i < masters.size() && trouve == false; i++) {
                    m = GetObjectCorba.getMasterCorba(masters.get(i), ServerRectorat.getOrb());
                    
                    if( m != null) {
                        if(m.nom().equals(c.master)) {
                            trouve = true;
                        }
                    }
                }
                try {
                    if(m != null && trouve) {
                        CandidatureDAO dao = new CandidatureDAO(ServerRectorat.getConnexionDb());
                        
                        //Vérification des pré requis
                        if(m.verifierPrerequis(candidature.getEtu().getLicence())) {
                            //Enregistrer candidature
                            candidature.setEtatCandidature(etatCandidature.valide.value());
                            dao.ajoutCandidature(candidature);
                        } else {
                            // 0 correspond à une candidature non valide
                            candidature.setEtatCandidature(etatCandidature.nonValide.value());
                            dao.ajoutCandidature(candidature);
                        }
                    }
                } catch (MasterInconnu ex) {
                    Logger.getLogger(RectoratImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        // Tranfert vers un autre ministère
        if(!trouve && ministere != null) {
            ministere.transfererCandidature(c,"creerCandidature");
        }
    }

    @Override
    public candidature[] recupererCandidaturesMaster(String universite, String master) throws MasterInconnu {
        System.out.println("Appel méthode RectoratImpl.recupererCandidaturesMaster");
        CandidatureDAO dao = new CandidatureDAO(ServerRectorat.getConnexionDb());
        return CandidatureMapper.candidaturesCorbaToListCandidature(dao.getCandidaturesMaster(universite, master));
    }

    @Override
    public candidature[] recupererCandidaturesEtudiant(identite etudiant) throws EtudiantInconnu {
        System.out.println("Appel méthode RectoratImpl.recupererCandidaturesEtudiant");
        CandidatureDAO dao = new CandidatureDAO(ServerRectorat.getConnexionDb());
        return CandidatureMapper.candidaturesCorbaToListCandidature(dao.getCandidaturesEtudiant(etudiant.ine));
    }

    @Override
    public void modifierCandidature(candidature c) throws CandidatureInconnu {
        System.out.println("Appel méthode RectoratImpl.modifierCandidature");
        
        Candidature candidature= CandidatureMapper.candidatureCorbaToCandidature(c);
        
        boolean trouve = false;
        
        //Je regarde si l'université cible fait partit de ma liste d'université
        for(String universite : universites) {
            if(universite.equals(c.universite)) {
                // Récupération de la liste des masters
                Master m = null;
                
                for(int i = 0; i < masters.size() && trouve == false; i++) {
                    m = GetObjectCorba.getMasterCorba(masters.get(i), ServerRectorat.getOrb());
                    
                    if( m != null) {
                        if(m.nom().equals(c.master)) {
                            trouve = true;
                        }
                    }
                }
                if(m != null) {
                    CandidatureDAO dao = new CandidatureDAO(ServerRectorat.getConnexionDb());
                    dao.modifierCandidature(candidature);
                }
            }
        }
        
        if(!trouve && ministere != null) {
            ministere.transfererCandidature(c,"modifierCandidature");
        }
    }

    @Override
    public String nom() {
        return this.nom;
    }
    
    @Override
    public String[] getListeGestEtu() {
        System.out.println("Appel méthode RectoratImpl.getListeGestEtu");
        
        String[] ge = new String[gestionsEtudiant.size()];
        
        for(int i = 0; i < gestionsEtudiant.size(); i++) {
            ge[i] = gestionsEtudiant.get(i);
        }
        
        return  ge;
    }

    @Override
    public void enregistrerGE(String ior, String universite) {
        System.out.println("Appel méthode RectoratImpl.enregistrerGE");
        System.out.println("Méthode RectoratImpl.enregistrerGE : ior => " + ior);
        
        if(!gestionsEtudiant.contains(ior)) {
            gestionsEtudiant.add(ior);
        }
        
        if(!universites.contains(universite)) {
            universites.add(universite);
        }
    }

    @Override
    public void enregistrerMaster(String ior) {
        System.out.println("Appel méthode RectoratImpl.enregistrerMaster");
        System.out.println("Méthode RectoratImpl.enregistrerMaster : ior => " + ior);
        
        if(!masters.contains(ior)) {
            masters.add(ior);
        }
    }

    @Override
    public String[] getListeMaster(String u) {
        System.out.println("Appel méthode RectoratImpl.getListeMaster");
        
        // Récupération de la liste des masters de l'université
        List<String> mastersUniversite = new ArrayList<>();
        
        for (String ior : masters) {
            Master master = GetObjectCorba.getMasterCorba(ior, ServerRectorat.getOrb());
            
            if(master.universite().equals(u)) {
                mastersUniversite.add(ior);
            }
        }
        
        // On convertit l'arraylist en tableau pour corba
        String[] m = new String[mastersUniversite.size()];
        int i = 0;
        
        for (String ior : mastersUniversite) {
            m[i] = ior;
            i++;
        }
        
        return m;
    }

    @Override
    public String[] getListeUniversite() {
        System.out.println("Appel méthode RectoratImpl.getListeUniversite");
        
        String[] u = new String[universites.size()];
        
        for(int i = 0; i < universites.size(); i++) {
            u[i] = universites.get(i);
        }
        
        return  u;
    }
    
    /**
     * Permet d'enregistrer le rectorat auprès du ministère
     */
    private void enregistrerSurMinistere() {
        System.out.println("Appel Méthode RectoratImpl.enregistrerSurMinistere");
        
        if(ministere != null) {
            ministere.enregistrerRectorat(ServerRectorat.getIorFromObject(this));
        }
    }

    @Override
    public String getGestEtu(String universite) {
        System.out.println("Appel méthode RectoratImpl.getGestEtu");
        
        String gestEtu = null;
        
        for (String ior : gestionsEtudiant) {
            GestionEtudiant g = GetObjectCorba.getGestionEtudiantCorba(ServerRectorat.getOrb(), ior);
            
            if(g.nom().equals(universite)) {
                gestEtu = ior;
            }
        }
        
        return gestEtu;
    }

    @Override
    public void supprimerCandidature(candidature c) throws CandidatureInconnu {
        System.out.println("Appel méthode RectoratImpl.supprimerCandidature");
        
        Candidature candidature= CandidatureMapper.candidatureCorbaToCandidature(c);

        boolean trouve = false;
        
        //Je regarde si l'université cible fait partit de ma liste d'université
        for(String universite : universites) {
            if(universite.equals(c.universite)) {
                // Récupération de la liste des masters
                Master m = null;
                
                for(int i = 0; i < masters.size() && trouve == false; i++) {
                    m = GetObjectCorba.getMasterCorba(masters.get(i), ServerRectorat.getOrb());
                    
                    if( m != null) {
                        if(m.nom().equals(c.master)){
                            trouve = true;
                        }
                    }
                }
                
                if(m != null) {
                    CandidatureDAO dao = new CandidatureDAO(ServerRectorat.getConnexionDb());
                    dao.supprimerCandidature(candidature);
                }
            }
        }
        
        if(!trouve && ministere != null) {
            ministere.transfererCandidature(c,"supprimerCandidature");
        }
    }
    
}
