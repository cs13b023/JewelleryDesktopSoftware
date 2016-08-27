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
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author vinay
 */
public class FXMLAddCustomerController implements Initializable {

    @FXML
    private Button AddCustomer;
    @FXML
    private TextField Name;
    @FXML
    private TextField MobileNo;
    @FXML
    private TextField City;
    @FXML
    private Button Home;
    @FXML
    private ComboBox Behaviour,Capacity;
    @FXML
    private RadioButton rb1,rb2,rb3,rb4,rb5;
    
 

    @FXML
    private void handleAddCustomer(ActionEvent event) throws SQLException{
       String city=City.getText();
        String name=Name.getText();
        //if(rb1.setSelected(true)==true)
            System.out.println("done that");
     String mobileno=MobileNo.getText();
      String a=(String) Behaviour.getValue();
       String capacity=(String) Capacity.getValue();
       String behaviour;
       behaviour=capacity+" , "+a;
    // System.out.println(name+"is good");
       //SqlLogin.executeUpdate(" Insert into CUSTOMER " + "Values( NULL, 'harshan', '7894561230', 'pune',3,8)" );
      SqlLogin.executeUpdate(" Insert into CUSTOMER " + "Values( NULL, '"+name+"', '"+mobileno+"','"+city+"',1,'"+behaviour+"',4)" );
        Name.clear();
        MobileNo.clear();
        City.clear();
        
   }
    
    @FXML
    private void handleHome(ActionEvent event) throws SQLException, IOException{
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLTest.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         Behaviour.getItems().clear();
        Behaviour.getItems().addAll("BargainingButGood","NotBargainingAndGood","BargainingAndRude","NotBargainingButRude");
         Capacity.getItems().clear();
        Capacity.getItems().addAll("AverageCapacity","HighCapacity","LowCapacity");
    
    }    

  
    
}
