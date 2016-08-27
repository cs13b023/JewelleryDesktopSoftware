/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package girvi;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Vinod
 */
public class OverviewController implements Initializable {

    @FXML
    private TextField handleHome;
    @FXML
    private TextField Orders;
    @FXML
    private TextField employee;
    @FXML
    private TextField Girvi;
    @FXML
    private TextField Loans;
    @FXML
    private TextField loyalty;
    @FXML
    private TextField InvoicesTextField;
    @FXML
    private TextField LoansTextField;
    @FXML
    private TextField OverviewTextField;
    @FXML
    private TextField LoansTextField1;
    @FXML
    private Pane InterestCalculatorPane;
    @FXML
    private Pane EMICalculatorPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

    @FXML
    private void handleHomeClick(MouseEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       // app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    private void handleInvoicesClick(MouseEvent event) {
    }

    @FXML
    private void handleLoanClick(MouseEvent event) {
    }

    @FXML
    private void handleInterestCalculatorClick(MouseEvent event) {
    }

    @FXML
    private void handleEMICalculatorClick(MouseEvent event) {
    }
    
}
