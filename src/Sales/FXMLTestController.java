/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sales;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PauseTransition;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;


/**
 * FXML Controller class
 *
 * @author vinay
 */
public class FXMLTestController implements Initializable {

    /**
     * Initializes the controller class.
     */
    //  @FXML
    //private TableView table;
    @FXML
    private Tab Customer,WholeSaler,Karigar,GSR,Inventory;
    @FXML
    private Button addCustomerData,getCustomerData;
    @FXML
    private Button addKarigarData,getKarigarData;
    @FXML
    private Button addWholeSalerData,getWholeSalerData,InvoiceAdditem,InvoiceSelectItems;
    @FXML
    private Button addTodayRate,getRates;
    @FXML
    private Button getOrnamentRequests,AddNewOrnRequest,DelSelectedItem;
    @FXML
    private TableView table1,table2,table3,table4,table5,table6,table7,table8,table9;
    @FXML
    private TextField SearchCustomer,InvoiceBarcode,DeleteCustomerField,SearchWholeSaler,SearchKarigar,SearchInventory;
    @FXML
    private DatePicker FromDate,ToDate,Date;
    @FXML
    private Label DelShow;
    @FXML
    private  TableView table = new TableView();
    ObservableList<ObservableList> arrdata = FXCollections.observableArrayList();
      private IntegerProperty index = new SimpleIntegerProperty();


    public final double getIndex() {
        return index.get();
    }

    
    public final void setIndex(Integer value) {
        index.set(value);
    }

    
    public IntegerProperty indexProperty() {
        return index;
    }

  //  public ObservableList<ObservableList> arrdata;
     //arrdata=FXCollections.observableArrayList();
    @FXML
    private void handlegetKarigarData(ActionEvent event) throws SQLException{
       
      table3.setEditable(true);
      
      if(!table3.getColumns().isEmpty())
        table3.getColumns().clear();
      SqlLogin.executeQuery("select * from KARIGAR",table3);      
          
      table3.setItems(SqlLogin.data);
      
               
   }
    @FXML
    private void handleaddKarigarData(ActionEvent event) throws SQLException, IOException{
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLAddKarigar.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
   }
    
    
    
    @FXML
    private void handlegetCustomerData(ActionEvent event) throws SQLException{
       
      table1.setEditable(true);
      
      if(!table1.getColumns().isEmpty())
        table1.getColumns().clear();
      SqlLogin.executeQuery("select * from CUSTOMER",table1);      
          
      table1.setItems(SqlLogin.data);
               
   }
   @FXML
    private void handleaddCustomerData() throws SQLException, IOException{
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLAddCustomer.fxml"));
        stage.setTitle("Add new entry");
        stage.setScene(new Scene(root, 800, 600));
        stage.show();
   }
    
     @FXML
    private void handleDeleteCustomer(ActionEvent event) throws SQLException{
       
     int id = Integer.parseInt(DeleteCustomerField.getText());
      SqlLogin.executeUpdate("delete from CUSTOMER WHERE ID='"+id+"'");      
          DeleteCustomerField.clear();
         //DelShow.setVisible(false);
                table1.setEditable(true);
      
      if(!table1.getColumns().isEmpty())
        table1.getColumns().clear();
      SqlLogin.executeQuery("select * from CUSTOMER",table1);      
          
      table1.setItems(SqlLogin.data);
   }
    
    
   @FXML
    private void handlegetInventory(ActionEvent event) throws SQLException{
       
      table5.setEditable(true);
      
      if(!table5.getColumns().isEmpty())
        table5.getColumns().clear();
      SqlLogin.executeQuery("select * from INVENTORY",table5);      
          
      table5.setItems(SqlLogin.data);
               
   }
   @FXML
    private void handleaddInventory(ActionEvent event) throws SQLException, IOException{
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLAddInventory.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
   }
    
    
    
    
    @FXML
    private void handlegetWholeSalerData(ActionEvent event) throws SQLException{
       
      table2.setEditable(true);
      
      if(!table2.getColumns().isEmpty())
        table2.getColumns().clear();
      SqlLogin.executeQuery("select * from WHOLESALER",table2);      
          
      table2.setItems(SqlLogin.data);
               
   }
    @FXML
    private void handleaddWholeSalerData() throws SQLException, IOException{
       /* Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLAddWholeSaler.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();*/
       Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLAddWholeSaler.fxml"));
        stage.setTitle("Add new entry");
        stage.setScene(new Scene(root, 800, 600));
        stage.show();
   }
    
    
    
