/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rectorat.pojo;

import Universite.pojo.Etudiant;
import Universite.pojo.Master;

/**
 *
 * @author johnny
 */
public class Candidature {
    //étudiant pour la candidature
    private Etudiant etu;
    //master visé par la candidature
    private String master;
    //université visée par la candidature
    private String Universite;
    //ordre de la candidature pour l'étudiant
    private int ordre;

    public Candidature(Etudiant etu, String master, String Universite, int ordre) {
        this.etu = etu;
        this.master = master;
        this.Universite = Universite;
        this.ordre = ordre;
    }
    
    
    /**
     * Récupère l'étudiant de la candidature
     * @return String
     */
    public Etudiant getEtu() {
        return etu;
    }

    /**
     * Définit l'étudiant de la candidature
     * @param etu 
     */
    public void setINE(Etudiant etu) {
        this.etu = etu;
    }

    /**
     * Récupère le master visé par la candidature
     * 
     * @return String 
     */
    public String getMaster() {
        return master;
    }

    /**
     * Définit le master visé par la candidature
     * @param master 
     */
    public void setIdMaster(String master) {
        this.master = master;
    }

    /**
     * Récupère l'université visée par la candidature
     * @return  String
     */
    public String getUniversite() {
        return Universite;
    }

    /**
     * Définit l'université pour la candidature
     * @param Universite 
     */
    public void setUniversite(String Universite) {
        this.Universite = Universite;
    }

    /**
     * Récupère l'ordre de la candidature pour l'étudiant
     * @return int
     */
    public int getOrdre() {
        return ordre;
    }

    /**
     * Définit l'ordre de la candidature
     * @param ordre 
     */
    public void setOrdre(int ordre) {
        this.ordre = ordre;
    }
    
    

}
