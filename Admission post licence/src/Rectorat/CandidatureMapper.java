/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rectorat;

import AdmissionPostLicence.candidature;
import AdmissionPostLicence.decisionCandidat;
import AdmissionPostLicence.decisionMaster;
import AdmissionPostLicence.etatCandidature;
import AdmissionPostLicence.resultatCandidature;
import Rectorat.pojo.Candidature;
import Rectorat.pojo.ResultatCandidature;
import Universite.GestionEtudiant.EtudiantMapper;

/**
 * Mapper permettant de transformer un classe POJO en classe CORBA
 * 
 * @author johnny
 */
public class CandidatureMapper {
    /**
     * Convertit les infos d'un objet Candidature vers son type candidature utilisé par corba
     * 
     * @param c
     * @return {@link candidature}
     */
    public static candidature candidatureToCandidatureCorba(Candidature c) {
        candidature ca = null;
        if(c != null) {
            ca = new candidature(EtudiantMapper.etudiantToIdentiteCorba(c.getEtu()), c.getMaster().getNom(), c.getUniversite(), (short)c.getOrdre());
        }
        return ca;
    }
    
    /**
     * Convertit les infos d'une candidature Corba vers l'objet Candidature 
     * 
     * @param c
     * @return {@link Candidature}
     */
    public static Candidature candidatureCorbaToCandidature(candidature c) {
        Candidature ca = null;
        if(c != null) {
            //TODO ICI LE MASTER N'EST PAS BIEN REMPLI IL FAUDRAIT CREER UN OBJET MASTER MAIS IL FAUT AU PREALABLE
            //ALLER VOIR SI CE DERNIER N'EXISTE PAS DEJA POUR RÉCUPERER SON ID
            ca = new Candidature(EtudiantMapper.identiteToEtudiantCorba(c.etudiant), c.master, c.universite, (int)c.ordre);
        }
        return ca;
    }
    
    /**
     * Convertit les infos de l'objet ResultatCandidature vers son type resultatcandidature utilisé par corba
     * 
     * @param rc
     * @return {@link resultatCandidature}
     */
    public static resultatCandidature candidatureToCandidatureCorba(ResultatCandidature rc) {
        resultatCandidature rca = null;
        if(rc != null) {
            rca = new resultatCandidature(CandidatureMapper.candidatureToCandidatureCorba(rc.getCandidature()),
                    etatCandidature.from_int(rc.getEtatCandidature()), decisionCandidat.from_int(rc.getDecisionCandidat()),
                    decisionMaster.from_int(rc.getDecisionMaster()));
        }       
        return rca;
    }
    
}
