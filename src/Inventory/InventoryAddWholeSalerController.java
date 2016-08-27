/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author vinay
 */
public class InventoryAddWholeSalerController implements Initializable {

    @FXML
    private TextField Name;
    @FXML
    private TextField Address;
    @FXML
    private TextField MobileNo;
    @FXML
    private Button AddWholeSaler;
    @FXML
    private TextField Email;

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private void handleAddWholeSaler(ActionEvent event) throws SQLException{
       
        String name=Name.getText();
        String address=Address.getText();
     String mobileno=MobileNo.getText();
     String email=Email.getText();
     if(name==null)
     {
         System.out.println("yes name is null");
     }
       //SqlLogin.executeUpdate(" Insert into CUSTOMER " + "Values( NULL, 'harshan', '7894561230', 'pune',3,8)" );
      SqlLogin.executeUpdate(" Insert into WHOLESALER " + "Values( NULL, '"+name+"', '"+address+"', '"+mobileno+"','"+email+"')" );
        Name.clear();
        MobileNo.clear();
        Address.clear();
       Email.clear();
   }
    
    private void handleHome(ActionEvent event) throws SQLException, IOException{
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("InventoryWholeSaler1.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
   /* @FXML
    private void handleGoBack(ActionEvent event) throws SQLException, IOException{
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLAddInventory.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
    */
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Name.setText(null);
        Address.setText(null);
        MobileNo.setText(null);
        Email.setText(null);
    }    


   
    
}
