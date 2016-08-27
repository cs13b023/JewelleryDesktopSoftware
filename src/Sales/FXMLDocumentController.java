/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sales;

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
import javafx.scene.control.TableView;
import javafx.stage.Stage;




/**
 *
 * @author sandukuttan
 */


public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button getKarigar;
    
    @FXML
    private Button getCustomer;
    
    @FXML
    private Button getWholeSaler;
     @FXML
    private Button getInventory;
    
  
    @FXML
    private TableView table;
    

    
    @FXML
    private void handleKarigar(ActionEvent event) throws SQLException{
       
      table.setEditable(true);
      
      if(!table.getColumns().isEmpty())
        table.getColumns().clear();
      SqlLogin.executeQuery("select * from KARIGAR",table);      
          
      table.setItems(SqlLogin.data);
               
   }
    @FXML
    private void handleCustomer(ActionEvent event) throws SQLException{
       
      table.setEditable(true);
      
      if(!table.getColumns().isEmpty())
        table.getColumns().clear();
      SqlLogin.executeQuery("select * from CUSTOMER",table);      
          
      table.setItems(SqlLogin.data);
               
   }
    @FXML
    private void handleWholeSaler(ActionEvent event) throws SQLException{
       
      table.setEditable(true);
      
      if(!table.getColumns().isEmpty())
        table.getColumns().clear();
      SqlLogin.executeQuery("select * from WHOLESALER",table);      
          
      table.setItems(SqlLogin.data);
               
   }
    
      @FXML
    private void handleInventory(ActionEvent event) throws SQLException{
       
      table.setEditable(true);
      
      if(!table.getColumns().isEmpty())
        table.getColumns().clear();
      SqlLogin.executeQuery("select * from INVENTORY",table);      
          
      table.setItems(SqlLogin.data);
               
   }
    @FXML
    private void handleaddCustomer(ActionEvent event) throws SQLException, IOException{
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLCustomer.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
    
    
    
    
      
    
    
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