    @FXML
    private void handlegetRates(ActionEvent event) throws SQLException{
       
      table4.setEditable(true);
      
      if(!table4.getColumns().isEmpty())
        table4.getColumns().clear();
      SqlLogin.executeQuery("select * from RATES",table4);      
          
      table4.setItems(SqlLogin.data);
               
   }
    @FXML
    private void handleaddTodayRate(ActionEvent event) throws SQLException, IOException{
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLAddTodayRate.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
   }
    @FXML
    private void handleSearchCustomer() throws SQLException{
       table1.getColumns().clear();
      table1.setEditable(true);
      String searchname=SearchCustomer.getText();
      if(!table1.getColumns().isEmpty())
        table1.getColumns().clear();
      SqlLogin.executeQuery("select * from CUSTOMER WHERE NAME LIKE '%"+searchname+"%' OR PHONE_NO LIKE '"+searchname+"%'",table1);      
          
      table1.setItems(SqlLogin.data);
               
   }
    @FXML
    private void handleSearchWholeSaler() throws SQLException{
       table2.getColumns().clear();
      table2.setEditable(true);
      String searchname=SearchWholeSaler.getText();
      if(!table2.getColumns().isEmpty())
        table2.getColumns().clear();
      SqlLogin.executeQuery("select * from WHOLESALER WHERE NAME LIKE '%"+searchname+"%' OR PHONE_NO LIKE '"+searchname+"%'",table2);      
      table2.setItems(SqlLogin.data);
               
   } 
    
     @FXML
    private void handleSearchKarigar() throws SQLException{
       table3.getColumns().clear();
      table3.setEditable(true);
      String searchname=SearchKarigar.getText();
      if(!table3.getColumns().isEmpty())
        table3.getColumns().clear();
      SqlLogin.executeQuery("select * from KARIGAR WHERE NAME LIKE '%"+searchname+"%' OR SPECIALITY LIKE '"+searchname+"%' OR PHONE_NO LIKE '"+searchname+"%'",table3);      
      table3.setItems(SqlLogin.data);
               
   } 
     @FXML
    private void handleSearchBetweenDate() throws SQLException{
       table4.getColumns().clear();
      table4.setEditable(true);
      LocalDate date1=FromDate.getValue();
       LocalDate date2=ToDate.getValue();
      if(!table4.getColumns().isEmpty())
        table4.getColumns().clear();
      SqlLogin.executeQuery("select * from RATES WHERE DATE BETWEEN '"+date1+"' and '"+date2+"'",table4);      
      table4.setItems(SqlLogin.data);
               
   } 
    @FXML
    private void handleSearchDate() throws SQLException{
       table4.getColumns().clear();
      table4.setEditable(true);
       LocalDate date=Date.getValue();
      if(!table4.getColumns().isEmpty())
        table4.getColumns().clear();
      SqlLogin.executeQuery("select * from RATES WHERE DATE LIKE '"+date+"%'",table4);      
      table4.setItems(SqlLogin.data);
               
   } 
    
  @FXML
    private void handleSearchInventory() throws SQLException{
       table5.getColumns().clear();
      table5.setEditable(true);
      String searchtype=SearchInventory.getText();
      if(!table5.getColumns().isEmpty())
        table5.getColumns().clear();
      SqlLogin.executeQuery("select * from INVENTORY WHERE TYPE LIKE '%"+searchtype+"%'",table5);      
      table5.setItems(SqlLogin.data);
               
   } 
     @FXML
    private void handlegetOrnamentRequests(ActionEvent event) throws SQLException{
       
      table6.setEditable(true);
      
      if(!table6.getColumns().isEmpty())
        table6.getColumns().clear();
      SqlLogin.executeQuery("select * from ORNAMENT_REQ_DETAILS",table6);      
          
      table6.setItems(SqlLogin.data);
    }
    
