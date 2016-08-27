/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chitfund;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author akshay
 */
public class NewmemberController implements Initializable {

    public TextField setname;
    public TextField setphonenumber;
    public TextField setaddress;
            
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void addmember(ActionEvent event){
        SqlLoginchit.executeUpdate("insert into `chitfundmembers` values(null,'"+setname.getText()+"','"+setphonenumber.getText()+"','"+setaddress.getText()+"')");
        setname.setText(null);
        setphonenumber.setText(null);
        setaddress.setText(null);
    }
}
