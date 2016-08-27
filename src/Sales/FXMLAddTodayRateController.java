/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sales;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author vinay
 */
public class FXMLAddTodayRateController implements Initializable {

    @FXML
    private Button AddRates;
    @FXML
    private TextField GoldRate;
    @FXML
    private TextField SilverRate;
    @FXML
    private Button Home;
    @FXML
    private DatePicker Date;

    /**
     * Initializes the controller class.
     */
    @FXML
    private void handleAddRates(ActionEvent event) throws SQLException{
       
        LocalDate date=Date.getValue();
    float silverrate = Float.parseFloat(SilverRate.getText());
   float goldrate = Float.parseFloat(GoldRate.getText());
       //SqlLogin.executeUpdate(" Insert into CUSTOMER " + "Values( NULL, 'harshan', '7894561230', 'pune',3,8)" );
    SqlLogin.executeUpdate(" Insert into RATES " + "Values( NULL, '"+date+"',null,'"+goldrate+"', '"+silverrate+"')" );
      //  Name.clear();
        //MobileNo.clear();
        //city.clear();
        
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
    }    

    
    
}
