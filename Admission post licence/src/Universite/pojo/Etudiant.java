package Universite.pojo;

import java.util.List;

/**
 * Objet utilisé pour stocker les données d'un étudiant présent en base
 * 
 * @author Teddy
 */
public class Etudiant {
    
    /** Numéro INE de l'étudiant */
    private String ine;
    
    /** Nom de l'étudiant */
    private String nom;
    
    /** Prénom de l'étudiant */
    private String prenom;
    
    /** Mot de passe de l'étudiant */
    private String mdp;
    
    /** Les résultats scolaires de l'étudiant aux différents semestres */
    private List<ResultatSemestre> resultats;
    
    /**
     * Retourne le numéro INE de l'étudiant
     * 
     * @return ine
     */
    public String getIne() {
        return ine;
    }
    
    /**
     * Retourne le nom de l'étudiant
     * 
     * @return le nom
     */
    public String getNom() {
        return nom;
    }
    
    /**
     * Retourne le prénom de l'étudiant
     * 
     * @return le prenom
     */
    public String getPrenom() {
        return prenom;
    }
    
    /**
     * Définit le numéro INE de l'étudiant
     * 
     * @param aIne 
     */
    public void setIne(String aIne) {
        ine = aIne;
    }
    
    /**
     * Définit le nom de l'étudiant
     * 
     * @param aNom 
     */
    public void setNom(String aNom) {
        nom = aNom;
    }
    
    /**
     * Définit le prénom de l'étudiant
     * 
     * @param aPrenom 
     */
    public void setPrenom(String aPrenom) {
        prenom = aPrenom;
    }
    
    /**
     * Retorune les résultats scolaires de l'étudiant
     * 
     * @return les resultats
     */
    public List<ResultatSemestre> getResultats() {
        return resultats;
    }
    
    /**
     * Définit les résultats scolaires de l'étudiant
     * 
     * @param aResultats 
     */
    public void setResultats(List<ResultatSemestre> aResultats) {
        resultats = aResultats;
    }
    
    /**
     * Retourne le mot de passe de l'étudiant
     * 
     * @return le mdp
     */
    public String getMdp() {
        return mdp;
    }
    
    /**
     * Définit le mot de passe de l'étudiant
     * 
     * @param aMdp 
     */
    public void setMdp(String aMdp) {
        mdp = aMdp;
    }
    
}
