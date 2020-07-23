/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frame;

import static frame.AjoutCitation.maBase;
import static frame.AjoutCitation.maCitation;
import static frame.AjoutCitation.monRecueil;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import obj.Recueil;
import quotebase.QuoteBase;

/**
 *
 * @author max
 */
public class QuoteFrame extends javax.swing.JFrame {

    Image monImage = (new ImageIcon(getClass().getResource("/img/QuoteBaseIconepng.png"))).getImage();
    Icon monIcone = new ImageIcon(getClass().getResource("/img/QuoteBaseIconepng.png"));
    //   AjoutCitation monAjout;
    QuoteBase maBase;
    Recueil monRecueil;

    /**
     * Creates new form QuoteFrame
     */
    public QuoteFrame() {
                maBase = new QuoteBase();
//        monRecueil = maBase.chargerCitations();

        initComponents();
        this.setLocationRelativeTo(null);
        quotebase.Graphic.imprimerTrait(quotebase.Graphic.LONGUEURTRAIT, 2);
        quotebase.Graphic.imprimerTexte(1, 5, "Lancement de la fenètre principale de QuoteBase");
        quotebase.Graphic.encadrerTexte("QuoteBase est un logiciel de gestion de base de données de citations. Il a été developé en Java 8 et Sql en 2020 sur NetBeans et AzureDataStudio. Il est distribué sous license Creative Commons. Auteur Maxime J. maxime.j.ricgard@gmail.com");
        quotebase.Graphic.imprimerTrait(quotebase.Graphic.LONGUEURTRAIT, 10);
        quotebase.Graphic.imprimerTitre();

  
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        ImageBGjLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        NouvelleCit = new javax.swing.JMenuItem();
        AjoutCit = new javax.swing.JMenuItem();
        ModifCit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        Auteurs = new javax.swing.JMenuItem();
        Sources = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        Themes = new javax.swing.JMenuItem();
        Types = new javax.swing.JMenuItem();
        Titres = new javax.swing.JMenuItem();
        Statuts = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        Gestion = new javax.swing.JMenuItem();
        Analyse = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        Generer = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        APropos = new javax.swing.JMenuItem();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        jMenu4.setText("jMenu4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImage(monImage);

        ImageBGjLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/QuoteBaseLogo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ImageBGjLabel1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ImageBGjLabel1)
        );

        jMenu1.setText("Citations");

        NouvelleCit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.META_MASK));
        NouvelleCit.setText("Nouvelle citation");
        NouvelleCit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NouvelleCitActionPerformed(evt);
            }
        });
        jMenu1.add(NouvelleCit);

        AjoutCit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.META_MASK));
        AjoutCit.setText("Afficher les citations");
        AjoutCit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AjoutCitActionPerformed(evt);
            }
        });
        jMenu1.add(AjoutCit);

        ModifCit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.META_MASK));
        ModifCit.setText("Modifier une citation");
        ModifCit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModifCitActionPerformed(evt);
            }
        });
        jMenu1.add(ModifCit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Outils");

        Auteurs.setText("Auteurs");
        Auteurs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AuteursActionPerformed(evt);
            }
        });
        jMenu2.add(Auteurs);

        Sources.setText("Sources");
        Sources.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SourcesActionPerformed(evt);
            }
        });
        jMenu2.add(Sources);
        jMenu2.add(jSeparator2);

        Themes.setText("Thèmes");
        Themes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThemesActionPerformed(evt);
            }
        });
        jMenu2.add(Themes);

        Types.setText("Types");
        Types.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TypesActionPerformed(evt);
            }
        });
        jMenu2.add(Types);

        Titres.setText("Titres");
        Titres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TitresActionPerformed(evt);
            }
        });
        jMenu2.add(Titres);

        Statuts.setText("Statuts");
        Statuts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StatutsActionPerformed(evt);
            }
        });
        jMenu2.add(Statuts);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Semblables");

        Gestion.setText("Gestion");
        Gestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GestionActionPerformed(evt);
            }
        });
        jMenu3.add(Gestion);

        Analyse.setText("Analyse");
        Analyse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnalyseActionPerformed(evt);
            }
        });
        jMenu3.add(Analyse);

        jMenuBar1.add(jMenu3);

        jMenu6.setText("Simulacres");

        Generer.setText("Génerer");
        Generer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenererActionPerformed(evt);
            }
        });
        jMenu6.add(Generer);

        jMenuItem1.setText("Afficher les Simulacres");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem1);

        jMenuBar1.add(jMenu6);

        jMenu5.setText("Aide");

        APropos.setText("A propos");
        APropos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AProposActionPerformed(evt);
            }
        });
        jMenu5.add(APropos);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AjoutCitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AjoutCitActionPerformed
        // TODO add your handling code here:
        AfficherRecueil monAffichageRecueil = new AfficherRecueil();
        monAffichageRecueil.setVisible(true);


    }//GEN-LAST:event_AjoutCitActionPerformed

    private void ModifCitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModifCitActionPerformed
        ChoisirCitationTreeJframe maModif = new ChoisirCitationTreeJframe("Modifier une citation :");
        //      ModifierCitation maModif = new ModifierCitation();
        maModif.setVisible(true);

