/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chitfund;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author akshay
 */
public class PaymentsController implements Initializable {

    @FXML
    private TextField namepayment;
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
         namepayment.setText(null);
         amountpaid.setText(null);
         datepaid.setValue(null);
    }    

    @FXML
    private void addpayment(ActionEvent event) {
        if(namepayment.getText()!=null && amountpaid.getText()!=null && datepaid.getValue()!=null){
        ObservableList<String>  data3=FXCollections.observableArrayList();
         SqlLoginchit.executeQuery2("select * from chitfundmembers where name='"+namepayment.getText()+"'",data3);  
         SqlLoginchit.executeUpdate("insert into `payments` values(null,'"+data3.get(0)+"','"+connection.getId()+"','"+amountpaid.getText()+"','"+datepaid.getValue()+"')");
         namepayment.setText(null);
         amountpaid.setText(null);
         datepaid.setValue(null);
    }
        else{
            
        }
    }
    }
    
