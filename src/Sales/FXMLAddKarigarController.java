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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author vinay
 */
public class FXMLAddKarigarController implements Initializable {

    @FXML
    private Button AddKarigar;
    @FXML
    private TextField Name;
    @FXML
    private TextField Address;
    @FXML
    private TextField MobileNo;
    @FXML
    private Button Home;
    @FXML
    private ComboBox Speciality;

    /**
     * Initializes the controller class.
     */
    
     @FXML
    private void handleAddKarigar(ActionEvent event) throws SQLException{
       
        String name=Name.getText();
        String address=Address.getText();
        String mobileno=MobileNo.getText();
       String speciality=(String) Speciality.getValue();
       //SqlLogin.executeUpdate(" Insert into CUSTOMER " + "Values( NULL, 'harshan', '7894561230', 'pune',3,8)" );
      SqlLogin.executeUpdate(" Insert into KARIGAR " + "Values( NULL, '"+name+"', '"+address+"', '"+mobileno+"','"+speciality+"',NULL,NULL,NULL,NULL)" );
        Name.clear();
        Address.clear();
        MobileNo.clear();
        //Speciality.clear();
        
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
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         Speciality.getItems().clear();
        Speciality.getItems().addAll("Necklace","Ring","Bangles");
    }    

   

    
}
