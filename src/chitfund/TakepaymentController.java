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
public class TakepaymentController implements Initializable {

    @FXML
    private TextField amountpaid;
    @FXML
    private DatePicker datepaid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

    @FXML
    private void Addpayment(ActionEvent event) {
      SqlLoginchit.executeUpdate("insert into `paymentspartof` values(null,'"+connection.getId()+"','"+amountpaid.getText()+"','"+datepaid.getValue()+"')");
      amountpaid.setText(null);
      datepaid.setValue(null);    

    }
    
}