     @FXML
    private void handleNewOrnRequest(ActionEvent event) throws SQLException, IOException{
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLAddNewOrnRequest.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
   }
     @FXML
    private void handleInvoiceAddItem(ActionEvent event) throws SQLException{
       

      String barcode=InvoiceBarcode.getText();
    //  
    //if(!table7.getColumns().isEmpty())
        //table7.getColumns().clear();
       //TableColumn firstNameCol = new TableColumn("First Name");
      SqlLogin.executeInvQuery("select ID,BARCODE,TYPE,MATERIAL,DESIGN_NAME,PURITY,NET_WEIGHT,GROSS_WEIGHT,SELLING_PRICE from INVENTORY where BARCODE='"+barcode+"'",table7);      
      // SqlLogin.executeUpdate(" Insert into INVOICE" + "Values( NULL, '"+name+"', '"+mobileno+"','"+city+"',1,'"+behaviour+"',4)" );   
      // final Button addButton = new Button("InvoiceAddItem");
       // InvoiceAdditem.setOnAction(new EventHandler<ActionEvent>() {
          //  @Override public void handle(ActionEvent e) {
           //     data.add(new Person("new","new","new"));
         //   }
       // });
      // table7.getColumns().addAll("firstNameCol");
     // data.add("SqlLogin.data.get(0).get(0)");
      System.out.println(SqlLogin.data.get(0));
     arrdata.add(SqlLogin.data.get(0));
      System.out.println("yo yo yo");
    System.out.println(arrdata);
      table7.setEditable(true);
     table7.setItems(arrdata);
      
      //table7.setVisible(true);
      InvoiceBarcode.clear();
   }
    @FXML
    private void handleInvoiceSelectItems(ActionEvent event) throws SQLException{
            
    
    
    }
     @FXML
    private void handleDeleteSelectedItem(ActionEvent event) throws SQLException{
            
    //data.remove(index.get());
             //   table.getSelectionModel().clearSelection();
    }
    @FXML
    private void handleConfirm(ActionEvent event) throws SQLException{
        
        
    }
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        table1.setEditable(true);
      
      if(!table1.getColumns().isEmpty())
        table1.getColumns().clear();
        try {      
            SqlLogin.executeQuery("select * from CUSTOMER",table1);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLTestController.class.getName()).log(Level.SEVERE, null, ex);
        }
          
      table1.setItems(SqlLogin.data);
      
      table2.setEditable(true);
      
      if(!table2.getColumns().isEmpty())
        table2.getColumns().clear();
        try {      
            SqlLogin.executeQuery("select * from WHOLESALER",table2);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLTestController.class.getName()).log(Level.SEVERE, null, ex);
        }
          
      table2.setItems(SqlLogin.data);
      
      table3.setEditable(true);
      
      if(!table3.getColumns().isEmpty())
        table3.getColumns().clear();
        try {      
            SqlLogin.executeQuery("select * from KARIGAR",table3);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLTestController.class.getName()).log(Level.SEVERE, null, ex);
        }
          
      table3.setItems(SqlLogin.data);
      
      table7.setEditable(true);
      if(!table7.getColumns().isEmpty())
        table7.getColumns().clear();
      String colName = null;
        for(int i=0;i<9;++i){
                    final int j=i;
                    if(i==0)
                        colName="ID";
                    else if(i==1)
                        colName="Barcode";
                    else if(i==2)
                        colName="Type";
                    else if(i==3)
                        colName="Material";
                    else if(i==4)
                        colName="DesignName";
                    else if(i==5)
                        colName="Purity";
                    else if(i==6)
                        colName="NetWeight";
                    else if(i==7)
                        colName="GrossWeight";
                    else if(i==8)
                        colName="Price";
                    
                    TableColumn col=new TableColumn(colName);
                    col.setMinWidth(55);
                    col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                        @Override
                        public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {                                                                                              
                            return new SimpleStringProperty(param.getValue().get(j).toString());                        
                        }                    
                    });
      
      table7.getColumns().addAll(col);
      
        }
         indexProperty().addListener(new ChangeListener() {

            @Override
            public void changed(ObservableValue o, Object oldVal,
                    Object newVal) {
                System.out.println("Index has changed!");
            }
        });
         
         
        table7.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {

            @Override
            public void changed(ObservableValue observable, Object oldvalue, Object newValue) {
               // Person selectedPerson = (Person) newValue;
                setIndex(arrdata.indexOf(newValue));

                System.out.println("OK");





            }
        });
         DelSelectedItem.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {

                arrdata.remove(index.get());
                table7.getSelectionModel().clearSelection();

            }
        });
      
      
       /*table7.getColumns().clear(); 
        table7.setEditable(true);
      TableColumn id = new TableColumn("ID");
        TableColumn barcode = new TableColumn("Barcode");
        TableColumn type = new TableColumn("Type");
        TableColumn material = new TableColumn("Material");
        TableColumn designname = new TableColumn("Design_Name");
        TableColumn purity = new TableColumn("Purity");
        TableColumn netweight = new TableColumn("NetWeight");
        TableColumn grossweight = new TableColumn("GrossWeight");
        TableColumn sellingprice = new TableColumn("SellingPrice");
        
        
        table7.getColumns().addAll(id,barcode,type,material,designname,purity,netweight,grossweight,sellingprice);
         //table7.setItems(SqlLogin.data);
        
        */
    }
        // TODO
       /* table7.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {

            @Override
            public void changed(ObservableValue observable, Object oldvalue, Object newValue) {
          
              //  setIndex(data.indexOf(newValue));

                System.out.println("OK");
             





            }

            
        });
       */
    
}