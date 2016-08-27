/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loans;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static java.time.temporal.ChronoUnit.DAYS;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Vinod
 */
public class AccountsController implements Initializable {

    @FXML
    private TextField Home;
    @FXML
    private TextField Overview;
    @FXML
    private TextField Current;
    @FXML
    private TextField Karigar;
    @FXML
    private TextField Karigar1;
    @FXML
    private Pane Default;
    @FXML
    private Label Taker1;
    @FXML
    private Label Taker2;
    @FXML
    private Label Taker3;
    @FXML
    private Label Taker4;
    @FXML
    private Label Taker5;
    @FXML
    private Label Asset1;
    @FXML
    private Label Asset2;
    @FXML
    private Label Asset3;
    @FXML
    private Label Asset4;
    @FXML
    private Label Asset5;
    @FXML
    private PieChart AssetsPieChart;
    @FXML
    private PieChart LiabilitiesPieChart;
    @FXML
    private Label Giver1;
    @FXML
    private Label Giver2;
    @FXML
    private Label Giver3;
    @FXML
    private Label Giver4;
    @FXML
    private Label Giver5;
    @FXML
    private Label Liability5;
    @FXML
    private Label Liability4;
    @FXML
    private Label Liability3;
    @FXML
    private Label Liability2;
    @FXML
    private Label Liability1;
    @FXML
    private ScrollPane ListScrollPane;
    @FXML
    private TextField ListSearch;
    @FXML
    private Pane CurrentAssetsPane;
    @FXML
    private Pane CurrentLiabilitiesPane;
    @FXML
    private Label ViewDetailsName;
    @FXML
    private Label ViewDetailsRate;
    @FXML
    private Label ViewDetailsInterest;
    @FXML
    private Label ViewDetailsAmount;
    private Label ViewDetailsBalance;
    @FXML
    private Pane ViewDetailsPane;
    @FXML
    private Label ViewDetailsDate;
    @FXML
    private Button ViewDetailsClose;
    @FXML
    private Label AssetsRight;
    @FXML
    private Label AssetsLeft;
    @FXML
    private Pane CurrentLiabilitiesInterestPane;
    @FXML
    private PieChart LiabilitiesInterestPieChart;
    @FXML
    private Label InterestGiver1;
    @FXML
    private Label InterestGiver2;
    @FXML
    private Label InterestGiver5;
    @FXML
    private Label InterestLiability5;
    @FXML
    private Label InterestLiability4;
    @FXML
    private Label InterestLiability3;
    @FXML
    private Label InterestLiability2;
    @FXML
    private Label InterestLiability1;
    @FXML
    private Label InterestGiver3;
    @FXML
    private Label InterestGiver4;
    @FXML
    private Pane CurrentAssetsInterestPane;
    @FXML
    private PieChart AssetsInterestPieChart;
    @FXML
    private Label InterestTaker1;
    @FXML
    private Label InterestTaker2;
    @FXML
    private Label InterestTaker3;
    @FXML
    private Label InterestTaker4;
    @FXML
    private Label InterestTaker5;
    @FXML
    private Label InterestAsset1;
    @FXML
    private Label InterestAsset3;
    @FXML
    private Label InterestAsset4;
    @FXML
    private Label InterestAsset5;
    @FXML
    private Label LiabilitiesRight;
    @FXML
    private Label LiabilitiesLeft;
    @FXML
    private Label LiabilitiesInterestRight;
    @FXML
    private Label LiabilitiesInterestLeft;
    @FXML
    private Label AssetsInterestRight;
    @FXML
    private Label AssetsInterestLeft;
    @FXML
    private TableView ViewDetailsTable;
    @FXML
    private Label InterestAsset2;
    @FXML
    private Pane NewLoanPane;
    @FXML
    private Button NewLoansClose;
    @FXML
    private ComboBox NewLoanType;
    @FXML
    private TextField Person;
    @FXML
    private TextArea Address;
    @FXML
    private TextField Amount;
    @FXML
    private TextField InterestRate;
    @FXML
    private TextField CompoundAfter;
    @FXML
    private Button AddLoan;
    @FXML
    private Label ViewDetailsAddress;
    @FXML
    private Label ViewDetailsLastInterestAdded;
    @FXML
    private Label ViewDetailsCompundAfter;
    @FXML
    private Label ViewDetailsPayable;
    @FXML
    private TextField AmountPaid;
    @FXML
    private ComboBox PaymentComboBox;
    @FXML
    private DatePicker DateOfPayment;
    @FXML
    private Button AddPayment;
    @FXML
    private Label ViewDetailsID;
    @FXML
    private Label ViewDetailsPrincipal;
    @FXML
    private Label ViewDetailsType;
    @FXML
    private DatePicker NewLoanDate;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
                
