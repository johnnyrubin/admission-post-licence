package Pojo;

import java.util.List;

/**
 * Objet utilisé pour stocker les données d'un étudiant présent en base
 * 
 * 
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
    
    /** Université à laquelle il appartient */
    private String universite;
    
    /** Licence dont il est originaire */
    private String licence;
    
    /** Les résultats scolaires de l'étudiant aux différents semestres */
    private List<ResultatSemestre> resultats;

    public Etudiant() {

    }
    
    /**
     * Constructeur sans le mot de passe
     * @param ine
     * @param nom
     * @param prenom
     * @param universite
     * @param licence 
     */
    public Etudiant(String ine, String nom, String prenom, String universite,String licence) {
        this.ine = ine;
        this.nom = nom;
        this.prenom = prenom;
        this.universite = universite;
        this.licence = licence;
    }
    
    /**
     * Surcharge du constructeur avec le mot de passe
     * @param ine
     * @param nom
     * @param prenom
     * @param universite
     * @param licence
     * @param pwd 
     */
    public Etudiant(String ine, String nom, String prenom, String universite,String licence,String pwd) {
        this.ine = ine;
        this.nom = nom;
        this.prenom = prenom;
        this.universite = universite;
        this.licence = licence;
        this.mdp = pwd;
    }
    
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

    /**
     * Récupère l'université actuelle de l'étudiant
     * @return String
     */
    public String getUniversite() {
        return universite;
    }

    /**
     * Définit l'université de l'étudiant
     * @param universite 
     */
    public void setUniversite(String universite) {
        this.universite = universite;
    }

    /**
     * Récupère la licence de l'étudiant
     * @return String
     */
    public String getLicence() {
        return licence;
    }

    /**
     * Définit la licence de l'étudiant
     * @param licence 
     */
    public void setLicence(String licence) {
        this.licence = licence;
    }

    @Override
    public String toString() {
        return "Etudiant{" + "ine=" + ine + ", nom=" + nom + ", prenom=" + prenom + ", mdp=" + mdp + ", universite=" + universite + ", licence=" + licence + ", resultats=" + resultats + '}';
    }
    
    
    
}
