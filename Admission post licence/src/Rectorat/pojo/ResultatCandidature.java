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
public class ResultatCandidature {
    //La Candidature visé par les résultats
    private Candidature candidature;
    //Etat de la candidature {nonValide, valide, cloture}, soit 0, 1 ou 2
    private int etatCandidature;
    //Décision du candidat { ouiDefinitif, ouiMais, nonMais, nonDefinitif } , soit 0, 1, 2 ou 3
    private int decisionCandidat;
    //Décision du master { admis, listeAttente, refuser } , soit 0, 1 ou 2
    private int decisionMaster;

    /**
     * Récupère la candidature
     * @return Candidature
     */
    public Candidature getCandidature() {
        return candidature;
    }

    /**
     * Définit la candidature
     * @param candidature 
     */
    public void setCandidature(Candidature candidature) {
        this.candidature = candidature;
    }

    /**
     * Récupère l'état de la candidature
     * @return int
     */
    public int getEtatCandidature() {
        return etatCandidature;
    }

    /**
     * Définit l'état de la candidature
     * @param etatCandidature 
     */
    public void setEtatCandidature(int etatCandidature) {
        this.etatCandidature = etatCandidature;
    }

    /**
     * Récupère la décision du candidat pour la candidature
     * @return int
     */
    public int getDecisionCandidat() {
        return decisionCandidat;
    }

    /**
     * Définit la décision du candidat pour la candidature
     * @param decisionCandidat 
     */
    public void setDecisionCandidat(int decisionCandidat) {
        this.decisionCandidat = decisionCandidat;
    }

    /**
     * Récupère la décision des décideurs du master
     * @return int
     */
    public int getDecisionMaster() {
        return decisionMaster;
    }

    /**
     * Définit la décision des décideurs du master
     * @param decisionMaster 
     */
    public void setDecisionMaster(int decisionMaster) {
        this.decisionMaster = decisionMaster;
    }
    
    
    
    
}
