/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rectorat;

import AdmissionPostLicence.accreditation;
import AdmissionPostLicence.candidature;
import AdmissionPostLicence.decisionCandidat;
import AdmissionPostLicence.decisionMaster;
import AdmissionPostLicence.etatCandidature;
//import AdmissionPostLicence.resultatCandidature;
import Rectorat.pojo.Candidature;
//import Rectorat.pojo.ResultatCandidature;
import Universite.GestionEtudiant.EtudiantMapper;
import java.util.ArrayList;
import java.util.List;

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
            ca = new candidature(EtudiantMapper.etudiantToIdentiteCorba(c.getEtu()), c.getMaster(), c.getUniversite(), 
                    (short)c.getOrdre(),etatCandidature.from_int(c.getEtatCandidature()), 
                    decisionCandidat.from_int(c.getDecisionCandidat()),decisionMaster.from_int(c.getDecisionMaster()));
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
            ca = new Candidature(EtudiantMapper.identiteToEtudiantCorba(c.etudiant), c.master, c.universite, (int)c.ordre,
                                c.etat.value(), c.decisionC.value(),c.decisionM.value());
        }
        return ca;
    }
    
    /**
     * Convertit les infos du type candidature[] de corba vers une liste de candidature
     * 
     * @param c
     * @return {@link List<Candidature>}
     */
    public static List<Candidature> candidaturesCorbaToListCandidature(candidature[] c) {
        List<Candidature> cs = new ArrayList<>();
        if(c.length!=0){
            for (candidature a1 : c) {
                cs.add(candidatureCorbaToCandidature(a1));
            }
        }
        return cs;
    }
    
    /**
     * Convertit les infos de la liste des candidatures vers candidature[] de corba
     * 
     * @param c
     * @return {@link <candidature>[]}
     */
    public static candidature[] candidaturesCorbaToListCandidature(List<Candidature> c) {
        candidature[] cs = new candidature[c.size()];
        if(!c.isEmpty()){
            for (int i=0;i<c.size();i++) {
                cs[i]=candidatureToCandidatureCorba(c.get(i));
            }
        }
        return cs;
    }
    
}
