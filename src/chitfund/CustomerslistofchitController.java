/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chitfund;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
/**
 * FXML Controller class
 *
 * @author akshay
 */
public class CustomerslistofchitController implements Initializable {

    /**
     * Initializes the controller class.
     */
    public Button chit;
    public TextField chitid;  
      public TableView table;
    public void handlecustomerslist(ActionEvent event) throws SQLException{
      int id = Integer.parseInt(chitid.getText());
       
       table.setEditable(true);
      
      if(!table.getColumns().isEmpty())
        table.getColumns().clear();
      SqlLoginchit.executeQuery("select * from chitfundcustomerdetails WHERE chitfundid='"+id+"'",table);      
          
      table.setItems(SqlLoginchit.data);
    }
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
