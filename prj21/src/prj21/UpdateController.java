/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prj21;
import java.sql.*;

import java.sql.PreparedStatement;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mongi
 */
public class UpdateController implements Initializable {
    @FXML
    private TextField txtTG;

    @FXML
    private TextField txtAt1;

    @FXML
    private TextField txtTR;

    @FXML
    private TextArea Resume;

    @FXML
    private TextArea Cmt;

    @FXML
    private TextField txtFile;
    
    
    String emails="";
       String ch11="";
        
     
 Connection c = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
     Alert a = new Alert(Alert.AlertType.NONE);
    
    
    
    @FXML
    private void handle(ActionEvent event) {
     FileChooser fileChooser = new FileChooser();
    File file = fileChooser.showOpenDialog(null);
                if (file != null) {
                    
                    txtFile.setText(file.getAbsolutePath());
                    
                }
                else { txtFile.setText("file is not valid");
                } }
    
    @FXML
 private void Update(ActionEvent event) {
        
   try {
        
           String ch1=txtAt1.getText();
          String ch2=txtTR.getText();
          String ch3=txtTG.getText();
          String ch4=Resume.getText();
          String ch5=Cmt.getText();
           String ch6=txtFile.getText();
          

            Class.forName("oracle.jdbc.driver.OracleDriver");

            String URL_BD = "jdbc:oracle:thin:@Localhost:1521:xe";
            String Util = "XE";
            String MP = "hr";
            Connection c = DriverManager.getConnection(URL_BD,Util,MP);

            Statement cmd = c.createStatement();
       System.out.println(ch11);
            int nbrMaj;
            nbrMaj = cmd.executeUpdate("UPDATE FAV SET AUTEUR='"+ch1+"',TITRE='"+ch2+"',TAGS='"+ch3+"',RÉSUMÉ='"+ch4+"',COMMENTAIRES='"+ch5+"',URL='"+ch6+"',LOGIN='"+emails+"'  Where LOGIN ='"+emails+"'  AND URL LIKE '%"+ch11+"' ");
            System.out.println("done\n");
        
           a.setAlertType(Alert.AlertType.CONFIRMATION);
  
                a.show();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
           a.setAlertType(Alert.AlertType.ERROR);
  
                // show the dialog
                a.show();
        }

        catch (Exception ex) {
            a.setAlertType(Alert.AlertType.ERROR);
  
                // show the dialog
                a.show();
        }
     
     
 }
   public void setUP(String ch,String emailsave)
   {
       emails=emailsave;
       ch11=ch;
    try {
          

            Class.forName("oracle.jdbc.driver.OracleDriver");

            String URL_BD = "jdbc:oracle:thin:@Localhost:1521:xe";
            String Util = "XE";
            String MP = "hr";
            Connection c = DriverManager.getConnection(URL_BD,Util,MP);

            Statement cmd = c.createStatement();

            String sql = "SELECT * FROM FAV Where LOGIN ='"+emailsave+"'  AND URL LIKE '%"+ch+"'";
            try {
                preparedStatement = c.prepareStatement(sql);
            
        
                resultSet = preparedStatement.executeQuery();
                
                while (resultSet.next()) {
                    
                  txtAt1.setText(resultSet.getString(1));
                   txtTR.setText(resultSet.getString(2));
                    txtTG.setText(resultSet.getString(3));
                     Resume.setText(resultSet.getString(4));
                      Cmt.setText(resultSet.getString(5));
                   txtFile.setText(resultSet.getString(6)); 
                }
            } catch (SQLException ex) {
                System.err.println(ex.getMessage()+" catch1 ");
                
            }
          
        } 

        catch (Exception ex) {
            System.out.println("catch 2");
        }
   
   }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
