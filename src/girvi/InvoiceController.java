/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package girvi;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Vinod
 */
public class InvoiceController implements Initializable {

    @FXML
    private Label GoldRate;
    @FXML
    private Pane InvMainPane;
    @FXML
    private TableView table;
    @FXML
    private TextField custName;
    @FXML
    private TextField address1;
    @FXML
    private TextField address2;
    @FXML
    private TextField Pin;
    @FXML
    private TextField PanNo;
    @FXML
    private TextField phoneNo;
    @FXML
    private TextField relationWith;
    @FXML
    private VBox suggestion;
    @FXML
    private ComboBox<?> relation;
    @FXML
    private ComboBox material = new ComboBox(); 
    @FXML
    private ComboBox item = new ComboBox();
    @FXML
    private TextField grossWt;
    @FXML
    private TextField value;
    @FXML
    private TextField purity;
    @FXML
    private Button clear;
    @FXML
    private Button add;
    @FXML
    private ImageView itemImage;
    @FXML
    private Button uploadImage;
    @FXML
    private TextField priceAgreed;
    @FXML
    private Button uploadImage1;
    @FXML
    private ImageView itemImage1;
    @FXML
    private TextField interestRate;
    @FXML
    private TextArea Description;
    @FXML
    private ComboBox paymentMode = new ComboBox();
    @FXML
    private Button addOffer;
    @FXML
    private Button save;
    @FXML
    private Button print;
    @FXML
    private Label total;
    @FXML
    private TextField custName1;
    @FXML
    private TextField SalesInvoice;
    @FXML
    private TextField SalesOverView;
    @FXML
    private TextField SalesSoldItems;
    @FXML
    private TextField SalesInvoice1;
    @FXML
    private Button Delete;
    @FXML
    private TextField LoanAmt;
    @FXML
    private TextField Interest;
    @FXML
    private TextField AmountPayable;
    @FXML
    private TextField AmtPaid;
    @FXML
    private Button Renew;
    @FXML
    private TableView renewtable;
    @FXML
    private ScrollPane ModifyGirvi;
    @FXML
    private TextField InvoiceID;
    @FXML
    private Button renewsave;
    @FXML
    private ComboBox renewpaymentMode;
    @FXML
    private Button renewaddOffer;
    @FXML
    private Button renewprint;
    @FXML
    private Label renewtotal;
    @FXML
    private Button renewDelete;
    @FXML
    private TableView OrnamentTable;
    
    
    /**
     * Initializes the controller class.
     */
    int girviSNo=0;
    int renewSNo=0;
    ObservableList<ObservableList> data ;
    ObservableList<ObservableList> renewdata ;
    @FXML
    private TextField Principal;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        UpdateInterest.Update();
        material.getItems().addAll(
            "Gold",
            "Silver",
            "Diamond",
            "Platinum",
            "Bronze",
            "Others"
        );
        
        item.getItems().addAll(
            "Necklace",
            "Chain",
            "Bracelet",
            "Ring",
            "Biscuit",
            "Others"
        );
        
        paymentMode.getItems().addAll(
            "Cash",
            "Card",
            "Cheque"
        );
        
        renewpaymentMode.getItems().addAll(
            "Cash",
            "Card",
            "Cheque"
        );
        
        data = FXCollections.observableArrayList();
        
