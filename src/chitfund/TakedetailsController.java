/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chitfund;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author akshay
 */
public class TakedetailsController implements Initializable {

    @FXML
    private TextField amounttaken;
    @FXML
    private DatePicker datetaken;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void adddetails(ActionEvent event) {
        SqlLoginchit.executeUpdate("insert into `detailspartof` values(null,'"+connection.getId()+"','"+amounttaken.getText()+"','"+datetaken.getValue()+"')");
    amounttaken.setText(null);
    datetaken.setValue(null);      
    
    }
    
}
