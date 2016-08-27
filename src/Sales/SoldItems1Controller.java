/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sales;

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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
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
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author vinay
 */
public class SoldItems1Controller implements Initializable {

    @FXML
    private TextField SalesOverView;
    @FXML
    private TextField SalesInvoice;
    @FXML
    private TextField SalesSoldItems;
    @FXML
    private TableView SITable;
    @FXML
    private ComboBox SIMaterialCombo;
    @FXML
    private TextField SISearchByAnything;
    private Button SIDelSelectedItem;
     @FXML
    private DatePicker SISearchDate;
  
    
    /**
     * Initializes the controller class.
     */
      
  private IntegerProperty index = new SimpleIntegerProperty();
    @FXML
    private Label DailyStatistics;
    @FXML
    private Label WeeklyStatistics;
    @FXML
    private Label MonthlyStatistics;
    @FXML
    private ComboBox<?> StatisticsMaterial;
    @FXML
    private ComboBox<?> StatisticsType;
    @FXML
    private Separator dseparator;
    @FXML
    private Separator wseparator;
    @FXML
    private Separator mseparator;
    @FXML
    private DatePicker SalesFromDate;
    @FXML
    private DatePicker SalesToDate;
    @FXML
    private BarChart<?, ?> SalesBarChart;
    @FXML
    private Button B6;
    @FXML
    private Button B5;
    @FXML
    private Button B4;
    @FXML
    private Button B3;
    @FXML
    private Button B2;
    @FXML
    private Button B1;
    @FXML
    private PieChart PieChartRevenue;
    @FXML
    private PieChart PieChartProfit;
   
    
    public final double getIndex() {
        return index.get();
    }

    
    public final void setIndex(Integer value) {
        index.set(value);
    }

    
    public IntegerProperty indexProperty() {
        return index;
    }
    @FXML
    private void handleSalesOverView(MouseEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("OverView1.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       // app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    private void handleSalesInvoice(MouseEvent event) throws IOException {
    Parent home_page_parent = FXMLLoader.load(getClass().getResource("Invoice1.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       // app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    private void handleSISearch(KeyEvent event) throws SQLException {
        String mate=(String) SIMaterialCombo.getValue();
       
        String query;
        String mat=InvStringClass.getvalue();
        SITable.getColumns().clear();
      SITable.setEditable(true);
      String searchtype=SISearchByAnything.getText();
      if(!SITable.getColumns().isEmpty())
        SITable.getColumns().clear();
           if(mate==null || mate=="None")
        {   
            query="select * from SOLD_ITEMS WHERE (TYPE LIKE '%"+searchtype+"%' OR DESIGN_NAME LIKE '%"+searchtype+"%' OR BARCODE LIKE '%"+searchtype+"%' OR DESIGN_NAME LIKE '%"+searchtype+"%' OR TRANSACTION_NO LIKE '%"+searchtype+"%') "; 
            System.out.println(mate);
            System.out.println("hello world");
        }
           else if("All".equals(mate))
           {
                query="select * from SOLD_ITEMS"; 
                System.out.println("my movie");
           }
            else
           {
                query="select * from SOLD_ITEMS WHERE MATERIAL LIKE '"+mate+"' AND (TYPE LIKE '%"+searchtype+"%' OR DESIGN_NAME LIKE '%"+searchtype+"%' OR BARCODE LIKE '%"+searchtype+"%' OR DESIGN_NAME LIKE '%"+searchtype+"%' OR TRANSACTION_NO LIKE '%"+searchtype+"%') "; 
           }
           
           
           SqlLogin.executeQuery(query,SITable);
      
      SITable.setItems(SqlLogin.data);
        
    }


    private void handleSIGetSoldItemsStat(ActionEvent event) throws SQLException {
         SITable.setEditable(true);
      
      if(!SITable.getColumns().isEmpty())
        SITable.getColumns().clear();
         SqlLogin.executeQuery("select ID,TYPE,MATERIAL,DESIGN_NAME,SALES from INV_STATISTICS",SITable);
          
      SITable.setItems(SqlLogin.data);
             
        
    }
    @FXML
    private void handleSISearchDate(ActionEvent event) throws SQLException {
         SITable.getColumns().clear();
      SITable.setEditable(true);
      LocalDate date=SISearchDate.getValue();
      if(!SITable.getColumns().isEmpty())
        SITable.getColumns().clear();
      SqlLogin.executeQuery("select * from SOLD_ITEMS WHERE DATE_OF_PURCHASE LIKE '"+date+"' ",SITable);      
      SITable.setItems(SqlLogin.data);
    }

    
    

    private void handleSIGetSoldItems(ActionEvent event) throws SQLException {
        SITable.setEditable(true);
      
      if(!SITable.getColumns().isEmpty())
        SITable.getColumns().clear();
       SqlLogin.executeQuery("select * from SOLD_ITEMS ",SITable);
          
      SITable.setItems(SqlLogin.data);
        
        
        
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
          SIMaterialCombo.getItems().clear();
         SIMaterialCombo.getItems().addAll("None","GOLD","SILVER","DIAMOND","BRONZE","PLATINUM","COPPER","Mixed","Other");
        // TODO
        
        
          SIMaterialCombo.getSelectionModel().selectedItemProperty().addListener(new  
ChangeListener<String>() 
{
public void changed(ObservableValue<? extends String> observable,String  
oldValue,String newValue) 
{
    // DesignName.getItems().clear();
    System.out.println("Value is::"+newValue);
    SITable.setEditable(true);
    if(!SITable.getColumns().isEmpty())
        SITable.getColumns().clear();
    try {
        SqlLogin.executeQuery("select * from SOLD_ITEMS WHERE MATERIAL='"+newValue+"' ",SITable);
    } catch (SQLException ex) {
        Logger.getLogger(SoldItems1Controller.class.getName()).log(Level.SEVERE, null, ex);
    }
     InvStringClass.setvalue(newValue);
    SITable.setItems(SqlLogin.data);
}   
});
           SITable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {

            @Override
            public void changed(ObservableValue observable, Object oldvalue, Object newValue) {
               // Person selectedPerson = (Person) newValue;
                setIndex(SqlLogin.data.indexOf(newValue));

                System.out.println("OK");
                
            }
        });
       SIDelSelectedItem.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent e) {
                   Stage stage = new Stage();
                Object root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("InvDelItemPopup.fxml"));
                } catch (IOException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
                stage.setScene(new Scene((Parent) root));
                stage.setTitle("My modal window");
                stage.initModality(Modality.APPLICATION_MODAL);
               stage.initOwner(SIDelSelectedItem.getScene().getWindow());
                stage.showAndWait();
                
                if(InventoryPopupDelete.getvalue()=="delete")
                 {
                     int v=index.get();
                      int checkid=Integer.valueOf((String) SqlLogin.data.get(v).get(0));
                    SqlLogin.data.remove(v);
                    SITable.getSelectionModel().clearSelection();
                    SqlLogin.executeUpdate("DELETE from SOLD_ITEMS where ID='"+checkid+"'"); 
                 }
                if(InventoryPopupDelete.getvalue()=="cancel")
                 {
                     SITable.getSelectionModel().clearSelection();
                 }
                
                //SqlLogin.data.remove(index.get());
               

            }
        });
        
        
        
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
    private void handleDailyStatistics(MouseEvent event) {
    }

    @FXML
    private void handleWeeklyStatistics(MouseEvent event) {
    }

    @FXML
    private void handleMonthlyStatistics(MouseEvent event) {
    }

  
}
