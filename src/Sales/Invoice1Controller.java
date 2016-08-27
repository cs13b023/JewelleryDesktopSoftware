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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;
import org.jsoup.Jsoup;

/**
 * FXML Controller class
 *
 * @author vinay
 */
public class Invoice1Controller implements Initializable {

    
    @FXML
    private TableView table7;
    @FXML
    private TextField InvoiceBarcode,InvCusID;
    @FXML
    private DatePicker InvDate;
    @FXML
    private Button InvoiceAddItem;
    @FXML
    private Button DelSelectedItem;
    @FXML
    private Pane InvMainPane;
    @FXML
    private Button InvConfirm;
    @FXML
    private Button InvCancel;
    @FXML
    private TextField InvTotal;
    @FXML
    private Button InvAddCustomer;

    Double cp;
    @FXML
    private TextField SalesOverView;
    @FXML
    private TextField SalesInvoice;
    @FXML
    private TextField SalesSoldItems;
    @FXML
    private Label GoldRate;
    @FXML
    private Label SilverRate;
    
    
//@FXML
  //  private  TableView table = new TableView();
    /**
     * Initializes the controller class.
     */
    ObservableList<ObservableList> arrdata = FXCollections.observableArrayList();
      private IntegerProperty index = new SimpleIntegerProperty();
    
    
    public final double getIndex() {
        return index.get();
    }

    
    public final void setIndex(Integer value) {
        index.set(value);
    }

    
    public IntegerProperty indexProperty() {
        return index;
    }

    
   

