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
public class Recueil {

    private Vector<Citation> mesCitations;
    private Vector<Auteur> mesAuteurs;
    private Vector<Source> mesSources;
    private Vector<Theme> mesThemes;
    private Vector<Type> mesTypes;
    private Vector<Langue> mesLangues;
    private Vector<Avis> mesAvis;

    public Recueil() {
    }

    public Recueil(Vector<Citation> mesCitations, Vector<Auteur> mesAuteurs, Vector<Source> mesSources, Vector<Theme> mesThemes, Vector<Type> mesTypes, Vector<Langue> mesLangues, Vector<Avis> mesAvis) {
        this.mesCitations = mesCitations;
        this.mesAuteurs = mesAuteurs;
        this.mesSources = mesSources;
        this.mesThemes = mesThemes;
        this.mesTypes = mesTypes;
        this.mesLangues = mesLangues;
        this.mesAvis = mesAvis;
    }

    public Vector<Citation> getMesCitations() {
        return mesCitations;
    }

    public void setMesCitations(Vector<Citation> mesCitations) {
        this.mesCitations = mesCitations;
        quotebase.Graphic.imprimerTexte(1, 3, "Citations mises à jour dans le Recueil.");

    }

    public Vector<Auteur> getMesAuteurs() {
        return mesAuteurs;
    }

    public void setMesAuteurs(Vector<Auteur> mesAuteurs) {
        this.mesAuteurs = mesAuteurs;
    }

    public Vector<Source> getMesSources() {
        return mesSources;
    }

    public void setMesSources(Vector<Source> mesSources) {
        this.mesSources = mesSources;
    }

    public Vector<Theme> getMesThemes() {
        return mesThemes;
    }

    public void setMesThemes(Vector<Theme> mesThemes) {
        this.mesThemes = mesThemes;
    }

    public Vector<Type> getMesTypes() {
        return mesTypes;
    }

    public void setMesTypes(Vector<Type> mesTypes) {
        this.mesTypes = mesTypes;
    }

    public Vector<Langue> getMesLangues() {
        return mesLangues;
    }

    public void setMesLangues(Vector<Langue> mesLangues) {
        this.mesLangues = mesLangues;
    }

    public Vector<Avis> getMesAvis() {
        return mesAvis;
    }

    public void setMesAvis(Vector<Avis> mesAvis) {
        this.mesAvis = mesAvis;
    }

}
