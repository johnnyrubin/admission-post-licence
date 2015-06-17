package Pojo;

/**
 *
 * 
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
    //Etat de la candidature {nonValide, valide, cloture}, soit 0, 1 ou 2
    private int etatCandidature;
    //Décision du candidat { ouiDefinitif, ouiMais, nonMais, nonDefinitif } , soit 0, 1, 2 ou 3
    private int decisionCandidat;
    //Décision du master { admis, listeAttente, refuser } , soit 0, 1 ou 2
    private int decisionMaster;

    public Candidature(Etudiant etu, String master, String Universite, int ordre,
            int etatCandidature, int decisionCandidat, int decisionMaster) {
        this.etu = etu;
        this.master = master;
        this.Universite = Universite;
        this.ordre = ordre;
        this.etatCandidature = etatCandidature;
        this.decisionCandidat = decisionCandidat;
        this.decisionMaster = decisionMaster;
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

    @Override
    public String toString() {
        return "Candidature{" + "etu=" + etu + ", master=" + master + ", Universite=" + Universite + ", ordre=" + ordre + ", etatCandidature=" + etatCandidature + ", decisionCandidat=" + decisionCandidat + ", decisionMaster=" + decisionMaster + '}';
    }

    
    
}
