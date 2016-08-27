/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chitfund;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author akshay
 */
public class OverviewchitController implements Initializable {

    @FXML
    private ComboBox combobox3;
    public DatePicker datefrom;
    public DatePicker dateto;
    public TextField customername;
   // public ScrollPane scrollpane;
    //public ScrollPane scrollpane2;
    public TableView table1;
    public TableView table2;
    public TextField customernamedue;
    public ComboBox chitnamedue;
    
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
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String>  data=FXCollections.observableArrayList();
         combobox.chitscombobox(combobox3,data);
         combobox3.getItems().addAll(data);
         ObservableList<String>  data2=FXCollections.observableArrayList();
         combobox.chitscombobox(chitnamedue,data2);
         chitnamedue.getItems().addAll(data);
          table2.setEditable(true);
     if(!table2.getColumns().isEmpty())
        table2.getColumns().clear();
        try {
            SqlLoginchit.executeQuery("select payments.id,chitfundmembers.name,chitslist.chitname,payments.amountpaid,payments.givendate from payments inner join chitfundmembers on chitfundmembers.id=payments.customerid inner join chitslist on chitslist.id=payments.chitfundid",table2);
        } catch (SQLException ex) {
            Logger.getLogger(OverviewchitController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //tileDisplay(SqlLogin.data);
        table2.setItems(SqlLoginchit.data); 
         table1.setEditable(true);
     if(!table1.getColumns().isEmpty())
        table1.getColumns().clear();
        try {
         SqlLoginchit.executeQuery("select chitfundmembers.name,chitslist.chitname,chitfundcustomerdetails.Dueamount from chitfundcustomerdetails inner join chitfundmembers on chitfundmembers.id=chitfundcustomerdetails.customerid inner join chitslist on chitslist.id=chitfundcustomerdetails.chitfundid",table1);
        } catch (SQLException ex) {
            Logger.getLogger(OverviewchitController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //tileDisplay2(SqlLogin.data);
        table1.setItems(SqlLoginchit.data); 
    } 
    public void searchchitdue(ActionEvent event) throws SQLException{
         table1.setEditable(true);
     if(!table1.getColumns().isEmpty())
        table1.getColumns().clear();
      SqlLoginchit.executeQuery("select chitfundmembers.name,chitslist.chitname,chitfundcustomerdetails.Dueamount from chitfundcustomerdetails inner join chitfundmembers on chitfundmembers.id=chitfundcustomerdetails.customerid inner join chitslist on chitslist.id=chitfundcustomerdetails.chitfundid  where chitslist.chitname='"+chitnamedue.getValue()+"'",table1);
        
       // tileDisplay2(SqlLogin.data);
       table1.setItems(SqlLoginchit.data); 
    }
    public void searchcustomerdue() throws SQLException{
         table1.setEditable(true);
     if(!table1.getColumns().isEmpty())
        table1.getColumns().clear();
       SqlLoginchit.executeQuery("select chitfundmembers.name,chitslist.chitname,chitfundcustomerdetails.Dueamount from chitfundcustomerdetails inner join chitfundmembers on chitfundmembers.id=chitfundcustomerdetails.customerid inner join chitslist on chitslist.id=chitfundcustomerdetails.chitfundid where chitfundmembers.name like '%"+customernamedue.getText()+"%'",table1);
    
        //tileDisplay2(SqlLogin.data);
        table1.setItems(SqlLoginchit.data); 
    }
    
    public void searchdate(ActionEvent event) throws SQLException{
         table2.setEditable(true);
     if(!table2.getColumns().isEmpty())
        table2.getColumns().clear();
       SqlLoginchit.executeQuery("select payments.id,chitfundmembers.name,chitslist.chitname,payments.amountpaid,payments.givendate from payments inner join chitfundmembers on chitfundmembers.id=payments.customerid inner join chitslist on chitslist.id=payments.chitfundid where givendate between '"+datefrom.getValue()+"' and '"+dateto.getValue()+"'",table2);
        
         table2.setItems(SqlLoginchit.data); 
         //tileDisplay(SqlLogin.data);
    }
    public void searchchit(ActionEvent event) throws SQLException{
         table2.setEditable(true);
     if(!table2.getColumns().isEmpty())
        table2.getColumns().clear();
        SqlLoginchit.executeQuery("select payments.id,chitfundmembers.name,chitslist.chitname,payments.amountpaid,payments.givendate from payments inner join chitfundmembers on chitfundmembers.id=payments.customerid inner join chitslist on chitslist.id=payments.chitfundid  where chitslist.chitname='"+combobox3.getValue()+"'",table2);
     
        table2.setItems(SqlLoginchit.data); 
        //tileDisplay(SqlLogin.data);
    }
    public void searchcustomer() throws SQLException{
         table2.setEditable(true);
     if(!table2.getColumns().isEmpty())
        table2.getColumns().clear();
       SqlLoginchit.executeQuery("select payments.id,chitfundmembers.name,chitslist.chitname,payments.amountpaid,payments.givendate from payments inner join chitfundmembers on chitfundmembers.id=payments.customerid inner join chitslist on chitslist.id=payments.chitfundid  where chitfundmembers.name like '%"+customername.getText()+"%'",table2);
       
        table2.setItems(SqlLoginchit.data); 
        //tileDisplay(SqlLogin.data);
    }

    @FXML
    private void handleActiveChit(MouseEvent event) throws IOException {
         Parent home_page_parent = FXMLLoader.load(getClass().getResource("Activechit.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
    
    @FXML
    private void handleNewChit(MouseEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("newchit.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    private void handleMember(MouseEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("members.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
      
    public void tileDisplay(ObservableList<ObservableList> data){
            //scrollpane.setContent(null);
            String name;
            System.out.println(data);
            VBox pledgings = new VBox();
            for(int i=0;i<data.size();++i){
                HBox pledgingTile=new HBox();
                pledgingTile.setSpacing(50);
                pledgingTile.setStyle("-fx-border-color:black;");
                pledgingTile.setId((String)data.get(i).get(0));
                Label id = new Label();
                id.setStyle("-fx-text-fill:black; -fx-font-size: 20px;");
                Label customer = new Label();
                customer.setStyle("-fx-text-fill:black; -fx-font-size: 20px;");
                Label chit = new Label();
                chit.setStyle("-fx-text-fill:black; -fx-font-size: 20px;");
                Label Amountpaid =new Label();
                Amountpaid.setStyle("-fx-text-fill:black; -fx-font-size: 20px;");
                Label  Date=new Label();
                Date.setStyle("-fx-text-fill:black; -fx-font-size: 20px;");
                               
                name=(String)data.get(i).get(0);
                id.setText(name);
                name=(String)data.get(i).get(1);
                customer.setText(name);
                name=(String)data.get(i).get(2);
                chit.setText(name);
                name=(String) data.get(i).get(3);
                Amountpaid.setText(name);
                name=(String) data.get(i).get(4);
                Date.setText(name);
                
                pledgingTile.getChildren().add(id);
                pledgingTile.getChildren().add(customer);
                pledgingTile.getChildren().add(chit);
                pledgingTile.getChildren().add(Amountpaid);
                pledgingTile.getChildren().add(Date);
                pledgings.getChildren().add(pledgingTile);
            }
               // scrollpane.setContent(pledgings);
    }
   public void tileDisplay2(ObservableList<ObservableList> data){
            //scrollpane.setContent(null);
            String name;
            System.out.println(data);
            VBox pledgings = new VBox();
           // VBox.setGap(50);
            for(int i=0;i<data.size();++i){
                HBox pledgingTile=new HBox();
                pledgingTile.setStyle("-fx-border-color:black;");
                pledgingTile.setId((String)data.get(i).get(0));
                int len;
                len = 50-data.get(i).get(0).toString().length();
                System.out.println(len);
                pledgingTile.setSpacing(50);
               // Label id = new Label();
                //id.setStyle("-fx-text-fill:black; -fx-font-size: 20px;");
                Label customer = new Label();
                customer.setStyle("-fx-text-fill:black; -fx-font-size: 20px;");
                Label chit = new Label();
                chit.setStyle("-fx-text-fill:black; -fx-font-size: 20px;");
                Label  Due=new Label();
                Due.setStyle("-fx-text-fill:black; -fx-font-size: 20px;");
                               
                name=(String)data.get(i).get(0);
                //name.setlength(15);
                customer.setText(name);
                name=(String)data.get(i).get(1);
                chit.setText(name);
                name=(String) data.get(i).get(2);
                Due.setText(name);
               
                pledgingTile.getChildren().add(customer);
                pledgingTile.getChildren().add(chit);
                pledgingTile.getChildren().add(Due);
                pledgings.getChildren().add(pledgingTile);
            }
                //scrollpane2.setContent(pledgings);
   } 
    
}
