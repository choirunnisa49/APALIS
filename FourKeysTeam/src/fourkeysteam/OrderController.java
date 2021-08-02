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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class OrderController implements Initializable {

     XStream xstream = new XStream(new StaxDriver());
    @FXML
    private TableView<Order> tbView;
    @FXML
    private TableColumn<Order,String> tcNama;
    @FXML
    private TableColumn<Order,String> tcAlamat;
    @FXML
    private TableColumn<Order,String> tcPesanan;
    @FXML
    private TableColumn<Order,String> tcJumlah;
    @FXML
    private TableColumn<Order,String> tcPembayaran;
    @FXML
    private TextField tfNama;
    @FXML
    private TextField tfAlamat;
    @FXML
    private TextField tfPesanan;
    @FXML
    private TextField tfJumlah;
    @FXML
    private TextField tfPembayaran;
    
    
    
    

    public void gantiNamaCellEvent(CellEditEvent edditedCell){
        Order pemesanDipilih = tbView.getSelectionModel().getSelectedItem();
        pemesanDipilih.setNama(edditedCell.getNewValue().toString());
                
    }
    
    public void gantiAlamatCellEvent(CellEditEvent edditedCell){
        Order pemesanDipilih = tbView.getSelectionModel().getSelectedItem();
        pemesanDipilih.setAlamat(edditedCell.getNewValue().toString());
                
    }
    
    public void gantiPesananCellEvent(CellEditEvent edditedCell){
        Order pemesanDipilih = tbView.getSelectionModel().getSelectedItem();
        pemesanDipilih.setPesanan(edditedCell.getNewValue().toString());
                
    }
    public void gantiJumlahCellEvent(CellEditEvent edditedCell){
        Order pemesanDipilih = tbView.getSelectionModel().getSelectedItem();
        pemesanDipilih.setJumlah(edditedCell.getNewValue().toString());
                
    }
    public void gantiPembayaranCellEvent(CellEditEvent edditedCell){
        Order pemesanDipilih = tbView.getSelectionModel().getSelectedItem();
        pemesanDipilih.setPembayaran(edditedCell.getNewValue().toString());
                
    }
    
    public void newPemesanButtonPushed(){
        Order newPemesan = new Order (tfNama.getText(),
                                          tfAlamat.getText(),
                                          tfPesanan.getText(),
                                          tfJumlah.getText(),
                                          tfPembayaran.getText());
        tbView.getItems().add(newPemesan);
        tfNama.setText("");
        tfAlamat.setText("");
        tfPesanan.setText("");
        tfJumlah.setText("");
        tfPembayaran.setText("");
    }
    
    public ObservableList<Order> getPoeple(){
        ObservableList<Order> poeple = FXCollections.observableArrayList();
        poeple.add(new Order(null,null,null,null,null));
        
        return poeple;
    }
    
    public void HapusButtonPushed(){
        ObservableList<Order>selectedRows, allPoeple;
        allPoeple = tbView.getItems();
        
        selectedRows = tbView.getSelectionModel().getSelectedItems();
        for(Order pemesan: selectedRows){
            allPoeple.remove(pemesan);
        }
    }
    
    @FXML
    private void handleButtonKembali(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Home1.fxml"));
        Scene tableViewScene = new Scene (tableViewParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
        
    }
    
    @FXML
    private void handleButtonHome(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Home1.fxml"));
        Scene tableViewScene = new Scene (tableViewParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tcNama.setCellValueFactory(new PropertyValueFactory<Order,String>("Nama"));
        tcAlamat.setCellValueFactory(new PropertyValueFactory<Order,String>("Alamat"));
        tcPesanan.setCellValueFactory(new PropertyValueFactory<Order,String>("Pesanan"));
        tcJumlah.setCellValueFactory(new PropertyValueFactory<Order,String>("Jumlah")); 
        tcPembayaran.setCellValueFactory(new PropertyValueFactory<Order,String>("Pembayaran"));
        
        tbView.setItems(getPoeple());
        
        tbView.setEditable(true);
        tcNama.setCellFactory(TextFieldTableCell.forTableColumn());
        tcAlamat.setCellFactory(TextFieldTableCell.forTableColumn());
        tcPesanan.setCellFactory(TextFieldTableCell.forTableColumn());
        tcJumlah.setCellFactory(TextFieldTableCell.forTableColumn());
        tcPembayaran.setCellFactory(TextFieldTableCell.forTableColumn());
        tbView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    @FXML
    private void handleButtonSimpan(ActionEvent event) throws IOException {
    
    Window stage = tfNama.getScene().getWindow();
        
    Order o = new Order();
    o.setNama(tfNama.getText());
    o.setAlamat(tfAlamat.getText());
    o.setPesanan(tfPesanan.getText());
    o.setJumlah(tfJumlah.getText());
    o.setPembayaran(tfPembayaran.getText());
    
    simpanXML(stage,o);
        
    
    }
    
    public static void simpanXML(Window stage, Order a) {
    
    XStream xstream = new XStream(new StaxDriver());
    String sxml = xstream.toXML(a);
    
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
    public void load(ActionEvent event){
        Order o= new Order();

        // menampilkan file chooser dan memilih file XML-nya
        String xmlFile = pilihLoadFile();
        
        // mengambil data dari XML-nya dimasukkan ke objek
        o = openXML(xmlFile);
        
        // menampilkan data objek ke interface
          
    o.setNama(tfNama.getText());
    o.setAlamat(tfAlamat.getText());
    o.setPesanan(tfPesanan.getText());
    o.setJumlah(tfJumlah.getText());
    o.setPembayaran(tfPembayaran.getText());
    
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
    
    public static Order openXML(String fileXML) {
    Order o = new Order();
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
        o = (Order)xstream.fromXML(sxml);
    }
    catch (Exception e){
        // show alerts
        System.out.println(e);
    }
    return o;
    }

    
}
