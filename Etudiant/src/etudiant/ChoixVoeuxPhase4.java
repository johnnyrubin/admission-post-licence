package etudiant;

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

/**
 *
 */
public class ChoixVoeuxPhase4 extends javax.swing.JFrame {

    private final GestionEtudiant g;
    private final org.omg.CORBA.ORB orb;
    private final Ministere m;
    private final Rectorat r;
    private final identite moi;
    private final List<Candidature> mesCandidatures = new ArrayList<>();
    private Candidature candidatureSelectionne;
    
    /**
     * Creates new form ChoixVoeux
     * @param m
     * @param r
     * @param g
     * @param orb
     * @param id
     */
    public ChoixVoeuxPhase4(Ministere m, Rectorat r,GestionEtudiant g,org.omg.CORBA.ORB orb,identite id) {
        this.g=g;
        this.orb=orb;
        this.m=m;
        this.r = r;
        this.moi = id;
        initComponents();
        jLabelPasBesoinDeReponse.setVisible(false);
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
        jComboBoxChoix1 = new javax.swing.JComboBox();
        jLabelPasBesoinDeReponse = new javax.swing.JLabel();
        jButtonValider = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel1.setText("Meilleur proposition");

        jLabelVoeux1.setText("Voeux 1");

        jComboBoxChoix1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Oui Definitif", "Non Definitif" }));
        jComboBoxChoix1.setToolTipText("");

        jLabelPasBesoinDeReponse.setText("Vous n'avez pas de meilleur proposition");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabelPasBesoinDeReponse)
                .addGap(155, 155, 155))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(jLabelVoeux1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jComboBoxChoix1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
            .addGroup(layout.createSequentialGroup()
                .addGap(243, 243, 243)
                .addComponent(jLabel1)
                .addContainerGap(186, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonValider)
                .addGap(233, 233, 233))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabelPasBesoinDeReponse)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxChoix1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelVoeux1))
                .addGap(18, 18, 18)
                .addComponent(jButtonValider)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonValiderActionPerformed
        String choix=jComboBoxChoix1.getSelectedItem().toString();
        switch(choix){
            case "Oui Definitif":
                candidatureSelectionne.setDecisionCandidat(decisionCandidat.ouiDefinitif.value());
                g.modifierDecision(CandidatureMapper.candidatureToCandidatureCorba(candidatureSelectionne));
                break;
            case "Non Definitif":
                candidatureSelectionne.setDecisionCandidat(decisionCandidat.nonDefinitif.value());
                g.modifierDecision(CandidatureMapper.candidatureToCandidatureCorba(candidatureSelectionne));
                break;
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
        boolean candidatureTrouve=false;
        
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
        
        for(Candidature c : mesCandidatures){
            if(decisionMaster.admis.value() == c.getDecisionMaster() && decisionCandidat.ouiDefinitif.value()!=c.getDecisionCandidat() 
                    && decisionCandidat.nonDefinitif.value()!=c.getDecisionCandidat()){
                jLabelVoeux1.setText(c.getMaster() + " - " + c.getUniversite());
                candidatureSelectionne=c;
                candidatureTrouve=true;
                break;
            }
        }
        if(!candidatureTrouve){
            jLabelPasBesoinDeReponse.setVisible(true);
            jButtonValider.setEnabled(false);
        }
            
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonValider;
    private javax.swing.JComboBox jComboBoxChoix1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelPasBesoinDeReponse;
    private javax.swing.JLabel jLabelVoeux1;
    // End of variables declaration//GEN-END:variables
}
