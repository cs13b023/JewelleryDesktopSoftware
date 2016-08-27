/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sales;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PauseTransition;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;
import org.jsoup.Jsoup;
import java.lang.NullPointerException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Objects;
import javafx.scene.control.TableCell;
import javafx.stage.Modality;
/**
 * FXML Controller class
 *
 * @author vinay
 */
public class InvoiceFinalController implements Initializable {

    @FXML
    private TextField custName;
    @FXML
    private TextField address1;
    @FXML
    private TextField address2;
    @FXML
    private TextField Pin;
    @FXML
    private TextField phoneNo;
    @FXML
    private TextField PanNo;
    @FXML
    private TextField relationWith;
    @FXML
    private TextField barCode;
    @FXML
    private TextField stoneWt;
    @FXML
    private TextField grossWt;
    @FXML
    private TextField netWt;
    @FXML
    private TextField purity;
    
    @FXML
    private ComboBox relation;
    @FXML
    private VBox suggestion;

    @FXML
    private Button uploadImage;
    @FXML
    private ImageView itemImage;
    
    @FXML
    private TextField SalesOverView;
    @FXML
    private TextField SalesInvoice;
    @FXML
    private TextField SalesSoldItems;
    @FXML
    private Pane InvMainPane;

    @FXML
    private TextField InvCusID;
    @FXML
    private Button InvAddCustomer;
    @FXML
    private DatePicker InvDate;
    @FXML
    private TextField InvTotal;
    @FXML
    private Button InvCancel;
    @FXML
    private Button InvConfirm;
    @FXML
    private Button DelSelectedItem;
    @FXML
    private Button InvoiceAddItem;
    @FXML
    private Label GoldRate;
    @FXML
    private Label SilverRate;
    
    @FXML
    private TextField type;
    @FXML
    private TextField design;
    @FXML
    private ComboBox material;
    @FXML
    private ComboBox stoneType;
    
    @FXML
    private Label total;
    
    @FXML
    private TableView table;
    
    @FXML
    protected void UploadImage(ActionEvent event){
        FileChooser fc = new FileChooser();
        File selectedFile  = fc.showOpenDialog(null);
        fc.setTitle("Choose Item Image");
       
        fc.setInitialDirectory(new File(System.getProperty("user.dir")));
        
       if(selectedFile!=null){
           String dir=selectedFile.getPath();
           File f=new File(dir);
           try{;
            Image image=new Image(f.toURI().toString());
            itemImage.setDisable(false);
            uploadImage.setVisible(false);
            itemImage.setImage(image);
            setImagePosition();
            
           }
           catch(Exception e){
               e.printStackTrace();
           }
           
           
       }else{
           
       }
    }
    
    @FXML
    private ComboBox payment;
    
    @FXML
    private Button print;
    
    @FXML
    protected void handlePrint(ActionEvent event) throws IOException{
        String paymentMode=payment.getValue().toString();
        switch (paymentMode) {
            case "Cash":
                {
                    Parent home_page_parent = FXMLLoader.load(getClass().getResource("Home.fxml"));
                    System.out.println(getClass().getResource(""));
                    Scene home_page_scene = new Scene(home_page_parent);
                    Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    // app_stage.hide();
                    app_stage.setScene(home_page_scene);
                    app_stage.show();
                    break;
                }
            case "Cheque":
                {
                    /*Parent home_page_parent = FXMLLoader.load(getClass().getResource("/SalesAndInventory/ChequePaymentPopUp.fxml"));
                    Scene home_page_scene = new Scene(home_page_parent);
                    Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    // app_stage.hide();
                    app_stage.setScene(home_page_scene);
                    app_stage.();*/
                    
              /*  Stage stage = new Stage();
                Object root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("CheckPaymentPopUp.fxml"));
                    
                } catch (IOException ex) {
                    Logger.getLogger(employee.FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
                stage.setScene(new Scene((Parent) root));
                stage.setTitle("Cheque Payment");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.initOwner(payment.getScene().getWindow());
                stage.showAndWait();
                ChequePayment chequePayment=PaymentDetails.getPayment().getCheque();
                Float newTotal=Float.parseFloat(total.getText())-chequePayment.amount;
                total.setText(newTotal.toString());
                    break;*/
                }
            case "Gold":
                {
                   /* Parent home_page_parent = FXMLLoader.load(getClass().getResource("/SalesAndInventory/GoldPaymentPopUp.fxml"));
                    Scene home_page_scene = new Scene(home_page_parent);
                    Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    // app_stage.hide();
                    app_stage.setScene(home_page_scene);
                    app_stage.show();
                */
                    
                    
                    
              /*  Stage stage = new Stage();
                Object root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("GoldPaymentPopUp.fxml"));
                    
                } catch (IOException ex) {
                    Logger.getLogger(employee.FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
                stage.setScene(new Scene((Parent) root));
                stage.setTitle("Gold Payment");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.initOwner(payment.getScene().getWindow());
                stage.showAndWait();
                GoldPayment goldPayment=PaymentDetails.getPayment().getGold();
                Float newTotal=Float.parseFloat(total.getText())-goldPayment.agreedPrice;
                total.setText(newTotal.toString());
                    break;*/
                }
            default:
                break;
        }
    }
    
