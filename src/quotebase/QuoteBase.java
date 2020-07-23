/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quotebase;

import frame.AjoutCitation;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import obj.Auteur;
import obj.Avis;
import obj.Citation;
import obj.Langue;
import obj.Recueil;
import obj.Source;
import obj.Theme;
import obj.Type;

/**
 *
 * @author max
 */
public class QuoteBase implements Graphic {

    /**
     * @param args the command line arguments
     */
    private String username;
    private String server;
    private String password;
    private String database;

    public QuoteBase() {

        this.username = "sa";
        this.server = "localhost:1433";
        this.password = "";
        this.database = "QuoteBasev1";
    }

    public QuoteBase(String username, String server, String password, String database) {
        this.username = username;
        this.server = server;
        this.password = password;
        this.database = database;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

//    [X][>] xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
//                      Methodes de chargement
//    [X][>] xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx     
    public Recueil chargerCitations(Recueil monReceuil) {
        Connection con = null;
        Vector<Citation> mesCitations = new Vector<Citation>();
        String connectionUrl = "jdbc:sqlserver://" + server + ";"
                + "database=" + database + ";"
                + "user=" + username + ";"
                + "password=" + password + ";";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            con = DriverManager.getConnection(connectionUrl);

            Graphic.imprimerTexte("Connecté à la base de données.");

            Graphic.imprimerTexte("Chargement des Citations");
            String SQL = "select C.CitationId, C.Texte, C.Location, C.SourceId\n"
                    + "from Citation C";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                Source s = null;
                int sourceId = rs.getInt(4);
                for (Source sou : monReceuil.getMesSources()) {
                    if (sou.getMonId() == sourceId) {
                        s = sou;
                    }
                }

                Citation c = new Citation(rs.getInt(1), rs.getString(2), s);
                if (rs.getString(4) != null) {
                    c.setMaLocation(rs.getString(3));
                }
                mesCitations.add(c);
                //  Graphic.imprimerTexte(c.getMonTexte());
            }
            monReceuil.setMesCitations(mesCitations);
            Graphic.imprimerTexte(1, 3, "Chargement des citations terminé.");
        } catch (Exception e) {
            Graphic.imprimerTexte(0, 3, "Echec du chargement du Receuil de citations : " + e.getMessage() + " " + e.getLocalizedMessage());
        }

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            con = DriverManager.getConnection(connectionUrl);

            Graphic.imprimerTexte("Connecté à la base de données.");

            Graphic.imprimerTexte("Chargement des Themes");
            String SQL = "select ThemeId, CitationId from THEME_CITATION order by ThemeId";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            int themeId = 0;
            int citationId = 0;
            while (rs.next()) {
                themeId = rs.getInt(1);
                citationId = rs.getInt(2);
                for (Citation c : monReceuil.getMesCitations()) {
                    if (c.getMonId() == citationId) {
                        Vector<Theme> vt = c.getMesThemes();

                        for (Theme t : monReceuil.getMesThemes()) {
                            if (t.getMonId() == themeId) {
                                vt.add(t);
                                c.setMesThemes(vt);
                            }
                        }
                    }
                }

            }

