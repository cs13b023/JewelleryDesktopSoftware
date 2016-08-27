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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author vinay
 */
public class InventoryEditWholeSalerController implements Initializable {

    @FXML
    private Button InvSaveDeatils;
    @FXML
    private TextField Name;
    @FXML
    private TextField Address;
    @FXML
    private TextField MobileNo;
    @FXML
    private TextField Email;
    int id;
    @FXML
    private Button DelWS;
    /**
     * Initializes the controller class.
     */
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
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         int c=Integer.valueOf(parameters.getvalue());
        try {
            
            SqlLogin.executeNewContent("select * from WHOLESALER WHERE ID='"+c+"' ");
            
            // TODO
        } catch (SQLException ex) {
            Logger.getLogger(InventoryEditWholeSalerController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       // c=c-1;
        id=Integer.valueOf((String) SqlLogin.data.get(0).get(0));
         String wsname=(String) SqlLogin.data.get(0).get(1);
    String wsaddress=(String) SqlLogin.data.get(0).get(2);
    String wsphoneno=(String) SqlLogin.data.get(0).get(3);
    String wsemailid=(String) SqlLogin.data.get(0).get(4);
    
    Name.setText(wsname);
    Address.setText(wsaddress);
    MobileNo.setText(wsphoneno);
    Email.setText(wsemailid);
    DelWS.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent e) {
                   Stage stage = new Stage();
                Object root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("InvDelItemPopup.fxml"));
                } catch (IOException ex) {
                    Logger.getLogger(InventoryEditWholeSalerController.class.getName()).log(Level.SEVERE, null, ex);
                }
                stage.setScene(new Scene((Parent) root));
                stage.setTitle("My modal window");
                stage.initModality(Modality.APPLICATION_MODAL);
               stage.initOwner(DelWS.getScene().getWindow());
                stage.showAndWait();
                
                if(InventoryPopupDelete.getvalue()=="delete")
                 {
                     int v=index.get();
                      int checkid=Integer.valueOf((String) SqlLogin.data.get(v).get(0));
                    SqlLogin.data.remove(v);
                    //InvTable.getSelectionModel().clearSelection();
                    SqlLogin.executeUpdate("DELETE from WHOLESALER where ID='"+checkid+"'"); 
                 }
                if(InventoryPopupDelete.getvalue()=="cancel")
                 {
                    // InvTable.getSelectionModel().clearSelection();
                 }
                
    
    }    
    });
            }
   

    @FXML
    private void handleInvSaveDetails(ActionEvent event) {
         String wname=Name.getText();
         String waddress=Address.getText();
         String wphoneno=MobileNo.getText();
         String wemail=Email.getText();
       SqlLogin.executeUpdate(" UPDATE WHOLESALER SET NAME='"+wname+"',ADDRESS='"+waddress+"',PHONE_NO='"+wphoneno+"',EMAIL='"+wemail+"' WHERE ID='"+id+"'" );
     //   Name.clear();
       // MobileNo.clear();
        //Address.clear();
         
         
    }

    @FXML
    private void handleDelWS(ActionEvent event) {
        
    }
    
}
