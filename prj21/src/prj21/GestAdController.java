/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prj21;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JFileChooser;
import static prj21.FXMLDocumentController.emailsave;

/**
 * FXML Controller class
 *
 * @author mongi
 */
public class GestAdController implements Initializable {

      
    @FXML
    private BorderPane bord; 
    
 @FXML
    private TextArea areatuser;

 
  Alert a = new Alert(Alert.AlertType.NONE);
   
 Connection c = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    
    
    
    
    

      @FXML
    private void listuser (ActionEvent ev)
    {

        System.out.println("ici me");
  Loder obj=new Loder();  
  Pane view=obj.getPage("listusers");  
  bord.setCenter(view);

    
    }
    
    
    
   @FXML
    private void lista()
   {
      
    try {
       
        ArrayList<String> L=new ArrayList();
           ObservableList<userr> list = FXCollections.observableArrayList();

            Class.forName("oracle.jdbc.driver.OracleDriver");

            String URL_BD = "jdbc:oracle:thin:@Localhost:1521:xe";
            String Util = "XE";
            String MPa = "hr";
            Connection c = DriverManager.getConnection(URL_BD,Util,MPa);

            Statement cmd = c.createStatement();
String ch="";
String ch2=" List of registered users \n";
            String sql = "SELECT * FROM users ";
            try {
                preparedStatement = c.prepareStatement(sql);
        
        
                resultSet = preparedStatement.executeQuery();
                
                while (resultSet.next()) {
                    if(resultSet.getInt(5)==0){
          
                ch=ch+("\n First Name :"+resultSet.getString(1)+"\n Last Name :"+
                        resultSet.getString(2)+"\n Email :"+resultSet.getString(3)+"\n Passe Word"+resultSet.getString(4)
                        +"\n*****************************************************************\n");
                    } 
                  
                }  
               
         areatuser.setText(ch2+(ch));
           
         
              
            } catch (SQLException ex) {
                System.err.println(ex.getMessage()+" catch1 ");
                
            }
          
        } 

        catch (Exception ex) {
         System.err.println(ex.getMessage()+" catch2 ");
        }
   
   }
    
    
    