            Graphic.imprimerTexte(1, 3, "Chargement des themes dans les citations terminé.");

        } catch (Exception ex) {
            Logger.getLogger(QuoteBase.class.getName()).log(Level.SEVERE, null, ex);
            Graphic.imprimerTexte(0, 3, "Echec du chargement des thèmes : " + ex.getMessage() + " " + ex.getLocalizedMessage());
        } catch (Error er) {
            Graphic.imprimerTexte(0, 3, "Echec du chargement des thèmes : " + er.getMessage() + " " + er.getLocalizedMessage());
        }

        Graphic.imprimerTitre();
        close(con);
        Graphic.imprimerTrait();

        return monReceuil;
    }

    public Source chargerUneSource(int sourceId, Vector<Auteur> mesAuteurs, Vector<Type> mesTypes) {
        Connection con = connect();
        Source s = new Source();
        try {
            Graphic.imprimerTexte("Chargement des infos d'une source");
            String SQL = "SELECT s.SourceId, s.Nom, s.Publication, s.Editeur, s.ISBN, s.Precisions, s.URLsource, s.Langue, A.AuteurId FROM Source s\n"
                    + "LEFT JOIN AUTEUR A on S.AuteurId = A.AuteurId\n"
                    + "where s.SourceId = " + sourceId;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                s.setMonId(rs.getInt("SourceId"));
                s.setMonNom(rs.getString("Nom"));
                s.setMaLangue(new Langue(rs.getString("Langue")));
                for (Auteur a : mesAuteurs) {
                    if (a.getMonId() == rs.getInt("AuteurId")) {
                        s.setMonAuteur(a);
                    }
                }
                s.setMaPublication(rs.getDate("Publication"));
                s.setMesPrecisions(rs.getString("Precisions"));
                s.setMonEditeur(rs.getString("Editeur"));
                s.setMonURLSource(rs.getString("URLsource"));
                s.setMonISBN(rs.getString("ISBN"));
                s.seDecrire();

                Graphic.imprimerTexte("Jointure Source - Type");
                SQL = "select TypeId, SourceId from TYPE_SOURCE where SourceId = " + sourceId;
                stmt = con.createStatement();
                rs = stmt.executeQuery(SQL);
                while (rs.next()) {
                    for (Type t : mesTypes) {
                        if (t.getMonId() == rs.getInt("TypeId")) {
                            Vector<Type> vt = s.getMesTypes();
                            vt.add(t);
                            s.setMesTypes(vt);
                        }
                    }

                }

            }
        } catch (Exception e) {
            Graphic.imprimerTexte(0, 3, "Echec du chargement d'une citation : " + e.getMessage() + " " + e.getLocalizedMessage());
        }
        close(con);
        return s;
    }

    public Recueil chargerElementsCitations() {
        Recueil r = new Recueil();
        Connection con = null;
        String tokenConsole = "-------- ";
        String sortieConsole = tokenConsole;
        Vector<Citation> mesCitations = new Vector<Citation>();
        Vector<Auteur> mesAuteurs = new Vector<Auteur>();
        Vector<Source> mesSources = new Vector<Source>();
        Vector<Theme> mesThemes = new Vector<Theme>();
        Vector<Type> mesTypes = new Vector<Type>();
        Vector<Langue> mesLangues = new Vector<Langue>();
        Vector<Avis> mesAvis = new Vector<Avis>();

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "jdbc:sqlserver://" + server + ";"
                    + "database=" + database + ";"
                    + "user=" + username + ";"
                    + "password=" + password + ";";
            con = DriverManager.getConnection(connectionUrl);

            Graphic.imprimerTexte("Connecté à la base de données.");

            Graphic.imprimerTexte("Chargement des Types");
            String SQL = "SELECT TypeId, Nom, Description FROM Type order by TypeId";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                obj.Type t = new obj.Type();
                t.setMonId(rs.getInt(1));
                t.setMonNom(rs.getString(2));
                t.setMaDescription(rs.getString(3));
                mesTypes.add(t);
                sortieConsole += t.getMonNom() + " - ";
            }
            r.setMesTypes(mesTypes);
            Graphic.imprimerTexte(sortieConsole);
            sortieConsole = tokenConsole;

            Graphic.imprimerTexte("Chargement des Auteurs");
            SQL = "SELECT AuteurId, Nom, Prenom, Date_Naissance, Date_Deces, Biographie FROM Auteur order by Nom";
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                Auteur a = new Auteur();
                a.setMonId(rs.getInt("AuteurId"));
                a.setMonNom(rs.getString(2));
                if (rs.getString("Prenom") != null) {
                    a.setMonPrenom(rs.getString(3));
                }

                a.setMaNaissance(rs.getDate("Date_Naissance"));
                a.setMaMort(rs.getDate("Date_Deces"));

                mesAuteurs.add(a);
                sortieConsole += a.toString() + " - ";
            }
            r.setMesAuteurs(mesAuteurs);
            Graphic.imprimerTexte(sortieConsole);
            sortieConsole = tokenConsole;

            Graphic.imprimerTexte("Jointure Auteur - Type");
            SQL = "select TypeId, AuteurId from TYPE_AUTEUR order by AuteurId";
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                int auteurId = rs.getInt(2);
                int typeId = rs.getInt(1);
                //        Graphic.imprimerTexte(1,3,"Debut des boucles d'éssai de jointure");
                for (Auteur a : r.getMesAuteurs()) {
                    if (a.getMonId() == auteurId) {
                        Vector<Type> v = a.getMesTitres();

                        for (Type t : mesTypes) {
                            if (t.getMonId() == typeId) {
                                v.add(t);
                                a.setMesTitres(v);
                                sortieConsole += " - " + a.toString() + " : " + t.getMonNom() + " - ";

                            }
                        }
                    }
                }

            }
            Graphic.imprimerTexte(sortieConsole);
            sortieConsole = tokenConsole;

            Graphic.imprimerTexte("Chargement des Langues");
            SQL = "SELECT * FROM Langue";
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                Langue l = new Langue();
                l.setMaLangue(rs.getString("Langue"));
                mesLangues.add(l);
                sortieConsole += l.getMaLangue() + " - ";
            }
            r.setMesLangues(mesLangues);
            Graphic.imprimerTexte(sortieConsole);
            sortieConsole = tokenConsole;

            Graphic.imprimerTexte("Chargement des Sources");
            SQL = "SELECT s.SourceId, s.Nom, s.Langue, A.AuteurId FROM Source s\n"
                    + "LEFT JOIN AUTEUR A on s.AuteurId = A.AuteurId\n"
                    + "order by s.Nom";
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                Source s = new Source();
                s.setMonId(rs.getInt("SourceId"));
                s.setMonNom(rs.getString("Nom"));
                s.setMaLangue(new Langue(rs.getString("Langue")));
                for (Auteur a : mesAuteurs) {
                    if (a.getMonId() == rs.getInt("AuteurId")) {
                        s.setMonAuteur(a);
                    }
                }
                mesSources.add(s);
                sortieConsole += s.getMonNom() + " -par " + s.getMonAuteur().toString() + "     -----     ";
            }
            r.setMesSources(mesSources);
            Graphic.imprimerTexte(sortieConsole);
            sortieConsole = tokenConsole;

            Graphic.imprimerTexte("Jointure Source - Type");
            SQL = "select TypeId, SourceId from TYPE_SOURCE order by SourceId";
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                int sourceId = rs.getInt(2);
                int typeId = rs.getInt(1);
                //        Graphic.imprimerTexte(1,3,"Debut des boucles d'éssai de jointure");
                for (Source s : r.getMesSources()) {
                    if (s.getMonId() == sourceId) {
                        Vector<Type> v = s.getMesTypes();

                        for (Type t : mesTypes) {
                            if (t.getMonId() == typeId) {
                                v.add(t);
                                s.setMesTypes(v);
                                sortieConsole += " - " + s.toString() + " : " + t.getMonNom() + " - ";

                            }
                        }
                    }
                }

            }
            Graphic.imprimerTexte(sortieConsole);
            sortieConsole = tokenConsole;

            Graphic.imprimerTexte("Chargement des Themes");
            SQL = "SELECT * FROM Type where TypeId > 2000 and typeId < 3000";
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                Theme t = new Theme();
                t.setMonId(rs.getInt(1));
                t.setMonNom(rs.getString(2));
                mesThemes.add(t);
                sortieConsole += t.getMonNom() + " - ";
            }
            r.setMesThemes(mesThemes);
            Graphic.imprimerTexte(sortieConsole);
            sortieConsole = tokenConsole;

            Graphic.imprimerTexte(1, 3, "Réussite du chargement des elements de Recueil : ");
        } catch (Exception e) {
            Graphic.imprimerTexte(0, 3, "Echec du chargement des elements du Recueil : " + e.getMessage() + " " + e.getLocalizedMessage());
        }
        Graphic.imprimerTitre();
        close(con);
        Graphic.imprimerTrait();

        return r;

    }

      public Vector<Auteur> chargerAuteur() {

        Vector<Auteur> mesAuteurs = new Vector<>();
        try {
            Connection con = connect();
            Graphic.imprimerTexte("Chargement des Types");
            
                     Graphic.imprimerTexte("Chargement des Auteurs");
            String SQL = "SELECT AuteurId, Nom, Prenom, Date_Naissance, Date_Deces, Biographie FROM Auteur order by Nom";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                Auteur a = new Auteur();
                a.setMonId(rs.getInt("AuteurId"));
                a.setMonNom(rs.getString(2));
                if (rs.getString("Prenom") != null) {
                    a.setMonPrenom(rs.getString(3));
                }

                a.setMaNaissance(rs.getDate("Date_Naissance"));
                a.setMaMort(rs.getDate("Date_Deces"));

                mesAuteurs.add(a);
            }
            
            
            close(con);
        } catch (Exception e) {
            Graphic.imprimerTexte(0, 3, "Echec du chargement des Types : " + e.getMessage() + " " + e.getLocalizedMessage());
        }

        return mesAuteurs;
    }
    
    public Vector<Type> chargerTypes(int cat) {

        Vector<Type> mesTypes = new Vector<>();
        try {
            Connection con = connect();
            Graphic.imprimerTexte("Chargement des Types");
            String SQL = "SELECT TypeId, Nom, Description FROM Type order by TypeId";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                obj.Type t = new obj.Type();
                t.setMonId(rs.getInt(1));
                t.setMonNom(rs.getString(2));
                t.setMaDescription(rs.getString(3));
                mesTypes.add(t);
            }
            close(con);
        } catch (Exception e) {
            Graphic.imprimerTexte(0, 3, "Echec du chargement des Types : " + e.getMessage() + " " + e.getLocalizedMessage());
        }

        return mesTypes;
    }

    public String chargerTexteCitation() {
        String s = "";
        StringBuilder sb = new StringBuilder();
        try {
            Connection con = connect();
            Graphic.imprimerTexte("Chargement des textes de Citations");
            String SQL = "SELECT Texte FROM Citation";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                sb.append(rs.getString(1));
                sb.append(" ");
                //  sb.append(""+ System.getProperty("line.separator"));
            }
            close(con);
        } catch (Exception e) {
            Graphic.imprimerTexte(0, 3, "Echec du chargement des textes de Citation : " + e.getMessage() + " " + e.getLocalizedMessage());
        }

        return sb.toString();
    }

    public String chargerTexteCitation(Auteur monAuteur) {
        String s = "";
        StringBuilder sb = new StringBuilder();
        try {
            Connection con = connect();
            Graphic.imprimerTexte("Chargement des textes de Citations de l'auteur " + monAuteur.toString());
            String SQL = "                    SELECT c.Texte \n"
                    + "FROM Citation c\n"
                    + "LEFT JOIN Source s on c.SourceId = s.SourceId\n"
                    + "where S.AuteurId = " + monAuteur.getMonId();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                sb.append(rs.getString(1));
                sb.append(" ");
                //  sb.append(""+ System.getProperty("line.separator"));
            }
            close(con);
        } catch (Exception e) {
            Graphic.imprimerTexte(0, 3, "Echec du chargement des textes de Citation avec selection d'Auteur: " + e.getMessage() + " " + e.getLocalizedMessage());
        }

        return sb.toString();
    }

