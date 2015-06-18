/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etudiant;

import AdmissionPostLicence.CandidatureInconnu;
import AdmissionPostLicence.EtudiantInconnu;
import AdmissionPostLicence.GestionEtudiant;
import AdmissionPostLicence.Ministere;
import AdmissionPostLicence.Rectorat;
import AdmissionPostLicence.decisionCandidat;
import AdmissionPostLicence.decisionMaster;
import AdmissionPostLicence.identite;
import Mapper.CandidatureMapper;
import Pojo.Candidature;
import Util.GetObjectCorba;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;

/**
 *
 * @author johnny
 */
public class ChoixVoeux extends javax.swing.JFrame {

    private final GestionEtudiant g;
    private final org.omg.CORBA.ORB orb;
    private final Ministere m;
    private final Rectorat r;
    private final identite moi;
    private final List<Candidature> mesCandidatures = new ArrayList<>();
    private JLabel[] lesLabelsChoix;
    private JLabel[] lesLabelsDecision;
    private JComboBox[] lesComboBox;
    private int voeuxRetenu=0;
    
    /**
     * Creates new form ChoixVoeux
     * @param m
     * @param r
     * @param g
     * @param orb
     * @param id
     */
    public ChoixVoeux(Ministere m, Rectorat r,GestionEtudiant g,org.omg.CORBA.ORB orb,identite id) {
        this.g=g;
        this.orb=orb;
        this.m=m;
        this.r = r;
        this.moi = id;
        initComponents();
        jLabelPasBesoinDeReponse.setVisible(false);
        initList();
        initCandidatures();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabelVoeux1 = new javax.swing.JLabel();
        jLabelVoeux3 = new javax.swing.JLabel();
        jLabelVoeux4 = new javax.swing.JLabel();
        jLabelVoeux5 = new javax.swing.JLabel();
        jLabelVoeux2 = new javax.swing.JLabel();
        jLabelDecision1 = new javax.swing.JLabel();
        jLabelDecision2 = new javax.swing.JLabel();
        jLabelDecision3 = new javax.swing.JLabel();
        jLabelDecision4 = new javax.swing.JLabel();
        jLabelDecision5 = new javax.swing.JLabel();
        jComboBoxChoix1 = new javax.swing.JComboBox();
        jComboBoxChoix2 = new javax.swing.JComboBox();
        jComboBoxChoix3 = new javax.swing.JComboBox();
        jComboBoxChoix4 = new javax.swing.JComboBox();
        jComboBoxChoix5 = new javax.swing.JComboBox();
        jLabelPasBesoinDeReponse = new javax.swing.JLabel();
        jButtonValider = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Choix de vos voeux");

        jLabelVoeux1.setText("Voeux 1");

        jLabelVoeux3.setText("Voeux 3");

        jLabelVoeux4.setText("Voeux 4");

        jLabelVoeux5.setText("Voeux 5");

        jLabelVoeux2.setText("Voeux 2");

        jLabelDecision1.setText("Decision");

        jLabelDecision2.setText("Decision");

        jLabelDecision3.setText("Decision");

        jLabelDecision4.setText("Decision");

        jLabelDecision5.setText("Decision");

        jComboBoxChoix5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxChoix5ActionPerformed(evt);
            }
        });

        jLabelPasBesoinDeReponse.setText("Vous n'avez pas besoin de nous donner une réponse");

        jButtonValider.setText("Valider");
        jButtonValider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonValiderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelVoeux2)
                    .addComponent(jLabelVoeux1)
                    .addComponent(jLabelVoeux3)
                    .addComponent(jLabelVoeux4)
                    .addComponent(jLabelVoeux5))
                .addGap(179, 179, 179)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabelDecision4)
                    .addComponent(jLabelDecision3)
                    .addComponent(jLabelDecision2)
                    .addComponent(jLabelDecision1)
                    .addComponent(jLabelDecision5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBoxChoix5, 0, 108, Short.MAX_VALUE)
                    .addComponent(jComboBoxChoix3, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxChoix2, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxChoix1, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxChoix4, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(100, 100, 100))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelPasBesoinDeReponse)
                .addGap(142, 142, 142))
            .addGroup(layout.createSequentialGroup()
                .addGap(259, 259, 259)
                .addComponent(jButtonValider)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelVoeux1)
                    .addComponent(jLabelDecision1)
                    .addComponent(jComboBoxChoix1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelVoeux2)
                    .addComponent(jLabelDecision2)
                    .addComponent(jComboBoxChoix2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelVoeux3)
                    .addComponent(jLabelDecision3)
                    .addComponent(jComboBoxChoix3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelVoeux4)
                    .addComponent(jLabelDecision4)
                    .addComponent(jComboBoxChoix4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelVoeux5)
                    .addComponent(jLabelDecision5)
                    .addComponent(jComboBoxChoix5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jLabelPasBesoinDeReponse)
                .addGap(18, 18, 18)
                .addComponent(jButtonValider)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxChoix5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxChoix5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxChoix5ActionPerformed

    private void jButtonValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonValiderActionPerformed
        try {
            Candidature c, cTemp;
            String d = lesComboBox[voeuxRetenu-1].getSelectedItem().toString();
            switch(d){
                case "ouiDefinitif":
                    c = mesCandidatures.get(voeuxRetenu-1);
                    c.setDecisionCandidat(decisionCandidat.ouiDefinitif.value());
                    r.modifierCandidature(CandidatureMapper.candidatureToCandidatureCorba(c));
                    //Si on accepte le voeux, cela annule tous les autres
                    for(Candidature c1 : mesCandidatures){
                        if(!c1.getEtu().getIne().equals(c.getEtu().getIne()) && 
                                !c1.getMaster().equals(c.getMaster())){
                            c1.setDecisionCandidat(decisionCandidat.nonDefinitif.value());
                            r.modifierCandidature(CandidatureMapper.candidatureToCandidatureCorba(c1));
                        }
                    }
                    break;
                case "ouiMais":
                    c = mesCandidatures.get(voeuxRetenu-1);
                    c.setDecisionCandidat(decisionCandidat.ouiMais.value());
                    //On va annuler celles qui suivent
                    for(int i=voeuxRetenu+1; i<mesCandidatures.size();i++){
                        cTemp = mesCandidatures.get(i);
                        cTemp.setDecisionCandidat(decisionCandidat.nonDefinitif.value());
                        r.modifierCandidature(CandidatureMapper.candidatureToCandidatureCorba(cTemp));
                    }
                    break;
                case "nonMais":
                    c = mesCandidatures.get(voeuxRetenu-1);
                    c.setDecisionCandidat(decisionCandidat.nonMais.value());
                    //On va annuler celles qui suivent
                    for(int i=voeuxRetenu+1; i<mesCandidatures.size();i++){
                        cTemp = mesCandidatures.get(i);
                        cTemp.setDecisionCandidat(decisionCandidat.nonDefinitif.value());
                        r.modifierCandidature(CandidatureMapper.candidatureToCandidatureCorba(cTemp));
                    }
                    break;
                case "nonDefinitif":
                    //Si on refuse le voeux, cela annule tous les autres
                    for(Candidature c1 : mesCandidatures){
                        c1.setDecisionCandidat(decisionCandidat.nonDefinitif.value());
                        r.modifierCandidature(CandidatureMapper.candidatureToCandidatureCorba(c1));
                    }
                    break;
            }
        } catch (CandidatureInconnu ex) {
            Logger.getLogger(ChoixVoeux.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonValiderActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
    }
    
    private void initCandidatures(){
        // Traitrement des candidatures
        String[] iorRectorats;
        iorRectorats = m.getListeRectorat();
        Rectorat rTemp;
        List<Candidature> lesCandidaturesTemp;
        int ordre;
        Candidature cTemp;
        
        for(String ior : iorRectorats) {
            rTemp = GetObjectCorba.getRectoratCorba(orb, ior);
            if( rTemp != null) {
                try {
                     lesCandidaturesTemp = CandidatureMapper.candidaturesCorbaToListCandidature(rTemp.recupererCandidaturesEtudiant(moi));
                     if(!lesCandidaturesTemp.isEmpty()){
                         for (Candidature lesCandidaturesTemp1 : lesCandidaturesTemp) {
                             mesCandidatures.add(lesCandidaturesTemp1);
                         }
                     }
                } catch (EtudiantInconnu ex) {
                    Logger.getLogger(ChoixVoeux.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        // On ordonne les candidatures pour les traités efficacement
        for(Candidature candidature : mesCandidatures){
            System.out.println(candidature);
            ordre=candidature.getOrdre();
            
            switch(ordre){
                case 1:
                    //S'il est retenu, on annule toutes les autres
                    if(decisionMaster.from_int(candidature.getDecisionMaster()).toString().equals("admis")){
                        voeuxRetenu=ordre; 
                    }
                    afficherVoeux(ordre,candidature);
                    afficherListe(ordre, decisionMaster.from_int(candidature.getDecisionMaster()));
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
                    if(voeuxRetenu==0 && decisionMaster.from_int(candidature.getDecisionMaster()).toString().equals("admis")){
                       voeuxRetenu=ordre; 
                       afficherVoeux(ordre, candidature);
                       afficherListe(ordre, decisionMaster.from_int(candidature.getDecisionMaster()));
                    }
                    else{
                        cTemp = candidature;
                        cTemp.setDecisionMaster(decisionMaster.refuser.value());
                        afficherVoeux(ordre, cTemp);
                        afficherListe(ordre, decisionMaster.refuser);
                    }
                    break;
                default:
                    break;
            }
      
        } 
        if(voeuxRetenu==0){
            jLabelPasBesoinDeReponse.setVisible(true);
            jButtonValider.setEnabled(false);
        }
        if(mesCandidatures.size()<5){
            for(int i=5;i>mesCandidatures.size();i--){
                lesLabelsChoix[i-1].setVisible(false);
                lesLabelsDecision[i-1].setVisible(false);
                lesComboBox[i-1].setVisible(false);
            }
        }
    }

    
    private void afficherVoeux(int ordre,Candidature candidature){
        JLabel labelChoix,labelDecision;
        //Affichage du master séléctionné
        labelChoix=lesLabelsChoix[ordre-1];
        labelChoix.setText(candidature.getMaster() + " - " + candidature.getUniversite());
        //Affichage de la decision pour ce master
        labelDecision=lesLabelsDecision[ordre-1];
        labelDecision.setText(decisionMaster.from_int(candidature.getDecisionMaster()).toString());  
    }
    
    private void afficherListe(int ordre,decisionMaster decision){
        switch(ordre){
                case 1:
                    if(decision.toString().equals("admis")){
                        lesComboBox[ordre-1].addItem(decisionCandidat.ouiDefinitif.toString());
                        lesComboBox[ordre-1].addItem(decisionCandidat.nonDefinitif.toString());
                    }
                    else{
                       //Si le premier choix n'est pas séléctionné, on desactive la liste deroulante
                       lesComboBox[ordre-1].setEnabled(false); 
                    }
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
                    //Si un choix précedent a été retenu, desactivation des listes deroulantes qui suivent
                    if(voeuxRetenu!=0 && voeuxRetenu!=ordre){
                        lesComboBox[ordre-1].setEnabled(false);
                    }
                    else if(decision.toString().equals("refuser")){
                        lesComboBox[ordre-1].setEnabled(false);
                    }
                    else if(voeuxRetenu==ordre){
                        lesComboBox[ordre-1].addItem(decisionCandidat.ouiDefinitif.toString());
                        lesComboBox[ordre-1].addItem(decisionCandidat.ouiMais.toString());
                        lesComboBox[ordre-1].addItem(decisionCandidat.nonMais.toString());
                        lesComboBox[ordre-1].addItem(decisionCandidat.nonDefinitif.toString());
                    }
                    break;
        }
    }
    
    private void initList(){
        lesLabelsChoix = new JLabel[] { jLabelVoeux1, jLabelVoeux2, jLabelVoeux3, jLabelVoeux4, jLabelVoeux5 };
        lesLabelsDecision = new JLabel[] {jLabelDecision1,jLabelDecision2,jLabelDecision3,jLabelDecision4,jLabelDecision5};
        lesComboBox = new JComboBox[] {jComboBoxChoix1,jComboBoxChoix2,jComboBoxChoix3,jComboBoxChoix4,jComboBoxChoix5};
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonValider;
    private javax.swing.JComboBox jComboBoxChoix1;
    private javax.swing.JComboBox jComboBoxChoix2;
    private javax.swing.JComboBox jComboBoxChoix3;
    private javax.swing.JComboBox jComboBoxChoix4;
    private javax.swing.JComboBox jComboBoxChoix5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelDecision1;
    private javax.swing.JLabel jLabelDecision2;
    private javax.swing.JLabel jLabelDecision3;
    private javax.swing.JLabel jLabelDecision4;
    private javax.swing.JLabel jLabelDecision5;
    private javax.swing.JLabel jLabelPasBesoinDeReponse;
    private javax.swing.JLabel jLabelVoeux1;
    private javax.swing.JLabel jLabelVoeux2;
    private javax.swing.JLabel jLabelVoeux3;
    private javax.swing.JLabel jLabelVoeux4;
    private javax.swing.JLabel jLabelVoeux5;
    // End of variables declaration//GEN-END:variables
}
