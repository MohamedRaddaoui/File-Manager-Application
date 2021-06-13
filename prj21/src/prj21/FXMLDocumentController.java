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
import java.nio.channels.Channel;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.sql.*;
import javafx.scene.control.PasswordField;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author mongi
 */
public class FXMLDocumentController implements Initializable {
      
    @FXML
    private BorderPane bord; 
    

          @FXML
    private javafx.scene.control.Button  btnt1;
  
       @FXML
    private TextField txtUsername11;

       static String emailsave ;
       @FXML
    private TextField txtus;

    @FXML
    private PasswordField txtps;


    @FXML
    private TextField txtfn;

    @FXML
    private TextField txtln;
 Alert a = new Alert(AlertType.NONE);
   
 Connection c = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    @FXML
   
    private void logup(ActionEvent event) {
      
        
        try {
            
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
           
            stage.close();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("logup.fxml")));
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
       
    }
    @FXML
        private void loginn(ActionEvent event) {
      
        
        try {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("login.fxml")));
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
       
    }
    @FXML
        private void mdpoublier(ActionEvent event) {
      
        
        try {
            
            
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
           
            stage.close();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("mdpasse.fxml")));
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
       
    }
    
     @FXML
     
    private void Home (ActionEvent eve)
    {
    
     try {
            
            Node node = (Node) eve.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            //stage.setMaximized(true);
            stage.close();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Home.fxml")));
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
  
    @FXML
    private void affch (ActionEvent ev)
    {
   
        System.out.println("yyyy me");
  Loder obj=new Loder();
  Pane view=obj.getPage("Affch");
  bord.setCenter(view);
  
    
    }
      @FXML
     
    private void afffch (ActionEvent eve)
    {
    
     try {
            
            Node node = (Node) eve.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            //stage.setMaximized(true);
            stage.close();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("afffich.fxml")));
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
            @FXML
     
    private void desplay (ActionEvent eve)
    {
    
     try {
            
            Node node = (Node) eve.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            //stage.setMaximized(true);
            stage.close();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("afffich.fxml")));
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    @FXML
      private void recherch (ActionEvent eve)
    {
    
     try {
        
           
            Stage stage = new Stage();
            //stage.setMaximized(true);
            
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Recherche.fxml")));
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    
      public String ch;
    
      @FXML
    private void MisAJ (ActionEvent eve)
    {
         ch =ListeUP.getValue();
        
   try {
       
            FXMLLoader loader=new FXMLLoader(getClass().getResource("Update.fxml"));
            Parent root=loader.load();
            UpdateController updt=loader.getController();
           
            updt.setUP(ch,emailsave);
            Stage stage = new Stage();
            //stage.setMaximized(true);
            
            
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    
    }
    
     @FXML
    private void Admin (ActionEvent eve)
    {
        
        
   try {
       /*
            FXMLLoader loader=new FXMLLoader(getClass().getResource("gestAd.fxml"));
            Parent root=loader.load();
            GestAdController add=loader.getController();
        
            Stage stage = new Stage();
            //stage.setMaximized(true);
            
            
            stage.setScene(new Scene(root));
            stage.show();*/
          Node node = (Node) eve.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            //stage.setMaximized(true);
            stage.close();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("gestAd.fxml")));
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    
    }
       
    
          @FXML
    private void Listage11 (ActionEvent eve)
    {
    
        
   try {
            
          FXMLLoader loader=new FXMLLoader(getClass().getResource("listage1.fxml"));
            Parent root=loader.load();
        Listage1Controller lis=loader.getController();
       lis.lista(emailsave);
                Stage stage = new Stage();
       stage. setScene(new  Scene(root));
            stage.show();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    
    }
    
    
    
    @FXML
    
     private void MAJSP (ActionEvent eve) throws ClassNotFoundException
    { 
       System.out.println("Click me");
  Loder obj=new Loder();
  Pane view=obj.getPage("MAJSP");
  bord.setCenter(view);
    }
    
    
    
 

    
  
    
    
    
    
    
    
    
    
      @FXML
      private void insert (ActionEvent eve)
      {
      
      try {
          
          String ch1=txtfn.getText();
          String ch2=txtln.getText();
          String ch3=txtus.getText();
          String ch4=txtps.getText();
          
          

            Class.forName("oracle.jdbc.driver.OracleDriver");

            String URL_BD = "jdbc:oracle:thin:@Localhost:1521:xe";
            String Util = "XE";
            String MP = "hr";
            Connection c = DriverManager.getConnection(URL_BD,Util,MP);

            Statement cmd = c.createStatement();

            int nbrMaj;
            nbrMaj = cmd.executeUpdate("INSERT INTO USERS VALUES('"+ch1+"','"+ch2+"','"+ch3+"','"+ch4+"')");
            System.out.println("donee\n");
            c.close();
            Home(eve);
        } catch (SQLException e) {
            System.out.println(e.getMessage()+"    dhia");
        }

        catch (Exception ex) {
            System.out.println("catch 2");
        }
    }
      
      
      
      
      
      
      
      
      
       @FXML
    private ComboBox<String> ListeUP;
      
      
          @FXML
      private void Delete (ActionEvent eve)
      {
      
      try {
          

            Class.forName("oracle.jdbc.driver.OracleDriver");

            String URL_BD = "jdbc:oracle:thin:@Localhost:1521:xe";
            String Util = "XE";
            String MP = "hr";
            Connection c = DriverManager.getConnection(URL_BD,Util,MP);

            Statement cmd = c.createStatement();
String ch=ListeUP.getValue();
            int nbrMaj;
            nbrMaj = cmd.executeUpdate("DELETE FROM FAV WHERE URL LIKE '%"+ch+"' AND LOGIN ='"+emailsave+"'");
            System.out.println("donee\n");
            System.out.println(ch);
            c.close();
          
        } catch (SQLException e) {
            System.out.println(e.getMessage()+"    catch1");
        }

        catch (Exception ex) {
            System.out.println("catch 2");
        }
    }
      
      
      
      
      
      
        @FXML
    private void Modifpass (ActionEvent ev)
    {
   
        System.out.println("Click me");
  Loder obj=new Loder();
  Pane view=obj.getPage("changerpass");
  bord.setCenter(view);
  
    
    } 
      
      
      
      
      
    
 
     @FXML
    private void tagf (ActionEvent ev)
    {
   
        System.out.println("Click me");
  Loder obj=new Loder();
  Pane view=obj.getPage("Tag");
  bord.setCenter(view);
  
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    

  
    @FXML
    private void ChoixF() throws ClassNotFoundException {
   
        
           try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            String URL_BD = "jdbc:oracle:thin:@Localhost:1521:xe";
            String Util = "XE";
            String MP = "hr";
            Connection c = DriverManager.getConnection(URL_BD,Util,MP);

               
            //query
            String sql = "SELECT * FROM FAV Where LOGIN = ? ";
            try {
                preparedStatement = c.prepareStatement(sql);
                preparedStatement.setString(1, emailsave);
        
                resultSet = preparedStatement.executeQuery();
                
               List<String> t = new ArrayList<>();
                
                    
                    while (resultSet.next()) {
                      
                   t.add(supch(resultSet.getString(6)));
                    }                   ListeUP.getItems().setAll(t);

                
            } catch (SQLException ex) {
                System.err.println(ex.getMessage()+" catch1 ");
                
            }
        
    }         catch (SQLException ex) {
                 System.err.println(ex.getMessage()+" catch2 ");
              }}
    
    
    
    
    
    
    
  
    

    
    
     @FXML
    private TextField txtUsername;

    @FXML
    private TextField txtPassword;
    
    
   @FXML
private void signin(ActionEvent event) {

           try {
          
        String email = txtUsername.getText();
        String password = txtPassword.getText();
          emailsave=email;
          

            Class.forName("oracle.jdbc.driver.OracleDriver");

            String URL_BD = "jdbc:oracle:thin:@Localhost:1521:xe";
            String Util = "XE";
            String MP = "hr";
            Connection c = DriverManager.getConnection(URL_BD,Util,MP);

               if(email.isEmpty() || password.isEmpty()) {
                   //custom title, warning icon
JOptionPane.showMessageDialog(null,"Null value.","Inane warning",JOptionPane.WARNING_MESSAGE);
                   
                   
                
        } else {
            //query
            String sql = "SELECT * FROM USERS Where LOGIN = ? and MP = ?";
            try {
                preparedStatement = c.prepareStatement(sql);
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, password);
                resultSet = preparedStatement.executeQuery();
                if (!resultSet.next()) {
                  JOptionPane.showMessageDialog(null,"check your data","Inane warning",JOptionPane.WARNING_MESSAGE);
                } else {
                    emailsave=resultSet.getString(3);
                    System.out.println(email);
                   if(resultSet.getInt(5)==0)
                    Home(event);
                   else Admin(event);
                }
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
                
            }
        }

          
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        catch (Exception ex) {
            System.out.println(ex.getMessage()+"         catch2");
        }

}





    
     @FXML
    private void handle(ActionEvent event) {
     FileChooser fileChooser = new FileChooser();
    File file = fileChooser.showOpenDialog(null);
                if (file != null) {
                    
                    txtFile.setText(file.getAbsolutePath());
                    
                }
                else { txtFile.setText("file is not valid");
                } }
    
    
    private String supch(String ch)
  {
 String strNew="" ;
      
        int n=0 ;
         for(int i =0 ;i<ch.length();i++)
         { if(ch.charAt(i)=='\\')
         n=i;
         }
  
 strNew =ch.substring(n+1,ch.length());
  return strNew;}

    
    
    
    
    
    
    
    
   

    @FXML
    private TextField txtTG;

    @FXML
    private TextField txtAt;

    @FXML
    private TextField txtTR;



    @FXML
    private TextArea Resume;

    @FXML
    private TextArea Cmt;

    @FXML
    private TextField txtFile;
     
    
    @FXML
 private void ADD(ActionEvent event) {
     
       JOptionPane.showMessageDialog(null,emailsave,"Inane warning",JOptionPane.WARNING_MESSAGE);  
   try {
      
           String ch1=txtAt.getText();
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

            int nbrMaj;
            nbrMaj = cmd.executeUpdate("INSERT INTO FAV VALUES('"+ch1+"','"+ch2+"','"+ch3+"','"+ch4+"','"+ch5+"','"+ch6+"','"+emailsave+"')");
            System.out.println("donee\n");
            c.close();
           a.setAlertType(AlertType.CONFIRMATION);
  
                a.show();
        } catch (SQLException e) {
            
JOptionPane.showMessageDialog(null,e.getMessage()+"  1","Inane warning",JOptionPane.WARNING_MESSAGE);  
                // show the dialog
               ;
        }

        catch (Exception ex) {
           JOptionPane.showMessageDialog(null,ex.getMessage()+"  2","Inane warning",JOptionPane.WARNING_MESSAGE);  
                // show the dialog
               
        }
     
     
 }
    
  @FXML
    private TableColumn<filee, String> AUTEUR;

    @FXML
    private TableColumn<filee, String> TITRE;

    @FXML
    private TableColumn<filee, String> TAGS;

    @FXML
    private TableColumn<filee, String>RÉSUMÉ;

    @FXML
    private TableColumn<filee, String>COMMENTAIRES;

    @FXML
    private TableColumn<filee, String> URL;
    @FXML
    private TableView<filee> table;
  
  @FXML
    private TextField txtTGup;

    @FXML
    private TextField attx;

    @FXML
    private TextField txtTRup;

    @FXML
    private Button btnUP;

 
  @FXML
 private void lista(ActionEvent event)
   {  String cha="";String chg="";String chr="";
   
     if(attx.getText()!=null)
      cha=attx.getText();
       if(txtTGup.getText()!=null)
      chg=txtTGup.getText();
        if(txtTRup.getText()!=null)
      chr=txtTRup.getText();
      
      
    try {
       
        ArrayList<String> L=new ArrayList();
           ObservableList<filee> list = FXCollections.observableArrayList();

            Class.forName("oracle.jdbc.driver.OracleDriver");

            String URL_BD = "jdbc:oracle:thin:@Localhost:1521:xe";
            String Util = "XE";
            String MP = "hr";
            Connection c = DriverManager.getConnection(URL_BD,Util,MP);

            Statement cmd = c.createStatement();

            String sql = "SELECT * FROM FAV WHERE  LOGIN ='"+emailsave+"' AND AUTEUR LIKE '%"+cha+"' AND TITRE LIKE '%"+chr+"' AND TAGS LIKE '%"+chg+"'";
            try {
                preparedStatement = c.prepareStatement(sql);
            
        
                resultSet = preparedStatement.executeQuery();
                filee f;
                while (resultSet.next()) {
                  f=new filee(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6));
                  list.add(f);
                  
                }  
               
               AUTEUR.setCellValueFactory(new PropertyValueFactory<filee, String>("AUTEUR"));
        TITRE.setCellValueFactory(new PropertyValueFactory<filee, String>("TITRE"));
        TAGS.setCellValueFactory(new PropertyValueFactory<filee, String>("TAGS"));
        RÉSUMÉ.setCellValueFactory(new PropertyValueFactory<filee, String>("RÉSUMÉ"));
        COMMENTAIRES.setCellValueFactory(new PropertyValueFactory<filee, String>("COMMENTAIRES"));
      URL.setCellValueFactory(new PropertyValueFactory<filee, String>("URL"));
               
            table.setItems(list);  
              System.err.println("D5aaal");
            } catch (SQLException ex) {
                System.err.println(ex.getMessage()+" catch1 ");
                
            }
          
        } 

        catch (Exception ex) {
            System.out.println("catch 2");
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
            String sql = "SELECT * FROM FAV WHERE  LOGIN ='"+emailsave+"'";
            try {
                preparedStatement = c.prepareStatement(sql);
                resultSet = preparedStatement.executeQuery();
              String[] ts = {"AUTEUR","TITRE","TAGS","RÉSUMÉ","COMMENTAIRES","URL"};
                 bw.write("Favorit files ");
                while (resultSet.next()) { 
              for (int j = 01; j  <6; j++) {
                      bw.newLine();
                      
                        bw.write(ts[j]+" = "+resultSet.getString(j)+" | ");
                    } 
                          bw.newLine();
                              bw.write("--------------------------------------------------------------------------------------------------------------------");bw.newLine();
                  
                }  
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
                    a.setAlertType(AlertType.ERROR);
                    a.setContentText("ERROR");
              
            }
            
            
        } }
 
 

 
    
    
    
 @FXML
    private PasswordField txtPasswordch;

    @FXML
    private PasswordField txtPassword1ch;

    @FXML
    private PasswordField txtPassword11ch;
    
    
    
    @FXML
        private void changerPasse(ActionEvent event) {
      String ch=txtPasswordch.getText();
      String ch1=txtPassword1ch.getText();
       String ch2=txtPassword11ch.getText();
        
        
          try {
          
     
       
     
          

            Class.forName("oracle.jdbc.driver.OracleDriver");

            String URL_BD = "jdbc:oracle:thin:@Localhost:1521:xe";
            String Util = "XE";
            String MP = "hr";
            Connection c = DriverManager.getConnection(URL_BD,Util,MP);

               if(ch.isEmpty() ||ch2.isEmpty() ||ch1.isEmpty() ) {
                   //custom title, warning icon
JOptionPane.showMessageDialog(null,"Null values.","Inane warning",JOptionPane.WARNING_MESSAGE);
                   
                   
                
        } else if(!ch1.equals(ch2)){
        
        JOptionPane.showMessageDialog(null,"Confirm your new passe word","Inane warning",JOptionPane.WARNING_MESSAGE);
        }else {
            //query
            String sql = "SELECT * FROM USERS Where LOGIN = ? and MP = ?";
            try {
                preparedStatement = c.prepareStatement(sql);
                preparedStatement.setString(1, emailsave);
                preparedStatement.setString(2, ch);

                resultSet = preparedStatement.executeQuery();
                
                if (!resultSet.next()) {
                  JOptionPane.showMessageDialog(null,"check your data","Inane warning",JOptionPane.WARNING_MESSAGE);
                } else {
                    if(resultSet.getString(4).equals(ch))
                    {
                      Statement cmd = c.createStatement();

            int nbrMaj;
            nbrMaj = cmd.executeUpdate("UPDATE users SET MP = '"+ch1+"' where LOGIN ='"+emailsave+"'");
          
            c.close();
           a.setAlertType(AlertType.CONFIRMATION);
  
                a.show();
                  
                   JOptionPane.showMessageDialog(null," the password is changed ","Passe Word",JOptionPane.YES_OPTION);
                  
                    }else{
                   
          JOptionPane.showMessageDialog(null,"Verify your passeword","Inane warning",JOptionPane.WARNING_MESSAGE);
                }}
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
                
            }
        }

          
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        catch (Exception ex) {
            System.out.println(ex.getMessage()+"         catch2");
        }
       
    }
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    
    
}
