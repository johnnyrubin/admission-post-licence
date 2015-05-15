/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rectorat.pojo;

/**
 *
 * @author johnny
 */
public class Candidature {
    //INE de l'étudiant pour la candidature
    private String INE;
    //Id du master visé par la candidature
    private String IdMaster;
    //université visée par la candidature
    private String Universite;
    //ordre de la candidature pour l'étudiant
    private int ordre;

    public String getINE() {
        return INE;
    }

    public void setINE(String INE) {
        this.INE = INE;
    }

    public String getIdMaster() {
        return IdMaster;
    }

    public void setIdMaster(String IdMaster) {
        this.IdMaster = IdMaster;
    }

    public String getUniversite() {
        return Universite;
    }

    public void setUniversite(String Universite) {
        this.Universite = Universite;
    }

    public int getOrdre() {
        return ordre;
    }

    public void setOrdre(int ordre) {
        this.ordre = ordre;
    }
    
    

}
