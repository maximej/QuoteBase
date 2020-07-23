/*
 * Project done with Oracle NetBeans
 * Distributed under Creative Commons 
 * By Maxime J.
 */
package frame;

import static frame.AfficherRecueil.maBase;
import static frame.AfficherRecueil.monRecueil;
import java.util.Vector;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import obj.*;
import quotebase.QuoteBase;

/**
 * "Ni aimer ni haïr", voila la première la moitié de toute sagesse ; "Ne rien
 * dire et ne rien croire", voilà l’autre moitié.
 *
 * @author Maxime J. <maximejrichard at gmail.com>
 */
public class ChoisirCitationTreeJframe extends javax.swing.JFrame {

    static String choix = "Choissisez une citation :";
    public static Recueil monRecueil;
    public static QuoteBase maBase;
    public static Citation maCitation;

    public static String getChoix() {
        return choix;
    }

    /**
     * Creates new form CHoisirCitationTreeJframe
     */
    public ChoisirCitationTreeJframe(String choix) {
        maBase = new QuoteBase();
        monRecueil = maBase.chargerElementsCitations();
        monRecueil = maBase.chargerCitations(monRecueil);

        this.choix = choix;
        initComponents();
        TextejRadioButton3.setSelected(true);

        jTree1.addTreeSelectionListener(new TreeSelectionListener() {
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) jTree1.getLastSelectedPathComponent();

                /* if nothing is selected */
                if (node == null) {
                    return;
                }

                /* retrieve the node that was selected */
                Object nodeInfo = node.getUserObject();
                /* React to the node selection. */
                if (nodeInfo.getClass().getSimpleName().equals("Citation")){
                    maCitation = (Citation) nodeInfo;
                }
            }
        });
        this.setLocationRelativeTo(null);

    }

    public DefaultTreeModel initCitationTree() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Citations");
        //Ajoute tout les auteurs comme premier niveau hierarchique
        for (Auteur a : monRecueil.getMesAuteurs()) {
            DefaultMutableTreeNode auteurNode = new DefaultMutableTreeNode(a);
            root.add(auteurNode);
            for (Source s : monRecueil.getMesSources()) {
                if (s.getMonAuteur().equals(a)) {
                    DefaultMutableTreeNode sourceNode = new DefaultMutableTreeNode(s);
                    auteurNode.add(sourceNode);
                    for (Citation c : monRecueil.getMesCitations()) {
                        if (c.getMaSource().equals(s)) {
                            DefaultMutableTreeNode citationNode = new DefaultMutableTreeNode(c);
                            sourceNode.add(citationNode);
                        }
                    }
                }
            }
        }

        //Crée le tree à partir du Root
        JTree tree = new JTree(root);
        DefaultTreeModel tm = new DefaultTreeModel(root);

        return tm;
    }

    public DefaultTreeModel researchAuteurTree(int field, String search) {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Citations");

        //Ajoute tout les auteurs contenant la recherche
        for (Auteur a : monRecueil.getMesAuteurs()) {
            if (a.toString().toLowerCase().contains(search)) {
                DefaultMutableTreeNode auteurNode = new DefaultMutableTreeNode(a);
                root.add(auteurNode);
                for (Source s : monRecueil.getMesSources()) {
                    if (s.getMonAuteur().equals(a)) {
                        DefaultMutableTreeNode sourceNode = new DefaultMutableTreeNode(s);
                        auteurNode.add(sourceNode);
                        for (Citation c : monRecueil.getMesCitations()) {
                            if (c.getMaSource().equals(s)) {
                                DefaultMutableTreeNode citationNode = new DefaultMutableTreeNode(c);
                                sourceNode.add(citationNode);
                            }
                        }
                    }
                }
            }
        }

        //Crée le tree à partir du Root
        JTree tree = new JTree(root);
        DefaultTreeModel tm = new DefaultTreeModel(root);

        return tm;
    }

    public DefaultTreeModel researchSourceTree(int field, String search) {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Citations");
        boolean found = false;

        //Ajoute tout les auteurs contenant la recherche
        for (Auteur a : monRecueil.getMesAuteurs()) {
            DefaultMutableTreeNode auteurNode = new DefaultMutableTreeNode(a);
            for (Source s : monRecueil.getMesSources()) {
                //   found = false;
                if (s.getMonNom().toLowerCase().contains(search.toLowerCase())) {
                    found = true;
                    if (s.getMonAuteur().equals(a)) {
                        DefaultMutableTreeNode sourceNode = new DefaultMutableTreeNode(s);
                        auteurNode.add(sourceNode);
                        for (Citation c : monRecueil.getMesCitations()) {
                            if (c.getMaSource().equals(s)) {
                                DefaultMutableTreeNode citationNode = new DefaultMutableTreeNode(c);
                                sourceNode.add(citationNode);
                            }
                        }
                    }

                }

            }
            if (!(auteurNode.isLeaf())) {
                root.add(auteurNode);
            }

        }

        //Crée le tree à partir du Root
        JTree tree = new JTree(root);
        DefaultTreeModel tm = new DefaultTreeModel(root);

        return tm;
    }

    public DefaultTreeModel researchCitationTree(int field, String search) {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Citations");

        //Ajoute tout les auteurs contenant la recherche
        for (Auteur a : monRecueil.getMesAuteurs()) {
            DefaultMutableTreeNode auteurNode = new DefaultMutableTreeNode(a);
            for (Source s : monRecueil.getMesSources()) {
                //   found = false;

                if (s.getMonAuteur().equals(a)) {
                    DefaultMutableTreeNode sourceNode = new DefaultMutableTreeNode(s);
                    for (Citation c : monRecueil.getMesCitations()) {

                        if (c.getMaSource().equals(s)) {
                            if (c.getMonTexte().contains(search)) {

                                DefaultMutableTreeNode citationNode = new DefaultMutableTreeNode(c);
                                sourceNode.add(citationNode);
                            }
                        }
                    }
                    if (!(sourceNode.isLeaf())) {
                        auteurNode.add(sourceNode);

                    }
                }

            }
            if (!(auteurNode.isLeaf())) {
                root.add(auteurNode);
            }

        }

        //Crée le tree à partir du Root
        JTree tree = new JTree(root);
        DefaultTreeModel tm = new DefaultTreeModel(root);

        return tm;
    }