//    [X][>] xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
//                       Methodes de Mise A Jour 
//    [X][>] xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx    
    public void MAJType(obj.Type monType, int maCat) {
        Connection con = connect();
        ResultSet rs;
        String SQL;
        int l;
        PreparedStatement ps;

        try {
            Graphic.imprimerTexte("Mise à jour d'un type");
            SQL = "update Type\n"
                    + "set Nom = ?,\n"
                    + "Description = ?\n"
                    + "where TypeId = ?";
            ps = con.prepareStatement(SQL);

            ps.setString(1, monType.getMonNom());
            ps.setString(2, monType.getMaDescription());
            ps.setInt(3, monType.getMonId());

            l = ps.executeUpdate();
            Graphic.imprimerTrait();
            Graphic.imprimerTexte(1, 3, l + " Reussite de la mise à jour d'un type : " + monType.getMonNom());

        } catch (Exception e) {
            Graphic.imprimerTexte(0, 3, "Echec de la mise à jour d'un type : " + e.getMessage());
        }
    }

    public void MAJCitation(Citation maCitation) {
        Connection con = connect();
        ResultSet rs;
        String SQL;
        int l;
        PreparedStatement ps;

        try {
            Graphic.imprimerTexte("Mise à jour d'une citation.");
            SQL = "update Citation\n"
                    + "set Location = ?,\n"
                    + "Texte = ?\n"
                    + "where CitationId = ?";
            ps = con.prepareStatement(SQL);

            ps.setString(1, maCitation.getMaLocation());
            ps.setString(2, maCitation.getMonTexte());
            ps.setInt(3, maCitation.getMonId());

            l = ps.executeUpdate();
            Graphic.imprimerTrait();
            Graphic.imprimerTexte(1, 3, "Reussite de la mise à jour d'une citation : " + maCitation.getMonTexte());

        } catch (Exception e) {
            Graphic.imprimerTexte(0, 3, "Echec de la mise à jour d'une citation : " + e.getMessage());
        }
    }

    public void MAJAuteur(Auteur monAuteur) {
        Connection con = connect();
        ResultSet rs;
        String SQL;
        int l;
        PreparedStatement ps;

        try {
            Graphic.imprimerTexte("Mise à jour de l'auteur.");
            SQL = "update Auteur\n"
                    + "set Nom = ?,\n"
                    + "Prenom = ?,\n"
                    + "Date_Naissance = ?,\n"
                    + "Date_Deces = ?\n"
                    + "where AuteurId = ?";
            ps = con.prepareStatement(SQL);

            ps.setString(1, monAuteur.getMonNom());
            ps.setString(2, monAuteur.getMonPrenom());
            if (monAuteur.getMaNaissance() == null) {
                ps.setNull(3, java.sql.Types.DATE);
            } else {
                Graphic.imprimerTexte(1, 1, "Auteur avec Date de Naissance : " + monAuteur.getMaNaissance());
                ps.setDate(3, (new java.sql.Date(monAuteur.getMaNaissance().getTime())));
            }

            if (monAuteur.getMaMort() == null) {
                ps.setNull(4, java.sql.Types.DATE);
            } else {
                Graphic.imprimerTexte(1, 1, "Auteur avec Date de Mort : " + monAuteur.getMaMort());
                ps.setDate(4, (new java.sql.Date(monAuteur.getMaMort().getTime())));
            }

            ps.setInt(5, monAuteur.getMonId());

            l = ps.executeUpdate();
            Graphic.imprimerTrait();
            Graphic.imprimerTexte(1, 3, "Reussite de la mise à jour d'un Auteur : " + monAuteur.toString() + " - id = " + monAuteur.getMonId());

        } catch (Exception e) {
            Graphic.imprimerTexte(0, 3, "Echec de la mise à jour d'un Auteur : " + e.getMessage());
        }

    }

    public void MAJSource(Source maSource) {
        Graphic.imprimerTexte("ToDo");

    }

