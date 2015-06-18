package etudiant;

import AdmissionPostLicence.EtudiantInconnu;
import AdmissionPostLicence.GestionEtudiant;
import AdmissionPostLicence.Ministere;
import AdmissionPostLicence.Rectorat;
import AdmissionPostLicence.identite;
import Util.GetObjectCorba;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * 
 */
public class Login extends javax.swing.JFrame {
    
    org.omg.CORBA.ORB orb;
    GestionEtudiant g;
    Ministere m;
    HashMap<String,Rectorat> lesRectorats = new HashMap<>();
    HashMap<String,GestionEtudiant> lesGestionEtudiants = new HashMap<>();

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        String[] test = {};

        orb = org.omg.CORBA.ORB.init(test,null);
        orb.string_to_object("corbaloc:iiop:1.2@" + GetObjectCorba.getIpServeur() + ":2001/NameService");
        m = GetObjectCorba.getMinistereCorba(orb);
        
        // Récupération de la liste des rectorats
        String[] iorRectorats = m.getListeRectorat();
        Rectorat r;
        for(String ior : iorRectorats) {
            r = GetObjectCorba.getRectoratCorba(orb, ior);
            if( r != null) {
                lesRectorats.put(r.nom(), r);
                jComboBoxRectorats.addItem(r.nom());
            }
        }

        
       jComboBoxRectorats.addActionListener (new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                if(!jComboBoxRectorats.getSelectedItem().equals("Séléctionner")){
                    Rectorat r = lesRectorats.get(jComboBoxRectorats.getSelectedItem());
                    GestionEtudiant g;
                    String[] gestEtus = r.getListeGestEtu();
                    for(String ior : gestEtus) {
                        g = GetObjectCorba.getGestionEtudiantCorba(orb, ior);
                        if( g != null) {
                            lesGestionEtudiants.put(g.nom(), g);
                            jComboBoxUniversite.addItem(g.nom());
                        }
                    }
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldINE = new javax.swing.JTextField();
        jPasswordField = new javax.swing.JPasswordField();
        jButtonConnect = new javax.swing.JButton();
        jLabelError = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxRectorats = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxUniversite = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel1.setText("Connexion");

        jLabel2.setText("INE :");

        jLabel3.setText("Mot de passe :");

        jTextFieldINE.setText("123456E");
        jTextFieldINE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldINEActionPerformed(evt);
            }
        });

        jPasswordField.setText("toto");

        jButtonConnect.setText("Se connecter");
        jButtonConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConnectActionPerformed(evt);
            }
        });

        jLabelError.setForeground(new java.awt.Color(255, 0, 0));

        jButton1.setText("S'inscrire");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Choisir un rectorat :");

        jComboBoxRectorats.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Séléctionner" }));
        jComboBoxRectorats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxRectoratsActionPerformed(evt);
            }
        });

        jLabel5.setText("Choisir une université :");

        jComboBoxUniversite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxUniversiteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(129, 129, 129))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabelError, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonConnect)
                        .addGap(132, 132, 132))))
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(27, 27, 27)
                        .addComponent(jComboBoxRectorats, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jTextFieldINE, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(29, 29, 29)
                                    .addComponent(jLabel1))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(62, 62, 62)
                                    .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxUniversite, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldINE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBoxRectorats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxUniversite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jButtonConnect)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelError, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConnectActionPerformed
        String ine = jTextFieldINE.getText();
        String mdp = new String(jPasswordField.getPassword());
        if(!ine.equals("")&&!mdp.equals("")&&
                jComboBoxUniversite.getSelectedIndex()!=-1 && !jComboBoxRectorats.getSelectedItem().equals("Séléctionner")){
            try {
                GestionEtudiant g = lesGestionEtudiants.get(jComboBoxUniversite.getSelectedItem());
                identite i = g.seConnecter(ine,mdp);
                if(i!=null){
                    //les identifiants sont ok
                    jLabelError.setText("");
                     // On récupère la période en cours afin de modifier l'IHM en conséquence
                    String periodeEnCours = m.periodeEnCours().toString();
                    System.out.println(periodeEnCours);
                    switch(periodeEnCours){
                        case "periode1":
                        case "periode2":
                            MenuPrincipal menu = new MenuPrincipal(m,lesRectorats.get(jComboBoxRectorats.getSelectedItem()),
                            g,orb,i);
                            menu.setVisible(true);
                            this.setVisible(false);
                            break;
                        case "periode3":
                            ChoixVoeux choixVoeux = new ChoixVoeux(m,lesRectorats.get(jComboBoxRectorats.getSelectedItem()),
                            g,orb,i);
                            choixVoeux.setVisible(true);
                            this.setVisible(false);
                            break;
                    }
                    
                }
                else{
                    jLabelError.setText("Identifiants ou mot de passe incorrect");
                }
            } catch (EtudiantInconnu ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_jButtonConnectActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Inscription i = new Inscription(g);
        i.setVisible(true);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBoxRectoratsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxRectoratsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxRectoratsActionPerformed

    private void jComboBoxUniversiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxUniversiteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxUniversiteActionPerformed

    private void jTextFieldINEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldINEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldINEActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonConnect;
    private javax.swing.JComboBox jComboBoxRectorats;
    private javax.swing.JComboBox jComboBoxUniversite;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelError;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JTextField jTextFieldINE;
    // End of variables declaration//GEN-END:variables
}