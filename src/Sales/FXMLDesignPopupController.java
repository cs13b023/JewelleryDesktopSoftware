/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sales;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author vinay
 */
public class FXMLDesignPopupController implements Initializable {

    @FXML
    private TextField PopupDesignName;
    @FXML
    private Button PopupAddDesign;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handlePopupAddDesign(ActionEvent event) {
        String pdn=PopupDesignName.getText();
        tryclass try1=new tryclass();
       try1.setvalue(pdn);
        
    }
    
}
