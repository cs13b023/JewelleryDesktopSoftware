/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orders;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author preetham
 */
public class KarigarController implements Initializable {

    @FXML
    private TextField Home;
    @FXML
    private TextField Overview;
    @FXML
    private Separator Underline1;
    @FXML
    private TextField Current;
    @FXML
    private Separator Underline2;
    @FXML
    private TextField Karigar;
    @FXML
    private Separator Underline3;
    @FXML
    private TextField KarigarSearch;
    @FXML
    private TilePane KarigarTile;
    @FXML
    private Pane Default;
    @FXML
    private TableView DefaultTable;
    @FXML
    private Pane Popup;
    @FXML
    private TextField Name;
    @FXML
    private TextField Factory;
    @FXML
    private TextField Special;
    @FXML
    private TextField Rating;
    @FXML
    private TextField Punctuality;
    @FXML
    private Pane KarigarImage;
    
    @FXML
    private TextField Sales;
    @FXML
    private TextField Inventory;
    @FXML
    private TextField loyalty;
    
    @FXML
    private TextField Girvi;
    @FXML
    private TextField Loans;
    @FXML
    private TextField Orders;
    @FXML
    private TextField employee;


    
    @FXML
    public void handleSales(MouseEvent event) throws IOException {
       Parent home_page_parent = FXMLLoader.load(getClass().getResource("/SalesAndInventory/OverView1.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       // app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();   
    }

    @FXML
    public void handleInventory(MouseEvent event) throws IOException {
      Parent home_page_parent = FXMLLoader.load(getClass().getResource("/SalesAndInventory/InventoryOverView1.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       // app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show(); 
    }
    
    @FXML
    public void handlechits(MouseEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/chitfund/overviewchit.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
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
    public void handleloyalty() throws IOException
    {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/loyalty/loyalty.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) (loyalty).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
    
    @FXML
    private void handleGirviClick(MouseEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/girvi/tempFXML.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) Girvi).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();    
    }

    @FXML
    private void handleLoanClick(MouseEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/girvi/LoanFXML.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) Loans).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
    
    @FXML 
     private void handleOrders() throws SQLException, IOException{
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/orders/overview.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) Orders).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
    
    @FXML
    public void handleemployee() throws IOException
    {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/employee/FXMLDocument.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) (employee).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
    

    /**
     * Initializes the controller class.
     */
    @Override
     public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Popup.setVisible(false);
        KarigarImage.setVisible(false);
        Default.setVisible(true);
        Underline1.setVisible(false);
        Underline2.setVisible(false);
       // KarigarSearch.setEditable(true);
        //KarigarSearch.setText("Search By Name");
        try {
            SqlLogin.executeQuery("select * from karigarlist",null);
        } catch (SQLException ex) {
            Logger.getLogger(KarigarController.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultTable.setEditable(true);
      
      if(!DefaultTable.getColumns().isEmpty())
        DefaultTable.getColumns().clear();
        try {      
            SqlLogin.executeQuery("select * from karigarlist",DefaultTable);
        } catch (SQLException ex) {
            Logger.getLogger(CurrentController.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        DefaultTable.setItems(SqlLogin.data);
        
        tileDisplay(SqlLogin.data);
      
    }    
        

    @FXML 
     private void handleCurrent() throws SQLException, IOException{
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("current.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) Current).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
        
    }
     @FXML 
     private void handleHome() throws SQLException, IOException{
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("home.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) Home).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
        
    }
    
     @FXML
     private void handleOverview() throws SQLException, IOException{
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("overview.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) Overview).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
        
        
    }
     
     
     @FXML
       public void tileDisplay(ObservableList<ObservableList> data){
             ImageView page = new ImageView();
             ImageView pic = new ImageView();
             //int search[];
            for(int i = 0 ; i < SqlLogin.data.size();i++)
            {
                String name;
                String spl;
                String fac;
                String rating;
                String punct;
                HBox KarigarInfo = new HBox();
                KarigarInfo.setMinWidth(250.00);
                Label KarigarName = new Label();
                Label KarigarSpcl = new Label();
                KarigarName.setStyle("-fx-text-fill : white;");
                KarigarSpcl.setStyle("-fx-text-fill : white;"); 
                
                VBox KarigarDet = new VBox();
                KarigarDet.setStyle("-fx-padding : 12 ;");
                KarigarInfo.setStyle("-fx-border-width:2px;-fx-border-color:black;-fx-padding:5");
                name=(String)data.get(i).get(2);
                spl=(String)data.get(i).get(6);
                fac=(String)data.get(i).get(3);
                rating=(String) data.get(i).get(4);
                punct=(String) data.get(i).get(5);
                KarigarName.setText(name);
                KarigarName.setScaleX(1.3);
                KarigarName.setScaleY(1.3);
                KarigarSpcl.setText(spl);
                KarigarSpcl.setScaleX(1.3);
                KarigarSpcl.setScaleY(1.3);
               
                
                KarigarInfo.setId((String) data.get(i).get(0));
                
                if(!name.equals(null)){      // condition to check if image is present or not
                    //System.out.println(name);
                try{    
               page = new ImageView(new Image(Orders.class.getResourceAsStream("Raju.jpg")));
                }
                catch(Exception E){
                    
                }
//pic = new ImageView(new Image(Orders.class.getResourceAsStream("img/" + name+".jpg")));
                page.setFitHeight(50);
                page.setFitWidth(50);
                //pic.setFitHeight(190);
                //pic.setFitWidth(190);
                //System.out.println(data.get(i).get(2));
                //System.out.println(Orders.class.getResourceAsStream("img"));
                
                //System.out.println(Orders.class.getResourceAsStream("img/"+data.get(i).get(2)))
                KarigarInfo.getChildren().add(page);
                KarigarDet.getChildren().add(KarigarName);
                KarigarDet.getChildren().add(KarigarSpcl);
                KarigarInfo.getChildren().add(KarigarDet);
                KarigarTile.getChildren().add(KarigarInfo);
                //KarigarImg.getChildren().add(page);
               // System.out.println(page);
               //Popup.getChildren().add(pic);
                
                
                
                KarigarInfo.setOnMouseClicked(new EventHandler<MouseEvent>(){
                    @Override
                    public void handle(MouseEvent event) {
                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                   //String KarigarID = KarigarTile.getId();
                   ImageView picc ;
                   
                   picc = new ImageView(new Image(Orders.class.getResourceAsStream("Raju.jpg")));
                   Popup.setVisible(true);
                   KarigarImage.setVisible(true);
                   //KarigarImage.getChildren().remove();
                   KarigarImage.getChildren().add(picc);
                    picc.setFitHeight(100);
                    picc.setFitWidth(100);
                   DefaultTable.setVisible(false);
                   Name.setText(name);
                   Factory.setText(fac);                   
                   Special.setText(spl);
                   Rating.setText(rating);
                   Punctuality.setText(punct);
                   Special.setEditable(false);
                   Factory.setEditable(false);
                   Name.setEditable(false);
                   Rating.setEditable(false);
                   Punctuality.setEditable(false);
                   
                    }
                   
                });
       
                }
            }
       }
    
     
}
