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
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class Home2Controller implements Initializable {

    @FXML
    private Button btEditProfile;
    @FXML
    private Button btSignout;
    @FXML
    private Button btTrending;
    @FXML
    private Button btChartOrder;
    @FXML
    private Button btOrder;
    @FXML
    private Button btSearch;
    
    @FXML
    public void handleButtonEditProfile(ActionEvent event) throws IOException{
        Parent tableViewParent =FXMLLoader.load(getClass().getResource("Profile.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        Stage window =(Stage)((Node) event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
    }
    @FXML
    public void handleButtonSignOut(ActionEvent event) throws IOException{
        Parent tableViewParent =FXMLLoader.load(getClass().getResource("Home1.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        Stage window =(Stage)((Node) event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show(); 
    }
    @FXML
    public void handleButtonChartOrder(ActionEvent event) throws IOException{
        Parent tableViewParent =FXMLLoader.load(getClass().getResource("/fourkeysteam/GrafikPemesanan.java"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        Stage window =(Stage)((Node) event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show(); 
    }
    @FXML
    public void handleButtonOrder(ActionEvent event) throws IOException{
        Parent tableViewParent =FXMLLoader.load(getClass().getResource("Order_1.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        Stage window =(Stage)((Node) event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show(); 
    }
    @FXML
    public void handleButtonTrending(ActionEvent event) throws IOException{
            Parent tableViewParent =FXMLLoader.load(getClass().getResource("Chart.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        Stage window =(Stage)((Node) event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show(); 
    }
    
    
    public void handleButtonSearch(ActionEvent event) throws IOException{
       
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
