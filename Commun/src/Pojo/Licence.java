package Pojo;

/**
 * Objet utilisé pour stocker les données d'une licence présente en base
 * 
 * 
 */
public class Licence {
    
    /** Identifiant de la licence */
    private Integer id;
    
    /** Nom de la licence */
    private String nom;
    
    /**
     * Retourne l'identifiant de la licence
     * 
     * @return l'id
     */
    public Integer getId() {
        return id;
    }
    
    /**
     * Définit l'identifiant de la licence
     * 
     * @param aId 
     */
    public void setId(Integer aId) {
        id = aId;
    }
    
    /**
     * Retourne le nom de la licence
     * 
     * @return le nom
     */
    public String getNom() {
        return nom;
    }
    
    /**
     * Définit le nom de la licence
     * 
     * @param aNom 
     */
    public void setNom(String aNom) {
        nom = aNom;
    }
    
}
