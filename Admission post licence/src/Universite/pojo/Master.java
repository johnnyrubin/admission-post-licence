package Universite.pojo;

import java.util.List;

/**
 * Objet utilisé pour stocker les données d'un master présent en base
 * 
 * @author Teddy
 */
public class Master {
    
    /** Identifiant du master */
    private Integer id;
    
    /** Nom du master */
    private String nom;
    
    /** Liste des licences requises pour candidater au master */
    private List<Licence> prerequis;
    
    /**
     * Retourne l'identifiant du master
     * 
     * @return l'id
     */
    public Integer getId() {
        return id;
    }
    
    /**
     * Définit l'identifiant du master
     * 
     * @param aId 
     */
    public void setId(Integer aId) {
        id = aId;
    }
    
    /**
     * Retourne le nom du master
     * 
     * @return le nom
     */
    public String getNom() {
        return nom;
    }
    
    /**
     * Définit le nom du master
     * 
     * @param aNom 
     */
    public void setNom(String aNom) {
        nom = aNom;
    }
    
    /**
     * Retourne les licences requises pour candidater au master
     * 
     * @return {@link List}<{@link Licence}>
     */
    public List<Licence> getPrerequis() {
        return prerequis;
    }
    
    /**
     * Définit la liste des licences requises pour candidater au master
     * 
     * @param aPrerequis 
     */
    public void setPrerequis(List<Licence> aPrerequis) {
        prerequis = aPrerequis;
    }
    
}
