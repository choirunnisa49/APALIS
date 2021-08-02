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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.lang.RuntimeException;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class SigninController implements Initializable {

    @FXML
    private Label lbSignin;
    
    @FXML
    private Button btSignin;
    
    @FXML
    private TextField tfUsername;

    @FXML
    private TextField tfPassword;

    @FXML
    private Button btHome;
    
    @FXML
    private Label lbPeringatan;
    
    
    @FXML
    public void handleButtonSignin(ActionEvent event) throws IOException{
        if("".equals(tfUsername.getText())&&"".equals(tfPassword.getText())){
        Alert alert = new Alert (Alert.AlertType.WARNING);
        alert.setContentText("MASUKKAN USERNAME & PASSWORD");
        alert.showAndWait();
        }
        else if("".equals(tfUsername.getText())){
        Alert alert = new Alert (Alert.AlertType.WARNING);
        alert.setContentText("MASUKKAN USERNAME!");
        alert.showAndWait();
        }
        else if ("".equals(tfPassword.getText())){
        Alert alert = new Alert (Alert.AlertType.WARNING);
        alert.setContentText("MASUKKAN PASSWORD");
        alert.showAndWait();
        }
        else if (!"".equals(tfUsername.getText()) && !"".equals(tfPassword.getText())) {
            Parent tableViewParent =FXMLLoader.load(getClass().getResource("Home2.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        Stage window =(Stage)((Node) event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show(); 
        }
        else{
        Alert alert = new Alert (Alert.AlertType.WARNING);
        alert.setContentText("MASUKKAN USERNAME & PASSWORD");
        alert.showAndWait();
        }
    }
    
    @FXML
    private void handleButtonHome(ActionEvent event) throws IOException{
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