//    [X][>] xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
//                            Methodes d'ajout 
//    [X][>] xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx     
    public void ajouterUnType(obj.Type monType, int maCat) {
        Connection con = connect();
        ResultSet rs;
        String SQL;
        int l;
        PreparedStatement ps;
        int min = maCat * 1000;
        int max = (maCat + 1) * 1000;
        int newId = -1;

        try {
            SQL = "select TOP 1 TypeId from type \n"
                    + "where \n"
                    + "TypeId > " + min + "\n"
                    + "and \n"
                    + "TypeId < " + max + "\n"
                    + "order by TypeId desc";

            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                newId = rs.getInt("TypeId") + 1;
            }
        } catch (Exception e) {
            Graphic.imprimerTexte(0, 3, "Echec de la récupération du nouveau TypeId : " + e.getMessage());
        }
        try {
            SQL = "INSERT INTO Type\n"
                    + "([TypeId],[Nom],[Description])\n"
                    + "VALUES(?, ?, ?)";
            ps = con.prepareStatement(SQL);

            ps.setInt(1, newId);
            ps.setString(2, monType.getMonNom());
            ps.setString(3, monType.getMaDescription());

            l = ps.executeUpdate();
            Graphic.imprimerTexte(1, 3, "Reussite de l'ajout d'un type : " + monType.getMonNom() + " - Id =  " + newId + " - " + l);
            Graphic.imprimerTrait();

        } catch (Exception e) {
            Graphic.imprimerTexte(0, 3, "Echec de l'ajout d'un type : " + e.getMessage());
        }

    }

    public void ajouterCitation(Citation maCitation) {
        Connection con = connect();
        ResultSet rs;
        String SQL;
        int l;
        PreparedStatement ps;

        try {

//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            String connectionUrl = "jdbc:sqlserver://" + server + ";"
//                    + "database=" + database + ";"
//                    + "user=" + username + ";"
//                    + "password=" + password + ";";
//            con = DriverManager.getConnection(connectionUrl);
            Graphic.imprimerTexte("Ajout d'une citation.");

            SQL = "INSERT INTO Citation\n"
                    + "([Texte],[Location],[SourceId], [TypeId])\n"
                    + "VALUES\n"
                    + "(?,?,?,3001)";
            ps = con.prepareStatement(SQL);
            ps.setString(1, maCitation.getMonTexte());
            if (maCitation.getMaLocation() == null || maCitation.getMaLocation().equals("")) {
                ps.setNull(2, java.sql.Types.VARCHAR);
            } else {
                ps.setString(2, maCitation.getMaLocation());
            }
            ps.setInt(3, maCitation.getMaSource().getMonId());

            l = ps.executeUpdate();
            Graphic.imprimerTrait();
            Graphic.imprimerTexte(1, 3, "Reussite de l'ajout d'une citation : " + maCitation.getMonTexte());

        } catch (Exception e) {
            Graphic.imprimerTexte(0, 3, "Echec de l'ajout d'une citation : " + e.getMessage());
        }

        try {
            Graphic.imprimerTexte("Recupération de l'Id le plus haut de la table des Citations");
            SQL = "select TOP(1) CitationId from Citation order by CitationId desc";
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                maCitation.setMonId(rs.getInt(1));
                // Graphic.imprimerTexte(maCitation.getMonTexte() + " - Id " + maCitation.getMonId());
            }

            Graphic.imprimerTexte("Mise à jour de la table de jointure - Theme - Citation.");
            for (obj.Theme t : maCitation.getMesThemes()) {
                SQL = "INSERT INTO THEME_CITATION \n"
                        + "([ThemeId],[CitationId])\n"
                        + "VALUES(?,?)";
                ps = con.prepareStatement(SQL);
                ps.setInt(2, maCitation.getMonId());
                ps.setInt(1, t.getMonId());
                l = ps.executeUpdate();
                Graphic.imprimerTexte(1, 1, "Ajout jointure du theme " + t.getMonNom());
            }
        } catch (Exception e) {
            Graphic.imprimerTexte(0, 3, "Echec des jointure des themes pour la citation : " + e.getMessage());
        }

        close(con);

    }

    public void ajouterCitation(Citation maCitation, Source maSource) {
        Connection con = null;
        ResultSet rs;
        String SQL;
        int l;
        PreparedStatement ps;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "jdbc:sqlserver://" + server + ";"
                    + "database=" + database + ";"
                    + "user=" + username + ";"
                    + "password=" + password + ";";
            con = DriverManager.getConnection(connectionUrl);

            Graphic.imprimerTexte(1, 1, "Connecté à la base de données pour l'ajout d'une source : ");
            String langue = maSource.getMaLangue().getMaLangue();
            Graphic.imprimerTexte(maSource.getMonNom() + " - " + langue);

            SQL = "INSERT INTO Source\n"
                    + "([Nom],[Publication], [Editeur], [ISBN], [Precisions], [URLsource],[Langue], [AuteurId])\n"
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(SQL);

            ps.setString(1, maSource.getMonNom());

            if (maSource.getMaPublication() == null) {
                ps.setNull(2, java.sql.Types.DATE);
                Graphic.imprimerTexte(0, "Pas de date de publication");

            } else {
                ps.setDate(2, new java.sql.Date(maSource.getMaPublication().getTime()));
                Graphic.imprimerTexte(1, "Insertion de la date de publication");

            }

            if (maSource.getMonEditeur().length() > 0) {
                ps.setString(3, maSource.getMonEditeur());
            } else {
                ps.setNull(3, java.sql.Types.VARCHAR);
            }

            if (maSource.getMonISBN().length() > 0) {
                ps.setString(4, maSource.getMonISBN());
            } else {
                ps.setNull(4, java.sql.Types.VARCHAR);
            }

            if (maSource.getMesPrecisions().length() > 0) {
                ps.setString(5, maSource.getMesPrecisions());
            } else {
                ps.setNull(5, java.sql.Types.VARCHAR);
            }

            if (maSource.getMonURLSource().length() > 0) {
                ps.setString(6, maSource.getMonURLSource());
            } else {
                ps.setNull(6, java.sql.Types.VARCHAR);
            }

            if (maSource.getMaLangue().getClass() != obj.Langue.class
                    || maSource.getMaLangue().getMaLangue().equals("")) {
                ps.setNull(7, java.sql.Types.VARCHAR);
            } else {
                ps.setString(7, maSource.getMaLangue().getMaLangue());
            }

            ps.setInt(8, maSource.getMonAuteur().getMonId());

            l = ps.executeUpdate();

            Graphic.imprimerTexte("Recupération de l'Id le plus haut de la table des Sources");
            SQL = "select TOP(1) SourceId from source order by SourceId desc";
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                maSource.setMonId(rs.getInt(1));
                Graphic.imprimerTexte(maSource.getMonNom() + " - Id " + maSource.getMonId());
            }
