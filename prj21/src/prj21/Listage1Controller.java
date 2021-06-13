/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prj21;

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
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author mongi
 */
public class Listage1Controller implements Initializable {

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
    private TextField txtln;
 Alert a = new Alert(Alert.AlertType.NONE);
   
 Connection c = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    
    
    
   public void lista(String emailsave)
   {
      
    try {
       
        ArrayList<String> L=new ArrayList();
           ObservableList<filee> list = FXCollections.observableArrayList();

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
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rrr) {
        // TODO
    }    
    
}
