package Universite.GestionEtudiant;

import AdmissionPostLicence.identite;
import AdmissionPostLicence.resultat;
import AdmissionPostLicence.resultatsEtudiant;
import Universite.database.Etudiant;
import Universite.database.ResultatSemestre;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Teddy
 */
public class EtudiantMapper {
    
    /**
     * Convertit les infos d'un étudiant contenu dans la bd vers son type identite utilisé par corba
     * 
     * @param etudiant
     * @return identite
     */
    public static identite etudiantToIdentiteCorba(Etudiant etudiant) {
        identite identite = null;
        if(etudiant != null) {
            identite = new identite(etudiant.getIne(), etudiant.getNom(), etudiant.getPrenom(), null, null);
        }
        return identite;
    }
    
    /**
     * Convertit les infos d'un étudiant contenu dans la bd vers le type resultatsEtudiant utilisé par corba
     * @param etudiant
     * @return 
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