// TODO add your handling code here:
    }//GEN-LAST:event_ModifCitActionPerformed

    private void NouvelleCitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NouvelleCitActionPerformed
        // TODO add your handling code here:
        quotebase.Graphic.imprimerTexte("Lancement de la fenètre d'ajout");

        AjoutCitation monAjout = new AjoutCitation();
        monAjout.setVisible(true);

    }//GEN-LAST:event_NouvelleCitActionPerformed

    private void SourcesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SourcesActionPerformed
        // TODO add your handling code here:
        toDoMessage();

    }//GEN-LAST:event_SourcesActionPerformed

    private void AnalyseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnalyseActionPerformed
        // TODO add your handling code here:
        toDoMessage();

    }//GEN-LAST:event_AnalyseActionPerformed

    private void AuteursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AuteursActionPerformed
        // TODO add your handling code here:
        toDoMessage();
    }//GEN-LAST:event_AuteursActionPerformed

    private void ThemesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThemesActionPerformed
                // 1 - 999 Types de sources // 1001 - 1999 Titres d'Auteurs 
        // 2001 - 2999 Thèmes de citations // 3001 - 3999 Statuts généraux
                TypeGestion tg = new TypeGestion(2, maBase);
        tg.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_ThemesActionPerformed

    private void TypesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TypesActionPerformed
                // 1 - 999 Types de sources // 1001 - 1999 Titres d'Auteurs 
        // 2001 - 2999 Thèmes de citations // 3001 - 3999 Statuts généraux
        
        TypeGestion tg = new TypeGestion(0, maBase);
        tg.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_TypesActionPerformed

    private void TitresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TitresActionPerformed
                // 1 - 999 Types de sources // 1001 - 1999 Titres d'Auteurs 
        // 2001 - 2999 Thèmes de citations // 3001 - 3999 Statuts généraux
                TypeGestion tg = new TypeGestion(1, maBase);
        tg.setVisible(true);
        
        // TODO add your handling code here:
    }//GEN-LAST:event_TitresActionPerformed

    private void GestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GestionActionPerformed
        toDoMessage();
        // TODO add your handling code here:
    }//GEN-LAST:event_GestionActionPerformed

    private void AProposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AProposActionPerformed
        toDoMessage();
        // TODO add your handling code here:
    }//GEN-LAST:event_AProposActionPerformed

    private void GenererActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenererActionPerformed
        // TODO add your handling code here:
        GenererSimulacreJFrame GJ = new GenererSimulacreJFrame(); 
GJ.setVisible(true);
    }//GEN-LAST:event_GenererActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        toDoMessage();
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void StatutsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StatutsActionPerformed
               // 1 - 999 Types de sources // 1001 - 1999 Titres d'Auteurs 
        // 2001 - 2999 Thèmes de citations // 3001 - 3999 Statuts généraux
                        TypeGestion tg = new TypeGestion(3, maBase);
        tg.setVisible(true);
        
        // TODO add your handling code here:
    }//GEN-LAST:event_StatutsActionPerformed

    public void toDoMessage() {
        quotebase.Graphic.imprimerTexte(0, 3, "TO DO");
        String method = new Throwable().getStackTrace()[1].getMethodName();

        JOptionPane.showMessageDialog(null, method + " reste à déveloper", "A faire", JOptionPane.INFORMATION_MESSAGE, monIcone);

    }

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
            java.util.logging.Logger.getLogger(QuoteFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuoteFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuoteFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuoteFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuoteFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem APropos;
    private javax.swing.JMenuItem AjoutCit;
    private javax.swing.JMenuItem Analyse;
    private javax.swing.JMenuItem Auteurs;
    private javax.swing.JMenuItem Generer;
    private javax.swing.JMenuItem Gestion;
    private javax.swing.JLabel ImageBGjLabel1;
    private javax.swing.JMenuItem ModifCit;
    private javax.swing.JMenuItem NouvelleCit;
    private javax.swing.JMenuItem Sources;
    private javax.swing.JMenuItem Statuts;
    private javax.swing.JMenuItem Themes;
    private javax.swing.JMenuItem Titres;
    private javax.swing.JMenuItem Types;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
