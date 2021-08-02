/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fourkeysteam;

import com.jfoenix.controls.JFXButton;
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
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ChartOrderController implements Initializable {

    @FXML
    private JFXButton btKembali;
    @FXML
    private BarChart bcSayur;
    @FXML
    private NumberAxis sumbuY;
    @FXML
    private CategoryAxis sumbuX;
    @FXML
    private JFXButton btView;

    ObservableList <Order> pesanan1 = FXCollections.observableArrayList();
 
    public void initData (ObservableList <Order> psn){
       
       pesanan1 = psn;
       int Bayam = 0;
       int Kangkung = 0;
       int Sawi = 0;

       for(Order ord:pesanan1){
           switch (ord.getPesanan()){
               case "Bayam" :
                   Bayam += ord.getJumlah();
                   break;

               case "Kangkung" :
                   Kangkung += ord.getJumlah();
                   break;

               case "Sawi" :
                   Sawi += ord.getJumlah();
                   break;
           }


       }

      XYChart.Series<String,Integer> series = new XYChart.Series();     
      series.getData().add(new XYChart.Data<>("Bayam",Bayam));
      series.getData().add(new XYChart.Data<>("Kangkung",Kangkung));
      series.getData().add(new XYChart.Data<>("Sawi",Sawi));
      bcSayur.getData().add(series);

    }
          
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleButtonHome(ActionEvent event) throws IOException {
    Parent tableViewParent = FXMLLoader.load(getClass().getResource("Home1.fxml"));
        Scene tableViewScene = new Scene (tableViewParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
        
    }
    
    @FXML
    private void handleButtonKembali(ActionEvent event) throws IOException {
    Parent tableViewParent = FXMLLoader.load(getClass().getResource("Order.fxml"));
        Scene tableViewScene = new Scene (tableViewParent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
        
    }

    
}