        table.setEditable(true);
      if(!table.getColumns().isEmpty())
        table.getColumns().clear();
        String colName = null;
        for(int i=1;i<7;++i){
                    final int j=i;
                    if(i==1)
                        colName="Material";
                    else if(i==2)
                        colName="Item";
                    else if(i==3)
                        colName="Gross Weight";
                    else if(i==4)
                        colName="Purity";
                    else if(i==5)
                        colName="Value";
                    else if(i==6)
                        colName="Price Agreed";
                    TableColumn col=new TableColumn(colName);
                      //col.prefWidthProperty().bind(StoneTable.widthProperty().multiply(0.3));}
                    col.setMinWidth(15);
                    col.setEditable(true);
                    col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                        public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {                                                                                              
                            return new SimpleStringProperty(param.getValue().get(j-1).toString());                        
                        }                    
                    });
        
            table.getColumns().addAll(col);
        }
        
        renewdata = FXCollections.observableArrayList();
        renewtable.setEditable(true);
      if(!renewtable.getColumns().isEmpty())
        renewtable.getColumns().clear();
        for(int i=1;i<10;++i){
                    final int j=i;
                    if(i==1)
                        colName="InvoiceID";
                    else if(i==2)
                        colName="Loan Amount";
                    else if(i==3)
                        colName="Interest";
                    else if(i==4)
                        colName="Payable";
                    else if(i==5)
                        colName="Amount Paid";
                    else if(i==6)
                        colName="Interest cut";
                    else if(i==7)
                        colName="Principal cut";
                    else if(i==8)
                        colName="Balance Interest";
                    else if(i==9)
                        colName="Updated Principal";
                    TableColumn col=new TableColumn(colName);
                    col.setMinWidth(15);
                    col.setEditable(true);
                    col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                        public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {                                                                                              
                            return new SimpleStringProperty(param.getValue().get(j-1).toString());                        
                        }                    
                    });
        
            renewtable.getColumns().addAll(col);
        }
        
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
    private void clearDetails(ActionEvent event) {
    }

    @FXML
    private void fillTableWithItem(ActionEvent event) {
        table.setEditable(true);
        int add = Integer.parseInt((String)priceAgreed.getText());
        String PriceAgreed  = priceAgreed.getText();
        String materialname  = (String) material.getValue();
        String itemname  = (String) item.getValue();
        String grosswt  = grossWt.getText();
        String Purity  = purity.getText();
        String Value  = value.getText();
        ObservableList<String> instance = FXCollections.observableArrayList();
        instance.add(materialname);
        instance.add(itemname);
        instance.add(grosswt);
        instance.add(Purity);
        instance.add(Value);
        instance.add(PriceAgreed);
        data.add(instance);
        table.setItems(data);
        int Total = Integer.parseInt((String)total.getText());
        Total = Total + add;
        total.setText(Integer.toString(Total));
        girviSNo++;
        material.setValue(null);
        item.setValue(null);
        grossWt.setText(null);
        purity.setText(null);
        value.setText(null);
        priceAgreed.setText(null);
    }

    @FXML
    private void UploadImage(ActionEvent event) {
    }

    @FXML
    private void save(ActionEvent event) {
        String customer = custName.getText();
        LocalDate date = LocalDate.now();
        int totalamount = Integer.parseInt((String)total.getText());
        float InterestRate = Float.parseFloat(interestRate.getText());
        String description  = Description.getText();
        int interest = 0;
        int payable = totalamount;
        int principal = totalamount;
        LocalDate LastPaidDate = LocalDate.parse("0001-01-01");
        LocalDate LastInterestAddedDate = LocalDate.parse("0001-01-01");
        String paymentmode = (String) paymentMode.getValue();
        try {
            SqlLogin.executeUpdate(" Insert into invoice Values( NULL, '" + customer + "', '" + totalamount + "', '" + InterestRate + "', '" + date + "', '" + paymentmode + "', '" + description +  "', '" + interest +  "', '" + payable +  "', '" + LastPaidDate +  "', '" + principal +  "', '" + LastInterestAddedDate + "')");
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ObservableList<String> instance = FXCollections.observableArrayList();
        int invoiceid = 0;
        int PriceAgreed;
        String materialname;
        String itemname;
        float grosswt;
        float Purity;
        int Value;
        int i=0;
        try {
            SqlLogin.executeQueryTiles("select * from invoice order by id desc");
            invoiceid  = Integer.parseInt((String)SqlLogin.data.get(0).get(0));
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        while(i<girviSNo){
            System.out.println(table.getItems().get(i));
            instance = (ObservableList<String>) table.getItems().get(i);
            materialname = instance.get(0);
            itemname = instance.get(1);
            grosswt = Float.parseFloat((String)instance.get(2));
            Purity = Float.parseFloat((String)instance.get(3));
            Value = Integer.parseInt((String)instance.get(4));
            PriceAgreed = Integer.parseInt((String)instance.get(5));
            try {
                SqlLogin.executeUpdate("Insert into items values(NULL, '" + invoiceid + "', '" + materialname + "', '" + itemname + "', '" + grosswt + "', '" + Purity + "', '" + Value + "', '" + PriceAgreed + "', 'No')");       
            } catch (SQLException ex) {
                Logger.getLogger(InvoiceController.class.getName()).log(Level.SEVERE, null, ex);
            }
            i++;
       }
        table.setEditable(true);
        table.setItems(null);
        total.setText("0");
        paymentMode.setValue(null);
        interestRate.setText(null);
        Description.setText(null);
        custName.setText(null);
        data = FXCollections.observableArrayList();
        girviSNo=0;
        
                        Stage stage = new Stage();
                        Object root = null;
                        try {
                            root = FXMLLoader.load(getClass().getResource("OnInvoiceSave.fxml"));
                        } catch (IOException ex) {
                            Logger.getLogger(BankDetailsController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        stage.setScene(new Scene((Parent) root));
                        stage.initModality(Modality.APPLICATION_MODAL);
                        stage.initOwner(save.getScene().getWindow());
                        stage.showAndWait();
        
    }
    @FXML
    private void handlePrint(ActionEvent event) {
    }

    @FXML
    private void handleSalesOverView(MouseEvent event) {
    }

    @FXML
    private void handleSalesSoldItems(MouseEvent event) {
    }

    @FXML
    private void handleDelete(ActionEvent event) {
        int selectedIndex = table.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            table.getItems().remove(selectedIndex);
        }
        girviSNo--;
    }
    @FXML
    private void fillRenewTable(ActionEvent event) {
        int add = Integer.parseInt((String)AmtPaid.getText());
        renewtable.setEditable(true);
        String invoiceID  = InvoiceID.getText();
        String loanamount  = LoanAmt.getText();
        String interest  = Interest.getText();
        int interestint = Integer.parseInt((String)Interest.getText());
        String principal  = Principal.getText();
        int principalint = Integer.parseInt((String)Principal.getText());
        String payable  = AmountPayable.getText();
        String amountpaid  = AmtPaid.getText();
        int amountpaidint  = Integer.parseInt((String)AmtPaid.getText());
        int interestcutint;
        int principalcutint;
        int newinterestint;
        int newprincipalint;
        if(amountpaidint>interestint){
            interestcutint = interestint;
            newinterestint = 0;
            principalcutint = amountpaidint-interestint;
            newprincipalint = principalint-principalcutint;
        }
        else{
            interestcutint = amountpaidint;
            principalcutint = 0;
            newinterestint = interestint - interestcutint;
            newprincipalint = principalint;
        }
        String interestcut = Integer.toString(interestcutint);
        String principalcut = Integer.toString(principalcutint);
        String newinterest = Integer.toString(newinterestint);
        String newprincipal = Integer.toString(newprincipalint);
        ObservableList<String> instance = FXCollections.observableArrayList();
        instance.add(invoiceID);
        instance.add(loanamount);
        instance.add(interest);
        instance.add(payable);
        instance.add(amountpaid);
        instance.add(interestcut);
        instance.add(principalcut);
        instance.add(newinterest);
        instance.add(newprincipal);
        renewdata.add(instance);
        renewtable.setItems(renewdata);
        int Total = Integer.parseInt((String)renewtotal.getText());
        Total = Total + add;
        renewtotal.setText(Integer.toString(Total));
        AmtPaid.setText(null);
        renewSNo++;
    }

    @FXML
    private void renewsave(ActionEvent event) {
        int i=0;
        ObservableList<String> instance = FXCollections.observableArrayList();
        int invoiceid = 0;
        int amountpaid,interestcut,principalcut,newinterest,newprincipal;
        String paymentType = (String) renewpaymentMode.getValue();
        LocalDate date = LocalDate.now();
        while(i<renewSNo){
            System.out.println(renewtable.getItems().get(i));
            instance = (ObservableList<String>) renewtable.getItems().get(i);
            invoiceid = Integer.parseInt((String)instance.get(0));
            amountpaid = Integer.parseInt((String)instance.get(4));
            interestcut = Integer.parseInt((String)instance.get(5));
            principalcut = Integer.parseInt((String)instance.get(6));
            newinterest = Integer.parseInt((String)instance.get(7));
            newprincipal = Integer.parseInt((String)instance.get(8));
            try {
                SqlLogin.executeUpdate(" Insert into payments Values( NULL, '" + invoiceid + "', '" + amountpaid + "', '" + date + "', '" + paymentType + "', '" + interestcut +  "', '" + principalcut + "')");
            } catch (SQLException ex) {
                Logger.getLogger(InvoiceController.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                SqlLogin.executeUpdate(" update invoice set last_paid = '" + date + "', interest = '" + newinterest + "', principal = '" + newprincipal + "' where id = " + invoiceid );
                System.out.println(" update invoice set last_paid = '" + date + "', interest = '" + newinterest + "', principal = '" + newprincipal + "' where id = " + invoiceid );
            } catch (SQLException ex) {
                Logger.getLogger(InvoiceController.class.getName()).log(Level.SEVERE, null, ex);
            }
            i++;
       }
        
        UpdateInterest.Update();
        
                        InvoiceID.setText(null);
                        LoanAmt.setText(null);
                        Interest.setText(null);
                        AmountPayable.setText(null);
                        OrnamentTable.setEditable(true);
                        if(!OrnamentTable.getColumns().isEmpty())
                        OrnamentTable.getColumns().clear();
                        OrnamentTable.setItems(null);
                        renewtable.setEditable(true);
                        renewtable.setItems(null);
                        renewtotal.setText("0");
                        renewpaymentMode.setValue(null);
                        renewdata = FXCollections.observableArrayList();
    }

    @FXML
    private void handlerenewPrint(ActionEvent event) {
    }

    @FXML
    private void handleRenewDelete(ActionEvent event) {
        int selectedIndex = renewtable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            renewtable.getItems().remove(selectedIndex);
        }
        renewSNo--;
    }

    @FXML
    private void ShowImage(ActionEvent event) {
    }

    @FXML
    private void handleModifyClick(Event event) {
                        InvoiceID.setText(null);
                        LoanAmt.setText(null);
                        Interest.setText(null);
                        AmountPayable.setText(null);
                        OrnamentTable.setEditable(true);
                        if(!OrnamentTable.getColumns().isEmpty())
                        OrnamentTable.getColumns().clear();
                        OrnamentTable.setItems(null);
                        renewtable.setEditable(true);
                        renewtable.setItems(null);
                        renewtotal.setText("0");
                        renewpaymentMode.setValue(null);
                        renewdata = FXCollections.observableArrayList();
        String customer = custName.getText();
        try {
            SqlLogin.executeQueryTiles("select * from invoice where customer = '" + customer + "'");
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ModifyGirvi.setContent(null);
        VBox Tiles = new VBox();
        Tiles.setSpacing(10);
        for(int i=0;i<SqlLogin.data.size();++i){
                Pane pane = new Pane();
                pane.getStyleClass().add("Pane");
                Label invoiceID = new Label();
                invoiceID.setStyle("-fx-text-fill:black; -fx-font-size: 20px;");
                invoiceID.setPrefSize(260,20);
                invoiceID.setText(" " + (String)SqlLogin.data.get(i).get(4) + "   ID: " + (String)SqlLogin.data.get(i).get(0) );
                int ID = Integer.parseInt((String)SqlLogin.data.get(i).get(0));
                String id = (String)SqlLogin.data.get(i).get(0);
                String TotalAmount = (String)SqlLogin.data.get(i).get(2);
                String TotalInterest = (String)SqlLogin.data.get(i).get(7);
                String amountpayable = (String)SqlLogin.data.get(i).get(8);
                String principal = (String)SqlLogin.data.get(i).get(10);
                pane.setOnMouseClicked(new EventHandler<MouseEvent>(){
                    @Override
                    public void handle(MouseEvent event) {
                        InvoiceID.setText(id);
                        LoanAmt.setText(TotalAmount);
                        Interest.setText(TotalInterest);
                        AmountPayable.setText(amountpayable);
                        Principal.setText(principal);
                        OrnamentTable.setEditable(true);
      
                    if(!OrnamentTable.getColumns().isEmpty())
                        OrnamentTable.getColumns().clear();
                    try {
                        SqlLogin.executeQuery("select material,item,grosswt,purity from items where invoiceid = " + ID,OrnamentTable);
                    } catch (SQLException ex) {
                        Logger.getLogger(InvoiceController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                        OrnamentTable.setItems(SqlLogin.data);
                    }
                });
                pane.getChildren().add(invoiceID);
                Tiles.getChildren().add(pane);
        }
        ModifyGirvi.setContent(Tiles);
    }
    
}
