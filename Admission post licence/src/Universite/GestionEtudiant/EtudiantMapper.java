package Universite.GestionEtudiant;

import AdmissionPostLicence.identite;
import AdmissionPostLicence.resultat;
import AdmissionPostLicence.resultatsEtudiant;
import Universite.pojo.Etudiant;
import Universite.pojo.ResultatSemestre;
import java.util.ArrayList;
import java.util.List;

/**
 * Mapper permettant de transformer un classe POJO en classe CORBA
 * 
 * @author Teddy
 */
public class EtudiantMapper {
    
    /**
     * Convertit les infos d'un étudiant contenu dans la bd vers son type identite utilisé par corba
     * 
     * @param etudiant
     * @return {@link identite}
     */
    public static identite etudiantToIdentiteCorba(Etudiant etudiant) {
        identite identite = null;
        if(etudiant != null) {
            identite = new identite(etudiant.getIne(), etudiant.getNom(), etudiant.getPrenom(), "", "");
        }
        return identite;
    }
    
    /**
     * Convertit les infos de type identite Corba vers l'objet Etudiant
     * 
     * @param identite
     * @return {@link Etudiant}
     */
    public static Etudiant identiteToEtudiantCorba(identite identite) {
        Etudiant etudiant = null;
        if(identite != null) {
            etudiant = new Etudiant(identite.ine, identite.nom, identite.prenom, identite.universite, identite.licence);
        }
        return etudiant;
    }
    
    /**
     * Convertit les infos d'un étudiant contenu dans la bd vers le type resultatsEtudiant utilisé par corba
     * 
     * @param etudiant
     * @return {@link resultatsEtudiant}
     */
    public static resultatsEtudiant etudiantToResultatsEtudiantCorba(Etudiant etudiant) {
        
        resultat[] resultatsSemestres = null;
        List<resultat> resTemp = new ArrayList<>();
        
        if(etudiant.getResultats() != null) {
            for(ResultatSemestre rSem : etudiant.getResultats()) {
                resultat res = new resultat(rSem.getCode(), rSem.getMoyenne().floatValue(), rSem.getPosition().shortValue());
                resTemp.add(res);
            }
        }
        
        identite identite = EtudiantMapper.etudiantToIdentiteCorba(etudiant);
        
        resultatsEtudiant resultatsEtudiant = new resultatsEtudiant(identite, resTemp.toArray(resultatsSemestres));
        
        return resultatsEtudiant;
    }
    
}
