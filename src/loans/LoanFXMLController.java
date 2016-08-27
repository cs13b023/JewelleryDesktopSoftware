/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loans;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author Vinod
 */
public class LoanFXMLController implements Initializable {

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
    private TextField LoansTextField;
    @FXML
    private TextField OverviewTextField;
    @FXML
    private TextField LoansTextField1;
    @FXML
    private TextField InvoicesTextField;
    @FXML
    private Pane InterestCalculatorPane;
    @FXML
    private Pane EMICalculatorPane;
    @FXML
    private Label GivenLoanAmount;
    @FXML
    private Label BorrowedLoansMonthlyInterest;
    @FXML
    private Label GivenLoansMonthlyInterest;
    @FXML
    private Label BorrowedLoanAmount;
    @FXML
    private ScrollPane AssetsList;
    @FXML
    private ScrollPane LiabilitiesList;
    @FXML
    private ScrollPane LiabilitiesPaymentPane;
    @FXML
    private ScrollPane AssetsPaymentPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            SqlLogin.executeQueryTiles("select sum(amount) from assets");
        } catch (SQLException ex) {
            Logger.getLogger(LoanFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        int ID = Integer.parseInt((String)SqlLogin.data.get(0).get(0));
        String s = NumberFormat.getIntegerInstance().format(ID);
        GivenLoanAmount.setText(s);
        try {
            // TODO
            SqlLogin.executeQueryTiles("select sum(amount) from liabilities");
        } catch (SQLException ex) {
            Logger.getLogger(LoanFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ID = Integer.parseInt((String)SqlLogin.data.get(0).get(0));
        s = NumberFormat.getIntegerInstance().format(ID);
        BorrowedLoanAmount.setText(s);
        
        try {
            // TODO
            SqlLogin.executeQueryTiles("select sum(interest) from assets");
        } catch (SQLException ex) {
            Logger.getLogger(LoanFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ID = Integer.parseInt((String)SqlLogin.data.get(0).get(0));
        s = NumberFormat.getIntegerInstance().format(ID);
        GivenLoansMonthlyInterest.setText(s);
        try {
            // TODO
            SqlLogin.executeQueryTiles("select sum(interest) from liabilities");
        } catch (SQLException ex) {
            Logger.getLogger(LoanFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ID = Integer.parseInt((String)SqlLogin.data.get(0).get(0));
        s = NumberFormat.getIntegerInstance().format(ID);
        BorrowedLoansMonthlyInterest.setText(s);
        
        AssetsListDisplay();
        LiabilitiesListDisplay();
        AccountsPaymentDisplay();
        LiabilitiesPaymentDisplay();
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
    private void handleLoanClick(MouseEvent event) {
    }

    @FXML
    private void handleInvoicesClick(MouseEvent event) {
    }

    @FXML
    private void handleInterestCalculatorClick(MouseEvent event) {
        Stage stage = new Stage();
                Object root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("InterestCalculatorFXML.fxml"));
                } catch (IOException ex) {
                    Logger.getLogger(LoanFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                }
                stage.setScene(new Scene((Parent) root));
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.initOwner(InterestCalculatorPane.getScene().getWindow());
                stage.showAndWait();
    }

    @FXML
    private void handleEMICalculatorClick(MouseEvent event) {
        Stage stage = new Stage();
        Object root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("EMICalculatorFXML.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(LoanFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
            stage.setScene(new Scene((Parent) root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(EMICalculatorPane.getScene().getWindow());
            stage.showAndWait();       
    }

    private void AssetsListDisplay() {
            AssetsList.setContent(null);
            String name;
            VBox Names = new VBox();
            Names.setSpacing(10);
            try {
            SqlLogin.executeQueryTiles("select * from assets");
            } catch (SQLException ex) {
                Logger.getLogger(AccountsController.class.getName()).log(Level.SEVERE, null, ex);
            }
            for(int i=0;i<SqlLogin.data.size();++i){
                Pane pane = new Pane();
                pane.getStyleClass().add("Pane");
                HBox hbox = new HBox();
                hbox.setSpacing(20);
                Label Name = new Label();
                Name.setStyle("-fx-text-fill:black; -fx-font-size: 15px;");
                Name.setPrefSize(165,20);
                name=(String)SqlLogin.data.get(i).get(1);
                Name.setText(name);
                int ID = Integer.parseInt((String)SqlLogin.data.get(i).get(0));
                Label Amount = new Label();
                Amount.setStyle("-fx-text-fill:black; -fx-font-size: 15px;");
                name=(String)SqlLogin.data.get(i).get(3) + "(" + (String)SqlLogin.data.get(i).get(4) + "%)";
                Amount.setText(name);
                hbox.getChildren().add(Name);
                hbox.getChildren().add(Amount);
                pane.getChildren().add(hbox);
                Names.getChildren().add(pane);
            }
            AssetsList.setContent(Names);
    }

    private void LiabilitiesListDisplay() {
            LiabilitiesList.setContent(null);
            String name;
            VBox Names = new VBox();
            Names.setSpacing(10);
            try {
            SqlLogin.executeQueryTiles("select * from liabilities");
            } catch (SQLException ex) {
                Logger.getLogger(AccountsController.class.getName()).log(Level.SEVERE, null, ex);
            }
            for(int i=0;i<SqlLogin.data.size();++i){
                Pane pane = new Pane();
                pane.getStyleClass().add("Pane");
                HBox hbox = new HBox();
                hbox.setSpacing(20);
                Label Name = new Label();
                Name.setStyle("-fx-text-fill:black; -fx-font-size: 15px;");
                Name.setPrefSize(165,20);
                name=(String)SqlLogin.data.get(i).get(1);
                Name.setText(name);
                int ID = Integer.parseInt((String)SqlLogin.data.get(i).get(0));
                Label Amount = new Label();
                Amount.setStyle("-fx-text-fill:black; -fx-font-size: 15px;");
                name=(String)SqlLogin.data.get(i).get(3) + "(" + (String)SqlLogin.data.get(i).get(4) + "%)";
                Amount.setText(name);
                hbox.getChildren().add(Name);
                hbox.getChildren().add(Amount);
                pane.getChildren().add(hbox);
                Names.getChildren().add(pane);
            }
            LiabilitiesList.setContent(Names);
    }

    private void AccountsPaymentDisplay() {
        AssetsPaymentPane.setContent(null);
        String str;
        VBox vbox = new VBox();
        vbox.setSpacing(15);
        try {
            SqlLogin.executeQueryTiles("select * from assets");
        } catch (SQLException ex) {
            Logger.getLogger(LoanFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int i=0;i<SqlLogin.data.size();++i){
            HBox hbox = new HBox();
            hbox.setSpacing(10);
            int ID = Integer.parseInt((String)SqlLogin.data.get(i).get(0));
            Label Name = new Label();
            Name.setStyle("-fx-text-fill:black; -fx-font-size: 15px;");
            Name.getStyleClass().add("Label");
            Name.setPrefSize(160,20);
            str=(String)SqlLogin.data.get(i).get(1);
            Name.setText(str);
            Label Balance = new Label();
            Balance.setStyle("-fx-text-fill:black; -fx-font-size: 15px;");
            Balance.getStyleClass().add("Label");
            Balance.setPrefSize(100,20);
            str=(String)SqlLogin.data.get(i).get(8);
            Balance.setText(str);
            Label LastPaid = new Label();
            LastPaid.setStyle("-fx-text-fill:black; -fx-font-size: 15px;");
            LastPaid.getStyleClass().add("Label");
            LastPaid.setPrefSize(140,20);
            str=(String)SqlLogin.data.get(i).get(9);
            LastPaid.setText(str);
            Button Pay = new Button();
            Pay.setPrefSize(50,5);
            Pay.setText("Pay");
            Pay.setOnMouseClicked(new EventHandler<MouseEvent>(){
                    @Override
                    public void handle(MouseEvent event) {
                        SelectedItem.setID(ID);
                        Stage stage = new Stage();
                        Object root = null;
                        try {
                            root = FXMLLoader.load(getClass().getResource("MakeAssetsPayment.fxml"));
                        } catch (IOException ex) {
                            Logger.getLogger(LoanFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        stage.setScene(new Scene((Parent) root));
                        stage.initModality(Modality.APPLICATION_MODAL);
                        stage.initOwner(Pay.getScene().getWindow());
                        stage.showAndWait();
                    }
                });
            hbox.getChildren().add(Name);
            hbox.getChildren().add(Balance);
            hbox.getChildren().add(LastPaid);
            hbox.getChildren().add(Pay);
            vbox.getChildren().add(hbox);
        }
        AssetsPaymentPane.setContent(vbox);
    }

    private void LiabilitiesPaymentDisplay() {
        LiabilitiesPaymentPane.setContent(null);
        String str;
        VBox vbox = new VBox();
        vbox.setSpacing(15);
        try {
            SqlLogin.executeQueryTiles("select * from liabilities");
        } catch (SQLException ex) {
            Logger.getLogger(LoanFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int i=0;i<SqlLogin.data.size();++i){
            HBox hbox = new HBox();
            hbox.setSpacing(10);
            int ID = Integer.parseInt((String)SqlLogin.data.get(i).get(0));
            Label Name = new Label();
            Name.setStyle("-fx-text-fill:black; -fx-font-size: 15px;");
            Name.getStyleClass().add("Label");
            Name.setPrefSize(160,20);
            str=(String)SqlLogin.data.get(i).get(1);
            Name.setText(str);
            Label Balance = new Label();
            Balance.setStyle("-fx-text-fill:black; -fx-font-size: 15px;");
            Balance.getStyleClass().add("Label");
            Balance.setPrefSize(100,20);
            str=(String)SqlLogin.data.get(i).get(8);
            Balance.setText(str);
            Label LastPaid = new Label();
            LastPaid.setStyle("-fx-text-fill:black; -fx-font-size: 15px;");
            LastPaid.getStyleClass().add("Label");
            LastPaid.setPrefSize(140,20);
            str=(String)SqlLogin.data.get(i).get(9);
            LastPaid.setText(str);
            Button Pay = new Button();
            Pay.setPrefSize(50,5);
            Pay.setText("Pay");
            Pay.setOnMouseClicked(new EventHandler<MouseEvent>(){
                    @Override
                    public void handle(MouseEvent event) {
                        SelectedItem.setID(ID);
                        Stage stage = new Stage();
                        Object root = null;
                        try {
                            root = FXMLLoader.load(getClass().getResource("MakeLiabilitiesPayment.fxml"));
                        } catch (IOException ex) {
                            Logger.getLogger(LoanFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        stage.setScene(new Scene((Parent) root));
                        stage.initModality(Modality.APPLICATION_MODAL);
                        stage.initOwner(Pay.getScene().getWindow());
                        stage.showAndWait();
                    }
                });
            hbox.getChildren().add(Name);
            hbox.getChildren().add(Balance);
            hbox.getChildren().add(LastPaid);
            hbox.getChildren().add(Pay);
            vbox.getChildren().add(hbox);
        }
        LiabilitiesPaymentPane.setContent(vbox);
    }
    
}
