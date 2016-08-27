/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author vinay
 */
public class InventoryWholeSalerController implements Initializable {

    @FXML
    private TextField InvOverView;
    @FXML
    private TextField InvDetails;
    @FXML
    private TextField InvWholeSaler;
    private ObservableList<String> data3;
    /**
     * Initializes the controller class.
     */
    @FXML
    private TilePane emp = new TilePane();
    @FXML
    private TextField InvAddNew;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Good Game!!");
        try {
            /*try {
            // TODO
            SqlLogin.executeNewContent("select NAME,ADDRESS,PHONE_NO  FROM WHOLESALER");
            //refresh();
            } catch (SQLException ex) {
            Logger.getLogger(InventoryWholeSaler1Controller.class.getName()).log(Level.SEVERE, null, ex);
            }*/
            refresh();
            //tileDisplay(SqlLogin.data);
        } catch (SQLException ex) {
            Logger.getLogger(InventoryWholeSalerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    



   @FXML
    private void handleInvOverView(MouseEvent event) throws IOException {
         Parent home_page_parent = FXMLLoader.load(getClass().getResource("InventoryOverView1.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       // app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
@FXML
    private void handleInvDetails(MouseEvent event) throws IOException {
         Parent home_page_parent = FXMLLoader.load(getClass().getResource("InventoryDetails1.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       // app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
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
    
  
       
    
    public void tileDisplay(ObservableList<ObservableList> data){
        emp.setHgap(5);
        emp.setVgap(5);
        ImageView page = new ImageView();
        
        String name;
        try{
        for(int i=0;i<data.size();++i){
            VBox empTile=new VBox();
            int wstestid=Integer.valueOf((String)data.get(i).get(0));
            empTile.setId((String)data.get(i).get(0));
            
            empTile.setOnMouseClicked(new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                    parameters.setvalue(empTile.getId());
     //             
                    Stage stage = new Stage();
                    Object root = null;
                    System.out.println("Inside Try fun!!");
                        InvIDClass.setvalue(wstestid);
                    try {
                        //int wsid= Integer.valueOf((String)data.get(i).get(0));
                        root = FXMLLoader.load(getClass().getResource("InventoryEditWholeSaler.fxml"));
                    } catch (IOException ex) {
                        Logger.getLogger(InventoryWholeSalerController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    stage.setScene(new Scene((Parent) root));
                    parameters.setvalue(empTile.getId());
     //               System.out.println(parameters.getEmpId());
                    stage.setTitle(empTile.getId());
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.initOwner(emp.getScene().getWindow());
                    stage.showAndWait();
                    try {
                        refresh();
                    } catch (SQLException ex) {
                        Logger.getLogger(InventoryWholeSalerController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
        });
            HBox descTile=new HBox();
            VBox desc = new VBox();
            Label wsname=new Label();
            wsname.setStyle("-fx-text-fill:red; -fx-font-size: 20px;");
           // Label wsaddress=new Label();
            Label wsphoneno=new Label();
            wsphoneno.setStyle("-fx-text-fill:green; -fx-font-size: 10px;");
            name=(String)data.get(i).get(1);
            wsname.setText(name);
           // name=(String)data.get(i).get(2);
            //wsaddress.setText(name);
            name=(String) data.get(i).get(3);
            wsphoneno.setText(name);
            
            System.out.println(name);
            if(true){
              page= new ImageView(new Image(MainFun.class.getResourceAsStream("img/"+data.get(i).get(0)+".jpg")));
                page.setFitHeight(150);
                page.setFitWidth(150);
                page.setId((String) data.get(i).get(0));
                descTile.getChildren().add(page);
                desc.getChildren().add(wsname);
               // desc.getChildren().add(wsaddress);
                desc.getChildren().add(wsphoneno);
               descTile.getChildren().add(desc);
                //empTile.applyCss();
                empTile.getChildren().add(descTile);
                emp.getChildren().add(empTile);
                
            }
            }
            
        }
        catch(Exception e){
                System.out.println(e);
            }
        
    }
    public void refresh() throws SQLException
    {
        emp.getChildren().clear();
        String id,name,ph;
        float sal;
        int attendance_count;
        
         System.out.println("Inside refresh!!");
            SqlLogin.executeNewContent("select * from WHOLESALER");
        tileDisplay(SqlLogin.data);

        VBox addBox = new VBox();
       ImageView add = new ImageView(new Image(MainFun.class.getResourceAsStream("img/add.jpg")));
       add.setFitHeight(150);
       add.setFitWidth(150); 
      addBox.getChildren().add(add);        
        addBox.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                Stage stage = new Stage();
                Object root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("InventoryAddWholeSaler.fxml"));
                } catch (IOException ex) {
                    Logger.getLogger(InventoryWholeSalerController.class.getName()).log(Level.SEVERE, null, ex);
                }
                stage.setScene(new Scene((Parent) root));
                stage.setTitle("My modal window");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.initOwner(addBox.getScene().getWindow());
                stage.showAndWait();
                try {
                    refresh();
                } catch (SQLException ex) {
                    Logger.getLogger(InventoryWholeSalerController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
        emp.getChildren().add(addBox);
        
    }

    /////////////////////////////////////////////////////
    
    /* public void tileDisplay(ObservableList<ObservableList> data){
            scrollpane.setContent(null);
            String name;
            System.out.println(data);
            VBox pledgings = new VBox();
            for(int i=0;i<data.size();++i){
                HBox pledgingTile=new HBox();
                pledgingTile.setSpacing(50);
                pledgingTile.setStyle("-fx-border-color:black;");
                //pledgingTile.setId((String)data.get(i).get(0));
                
                Label wsname = new Label();
                wsname.setStyle("-fx-text-fill:black; -fx-font-size: 20px;");
                Label address = new Label();
                address.setStyle("-fx-text-fill:black; -fx-font-size: 20px;");
                Label phoneno =new Label();
                phoneno.setStyle("-fx-text-fill:black; -fx-font-size: 20px;");
               
                
                
                name=(String)data.get(i).get(0);
                wsname.setText("WSName:  " + name);
                name=(String)data.get(i).get(1);
               address.setText("Address: " + name);
                name=(String) data.get(i).get(2);
                phoneno.setText("PhoneNo: " + name);
                
                
               // pledgingTile.getChildren().add(id);
                pledgingTile.getChildren().add(wsname);
                pledgingTile.getChildren().add(address);
                pledgingTile.getChildren().add(phoneno);
                
                pledgings.getChildren().add(pledgingTile);
            }
                scrollpane.setContent(pledgings);
    }
    */

    @FXML
    private void handleAddNew(MouseEvent event) throws IOException {
    
     Parent home_page_parent = FXMLLoader.load(getClass().getResource("AddInventory.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       // app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    
    
    }
    
}
