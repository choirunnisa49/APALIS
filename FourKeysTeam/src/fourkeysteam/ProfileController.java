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
import java.time.Instant;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import util.DateUtil;
/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ProfileController implements Initializable {

    @FXML
    private TableView<Profile> tbView;
    @FXML
    private TableColumn<Profile,String> tcNama;
    @FXML
    private TableColumn<Profile,String> tcAlamat;
    
    
    
    
    @FXML
    private ToggleGroup GenderToggle;
    
    @FXML
    private TextField tfNama; 
    
    @FXML
    private TextField tfAlamat;
    
    @FXML
    private TextField tfEmail; 
    
    @FXML
    private TextField tfPassword; 
    
    @FXML 
    private RadioButton rbLaki;
    
    @FXML 
    private RadioButton rbPr;
    
    @FXML
    private DateUtil duUltah;
    
    Profile pf = new Profile();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tcNama.setCellValueFactory(new PropertyValueFactory<Profile,String>("Nama"));
        tcAlamat.setCellValueFactory(new PropertyValueFactory<Profile,String>("Alamat"));
       
       
        
        tbView.setItems(getPoeple());
        
        tbView.setEditable(true);
        tcNama.setCellFactory(TextFieldTableCell.forTableColumn());
        tcAlamat.setCellFactory(TextFieldTableCell.forTableColumn());
             
        tbView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }
    
   /*  public void gantiNamaCellEvent(TableColumn.CellEditEvent edditedCell){
        Profile pemesanDipilih = tbView.getSelectionModel().getSelectedItem();
        pemesanDipilih.setNama(edditedCell.getNewValue().toString());
                
    }*/
    
    public void newPemesanButtonPushed(){
        Profile newPemesan = new Profile (tfNama.getText(),
                                          tfAlamat.getText());
                                          
                                          
        tbView.getItems().addAll(newPemesan);
    }
   
    public ObservableList<Profile> getPoeple(){
        ObservableList<Profile> poeple = FXCollections.observableArrayList();
        poeple.add(new Profile(null,null,null,null));
        
        return poeple;
    }
    
    @FXML
    private void handleButtonHome(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Home2.fxml"));
        Scene tableViewScene = new Scene (tableViewParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
        
    }
    
    @FXML
    private void handleButtonTes(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("EditProfile.fxml"));
        Scene tableViewScene = new Scene (tableViewParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
        
    }
    
    @FXML
    private void handleButtonSimpan (ActionEvent event) { 
    
     Profile newPemesan = new Profile (tfNama.getText(),
                                          tfAlamat.getText(),
                                          tfEmail.getText(),
                                        tfPassword.getText());
        tbView.getItems().addAll(newPemesan);
        
        
    Window stage = tfNama.getScene().getWindow();
    // mengakses isi dari tampilan dan disimpan di objek
        
        
    
    pf.setNama(tfNama.getText());
    pf.setAlamat(tfAlamat.getText());
    if (rbLaki.isSelected()) pf.setGender("Male");
            else if (rbPr.isSelected()) pf.setGender("Female");
    pf.setEmail(tfEmail.getText());
    pf.setPassword(tfPassword.getText());
    
    simpanXML(stage, pf);
    tfNama.setText("");
    tfAlamat.setText("");
    tfEmail.setText("");
    tfPassword.setText("");
    
   
    }
    
    public static void simpanXML(Window stage, Profile pf) {
    
    XStream xstream = new XStream(new StaxDriver());
    String sxml = xstream.toXML(pf);
    
        FileOutputStream f = null;
        //TODO panggil filechooser
    
        try{
            f = new FileOutputStream(chooseFile(stage));
            byte[] bytes = sxml.getBytes("UTF-8");
            f.write(bytes);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
    private static File chooseFile(Window stage){
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File(System.getProperty("user.dir")));
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML Files", ".xml") );
        File xmlTerpilih = fc.showSaveDialog(stage);
    
        return xmlTerpilih;
    }
     @FXML
    public void handleButtonLoad(ActionEvent event){
        Profile pf = new Profile();

        // menampilkan file chooser dan memilih file XML-nya
        String xmlFile = pilihLoadFile();
        
        // mengambil data dari XML-nya dimasukkan ke objek
        pf = openXML(xmlFile);
        
        // menampilkan data objek ke interface
        tfNama.setText(pf.getNama());
        tfAlamat.setText(pf.getAlamat());
        tfEmail.setText(pf.getEmail());
        tfPassword.setText(pf.getPassword());
        
        if(pf.getGender().equals("Male")){
            rbLaki.setSelected(true);
            rbPr.setSelected(false);
        }
        else {
            if(pf.getGender().equals("Female")){
                rbLaki.setSelected(false);
                rbPr.setSelected(true);
            }
        }
        
    }
    
    public static String pilihLoadFile(){
        String pathXML = "";
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File(System.getProperty("user.dir")));
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML Files", ".xml") );
        File xmlTerpilih = fc.showOpenDialog(null);
        if(xmlTerpilih == null){
            // show alert
        }
        else{
            pathXML = xmlTerpilih.getAbsolutePath();
        }
        return pathXML;
    }
    
    public static Profile openXML(String fileXML) {
    Profile pf = new Profile();
    XStream xstream =  new XStream(new StandardStaxDriver());
    FileInputStream f = null;
   
    try{
    
    f = new FileInputStream(fileXML);
    
        int isi;
        char c;
        String sxml="";
        
        while((isi=f.read()) != -1){
            c = (char) isi;
            sxml = sxml +c;
        } 
        pf = (Profile)xstream.fromXML(sxml);
    }
    catch (Exception e){
        // show alerts
        System.out.println(e);
    }
    return pf;
    }
    }
    

   
