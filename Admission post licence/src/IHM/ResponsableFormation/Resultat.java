package IHM.ResponsableFormation;

/**
 *
 * @author Teddy
 */
public class Resultat {
    
    private String semestre;
    
    private String moyenne;
    
    private String classement;
    
    /**
     * 
     * @return 
     */
    public String getSemestre() {
        return semestre;
    }

    /**
     * 
     * @param unSemestre 
     */
    public void setSemestre(String unSemestre) {
        this.semestre = unSemestre;
    }

    /**
     * 
     * @return 
     */
    public String getMoyenne() {
        return moyenne;
    }

    /**
     * 
     * @param uneMoyenne 
     */
    public void setMoyenne(String uneMoyenne) {
        this.moyenne = uneMoyenne;
    }

    /**
     * 
     * @return 
     */
    public String getClassement() {
        return classement;
    }

    /**
     * 
     * @param unClassement 
     */
    public void setClassement(String unClassement) {
        this.classement = unClassement;
    }
}
