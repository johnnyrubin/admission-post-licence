/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ministere.pojo;

/**
 *
 * @author johnny
 */
public class Accreditation {
    private String universite;
    private String diplome;

    public Accreditation(String universite, String diplome) {
        this.universite = universite;
        this.diplome = diplome;
    }
    
    public String getUniversite() {
        return universite;
    }

    public void setUniversite(String universite) {
        this.universite = universite;
    }

    public String getDiplome() {
        return diplome;
    }

    public void setDiplome(String diplome) {
        this.diplome = diplome;
    }
    
    
}
