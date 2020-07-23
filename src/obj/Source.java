/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obj;

import java.util.Date;
import java.util.Vector;

/**
 *
 * @author max
 */
public class Source {

    private int monId;
    private String monNom;
    private String monEditeur;
    private String mesPrecisions;
    private String monISBN;
    private String monURLSource;
    private Langue maLangue;
    private Vector<Type> mesTypes;
    private Auteur monAuteur;

    private Vector<Auteur> mesAuteurs;
    private Date maPublication;

    public Source() {
    }

    public Source(int monId, String monNom, Langue maLangue, Vector<Type> mesTypes, Auteur monAuteur) {
        this.monId = monId;
        this.monNom = monNom;
        this.maLangue = maLangue;
        this.mesTypes = mesTypes;
        this.monAuteur = monAuteur;

    }

    public Source(int monId, String monNom, String monEditeur, String mesPrecisions, String monISBN, String monURLSource, Langue maLangue, Vector<Type> mesTypes, Date maPublication) {
        this.monId = monId;
        this.monNom = monNom;
        this.monEditeur = monEditeur;
        this.mesPrecisions = mesPrecisions;
        this.monISBN = monISBN;
        this.monURLSource = monURLSource;
        this.maLangue = maLangue;
        this.mesTypes = mesTypes;
        this.maPublication = maPublication;
    }

    public int getMonId() {
        return monId;
    }

    public void setMonId(int monId) {
        this.monId = monId;
    }

    public String getMonNom() {
        return monNom;
    }

    public void setMonNom(String monNom) {
        this.monNom = monNom;
    }

    public String getMonEditeur() {
        return monEditeur;
    }

    public void setMonEditeur(String monEditeur) {
        this.monEditeur = monEditeur;
    }

    public String getMesPrecisions() {
        return mesPrecisions;
    }

    public void setMesPrecisions(String mesPrecisions) {
        this.mesPrecisions = mesPrecisions;
    }

    public String getMonISBN() {
        return monISBN;
    }

    public void setMonISBN(String monISBN) {
        this.monISBN = monISBN;
    }

    public String getMonURLSource() {
        return monURLSource;
    }

    public void setMonURLSource(String monURLSource) {
        this.monURLSource = monURLSource;
    }

    public Langue getMaLangue() {
        if (maLangue == null || maLangue.getMaLangue().equals("") || maLangue.equals("")) {
            quotebase.Graphic.imprimerTexte(0, 1, "VOTRE SOURCE N'A PAS DE LANGUE");
            setMaLangue(new Langue("Français"));
            quotebase.Graphic.imprimerTexte("Le français est choisi par defaut");
        }
        return maLangue;
    }

    public void setMaLangue(Langue maLangue) {
        this.maLangue = maLangue;
    }

    public Vector<Type> getMesTypes() {
        if (mesTypes == null) {
            mesTypes = new Vector<Type>();
        }
        return mesTypes;
    }

    public void setMesTypes(Vector<Type> mesTypes) {
        this.mesTypes = mesTypes;
    }

    public Date getMaPublication() {
//        if (maPublication == null){
//            return new Date();
//        }
        return maPublication;
    }

    public void setMaPublication(Date maPublication) {
        this.maPublication = maPublication;
    }

    public Vector<Auteur> getMesAuteurs() {
        return mesAuteurs;
    }

    public void setMesAuteurs(Vector<Auteur> mesAuteurs) {
        this.mesAuteurs = mesAuteurs;
    }

    public Auteur getMonAuteur() {
        return monAuteur;
    }

    public void setMonAuteur(Auteur monAuteur) {
        this.monAuteur = monAuteur;
    }

    public String seDecrire() {
        StringBuilder sd = new StringBuilder();

        sd.append(quotebase.Graphic.imprimerTrait());
        sd.append(quotebase.Graphic.imprimerTexte(getMonNom()));
        sd.append(quotebase.Graphic.imprimerTexte(getMonISBN()));
        sd.append(quotebase.Graphic.imprimerTexte(getMonEditeur()));
        sd.append(quotebase.Graphic.imprimerTexte(getMonURLSource()));
        sd.append(quotebase.Graphic.imprimerTexte(getMesPrecisions()));
        if (getMaPublication() != null) {
            sd.append(quotebase.Graphic.imprimerTexte(getMaPublication().toString()));
        }
        sd.append(quotebase.Graphic.imprimerTexte(getMaLangue().getMaLangue()));
        sd.append(quotebase.Graphic.imprimerTexte(getMonAuteur().toString()));
        for (Type t : getMesTypes()) {
            sd.append(quotebase.Graphic.imprimerTexte(t.getMonNom()));

        }
        return sd.toString();
    }

    @Override
    public String toString() {
        return getMonNom();
    }

}
