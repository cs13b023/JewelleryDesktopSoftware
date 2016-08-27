/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package girvi;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Vinod
 */
public class AddBankController implements Initializable {

    @FXML
    private TextField BankName;
    @FXML
    private TextField Branch;
    @FXML
    private TextField InterestRate;
    @FXML
    private TextField LoanPercent;
    @FXML
    private TextField CompoundAfter;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

    @FXML
    private void handleAddBank(ActionEvent event) {
        String bank = BankName.getText();
        String branch = Branch.getText();
        float interestrate = Float.parseFloat(InterestRate.getText()); 
        float loanpercent = Float.parseFloat(LoanPercent.getText()); 
        int compoundafter = Integer.parseInt(CompoundAfter.getText());
        
        try {
            SqlLogin.executeUpdate(" Insert into banks Values( NULL, '" + bank + "', '" + branch + "', '" + interestrate + "', '" + loanpercent + "', '" + compoundafter + "')");
        } catch (SQLException ex) {
            Logger.getLogger(AddBankController.class.getName()).log(Level.SEVERE, null, ex);
        }
        BankName.setText(null);
        Branch.setText(null);
        InterestRate.setText(null);
        LoanPercent.setText(null);
        CompoundAfter.setText(null);
    }
}
