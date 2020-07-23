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
public class Langue {
    
    private String maLangue;

    public Langue() {
    }

    public Langue(String maLangue) {
        this.maLangue = maLangue;
    }

    public String getMaLangue() {
        return maLangue;
    }

    public void setMaLangue(String maLangue) {
        this.maLangue = maLangue;
    }
        @Override
    public String toString(){
        return getMaLangue();
    }
    
    
}
