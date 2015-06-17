package Pojo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 
 */
public class Accreditation {
    private String universite;
    private List<String> diplome;

    public Accreditation(String universite, List<String> diplome) {
        this.universite = universite;
        this.diplome = diplome;
    }
    
    public Accreditation(String universite){
        this.universite = universite;
        this.diplome = new ArrayList<>();
    }
    
    public String getUniversite() {
        return universite;
    }

    public void setUniversite(String universite) {
        this.universite = universite;
    }

    public List<String> getDiplome() {
        return diplome;
    }

    public void setDiplome(List<String> diplome) {
        this.diplome = diplome;
    }
    
    public void addDiplome(String diplome){
        this.diplome.add(diplome);
    }

    @Override
    public String toString() {
        return "Accreditation{" + "universite=" + universite + ", diplome=" + diplome + '}';
    }
    
    
}