     @FXML
    private void handleInvoiceAddItem(ActionEvent event) throws SQLException{
       double amt,s;
       s=0;
       System.out.println("Y it is haqppening!!!");
      String barcode=InvoiceBarcode.getText();
    //  
    //if(!table7.getColumns().isEmpty())
        //table7.getColumns().clear();
       
      SqlLogin.executeInvQuery("select ID,BARCODE,TYPE,MATERIAL,DESIGN_NAME,PURITY,NET_WEIGHT,GROSS_WEIGHT,SELLING_PRICE,COST_PRICE from INVENTORY where BARCODE='"+barcode+"'",table7);      
     
      cp=Double.valueOf((String)SqlLogin.data.get(0).get(8));
      System.out.println(SqlLogin.data);
     arrdata.add(SqlLogin.data.get(0));
   System.out.println(arrdata);
    for(int k=0;k<arrdata.size();k++)
    {
         s=s+Double.valueOf((String) arrdata.get(k).get(9));
     }
    String val;
     val=String.valueOf(s);
     InvTotal.setText(val);
     System.out.println("yo yo yo");
   System.out.println(arrdata);
      table7.setEditable(true);
     table7.setItems(arrdata);
      
      //table7.setVisible(true);
      InvoiceBarcode.clear();
   }
     @FXML
    private void handleDeleteSelectedItem(ActionEvent event) throws SQLException{
       
            
    //data.remove(index.get());
             //   table.getSelectionModel().clearSelection();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        org.jsoup.nodes.Document doc = null;
        
        try {
            doc = Jsoup.connect("http://www.goldpriceindia.com/gold-price-hyderabad.php").get();
        } catch (IOException ex) {
            Logger.getLogger(Invoice1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        // System.out.println(doc.text());
        org.jsoup.select.Elements price;
        price = doc.getElementsByClass("prc");
        String prices = price.get(0).text();
        System.out.println(prices);
        GoldRate.setVisible(true);
        GoldRate.setText("Rs: " + prices+" /10gms");
        
       //  org.jsoup.nodes.Document doc = null;
        
        try {
            doc = Jsoup.connect("http://www.goldpriceindia.com/silver-price-india.php").get();
        } catch (IOException ex) {
            Logger.getLogger(Invoice1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        // System.out.println(doc.text());
        //org.jsoup.select.Elements price;
        price = doc.getElementsByClass("prc");
        String prices1 = price.get(0).text();
        System.out.println(prices1);
        SilverRate.setVisible(true);
        SilverRate.setText("Rs: " + prices1+" /Kg");
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
         table7.setEditable(true);
      if(!table7.getColumns().isEmpty())
        table7.getColumns().clear();
      String colName = null;
        for(int i=0;i<9;++i){
                    final int j=i;
                    if(i==0)
                        colName="ID";
                    else if(i==1)
                        colName="Barcode";
                    else if(i==2)
                        colName="Type";
                    else if(i==3)
                        colName="Material";
                    else if(i==4)
                        colName="DesignName";
                    else if(i==5)
                        colName="Purity";
                    else if(i==6)
                        colName="NetWeight";
                    else if(i==7)
                        colName="GrossWeight";
                    else if(i==8)
                        colName="Price";
                    
                    TableColumn col=new TableColumn(colName);
                    col.setMinWidth(100);
                    col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                        public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {                                                                                              
                            return new SimpleStringProperty(param.getValue().get(j).toString());                        
                        }                    
                    });
      
      table7.getColumns().addAll(col);
      
        }
         indexProperty().addListener(new ChangeListener() {

            @Override
            public void changed(ObservableValue o, Object oldVal,
                    Object newVal) {
                System.out.println("Index has changed!");
            }
        });
         
         
        table7.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {

            @Override
            public void changed(ObservableValue observable, Object oldvalue, Object newValue) {
               // Person selectedPerson = (Person) newValue;
                setIndex(arrdata.indexOf(newValue));

                System.out.println("OK");
                
            }
        });
         DelSelectedItem.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent e) {

                arrdata.remove(index.get());
                table7.getSelectionModel().clearSelection();

            }
        });
      
      
        
        
        
        // TODO
    }    

    @FXML
    private void handleInvConfirm(ActionEvent event) throws SQLException {
        //System.out.println(arrdata.size());
        LocalDate invdate=InvDate.getValue();
     int invcusid = Integer.parseInt(InvCusID.getText());
        int lendata;
        String barcode;
        lendata=arrdata.size();
        for(int i=0;i<lendata;i++){
            barcode=(String) arrdata.get(i).get(1);
            String type=(String) arrdata.get(i).get(2);
            String material=(String) arrdata.get(i).get(3);
            String designname=(String) arrdata.get(i).get(4);
           float purity= Float.valueOf((String) arrdata.get(i).get(5));
           float netweight= Float.valueOf((String) arrdata.get(i).get(6));
           float grossweight= Float.valueOf((String) arrdata.get(i).get(7));
         
           Double sellingprice=Double.valueOf((String) arrdata.get(i).get(9));
           Double profit;
           profit=sellingprice-cp;
       //  SqlLogin.executeUpdate("DELETE from INVENTORY where BARCODE='"+barcode+"'"); 
           SqlLogin.executeUpdate("UPDATE INV_STATISTICS SET QUANTITY=QUANTITY-1 WHERE TYPE='"+type+"' AND MATERIAL='"+material+"' AND DESIGN_NAME='"+designname+"' ");
           SqlLogin.executeUpdate(" Insert into SOLD_ITEMS " + "Values( NULL, '"+barcode+"','"+invcusid+"','"+invdate+"','TR12BG3445','"+type+"','"+material+"','"+designname+"','"+purity+"','"+netweight+"','"+grossweight+"','"+sellingprice+"','"+profit+"')" );
           //  SqlLogin.executeUpdate("UPDATE INV_STATISTICS SET SALES=SALES+1  WHERE TYPE='"+type+"' AND MATERIAL='"+material+"' AND DESIGN_NAME='"+designname+"' ");
          // SqlLogin.executeUpdate("UPDATE INV_STATISTICS SET TOTAL_REVENUE=TOTAL_REVENUE+"+sellingprice+" and PROFIT=PROFIT+"+profit+" WHERE TYPE='"+type+"' AND MATERIAL='"+material+"' AND DESIGN_NAME='"+designname+"' ");
          // SqlLogin.executeUpdate("UPDATE INV_STATISTICS SET PROFIT=PROFIT+"+profit+" WHERE TYPE='"+type+"' AND MATERIAL='"+material+"' AND DESIGN_NAME='"+designname+"' ");

//SqlLogin.executeUpdate()
              // SqlLogin.executeUpdate("UPDATE SOLD_STATISTICS SET QUANTITY=QUANTITY-1 WHERE TYPE='"+type+"' AND MATERIAL='"+material+"' AND DESIGN_NAME='"+designname+"' ");
      
               SqlLogin.executeNewContent("Select * from SOLD_STATISTICS WHERE TYPE='"+type+"' and MATERIAL='"+material+"' AND DATE='"+invdate+"' ");
    if(SqlLogin.data.size()==0)
    {
    System.out.println("No elements inside");
    SqlLogin.executeUpdate("INSERT INTO SOLD_STATISTICS VALUES(NULL,'"+invdate+"','"+type+"','"+material+"',1,'"+sellingprice+"','"+profit+"')");
    }
    else
    {       
      SqlLogin.executeUpdate("UPDATE SOLD_STATISTICS SET NO_OF_SALES=NO_OF_SALES+1 WHERE TYPE='"+type+"' AND MATERIAL='"+material+"' AND DATE='"+invdate+"'   ");
       SqlLogin.executeUpdate("UPDATE SOLD_STATISTICS SET TOTAL_REVENUE=TOTAL_REVENUE+"+sellingprice+" WHERE TYPE='"+type+"' AND MATERIAL='"+material+"' AND DATE='"+invdate+"'  ");
        SqlLogin.executeUpdate("UPDATE SOLD_STATISTICS SET PROFIT=PROFIT+"+profit+" WHERE TYPE='"+type+"' AND MATERIAL='"+material+"' AND DATE='"+invdate+"'  ");
        System.out.println("helloWorld!!!!!!!!!!!!!!!");
        System.out.println("It works cool");
              
        
    }
        
        } 
        
        System.out.println("Got It!!!");
    }

    @FXML
    private void handleInvCancel(ActionEvent event) {
    }

    

    @FXML
    private void handleInvAddCustomer(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLAddCustomer.fxml"));
        stage.setTitle("Add new entry");
        stage.setScene(new Scene(root, 800, 600));
        stage.show();
        
    }

    @FXML
    private void handleSalesOverView(MouseEvent event) throws IOException {
       Parent home_page_parent = FXMLLoader.load(getClass().getResource("OverView1.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    


    @FXML
    private void handleSalesSoldItems(MouseEvent event) throws IOException {
       Parent home_page_parent = FXMLLoader.load(getClass().getResource("SoldItems1.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
      //  app_stage.hide();
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
    
}
