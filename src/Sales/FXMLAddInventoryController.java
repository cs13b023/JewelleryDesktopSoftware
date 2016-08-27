/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sales;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author vinay
 */
public class FXMLAddInventoryController implements Initializable {

   
    @FXML
    private TextField Purity;
    @FXML
    private TextField NetWeight;
    @FXML
    private TextField GrossWeight;
    @FXML
    private ComboBox WholeSalerName;
    @FXML
    private TextField CostPrice,SellingPrice,Barcode;
    @FXML
    private DatePicker Date;
    @FXML
    private Button AddOrnament;
    @FXML
    private Button Home;
    @FXML
    private ComboBox Material,DesignName,Type;
    @FXML
    private Button AddNewWholeSaler;
    @FXML
    private Button AddNewType;
    @FXML
    private Button AddNewDesign;
    /**
     * Initializes the controller class.
     */
   // @FXML
    //private void generatebarcode(String type,String Material,String Design){
        
    //}
   // 
    @FXML
    private void handleAddOrnament(ActionEvent event) throws SQLException{
       
        String type=(String) Type.getValue();
        
        String material=(String) Material.getValue();
        String designname=(String) DesignName.getValue();
        String wholesaler = (String) WholeSalerName.getValue();
       
        LocalDate date=Date.getValue();
        String barcode=Barcode.getText();
    float purity = Float.parseFloat(Purity.getText());
   float netweight = Float.parseFloat(NetWeight.getText());
   float grossweight = Float.parseFloat(GrossWeight.getText());
   double costprice = Double.parseDouble(CostPrice.getText());
   double sellingprice = Double.parseDouble(SellingPrice.getText());
       //SqlLogin.executeUpdate(" Insert into CUSTOMER " + "Values( NULL, 'harshan', '7894561230', 'pune',3,8)" );
    SqlLogin.executeUpdate(" Insert into INVENTORY " + "Values( NULL, '"+barcode+"', '"+wholesaler+"', '"+date+"','"+type+"','"+material+"','"+designname+"','"+purity+"','"+netweight+"','"+grossweight+"','"+sellingprice+"','"+costprice+"')" );
      SqlLogin.executeUpdate("UPDATE INV_STATISTICS SET QUANTITY=QUANTITY+1 WHERE TYPE='"+type+"' AND MATERIAL='"+material+"' AND DESIGN_NAME='"+designname+"' ");
//  Name.clear();
        //MobileNo.clear();
        //city.clear();
        
   }
    @FXML
   private void handleAddNewWholeSaler(ActionEvent event) throws SQLException, IOException{
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLAddWholeSaler.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    } 
    
    @FXML
    private void handleHome(ActionEvent event) throws SQLException, IOException{
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLTest.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
    //@FXML
    //private void handleTypeDesign(ActionEvent event) throws SQLException, IOException{
       /*Type.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
  @Override public void changed(ObservableValue<? extends String> selected, String oldValue, String newValue) {
    System.out.println("Selected: " + newValue);
  }
});*/
    //}
        
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         ObservableList<String> typedata = FXCollections.observableArrayList();
        WholeSalerName.getItems().clear();
       ObservableList<String>  data=FXCollections.observableArrayList();
        try {
            SqlLogin.executeContent("Select NAME from WHOLESALER",data);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLAddInventoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        WholeSalerName.getItems().addAll(data);
         Type.getItems().clear();
          Material.getItems().clear();
          DesignName.getItems().clear();
        try {
            SqlLogin.executeContent("Select DISTINCT TYPE from INV_TYPE ",typedata);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLAddInventoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
          //Type.getItems().addAll("Necklace","Ring","Bangle","Chain","Mixed","Other");
          Type.getItems().addAll(typedata);
        // DesignName.getItems().addAll("Men V-Shape","women");
          Material.getItems().addAll("GOLD","SILVER","DIAMOND","BRONZE","PLATINUM","COPPER","Mixed","Other");
          //
         
         /*Type.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
  @Override public void changed(ObservableValue<? extends String> selected, String oldValue, String newValue) {
    System.out.println("Selected: " + newValue);
  }
});*/
          Type.getSelectionModel().selectedItemProperty().addListener(new  
ChangeListener<String>() 
{
public void changed(ObservableValue<? extends String> observable,String  
oldValue,String newValue) 
{
     DesignName.getItems().clear();
    System.out.println("Value is::"+newValue);
    ObservableList<String>  data1=FXCollections.observableArrayList();
        try {
            SqlLogin.executeContent("Select DISTINCT DESIGN_NAME from INV_STATISTICS where TYPE='"+newValue+"'",data1);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLAddInventoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        DesignName.getItems().addAll(data1);
         DesignName.getItems().addAll("Other");
         
       
        data1.clear();
       // DesignName.getItems().clear();
}   
});
        
          
    }    

    @FXML
    private void handleAddNewType(ActionEvent event) {
        
        Stage stage = new Stage();
                Object root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("FXMLTypePopup.fxml"));
                } catch (IOException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
                stage.setScene(new Scene((Parent) root));
                stage.setTitle("My modal window");
                stage.initModality(Modality.APPLICATION_MODAL);
               stage.initOwner(AddNewType.getScene().getWindow());
                stage.showAndWait();
                
                Type.getItems().clear();
                ObservableList<String> typedata = FXCollections.observableArrayList();
                 try {
            SqlLogin.executeContent("Select DISTINCT TYPE from INV_TYPE ",typedata);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLAddInventoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
          //Type.getItems().addAll("Necklace","Ring","Bangle","Chain","Mixed","Other");
          Type.getItems().addAll(typedata);
    }

    @FXML
    private void handleAddNewDesign(ActionEvent event) {
        Stage stage = new Stage();
                Object root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("FXMLDesignPopup.fxml"));
                } catch (IOException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
                stage.setScene(new Scene((Parent) root));
                stage.setTitle("My modal window");
                stage.initModality(Modality.APPLICATION_MODAL);
               stage.initOwner(AddNewDesign.getScene().getWindow());
                stage.showAndWait();
                DesignName.getItems().addAll(tryclass.getvalue());
    }
    
   

    
}
