package IHM.Etudiant;

import AdmissionPostLicence.EtudiantInconnu;
import AdmissionPostLicence.GestionEtudiant;
import AdmissionPostLicence.Ministere;
import AdmissionPostLicence.MinistereHelper;
import AdmissionPostLicence.Rectorat;
import AdmissionPostLicence.accreditation;
import AdmissionPostLicence.candidature;
import AdmissionPostLicence.decisionCandidat;
import AdmissionPostLicence.decisionMaster;
import AdmissionPostLicence.etatCandidature;
import AdmissionPostLicence.identite;
import Ministere.AccreditationMapper;
import Ministere.pojo.Accreditation;
import Rectorat.CandidatureMapper;
import Rectorat.pojo.Candidature;
import Universite.GestionEtudiant.EtudiantMapper;
import Universite.pojo.Etudiant;
import Util.GetObjectCorba;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.NotFound;

/**
 *
 * @author johnny
 */
public class MenuPrincipal extends javax.swing.JFrame {
    private final GestionEtudiant g;
    private final org.omg.CORBA.ORB orb;
    private final Ministere m;
    private final Rectorat r;
    private final identite moi;
    private boolean panelChoixVisible = false;
    private List<Candidature> mesCandidatures = new ArrayList<>();
    HashMap<String, Accreditation> lesAccreditations = new HashMap<>();
    private int nombreDeVoeux=0;
    private List<Integer> ordreDejaSaisies = new ArrayList<>();
    
