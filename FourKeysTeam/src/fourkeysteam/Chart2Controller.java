/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fourkeysteam;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button; 
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class Chart2Controller implements Initializable {
    
    XYChart.Series<String,Integer> series = new XYChart.Series();

    
    @FXML
    private Button btView;
    
    @FXML
    private BarChart bcSayur;
    
    @FXML
    private CategoryAxis sumbuX;

    @FXML
    private NumberAxis sumbuY;

    @FXML
    private Button btKembali;

    
    ArrayList<Chart> daftarSayur;
    XYChart.Series sr;
    
    
    @FXML
    private void handleButtonKembali(ActionEvent event) throws IOException {
        Parent tableViewParent =FXMLLoader.load(getClass().getResource("Home2.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        Stage window =(Stage)((Node) event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show(); 
    }
    
    @FXML
    private void handleButtonViewAnother(ActionEvent event) throws IOException {
        Parent tableViewParent =FXMLLoader.load(getClass().getResource("Chart1.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        Stage window =(Stage)((Node) event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show(); 
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    daftarSayur = new ArrayList<>();
    
    daftarSayur.add(new Chart("Aiman","Bayam"));
    daftarSayur.add(new Chart("Andi","Bayam"));
    daftarSayur.add(new Chart("Eka","Kangkung"));
    daftarSayur.add(new Chart("Nugroho","Bayam"));
    daftarSayur.add(new Chart("Setyo","Kangkung"));
    daftarSayur.add(new Chart("Budi","Bayam"));
    daftarSayur.add(new Chart("Indah","Kangkung"));
    daftarSayur.add(new Chart("Malihah","Bayam"));
    daftarSayur.add(new Chart("Bunga","Sawi"));
    daftarSayur.add(new Chart("Nely","Sawi"));
    daftarSayur.add(new Chart("Chika","Sawi"));
    
       
   int jmlBayam = 0;
   int jmlKangkung = 0;
   int jmlSawi = 0;
    
   for (Chart syr : daftarSayur){
   if (syr.getSayuran().equals("Bayam")) ++jmlBayam;
   else if(syr.getSayuran().equals("Kangkung")) ++jmlKangkung;
   else ++jmlSawi;          
   }
   
   jmlBayam = jmlBayam*10;
   jmlKangkung = jmlKangkung*10;
   jmlSawi = jmlSawi*10;
   
   sr =new XYChart.Series();
   
   sr.getData().add(new XYChart.Data("Bayam", jmlBayam));
   sr.getData().add(new XYChart.Data("Kangkung", jmlKangkung));
   sr.getData().add(new XYChart.Data("Sawi", jmlSawi));
   
   bcSayur.getData().add(sr);
    } 
    
    
    
}
