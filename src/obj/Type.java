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
public class Type {
 
    private int monId;
    private String monNom;
    private String maDescription;

    public Type() {
    }

    public Type(int monId, String monNom) {
        this.monId = monId;
        this.monNom = monNom;
    }

    public Type(int monId, String monNom, String maDescription) {
        this.monId = monId;
        this.monNom = monNom;
        this.maDescription = maDescription;
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

    public String getMaDescription() {
        return maDescription;
    }

    public void setMaDescription(String maDescription) {
        this.maDescription = maDescription;
    }
    
        @Override
    public String toString(){
        return getMonNom();
    }
    
}
