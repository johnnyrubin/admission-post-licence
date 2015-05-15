package Universite.database;

/**
 * Objet utilisé pour stocker les résultats scolaires d'un étudiant présent en base
 * 
 * @author Teddy
 */
public class ResultatSemestre {
    
    /** Code du semestre */
    private String code;
    
    /** Moyenne de l'étudiant à ce semestre */
    private Double moyenne;
    
    /** Classement de l'étudiant dans la promo pour ce semestre */
    private Integer position;
    
    /**
     * Retourne le code du semstre
     * 
     * @return le code
     */
    public String getCode() {
        return code;
    }
    
    /**
     * Retourne la moyenne du semestre
     * 
     * @return la moyenne
     */
    public Double getMoyenne() {
        return moyenne;
    }
    
    /**
     * la position de l'étudiant à ce semestre
     * 
     * @return la position
     */
    public Integer getPosition() {
        return position;
    }
    
    /**
     * Définit le code du semestre
     * 
     * @param aCode 
     */
    public void setCode(String aCode) {
        code = aCode;
    }
    
    /**
     * Définit la moyenne au semestre
     * 
     * @param aMoyenne 
     */
    public void setMoyenne(Double aMoyenne) {
        moyenne = aMoyenne;
    }
    
    /**
     * Définit la postion dans la promo à ce semestre
     * 
     * @param aPosition 
     */
    public void setPosition(Integer aPosition) {
        position = aPosition;
    }
    
}
