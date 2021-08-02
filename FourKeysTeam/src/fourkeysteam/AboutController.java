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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AboutController implements Initializable {

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    public void handleButtonHome(ActionEvent event) throws IOException{
        Parent tableViewParent =FXMLLoader.load(getClass().getResource("Home1.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        Stage window =(Stage)((Node) event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show(); 
}
    
    @FXML
    public void handleButtonSignin(ActionEvent event) throws IOException{
        Parent tableViewParent =FXMLLoader.load(getClass().getResource("Signin.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        Stage window =(Stage)((Node) event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show(); 
}

    @FXML
    public void handleButtonSignup(ActionEvent event) throws IOException{
        Parent tableViewParent =FXMLLoader.load(getClass().getResource("Signup.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        Stage window =(Stage)((Node) event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show(); 
}
}