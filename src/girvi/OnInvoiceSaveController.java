/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package girvi;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Vinod
 */
public class OnInvoiceSaveController implements Initializable {

    @FXML
    private TextField gumastha;
    @FXML
    private ComboBox ratingcombobox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ratingcombobox.getItems().addAll("1","2","3","4","5");
    }    

    @FXML
    private void SaveDetails(ActionEvent event) {
    }
    
}
