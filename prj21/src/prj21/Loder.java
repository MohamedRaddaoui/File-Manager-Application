/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prj21;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

/**
 *
 * @author mongi
 */
public class Loder {
    private Pane view;
    
    
    
    public Pane getPage(String fileName) 
    { 
        
    
        
            try { 
                URL fileU= Prj21.class.getResource("/prj21/"+fileName+".fxml");
                if(fileU== null)
        {
                throw  new java.io.FileNotFoundException("not found");
           }
            view=new FXMLLoader().load(fileU);
            
            } catch (Exception ex) {
                System.out.println("page"+fileName);
            }
        
    return view;
    }
    
}
