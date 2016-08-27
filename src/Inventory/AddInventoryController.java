/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
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
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBoxBuilder;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;
import org.jsoup.Jsoup;
/**
 * FXML Controller class
 *
 * @author vinay kumar reddy
 */
public class AddInventoryController implements Initializable {

    @FXML
    private TextField Home;
    @FXML
    private TextField InvOverView;
    
    @FXML
    private TextField InvDetails;
    @FXML
    private TextField InvWholeSaler;
    @FXML
    private TextField InvWholeSaler1;
    @FXML
    private ComboBox FamilyCombo;
    @FXML
    private TextField FamilyName;
    @FXML
    private TextField MobileNo;
    @FXML
    private TextField PanNo;
    @FXML
    private TextField PinCode;
    @FXML
    private TextField Address2;
    @FXML
    private TextField Address1;
    @FXML
    private TextField WSName;
    @FXML
    private TextField SubItem;
    @FXML
    private TableView StoneTable;
    @FXML
    private TextField BuyingPrice;
    @FXML
    private TextField Purity;
    @FXML
    private ComboBox StoneCombo;
    @FXML
    private ComboBox StoneClassCombo;
    @FXML
    private TextField Clarity;
    @FXML
    private TextField Pieces;
    @FXML
    private TextField StoneRate;
    @FXML
    private Button AddStone;
    @FXML
    private ComboBox HallMarkCombo;
    @FXML
    private TextField SellingPrice;
    @FXML
    private ComboBox Purity1Combo;
    @FXML
    private ComboBox Purity2Combo;
    @FXML
    private ComboBox CWPCombo;
    @FXML
    private Button UploadImage;
    @FXML
    private ComboBox MaterialCombo;
    @FXML
    private ComboBox TypeCombo;
    @FXML
    private ComboBox DesignNameCombo;
    @FXML
    private TextField GrossWeight;
    @FXML
    private TextField StoneWeight;
    @FXML
    private TextField MakingCharges;
    @FXML
    private TextField Quantity;
    @FXML
    private TextField singlemetalweight;
    @FXML
    private TextField SingleOrnamentPrice;
    @FXML
    private TableView OrnamentTable;
    @FXML
    private Button AddOrnament;
    @FXML
    private Button AddSimilar;
    @FXML
    private TextField TotalTypes;
    @FXML
    private TextField TotalItems;
    @FXML
    private TextField TotalDue;
    @FXML
    private TextField PreviousBalance;
    @FXML
    private Button SaveInventory;
    @FXML
    private Button AddMaterial;
    @FXML
    private Button AddNewType;
    @FXML
    private Button AddNewDesignName;
    @FXML
    private TextField Cut;
    @FXML
    private Label TotalStonePrice;
     @FXML
    private TextField CompleteStoneWeight;
     @FXML
    private TextField TotalPrice;
      @FXML
    private VBox suggestion;
    ObservableList<ObservableList>  Stonetabledata;
    ObservableList<ObservableList>  Ornamenttabledata;
    ObservableList<ObservableList>   Suggestiondata;
   int k=1,l=1;
    
   
   
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Group root = new Group();
         
