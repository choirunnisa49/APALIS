/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fourkeysteam;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class SignupController implements Initializable {

    @FXML
    private Label lbSignup;
    
    @FXML
    private Button btSignup;
    
    @FXML
    private Button btHome;
    
    @FXML
    private TextField tfUsername;
    
    @FXML
    private TextField tfEmail;
    
    @FXML
    private TextField tfPassword;
    
    @FXML
    public void handleButtonSignup(ActionEvent event) throws IOException{
   if("".equals(tfUsername.getText())&&"".equals(tfEmail.getText())&&"".equals(tfPassword.getText())){
        Alert alert = new Alert (Alert.AlertType.WARNING);
        alert.setContentText("MASUKKAN USERNAME,E-MAIL & PASSWORD");
        alert.showAndWait();
        }
        else if("".equals(tfUsername.getText())&&"".equals(tfEmail.getText())){
        Alert alert = new Alert (Alert.AlertType.WARNING);
        alert.setContentText("USERNAME & E-MAIL TIDAK BOLEH KOSONG");
        alert.showAndWait();
        }
        else if("".equals(tfUsername.getText())&&"".equals(tfPassword.getText())){
        Alert alert = new Alert (Alert.AlertType.WARNING);
        alert.setContentText("USERNAME & PASSWORD TIDAK BOLEH KOSONG");
        alert.showAndWait();
        }
        else if("".equals(tfEmail.getText())&&"".equals(tfPassword.getText())){
        Alert alert = new Alert (Alert.AlertType.WARNING);
        alert.setContentText("E-MAIL & PASSWORD TIDAK BOLEH KOSONG");
        alert.showAndWait();
        }
        else if("".equals(tfUsername.getText())){
        Alert alert = new Alert (Alert.AlertType.WARNING);
        alert.setContentText("MASUKKAN USERNAME ANDA");
        alert.showAndWait();
        }
        else if("".equals(tfEmail.getText())){
        Alert alert = new Alert (Alert.AlertType.WARNING);
        alert.setContentText("MASUKKAN E-MAIL ANDA");
        alert.showAndWait();
        }
        else if("".equals(tfPassword.getText())){
        Alert alert = new Alert (Alert.AlertType.WARNING);
        alert.setContentText("MASUKKAN PASSWORD ANDA ");
        alert.showAndWait();
        }
        else{
        Parent tableViewParent =FXMLLoader.load(getClass().getResource("Home2.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        Stage window =(Stage)((Node) event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
        }
    }
    
    @FXML
    public void handleButtonHome(ActionEvent event) throws IOException{
        Parent tableViewParent =FXMLLoader.load(getClass().getResource("Home1.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        Stage window =(Stage)((Node) event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
