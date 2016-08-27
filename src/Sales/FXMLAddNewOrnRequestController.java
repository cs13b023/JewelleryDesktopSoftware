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
public class FXMLAddNewOrnRequestController implements Initializable {

    @FXML
    private TextField Barcode;
    @FXML
    private TextField Type;
    @FXML
    private TextField DesignNo;
    @FXML
    private TextField Purity;
    @FXML
    private TextField NetWeight;
    @FXML
    private TextField GrossWeight;
    @FXML
    private TextField Price;
    @FXML
    private TextField CusID;
    @FXML
    private TextField AdvPaid;
    
    @FXML
    private DatePicker Date;
    @FXML
    private Button AddOrnament;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleAddOrnament(ActionEvent event) {
        String barcode=Barcode.getText();
        String type=Type.getText();
    LocalDate date=Date.getValue();
    float netweight = Float.parseFloat(NetWeight.getText());
   float grossweight = Float.parseFloat(GrossWeight.getText());
    float purity = Float.parseFloat(Purity.getText());
    float price = Float.parseFloat(Price.getText());
    float advancepaid = Float.parseFloat(AdvPaid.getText());
    float dueamount = price-advancepaid;
    int cusid = Integer.parseInt(CusID.getText());
     int designno = Integer.parseInt(DesignNo.getText());
      
     SqlLogin.executeUpdate(" Insert into ORNAMENT_REQ_DETAILS " + "Values( NULL, '"+barcode+"', '"+type+"', '"+designno+"','"+cusid+"','"+date+"','NRT456R54','"+purity+"','"+netweight+"','"+grossweight+"','"+price+"','"+advancepaid+"','"+dueamount+"')" );
        
        Barcode.clear();
        Type.clear();
        DesignNo.clear();
        CusID.clear();
        Purity.clear();
        NetWeight.clear();
        GrossWeight.clear();
        Price.clear();
        AdvPaid.clear();
        
        
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
    
}