       // Button buttonLoad = new Button("Load");
        UploadImage.setOnAction(new EventHandler<ActionEvent>(){
             @Override
            public void handle(ActionEvent arg0) {
                FileChooser fileChooser = new FileChooser();
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
                fileChooser.getExtensionFilters().add(extFilter);
               // File file = fileChooser.showOpenDialog(primaryStage);
               // System.out.println(file);
            }
        });
        VBox vBox = VBoxBuilder.create()
                .children(UploadImage)
                .build();
        root.getChildren().add(vBox);
       // primaryStage.setScene(new Scene(root, 500, 400));
        //primaryStage.show();
        
        
        
        
        
        
        WSName.addEventHandler(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent event) {
                String typed=WSName.getText();
                if(typed.length()==0)
                {
                                WSName.clear();
                                Address1.clear();
                                Address2.clear();
                                PinCode.clear();
                                MobileNo.clear();
                                PanNo.clear();
                                FamilyCombo.setValue(null);
                                FamilyName.clear();
                                //relationWith.clear();
                                
                    suggestion.getChildren().clear();
                    suggestion.setVisible(false);
                    return;
                }
                suggestion.getChildren().clear();
                try {
                    SqlLogin.executeNewContent("select * from WHOLESALER WHERE NAME LIKE '%"+typed+"%' ");
                } catch (SQLException ex) {
                    Logger.getLogger(AddInventoryController.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println(SqlLogin.data);
                Suggestiondata=SqlLogin.data;
                //ArrayList<Customer> searchList=CustomerTable.searchCustomer(typed);
                for(int i=0;i<SqlLogin.data.size();++i){
                    HBox entry=new HBox();
                    Label name=new Label((String)SqlLogin.data.get(i).get(1));
                   // Label phone=new Label(SqlLogin.data.get(i).getPhoneNo());
                   // name.setId(searchList.get(i).getId().toString());
                    entry.getChildren().addAll(name);
                    name.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>(){
                        @Override
                        public void handle(MouseEvent event) {
                            name.setStyle("-fx-background-color:blue");
                        }
                        
                    });
                    name.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>(){
                        @Override
                        public void handle(MouseEvent event) {
                            name.setStyle("-fx-background-color:white");
                        }
                        
                    });
                    name.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
                        @Override
                        public void handle(MouseEvent event) {
                            //Integer id=Integer.parseInt(name.getId());
                            try{
                                System.out.println("working");
                                WSName.setText((String)Suggestiondata.get(0).get(1));
                                 Address1.setText((String)Suggestiondata.get(0).get(2));
                                  MobileNo.setText((String)Suggestiondata.get(0).get(3));
                                /*Customer c=CustomerTable.getCustomer(id);
                                custName.setText(c.getCustName());
                                address1.setText(c.getAddress());
                                address2.setText(c.getCity());
                                Pin.setText(c.getPin());
                                phoneNo.setText(c.getPhoneNo());
                                PanNo.setText(c.getPanNo());
                                relationWith.setText(c.getRelatedTo());
                                relation.getEditor().setText(c.getRelation());
                                relation.setValue(c.getRelatedTo());*/
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
                suggestion.setVisible(true);
                
                
            }
            
        });
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        // TODO
        Stonetabledata=FXCollections.observableArrayList();
        Ornamenttabledata=FXCollections.observableArrayList();
         ObservableList<String> typedata1 = FXCollections.observableArrayList();
            ObservableList<String> typedata2 = FXCollections.observableArrayList();
            ObservableList<String> typedata3 = FXCollections.observableArrayList();
            ObservableList<String> typedata4 = FXCollections.observableArrayList();
           StoneCombo.getItems().clear();
           StoneClassCombo.getItems().clear();
        try {
            SqlLogin.executeContent("Select  NAME from STONE_NAMES ",typedata3);
        } catch (SQLException ex) {
            Logger.getLogger(AddInventoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
         StoneCombo.getItems().addAll(typedata3);
         typedata3.clear();
          StoneCombo.getSelectionModel().selectedItemProperty().addListener(new  
      ChangeListener<String>() 
      {
      public void changed(ObservableValue<? extends String> observable,String  
      oldValue,String newValue) 
      {
          System.out.println("Value is::"+newValue);
          //tryclass.setvalue(newValue);
          //StoneClassCombo.setValue(null);
           StoneClassCombo.getItems().clear();
          try {
              SqlLogin.executeContent("Select DISTINCT CLASS from STONE_CLASS where NAME='"+newValue+"' ",typedata4);
          } catch (SQLException ex) {
              Logger.getLogger(AddInventoryController.class.getName()).log(Level.SEVERE, null, ex);
          }
          StoneClassCombo.getItems().addAll(typedata4);
          typedata4.clear();
      }   
      });
          FamilyCombo.getItems().clear();
         FamilyCombo.getItems().addAll("S/O","W/O","D/O");
         CWPCombo.getItems().clear();
         CWPCombo.getItems().addAll("C","W","P");
         HallMarkCombo.getItems().clear();
         HallMarkCombo.getItems().addAll("Present","NotPresent");
         
            
          TypeCombo.getItems().clear();
          MaterialCombo.getItems().clear();
          DesignNameCombo.getItems().clear();
        try {
            SqlLogin.executeContent("Select  MATERIAL from INV_MAT ",typedata1);
        } catch (SQLException ex) {
            Logger.getLogger(AddInventoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        MaterialCombo.getItems().addAll(typedata1);
         typedata1.clear();
       // MaterialCombo.getItems().addAll("AddNewMaterial");
        MaterialCombo.getSelectionModel().selectedItemProperty().addListener(new  
      ChangeListener<String>() 
      {
      public void changed(ObservableValue<? extends String> observable,String  
      oldValue,String newValue) 
      {
          System.out.println("Value is::"+newValue);
          tryclass.setvalue(newValue);
          TypeCombo.setValue(null);
      }   
      });
       
       
        try {
            SqlLogin.executeContent("Select DISTINCT TYPE from INV_TYPE ",typedata2);
        } catch (SQLException ex) {
            Logger.getLogger(AddInventoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
          //Type.getItems().addAll("Necklace","Ring","Bangle","Chain","Mixed","Other");
          TypeCombo.getItems().addAll(typedata2);
          typedata2.clear();
          
      TypeCombo.getSelectionModel().selectedItemProperty().addListener(new  
      ChangeListener<String>() 
      {
      public void changed(ObservableValue<? extends String> observable,String  
      oldValue,String newValue) 
      {
         String testmat=tryclass.getvalue();
         // String testmat=(String)MaterialCombo.getValue();
           DesignNameCombo.getItems().clear();
          System.out.println("type is::"+newValue);
           System.out.println("mat is::"+testmat);
          ObservableList<String>  data1=FXCollections.observableArrayList();
          try {
              SqlLogin.executeContent("Select DISTINCT DESIGN_NAME from INV_STATISTICS where MATERIAL='"+testmat+"' and TYPE='"+newValue+"'",data1);
          } catch (SQLException ex) {
              Logger.getLogger(AddInventoryController.class.getName()).log(Level.SEVERE, null, ex);
          }
              DesignNameCombo.getItems().addAll(data1);
               //DesignNameCombo.getItems().addAll("AddOtherDesign");


              data1.clear();
          
             // DesignName.getItems().clear();
      }   
      });
     StoneTable.setEditable(true);
      if(!StoneTable.getColumns().isEmpty())
        StoneTable.getColumns().clear();
      String colName = null;
        for(int i=0;i<11;++i){
                    final int j=i;
                    if(i==0)
                   colName="S.NO";
                  
                    else if(i==1)
                        colName="STONE";
                    else if(i==2)
                        colName="CLASS";
                    else if(i==3)
                        colName="CLARITY";
                    else if(i==4)
                        colName="CUT";
                    else if(i==5)
                        colName="Weight/STONE";
                    else if(i==6)
                        colName="C/W/P";
                    else if(i==7)
                        colName="RATE/STONE";
                    else if(i==8)
                        colName="PIECES";
                    else if(i==9)
                        colName="TOTALWEIGHT";
                     else if(i==10)
                     {
                        colName="NETRATE";
                        //colName.setWidth(10);
                     }
                    TableColumn col=new TableColumn(colName);
                      //col.prefWidthProperty().bind(StoneTable.widthProperty().multiply(0.3));}
                    col.setMinWidth(15);
                    col.setEditable(true);
                    col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                        public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {                                                                                              
                            return new SimpleStringProperty(param.getValue().get(j).toString());                        
                        }                    
                    });
        
      StoneTable.getColumns().addAll(col);

    }
       OrnamentTable.setEditable(true);
      if(!OrnamentTable.getColumns().isEmpty())
        OrnamentTable.getColumns().clear();
      String colName1 = null;
        for(int i=0;i<15;++i){
                    final int j=i;
                    if(i==0)
                        colName1="S.NO";
                    else if(i==1)
                        colName1="MATERIAL";
                    else if(i==2)
                        colName1="TYPE";
                    else if(i==3)
                        colName1="DESIGN_NAME";
                    else if(i==4)
                        colName1="HALLMARK";
                    else if(i==5)
                        colName1="PURITY";
                    else if(i==6)
                        colName1="GROSSWEIGHT";
                    else if(i==7)
                        colName1="STONEWEIGHT";
                    else if(i==8)
                        colName1="NETWEIGHT";
                    else if(i==9)
                        colName1="MAKING_CHARGES";
                    else if(i==10)
                        colName1="METAL_PRICE";
                    else if(i==11)
                        colName1="STONE_PRICE";
                     else if(i==12)
                        colName1="NET_PRICE";
                      
                    else if(i==13)
                        colName1="QUANTITY";
                    else if(i==14)
                        colName1="NET_AMOUNT";
                    
                    TableColumn col=new TableColumn(colName1);
                    col.setMinWidth(15);
                    col.setEditable(true);
                    col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                        public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {                                                                                              
                            return new SimpleStringProperty(param.getValue().get(j).toString());                        
                        }                    
                    });
        
      OrnamentTable.getColumns().addAll(col);

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
    private void handleInvDetails(MouseEvent event) throws IOException {
         Parent home_page_parent = FXMLLoader.load(getClass().getResource("InventoryDetails.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       // app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    private void handleInvWholeSaler(MouseEvent event) throws IOException {
         Parent home_page_parent = FXMLLoader.load(getClass().getResource("InventoryWholeSaler.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       // app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }


    @FXML
    private void handleSaveInventory(ActionEvent event) {
    }

    @FXML
    private void handleAddMaterial(ActionEvent event) throws IOException {
         Stage stage = new Stage();
                Object root = null;
                 root = FXMLLoader.load(getClass().getResource("InventoryMaterialPopup.fxml"));
                stage.setScene(new Scene((Parent) root));
                stage.setTitle("My modal window");
                stage.initModality(Modality.APPLICATION_MODAL);
               stage.initOwner(AddNewType.getScene().getWindow());
                stage.showAndWait();
                
               // TypeCombo.getItems().clear();
               // String temp1=tryclass.getvalue();
               // TypeCombo.setValue(temp1);
                MaterialCombo.getItems().addAll(tryclass.getvalue());
    }

    @FXML
    private void handleAddNewType(ActionEvent event) throws IOException {
         Stage stage = new Stage();
                Object root = null;
                root = FXMLLoader.load(getClass().getResource("InventoryTypePopup.fxml"));
                stage.setScene(new Scene((Parent) root));
                stage.setTitle("My modal window");
                stage.initModality(Modality.APPLICATION_MODAL);
               stage.initOwner(AddNewType.getScene().getWindow());
                stage.showAndWait();
                
               // TypeCombo.getItems().clear();
               // String temp1=tryclass.getvalue();
               // TypeCombo.setValue(temp1);
                TypeCombo.getItems().addAll(tryclass.getvalue());
                
      
    }

    @FXML
    private void handleAddNewDesignName(ActionEvent event) throws IOException {
        Stage stage = new Stage();
                Object root = null;
                root = FXMLLoader.load(getClass().getResource("InventoryDesignPopup.fxml"));
                stage.setScene(new Scene((Parent) root));
                stage.setTitle("My modal window");
                stage.initModality(Modality.APPLICATION_MODAL);
               stage.initOwner(AddNewDesignName.getScene().getWindow());
                stage.showAndWait();
                DesignNameCombo.getItems().addAll(tryclass.getvalue());
    }

    @FXML
    private void handleaddstone(ActionEvent event) {
        
         String stonename=(String) StoneCombo.getValue();
        
        String stoneclassname=(String) StoneClassCombo.getValue();
       
        LocalDate today = LocalDate.now();
        System.out.println(today);
        
   ObservableList<String> row= FXCollections.observableArrayList();
  
   row.add(Integer.toString(k));
   k++;
    row.add(stonename);
    row.add(stoneclassname);
     row.add(Clarity.getText()); 
     row.add(Cut.getText());
     
      //System.out.println(StoneWeight.getText());
      String stweight=StoneWeight.getText();
      float swperstone=Float.parseFloat(stweight );
      row.add(stweight);
      row.add((String) CWPCombo.getValue());
      String sw1=StoneRate.getText();
      float swvalue=Float.parseFloat(sw1);
      row.add(sw1);
      
      String pieces=Pieces.getText();
     int pvalue=Integer.parseInt(pieces);
      row.add(pieces);
      float totstoneweight;
      totstoneweight=pvalue*swperstone;
      row.add(Float.toString(totstoneweight));
      float netrate;
      netrate=pvalue*swvalue;
      
      
      
      //row.add("yo");
      
      row.add(Float.toString(netrate));
       //row.add(StoneRate.getText());
      Stonetabledata.add(row);
      System.out.println(Stonetabledata.get(0));
      StoneTable.setEditable(true);
      
      StoneTable.setItems(Stonetabledata);
         StoneCombo.setValue(null);
        //StoneCombo.getValue();
        Clarity.clear();
        Cut.clear();
        Pieces.clear();
        StoneWeight.clear();
        CWPCombo.setValue(null);
        StoneRate.clear();
       // arrdata.add(SqlLogin.data.get(0));
  // System.out.println(arrdata);
  double s=0;
    for(int p=0;p<Stonetabledata.size();p++)
    {
         s=s+Double.valueOf((String) Stonetabledata.get(p).get(10));
     }
    String val;
     val=String.valueOf(s);
     TotalStonePrice.setText(val);
     TotalStonePrice.setVisible(true);
     Double buyprice=Double.parseDouble(BuyingPrice.getText());
     Double totsingleornprice=0.0;
     totsingleornprice=buyprice+s;
     SingleOrnamentPrice.setText(Double.toString(totsingleornprice));
      // SqlLogin.executeUpdate(" Insert into STONE_DETAILS " + "Values( NULL, '"+barcode+"', '"+wholesaler+"', '"+date+"','"+type+"','"+material+"','"+designname+"','"+purity+"','"+netweight+"','"+grossweight+"','"+costprice+"','"+sellingprice+"')" ); 
       // SqlLogin.executeInvQuery("select ID,BARCODE,TYPE,MATERIAL,DESIGN_NAME,PURITY,NET_WEIGHT,GROSS_WEIGHT,SELLING_PRICE,COST_PRICE from INVENTORY where BARCODE='"+barcode+"'",StoneTable); 
    }

    @FXML
    private void handleAddOrnament(ActionEvent event) {
       /* String wsname=WSName.getText();
        String add1=Address1.getText();
        String add2=Address2.getText();
        String pin=PinCode.getText();
        String phoneno=MobileNo.getText();
        String panno=PanNo.getText();
         //String panno=Family.getText();*/
       
        String material=(String)MaterialCombo.getValue();
         String type=(String) TypeCombo.getValue();
        String designname=(String) DesignNameCombo.getValue();
        String subitem=null;
        //String wholesaler = (String) WholeSalerName.getValue();
       
        LocalDate date=LocalDate.now();
         String hm=(String) HallMarkCombo.getValue();
        String barcode=null;
        
        int quantity= Integer.parseInt(Quantity.getText());
    float purity= Float.parseFloat(Purity.getText());
   float stoneweight = Float.parseFloat(CompleteStoneWeight.getText());
   float grossweight = Float.parseFloat(GrossWeight.getText());
   double buyingprice = Double.parseDouble(BuyingPrice.getText());
   double sellingprice = Double.parseDouble(SellingPrice.getText());
   double makingcharges = Double.parseDouble(MakingCharges.getText());
   double totmetalprice = Double.parseDouble(SingleOrnamentPrice.getText());
        
        
    // SqlLogin.executeUpdate(" Insert into NEW_INVENTORY " + "Values( NULL, '"+barcode+"', '"+wsname+"', '"+date+"','"+mat+"','"+type+"','"+designname+"','"+subitem+"','"+makingcharges+"','"+hm+"','"+purity+"',null,'"+stoneweight+"','"+grossweight+"','"+buyingprice+"','"+sellingprice+"')" );   
     ObservableList<String> row1= FXCollections.observableArrayList();
   
   row1.add(Integer.toString(l));
   l++;
    row1.add(material);
    row1.add(type);
     row1.add(designname); 
     
     row1.add(hm); 
      row1.add(Float.toString(purity));
    // row1.add(grossweight); 
     row1.add(Float.toString(grossweight)); 
     row1.add(Float.toString(stoneweight));
     float nw=grossweight+stoneweight;
     row1.add(Float.toString(nw));
    row1.add(Double.toString(makingcharges));
     //row1.add(Double.toString(buyingprice));
     row1.add(Double.toString(buyingprice));
    // row1.add(Double.toString(sellingprice));
     String tsp=TotalStonePrice.getText();
     row1.add(tsp);
     double stonepriceval=Double.parseDouble(tsp);
     //double netprice=0.0;
     //netprice
     Double sop=Double.parseDouble(SingleOrnamentPrice.getText());
     row1.add(SingleOrnamentPrice.getText());
     row1.add(Integer.toString(quantity)); 
     double netamount=0.0;
     netamount=quantity*sop;
     row1.add(Double.toString(netamount));
    //// //double tempvar=0;
    // tempvar=buyingprice+stonepriceval;
    // TotalPrice.setText(Double.toString(tempvar));
    // PreviousBalance.setText("0.0");
    //TotalDue.setText("0.0");
    // String pieces1=Pieces.getText();
    // int pvalue=Integer.parseInt(pieces1);
     // row.add(pieces1);
      //System.out.println(StoneWeight.getText());
      ////row.add(StoneWeight.getText());
     // row.add((String) CWPCombo.getValue());
     // String sw1=StoneRate.getText();
    //  float swvalue=Float.parseFloat(sw1);
     // row.add(sw1);
    // double netrate;
    //  netrate=quantity*tempvar;
    //  row1.add(Double.toString(netrate));
      
      
      
      
      //row.add("yo");
      
     // row.add(Float.toString(netrate));
       //row.add(StoneRate.getText());
      Ornamenttabledata.add(row1);
      System.out.println(Ornamenttabledata.get(0));
      OrnamentTable.setEditable(true);
      
      OrnamentTable.setItems(Ornamenttabledata);
         StoneCombo.setValue(null);
        //StoneCombo.getValue();
       //// Material.clear();
       // .clear();
        GrossWeight.clear();
        CompleteStoneWeight.clear();
        MaterialCombo.setValue(null);
        HallMarkCombo.setValue(null);
        TypeCombo.setValue(null);
        DesignNameCombo.setValue(null);
        MakingCharges.clear();
        SellingPrice.clear();
        BuyingPrice.clear();
        SubItem.clear();
       // arrdata.add(SqlLogin.data.get(0));
  // System.out.println(arrdata);
  double s=0;
    for(int z=0;z<Ornamenttabledata.size();z++)
    {
         s=s+Double.valueOf((String) Ornamenttabledata.get(z).get(14));
     }
    String val;
     val=String.valueOf(s);
     TotalPrice.setText(val);
    // TotalStonePrice.setVisible(true);   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   
    
    }
    
    

    @FXML
    private void handleAddSimilar(ActionEvent event) {
        
        WSName.addEventHandler(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent event) {
                String typed=WSName.getText();
                if(typed.length()==0)
                {
                                WSName.clear();
                                Address1.clear();
                                Address2.clear();
                                PinCode.clear();
                                MobileNo.clear();
                                PanNo.clear();
                                FamilyCombo.setValue(null);
                                FamilyName.clear();
                                //relationWith.clear();
                                
                    suggestion.getChildren().clear();
                    suggestion.setVisible(false);
                    return;
                }
                suggestion.getChildren().clear();
                try {
                    SqlLogin.executeNewContent("select * from WHOLESALER WHERE NAME LIKE '%"+typed+"%' ");
                } catch (SQLException ex) {
                    Logger.getLogger(AddInventoryController.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println(SqlLogin.data);
                //ArrayList<Customer> searchList=CustomerTable.searchCustomer(typed);
                for(int i=0;i<SqlLogin.data.size();++i){
                    HBox entry=new HBox();
                    Label name=new Label((String)SqlLogin.data.get(i).get(1));
                   // Label phone=new Label(SqlLogin.data.get(i).getPhoneNo());
                   // name.setId(searchList.get(i).getId().toString());
                    entry.getChildren().addAll(name);
                    name.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>(){
                        @Override
                        public void handle(MouseEvent event) {
                            name.setStyle("-fx-background-color:blue");
                        }
                        
                    });
                    name.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>(){
                        @Override
                        public void handle(MouseEvent event) {
                            name.setStyle("-fx-background-color:white");
                        }
                        
                    });
                    name.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
                        @Override
                        public void handle(MouseEvent event) {
                            Integer id=Integer.parseInt(name.getId());
                            try{
                                System.out.println("working");
                                /*Customer c=CustomerTable.getCustomer(id);
                                custName.setText(c.getCustName());
                                address1.setText(c.getAddress());
                                address2.setText(c.getCity());
                                Pin.setText(c.getPin());
                                phoneNo.setText(c.getPhoneNo());
                                PanNo.setText(c.getPanNo());
                                relationWith.setText(c.getRelatedTo());
                                relation.getEditor().setText(c.getRelation());
                                relation.setValue(c.getRelatedTo());*/
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
                suggestion.setVisible(true);
                
                
            }
            
        });
        
        
        
        
        
    }

    private void handleTotalPrice(KeyEvent event) {
        String bp=BuyingPrice.getText();
        SingleOrnamentPrice.setText(bp);
        
    }

    private void handleTotalMetalWeight(KeyEvent event) {
        String gw=GrossWeight.getText();
        singlemetalweight.setText(gw);
        
        
    }

    @FXML
    private void handleInvOverView(MouseEvent event) {
    }
    
}
