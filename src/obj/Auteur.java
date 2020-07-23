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
public class Auteur {

    private int monId;
    private String monNom;
    private String monPrenom;
    private Date maNaissance = null;
    private Date maMort = null;
    private Vector<Type> mesTitres;
    private String maBiographie;

    public Auteur() {
    }

    public Auteur(int monId, String monNom) {
        this.monId = monId;
        this.monNom = monNom;
    }

    public Auteur(int monId, String monNom, String monPrenom, Date maNaissance, Date maMort, Vector<Type> mesTitres, String maBiographie) {
        this.monId = monId;
        this.monNom = monNom;
        this.monPrenom = monPrenom;
        this.maNaissance = maNaissance;
        this.maMort = maMort;
        this.mesTitres = mesTitres;
        this.maBiographie = maBiographie;
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

    public String getMonPrenom() {
        if (monPrenom == null || (monPrenom.getClass() != String.class)) {
            quotebase.Graphic.imprimerTexte(0, 1, "Auteur sans prenom");
            return "";
        }
        return monPrenom;
    }

    public void setMonPrenom(String monPrenom) {
        this.monPrenom = monPrenom;
    }

    public Date getMaNaissance() {
        if (maNaissance == null) {
            quotebase.Graphic.imprimerTexte(0, 1, "Auteur sans date de naissance");
            return null;
        }
        return maNaissance;
    }

    public void setMaNaissance(Date maNaissance) {
        this.maNaissance = maNaissance;
    }

    public Date getMaMort() {
        if (maMort == null) {
            quotebase.Graphic.imprimerTexte(0, 1, "Auteur sans date de mort");
            return null;
        }
        return maMort;
    }

    public void setMaMort(Date maMort) {
        this.maMort = maMort;
    }

    public Vector<Type> getMesTitres() {
        if (mesTitres==null){
            mesTitres = new Vector<Type>();
        }
        return mesTitres;
    }

    public void setMesTitres(Vector<Type> mesTitres) {
        this.mesTitres = mesTitres;
    }

    public String getMaBiographie() {
        quotebase.Graphic.imprimerTexte("Demande de consultation de la Bio de " + monNom);
        int length = 0;
        try {
            length = maBiographie.length();
        } catch (Error e) {
            quotebase.Graphic.imprimerTexte(0, 1, "Auteur sans Bio");
            quotebase.Graphic.imprimerTexte(0, 1, e.getMessage());
        }
        if (length < 1 || maBiographie == null) {
            quotebase.Graphic.imprimerTexte(0, 1, "Auteur sans Bio");
            maBiographie = "";
        }
        return maBiographie;
    }

    public void setMaBiographie(String maBiographie) {
        this.maBiographie = maBiographie;
    }

    @Override
    public String toString() {
        String n = "";
        if (monPrenom != null) {
            n += monPrenom + " ";
        }
        n += monNom;
        return n;
    }

}