              @FXML
    private void Listage11 (ActionEvent eve)
    {
    
        
   
      
          System.out.println("ici me");
  Loder obj=new Loder();  
  Pane view=obj.getPage("Nombre_de_fichiers");  
  bord.setCenter(view);
      
    
    }
    
    
               @FXML
    private void Listtags (ActionEvent eve)
    {
    
        
   try {
            
          FXMLLoader loader=new FXMLLoader(getClass().getResource("listTags.fxml"));
            Parent root=loader.load();
  

                Stage stage = new Stage();
       stage. setScene(new  Scene(root));
            stage.show();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    
    }   
    
    
    
     @FXML
    private TextArea affichnbr;
         @FXML
    private void Nombredefichiers()
   {
      
    try {
       


            Class.forName("oracle.jdbc.driver.OracleDriver");

            String URL_BD = "jdbc:oracle:thin:@Localhost:1521:xe";
            String Util = "XE";
            String MPa = "hr";
            Connection c = DriverManager.getConnection(URL_BD,Util,MPa);

            Statement cmd = c.createStatement();
String ch="Number of favorite files per user  \n";
            String sql = "SELECT COUNT(*),login FROM fav GROUP BY login ";
            try {
                preparedStatement = c.prepareStatement(sql);
        
        
                resultSet = preparedStatement.executeQuery();
                 
                while (resultSet.next()) {
              ch=ch+(resultSet.getString(2)+"  :--->    "+resultSet.getInt(1)+"  \n");
                System.err.println(ch);
                 
                  
                }  
     affichnbr.setText(ch);
              
            } catch (SQLException ex) {
                System.err.println(ex.getMessage()+" catch1 ");
                
            }
          
        } 

        catch (Exception ex) {
         System.err.println(ex.getMessage()+" catch2 ");
        }
   
   }
    
      @FXML
    private void Nombredefichierstxt()
   {
      
      JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file save");
        int userSelection = fileChooser.showSaveDialog(fileChooser);
        if(userSelection == JFileChooser.APPROVE_OPTION){
            File fileToSave = fileChooser.getSelectedFile();
            
     Desktop desktop = Desktop.getDesktop();
            //lets write to file
         
            try {
                  FileWriter fw = new FileWriter(fileToSave);
                BufferedWriter bw = new BufferedWriter(fw);
                
                
         try {
       
        
            Class.forName("oracle.jdbc.driver.OracleDriver");

            String URL_BD = "jdbc:oracle:thin:@Localhost:1521:xe";
            String Util = "XE";
            String MP = "hr";
            Connection c = DriverManager.getConnection(URL_BD,Util,MP);

            Statement cmd = c.createStatement();

           String sql = "SELECT COUNT(*),login FROM fav GROUP BY login ";
            try {
                preparedStatement = c.prepareStatement(sql);
            
        
                resultSet = preparedStatement.executeQuery();
String ch="Number of favorite files per user  \n";
                while (resultSet.next()) { 
            
                         ch=ch+(resultSet.getString(2)+"  :--->    "+resultSet.getInt(1)+"  \n");
                             
                  
                }    bw.newLine();  bw.write((ch));bw.newLine();
                  bw.close();
                fw.close();
         
               
   
      
            desktop.open(fileToSave);
      
            
             
            } catch (SQLException ex) {
                System.err.println(ex.getMessage()+" catch1 ");
                
            }
          
        } 

        catch (Exception ex) {
            System.out.println("catch 2");
        }
   
                bw.close();
                fw.close();
            } catch (IOException ex) {
                    a.setAlertType(Alert.AlertType.ERROR);
                    a.setContentText("ERREUR");
              
            }
            
            
        }
   
   }
    
    
    @FXML
    private TextField txtTname;



    @FXML
    private TextArea affichtag;
    
    
    
             @FXML
    private void listTagE()
   {
      
    try {
       
String ch1=txtTname.getText();

            Class.forName("oracle.jdbc.driver.OracleDriver");

            String URL_BD = "jdbc:oracle:thin:@Localhost:1521:xe";
            String Util = "XE";
            String MPa = "hr";
            Connection c = DriverManager.getConnection(URL_BD,Util,MPa);

            Statement cmd = c.createStatement();
String ch="";
String ch2=" List of tags used by a user  \n";
            String sql = "SELECT TAGS FROM fav WHERE login='"+ch1+"'";
            try {
                preparedStatement = c.prepareStatement(sql);
        
        
                resultSet = preparedStatement.executeQuery();
                 
                while (resultSet.next()) {
              ch=ch+(resultSet.getString(1)+",");
             }  
              
                ch=rmv(ch);
               
     affichtag.setText(ch2+(ch));
              
            } catch (SQLException ex) {
                System.err.println(ex.getMessage()+" catch1 ");
                
            }
          
        } 

        catch (Exception ex) {
         System.err.println(ex.getMessage()+" catch2 ");
        }
   
   }
                 @FXML
    private void listTagEtxt()
   {
      
      JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file save");
        int userSelection = fileChooser.showSaveDialog(fileChooser);
        if(userSelection == JFileChooser.APPROVE_OPTION){
            File fileToSave = fileChooser.getSelectedFile();
            
     Desktop desktop = Desktop.getDesktop();
            //lets write to file
         
            try {
                  FileWriter fw = new FileWriter(fileToSave);
                BufferedWriter bw = new BufferedWriter(fw);
                
                
         try {
       String ch1=txtTname.getText();
        
            Class.forName("oracle.jdbc.driver.OracleDriver");

            String URL_BD = "jdbc:oracle:thin:@Localhost:1521:xe";
            String Util = "XE";
            String MP = "hr";
            Connection c = DriverManager.getConnection(URL_BD,Util,MP);

            Statement cmd = c.createStatement();

    String ch="";
String ch2=" List of tags used by a user  \n";
            String sql = "SELECT TAGS FROM fav WHERE login='"+ch1+"'";
            try {
                preparedStatement = c.prepareStatement(sql);
            
        
                resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) { 
            
                        ch=ch+(resultSet.getString(1)+",");
                             
                  
                }    bw.newLine();  bw.write((ch2+(ch)));bw.newLine();
                  bw.close();
                fw.close();
         
               
   
      
            desktop.open(fileToSave);
      
            
             
            } catch (SQLException ex) {
                System.err.println(ex.getMessage()+" catch1 ");
                
            }
          
        } 

        catch (Exception ex) {
            System.out.println("catch 2");
        }
   
                bw.close();
                fw.close();
            } catch (IOException ex) {
                    a.setAlertType(Alert.AlertType.ERROR);
                    a.setContentText("ERREUR");
              
            }
            
            
        }
   
   }
    
    
      @FXML
    private TextField txtTtags;
    