        UpdateInterest.UpdateAssetsInterest();
        UpdateInterest.UpdateLiabilitiesInterest();
        try {
            SqlLogin.executeQueryTiles("select * from assets order by dateoflending desc");
        } catch (SQLException ex) {
            Logger.getLogger(AccountsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        CurrentAssetsDisplay(SqlLogin.data);
        AssetsPieChart.setData(Graphs.getPieChartData("select customer,payable from assets"));
        AssetsInterestPieChart.setData(Graphs.getPieChartData("select customer,interest from assets"));
        
       try {
            SqlLogin.executeQueryTiles("select * from liabilities order by dateoflending desc");
        } catch (SQLException ex) {
            Logger.getLogger(AccountsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        CurrentLiabilitiesDisplay(SqlLogin.data);
        LiabilitiesPieChart.setData(Graphs.getPieChartData("select customer,payable from liabilities"));
        LiabilitiesInterestPieChart.setData(Graphs.getPieChartData("select customer,interest from liabilities"));
        
        ListDisplay();
        
        CurrentAssetsPane.setVisible(true);
        CurrentLiabilitiesPane.setVisible(true);
        CurrentAssetsInterestPane.setVisible(false);
        CurrentLiabilitiesInterestPane.setVisible(false);
        ViewDetailsPane.setVisible(false);
        NewLoanPane.setVisible(false);
        
        NewLoanType.getItems().addAll(
            "Asset",
            "Liability"
        );
        PaymentComboBox.getItems().addAll(
            "Cash",
            "Card",
            "Cheque"
        );
        NewLoanDate.setValue(LocalDate.now());
    }    

    @FXML
    private void handleHome(MouseEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       // app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    private void handleSales(MouseEvent event) {
    }

    @FXML
    private void handleOrders(MouseEvent event) {
    }

    @FXML
    private void handleemployee(MouseEvent event) {
    }

    @FXML
    private void handlechits(MouseEvent event) {
    }

    @FXML
    private void handleGirviClick(MouseEvent event) {
    }

    @FXML
    private void handleInventory(MouseEvent event) {
    }

    @FXML
    private void handleLoanClick(MouseEvent event) {
    }

    @FXML
    private void handleloyalty(MouseEvent event) {
    }

    @FXML
    private void handleOverview(MouseEvent event) {
    }

    @FXML
    private void handleCurrent(MouseEvent event) {
    }
    
    public void CurrentAssetsDisplay(ObservableList<ObservableList> data){
            Taker1.setText((String) SqlLogin.data.get(0).get(1));
            Taker2.setText((String) SqlLogin.data.get(1).get(1));
            Taker3.setText((String) SqlLogin.data.get(2).get(1));
            Taker4.setText((String) SqlLogin.data.get(3).get(1));
            Taker5.setText((String) SqlLogin.data.get(4).get(1));
            Asset1.setText((String) SqlLogin.data.get(0).get(8));
            Asset2.setText((String) SqlLogin.data.get(1).get(8));
            Asset3.setText((String) SqlLogin.data.get(2).get(8));
            Asset4.setText((String) SqlLogin.data.get(3).get(8));
            Asset5.setText((String) SqlLogin.data.get(4).get(8));
            InterestTaker1.setText((String) SqlLogin.data.get(0).get(1));
            InterestTaker2.setText((String) SqlLogin.data.get(1).get(1));
            InterestTaker3.setText((String) SqlLogin.data.get(2).get(1));
            InterestTaker4.setText((String) SqlLogin.data.get(3).get(1));
            InterestTaker5.setText((String) SqlLogin.data.get(4).get(1));
            InterestAsset1.setText((String) SqlLogin.data.get(0).get(7));
            InterestAsset2.setText((String) SqlLogin.data.get(1).get(7));
            InterestAsset3.setText((String) SqlLogin.data.get(2).get(7));
            InterestAsset4.setText((String) SqlLogin.data.get(3).get(7));
            InterestAsset5.setText((String) SqlLogin.data.get(4).get(7));
    }
    
    public void CurrentLiabilitiesDisplay(ObservableList<ObservableList> data){
            Giver1.setText((String) SqlLogin.data.get(0).get(1));
            Giver2.setText((String) SqlLogin.data.get(1).get(1));
            Giver3.setText((String) SqlLogin.data.get(2).get(1));
            Giver4.setText((String) SqlLogin.data.get(3).get(1));
            Giver5.setText((String) SqlLogin.data.get(4).get(1));
            Liability1.setText((String) SqlLogin.data.get(0).get(8));
            Liability2.setText((String) SqlLogin.data.get(1).get(8));
            Liability3.setText((String) SqlLogin.data.get(2).get(8));
            Liability4.setText((String) SqlLogin.data.get(3).get(8));
            Liability5.setText((String) SqlLogin.data.get(4).get(8));
            InterestGiver1.setText((String) SqlLogin.data.get(0).get(1));
            InterestGiver2.setText((String) SqlLogin.data.get(1).get(1));
            InterestGiver3.setText((String) SqlLogin.data.get(2).get(1));
            InterestGiver4.setText((String) SqlLogin.data.get(3).get(1));
            InterestGiver5.setText((String) SqlLogin.data.get(4).get(1));
            InterestLiability1.setText((String) SqlLogin.data.get(0).get(7));
            InterestLiability2.setText((String) SqlLogin.data.get(1).get(7));
            InterestLiability3.setText((String) SqlLogin.data.get(2).get(7));
            InterestLiability4.setText((String) SqlLogin.data.get(3).get(7));
            InterestLiability5.setText((String) SqlLogin.data.get(4).get(7)); 
    }
    

    private void ListDisplay() {
            ListScrollPane.setContent(null);
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
                Label Name = new Label();
                Name.setStyle("-fx-text-fill:black; -fx-font-size: 20px;");
                Name.setPrefSize(260,20);
                name=(String)SqlLogin.data.get(i).get(1);
                int ID = Integer.parseInt((String)SqlLogin.data.get(i).get(0));
                Name.setText(name);
                pane.setOnMouseClicked(new EventHandler<MouseEvent>(){
                    @Override
                    public void handle(MouseEvent event) {
                        CurrentAssetsPane.setVisible(false);
                        CurrentLiabilitiesPane.setVisible(false);
                        CurrentAssetsInterestPane.setVisible(false);
                        CurrentLiabilitiesInterestPane.setVisible(false);
                        NewLoanPane.setVisible(false);
                        ViewAssetsDetails(ID);
                        ViewDetailsPane.setVisible(true);
                    }
                });
                pane.setOnMouseEntered(new EventHandler<MouseEvent>(){
                    @Override
                    public void handle(MouseEvent event) {
                        
                    }
                });
                pane.setOnMouseExited(new EventHandler<MouseEvent>(){
                    @Override
                    public void handle(MouseEvent event) {
                        
                    }
                });
                pane.getChildren().add(Name);
                Names.getChildren().add(pane);
            }
            try {
            SqlLogin.executeQueryTiles("select * from liabilities");
            } catch (SQLException ex) {
                Logger.getLogger(AccountsController.class.getName()).log(Level.SEVERE, null, ex);
            }
            for(int i=0;i<SqlLogin.data.size();++i){
                Pane pane = new Pane();
                pane.getStyleClass().add("Pane");
                Label Name = new Label();
                Name.setStyle("-fx-text-fill:red; -fx-font-size: 20px;");
                Name.setPrefSize(260,20);
                name=(String)SqlLogin.data.get(i).get(1);
                int ID = Integer.parseInt((String)SqlLogin.data.get(i).get(0));
                Name.setText(name);
                pane.setOnMouseClicked(new EventHandler<MouseEvent>(){
                    @Override
                    public void handle(MouseEvent event) {
                        CurrentAssetsPane.setVisible(false);
                        CurrentLiabilitiesPane.setVisible(false);
                        CurrentAssetsInterestPane.setVisible(false);
                        CurrentLiabilitiesInterestPane.setVisible(false);
                        NewLoanPane.setVisible(false);
                        ViewLiabilitiesDetails(ID);
                        ViewDetailsPane.setVisible(true);
                    }
                });
                pane.getChildren().add(Name);
                Names.getChildren().add(pane);               
            }
            ListScrollPane.setContent(Names);
    }
    
    
    private void ViewAssetsDetails(int ID) {
        String query = "select * from assets where id = " + ID;
        try {
            SqlSelectedItems.executeSelectedItems(query);
        } catch (SQLException ex) {
            Logger.getLogger(AccountsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ViewDetailsType.setText("Asset");
        String name = (String) SqlSelectedItems.data.get(0).get(0);
        ViewDetailsID.setText(name);
        name = (String) SqlSelectedItems.data.get(0).get(1);
        ViewDetailsName.setText(name);
        name = (String) SqlSelectedItems.data.get(0).get(2);
        ViewDetailsAddress.setText(name);
        name = (String) SqlSelectedItems.data.get(0).get(3);
        ViewDetailsAmount.setText(name);
        name = (String) SqlSelectedItems.data.get(0).get(4);
        ViewDetailsRate.setText(name);
        name = (String) SqlSelectedItems.data.get(0).get(5);
        ViewDetailsCompundAfter.setText(name);
        name = (String) SqlSelectedItems.data.get(0).get(6);
        ViewDetailsDate.setText(name);
        name = (String) SqlSelectedItems.data.get(0).get(7);
        ViewDetailsInterest.setText(name);
        name = (String) SqlSelectedItems.data.get(0).get(11);
        ViewDetailsLastInterestAdded.setText(name); 
        name = (String) SqlSelectedItems.data.get(0).get(8);
        ViewDetailsPayable.setText(name);
        name = (String) SqlSelectedItems.data.get(0).get(10);
        ViewDetailsPrincipal.setText(name);
        ViewDetailsTable.setEditable(true);
      
                    if(!ViewDetailsTable.getColumns().isEmpty())
                        ViewDetailsTable.getColumns().clear();
                    try {
                        SqlLogin.executeQuery("select * from assetspayments where assetsid = " + ID,ViewDetailsTable);
                    } catch (SQLException ex) {
                        Logger.getLogger(AccountsController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                        ViewDetailsTable.setItems(SqlLogin.data);
        AmountPaid.setText(null);
        PaymentComboBox.setValue(null);
        DateOfPayment.setValue(LocalDate.now());
    }
    
    private void ViewLiabilitiesDetails(int ID) {
        String query = "select * from liabilities where id = " + ID;
        try {
            SqlSelectedItems.executeSelectedItems(query);
        } catch (SQLException ex) {
            Logger.getLogger(AccountsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ViewDetailsType.setText("Liability");
        String name = (String) SqlSelectedItems.data.get(0).get(0);
        ViewDetailsID.setText(name);
        name = (String) SqlSelectedItems.data.get(0).get(1);
        ViewDetailsName.setText(name);
        name = (String) SqlSelectedItems.data.get(0).get(2);
        ViewDetailsAddress.setText(name);
        name = (String) SqlSelectedItems.data.get(0).get(3);
        ViewDetailsAmount.setText(name);
        name = (String) SqlSelectedItems.data.get(0).get(4);
        ViewDetailsRate.setText(name);
        name = (String) SqlSelectedItems.data.get(0).get(5);
        ViewDetailsCompundAfter.setText(name);
        name = (String) SqlSelectedItems.data.get(0).get(6);
        ViewDetailsDate.setText(name);
        name = (String) SqlSelectedItems.data.get(0).get(7);
        ViewDetailsInterest.setText(name);
        name = (String) SqlSelectedItems.data.get(0).get(11);
        ViewDetailsLastInterestAdded.setText(name); 
        name = (String) SqlSelectedItems.data.get(0).get(8);
        ViewDetailsPayable.setText(name);
        name = (String) SqlSelectedItems.data.get(0).get(10);
        ViewDetailsPrincipal.setText(name);
        ViewDetailsTable.setEditable(true);
      
                    if(!ViewDetailsTable.getColumns().isEmpty())
                        ViewDetailsTable.getColumns().clear();
                    try {
                        SqlLogin.executeQuery("select * from liabilitiespayments where liabilitiesid = " + ID,ViewDetailsTable);
                    } catch (SQLException ex) {
                        Logger.getLogger(AccountsController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                        ViewDetailsTable.setItems(SqlLogin.data);
        AmountPaid.setText(null);
        PaymentComboBox.setValue(null);
        DateOfPayment.setValue(LocalDate.now());
    }
    
    private void ListSearchDisplay(String search) {
        ListScrollPane.setContent(null);
        String name;
        VBox Names = new VBox();
        Names.setSpacing(10);
        
        try {
            SqlLogin.executeQueryTiles("select * from assets where customer like '" + search + "%'");
        } catch (SQLException ex) {
            Logger.getLogger(AccountsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int i=0;i<SqlLogin.data.size();++i){
            Pane pane = new Pane();
            pane.getStyleClass().add("Pane");
            Label Name = new Label();
            Name.setPrefSize(260,20);
            Name.setStyle("-fx-text-fill:black; -fx-font-size: 20px;");
            name=(String)SqlLogin.data.get(i).get(1);
            int ID = Integer.parseInt((String)SqlLogin.data.get(i).get(0));
                Name.setText(name);
                pane.setOnMouseClicked(new EventHandler<MouseEvent>(){
                    @Override
                    public void handle(MouseEvent event) {
                        CurrentAssetsPane.setVisible(false);
                        CurrentLiabilitiesPane.setVisible(false);
                        CurrentAssetsInterestPane.setVisible(false);
                        CurrentLiabilitiesInterestPane.setVisible(false);
                        NewLoanPane.setVisible(false);
                        ViewAssetsDetails(ID);
                        ViewDetailsPane.setVisible(true);
                    }
                });
            pane.getChildren().add(Name);
            Names.getChildren().add(pane);
        }
        try {
            SqlLogin.executeQueryTiles("select * from liabilities where customer like '" + search + "%'");
        } catch (SQLException ex) {
            Logger.getLogger(AccountsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int i=0;i<SqlLogin.data.size();++i){
            Pane pane = new Pane();
            pane.getStyleClass().add("Pane");
            Label Name = new Label();
            Name.setStyle("-fx-text-fill:red; -fx-font-size: 20px;");
            Name.setPrefSize(260,20);
            name=(String)SqlLogin.data.get(i).get(1);
            int ID = Integer.parseInt((String)SqlLogin.data.get(i).get(0));
                Name.setText(name);
                pane.setOnMouseClicked(new EventHandler<MouseEvent>(){
                    @Override
                    public void handle(MouseEvent event) {
                        CurrentAssetsPane.setVisible(false);
                        CurrentLiabilitiesPane.setVisible(false);
                        CurrentAssetsInterestPane.setVisible(false);
                        CurrentLiabilitiesInterestPane.setVisible(false);
                        NewLoanPane.setVisible(false);
                        ViewLiabilitiesDetails(ID);
                        ViewDetailsPane.setVisible(true);
                    }
                });
            pane.getChildren().add(Name);
            Names.getChildren().add(pane);
        }
        ListScrollPane.setContent(Names);
    }

    @FXML
    private void handleListSearch(KeyEvent event) {
        String search = ListSearch.getText();
        ListSearchDisplay(search);
    }

    @FXML
    private void handleViewDetailsClose(ActionEvent event) {
        NewLoanPane.setVisible(false);
        CurrentAssetsPane.setVisible(true);
        CurrentLiabilitiesPane.setVisible(true);
        CurrentAssetsInterestPane.setVisible(false);
        CurrentLiabilitiesInterestPane.setVisible(false);
        ViewDetailsPane.setVisible(false);
    }

    @FXML
    private void handleAssetsShift(MouseEvent event) {
        CurrentAssetsPane.setVisible(false);
        CurrentAssetsInterestPane.setVisible(true);
    }

    @FXML
    private void handleLiabilitiesShift(MouseEvent event) {
        CurrentLiabilitiesPane.setVisible(false);
        CurrentLiabilitiesInterestPane.setVisible(true);
    }

    @FXML
    private void handleLiabilitiesInterestShift(MouseEvent event) {
        CurrentLiabilitiesPane.setVisible(true);
        CurrentLiabilitiesInterestPane.setVisible(false);
    }

    @FXML
    private void handleAssetsInterestShift(MouseEvent event) {
        CurrentAssetsPane.setVisible(true);
        CurrentAssetsInterestPane.setVisible(false);
    }

    @FXML
    private void handleNewLoan(ActionEvent event) {
        NewLoanPane.setVisible(true);
        CurrentAssetsPane.setVisible(false);
        CurrentLiabilitiesPane.setVisible(false);
        CurrentAssetsInterestPane.setVisible(false);
        CurrentLiabilitiesInterestPane.setVisible(false);
        ViewDetailsPane.setVisible(false);
    }

    @FXML
    private void handleNewLoansClose(ActionEvent event) {
        NewLoanPane.setVisible(false);
        CurrentAssetsPane.setVisible(true);
        CurrentLiabilitiesPane.setVisible(true);
        CurrentAssetsInterestPane.setVisible(false);
        CurrentLiabilitiesInterestPane.setVisible(false);
        ViewDetailsPane.setVisible(false);
    }

    @FXML
    private void handleAddLoan(ActionEvent event) {
        String customer = Person.getText();
        String address = Address.getText();
        int amount = Integer.parseInt((String)Amount.getText());
        float interestrate = Float.parseFloat((String)InterestRate.getText());
        int compoundafter = Integer.parseInt((String)CompoundAfter.getText());
        LocalDate date = NewLoanDate.getValue();
        int interest = 0;
        int payable = amount;
        int principal = amount;
        LocalDate LastPaidDate = LocalDate.parse("0001-01-01");
        LocalDate LastInterestAddedDate = LocalDate.parse("0001-01-01");
        String LoanType = (String) NewLoanType.getValue();
        if(LoanType.equals("Asset")){
            try {
                //System.out.println(" Insert into assets Values( NULL, '" + customer + "', '" + address + "', '" + amount + "', '" + interestrate + "', '" + compoundafter + "', '" + date +  "', '" + interest +  "', '" + payable +  "', '" + LastPaidDate +  "', '" + principal +  "', '" + LastInterestAddedDate + "')");
                SqlLogin.executeUpdate(" Insert into assets Values( NULL, '" + customer + "', '" + address + "', '" + amount + "', '" + interestrate + "', '" + compoundafter + "', '" + date +  "', '" + interest +  "', '" + payable +  "', '" + LastPaidDate +  "', '" + principal +  "', '" + LastInterestAddedDate + "')");
            } catch (SQLException ex) {
                Logger.getLogger(AccountsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            try {
                //System.out.println(" Insert into liabilities Values( NULL, '" + customer + "', '" + address + "', '" + amount + "', '" + interestrate + "', '" + compoundafter + "', '" + date +  "', '" + interest +  "', '" + payable +  "', '" + LastPaidDate +  "', '" + principal +  "', '" + LastInterestAddedDate + "')");
                SqlLogin.executeUpdate(" Insert into liabilities Values( NULL, '" + customer + "', '" + address + "', '" + amount + "', '" + interestrate + "', '" + compoundafter + "', '" + date +  "', '" + interest +  "', '" + payable +  "', '" + LastPaidDate +  "', '" + principal +  "', '" + LastInterestAddedDate + "')");
            } catch (SQLException ex) {
                Logger.getLogger(AccountsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        NewLoanType.setValue(null);
        Person.setText(null);
        Address.setText(null);
        Amount.setText(null);
        InterestRate.setText(null);
        CompoundAfter.setText(null);
        NewLoanDate.setValue(LocalDate.now());
        ListDisplay();
        refreshHome();
    }

    @FXML
    private void handleAddPayment(ActionEvent event) {
        String Type = ViewDetailsType.getText();
        int i = Integer.parseInt(ViewDetailsID.getText());
        int amount = Integer.parseInt(AmountPaid.getText());
        LocalDate date = DateOfPayment.getValue();
        String paymentType = (String) PaymentComboBox.getValue();
        int interest = Integer.parseInt(ViewDetailsInterest.getText());
        int principal = Integer.parseInt(ViewDetailsPrincipal.getText());
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
        if(Type.equals("Asset")){
            try {
                SqlLogin.executeUpdate(" Insert into assetspayments Values( NULL, '" + i + "', '" + amount + "', '" + date + "', '" + paymentType + "', '" + interestcut +  "', '" + principalcut + "')");
            } catch (SQLException ex) {
                Logger.getLogger(MakeAssetsPaymentController.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                SqlLogin.executeUpdate(" update assets set last_paid = '" + date + "', interest = '" + newinterest + "', principal = '" + newprincipal + "' where id = " + i );
                System.out.println(" update assets set last_paid = '" + date + "', interest = '" + newinterest + "', principal = '" + newprincipal + "' where id = " + i );
            } catch (SQLException ex) {
                Logger.getLogger(MakeAssetsPaymentController.class.getName()).log(Level.SEVERE, null, ex);
            }
            refreshHome();
            ViewAssetsDetails(i);
        }
        else{
            try {
                SqlLogin.executeUpdate(" Insert into liabilitiespayments Values( NULL, '" + i + "', '" + amount + "', '" + date + "', '" + paymentType + "', '" + interestcut +  "', '" + principalcut + "')");
            } catch (SQLException ex) {
                Logger.getLogger(MakeAssetsPaymentController.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                SqlLogin.executeUpdate(" update liabilities set last_paid = '" + date + "', interest = '" + newinterest + "', principal = '" + newprincipal + "' where id = " + i );
                //System.out.println(" update liabilities set last_paid = '" + date + "', interest = '" + newinterest + "', principal = '" + newprincipal + "' where id = " + i );
            } catch (SQLException ex) {
                Logger.getLogger(MakeAssetsPaymentController.class.getName()).log(Level.SEVERE, null, ex);
            }
            refreshHome();
            ViewAssetsDetails(i);
        }
    }

    private void refreshHome() {
        UpdateInterest.UpdateAssetsInterest();
        UpdateInterest.UpdateLiabilitiesInterest();
        
        try {
            SqlLogin.executeQueryTiles("select * from assets order by dateoflending desc");
        } catch (SQLException ex) {
            Logger.getLogger(AccountsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        CurrentAssetsDisplay(SqlLogin.data);
        AssetsPieChart.setData(Graphs.getPieChartData("select customer,payable from assets"));
        AssetsInterestPieChart.setData(Graphs.getPieChartData("select customer,interest from assets"));
        
        try {
            SqlLogin.executeQueryTiles("select * from liabilities order by dateoflending desc");
        } catch (SQLException ex) {
            Logger.getLogger(AccountsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        CurrentLiabilitiesDisplay(SqlLogin.data);
        LiabilitiesPieChart.setData(Graphs.getPieChartData("select customer,payable from liabilities"));
        LiabilitiesInterestPieChart.setData(Graphs.getPieChartData("select customer,interest from liabilities"));
    }
    
}