//
//            Graphic.imprimerTexte("Mise à jour de la table de jointure - Auteur - Source.");
//            Graphic.imprimerTexte(maSource.getMonAuteur().toString() + " - " + maSource.getMonAuteur().getMonId());
//
//            SQL = "INSERT INTO AUTEUR_SOURCE \n"
//                    + "([SourceId],[AuteurId])\n"
//                    + "VALUES(?,?)";
//            ps = con.prepareStatement(SQL);
//            ps.setInt(1, maSource.getMonId());
//            ps.setInt(2, maSource.getMonAuteur().getMonId());
//            l = ps.executeUpdate();
//            Graphic.imprimerTexte(1, 3, "Ajout d'une source");

            Graphic.imprimerTexte("Mise à jour de la table de jointure - Type - Source.");
            for (obj.Type t : maSource.getMesTypes()) {
                SQL = "INSERT INTO TYPE_SOURCE \n"
                        + "([SourceId],[TypeId])\n"
                        + "VALUES(?,?)";
                ps = con.prepareStatement(SQL);
                ps.setInt(1, maSource.getMonId());
                ps.setInt(2, t.getMonId());
                l = ps.executeUpdate();
                Graphic.imprimerTexte(1, 3, "Ajout jointure du types " + t.getMonNom());
            }

        } catch (Exception e) {
            Graphic.imprimerTexte(0, 3, "Echec de l'ajout de la source - " + e.getMessage());
        }
        close(con);

        maCitation.setMaSource(maSource);

        ajouterCitation(maCitation);
