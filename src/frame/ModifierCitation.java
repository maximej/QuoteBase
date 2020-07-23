/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frame;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Rectangle;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Formatter;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import obj.*;
import obj.Type;
import quotebase.Graphic;
import quotebase.QuoteBase;

/**
 *
 * @author max
 */
public class ModifierCitation extends javax.swing.JFrame implements quotebase.Graphic {

    public static Recueil monRecueil;
    public static QuoteBase maBase;
    public static Source maSource;
    public static Auteur monAuteur;
    public static Citation maCitation;
    Icon icone = (new ImageIcon(getClass().getResource("/img/QuoteBaseIconepng.png")));

    /**
     * Creates new form AjoutCitation
     */
    public ModifierCitation() {

        maBase = new QuoteBase();
        monRecueil = maBase.chargerElementsCitations();

        initComponents();
        AddAuteurjPanel1.setVisible(false);
        AddSourcejPanel1.setVisible(false);
        checkPannels();

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
        Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
        int x = (int) rect.getMaxX() - this.getWidth();
        int y = (int) rect.getMaxY() - this.getHeight();
        this.setLocation(0, 0);

    }

    public ModifierCitation(Recueil monRecueil, QuoteBase maBase, Citation maCitation) {
        this.maBase = maBase;
        this.monRecueil = monRecueil;
        this.maCitation = maCitation;

        maSource = maBase.chargerUneSource(maCitation.getMaSource().getMonId(), monRecueil.getMesAuteurs(), monRecueil.getMesTypes());
        monAuteur = maSource.getMonAuteur();

        initComponents();

        AddAuteurjPanel1.setVisible(false);
        AddSourcejPanel1.setVisible(false);
        chargerCitation();
        chargerSource();
        chargerAuteur();
        checkPannels();
        SourcejComboBox1.setSelectedItem(maCitation.getMaSource());
        AuteurjComboBox3.setSelectedItem(monAuteur);
        SourcejComboBox1.setEnabled(false);
        AuteurjComboBox3.setEnabled(false);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
        Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
        int x = (int) rect.getMaxX() - this.getWidth();
        int y = (int) rect.getMaxY() - this.getHeight();
        this.setLocation(0, 0);

    }

    public DefaultComboBoxModel initSourceComboBoxModel() {
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel(monRecueil.getMesSources());
        // dcbm.setSelectedItem("Sources");

        return dcbm;
    }

    public DefaultComboBoxModel initLangueComboBoxModel() {
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel(monRecueil.getMesLangues());
        //  dcbm.setSelectedItem("Langues");

        return dcbm;
    }

    public DefaultComboBoxModel initTypeAuteurComboBoxModel() {
        Vector<obj.Type> mesTypesAuteurs = new Vector();
        for (obj.Type t : monRecueil.getMesTypes()) {
            if (t.getMonId() > 1000 && t.getMonId() < 2000) {
                mesTypesAuteurs.add(t);
            }
        }
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel(mesTypesAuteurs);
        dcbm.setSelectedItem("Titres");

        return dcbm;
    }

    public DefaultComboBoxModel selectSourceFromAuteurComboBoxModel(Vector<Source> vs) {
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel(vs);
        return dcbm;
    }

    public DefaultComboBoxModel initAuteurComboBoxModel() {
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel(monRecueil.getMesAuteurs());
        //    dcbm.setSelectedItem("Auteurs");

        return dcbm;
    }

    public DefaultComboBoxModel initThemeComboBoxModel() {
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel(monRecueil.getMesThemes());
        dcbm.setSelectedItem("Themes");

        return dcbm;
    }

