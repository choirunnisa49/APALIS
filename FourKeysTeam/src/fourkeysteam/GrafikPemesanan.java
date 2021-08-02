/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fourkeysteam;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 *
 * @author Bagus Anugrah P
 * Grafik Pemesanan APALIS
 */
public class GrafikPemesanan extends Application {
private TableView<XYChart.Data> tableView = new TableView<>(); 

private ObservableList<XYChart.Data> dataList =
FXCollections.observableArrayList(
new XYChart.Data("January", 0),
new XYChart.Data("February", 0),
new XYChart.Data("March", 0),
new XYChart.Data("April", 0),
new XYChart.Data("May", 0),
new XYChart.Data("June", 0),
new XYChart.Data("July", 0),
new XYChart.Data("August", 0),
new XYChart.Data("September", 0),
new XYChart.Data("October", 0),
new XYChart.Data("November", 0),
new XYChart.Data("December", 0));
 
/**
* @param args the command line arguments
*/
public static void main(String[] args) {
launch(args);
}
 
@Override
    public void start(Stage primaryStage) {
    primaryStage.setTitle("Grafik Pemesanan Sayur"); 
    Group root = new Group(); 
    tableView.setEditable(true);
    Callback<TableColumn, TableCell> cellFactory =
    new Callback<TableColumn, TableCell>() {

@Override
    public TableCell call(TableColumn p) {
    return new EditingCell();
    }
  };
 
TableColumn columnMonth = new TableColumn("Bulan");
columnMonth.setCellValueFactory(
new PropertyValueFactory<XYChart.Data,String>("XValue"));
 
TableColumn columnValue = new TableColumn("Total Pemesanan");
columnValue.setCellValueFactory(
new PropertyValueFactory<XYChart.Data,Number>("YValue"));
 
//Menambah Edit dari Tabel Pemesanan
columnValue.setCellFactory(cellFactory);
 
columnValue.setOnEditCommit(
new EventHandler<TableColumn.CellEditEvent<XYChart.Data, Number>>() {

    @Override public void handle(TableColumn.CellEditEvent<XYChart.Data, Number> t) {
    ((XYChart.Data)t.getTableView().getItems().get(
    t.getTablePosition().getRow())).setYValue(t.getNewValue());
    }
  });
  
//Grafik Garis Pemesanan
final CategoryAxis xAxis = new CategoryAxis();
final NumberAxis yAxis = new NumberAxis();
 
xAxis.setLabel("Bulan");
yAxis.setLabel("Total Pemesanan");
 
final LineChart<String, Number> lineChart = new LineChart<>(xAxis,yAxis);
 
lineChart.setTitle("Laju Pemesanan/Bulan");
XYChart.Series series = new XYChart.Series(dataList);
series.setName("APALIS.corp");
lineChart.getData().add(series);
 
//TabelView Data Pemesanan
 
tableView.setItems(dataList);
tableView.getColumns().addAll(columnMonth, columnValue);
 
//--
 
HBox hBox = new HBox();
hBox.setSpacing(10);
hBox.getChildren().addAll(tableView, lineChart);
 
root.getChildren().add(hBox);
 
primaryStage.setScene(new Scene(root, 670, 400));
primaryStage.show();
}
 
class EditingCell extends TableCell<XYChart.Data, Number> {
 
private TextField textField;
 
public EditingCell() {}
 
@Override
    public void startEdit() {
    super.startEdit();
 
    if (textField == null) {
        createTextField();
}
 
setGraphic(textField);
setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
textField.selectAll();
}
 
@Override
    public void cancelEdit() {
    super.cancelEdit();
 
setText(String.valueOf(getItem()));
setContentDisplay(ContentDisplay.TEXT_ONLY);
}
 
@Override
    public void updateItem(Number item, boolean empty) {
    super.updateItem(item, empty);
 
    if (empty) {
    setText(null);
    setGraphic(null);
        } else {
            if (isEditing()) {
                if (textField != null) {
                    textField.setText(getString());
}
setGraphic(textField);
setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        } else {
setText(getString());
setContentDisplay(ContentDisplay.TEXT_ONLY);
        }
    }
}
 
private void createTextField() {
textField = new TextField(getString());
textField.setMinWidth(this.getWidth() - this.getGraphicTextGap()*2);
textField.setOnKeyPressed(new EventHandler<KeyEvent>() {
 
@Override
    public void handle(KeyEvent t) {
    if (t.getCode() == KeyCode.ENTER) {
    commitEdit(Double.parseDouble(textField.getText()));
        } else if (t.getCode() == KeyCode.ESCAPE) {
            cancelEdit();
        }
    }
  });
}
 
private String getString() {
return getItem() == null ? "" : getItem().toString();
    }
  }
}
