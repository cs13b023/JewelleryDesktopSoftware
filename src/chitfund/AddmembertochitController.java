/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chitfund;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author akshay
 */
public class AddmembertochitController implements Initializable {

    /**
     * Initializes the controller class.
     */
    public ComboBox combobox2;
    public ComboBox customername;
    public Label error;
    public Label success;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         ObservableList<String>  data=FXCollections.observableArrayList();
          combobox2.getItems().clear();
         combobox2.setEditable(true);
         SqlLoginchit.executeQuery("select chitname from chitslist",data);
         combobox2.getItems().addAll(data); 
         combobox2.setValue(null);
         customername.getItems().clear();
        customername.setEditable(true);
         ObservableList<String>  data2=FXCollections.observableArrayList();
         SqlLoginchit.executeQuery("select name from chitfundmembers",data2);
         customername.getItems().addAll(data2); 
         error.setVisible(false);
         success.setVisible(false);
         
    }    
    public void addmembertochit(ActionEvent event) throws SQLException{
        if(combobox2.getValue()!=null&&customername.getValue()!=null){
           ObservableList<String>  data=FXCollections.observableArrayList();
           SqlLoginchit.executeQuery2("select * from chitslist where chitname='"+combobox2.getValue()+"'",data);
           ObservableList<String>  data3=FXCollections.observableArrayList();
           SqlLoginchit.executeQuery2("select * from chitfundmembers where name='"+customername.getValue()+"'",data3);
           System.out.println(data3.get(0));
           SqlLoginchit.executeUpdate("insert into `chitfundcustomerdetails` values(null,'"+data3.get(0)+"','"+data.get(0)+"',0,0,null)");
           combobox2.setValue(null);
           customername.setValue(null);
           error.setVisible(false);
           success.setVisible(true);
           
        }
        else
        {
            error.setVisible(true);
            success.setVisible(false);
        } 
    }
   public void suggestions(){
       customername.getItems().clear();
       ObservableList<String>  data3=FXCollections.observableArrayList();
        customername.setEditable(true);
         SqlLoginchit.executeQuery("select name from chitfundmembers where name like '%"+customername.getEditor().getText()+"%'",data3);
         //System.out.println(customername.getEditor().getText());
         customername.getItems().addAll(data3); 
   }
}
