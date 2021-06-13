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
public class filee {

  
    private String AUTEUR;
    private String TITRE;
    private String TAGS;
    private String RÉSUMÉ;
    private String COMMENTAIRES;
    private String URL;

  
    
  public filee(String AUTEUR, String TITRE, String TAGS, String RÉSUMÉ, String COMMENTAIRES, String URL) {
        this.AUTEUR = AUTEUR;
        this.TITRE = TITRE;
        this.TAGS = TAGS;
        this.RÉSUMÉ = RÉSUMÉ;
        this.COMMENTAIRES = COMMENTAIRES;
        this.URL = URL;
    }
  public String getURL() {
        return URL;
    }
    public String getAUTEUR() {
        return AUTEUR;
    }

    public void setAUTEUR(String AUTEUR) {
        this.AUTEUR = AUTEUR;
    }

  

    public String getTITRE() {
        return TITRE;
    }

    public void setTITRE(String TITRE) {
        this.TITRE = TITRE;
    }

    public String getTAGS() {
        return TAGS;
    }

    public void setTAGS(String TAGS) {
        this.TAGS = TAGS;
    }

    public String getRÉSUMÉ() {
        return RÉSUMÉ;
    }

    public void setRÉSUMÉ(String RÉSUMÉ) {
        this.RÉSUMÉ = RÉSUMÉ;
    }

    public String getCOMMENTAIRES() {
        return COMMENTAIRES;
    }

    public void setCOMMENTAIRES(String COMMENTAIRES) {
        this.COMMENTAIRES = COMMENTAIRES;
    }
    public String tostring(){
    
    
    return getURL();}
}
    

