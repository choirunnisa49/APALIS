/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fourkeysteam;

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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class OrderController1 implements Initializable {

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
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Home2.fxml"));
        Scene tableViewScene = new Scene (tableViewParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
        
    }
    
    @FXML
    private void handleButtonHome(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Home2.fxml"));
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
    
}