    /**
     * Creates new form MenuPrincipal
     * @param m
     * @param r
     * @param g
     * @param orb
     * @param id
     */
    public MenuPrincipal(Ministere m, Rectorat r,GestionEtudiant g,org.omg.CORBA.ORB orb,identite id) {
        this.nombreDeVoeux = 0;
        initComponents();
        this.g=g;
        this.orb=orb;
        this.m=m;
        this.r = r;
        this.moi = id;
        
        // Traitement des accreditations
        accreditation[] accreditations = this.m.recupererAccreditations();
        
        for(accreditation a : accreditations) {
            lesAccreditations.put(a.universite, AccreditationMapper.accreditationCorbaToAccredidation(a));
            jComboBoxUniversiteNouvelleCandidature.addItem(a.universite);
        }
        
        jComboBoxUniversiteNouvelleCandidature.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {    
                if(!jComboBoxUniversiteNouvelleCandidature.getSelectedItem().equals("Selectionner")){
                    jComboBoxFormationNouvelleCandidature.removeAllItems();
                    List<String> diplomes = lesAccreditations.get(jComboBoxUniversiteNouvelleCandidature.getSelectedItem()).getDiplome();
                    for(String diplome : diplomes){
                        jComboBoxFormationNouvelleCandidature.addItem(diplome);
                    }
                }
            }
        });
 
        // Traitrement des candidatures
        String[] iorRectorats;
        iorRectorats = m.getListeRectorat();
        Rectorat rTemp;
        List<Candidature> lesCandidaturesTemp;
        for(String ior : iorRectorats) {
            rTemp = GetObjectCorba.getRectoratCorba(orb, ior);
            if( rTemp != null) {
                try {
                     lesCandidaturesTemp = CandidatureMapper.candidaturesCorbaToListCandidature(rTemp.recupererCandidaturesEtudiant(moi));
                     if(!lesCandidaturesTemp.isEmpty()){
                         for (Candidature lesCandidaturesTemp1 : lesCandidaturesTemp) {
                             nombreDeVoeux++;
                             mesCandidatures.add(lesCandidaturesTemp1);
                             jComboBoxAccreditations.addItem(lesCandidaturesTemp1.getMaster() + "-" + lesCandidaturesTemp1.getUniversite());
                             ordreDejaSaisies.add(lesCandidaturesTemp1.getOrdre());
                             System.out.println("ordre : "+lesCandidaturesTemp1.getOrdre());
                         }
                     }
                } catch (EtudiantInconnu ex) {
                    Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(nombreDeVoeux==5){
                jButtonCandidater.setEnabled(false);
            }
        }
        jComboBoxAccreditations.setSelectedIndex(-1);
        
        jComboBoxAccreditations.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {    
                if(jComboBoxAccreditations.getSelectedIndex()!=-1){
                    String master = jComboBoxAccreditations.getSelectedItem().toString().replaceAll("\\-.*","");
                    Candidature c = getCandidature(master);
                    jTextFieldMaster.setText(c.getMaster());
                    jTextFieldUniversite.setText(c.getUniversite());
                    jTextFieldOrdre.setText(Integer.toString(c.getOrdre()));
                }
            }
        });

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
        jComboBoxAccreditations = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldUniversite = new javax.swing.JTextField();
        jTextFieldMaster = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldOrdre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboBoxUniversiteNouvelleCandidature = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jComboBoxFormationNouvelleCandidature = new javax.swing.JComboBox();
        jButtonCandidater = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldOrdreNouvelleCandidature = new javax.swing.JTextField();
        jLabelErrorNewCandidature = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Menu principal Gestion Etudiant");

        jLabel2.setText("Selectionner une candidature :");

        jLabel3.setText("Formation : ");

        jButton1.setText("Modifier");

        jLabel4.setText("Université :");

        jLabel5.setText("Ordre : ");

        jLabel6.setText("Modifier une candidature");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(64, 64, 64))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addGap(47, 47, 47))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addGap(18, 18, 18)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(23, 23, 23)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldUniversite, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldOrdre, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldMaster, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(jButton1)))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldUniversite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldMaster, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldOrdre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(jButton1)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jLabel7.setText("Nouvelle candidature");

        jLabel8.setText("Université :");

        jComboBoxUniversiteNouvelleCandidature.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selectionner" }));
        jComboBoxUniversiteNouvelleCandidature.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxUniversiteNouvelleCandidatureActionPerformed(evt);
            }
        });

        jLabel9.setText("Formation :");

        jButtonCandidater.setText("Candidater");
        jButtonCandidater.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCandidaterActionPerformed(evt);
            }
        });

        jLabel10.setText("Ordre :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelErrorNewCandidature, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(158, 158, 158)
                            .addComponent(jLabel7))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(26, 26, 26)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8)
                                .addComponent(jLabel9)
                                .addComponent(jLabel10))
                            .addGap(42, 42, 42)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jComboBoxUniversiteNouvelleCandidature, 0, 193, Short.MAX_VALUE)
                                .addComponent(jComboBoxFormationNouvelleCandidature, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextFieldOrdreNouvelleCandidature)))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(154, 154, 154)
                            .addComponent(jButtonCandidater))))
                .addContainerGap(143, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jComboBoxUniversiteNouvelleCandidature, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jComboBoxFormationNouvelleCandidature, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextFieldOrdreNouvelleCandidature, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(jButtonCandidater)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelErrorNewCandidature, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(281, 281, 281)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxAccreditations, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxAccreditations, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxUniversiteNouvelleCandidatureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxUniversiteNouvelleCandidatureActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxUniversiteNouvelleCandidatureActionPerformed

    private void jButtonCandidaterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCandidaterActionPerformed
        if(jComboBoxFormationNouvelleCandidature.getSelectedIndex()!=-1){
            if(!ordreDejaSaisies.contains(Integer.parseInt(jTextFieldOrdreNouvelleCandidature.getText()))){
                jLabelErrorNewCandidature.setText(" ");
                candidature c = new candidature(moi, jComboBoxFormationNouvelleCandidature.getSelectedItem().toString(), 
                        jComboBoxUniversiteNouvelleCandidature.getSelectedItem().toString(), Short.parseShort(jTextFieldOrdreNouvelleCandidature.getText()), 
                        etatCandidature.nonTraite, decisionCandidat.nonTraite, decisionMaster.nonTraite);
                r.creerCandidature(c);

            }
            else{
                jLabelErrorNewCandidature.setText("Cet ordre a déjà été saisie");
            }
        }
    }//GEN-LAST:event_jButtonCandidaterActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

    }

    /**
     * Renvoi la Candidature visé par ce master
     * @param master
     * @return 
     */
    public Candidature getCandidature(String master){
        for (Candidature mesCandidatures1 : mesCandidatures) {
            if(mesCandidatures1.getEtu().getIne().equals(moi.ine) && mesCandidatures1.getMaster().equals(master)){
                return mesCandidatures1;
            }
        }
        return null;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonCandidater;
    private javax.swing.JComboBox jComboBoxAccreditations;
    private javax.swing.JComboBox jComboBoxFormationNouvelleCandidature;
    private javax.swing.JComboBox jComboBoxUniversiteNouvelleCandidature;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelErrorNewCandidature;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextFieldMaster;
    private javax.swing.JTextField jTextFieldOrdre;
    private javax.swing.JTextField jTextFieldOrdreNouvelleCandidature;
    private javax.swing.JTextField jTextFieldUniversite;
    // End of variables declaration//GEN-END:variables
}