    HashMap <String,Integer>stoneTypeDrop ;
    private void fillStoneTypeDrop(ObservableList<ObservableList> data) {
        stoneTypeDrop=new HashMap<>();
        stoneType.getItems().clear();
        int index=0;
        for(int i=0;i<data.size();++i){
                stoneTypeDrop.putIfAbsent( (String) data.get(i).get(0), index);
                stoneType.getItems().add((String) data.get(i).get(0));
                
                index++;
            
        }
    }
    HashMap <String,Integer>materialTypeDrop ;
    private void fillMaterialDrop(ObservableList<ObservableList> data) {
        materialTypeDrop=new HashMap<>();
        material.getItems().clear();
        int index=0;
        for(int i=0;i<data.size();++i){
            materialTypeDrop.putIfAbsent((String) data.get(i).get(0),index);
            material.getItems().add((String) data.get(i).get(0));
            index++;
        }
    }
    public void fillItemDetails(ObservableList<ObservableList> data){
                grossWt.setText((String) data.get(0).get(9));
                netWt.setText((String) data.get(0).get(8));
                purity.setText((String) data.get(0).get(7));
                type.setText((String) data.get(0).get(4));
                design.setText((String) data.get(0).get(6));
                material.setValue(material.getItems().get(materialTypeDrop.get(data.get(0).get(5))));
                
                File imageDir=new File(data.get(0).get(12).toString());
                try{;
                    Image image=new Image(imageDir.toURI().toString());
                    itemImage.setDisable(false);
                    itemImage.setImage(image);
                    setImagePosition();
                    
            
                    }
                catch(Exception e){
                    e.printStackTrace();
                }
                
            
    }
    @FXML
    private Button add;
    @FXML
    protected void fillTableWithItem() {
        try{
            ObservableList<String> row=FXCollections.observableArrayList();
            Integer slNo=billData.size()+1;
            String name=material.getValue().toString()+" "+type.getText();
            Float price=Float.parseFloat(purity.getText())*Float.parseFloat(grossWt.getText())*0.01f;
            String rate=material.getValue().toString().toUpperCase()+"_RATE";    
            try {
            
            SqlLogin.executeQuery("select "+rate+" from RATES", null);
            } catch (SQLException ex) {
                Logger.getLogger(Invoice1Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            price=price*Float.parseFloat(SqlLogin.data.get(0).get(SqlLogin.data.size()-1).toString());
            row.addAll(slNo.toString(),name,grossWt.getText(),price.toString(),"x");
            Float newTotal=Float.parseFloat(total.getText())+price;
            total.setText(newTotal.toString());
            
            billData.add(row);
            
            //System.out.println(billData);
            try {
            
            SqlLogin.executeQuery("select StoneType,StoneWt,StonePrice from StoneTable,ItemStoneTable where ItemStoneTable.stoneID=StoneTable.StoneID and itemID="+barCode.getText(), null);
            for(int i=0;i<SqlLogin.data.size();++i){
                    ObservableList<String> stoneRow=FXCollections.observableArrayList();
            
                    stoneRow.add("-");
                    for(int j=0;j<SqlLogin.data.get(0).size();++j){
                        stoneRow.add(SqlLogin.data.get(i).get(j).toString());
                    }
                    stoneRow.add("x");
                    newTotal=Float.parseFloat(total.getText())+Float.parseFloat(stoneRow.get(3));
                    total.setText(newTotal.toString());
                    billData.add(stoneRow);

            }
            } catch (SQLException ex) {
                Logger.getLogger(Invoice1Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
                
            table.setItems(billData);
            clearDetailsFromBarCode();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    @FXML
    private Button  addStone;
    @FXML
    protected void fillTableWithStone(){
        ObservableList<String> row=FXCollections.observableArrayList();
        
        try {
            
            SqlLogin.executeQuery("select StonePrice from StoneTable where StoneType='"+stoneType.getValue().toString()+"' and StoneWt="+stoneWt.getText(), null);            
            row.add("-");
            row.add(stoneType.getValue().toString());
            row.add(stoneWt.getText());
            row.add(SqlLogin.data.get(0).get(0).toString());
            Float newTotal=Float.parseFloat(total.getText())+Float.parseFloat(SqlLogin.data.get(0).get(0).toString());
            total.setText(newTotal.toString());
            row.add("x");
            billData.add(row);
            table.setItems(billData);
            } catch (SQLException ex) {
                Logger.getLogger(Invoice1Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
    }
    @FXML
    private Button clear;
    @FXML
    protected void clearDetailsFromBarCode(){
        barCode.clear();
        grossWt.clear();
        netWt.clear();
        purity.clear();
        type.clear();
        design.clear();
        material.setValue("");
        itemImage.setImage(null);
        itemImage.setDisable(true);
        uploadImage.setVisible(true);
        barCode.setDisable(false);
    }
    
    CustomerTable custTable=CustomerTable.getList();
    ObservableList<ObservableList> billData;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        billData=FXCollections.observableArrayList();
        total.setText("0.00");
        String Name,address,city,phone,pan,pinNo,related,relatedTo;
        Integer id;
        itemImage.setDisable(true);
        try {
            
            SqlLogin.executeQuery("select * from CustomerTable", null);
        } catch (SQLException ex) {
            Logger.getLogger(Invoice1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int i=0;i<SqlLogin.data.size();++i){
            
            Name=((String) SqlLogin.data.get(i).get(0));
                       
            address=((String) SqlLogin.data.get(i).get(1));
                       
            city=(String) SqlLogin.data.get(i).get(2);
                                      
            pinNo=((String) SqlLogin.data.get(i).get(3));
                                    
            related=((String) SqlLogin.data.get(i).get(4));
            
            relatedTo=((String) SqlLogin.data.get(i).get(5));
            
            phone=((String) SqlLogin.data.get(i).get(6));
            
            pan=((String) SqlLogin.data.get(i).get(7));
            
            id=(Integer.parseInt((String) SqlLogin.data.get(i).get(8)));
                
            Customer c=new Customer(Name, address, city, pinNo, related, relatedTo, phone, pan, id);

            CustomerTable.addCustomer(c);
            
            //System.out.println(CustomerTable.getCustomer(id));
        }

        suggestion.setVisible(false);
        suggestion.setStyle("-fx-background-color:white;");
        suggestion.setSpacing(2);
        relation.getItems().clear();
        relation.getItems().addAll("S/o","F/o","W/o","M/o","D/o");
        payment.getItems().addAll("Cash","Cheque","Gold");
        payment.setValue("Cash");
        try {
            
            SqlLogin.executeQuery("select MATERIAL from INVENTORY", null);
        } catch (SQLException ex) {
            Logger.getLogger(Invoice1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        fillMaterialDrop(SqlLogin.data);
        
        try {
            
            SqlLogin.executeQuery("select StoneType from StoneTable", null);
        } catch (SQLException ex) {
            Logger.getLogger(Invoice1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        fillStoneTypeDrop(SqlLogin.data);
        
        
        custName.addEventHandler(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent event) {
                String typed=custName.getText();
                if(typed.length()==0)
                {
                                custName.clear();
                                address1.clear();
                                address2.clear();
                                Pin.clear();
                                phoneNo.clear();
                                PanNo.clear();
                                relationWith.clear();
                                relation.setValue(" ");
                                
                    suggestion.getChildren().clear();
                    suggestion.setVisible(false);
                    return;
                }
                suggestion.getChildren().clear();
                ArrayList<Customer> searchList=CustomerTable.searchCustomer(typed);
                for(int i=0;i<searchList.size();++i){
                    HBox entry=new HBox();
                    entry.setSpacing(5);
                    Label name=new Label(searchList.get(i).getCustName());
                    Label phone=new Label(searchList.get(i).getPhoneNo());
                    
                    name.setId(searchList.get(i).getId().toString());
                    entry.getChildren().addAll(name,phone);
                    entry.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>(){
                        @Override
                        public void handle(MouseEvent event) {
                            entry.setStyle("-fx-background-color:blue;");
                        }
                        
                    });
                    entry.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>(){
                        @Override
                        public void handle(MouseEvent event) {
                            entry.setStyle("-fx-background-color:white;");
                        }
                        
                    });
                    entry.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
                        @Override
                        public void handle(MouseEvent event) {
                            Integer id=Integer.parseInt(name.getId());
                            try{
                                Customer c=CustomerTable.getCustomer(id);
                                
                                custName.setText(c.getCustName());
                                address1.setText(c.getAddress());
                                address2.setText(c.getCity());
                                Pin.setText(c.getPin());
                                phoneNo.setText(c.getPhoneNo());
                                PanNo.setText(c.getPanNo());
                                relationWith.setText(c.getRelatedTo());
                                String rel=c.getRelation();
                                if(rel.charAt(0)=='S' || rel.charAt(0)=='S')
                                    relation.setValue(relation.getItems().get(0));
                                else if(rel.charAt(0)=='F' || rel.charAt(0)=='f')
                                    relation.setValue(relation.getItems().get(1));
                                else if(rel.charAt(0)=='W' || rel.charAt(0)=='2')
                                    relation.setValue(relation.getItems().get(2));
                                else if(rel.charAt(0)=='M' || rel.charAt(0)=='m')
                                    relation.setValue(relation.getItems().get(3));
                                else if(rel.charAt(0)=='D' || rel.charAt(0)=='S')
                                    relation.setValue(relation.getItems().get(4));
                                
                            }
                            catch(Exception e){
                                e.printStackTrace();
                            }
                            suggestion.setVisible(false);
                            suggestion.getChildren().clear();
                        }
                        
                    });
                    suggestion.getChildren().add(entry);
                    
                }
                suggestion.setMaxHeight(suggestion.getChildren().size()*10);
                suggestion.setVisible(true);
                
                
            }
            
        });
        itemImage.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                    uploadImage.setVisible(true);
                
            }
            
        });
        itemImage.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                    if(!itemImage.isDisable())
                        uploadImage.setVisible(false);
                
            }
            
        });
        uploadImage.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                if(!itemImage.isDisable())
                    uploadImage.setVisible(true);
            }
            
        });
        
        barCode.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode().equals(KeyCode.ENTER)){
                    try {
                        SqlLogin.executeQuery("select * from INVENTORY where BARCODE="+barCode.getText()+";", null);
                    } catch (SQLException ex) {
                        Logger.getLogger(Invoice1Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    fillItemDetails(SqlLogin.data);
                    barCode.setDisable(true);
                    uploadImage.setVisible(false);
                }                
            }

        });
        String colName=null;
        for(int i=0;i<5;++i){
            final int j=i;
            if(i==0)
                colName="Sl.No";
            else if(i==1)
                colName="Name";
            else if(i==2)
                colName="Wt";
            else if(i==3)
                colName="Price";
            else
                colName="X";
            
            TableColumn col=new TableColumn(colName);
            if(i==0)
                col.setMaxWidth(50);
            else if(i==1)
                col.setMinWidth(120);
            col.setEditable(true);
            col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                @Override
                public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {                                                                                              
                    return new SimpleStringProperty(param.getValue().get(j).toString());                        
                }                    
            });
            if(i==4){
                col.setMaxWidth(50);
                col.setCellFactory(new Callback<TableColumn<ObservableList,String>,TableCell<ObservableList,String>>(){
                           @Override
                           public TableCell<ObservableList, String> call(TableColumn<ObservableList, String> param) {
                               final TableCell<ObservableList,String> cell=new TableCell<>();
                              
                               cell.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
                                   @Override
                                   public void handle(MouseEvent event) {
                                       
                                       try{
                                            ObservableList row = cell.getTableView().getItems().get(cell.getIndex());
                                            //ObservableList<ObservableList> fullItem=FXCollections.observableArrayList();
                                            Float indCost = null,cost;
                                            Integer start=cell.getIndex(),end=cell.getIndex();
                                            if(row.get(0).toString().equals("-")){
                                                indCost=Float.parseFloat((String) row.get(3));
                                                
                                            }
                                            else
                                            {
                                                indCost=Float.parseFloat((String) row.get(3));
                                                end++;
                                                try{
                                                    row=cell.getTableView().getItems().get(end.intValue());
                                                    while(row.get(0).toString().equals("-")){
                                                        end++;
                                                        indCost+=Float.parseFloat((String) row.get(3));
                                                        if(end==cell.getTableView().getItems().size()){
                                                            break;
                                                        }
                                                        row=cell.getTableView().getItems().get(end.intValue());
                                                    }
                                                }
                                                catch(Exception e){
                                                    System.out.println(e);
                                                }
                                                
                                            }

                                                if(Objects.equals(start, end)){
                                                    cell.getTableView().getItems().remove(start.intValue());
                                                    cost=Float.parseFloat(total.getText())-indCost;
                                                    total.setText(cost.toString());
                                                }
                                                else{
                                                    cell.getTableView().getItems().remove(start.intValue(),end.intValue());
                                                    cost=Float.parseFloat(total.getText())-indCost;
                                                    total.setText(cost.toString());
                                                    
                                                }
                                                
                                       }                                                                                   
                                       catch(Exception e){
                                           System.out.println(e);
                                       }
                                    }
                                   
                               });
                               
                               cell.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>(){
                                   @Override
                                   public void handle(MouseEvent event) {
                                       try{
                                        if(!cell.getTableView().getItems().get(cell.getIndex()).isEmpty())
                                             cell.setText("x");
                                        else
                                            cell.setText("-");
                                   
                                       }
                                       catch(Exception e){
                                           System.out.println(e);
                                       }
                                    }
                                   
                               });
                               cell.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>(){
                                   @Override
                                   public void handle(MouseEvent event) {
                                       cell.setText("");
                                   }
                                   
                               });
                               return cell;
                           }
                           
                           
                       });
                
            }
            
            table.getColumns().add(col);
            
        }
      
        
 
    }    

    private void setImagePosition(){
        itemImage.setFitHeight(150);
        itemImage.setFitWidth(200);
        itemImage.setLayoutX(50);
        itemImage.setLayoutX(75);
    }
    

    @FXML
    private void handleHome(MouseEvent event) throws IOException {
         Parent home_page_parent = FXMLLoader.load(getClass().getResource("/mastersoftware/Home.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       // app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    private void handleSalesOverView(MouseEvent event) {
    }

    @FXML
    private void handleSalesSoldItems(MouseEvent event) {
    }

    @FXML
    private void handleInvAddCustomer(ActionEvent event) {
    }

    @FXML
    private void handleInvCancel(ActionEvent event) {
    }

    @FXML
    private void handleInvConfirm(ActionEvent event) {
    }

    @FXML
    private void handleDeleteSelectedItem(ActionEvent event) {
    }

    @FXML
    private void handleInvoiceAddItem(ActionEvent event) {
    }

    
    
}
