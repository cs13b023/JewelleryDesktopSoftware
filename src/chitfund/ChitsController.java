/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chitfund;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
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
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author akshay
 */
public class ChitsController implements Initializable {

    /**
     * Initializes the controller class.
     */
    public Button takedetails;
    public Button takepayment;
    public Button payment;
    public Button conductchit;
    public ComboBox comboBox;
    public TableView table;
    public TableView table2;
    public TextField chitname;
    public TextField totalmembers;
    public TextField totalmonths;
    public TextField totalamount;
    public TextField installments;
    public TextField pooledamount;
    public TextField chitname1;
    public TextField totalmembers1;
    public TextField totalmonths1;
    public TextField totalamount1;
    public TextField installments1;
    public TextField pooledamount1;
    public LineChart lineChart;
    public TextField startdate;
    public TextField nameconductchit;
    public TextField amounttaken;
    public DatePicker datetaken;
    public TextField searchdetails;
    public TextField manager;
    public TextField commision;
    public TextField startdate1;
    public Pane pane1;
    public Pane pane11;
    public int id;
    
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
    
    
    public void details(ActionEvent event) throws SQLException{
       String name= (String) comboBox.getValue();
       ObservableList<String>  data=FXCollections.observableArrayList();
       Boolean i=SqlLoginchit.executeQuery("select * from chitslist where chitname='"+name+"'");
        Boolean j=SqlLoginchit.executeQuery("select * from chitspartof where name='"+name+"'");
       if(i==true){
        pane11.setVisible(false);
        pane1.setVisible(true);
     
       SqlLoginchit.executeQuery2("select * from chitslist where chitname='"+name+"'",data); 
       //SqlLogin.executeQuery("select * from chitslist where name='"+name+"'");
       System.out.println(data);
       //LocalDate date= LocalDate("2016-12-04");
       id = Integer.parseInt(data.get(0));
       chitname.setText(data.get(1));
       totalmembers.setText(data.get(2));
       totalmonths.setText(data.get(3));
       totalamount.setText(data.get(4));
       installments.setText(data.get(5));
       pooledamount.setText(data.get(6));
       startdate.setText(data.get(6));
      commision.setText(data.get(8));
      startdate1.setText(data.get(7));
      table.setEditable(true);
      connection.setId(id);
      
      if(!table.getColumns().isEmpty())
        table.getColumns().clear();
      SqlLoginchit.executeQuery("SELECT chitfundmembers.name, chitfundcustomerdetails.amonttaken,chitfundcustomerdetails.Dueamount,chitfundcustomerdetails.datetaken FROM chitfundcustomerdetails INNER JOIN chitslist ON chitslist.id = chitfundcustomerdetails.chitfundid INNER JOIN chitfundmembers on chitfundmembers.id=chitfundcustomerdetails.customerid where chitslist.id='"+id+"'",table);          
      table.setItems(SqlLoginchit.data);
       table2.setEditable(true);
     if(!table2.getColumns().isEmpty())
        table2.getColumns().clear();
          SqlLoginchit.executeQuery("SELECT chitfundmembers.name, payments.amountpaid,payments.givendate FROM payments INNER JOIN chitslist ON chitslist.id =payments.chitfundid INNER JOIN chitfundmembers on chitfundmembers.id=payments.customerid where chitslist.id='"+id+"'",table2);
       //   SqlLogin.executeQuery("SELECT chitfundmembers.name,payments.amountpaid,paymentspartof.givendate FROM paymentspartof INNER JOIN chitspartof ON chitspartof.id = paymentspartof.chitfundid where chitspartof.id='"+id+"'",table2);          
         table2.setItems(SqlLoginchit.data);
      try {
              lineChart.getData().clear();
            // TODO Auto-generated method stu
            lineChart.getXAxis().setAutoRanging(true);
            lineChart.getYAxis().setAutoRanging(true);
            
            XYChart.Series series = new XYChart.Series<>();
           SqlLoginchit.executeQuery("select datetaken,amonttaken from chitfundcustomerdetails where chitfundid='"+id+"' and datetaken!='"+null+"'",series);
             
            lineChart.getData().add(series);
          
        } catch (SQLException ex) {
            Logger.getLogger(ChitsController.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
       
        else if(j==true){
        pane1.setVisible(true);
        pane11.setVisible(true);
       SqlLoginchit.executeQuery2("select * from chitspartof where name='"+name+"'",data); 
       //SqlLogin.executeQuery("select * from chitslist where name='"+name+"'");
       System.out.println(data);
       id = Integer.parseInt(data.get(0));
       chitname1.setText(data.get(1));
       totalmembers1.setText(data.get(2));
       totalmonths1.setText(data.get(3));
       totalamount1.setText(data.get(4));
       installments1.setText(data.get(5));
       pooledamount1.setText(data.get(6));
       
       manager.setText(data.get(8));
      startdate.setText((data.get(7)));  
      table.setEditable(true);
      connection.setId(id);
      if(!table.getColumns().isEmpty())
        table.getColumns().clear();
      SqlLoginchit.executeQuery("SELECT  detailspartof.amonttaken,detailspartof.datetaken FROM detailspartof INNER JOIN chitspartof ON chitspartof.id = detailspartof.chitfundid  where chitspartof.id='"+id+"'",table);          
      table.setItems(SqlLoginchit.data);
       table2.setEditable(true);
     if(!table2.getColumns().isEmpty())
        table2.getColumns().clear();
     // SqlLogin.executeQuery("SELECT  chitspartof.name,paymentspartof.amountpaid,paymentspartof.givendate FROM payments INNER JOIN chitspartof ON chitspartof.id = paymentspartof.chitfundid where chitspartof.id='"+id+"'",table2);          
     SqlLoginchit.executeQuery("SELECT paymentspartof.amountpaid,paymentspartof.givendate FROM paymentspartof INNER JOIN chitspartof ON chitspartof.id = paymentspartof.chitfundid where chitspartof.id='"+id+"'",table2);          
     table2.setItems(SqlLoginchit.data);
      try {
              lineChart.getData().clear();
            // TODO Auto-generated method stu
            lineChart.getXAxis().setAutoRanging(true);
            lineChart.getYAxis().setAutoRanging(true);
            
            XYChart.Series series = new XYChart.Series<>();
           SqlLoginchit.executeQuery("select datetaken,amonttaken from detailspartof where chitfundid='"+id+"'",series);
             
            lineChart.getData().add(series);
          
        } catch (SQLException ex) {
            Logger.getLogger(ChitsController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    }
    
       public void addmembertochit(ActionEvent event) throws SQLException{
          
           ObservableList<String>  data=FXCollections.observableArrayList();
           SqlLoginchit.executeQuery2("select * from chitslist where chitname='"+comboBox.getValue()+"'",data);
           ObservableList<String>  data3=FXCollections.observableArrayList();
           //SqlLogin.executeQuery2("select * from chitfundmembers where phonenumber='"+chitphone.getText()+"'",data3);
           System.out.println(data3.get(0));
           SqlLoginchit.executeUpdate("insert into `chitfundcustomerdetails` values(null,'"+data3.get(0)+"','"+data.get(0)+"',0,0,null)");
           if(!table2.getColumns().isEmpty())
                table2.getColumns().clear();
           SqlLoginchit.executeQuery("select customerid,chitfundid from chitfundcustomerdetails WHERE chitfundid='"+data.get(0)+"'",table2);      
          
           table2.setItems(SqlLoginchit.data); 
       }
       public void update(ActionEvent event){
           String Name,Totalmembers,Totalmonths;
           Name=chitname.getText();
           Totalmembers=totalmembers.getText();
           Totalmonths=totalmonths.getText();

            SqlLoginchit.executeUpdate("UPDATE chitslist SET chitname='"+Name+"',totalmembers='"+Totalmembers+"',totalmonths='"+Totalmonths+"',totalamount='"+totalamount.getText()+"',installmentscompleted='"+installments.getText()+"',pooledmoney='"+pooledamount.getText()+"' WHERE id ='"+id+"';");
            comboBox.getItems().clear(); 
            ObservableList<String>  data=FXCollections.observableArrayList();
           SqlLoginchit.executeQuery("select chitname from chitslist",data);  
           comboBox.getItems().addAll(data);
       }
       
       public void makepayment(ActionEvent event) throws IOException{
           // private void handleaddCustomerData() throws SQLException, IOException{
      Stage stage = new Stage();
                Object root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("payments.fxml"));
                } catch (IOException ex) {
                    Logger.getLogger(ChitsController.class.getName()).log(Level.SEVERE, null, ex);
                }
                stage.setScene(new Scene((Parent) root));
                stage.setTitle("My modal window");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.initOwner(payment.getScene().getWindow());
                stage.showAndWait();
       }
       public void conductchit(ActionEvent event) throws IOException{
               Stage stage = new Stage();
                Object root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("conductchit.fxml"));
                } catch (IOException ex) {
                    Logger.getLogger(ChitsController.class.getName()).log(Level.SEVERE, null, ex);
                }
                stage.setScene(new Scene((Parent) root));
                stage.setTitle("My modal window");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.initOwner(conductchit.getScene().getWindow());
                stage.showAndWait();
       }
        public void takedetails(ActionEvent event) throws IOException{
               Stage stage = new Stage();
                Object root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("takedetails.fxml"));
                } catch (IOException ex) {
                    Logger.getLogger(ChitsController.class.getName()).log(Level.SEVERE, null, ex);
                }
                stage.setScene(new Scene((Parent) root));
                stage.setTitle("My modal window");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.initOwner(takedetails.getScene().getWindow());
                stage.showAndWait();
       }
        public void takepayment(ActionEvent event) throws IOException{
               Stage stage = new Stage();
                Object root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("takepayment.fxml"));
                } catch (IOException ex) {
                    Logger.getLogger(ChitsController.class.getName()).log(Level.SEVERE, null, ex);
                }
                stage.setScene(new Scene((Parent) root));
                stage.setTitle("My modal window");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.initOwner(takepayment.getScene().getWindow());
                stage.showAndWait();
       }
    public void searchdues() throws SQLException{
     
      String name=searchdetails.getText();
      table.setEditable(true);
      if(!table.getColumns().isEmpty())
        table.getColumns().clear();
          SqlLoginchit.executeQuery("SELECT chitfundmembers.name, chitfundcustomerdetails.amonttaken,chitfundcustomerdetails.Dueamount,chitfundcustomerdetails.datetaken FROM chitfundcustomerdetails INNER JOIN chitslist ON chitslist.id = chitfundcustomerdetails.chitfundid INNER JOIN chitfundmembers on chitfundmembers.id=chitfundcustomerdetails.customerid where chitslist.id='"+id+"'and chitfundmembers.name like '%"+name+"%'",table);           
            table.setItems(SqlLoginchit.data);
      } 
       
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
        ObservableList<String>  data=FXCollections.observableArrayList();
         combobox.chitscombobox(comboBox,data);
         comboBox.getItems().addAll(data); 
          ObservableList<String>  data2=FXCollections.observableArrayList();
          comboBox.getItems().clear();
         comboBox.setEditable(true);
         SqlLoginchit.executeQuery("select name from chitspartof ",data);
       // String[] both = (String[])ArrayUtils.addAll(data,data2);
         comboBox.getItems().addAll(data); 
    }  
     public void handleoverview(MouseEvent event) throws IOException {
         Parent home_page_parent = FXMLLoader.load(getClass().getResource("overviewchit.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    public void handleNewChit(MouseEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("newchit.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    public void handleMember(MouseEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("members.fxml"));
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

    
}
