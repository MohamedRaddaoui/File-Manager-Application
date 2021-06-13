/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prj21;

/**
 *
 * @author mongi
 */
public class userr {

  

   
    String NOM;
    String PRENOM;
    String LOGIN;
    String MP;
    
      public userr(String NOM, String PRENOM, String LOGIN, String MP) {
        this.NOM = NOM;
        this.PRENOM = PRENOM;
        this.LOGIN = LOGIN;
        this.MP = MP;
    }

     public void setNOM(String NOM) {
        this.NOM = NOM;
    }

    public void setPRENOM(String PRENOM) {
        this.PRENOM = PRENOM;
    }

    public void setLOGIN(String LOGIN) {
        this.LOGIN = LOGIN;
    }

    public void setMP(String MP) {
        this.MP = MP;
    }
}
