/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author vinay
 */
public class InventoryTypePopupController implements Initializable {

   
    @FXML
    private Button PopupAddType;
    @FXML
    private TextField PopupNewType;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // PopupMaterial.getItems().clear();
        //PopupMaterial.getItems().addAll("Gold","Silver","Diamond","Bronze","Platinum","Mixed","Other");
        
        
        // TODO
    }    

   
    @FXML
    private void handlePopupAddType(ActionEvent event) {
        String a=PopupNewType.getText();
         
      SqlLogin.executeUpdate("INSERT INTO INV_TYPE VALUES(NULL,'"+a+"')");
      tryclass.setvalue(a);
    }
    
}
