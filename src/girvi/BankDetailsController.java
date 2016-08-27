/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package girvi;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Vinod
 */
public class BankDetailsController implements Initializable {

    @FXML
    private Pane InvMainPane;
    @FXML
    private Label CustomerName;
    @FXML
    private TableView BankTable;
    @FXML
    private ComboBox BankComboBox;
    @FXML
    private Label ExpectedAmount;
    @FXML
    private Button AddBank;
    @FXML
    private ComboBox itemid;
    @FXML
    private Label GoldRate;
    @FXML
    private TextField SalesOverView;
    @FXML
    private TextField SalesInvoice;
    @FXML
    private TextField SalesInvoice1;
    @FXML
    private TextField SalesSoldItems;
    @FXML
    private TableView itemstable;

    /* Initializes the controller class. */
    
    int tableSNo=0;
    ObservableList<ObservableList> data ;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        data = FXCollections.observableArrayList();
        
        try {
            // TODO
            SqlLogin.executeQueryTiles("select * from items where presentinbank = 'No'");
        } catch (SQLException ex) {
            Logger.getLogger(BankDetailsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int i=0;i<SqlLogin.data.size();++i){
            itemid.getItems().add(SqlLogin.data.get(i).get(0));
        }
        try {
            // TODO
            SqlLogin.executeQueryTiles("select * from banks");
        } catch (SQLException ex) {
            Logger.getLogger(BankDetailsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int i=0;i<SqlLogin.data.size();++i){
            BankComboBox.getItems().add(SqlLogin.data.get(i).get(0));
        }
        
        BankTable.setEditable(true);
      if(!BankTable.getColumns().isEmpty())
        BankTable.getColumns().clear();
        String colName = null;
        for(int i=1;i<4;++i){
                    final int j=i;
                    if(i==1)
                        colName="Item ID";
                    else if(i==2)
                        colName="Bank ID";
                    else if(i==3)
                        colName="Amount expected";
                    TableColumn col=new TableColumn(colName);
                      //col.prefWidthProperty().bind(StoneTable.widthProperty().multiply(0.3));}
                    col.setMinWidth(15);
                    col.setEditable(true);
                    col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                        public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {                                                                                              
                            return new SimpleStringProperty(param.getValue().get(j-1).toString());                        
                        }                    
                    });
        
            BankTable.getColumns().addAll(col);
        }
    }    

    @FXML
    private void handleHome(MouseEvent event) throws IOException {
        
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       // app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
        
    }

    @FXML
    private void SaveDetails(ActionEvent event) {
    }

    @FXML
    private void handleAddBank(ActionEvent event) {
                        Stage stage = new Stage();
                        Object root = null;
                        try {
                            root = FXMLLoader.load(getClass().getResource("AddBank.fxml"));
                        } catch (IOException ex) {
                            Logger.getLogger(BankDetailsController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        stage.setScene(new Scene((Parent) root));
                        stage.initModality(Modality.APPLICATION_MODAL);
                        stage.initOwner(AddBank.getScene().getWindow());
                        stage.showAndWait();
    }

    @FXML
    private void handleSalesOverView(MouseEvent event) {
    }

    @FXML
    private void handleSalesSoldItems(MouseEvent event) {
    }

    @FXML
    private void LoadDetails(ActionEvent event) {
        int ID = Integer.parseInt((String) itemid.getValue());
        try {
            SqlLogin.executeQueryTiles("select invoiceid from items where id = " + ID);
        } catch (SQLException ex) {
            Logger.getLogger(BankDetailsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        int InvoiceID = Integer.parseInt((String)SqlLogin.data.get(0).get(0));
        try {
            SqlLogin.executeQueryTiles("select customer from invoice where id = " + InvoiceID);
        } catch (SQLException ex) {
            Logger.getLogger(BankDetailsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        CustomerName.setText((String) SqlLogin.data.get(0).get(0));
        itemstable.setEditable(true);
      
                    if(!itemstable.getColumns().isEmpty())
                        itemstable.getColumns().clear();
                    try {
                        SqlLogin.executeQuery("select * from items where id = " + ID,itemstable);
                    } catch (SQLException ex) {
                        Logger.getLogger(BankDetailsController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                        itemstable.setItems(SqlLogin.data);
                        
        BankComboBox.setValue(null);
        ExpectedAmount.setText("0");
    }

    @FXML
    private void handleLoadExpected(ActionEvent event) {
        int bankid = Integer.parseInt((String) BankComboBox.getValue());
        try {
            SqlLogin.executeQueryTiles("select * from banks where id = " + bankid);
        } catch (SQLException ex) {
            Logger.getLogger(BankDetailsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ObservableList<String> instance = (ObservableList<String>) itemstable.getItems().get(0);
        float grossweight = Float.parseFloat(instance.get(4));
        float purity = Float.parseFloat(instance.get(5))/100;
        float percent = Float.parseFloat((String) SqlLogin.data.get(0).get(4))/100;
        int expected = (int) (grossweight * purity * percent * 3000);
        ExpectedAmount.setText(Integer.toString(expected));
    }

    @FXML
    private void AddToTable(ActionEvent event) {
        tableSNo++;
        String Itemid = (String) itemid.getValue();
        String Bankid = (String) BankComboBox.getValue();
        LocalDate date = LocalDate.now();
        String Expected = (String) ExpectedAmount.getText();
        
        ObservableList<String> instance = FXCollections.observableArrayList();
        instance.add(Itemid);
        instance.add(Bankid);
        instance.add(Expected);
        BankTable.setEditable(true);
        data.add(instance);
        BankTable.setItems(data);
        itemid.setValue(null);
        ExpectedAmount.setText("0");
    }
    
}
