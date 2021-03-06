/*
 * Project done with Oracle NetBeans
 * Distributed under Creative Commons 
 * By Maxime J.
 */
package frame;

import static frame.AjoutCitation.monRecueil;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import obj.Auteur;
import quotebase.Graphic;
import quotebase.QuoteBase;

/**
 *
 * @author Maxime J. <maximejrichard at gmail.com>
 */
public class GenererSimulacreJFrame extends javax.swing.JFrame {

    Icon icone = (new ImageIcon(getClass().getResource("/img/QuoteBaseIconepng.png")));
    quotebase.QuoteBase maBase = new QuoteBase();

    /**
     * Creates new form NewJFrame
     */
    public GenererSimulacreJFrame() {
        initComponents();

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
        Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
        int x = (int) rect.getMaxX() - this.getWidth();
        int y = ((int) rect.getMaxY()) - this.getHeight();
        this.setLocation(x, 0);
        checkPannels();
    }

    public DefaultComboBoxModel initAuteurComboBoxModel() {
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel(maBase.chargerAuteur());
        dcbm.setSelectedItem("Auteurs");

        return dcbm;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GenererSimulacrejPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        RozettajCheckBox1 = new javax.swing.JCheckBox();
        DanjCheckBox2 = new javax.swing.JCheckBox();
        SatjCheckBox3 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        RozettajPanel2 = new javax.swing.JPanel();
        GenererjButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        clefjSpinner1 = new javax.swing.JSpinner();
        sortiejSpinner2 = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        DanFjPanel3 = new javax.swing.JPanel();
        GenererjButton2 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox();
        clefjSpinner2 = new javax.swing.JSpinner();
        sortiejSpinner3 = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        SatFjPanel4 = new javax.swing.JPanel();
        GenererjButton3 = new javax.swing.JButton();
        jComboBox3 = new javax.swing.JComboBox();
        clefjSpinner3 = new javax.swing.JSpinner();
        sortiejSpinner4 = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/QuoteBaseIconepng.png"))); // NOI18N

        jLabel5.setText("Generateur de Simulacre");

        RozettajCheckBox1.setText("RozettaCode");
        RozettajCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RozettajCheckBox1ActionPerformed(evt);
            }
        });

        DanjCheckBox2.setText("DanFCode");
        DanjCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DanjCheckBox2ActionPerformed(evt);
            }
        });

        SatjCheckBox3.setText("SatssukiCode");
        SatjCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SatjCheckBox3ActionPerformed(evt);
            }
        });

        jButton1.setText("Enregistrer le SImulacre");

        javax.swing.GroupLayout GenererSimulacrejPanel2Layout = new javax.swing.GroupLayout(GenererSimulacrejPanel2);
        GenererSimulacrejPanel2.setLayout(GenererSimulacrejPanel2Layout);
        GenererSimulacrejPanel2Layout.setHorizontalGroup(
            GenererSimulacrejPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GenererSimulacrejPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(GenererSimulacrejPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GenererSimulacrejPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(GenererSimulacrejPanel2Layout.createSequentialGroup()
                        .addComponent(RozettajCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DanjCheckBox2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SatjCheckBox3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        GenererSimulacrejPanel2Layout.setVerticalGroup(
            GenererSimulacrejPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GenererSimulacrejPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(GenererSimulacrejPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(GenererSimulacrejPanel2Layout.createSequentialGroup()
                        .addGroup(GenererSimulacrejPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(GenererSimulacrejPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RozettajCheckBox1)
                            .addComponent(DanjCheckBox2)
                            .addComponent(SatjCheckBox3))
                        .addGap(58, 58, 58))
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.setPreferredSize(new java.awt.Dimension(567, 225));

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                .addContainerGap())
        );

        GenererjButton1.setText("Generer par RozettaCode");
        GenererjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenererjButton1ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(initAuteurComboBoxModel());

        clefjSpinner1.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), null, null, Integer.valueOf(1)));

        sortiejSpinner2.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(12), null, null, Integer.valueOf(1)));

        jLabel2.setText("Clef");

        jLabel3.setText("Sortie");

        jTextField1.setText("Mot dans la source");

        javax.swing.GroupLayout RozettajPanel2Layout = new javax.swing.GroupLayout(RozettajPanel2);
        RozettajPanel2.setLayout(RozettajPanel2Layout);
        RozettajPanel2Layout.setHorizontalGroup(
            RozettajPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RozettajPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(RozettajPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(RozettajPanel2Layout.createSequentialGroup()
                        .addGroup(RozettajPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(GenererjButton1)
                            .addGroup(RozettajPanel2Layout.createSequentialGroup()
                                .addComponent(clefjSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sortiejSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(RozettajPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        RozettajPanel2Layout.setVerticalGroup(
            RozettajPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RozettajPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(RozettajPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GenererjButton1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(RozettajPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clefjSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(sortiejSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        GenererjButton2.setText("Generer par DanFCode");
        GenererjButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenererjButton2ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(initAuteurComboBoxModel());

        clefjSpinner2.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(4), null, null, Integer.valueOf(1)));

        sortiejSpinner3.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(80), null, null, Integer.valueOf(1)));

        jLabel6.setText("Clef");

        jLabel7.setText("Sortie");

        jTextField2.setText("Mot dans la source");

        javax.swing.GroupLayout DanFjPanel3Layout = new javax.swing.GroupLayout(DanFjPanel3);
        DanFjPanel3.setLayout(DanFjPanel3Layout);
        DanFjPanel3Layout.setHorizontalGroup(
            DanFjPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DanFjPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DanFjPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addGroup(DanFjPanel3Layout.createSequentialGroup()
                        .addGroup(DanFjPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(GenererjButton2)
                            .addGroup(DanFjPanel3Layout.createSequentialGroup()
                                .addComponent(clefjSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sortiejSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(DanFjPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        DanFjPanel3Layout.setVerticalGroup(
            DanFjPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DanFjPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DanFjPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GenererjButton2)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DanFjPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clefjSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(sortiejSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        GenererjButton3.setText("Generer par SatssukiCode");
        GenererjButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenererjButton3ActionPerformed(evt);
            }
        });

        jComboBox3.setModel(initAuteurComboBoxModel());

        clefjSpinner3.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(4), null, null, Integer.valueOf(1)));

        sortiejSpinner4.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(80), null, null, Integer.valueOf(1)));

        jLabel8.setText("Clef");

        jLabel9.setText("Sortie");

        jTextField3.setText("Mot dans la source");

        javax.swing.GroupLayout SatFjPanel4Layout = new javax.swing.GroupLayout(SatFjPanel4);
        SatFjPanel4.setLayout(SatFjPanel4Layout);
        SatFjPanel4Layout.setHorizontalGroup(
            SatFjPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SatFjPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SatFjPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3)
                    .addGroup(SatFjPanel4Layout.createSequentialGroup()
                        .addGroup(SatFjPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(GenererjButton3)
                            .addGroup(SatFjPanel4Layout.createSequentialGroup()
                                .addComponent(clefjSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sortiejSpinner4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addGroup(SatFjPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        SatFjPanel4Layout.setVerticalGroup(
            SatFjPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SatFjPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SatFjPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GenererjButton3)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SatFjPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clefjSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(sortiejSpinner4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                    .addComponent(GenererSimulacrejPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RozettajPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DanFjPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SatFjPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(GenererSimulacrejPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RozettajPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DanFjPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SatFjPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        setBounds(0, 0, 567, 736);
    }// </editor-fold>//GEN-END:initComponents

    private void GenererjButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenererjButton1ActionPerformed
        try {
            // TODO add your handling code here:
//            String[] args = new String[]{"A","B","C","D","E"};
//            new simulacre.Projet_Main().main(args);
//            String corpus = "Note that String implements Comparable interface, so it works for natural sorting. Incase you want to sort by some other way, you can use Arrays.sort() overloaded method by passing a Comparator. Learn about these sorting techniques at Comparable and Comparator in java.";

            String corpus = "";

            if (jComboBox1.getSelectedIndex() > 0) {
                corpus = maBase.chargerTexteCitation((Auteur) jComboBox1.getSelectedItem());
            } else {
                corpus = maBase.chargerTexteCitation();
            }

            simulacre.MarkovChain MC = new simulacre.MarkovChain();
            //   MC.markov(corpus, 5, 1);

            jTextArea1.setText(MC.markov(corpus, (int) clefjSpinner1.getValue(), (int) sortiejSpinner2.getValue()));
            Graphic.imprimerTexte(1, 2, "Chaine de Markov générée : " + jTextArea1.getText());

        } catch (IOException ex) {
            Graphic.imprimerTexte(0, 3, "Echec due la création de chaine de Markov : " + ex.getMessage());
        }

    }//GEN-LAST:event_GenererjButton1ActionPerformed

    private void GenererjButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenererjButton2ActionPerformed
        String corpus = "";
        if (jComboBox2.getSelectedIndex() > 0) {
            corpus = maBase.chargerTexteCitation((Auteur) jComboBox2.getSelectedItem());
        } else {
            corpus = maBase.chargerTexteCitation();
        }
        simulacre.MarkovChain MC = new simulacre.MarkovChain();
        String[] arg = new String[]{clefjSpinner2.getValue().toString(), sortiejSpinner3.getValue().toString(), corpus};
        jTextArea1.setText(MC.markovDanF(arg));
        Graphic.imprimerTexte(1, 2, "Chaine de Markov générée : " + jTextArea1.getText());
    }//GEN-LAST:event_GenererjButton2ActionPerformed

    private void GenererjButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenererjButton3ActionPerformed
        String corpus = "";
        if (jComboBox3.getSelectedIndex() > 0) {
            corpus = maBase.chargerTexteCitation((Auteur) jComboBox3.getSelectedItem());
        } else {
            corpus = maBase.chargerTexteCitation();
        }
        simulacre.TextGenerator TG = new simulacre.TextGenerator();
        jTextArea1.setText(TG.TextGenerator(Integer.valueOf(clefjSpinner3.getValue().toString()), Integer.valueOf(sortiejSpinner4.getValue().toString()), corpus));
        // String[] arg = new String[]{clefjSpinner2.getValue().toString(), sortiejSpinner3.getValue().toString(), corpus};
        Graphic.imprimerTexte(1, 2, "Chaine de Markov générée : " + jTextArea1.getText());
    }//GEN-LAST:event_GenererjButton3ActionPerformed

    private void checkPannels() {
        if (RozettajCheckBox1.isSelected()) {
            RozettajPanel2.setVisible(true);
        } else {
            RozettajPanel2.setVisible(false);
        }
        if (DanjCheckBox2.isSelected()) {
            DanFjPanel3.setVisible(true);
        } else {
            DanFjPanel3.setVisible(false);
        }
        if (SatjCheckBox3.isSelected()) {
            SatFjPanel4.setVisible(true);
        } else {
            SatFjPanel4.setVisible(false);
        }
        pack();
    }

    private void RozettajCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RozettajCheckBox1ActionPerformed
        // TODO add your handling code here:
        checkPannels();
    }//GEN-LAST:event_RozettajCheckBox1ActionPerformed

    private void DanjCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DanjCheckBox2ActionPerformed
        // TODO add your handling code here:
        checkPannels();
    }//GEN-LAST:event_DanjCheckBox2ActionPerformed

    private void SatjCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SatjCheckBox3ActionPerformed
        // TODO add your handling code here:
        checkPannels();

    }//GEN-LAST:event_SatjCheckBox3ActionPerformed

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
            java.util.logging.Logger.getLogger(GenererSimulacreJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GenererSimulacreJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GenererSimulacreJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GenererSimulacreJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GenererSimulacreJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DanFjPanel3;
    private javax.swing.JCheckBox DanjCheckBox2;
    private javax.swing.JPanel GenererSimulacrejPanel2;
    private javax.swing.JButton GenererjButton1;
    private javax.swing.JButton GenererjButton2;
    private javax.swing.JButton GenererjButton3;
    private javax.swing.JCheckBox RozettajCheckBox1;
    private javax.swing.JPanel RozettajPanel2;
    private javax.swing.JPanel SatFjPanel4;
    private javax.swing.JCheckBox SatjCheckBox3;
    private javax.swing.JSpinner clefjSpinner1;
    private javax.swing.JSpinner clefjSpinner2;
    private javax.swing.JSpinner clefjSpinner3;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JSpinner sortiejSpinner2;
    private javax.swing.JSpinner sortiejSpinner3;
    private javax.swing.JSpinner sortiejSpinner4;
    // End of variables declaration//GEN-END:variables
}
