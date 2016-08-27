package Sales;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*package javafxapplication4;

/**
 *
 * @author vinay
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package shoppingmall;
/*
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
//import static shoppingmall.Inventory.inventory;

/**
 * FXML Controller class
 *
 * @author sandukuttan
 */
/*public class BillingPageController implements Initializable {
    
    @FXML
    private Label shopName;
    
    @FXML
    private Label lpoints;
    
    @FXML
    private Label subTotal;
    
    @FXML
    private Label saved;
    
    @FXML
    private Label total;
    
    @FXML
    private Button print;
    
    @FXML
    private TextField search;
    
    @FXML
    private TextField custName;
    
    @FXML
    private TextField custID;
    
    @FXML
    private TilePane tile;
    
    @FXML
    private HBox cart;
    
    @FXML
    private Button back;
    
    @FXML
    private TableView table;
    
    @FXML
    private void goBack(ActionEvent event) throws IOException{
        Parent homePageParent = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
            Scene homePageScene = new Scene(homePageParent);
            Stage appStage = (Stage)((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(homePageScene);
            appStage.show();
    }
    
    @FXML
    protected void displaySearch(){
        ArrayList<Item> result=null;
        String noOfProducts="Total Products : ";
        if(search.getText().isEmpty()){
            tile.getChildren().remove(0, tile.getChildren().size());
            tileDisplay(SqlLogin.data);
        }
        else{
            
            
            ObservableList<ObservableList> data = FXCollections.observableArrayList();
            try{
                result= inventory.searchItem(search.getText());
                
                for (Item item : result) {
                    ObservableList o = FXCollections.observableArrayList();
                    o.addAll(item.getItemID(),item.getItemName(),item.getItemPrice().toString(),item.getItemQuantity().toString(),item.getItemCategory(),(item.isItemOfferAvailability())?"1":"0",item.getItemImage(),item.getItemDiscount().toString());
                    //System.out.println(o);

                    data.add(o);
                }
            }
            catch(Exception e){
                System.out.println(e);
            }
            tile.getChildren().remove(0, tile.getChildren().size());
            tileDisplay(data);
        }

        
    }
    private float totalCost,subTotalCost;
    ObservableList<ObservableList> billData;
    public void tileDisplay(ObservableList<ObservableList> data){
        ImageView page = new ImageView();
        
        tile.setMaxWidth(600);
        tile.setMaxHeight(1000);
        String name;
        
        try{
        for(int i=0;i<data.size();++i){
            VBox itemTile=new VBox();
            Label itemName=new Label();
            Label itemPrice=new Label();
            //Label itemQuantity=new Label();
            ObservableList row=FXCollections.observableArrayList();
            name=(String)data.get(i).get(2);
            itemPrice.setText(name);
            itemPrice.setScaleX(1.3);
            itemPrice.setScaleY(1.3);
            //name=(String)data.get(i).get(3);
            //itemQuantity.setText(name);
            name=(String) data.get(i).get(6);
            itemName.setText(name);
            itemTile.setId((String) data.get(i).get(0));
            //System.out.println(name);
            if(!name.equals("0")){
                page= new ImageView(new Image(ShoppingMall.class.getResourceAsStream("img/"+name)));
                page.setFitHeight(200);
                page.setFitWidth(200);
                page.setId((String) data.get(i).get(1));
                itemTile.getChildren().add(page);
                itemTile.getChildren().add(itemName);
                itemTile.getChildren().add(itemPrice);
                
                itemTile.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        Item item = new Item();
                         item=Inventory.getItem(itemTile.getId());
                         System.out.println(item.getItemPrice());
                         //total.setText(item.getItemPrice().toString());
                         row.addAll(item.getItemID(),item.getItemName(),0,item.isItemOfferAvailability(),item.getItemPrice());
                         billData.add(row);
                         table.setItems(billData);
                         totalCost+=item.getItemPrice();
                         subTotalCost+=item.getItemPrice();
                         //total.setText("Total : "+totalCost);
                         subTotal.setText("Rs "+subTotalCost+"\\-");
                         
                    }
                });
                //itemTile.getChildren().add(itemQuantity);
                tile.getChildren().add(itemTile);
                
            }
            
            }
            
        }
        catch(Exception e){
                System.out.println(e);
            }
        
    }
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
   /* @Override
    public void initialize(URL url, ResourceBundle rb) {
        totalCost=subTotalCost=0;
        billData=FXCollections.observableArrayList();
        Login user=Login.getUser();
        table.setEditable(true);
        shopName.setText(user.getShopName());
        String noOfProducts="Total Products : ";
        String ItemID,ItemName,ItemCategory,ItemImage;
        Float ItemPrice,ItemDiscount;
        Integer ItemQuantity;
        boolean ItemOfferAvailability;
        try {
            
            SqlLogin.getTable("select * from ItemTable",null);
        } catch (SQLException ex) {
            Logger.getLogger(InventoryPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int i=0;i<SqlLogin.data.size();++i){
            
            ItemID=((String) SqlLogin.data.get(i).get(0));
                       
            ItemName=((String) SqlLogin.data.get(i).get(1));
                       
            ItemPrice=(Float.valueOf((String) SqlLogin.data.get(0).get(2)));
            
            ItemQuantity=(Integer.parseInt((String) SqlLogin.data.get(i).get(3)));
               
            ItemCategory=((String) SqlLogin.data.get(i).get(4));
            
            ItemOfferAvailability=((Integer.valueOf((String) SqlLogin.data.get(i).get(5))==1));
            
            ItemImage=((String) SqlLogin.data.get(i).get(6));
            
            ItemDiscount=(Float.valueOf((String) SqlLogin.data.get(i).get(7)));
                
            Item item=new Item(ItemID, ItemName, ItemCategory, ItemImage, ItemPrice, ItemDiscount, ItemQuantity, ItemOfferAvailability);
            Inventory.addItem(item);
        }
        String colName = null;
        for(int i=0;i<5;++i){
                    final int j=i;
                    if(i==0)
                        colName="Item ID";
                    else if(i==1)
                        colName="Name";
                    else if(i==2)
                        colName="Quantity";
                    else if(i==3)
                        colName="Offer Availability";
                    else
                        colName="Price";
                    TableColumn col=new TableColumn(colName);
                    col.setMinWidth(200);
                    col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                        @Override
                        public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {                                                                                              
                            return new SimpleStringProperty(param.getValue().get(j).toString());                        
                        }                    
                    });
                    table.getColumns().addAll(col);
                }
        tileDisplay(SqlLogin.data);
        // TODO
    }    
    
}
*/