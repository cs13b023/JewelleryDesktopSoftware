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
public class InterestCalculatorFXMLController implements Initializable {

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
    private ComboBox Type = new ComboBox();
    
    @FXML
    private Button Calculate_interest;
    
    @FXML
    private Label Interest;
    
    @FXML
    private Label Final_amount;
    
    @FXML
    private void handleCalculateInterest() throws SQLException, IOException{
        int amount = Integer.parseInt(Amount.getText());
        float number_of_months = Float.parseFloat(Number_of_months.getText());
        float interest_rate = Float.parseFloat(Interest_rate.getText());
        String type = (String) Type.getValue();
        int interest;
        if(Objects.equals("Simple",type)){
            interest = (int) Operations.calculateSimpleInterest(amount, number_of_months, interest_rate);
        }
        else{
            interest = (int) Operations.calculateCompundInterest(amount, number_of_months, interest_rate);
        }
        Interest.setText(String.valueOf(interest));
        Interest.setVisible(true);
        amount = amount + interest;
        Final_amount.setText(String.valueOf(amount));
        Final_amount.setVisible(true);
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Type.getItems().addAll(
            "Simple",
            "Compound"
        );
      Interest.setVisible(false);
      Final_amount.setVisible(false);
        
    }    
    
}
