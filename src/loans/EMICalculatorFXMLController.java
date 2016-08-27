/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loans;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Vinod
 */
public class EMICalculatorFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
    @FXML
    private TextField Amount;
    
    @FXML
    private TextField Number_of_months;
    
    @FXML
    private TextField Interest_rate;
    
    @FXML
    private Button Calculate_EMI;
    
    @FXML
    private Label EMI;
    
    @FXML
    private void handleCalculateEMI(ActionEvent event) throws SQLException, IOException{
        int amount = Integer.parseInt(Amount.getText());
        int number_of_months = Integer.parseInt(Number_of_months.getText());
        float interest_rate = Float.parseFloat(Interest_rate.getText());
        int emi;
        emi = (int) Operations.calculateEMI(amount, interest_rate, number_of_months);
        EMI.setText(String.valueOf(emi));
        EMI.setVisible(true);
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        EMI.setVisible(false);
        
    }    
    
}
