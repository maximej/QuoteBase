/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obj;

/**
 *
 * @author max
 */
public class Avis {
    
    private int monId;
    private int maNote;
    private String monCommentaire;
    private int maCitationId;

    public Avis() {
    }

    public Avis(int monId, String monCommentaire, int maCitationId) {
        this.monId = monId;
        this.monCommentaire = monCommentaire;
        this.maCitationId = maCitationId;
    }

    public Avis(int monId, int maNote, int maCitationId) {
        this.monId = monId;
        this.maNote = maNote;
        this.maCitationId = maCitationId;
    }

    public Avis(int monId, int maNote, String monCommentaire, int maCitationId) {
        this.monId = monId;
        this.maNote = maNote;
        this.monCommentaire = monCommentaire;
        this.maCitationId = maCitationId;
    }

    public int getMonId() {
        return monId;
    }

    public void setMonId(int monId) {
        this.monId = monId;
    }

    public int getMaNote() {
        return maNote;
    }

    public void setMaNote(int maNote) {
        this.maNote = maNote;
    }

    public String getMonCommentaire() {
        return monCommentaire;
    }

    public void setMonCommentaire(String monCommentaire) {
        this.monCommentaire = monCommentaire;
    }

    public int getMaCitationId() {
        return maCitationId;
    }

    public void setMaCitationId(int maCitationId) {
        this.maCitationId = maCitationId;
    }

    
    
}
