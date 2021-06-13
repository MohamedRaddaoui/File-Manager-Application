/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prj21;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;
import static prj21.FXMLDocumentController.emailsave;

/**
 * FXML Controller class
 *
 * @author mongi
 */
public class MdpasseController implements Initializable {
    
    Connection c = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
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
    private TextField txtUsername;
        
     @FXML
        private void MPoublier(ActionEvent event) throws SQLException {
      
        
        
          try {
          
        String email = txtUsername.getText();
       
     
          

            Class.forName("oracle.jdbc.driver.OracleDriver");

            String URL_BD = "jdbc:oracle:thin:@Localhost:1521:xe";
            String Util = "XE";
            String MP = "hr";
            Connection c = DriverManager.getConnection(URL_BD,Util,MP);

               if(email.isEmpty() ) {
                   //custom title, warning icon
JOptionPane.showMessageDialog(null,"Null value.","Inane warning",JOptionPane.WARNING_MESSAGE);
                   
                   
                
        } else {
            //query
            String sql = "SELECT * FROM USERS Where LOGIN = ? ";
            try {
                preparedStatement = c.prepareStatement(sql);
                preparedStatement.setString(1, email);
              
                resultSet = preparedStatement.executeQuery();
                if (!resultSet.next()) {
                  JOptionPane.showMessageDialog(null,"check your data","Inane warning",JOptionPane.WARNING_MESSAGE);
                } else {
                    StringBuilder html = new StringBuilder();
        FileReader fr0;
        fr0 = new FileReader("C:\\Users\\TOPINFO\\Desktop\\Med\\2LNBIS1\\POO\\HTML1.html");
      
            BufferedReader bf0=new BufferedReader(fr0);
            String content1;
            while((content1=bf0.readLine())!=null){
                html.append(content1);
            }
            html.append(resultSet.getString(4));
            FileReader fr1;
        fr1 = new FileReader("C:\\Users\\TOPINFO\\Desktop\\Med\\2LNBIS1\\POO\\HTML2.html");
        BufferedReader bf1=new BufferedReader(fr1);
        String content2;
            while((content2=bf1.readLine())!=null){
                html.append(content2);
            }
         String body=html.toString();
        bf0.close();
        bf1.close();

String to = "Chekerasma10@gmail.com"; // to address. It can be any like gmail, hotmail etc.
  final String from = "mohamedraddaoui05@gmail.com"; // from address. As this is using Gmail SMTP.
  final String password = "m+m=l147258369"; // password for from mail address. 
 
  Properties prop = new Properties();
  prop.put("mail.smtp.host", "smtp.gmail.com");
  prop.put("mail.smtp.port", "465");
  prop.put("mail.smtp.auth", "true");
  prop.put("mail.smtp.socketFactory.port", "465");
  prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
 
  Session session;
        session = Session.getInstance(prop, new javax.mail.Authenticator() {
            protected   PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
            
        });
 
  try {
 
   Message message = new MimeMessage(session);
   message.setFrom(new InternetAddress(from));
   message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
   message.setSubject("Reset Password");
   MimeBodyPart mimeBodyPart = new MimeBodyPart();
   mimeBodyPart.setContent(body, "text/html");
   Multipart multipart = new MimeMultipart();
   multipart.addBodyPart(mimeBodyPart);
   message.setContent(multipart);
   Transport.send(message);
 
   System.out.println("Mail successfully sent..");
 
  } catch (MessagingException e) {
   e.printStackTrace();
  }                  
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
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
