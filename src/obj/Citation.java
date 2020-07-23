/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obj;

import java.util.Vector;

/**
 *
 * @author max
 */
public class Citation {

    private int monId;
    private String monTexte;
    private String maLocation;
    private Source maSource;

    private Vector<Theme> mesThemes;

    public Citation() {
    }

    public Citation(int monId, String monTexte, Source maSource) {
        this.monId = monId;
        this.monTexte = monTexte;
        this.maSource = maSource;
    }

    public Citation(int monId, String monTexte, String maLocation, Source maSource, Vector<Theme> mesThemes) {
        this.monId = monId;
        this.monTexte = monTexte;
        this.maLocation = maLocation;
        this.maSource = maSource;
        this.mesThemes = mesThemes;
    }

    public int getMonId() {
        return monId;
    }

    public void setMonId(int monId) {
        this.monId = monId;
    }

    public String getMonTexte() {
        if (monTexte == null || monTexte.equals("")) {
            quotebase.Graphic.imprimerTexte(0, 3, "VOTRE CITATION N'A PAS DE TEXTE");
            return null;

        }
        return monTexte;
    }

    public void setMonTexte(String monTexte) {
        this.monTexte = monTexte;
    }

    public String getMaLocation() {
        if (maLocation == null || maLocation.equals("")) {
            quotebase.Graphic.imprimerTexte(0, 1, "Votre citation n'a pas de Location");
            return null;
        }
        return maLocation;
    }

    public void setMaLocation(String maLocation) {
        this.maLocation = maLocation;
    }

    public Source getMaSource() {
        if (maSource == null || maSource.equals("")) {
            quotebase.Graphic.imprimerTexte(0, 3, "VOTRE CITATION N'A PAS DE SOURCE");
            return null;
        }
        return maSource;
    }

    public void setMaSource(Source maSource) {
        this.maSource = maSource;
    }

    public Vector<Theme> getMesThemes() {
        if (mesThemes == null) {
            mesThemes = new Vector<Theme>();
        }
        return mesThemes;
    }

    public void setMesThemes(Vector<Theme> mesThemes) {
        this.mesThemes = mesThemes;
    }

    /**
     * Renvoie un vecteur composé des element principaux de la citation
     *
     * @return Vecteur avec 4 String Texte - Auteur + Titre - Source + Location
     * - Themes
     */
    public Vector getMonVecteurPrincipal() {
        Vector<String> v = new Vector<>();

        // AJOUT DU TEXTE
        v.add(getMonTexte());

        // AJOUT DE L'AUTEUR
        if (maSource.getMonAuteur().getMesTitres().size() > 0) {
            String monAuteurString = "";
            monAuteurString += maSource.getMonAuteur() + ", ";
            for (Type t : maSource.getMonAuteur().getMesTitres()) {
                monAuteurString += t.getMonNom() + ", ";
            }
            monAuteurString = monAuteurString.substring(0, monAuteurString.length() - 2);
            v.add(monAuteurString);
        } else {
            v.add(maSource.getMonAuteur().toString());
        }

        // AJOUT DES SOURCES
        if (maLocation != null) {
            v.add(maSource + ", " + maLocation);
        } else {
            v.add(maSource.getMonNom());
        }

        // AJOUT DES THEMES
        String mesThemeString = "";
        if (getMesThemes().size()>0) {
            for (Theme t : mesThemes) {
                mesThemeString += t.getMonNom() + ", ";
            }
            mesThemeString = mesThemeString.substring(0, mesThemeString.length() - 2);
            v.add(mesThemeString);
        } else {
            v.add("Pas de thème précisé");
        }

        return v;
    }

    @Override
    public String toString() {
        return monTexte;
    }
    
    

}
