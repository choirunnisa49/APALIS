/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fourkeysteam;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StandardStaxDriver;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class EditProfileController implements Initializable {

    EditProfile prf = new EditProfile();
    XStream xstream = new XStream(new StaxDriver());
    
    @FXML
    private Label lbNama;

    @FXML
    private Label lbAlamat;

    @FXML
    private Label lbEmail;
    
    
    
    
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    Profile p = new Profile();
    ProfileController pc =new ProfileController();
    lbNama.setText(pc.pf.getNama());
    lbAlamat.setText(pc.pf.getNama());
    lbEmail.setText(pc.pf.getNama());
    }    
    
}