//    public DefaultTreeModel researchCitationTree(int field, String search) {
//        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Citations");
//        //Ajoute tout les auteurs comme premier niveau hierarchique
//
//        for (Auteur a : monRecueil.getMesAuteurs()) {
//            boolean found = false;
//            DefaultMutableTreeNode auteurNode = new DefaultMutableTreeNode(a);
//            root.add(auteurNode);
//
//            if (a.toString().toLowerCase().contains(search.toLowerCase())) {
//                found = true;
//            }
//
//            for (Source s : monRecueil.getMesSources()) {
//
//                if (s.getMonAuteur().equals(a)) {
//                    DefaultMutableTreeNode sourceNode = new DefaultMutableTreeNode(s);
//                    auteurNode.add(sourceNode);
//
//                    if (s.getMonNom().contains(search)) {
//                        found = true;
//                    }
//
//                    for (Citation c : monRecueil.getMesCitations()) {
//                        if (c.getMaSource().equals(s)) {
//
//                            if (found == true) {
//                                DefaultMutableTreeNode citationNode = new DefaultMutableTreeNode(c);
//                                sourceNode.add(citationNode);
//                                quotebase.Graphic.imprimerTexte(1, "Auteur ou Source contiennent: " + search + " -- sur la citation : " + c.getMonTexte());
//                            } else if (c.getMonTexte().contains(search)) {
//                                DefaultMutableTreeNode citationNode = new DefaultMutableTreeNode(c);
//                                sourceNode.add(citationNode);
//                                quotebase.Graphic.imprimerTexte(1, "Recherche trouvée dans : " + search + " -- sur la citation : " + c.getMonTexte());
//
//                                found = true;
//
//                            } else if (found == false) {
//                                quotebase.Graphic.imprimerTexte(0, "Rien de trouvé");
//
//                                // quotebase.Graphic.imprimerTexte(0, "Recherche non trouvée : " + search + " -- sur la citation : " + c.getMonTexte());
//                            }
//                        }
//                    }
//
//                    if (found == false) {
//                        auteurNode.remove(sourceNode);
//                        quotebase.Graphic.imprimerTexte(0, 5, "Retrait de la source");
//
//                    }
//                }
//
//            }
//            if (found == false) {
//                root.remove(auteurNode);
//                quotebase.Graphic.imprimerTexte(0, 5, "Retrait de l'auteur");
//
//            }
//
//        }
//
//        //Crée le tree à partir du Root
//        JTree tree = new JTree(root);
//        DefaultTreeModel tm = new DefaultTreeModel(root);
//
//        return tm;
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        SourcejRadioButton1 = new javax.swing.JRadioButton();
        AuteurjRadioButton2 = new javax.swing.JRadioButton();
        TextejRadioButton3 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTree1.setModel(initCitationTree());
        jScrollPane1.setViewportView(jTree1);

        jLabel1.setText(choix);

        jButton1.setText("Choisir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Rechercher");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(SourcejRadioButton1);
        SourcejRadioButton1.setText("Source");

        buttonGroup1.add(AuteurjRadioButton2);
        AuteurjRadioButton2.setText("Auteur");

        buttonGroup1.add(TextejRadioButton3);
        TextejRadioButton3.setText("Texte");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 23, Short.MAX_VALUE)
                                .addComponent(AuteurjRadioButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SourcejRadioButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TextejRadioButton3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SourcejRadioButton1)
                    .addComponent(AuteurjRadioButton2)
                    .addComponent(TextejRadioButton3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (AuteurjRadioButton2.isSelected()) {
            jTree1.setModel(researchAuteurTree(1, jTextField1.getText()));
        }
        if (SourcejRadioButton1.isSelected()) {
            jTree1.setModel(researchSourceTree(2, jTextField1.getText()));
        }
        if (TextejRadioButton3.isSelected()) {
            jTree1.setModel(researchCitationTree(3, jTextField1.getText()));
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //   maCitation = (Citation) jTree1.getLastSelectedPathComponent();

        ModifierCitation maModif = new ModifierCitation(monRecueil, maBase, maCitation);
        maModif.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(ChoisirCitationTreeJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChoisirCitationTreeJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChoisirCitationTreeJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChoisirCitationTreeJframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChoisirCitationTreeJframe(getChoix()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton AuteurjRadioButton2;
    private javax.swing.JRadioButton SourcejRadioButton1;
    private javax.swing.JRadioButton TextejRadioButton3;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTree jTree1;
    // End of variables declaration//GEN-END:variables

}
