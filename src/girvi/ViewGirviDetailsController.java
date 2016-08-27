/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package girvi;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author akshay
 */
public class ViewGirviDetailsController implements Initializable {

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
    private TextField CustomersSearch;
    @FXML
    private DatePicker fromdate;
    @FXML
    private DatePicker tilldate;
    @FXML
    private ComboBox  metal;
    @FXML
    private TilePane itemspane;
    @FXML
    private ComboBox  itemscombobox;
    @FXML
    private TextField rangefrom;
    @FXML
    private TextField rangeto;
    @FXML
    private CheckBox bankitems;
    @FXML
    private CheckBox expireditems;
    @FXML
    private ScrollPane scrollpane;
    @FXML
    private TextField InvoicesTextField;
    @FXML
    private TextField PledgingsTextField;
    @FXML
    private TextField OverviewTextField;
    @FXML
    private TextField InvoicesTextField1;
    public Label totalitems;
    public Label totalinterest;
    public Label totalamount;
    public HBox currhbox=null;
    public HBox remhbox=null;
    public VBox currvbox=null;
    public VBox remvbox=null;
    public AnchorPane girvipane;
    public int count=0;
    public int Totalamount;
    public int Totalinterest;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         metal.getItems().addAll(
            "Gold",
            "Silver",
            "Diamond",
            "Platinum",
            "Bronze",
            "Others"
            ); 
         itemscombobox.getItems().addAll(
             "Necklace",
            "Chain",
            "Bracelet",
            "Ring",
            "Biscuit",
            "Others"
         );
         rangefrom.setText("1");
         rangeto.setText("10000000");
          try {
            SqlLoginchit.executeQueryTiles("select id,customer,dateoflending,amount,interest from invoice");
        } catch (SQLException ex) {
            Logger.getLogger(ViewGirviDetailsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            tileDisplay(SqlLoginchit.data);
        } catch (SQLException ex) {
            Logger.getLogger(ViewGirviDetailsController.class.getName()).log(Level.SEVERE, null, ex);
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
    private void handleCustomersSearch(KeyEvent event) throws SQLException {
         SqlLoginchit.executeQueryTiles("select id,customer,dateoflending,amount,interest from invoice where customer like '%"+CustomersSearch.getText()+"%'");
         tileDisplay(SqlLoginchit.data);
    }

    @FXML
    private void additemtopane(ActionEvent event) {
    }

    @FXML
    private void handleInvoicesClick(MouseEvent event) {
    }

    @FXML
    private void handleOverviewClick(MouseEvent event) {
    }
    public void tileDisplay(ObservableList<ObservableList> data) throws SQLException{
            scrollpane.setContent(null);
            String name;
            System.out.println(data);
            VBox pledgings = new VBox();
            int temp=-1;
            int items=0;
            Totalinterest=0;
            Totalamount=0;
            for(int i=0;i<data.size();++i){
                VBox vbox2=new VBox();
                Pane pane = new Pane();
                pane.getStyleClass().add("Pane");
                HBox pledgingTile=new HBox();
                pledgingTile.setPrefSize(1000,20);
                pledgingTile.setSpacing(50);
                pledgings.setSpacing(20);
                pledgingTile.setId((String)data.get(i).get(0));
                int k=Integer.parseInt((String)data.get(i).get(0));
                //SqlLoginchit.executeQueryTiles("select item,grosswt,purity from girvi where customerid='"+k+"'");
                if(temp!=k){
                 
                 items=items+1;
                 temp=k;
                Label id = new Label();
                id.setStyle("-fx-text-fill:black; -fx-font-size: 13px;");
                id.setText((String)data.get(i).get(0));
                id.setPrefSize(10, 20);
                Label customer = new Label();
                customer.setStyle("-fx-text-fill:black; -fx-font-size: 13px;");
                customer.setText((String)data.get(i).get(1));
                customer.setPrefSize(70, 20);
                Label date = new Label();
                date.setStyle("-fx-text-fill:black; -fx-font-size: 13px;");
                date.setText((String)data.get(i).get(2));
                date.setPrefSize(90, 20);
                Label grosswt=new Label();
                grosswt.setStyle("-fx-text-fill:black; -fx-font-size: 13px;");
                grosswt.setText(null);
                //loan.setText((String)data.get(i).get(3)+"("+(String)data.get(i).get(4)+")");
                VBox vbox1=new VBox();
                SqlLoginchit.executeQueryTiles("select item,grosswt,purity from items where invoiceid='"+k+"'");
                vbox1.setPrefSize(150, 20);
                VBox vbox3=new VBox();
                tiledisplay2(SqlLoginchit.data,vbox1);
                Label loan=new Label();
                loan.setPrefSize(80, 20);
                Label Intrest=new Label();
                loan.setStyle("-fx-text-fill:black; -fx-font-size: 13px;");
                loan.setText((String)data.get(i).get(3));
                Totalamount=Totalamount+Integer.parseInt((String)data.get(i).get(3));
                Intrest.setStyle("-fx-text-fill:black; -fx-font-size: 13px;");
                Intrest.setText("("+(String)data.get(i).get(4)+")");
                Totalinterest=Totalinterest+Integer.parseInt((String)data.get(i).get(4));
                  vbox3.getChildren().add(loan);
                  vbox3.getChildren().add(Intrest);
                pledgingTile.getChildren().add(id);
                pledgingTile.getChildren().add(customer);
                pledgingTile.getChildren().add(date);
                pledgingTile.getChildren().add(vbox1);
                pledgingTile.getChildren().add(grosswt);
                pledgingTile.getChildren().add(vbox3);
                vbox2.getChildren().add(pledgingTile);
                TableView table=new TableView();
                HBox hbox2=new HBox();
                if(!table.getColumns().isEmpty())
                  table.getColumns().clear();
                SqlLoginchit.executeQuery("SELECT * from payments where invoiceid='"+k+"'",table);          
                table.setItems(SqlLoginchit.data);
                table.setPrefSize(720, 100);
                hbox2.getChildren().add(table);
                  girvipane.setOnMouseClicked(new EventHandler<MouseEvent>(){
                    public void handle(MouseEvent event) {
                      if(currhbox!=null && count==0){
                        currvbox.getChildren().remove(currhbox);
                        currhbox=null;
                        currvbox=null;
                        
                    }
                      count=0;
                     
                    }
                 }
                 );
                pane.setOnMouseClicked(new EventHandler<MouseEvent>(){
                    public void handle(MouseEvent event) {
                        if(currhbox!=null){
                          currvbox.getChildren().remove(currhbox);
                          remhbox=currhbox;
                          currhbox=null;
                           remvbox=currvbox;
                          currvbox=null;
                          }
                        if(remhbox!=hbox2){
                          vbox2.getChildren().add(hbox2);
                          currhbox=hbox2;
                          currvbox=vbox2;
                          
                        }
                        remhbox=null;
                        remvbox=null;
                        count=1;
                            
                        }
                      });
                pane.getChildren().add(vbox2);
                pledgings.getChildren().add(pane);
            }
            }
                scrollpane.setContent(pledgings);
                System.out.println(items);
                totalitems.setText(String.valueOf(items));
                totalamount.setText(String.valueOf(Totalamount));
                System.out.println(Totalamount);
                System.out.println(Totalinterest);
                totalinterest.setText(String.valueOf(Totalinterest));
    }
    public void tileDisplay3(ObservableList<ObservableList> data) throws SQLException{
            scrollpane.setContent(null);
            String name;
            System.out.println(data);
            VBox pledgings = new VBox();
            int temp=-1;
            int totalitem =0;
            Totalinterest=0;
            Totalamount=0;
            for(int i=0;i<data.size();++i){
                VBox vbox2=new VBox();
                Pane pane = new Pane();
                pane.getStyleClass().add("Pane");
                HBox pledgingTile=new HBox();
                pledgingTile.setPrefSize(1000,20);
                pledgingTile.setSpacing(50);
                pledgings.setSpacing(20);
                pledgingTile.setId((String)data.get(i).get(0));
                int k=Integer.parseInt((String)data.get(i).get(0));
                SqlLoginchit.executeQueryTiles("select grosswt,purity from items where invoiceid='"+k+"'");
                int m;
                m=expired(SqlLoginchit.data);
                if(temp!=k && m<=0){
                
                totalitem = totalitem+1;   
                temp=k;
                Label id = new Label();
                id.setStyle("-fx-text-fill:black; -fx-font-size: 13px;");
                id.setText((String)data.get(i).get(0));
                id.setPrefSize(10, 20);
                Label customer = new Label();
                customer.setStyle("-fx-text-fill:black; -fx-font-size: 13px;");
                customer.setText((String)data.get(i).get(1));
                customer.setPrefSize(70, 20);
                Label date = new Label();
                date.setStyle("-fx-text-fill:black; -fx-font-size: 13px;");
                date.setText((String)data.get(i).get(2));
                date.setPrefSize(90, 20);
                Label grosswt=new Label();
                grosswt.setStyle("-fx-text-fill:black; -fx-font-size: 13px;");
                grosswt.setText(null);
                //loan.setText((String)data.get(i).get(3)+"("+(String)data.get(i).get(4)+")");
                Label Bank=new Label();
                Bank.setStyle("-fx-text-fill:black; -fx-font-size: 13px;");
                Bank.setText((String)data.get(i).get(5));
                VBox vbox1=new VBox();
                SqlLoginchit.executeQueryTiles("select item,grosswt,purity from girvi where customerid='"+k+"'");
                vbox1.setPrefSize(150, 20);
                VBox vbox3=new VBox();
                tiledisplay2(SqlLoginchit.data,vbox1);
                Label loan=new Label();
                loan.setPrefSize(80, 20);
                Label Intrest=new Label();
                loan.setStyle("-fx-text-fill:black; -fx-font-size: 13px;");
                loan.setText((String)data.get(i).get(3));
                Totalamount=Totalamount+Integer.parseInt((String)data.get(i).get(3));
                Intrest.setStyle("-fx-text-fill:black; -fx-font-size: 13px;");
                Intrest.setText("("+(String)data.get(i).get(4)+")");
                 Totalinterest=Totalinterest+Integer.parseInt((String)data.get(i).get(3));
                vbox3.getChildren().add(loan);
                  vbox3.getChildren().add(Intrest);
                pledgingTile.getChildren().add(id);
                pledgingTile.getChildren().add(customer);
                pledgingTile.getChildren().add(date);
                pledgingTile.getChildren().add(vbox1);
                pledgingTile.getChildren().add(grosswt);
                pledgingTile.getChildren().add(vbox3);
                pledgingTile.getChildren().add(Bank);
                vbox2.getChildren().add(pledgingTile);
                TableView table=new TableView();
                HBox hbox2=new HBox();
                if(!table.getColumns().isEmpty())
                  table.getColumns().clear();
                SqlLoginchit.executeQuery("SELECT invoice.customer,payments.amount,payments.dateofpayment,payments.paymentmode from payments INNER JOIN invoice ON invoice.id = payments.invoiceid where invoice.id='"+k+"'",table);          
                table.setItems(SqlLoginchit.data);
                table.setPrefSize(720, 100);
                hbox2.getChildren().add(table);
                  girvipane.setOnMouseClicked(new EventHandler<MouseEvent>(){
                    public void handle(MouseEvent event) {
                      if(currhbox!=null && count==0){
                        currvbox.getChildren().remove(currhbox);
                        currhbox=null;
                        currvbox=null;
                        
                    }
                      count=0;
                  
                    }
                 }
                 );
                pane.setOnMouseClicked(new EventHandler<MouseEvent>(){
                    public void handle(MouseEvent event) {
                        if(currhbox!=null){
                          currvbox.getChildren().remove(currhbox);
                          remhbox=currhbox;
                          currhbox=null;
                           remvbox=currvbox;
                          currvbox=null;
                          }
                        if(remhbox!=hbox2){
                          vbox2.getChildren().add(hbox2);
                          currhbox=hbox2;
                          currvbox=vbox2;
                          
                        }
                        remhbox=null;
                        remvbox=null;
                        count=1;
                     //    System.out.println("uhrdakshay");
                            
                        }
                      });
                pane.getChildren().add(vbox2);
                pledgings.getChildren().add(pane);
                
            }
            }
                scrollpane.setContent(pledgings);
                totalitems.setText(String.valueOf(totalitem));
                totalamount.setText(String.valueOf(Totalamount));
                totalinterest.setText(String.valueOf(Totalinterest));
    }

    private void tiledisplay2(ObservableList<ObservableList> data, VBox vbox1) {
             for(int i=0;i<data.size();++i){
                 Label item=new Label();              
                item.setStyle("-fx-text-fill:black; -fx-font-size: 13px;");
                item.setText((String)data.get(i).get(0)+"("+(String)data.get(i).get(1)+"gms"+","+(String)data.get(i).get(2)+"%)");
                vbox1.getChildren().add(item);
             }
    }
    
      public void searchdate(ActionEvent event) {
         
          try {
            SqlLoginchit.executeQueryTiles("select id,customer,dateoflending,amount,interest from invoice where dateoflending between '"+fromdate.getValue()+"' and '"+tilldate.getValue()+"'");
        } catch (SQLException ex) {
            Logger.getLogger(ViewGirviDetailsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            tileDisplay(SqlLoginchit.data);
        } catch (SQLException ex) {
            Logger.getLogger(ViewGirviDetailsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      public void searchmetal(ActionEvent event) {
          
          try {
            SqlLoginchit.executeQueryTiles("select invoice.id,invoice.customer,invoice.dateoflending,invoice.amount,invoice.interest from invoice inner join items on items.invoiceid=invoice.id where items.material='"+metal.getValue()+"'");
        } catch (SQLException ex) {
            Logger.getLogger(ViewGirviDetailsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            tileDisplay(SqlLoginchit.data);
        } catch (SQLException ex) {
            Logger.getLogger(ViewGirviDetailsController.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
       public void searchrange() {
          try {
            SqlLoginchit.executeQueryTiles("select id,customer,dateoflending,amount,interest from invoice where amount between '"+Integer.parseInt(rangefrom.getText())+"' and '"+Integer.parseInt(rangeto.getText())+"'");
        } catch (SQLException ex) {
            Logger.getLogger(ViewGirviDetailsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            tileDisplay(SqlLoginchit.data);
        } catch (SQLException ex) {
            Logger.getLogger(ViewGirviDetailsController.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
       public void searchitem(ActionEvent Event) {
           //System.out.println(Integer.parseInt.getText()));
          try {
            SqlLoginchit.executeQueryTiles("select invoice.id,invoice.customer,invoice.dateoflending,invoice.amount,invoice.interest from invoice inner join items on items.invoiceid=invoice.id where items.item='"+itemscombobox.getValue()+"'");
        } catch (SQLException ex) {
            Logger.getLogger(ViewGirviDetailsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            tileDisplay(SqlLoginchit.data);
        } catch (SQLException ex) {
            Logger.getLogger(ViewGirviDetailsController.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
        public void searchinbank(ActionEvent Event) {
           if(bankitems.isSelected()==true){
          try {
            SqlLoginchit.executeQueryTiles("select invoice.id,invoice.customer,invoice.dateofpledging,invoice.totalamount,totalinterest,presentinbank from invoice where presentinbank='Yes'");//change to Yes
        } catch (SQLException ex) {
            Logger.getLogger(ViewGirviDetailsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            tileDisplay(SqlLoginchit.data);
        } catch (SQLException ex) {
            Logger.getLogger(ViewGirviDetailsController.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
        else {
        try {
            SqlLoginchit.executeQueryTiles("select invoice.id,invoice.customer,invoice.dateofpledging,invoice.totalamount,totalinterest,presentinbank from invoice");//change to Yes
        } catch (SQLException ex) {
            Logger.getLogger(ViewGirviDetailsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            tileDisplay(SqlLoginchit.data);
        } catch (SQLException ex) {
            Logger.getLogger(ViewGirviDetailsController.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
}
     public void removemetal(MouseEvent Event){
            fromdate.setValue(null);
            tilldate.setValue(null);
            itemscombobox.setValue(null);
            
              try {
            SqlLoginchit.executeQueryTiles("select id,customer,dateoflending,amount,interest from invoice");
        } catch (SQLException ex) {
            Logger.getLogger(ViewGirviDetailsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            tileDisplay(SqlLoginchit.data);
        } catch (SQLException ex) {
            Logger.getLogger(ViewGirviDetailsController.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
      public void removeitems(MouseEvent Event){
            fromdate.setValue(null);
            tilldate.setValue(null);
            metal.setValue(null);
            
              try {
            SqlLoginchit.executeQueryTiles("select id,customer,dateoflending,amount,interest from invoice");
        } catch (SQLException ex) {
            Logger.getLogger(ViewGirviDetailsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            tileDisplay(SqlLoginchit.data);
        } catch (SQLException ex) {
            Logger.getLogger(ViewGirviDetailsController.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
       public void removedate(MouseEvent Event){
            itemscombobox.setValue(null);
            metal.setValue(null);
              try {
            SqlLoginchit.executeQueryTiles("select id,customer,dateoflending,amount,interest from invoice");
        } catch (SQLException ex) {
            Logger.getLogger(ViewGirviDetailsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            tileDisplay(SqlLoginchit.data);
        } catch (SQLException ex) {
            Logger.getLogger(ViewGirviDetailsController.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
        public void expireditem(ActionEvent Event) throws SQLException {
             if(expireditems.isSelected()==true){
                 SqlLoginchit.executeQueryTiles("select id,customer,dateoflending,amount,interest from invoice");
                  tileDisplay3(SqlLoginchit.data);
             }
             else{
                 SqlLoginchit.executeQueryTiles("select id,customer,dateoflending,amount,interest from invoice");
                  tileDisplay(SqlLoginchit.data);
             }
        }

    public int expired(ObservableList<ObservableList> data) {
        int m=0;
        for(int i=0;i<data.size();++i){
           m=m+Integer.parseInt((String) data.get(i).get(0))*Integer.parseInt((String) data.get(i).get(1))*2000/100-Integer.parseInt((String) data.get(i).get(2))-Integer.parseInt((String) data.get(i).get(3));
        }
      
        return m;
    }
    
}
