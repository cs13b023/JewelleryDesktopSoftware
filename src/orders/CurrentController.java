/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orders;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Separator;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hemanth Reddy
 */


public class CurrentController implements Initializable {
    
    @FXML
    private TextField Current;
    @FXML
    private TextField Overview;
    @FXML
    private TextField Karigar;
    @FXML
    private Separator Underline1; 
    @FXML
    private Separator Underline2; 
    @FXML
    private Separator Underline3; 
    @FXML
    private ComboBox Status;
    @FXML
    private TableView Table1;
    @FXML
    private TableView Table2;
    @FXML
    private TableView Table3;
    @FXML
    private TextField Search;
    @FXML
    private TextField Home;
    
    @FXML
    private TextField Sales;
    @FXML
    private TextField Inventory;
    @FXML
    private TextField loyalty;
    
    @FXML
    private TextField Girvi;
    @FXML
    private TextField Loans;
    @FXML
    private TextField Orders;
    @FXML
    private TextField employee;


    
    @FXML
    public void handleSales(MouseEvent event) throws IOException {
       Parent home_page_parent = FXMLLoader.load(getClass().getResource("/SalesAndInventory/OverView1.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       // app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();   
    }

    @FXML
    public void handleInventory(MouseEvent event) throws IOException {
      Parent home_page_parent = FXMLLoader.load(getClass().getResource("/SalesAndInventory/InventoryOverView1.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       // app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show(); 
    }
    
    @FXML
    public void handlechits(MouseEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/chitfund/overviewchit.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    private void handleHome(MouseEvent event) throws IOException {
         Parent home_page_parent = FXMLLoader.load(getClass().getResource("/mastersoftware/Home.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       // app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
        
        
    }
    
    @FXML
    public void handleloyalty() throws IOException
    {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/loyalty/loyalty.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) (loyalty).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
    
    @FXML
    private void handleGirviClick(MouseEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/girvi/tempFXML.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) Girvi).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();    
    }

    @FXML
    private void handleLoanClick(MouseEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/girvi/LoanFXML.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) Loans).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
    
    @FXML 
     private void handleOrders() throws SQLException, IOException{
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/orders/overview.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) Orders).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
    
    @FXML
    public void handleemployee() throws IOException
    {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/employee/FXMLDocument.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) (employee).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
    

    /**
     * Initializes the controller class.
     */@FXML
     private void handleOverview() throws SQLException, IOException{
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("overview.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) Overview).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
        
        
    }
     @FXML 
     private void handleHome() throws SQLException, IOException{
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("home.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) Home).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
        
    }
      @FXML
     private void handleKarigar() throws SQLException, IOException{
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("karigar.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) Karigar).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
        
    }
     @FXML
     private void handleStatus() throws SQLException, IOException{
        if(Status.getValue() == "Request Sent") {
            Table2.setVisible(false);
            Table1.setVisible(true);
            Table3.setVisible(false);
        } 
        else if(Status.getValue()=="Dispatched Orders"){
            Table1.setVisible(false);
            Table2.setVisible(true);
            Table3.setVisible(false);
        }
        else{
            Table1.setVisible(false);
            Table2.setVisible(false);
            Table3.setVisible(true);
        }
        
    }
     
      @FXML
     private void handleSearch() throws SQLException, IOException{
        String search = Search.getText();
        if(Status.getValue() == "Request Sent" ){
        Table1.setEditable(true);
        Table1.getColumns().clear();
        SqlLogin.executeQuery("select * from orderlist where Customer_name like '" + search + "%'", Table1);
        Table1.setItems(SqlLogin.data);
        }
         if(Status.getValue() == "Dispatched Orders" ){
        Table2.setEditable(true);
        Table2.getColumns().clear();
        SqlLogin.executeQuery("select * from dispatchlist where Karigar_name like '" + search + "%'", Table2);
        Table2.setItems(SqlLogin.data);
        }
          if(Status.getValue() == "Out for Delivery" ){
        Table3.setEditable(true);
        Table3.getColumns().clear();
        SqlLogin.executeQuery("select * from deliverylist where Customer_name like '" + search + "%'", Table3);
        Table3.setItems(SqlLogin.data);
        }
     
     
     
     
     }
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Underline1.setVisible(false);
        Underline3.setVisible(false);
        Table1.setVisible(true);
        Table2.setVisible(false);
        Table3.setVisible(false);
        Status.setValue("Request Sent");
      
     Table1.setEditable(true);
      
      if(!Table1.getColumns().isEmpty())
        Table1.getColumns().clear();
        try {      
            SqlLogin.executeQuery("select * from orderlist",Table1);
        } catch (SQLException ex) {
            Logger.getLogger(CurrentController.class.getName()).log(Level.SEVERE, null, ex);
        }
          
      Table1.setItems(SqlLogin.data);
      
       Table2.setEditable(true);
      
      if(!Table2.getColumns().isEmpty())
        Table2.getColumns().clear();
        try {      
            SqlLogin.executeQuery("select * from dispatchlist",Table2);
        } catch (SQLException ex) {
            Logger.getLogger(CurrentController.class.getName()).log(Level.SEVERE, null, ex);
        }
          
      Table2.setItems(SqlLogin.data);
      
      Table3.setEditable(true);
      
      if(!Table3.getColumns().isEmpty())
        Table3.getColumns().clear();
        try {      
            SqlLogin.executeQuery("select * from deliverylist",Table3);
        } catch (SQLException ex) {
            Logger.getLogger(CurrentController.class.getName()).log(Level.SEVERE, null, ex);
        }
          
      Table3.setItems(SqlLogin.data);
      
      Search.setEditable(true);
          
        Status.getItems().addAll(
                "Request Sent",
                "Dispatched Orders",
                "Out for Delivery"
        ); 
    } 
    
    
   
}
