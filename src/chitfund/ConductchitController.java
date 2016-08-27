/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chitfund;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author akshay
 */
public class ConductchitController implements Initializable {

    @FXML
    public TextField amountgiven;
    @FXML
    public TextField nameconductchit;
    @FXML
    public DatePicker datetaken;
    public ComboBox type;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String> options = 
    FXCollections.observableArrayList(
               "normal",
                 "pooledamount"       
    );
     type.getItems().addAll(options);
    }    

    @FXML
    public void Addconductchit(ActionEvent event) {
        int id=1;
         System.out.println("akshay");
        ObservableList<String>  data3=FXCollections.observableArrayList();
         //SqlLogin.executeQuery2("select * from chitfundmembers where name='"+nameconductchit.getText()+"'",data3);  
         SqlLoginchit.executeQuery2("select * from chitfundmembers where name='"+nameconductchit.getText()+"'",data3);  
         
         SqlLoginchit.executeUpdate("insert into `chitfundcustomerdetails` values(null,'"+data3.get(0)+"','"+connection.getId()+"',0,'"+amountgiven.getText()+"','"+datetaken.getValue()+"')");
          ObservableList<String>  data2=FXCollections.observableArrayList();
          SqlLoginchit.executeQuery2("select * from chitslist where id='"+connection.getId()+"'",data2);  
         int pooledamount,installments; 
         pooledamount = Integer.parseInt(data2.get(6));
         installments = Integer.parseInt(data2.get(5));
         installments=installments+1;
         if(type.getValue()=="normal"){
         pooledamount=pooledamount+Integer.parseInt(data2.get(4))-Integer.parseInt(data2.get(8))*(Integer.parseInt(data2.get(4))/100)-Integer.parseInt(amountgiven.getText());
         SqlLoginchit.executeUpdate("update chitslist set pooledmoney='"+pooledamount+"', installmentscompleted='"+installments+"' where id='"+connection.getId()+"'");
        }
         if(type.getValue()=="pooledamount"){
          pooledamount=pooledamount-Integer.parseInt(data3.get(8))*(Integer.parseInt(data3.get(4))/100)-Integer.parseInt(amountgiven.getText());
          if(pooledamount>0){
          SqlLoginchit.executeUpdate("update chitslist set pooledmoney='"+pooledamount+"', installmentscompleted='"+installments+"' where id='"+connection.getId()+"'");   
         }
       }
    }
}