    public DefaultComboBoxModel initTypeSourceComboBoxModel() {
        Vector<obj.Type> mesTypesSource = new Vector();
        for (obj.Type t : monRecueil.getMesTypes()) {
            if (t.getMonId() < 1000) {
                mesTypesSource.add(t);
            }
        }
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel(mesTypesSource);
        dcbm.setSelectedItem("Types");

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

        AddBasejPanel1 = new javax.swing.JPanel();
        AuteurjCheckBox1 = new javax.swing.JCheckBox();
        AuteurjComboBox3 = new javax.swing.JComboBox();
        AjouterButton = new javax.swing.JButton();
        SourcejComboBox1 = new javax.swing.JComboBox();
        SourcejCheckBox2 = new javax.swing.JCheckBox();
        ReinitjButton1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        CitationjPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        CitationjTextArea1 = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        LocationjTextField = new javax.swing.JTextField();
        ThemejComboBox1 = new javax.swing.JComboBox();
        ThemejComboBox2 = new javax.swing.JComboBox();
        ThemejComboBox3 = new javax.swing.JComboBox();
        AddSourcejPanel1 = new javax.swing.JPanel();
        SourcejTextField1 = new javax.swing.JTextField();
        ISBNjTextField2 = new javax.swing.JTextField();
        URLjTextField3 = new javax.swing.JTextField();
        PrecisionsTextField4 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TypeComboBox2 = new javax.swing.JComboBox();
        TypejComboBox4 = new javax.swing.JComboBox();
        DatejFormattedTextField3 = new javax.swing.JFormattedTextField();
        Publication = new javax.swing.JLabel();
        LanguejComboBox1 = new javax.swing.JComboBox();
        Editeur = new javax.swing.JLabel();
        EditeurjTextField1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        AddAuteurjPanel1 = new javax.swing.JPanel();
        PrenomjTextField5 = new javax.swing.JTextField();
        NomjTextField6 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TitrejComboBox2 = new javax.swing.JComboBox();
        TitrejComboBox5 = new javax.swing.JComboBox();
        TitrejComboBox6 = new javax.swing.JComboBox();
        TitrejComboBox7 = new javax.swing.JComboBox();
        NaissancejFormattedTextField1 = new javax.swing.JFormattedTextField();
        MortjFormattedTextField2 = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modifier une Citation");

        AuteurjCheckBox1.setText("Modifier les infos de l'Auteur");
        AuteurjCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                AuteurjCheckBox1ItemStateChanged(evt);
            }
        });
        AuteurjCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AuteurjCheckBox1ActionPerformed(evt);
            }
        });

        AuteurjComboBox3.setModel(initAuteurComboBoxModel());
        AuteurjComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AuteurjComboBox3ActionPerformed(evt);
            }
        });

        AjouterButton.setText("Enregistrer");
        AjouterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AjouterButtonActionPerformed(evt);
            }
        });

        SourcejComboBox1.setModel(initSourceComboBoxModel());
        SourcejComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SourcejComboBox1ActionPerformed(evt);
            }
        });

        SourcejCheckBox2.setText("Modifier les infos de la Source");
        SourcejCheckBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                SourcejCheckBox2ItemStateChanged(evt);
            }
        });
        SourcejCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SourcejCheckBox2ActionPerformed(evt);
            }
        });

        ReinitjButton1.setText("Anuler");
        ReinitjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReinitjButton1ActionPerformed(evt);
            }
        });

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/QuoteBaseIconepng.png"))); // NOI18N

        javax.swing.GroupLayout AddBasejPanel1Layout = new javax.swing.GroupLayout(AddBasejPanel1);
        AddBasejPanel1.setLayout(AddBasejPanel1Layout);
        AddBasejPanel1Layout.setHorizontalGroup(
            AddBasejPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddBasejPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AddBasejPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(AddBasejPanel1Layout.createSequentialGroup()
                        .addComponent(ReinitjButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(SourcejCheckBox2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddBasejPanel1Layout.createSequentialGroup()
                        .addComponent(AjouterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(SourcejComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(AddBasejPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AuteurjComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AuteurjCheckBox1))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        AddBasejPanel1Layout.setVerticalGroup(
            AddBasejPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddBasejPanel1Layout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addContainerGap())
            .addGroup(AddBasejPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(AddBasejPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AjouterButton)
                    .addComponent(SourcejComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AuteurjComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(AddBasejPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ReinitjButton1)
                    .addComponent(SourcejCheckBox2)
                    .addComponent(AuteurjCheckBox1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        CitationjTextArea1.setColumns(20);
        CitationjTextArea1.setRows(5);
        jScrollPane1.setViewportView(CitationjTextArea1);

        jLabel11.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel11.setText("Modifier Citation");

        jLabel8.setText("Location");

        ThemejComboBox1.setModel(initThemeComboBoxModel());

        ThemejComboBox2.setModel(initThemeComboBoxModel());

        ThemejComboBox3.setModel(initThemeComboBoxModel());

        javax.swing.GroupLayout CitationjPanel1Layout = new javax.swing.GroupLayout(CitationjPanel1);
        CitationjPanel1.setLayout(CitationjPanel1Layout);
        CitationjPanel1Layout.setHorizontalGroup(
            CitationjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CitationjPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CitationjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CitationjPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(ThemejComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ThemejComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ThemejComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LocationjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1))
                .addContainerGap())
            .addGroup(CitationjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(CitationjPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        CitationjPanel1Layout.setVerticalGroup(
            CitationjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CitationjPanel1Layout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(CitationjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CitationjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LocationjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(ThemejComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CitationjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ThemejComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ThemejComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel11))
                .addContainerGap(176, Short.MAX_VALUE))
            .addGroup(CitationjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CitationjPanel1Layout.createSequentialGroup()
                    .addGap(0, 44, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jLabel1.setText("Source");

        jLabel2.setText("ISBN/URL");

        jLabel3.setText("Precisions");

        TypeComboBox2.setModel(initTypeSourceComboBoxModel());

        TypejComboBox4.setModel(initTypeSourceComboBoxModel());

        DatejFormattedTextField3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));

        Publication.setText("Date");

        LanguejComboBox1.setModel(initLangueComboBoxModel());

        Editeur.setText("Editeur");

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel9.setText("Source");

        javax.swing.GroupLayout AddSourcejPanel1Layout = new javax.swing.GroupLayout(AddSourcejPanel1);
        AddSourcejPanel1.setLayout(AddSourcejPanel1Layout);
        AddSourcejPanel1Layout.setHorizontalGroup(
            AddSourcejPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddSourcejPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AddSourcejPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddSourcejPanel1Layout.createSequentialGroup()
                        .addGroup(AddSourcejPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TypeComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TypejComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(AddSourcejPanel1Layout.createSequentialGroup()
                                .addComponent(LanguejComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Publication)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DatejFormattedTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(AddSourcejPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(AddSourcejPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SourcejTextField1)
                            .addGroup(AddSourcejPanel1Layout.createSequentialGroup()
                                .addGroup(AddSourcejPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(PrecisionsTextField4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                                    .addComponent(ISBNjTextField2, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(AddSourcejPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(URLjTextField3)
                                    .addGroup(AddSourcejPanel1Layout.createSequentialGroup()
                                        .addComponent(Editeur)
                                        .addGap(18, 18, 18)
                                        .addComponent(EditeurjTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addComponent(jSeparator2)
                    .addGroup(AddSourcejPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        AddSourcejPanel1Layout.setVerticalGroup(
            AddSourcejPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddSourcejPanel1Layout.createSequentialGroup()
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(AddSourcejPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SourcejTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(TypeComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AddSourcejPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ISBNjTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(URLjTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(TypejComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AddSourcejPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PrecisionsTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(DatejFormattedTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Publication)
                    .addComponent(LanguejComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Editeur)
                    .addComponent(EditeurjTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jLabel4.setText("Nom");

        jLabel5.setText("Prenom");

        jLabel6.setText("Naissance");

        jLabel7.setText("Mort");

        TitrejComboBox2.setModel(initTypeAuteurComboBoxModel());

        TitrejComboBox5.setModel(initTypeAuteurComboBoxModel());

        TitrejComboBox6.setModel(initTypeAuteurComboBoxModel());

        TitrejComboBox7.setModel(initTypeAuteurComboBoxModel());

        NaissancejFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));

        MortjFormattedTextField2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));

        jLabel10.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel10.setText("Auteur");

        javax.swing.GroupLayout AddAuteurjPanel1Layout = new javax.swing.GroupLayout(AddAuteurjPanel1);
        AddAuteurjPanel1.setLayout(AddAuteurjPanel1Layout);
        AddAuteurjPanel1Layout.setHorizontalGroup(
            AddAuteurjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddAuteurjPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AddAuteurjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddAuteurjPanel1Layout.createSequentialGroup()
                        .addGroup(AddAuteurjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TitrejComboBox5, 0, 108, Short.MAX_VALUE)
                            .addComponent(TitrejComboBox6, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(AddAuteurjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TitrejComboBox7, 0, 110, Short.MAX_VALUE)
                            .addComponent(TitrejComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(37, 37, 37)
                        .addGroup(AddAuteurjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddAuteurjPanel1Layout.createSequentialGroup()
                                .addGroup(AddAuteurjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(PrenomjTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                                .addGroup(AddAuteurjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(NomjTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddAuteurjPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(NaissancejFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(MortjFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(AddAuteurjPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        AddAuteurjPanel1Layout.setVerticalGroup(
            AddAuteurjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddAuteurjPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AddAuteurjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(AddAuteurjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddAuteurjPanel1Layout.createSequentialGroup()
                        .addGroup(AddAuteurjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PrenomjTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NomjTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TitrejComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(AddAuteurjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(MortjFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(AddAuteurjPanel1Layout.createSequentialGroup()
                        .addComponent(TitrejComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addGroup(AddAuteurjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TitrejComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TitrejComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(NaissancejFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddSourcejPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(AddBasejPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(CitationjPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(AddAuteurjPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AddBasejPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CitationjPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AddSourcejPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AddAuteurjPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SourcejCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SourcejCheckBox2ActionPerformed
        // TODO add your handling code here:
        checkPannels();
    }//GEN-LAST:event_SourcejCheckBox2ActionPerformed

    private void SourcejCheckBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_SourcejCheckBox2ItemStateChanged
        // TODO add your handling code here:
        checkPannels();

    }//GEN-LAST:event_SourcejCheckBox2ItemStateChanged

    private void AuteurjCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AuteurjCheckBox1ActionPerformed
        // TODO add your handling code here:
        checkPannels();

    }//GEN-LAST:event_AuteurjCheckBox1ActionPerformed

    private void AuteurjCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_AuteurjCheckBox1ItemStateChanged
        // TODO add your handling code here:
        checkPannels();

    }//GEN-LAST:event_AuteurjCheckBox1ItemStateChanged

    private void parserAuteur() {
      //  monAuteur = new Auteur();
        monAuteur.setMonNom(NomjTextField6.getText());
        monAuteur.setMonPrenom(PrenomjTextField5.getText());
        Vector<obj.Type> vt = new Vector();
        if (TitrejComboBox2.getSelectedItem().getClass() != String.class) {
            vt.add((obj.Type) TitrejComboBox2.getSelectedItem());
        }
        if (TitrejComboBox5.getSelectedItem().getClass() != String.class) {
            vt.add((obj.Type) TitrejComboBox5.getSelectedItem());
        }
        if (TitrejComboBox6.getSelectedItem().getClass() != String.class) {
            vt.add((obj.Type) TitrejComboBox6.getSelectedItem());
        }
        if (TitrejComboBox7.getSelectedItem().getClass() != String.class) {
            vt.add((obj.Type) TitrejComboBox7.getSelectedItem());
        }
        monAuteur.setMesTitres(vt);

        if (!(NaissancejFormattedTextField1.getText().equals("JJ/MM/AAAA"))) {
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                monAuteur.setMaNaissance(simpleDateFormat.parse(NaissancejFormattedTextField1.getText()));
                Graphic.imprimerTexte(1, 1, monAuteur.getMonNom() + " est né le " + monAuteur.getMaNaissance().toString());

            } catch (ParseException ex) {
                Graphic.imprimerTexte(0, 1, "Echec de lecture de la date de naissance: " + ex.getMessage());
            }
        } else {
            // monAuteur.getMaNaissance();
        }
        if (!(MortjFormattedTextField2.getText().equals("JJ/MM/AAAA"))) {
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                monAuteur.setMaMort(simpleDateFormat.parse(MortjFormattedTextField2.getText()));
                Graphic.imprimerTexte(1, 1, monAuteur.getMonNom() + " est mort le " + monAuteur.getMaMort().toString());

            } catch (ParseException ex) {
                Graphic.imprimerTexte(0, 1, "Echec de lecture de la date de mort: " + ex.getMessage());
            }
        } else {
            // monAuteur.getMaMort();
        }

    }

    private void parserCitation() {
    //    maCitation = new Citation();
        maCitation.setMonTexte(CitationjTextArea1.getText());
        maCitation.setMaLocation(LocationjTextField.getText());

        Vector<Theme> vt = new Vector();
        if (ThemejComboBox1.getSelectedItem().getClass() != String.class) {
            vt.add((Theme) ThemejComboBox1.getSelectedItem());
        }
        if (ThemejComboBox2.getSelectedItem().getClass() != String.class) {
            vt.add((Theme) ThemejComboBox2.getSelectedItem());
        }
        if (ThemejComboBox3.getSelectedItem().getClass() != String.class) {
            vt.add((Theme) ThemejComboBox3.getSelectedItem());
        }
        maCitation.setMesThemes(vt);

    }

    private void parserSource() {
      //  maSource = new Source();

        if (LanguejComboBox1.getSelectedItem().getClass() == obj.Langue.class) {
            maSource.setMaLangue((Langue) LanguejComboBox1.getSelectedItem());
        }

        Vector<obj.Type> vty = new Vector();
        if (TypeComboBox2.getSelectedItem().getClass() != String.class) {
            vty.add((obj.Type) TypeComboBox2.getSelectedItem());
        }
        if (TypejComboBox4.getSelectedItem().getClass() != String.class) {
            vty.add((obj.Type) TypejComboBox4.getSelectedItem());
        }

        maSource.setMesTypes(vty);
        maSource.setMonNom(SourcejTextField1.getText());
        maSource.setMonEditeur(EditeurjTextField1.getText());
        maSource.setMonISBN(ISBNjTextField2.getText());
        maSource.setMonURLSource(URLjTextField3.getText());
        maSource.setMesPrecisions(PrecisionsTextField4.getText());
        if (!(DatejFormattedTextField3.getText().equals("JJ/MM/AAAA"))) {
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                maSource.setMaPublication(simpleDateFormat.parse(DatejFormattedTextField3.getText()));
            } catch (ParseException ex) {
                Graphic.imprimerTexte(0, 1, "Echec de lecture de la date : " + ex.getMessage());
            }
        }
        if (!(AuteurjCheckBox1.isSelected())) {
            if (AuteurjComboBox3.getSelectedItem().getClass() != String.class) {
                monAuteur = (Auteur) AuteurjComboBox3.getSelectedItem();
                maSource.setMonAuteur(monAuteur);
                Graphic.imprimerTexte("L'auteur de la source est celui selectionné par la comboBox");
            }
        }

        maSource.setMonAuteur(monAuteur);
        maSource.seDecrire();

    }

    private void chargerCitation() {
        //   maCitation = new Citation();
        CitationjTextArea1.setText(maCitation.getMonTexte());
        LocationjTextField.setText(maCitation.getMaLocation());

        if (maCitation.getMesThemes().size() > 0) {
            ThemejComboBox1.setSelectedItem(maCitation.getMesThemes().get(0));
        }
        if (maCitation.getMesThemes().size() > 1) {
            ThemejComboBox1.setSelectedItem(maCitation.getMesThemes().get(1));
        }
        if (maCitation.getMesThemes().size() > 2) {
            ThemejComboBox1.setSelectedItem(maCitation.getMesThemes().get(2));
        }

    }

    private void chargerSource() {

        LanguejComboBox1.setSelectedItem(maSource.getMaLangue());
        if (maSource.getMesTypes().size() > 0) {
            TypeComboBox2.setSelectedItem(maSource.getMesTypes().get(0));
            //quotebase.Graphic.imprimerTexte(maSource.getMesTypes().get(0).getMonNom());
        }
        if (maSource.getMesTypes().size() > 1) {
            TypejComboBox4.setSelectedItem(maSource.getMesTypes().get(1));
            //quotebase.Graphic.imprimerTexte(maSource.getMesTypes().get(1).getMonNom());

        }
        SourcejTextField1.setText(maSource.getMonNom());
        EditeurjTextField1.setText(maSource.getMonEditeur());
        ISBNjTextField2.setText(maSource.getMonISBN());
        URLjTextField3.setText(maSource.getMonURLSource());
        PrecisionsTextField4.setText(maSource.getMesPrecisions());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        if (maSource.getMaPublication() != null) {
            DatejFormattedTextField3.setText(simpleDateFormat.format(maSource.getMaPublication()));
        }
    }

    private void chargerAuteur() {

        NomjTextField6.setText(monAuteur.getMonNom());
        PrenomjTextField5.setText(monAuteur.getMonPrenom());

        if (monAuteur.getMesTitres().size() > 0) {
            TitrejComboBox2.setSelectedItem(monAuteur.getMesTitres().get(0));
        }
        if (monAuteur.getMesTitres().size() > 1) {
            TitrejComboBox2.setSelectedItem(monAuteur.getMesTitres().get(1));
        }
        if (monAuteur.getMesTitres().size() > 2) {
            TitrejComboBox2.setSelectedItem(monAuteur.getMesTitres().get(2));
        }
        if (monAuteur.getMesTitres().size() > 3) {
            TitrejComboBox2.setSelectedItem(monAuteur.getMesTitres().get(3));
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        if (monAuteur.getMaNaissance() != null) {
            NaissancejFormattedTextField1.setText(simpleDateFormat.format(monAuteur.getMaNaissance()));
        }
        if (monAuteur.getMaMort() != null) {
            MortjFormattedTextField2.setText(simpleDateFormat.format(monAuteur.getMaMort()));
        }

    }

    private void AjouterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AjouterButtonActionPerformed
        Graphic.imprimerTitre();
        Graphic.imprimerTrait();
        parserCitation();
        maBase.MAJCitation(maCitation);
        if (SourcejCheckBox2.isSelected()) {
            Graphic.imprimerTexte("Modification des infos de la source");
            parserSource();
            maBase.MAJSource(maSource);

//        } else if (!(SourcejComboBox1.getSelectedItem().equals(monAuteur))) {
//            Graphic.imprimerTexte("Mise à jour de l'id de la source");
//
        }
        if (AuteurjCheckBox1.isSelected()) {
            Graphic.imprimerTexte("Modification des infos de l'auteur");
            parserAuteur();
            maBase.MAJAuteur(monAuteur);

//        } else if (!(AuteurjComboBox3.getSelectedItem().equals(monAuteur))) {
//            Graphic.imprimerTexte("Mise à jour de l'id d'auteur");
//
        }
        JOptionPane.showMessageDialog(null, "Vous mis à jour la citation :\n" + maCitation.getMonTexte() + "\n", "Modification", JOptionPane.OK_OPTION, icone);
        dispose();

        Graphic.imprimerTexte(1, 3, "Fin de la Modification");
        Graphic.imprimerTrait(3);


    }//GEN-LAST:event_AjouterButtonActionPerformed

    private void ReinitjButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReinitjButton1ActionPerformed
        // TODO add your handling code here:
        //        initComponents();
        dispose();

    }//GEN-LAST:event_ReinitjButton1ActionPerformed

    public void selectComboBox() {
//        checkPannels();
//        if (SourcejComboBox1.getSelectedItem().getClass() == Source.class) {
//            maSource = (Source) SourcejComboBox1.getSelectedItem();
//            AuteurjComboBox3.setSelectedItem(maSource.getMonAuteur());
//        }

//        if (AuteurjComboBox3.getSelectedItem().getClass() == Auteur.class && AuteurjComboBox3.getSelectedItem() != monAuteur) {
//            monAuteur = (Auteur) AuteurjComboBox3.getSelectedItem();
//            Vector<Source> vs = new Vector<>();
//            for (Source s : monRecueil.getMesSources()) {
//                if (s.getMonAuteur().equals(monAuteur)) {
//                    vs.add(s);
//                }
//            }
//            SourcejComboBox1.setModel(selectSourceFromAuteurComboBoxModel(vs));
//        }
    }

    private void SourcejComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SourcejComboBox1ActionPerformed


    }//GEN-LAST:event_SourcejComboBox1ActionPerformed

    private void AuteurjComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AuteurjComboBox3ActionPerformed


    }//GEN-LAST:event_AuteurjComboBox3ActionPerformed

    private void resetSource() {
        String reset = "";
        String defaultDate = "JJ/MM/AAAA";
        DatejFormattedTextField3.setText(defaultDate);
        SourcejTextField1.setText(reset);
        ISBNjTextField2.setText(reset);
        URLjTextField3.setText(reset);
        PrecisionsTextField4.setText(reset);
        EditeurjTextField1.setText(reset);
        TypeComboBox2.setModel(initTypeSourceComboBoxModel());
        TypejComboBox4.setModel(initTypeSourceComboBoxModel());
        LanguejComboBox1.setModel(initLangueComboBoxModel());

    }

    private void resetAuteur() {
        String reset = "";
        String defaultDate = "JJ/MM/AAAA";
        PrenomjTextField5.setText(reset);
        NomjTextField6.setText(reset);

        NaissancejFormattedTextField1.setText(defaultDate);
        MortjFormattedTextField2.setText(defaultDate);
        DatejFormattedTextField3.setText(defaultDate);
        TitrejComboBox2.setModel(initTypeAuteurComboBoxModel());
        TitrejComboBox5.setModel(initTypeAuteurComboBoxModel());
        TitrejComboBox6.setModel(initTypeAuteurComboBoxModel());
        TitrejComboBox7.setModel(initTypeAuteurComboBoxModel());
    }

    private void resetCitation() {
        String reset = "";
        String defaultDate = "JJ/MM/AAAA";
        LocationjTextField.setText(reset);
        CitationjTextArea1.setText(reset);
        SourcejComboBox1.setModel(initSourceComboBoxModel());
        AuteurjComboBox3.setModel(initAuteurComboBoxModel());
        ThemejComboBox1.setModel(initThemeComboBoxModel());
        ThemejComboBox2.setModel(initThemeComboBoxModel());

    }

    private void resetPannel() {
        String reset = "";
        String defaultDate = "JJ/MM/AAAA";
        monRecueil = maBase.chargerElementsCitations();

        resetCitation();
        resetSource();
        resetAuteur();

        AuteurjCheckBox1.setSelected(false);
        SourcejCheckBox2.setSelected(false);

    }

    private void checkPannels() {
        if (AuteurjCheckBox1.isSelected() == true) {
            chargerAuteur();
            AddAuteurjPanel1.setVisible(true);
        } else if (AuteurjCheckBox1.isSelected() == false) {
            AddAuteurjPanel1.setVisible(false);

            resetAuteur();
        }
        if (SourcejCheckBox2.isSelected() == true) {
            chargerSource();
            AddSourcejPanel1.setVisible(true);
        } else if (SourcejCheckBox2.isSelected() == false) {

            resetSource();
            AddSourcejPanel1.setVisible(false);

            //    AuteurjComboBox3.setModel(initAuteurComboBoxModel());
        }
             pack();
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
        Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
        int x = (int) rect.getMaxX() - this.getWidth();
        int y = (int) rect.getMaxY() - this.getHeight();
        this.setLocation(0, 0);
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
            java.util.logging.Logger.getLogger(ModifierCitation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModifierCitation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModifierCitation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModifierCitation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModifierCitation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AddAuteurjPanel1;
    private javax.swing.JPanel AddBasejPanel1;
    private javax.swing.JPanel AddSourcejPanel1;
    private javax.swing.JButton AjouterButton;
    private javax.swing.JCheckBox AuteurjCheckBox1;
    private javax.swing.JComboBox AuteurjComboBox3;
    private javax.swing.JPanel CitationjPanel1;
    private javax.swing.JTextArea CitationjTextArea1;
    private javax.swing.JFormattedTextField DatejFormattedTextField3;
    private javax.swing.JLabel Editeur;
    private javax.swing.JTextField EditeurjTextField1;
    private javax.swing.JTextField ISBNjTextField2;
    private javax.swing.JComboBox LanguejComboBox1;
    private javax.swing.JTextField LocationjTextField;
    private javax.swing.JFormattedTextField MortjFormattedTextField2;
    private javax.swing.JFormattedTextField NaissancejFormattedTextField1;
    private javax.swing.JTextField NomjTextField6;
    private javax.swing.JTextField PrecisionsTextField4;
    private javax.swing.JTextField PrenomjTextField5;
    private javax.swing.JLabel Publication;
    private javax.swing.JButton ReinitjButton1;
    private javax.swing.JCheckBox SourcejCheckBox2;
    private javax.swing.JComboBox SourcejComboBox1;
    private javax.swing.JTextField SourcejTextField1;
    private javax.swing.JComboBox ThemejComboBox1;
    private javax.swing.JComboBox ThemejComboBox2;
    private javax.swing.JComboBox ThemejComboBox3;
    private javax.swing.JComboBox TitrejComboBox2;
    private javax.swing.JComboBox TitrejComboBox5;
    private javax.swing.JComboBox TitrejComboBox6;
    private javax.swing.JComboBox TitrejComboBox7;
    private javax.swing.JComboBox TypeComboBox2;
    private javax.swing.JComboBox TypejComboBox4;
    private javax.swing.JTextField URLjTextField3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration//GEN-END:variables
}