//
//        try {
//            maCitation.setMaSource(maSource);
//
//            Graphic.imprimerTexte("Ajout d'une nouvelle Citation lié à la source " + maCitation.getMaSource().getMonId() + " : \"" + maCitation.getMonTexte() + "\" - " + maCitation.getMaLocation());
//            SQL = "INSERT INTO Citation\n"
//                    + "([Texte],[Location],[SourceId])\n"
//                    + "VALUES\n"
//                    + "(?,?,?)";
//            ps = con.prepareStatement(SQL);
//            ps.setString(1, maCitation.getMonTexte());
//            if (maCitation.getMaLocation() == null || maCitation.getMaLocation().equals("")) {
//                ps.setNull(2, java.sql.Types.VARCHAR);
//            } else {
//                ps.setString(2, maCitation.getMaLocation());
//            }
//            ps.setInt(3, maCitation.getMaSource().getMonId());
//
//            l = ps.executeUpdate();
//
//            Graphic.imprimerTexte(1, 3, "Ajout d'une citation");
//            close(con);
//        } catch (Exception e) {
//            Graphic.imprimerTexte(0, 3, "Echec de l'ajout de la citation - " + e.getMessage());
//        }
        Graphic.imprimerTrait();
    }

    public void ajouterCitation(Citation maCitation, Source maSource, Auteur monAuteur) {
        Connection con = null;
        ResultSet rs;
        String SQL;
        int l;
        PreparedStatement ps;

        try {
            con = connect();

            SQL = "INSERT INTO Auteur\n"
                    + "([Nom],[Prenom],[Date_Naissance],[Date_Deces])\n"
                    + "VALUES(?,?,?,?)";
            ps = con.prepareStatement(SQL);
            ps.setString(1, monAuteur.getMonNom());

            if (monAuteur.getMonPrenom() == null) {
                //  Graphic.imprimerTexte(0, 1, "Auteur sans Prenom");
                ps.setNull(2, java.sql.Types.VARCHAR);
            } else {
                ps.setString(2, monAuteur.getMonPrenom());
            }

            if (monAuteur.getMaNaissance() == null) {
                ps.setNull(3, java.sql.Types.DATE);
            } else {
                Graphic.imprimerTexte(1, 1, "Auteur avec Date de Naissance : " + monAuteur.getMaNaissance());
                ps.setDate(3, (new java.sql.Date(monAuteur.getMaNaissance().getTime())));
            }

            if (monAuteur.getMaMort() == null) {
                ps.setNull(4, java.sql.Types.DATE);
            } else {
                Graphic.imprimerTexte(1, 1, "Auteur avec Date de Mort : " + monAuteur.getMaMort().getTime());
                ps.setDate(4, (new java.sql.Date(monAuteur.getMaMort().getTime())));
            }

//            Graphic.imprimerTexte(0, 1, monAuteur.getMaBiographie());
//
//            if (monAuteur.getMaBiographie().length() < 1) {
//                Graphic.imprimerTexte(0, 1, "Auteur sans Biographie");
//                ps.setNull(5, java.sql.Types.VARCHAR);
//            } else {
//                Graphic.imprimerTexte(1, 1, "Insertion de la Biographie");
//                ps.setString(5, monAuteur.getMaBiographie());
//            }
            l = ps.executeUpdate();
            Graphic.imprimerTexte(1, 1, "Ajout d'un auteur : " + monAuteur.toString());

            Graphic.imprimerTexte("Recupération de l'Id le plus haut de la table des Auteur");
            SQL = "select TOP(1) AuteurId from Auteur order by AuteurId desc";
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                monAuteur.setMonId(rs.getInt(1));
                Graphic.imprimerTexte(monAuteur.toString() + " - Id " + monAuteur.getMonId());
            }
            maSource.setMonAuteur(monAuteur);

            Graphic.imprimerTexte("Mise à jour de la table de jointure - Type - Auteur.");
            for (obj.Type t : monAuteur.getMesTitres()) {
                SQL = "INSERT INTO TYPE_Auteur \n"
                        + "([TypeId],[AuteurId])\n"
                        + "VALUES(?,?)";
                ps = con.prepareStatement(SQL);

                ps.setInt(2, monAuteur.getMonId());
                ps.setInt(1, t.getMonId());
                l = ps.executeUpdate();
                Graphic.imprimerTexte(1, 3, "Ajout jointure du types " + t.getMonNom());
            }

        } catch (Exception e) {
            Graphic.imprimerTexte(0, 3, "Echec de l'ajout d'un nouvel Auteur - " + e.getMessage());
        }

        ajouterCitation(maCitation, maSource);

    }

//    [X][>] xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
//                       Methodes de connections
//    [X][>] xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx    
    public static void close(Connection con) {
        try {
            con.close();
            Graphic.imprimerTexte(1, 1, "Connection fermée");
            Graphic.imprimerHeure(PAUSE);
        } catch (SQLException ex) {
            Graphic.imprimerTexte(0, 3, "Echec de la fermeture de la connection" + ex.getMessage());
        }
    }

    public Connection connect() {
        Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "jdbc:sqlserver://" + server + ";"
                    + "database=" + database + ";"
                    + "user=" + username + ";"
                    + "password=" + password + ";";
            con = DriverManager.getConnection(connectionUrl);

            Graphic.imprimerTexte(1, 3, "Connecté à la base de données.");
//
            Statement stmt = con.createStatement();

        } catch (Exception e) {
            Graphic.imprimerTexte(0, 3, "Echec de la connexion" + e.getMessage());
        }
        return con;
    }

}