     @FXML
    private void listusersT()
   {
      
    try {
       
String ch1=txtTtags.getText();

            Class.forName("oracle.jdbc.driver.OracleDriver");

            String URL_BD = "jdbc:oracle:thin:@Localhost:1521:xe";
            String Util = "XE";
            String MPa = "hr";
            Connection c = DriverManager.getConnection(URL_BD,Util,MPa);

            Statement cmd = c.createStatement();
String ch="";
String ch2=" List of users  by  Tag  \n";
            String sql = "SELECT login FROM fav WHERE tags like '%"+ch1+"%'";
            try {
                preparedStatement = c.prepareStatement(sql);
        
        
                resultSet = preparedStatement.executeQuery();
                 
                while (resultSet.next()) {
              ch=ch+(resultSet.getString(1)+",");
             }  
                
                ch=rmv(ch);
               
     affichtag.setText(ch2+(ch));
              
            } catch (SQLException ex) {
                System.err.println(ex.getMessage()+" catch1 ");
                
            }
          
        } 

        catch (Exception ex) {
         System.err.println(ex.getMessage()+" catch2 ");
        }
   
   }
    
    
     @FXML
    private void listusersTtxt()
   {
      JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file save");
        int userSelection = fileChooser.showSaveDialog(fileChooser);
        if(userSelection == JFileChooser.APPROVE_OPTION){
            File fileToSave = fileChooser.getSelectedFile();
            
     Desktop desktop = Desktop.getDesktop();
            //lets write to file
         
            try {
                  FileWriter fw = new FileWriter(fileToSave);
                BufferedWriter bw = new BufferedWriter(fw);
                
                
         try {
     String ch1=txtTtags.getText();
        
            Class.forName("oracle.jdbc.driver.OracleDriver");

            String URL_BD = "jdbc:oracle:thin:@Localhost:1521:xe";
            String Util = "XE";
            String MP = "hr";
            Connection c = DriverManager.getConnection(URL_BD,Util,MP);

            Statement cmd = c.createStatement();
String ch="";
String ch2=" List of users  by  Tag  \n";
            String sql = "SELECT login FROM fav WHERE tags like '%"+ch1+"%'";
            try {
                preparedStatement = c.prepareStatement(sql);
            
        
                resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) { 
            
                   ch=ch+(resultSet.getString(1)+",");
                             
                  
                }
                   ch=rmv(ch);
              bw.write((ch2+(ch)));bw.newLine();
                  bw.close();
                fw.close();
         
               
   
      
            desktop.open(fileToSave);
      
            
             
            } catch (SQLException ex) {
                System.err.println(ex.getMessage()+" catch1 ");
                
            }
          
        } 

        catch (Exception ex) {
            System.out.println("catch 2");
        }
   
                bw.close();
                fw.close();
            } catch (IOException ex) {
                    a.setAlertType(Alert.AlertType.ERROR);
                    a.setContentText("ERREUR");
              
            }
            
            
        }
   
    
   }
    
    
   
         @FXML
    private void listallT()
   {
      
    try {
       
String ch1=txtTtags.getText();

            Class.forName("oracle.jdbc.driver.OracleDriver");

            String URL_BD = "jdbc:oracle:thin:@Localhost:1521:xe";
            String Util = "XE";
            String MPa = "hr";
            Connection c = DriverManager.getConnection(URL_BD,Util,MPa);

            Statement cmd = c.createStatement();
String ch="";
String ch2=" List of Tags \n";
            String sql = "SELECT tags FROM fav ";
            try {
                preparedStatement = c.prepareStatement(sql);
        
        
                resultSet = preparedStatement.executeQuery();
                 
                while (resultSet.next()) {
              ch=ch+(resultSet.getString(1)+",");
             }  
                
                ch=rmv2(ch);
                  ch=rmv1(ch);
     affichtag.setText(ch2+(ch));
              
            } catch (SQLException ex) {
                System.err.println(ex.getMessage()+" catch1 ");
                
            }
          
        } 

        catch (Exception ex) {
         System.err.println(ex.getMessage()+" catch2 ");
        }
   
   }
    
      @FXML
    private void listallTtxt()
   {
      
 JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file save");
        int userSelection = fileChooser.showSaveDialog(fileChooser);
        if(userSelection == JFileChooser.APPROVE_OPTION){
            File fileToSave = fileChooser.getSelectedFile();
            
     Desktop desktop = Desktop.getDesktop();
            //lets write to file
         
            try {
                  FileWriter fw = new FileWriter(fileToSave);
                BufferedWriter bw = new BufferedWriter(fw);
                
                
         try {
       String ch1=txtTname.getText();
        
            Class.forName("oracle.jdbc.driver.OracleDriver");

            String URL_BD = "jdbc:oracle:thin:@Localhost:1521:xe";
            String Util = "XE";
            String MP = "hr";
            Connection c = DriverManager.getConnection(URL_BD,Util,MP);

            Statement cmd = c.createStatement();

  String ch="";
String ch2=" List of Tags \n";
            String sql = "SELECT tags FROM fav ";
            try {
                preparedStatement = c.prepareStatement(sql);
            
        
                resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) { 
            
                      ch=ch+(resultSet.getString(1)+",");
                             
                  
                }
                ch=rmv2(ch);
                  ch=rmv1(ch);
              bw.write((ch2+(ch)));bw.newLine();
                  bw.close();
                fw.close();
         
               
   
      
            desktop.open(fileToSave);
      
            
             
            } catch (SQLException ex) {
                System.err.println(ex.getMessage()+" catch1 ");
                
            }
          
        } 

        catch (Exception ex) {
            System.out.println("catch 2");
        }
   
                bw.close();
                fw.close();
            } catch (IOException ex) {
                    a.setAlertType(Alert.AlertType.ERROR);
                    a.setContentText("ERREUR");
              
            }
            
            
        }
   
   }
    
    
    
    
      
    public  String rmv(String test3)
    {
    
 
     
        String[] ary = test3.split(",");
        for(int i=0; i<ary.length-1; i++)
        {
            for(int j=i+1; j<ary.length; j++)
            {
                if(ary[i].toLowerCase().equals(ary[j].toLowerCase()))
                {
                    ary[j]="";
                }


            }}
        String ch="";
        
        for(int i=0; i<ary.length; i++)
    { 
        if(ary[i]!="")
        ch=ch+ary[i]+",\n";

    }



    
   return ch;}
    
    
    
    
    
    
    public  String rmv2(String test3)
    {
    
 
     
        String[] ary = test3.split(",");
        for(int i=0; i<ary.length-1; i++)
        {
            for(int j=i+1; j<ary.length; j++)
            {
                if(ary[i].toLowerCase().equals(ary[j].toLowerCase()))
                {
                    ary[j]="";
                }


            }}
        String ch="";
        
        for(int i=0; i<ary.length; i++)
    { 
        if(ary[i]!="")
        ch=ch+ary[i]+",";

    }



    
   return ch;}
    
    
    
     public  String rmv1(String test3) throws ClassNotFoundException, SQLException 
    {
    
            Class.forName("oracle.jdbc.driver.OracleDriver");

            String URL_BD = "jdbc:oracle:thin:@Localhost:1521:xe";
            String Util = "XE";
            String MPa = "hr";
            Connection c = DriverManager.getConnection(URL_BD,Util,MPa);
 
     
        String[] ary = test3.split(",");
     
        String ch="";
        
        
           
     int [] t=new int[100];
        

            Statement cmd = c.createStatement();
for(int i=0; i<ary.length; i++)
    { 
            String sql = "SELECT COUNT(login) from fav where tags LIKE '%"+ary[i]+"%'";
            try { 
                preparedStatement = c.prepareStatement(sql);
        
        
                resultSet = preparedStatement.executeQuery();
                 
                while (resultSet.next()) { 
                t[i]=resultSet.getInt(1);
                System.err.println(t[i]);
            ary[i]= ary[i]+"    had     "+resultSet.getInt(1)+"   users";
           
             }
        
            
        
         } catch (SQLException ex) {
                System.err.println(ex.getMessage()+" catch1 ");
                
         }

        catch (Exception ex) {
         System.err.println(ex.getMessage()+" catch2 ");
        }
        
    
    }
                
        tri_bulle(t, ary);
     
        
        for(int i=0; i<ary.length; i++)
    { 
      
        ch=ch+ary[i]+"\n";

    }



    


    
   return ch;}
    
    
    
     private void tri_bulle(int[] tab,String [] tab2 )
    {
        int taille = tab.length;
        int tmp = 0;
        String tmp2="";
        for(int i=0; i < taille; i++)
        {
            for(int j=1; j < (taille-i); j++)
            {
                if(tab[j-1] < tab[j])
                {
                    //echanges des elements
                    tmp = tab[j-1];
                    tab[j-1] = tab[j];
                    tab[j] = tmp;
                     tmp2 = tab2[j-1];
                    tab2[j-1] = tab2[j];
                    tab2[j] = tmp2;
                }

            }
        }
    }
    
    
    
    
     
     
     
     
     
     
     
     
       @FXML
    private void savefile(ActionEvent event) {
   JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file save");
        int userSelection = fileChooser.showSaveDialog(fileChooser);
        if(userSelection == JFileChooser.APPROVE_OPTION){
            File fileToSave = fileChooser.getSelectedFile();
            
     Desktop desktop = Desktop.getDesktop();
            //lets write to file
         
            try {
                  FileWriter fw = new FileWriter(fileToSave);
                BufferedWriter bw = new BufferedWriter(fw);
                
                
         try {
       
        
            Class.forName("oracle.jdbc.driver.OracleDriver");

            String URL_BD = "jdbc:oracle:thin:@Localhost:1521:xe";
            String Util = "XE";
            String MP = "hr";
            Connection c = DriverManager.getConnection(URL_BD,Util,MP);

            Statement cmd = c.createStatement();

             String sql = "SELECT * FROM users ";
            try {
                preparedStatement = c.prepareStatement(sql);
            
        
                resultSet = preparedStatement.executeQuery();
             String ch="";
String ch2=" List of registered users \n";
                while (resultSet.next()) { 
              if(resultSet.getInt(5)==0){
                      bw.newLine();
                      
                      ch=ch+("\n First Name :"+resultSet.getString(1)+"\n Last Name :"+
                        resultSet.getString(2)+"\n Email :"+resultSet.getString(3)+"\n Passe Word"+resultSet.getString(4)
                        +"\n*****************************************************************\n");
                    } 
                       
                             
                  
                }    bw.newLine();  bw.write(ch2+(ch));bw.newLine();
                  bw.close();
                fw.close();
         
               
   
      
            desktop.open(fileToSave);
      
            
             
            } catch (SQLException ex) {
                System.err.println(ex.getMessage()+" catch1 ");
                
            }
          
        } 

        catch (Exception ex) {
            System.out.println("catch 2");
        }
   
                bw.close();
                fw.close();
            } catch (IOException ex) {
                    a.setAlertType(Alert.AlertType.ERROR);
                    a.setContentText("ERREUR");
              
            }
            
            
        } }
 
 
     
     
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
