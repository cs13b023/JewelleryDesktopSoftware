/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loans;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Vinod
 */
public class MakeLiabilitiesPaymentController implements Initializable {

    @FXML
    private DatePicker datePicker = new DatePicker();
    @FXML
    private ComboBox TypeComboBox = new ComboBox();     
    private Label Balance;
    @FXML
    private Button Save;
    @FXML
    private Label LoanAmount;
    @FXML
    private Label Name;
    @FXML
    private TextField AmountPaid;
    @FXML
    private Label Interest;
    @FXML
    private Label Payable;
    @FXML
    private Label Principal;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        String str;
        int i = SelectedItem.getID();
        String query = "select * from liabilities where id =" + i;
        System.out.println(query);
        try {
            SqlSelectedItems.executeSelectedItems(query);
        } catch (SQLException ex) {
            Logger.getLogger(MakeLiabilitiesPaymentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        str = (String) SqlSelectedItems.data.get(0).get(1);
        Name.setText(str);
        str = (String) SqlSelectedItems.data.get(0).get(3);
        LoanAmount.setText(str);
        str = (String) SqlSelectedItems.data.get(0).get(7);
        Interest.setText(str);
        str = (String) SqlSelectedItems.data.get(0).get(8);
        Payable.setText(str);
        str = (String) SqlSelectedItems.data.get(0).get(10);
        Principal.setText(str);
        TypeComboBox.getItems().addAll(
            "Cash",
            "Card",
            "Cheque"
        );
        datePicker.setValue(LocalDate.now());
    }    

    @FXML
    private void MakePayment(ActionEvent event) {
        int i = SelectedItem.getID();
        int amount = Integer.parseInt(AmountPaid.getText());
        LocalDate date = datePicker.getValue();
        String paymentType = (String) TypeComboBox.getValue();
        int interest = Integer.parseInt(Interest.getText());
        int principal = Integer.parseInt(Principal.getText());
        int interestcut;
        int principalcut;
        int newinterest;
        int newprincipal;
        if(amount>interest){
            interestcut = interest;
            newinterest = 0;
            principalcut = amount-interest;
            newprincipal = principal-principalcut;
        }
        else{
            interestcut = amount;
            principalcut = 0;
            newinterest = interest - interestcut;
            newprincipal = principal;
        }
        try {
            SqlLogin.executeUpdate(" Insert into liabilitiespayments Values( NULL, '" + i + "', '" + amount + "', '" + date + "', '" + paymentType + "', '" + interestcut +  "', '" + principalcut + "')");
        } catch (SQLException ex) {
            Logger.getLogger(MakeLiabilitiesPaymentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            SqlLogin.executeUpdate(" update liabilities set last_paid = '" + date + "', interest = '" + newinterest + "', principal = '" + newprincipal + "' where id = " + i );
            System.out.println(" update liabilities set last_paid = '" + date + "', interest = '" + newinterest + "', principal = '" + newprincipal + "' where id = " + i );
        } catch (SQLException ex) {
            Logger.getLogger(MakeLiabilitiesPaymentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        refresh();
    }

    private void refresh() {
        UpdateInterest.UpdateLiabilitiesInterest();
        AmountPaid.setText(null);
        TypeComboBox.setValue(null);
        String str;
        int i = SelectedItem.getID();
        String query = "select * from liabilities where id =" + i;
        System.out.println(query);
        try {
            SqlSelectedItems.executeSelectedItems(query);
        } catch (SQLException ex) {
            Logger.getLogger(MakeLiabilitiesPaymentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        str = (String) SqlSelectedItems.data.get(0).get(1);
        Name.setText(str);
        str = (String) SqlSelectedItems.data.get(0).get(3);
        LoanAmount.setText(str);
        str = (String) SqlSelectedItems.data.get(0).get(7);
        Interest.setText(str);
        str = (String) SqlSelectedItems.data.get(0).get(8);
        Payable.setText(str);
        str = (String) SqlSelectedItems.data.get(0).get(10);
        Principal.setText(str);
        datePicker.setValue(LocalDate.now());
    }
    
}
