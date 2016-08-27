/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chitfund;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
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
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
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
public class NewchitController implements Initializable {

    @FXML
    private TextField setchitname;
    @FXML
    private TextField settotalmonths;
    @FXML
    private TextField settotalmembers;
    @FXML
    private TextField settotalamount;
    @FXML
    private TextField setpooledamount;
    @FXML
    private TextField setinstallments;
    @FXML
    private Pane setmanager;
    @FXML
    private TextField setchitname1;
    @FXML
    private TextField settotalmonths1;
    @FXML
    private TextField settotalmembers1;
    @FXML
    private TextField settotalamount1;
    @FXML
    private TextField setpooledamount1;
    @FXML
    private TextField setinstallments1;
    @FXML
    private TextField setmanager1;
    public DatePicker  setstartdate;
    public Button addmembertochit;
    public DatePicker startdate;
    public TextField commision;
    
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
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addnewchit(ActionEvent event) {
         SqlLoginchit.executeUpdate("insert into `chitslist` values(null,'"+setchitname.getText()+"','"+settotalmembers.getText()+"','"+settotalmonths.getText()+"','"+settotalamount.getText()+"','"+setinstallments.getText()+"','"+setpooledamount.getText()+"','"+startdate.getValue()+"','"+commision.getText()+"')");
        setchitname.setText(null);
        settotalmonths.setText(null);
        settotalmembers.setText(null);
        settotalamount.setText(null);
        setinstallments.setText(null);
        setpooledamount.setText(null);
        startdate.setValue(null);
        commision.setText(null);
    }   

    @FXML
    private void addnewchitpartof(ActionEvent event) {
        SqlLoginchit.executeUpdate("insert into `chitspartof` values(null,'"+setchitname1.getText()+"','"+settotalmembers1.getText()+"','"+settotalmonths1.getText()+"','"+settotalamount1.getText()+"','"+setinstallments1.getText()+"','"+setpooledamount1.getText()+"','"+setstartdate.getValue()+"','"+setmanager1.getText()+"')");
        setchitname1.setText(null);
        settotalmonths1.setText(null);
        settotalmembers1.setText(null);
        settotalamount1.setText(null);
        setinstallments1.setText(null);
        setpooledamount1.setText(null);
        setstartdate.setValue(null);
    }
     public void addmembertochit(ActionEvent event) throws IOException{
           // private void handleaddCustomerData() throws SQLException, IOException{
      Stage stage = new Stage();
                Object root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("addmembertochit.fxml"));
                } catch (IOException ex) {
                    Logger.getLogger(MembersController.class.getName()).log(Level.SEVERE, null, ex);
                }
                stage.setScene(new Scene((Parent) root));
                stage.setTitle("My modal window");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.initOwner(addmembertochit.getScene().getWindow());
                stage.showAndWait();
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
    public void handleActiveChit(MouseEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("Activechit.fxml"));
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
