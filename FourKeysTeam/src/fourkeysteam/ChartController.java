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
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ChartController implements Initializable {

    
    XYChart.Series<String,Integer> series = new XYChart.Series();
    
    
    @FXML
    private LineChart lcSayur;

    @FXML
    private Button btKembali;

    @FXML
    private Button btSedikit;
    
    @FXML
    private Button btBanyak;
    
    @FXML
    private void handleButtonLainnya(ActionEvent event) {
    series.getData().add(new XYChart.Data<>("Kol",20));
    }
    
    @FXML
    private void handleButtonSedikit(ActionEvent event) {
    series.getData().remove(0);
    }
    
    @FXML
    private void handleButtonKembali(ActionEvent event) throws IOException  {
         Parent tableViewParent =FXMLLoader.load(getClass().getResource("Chart.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        Stage window =(Stage)((Node) event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show(); 
    
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    series.getData().add(new XYChart.Data<>("Bayam",50));
    series.getData().add(new XYChart.Data<>("Kangkung",30));
    series.getData().add(new XYChart.Data<>("Sawi",30));
    
    lcSayur.getData().add(series);
    }    
    
}
