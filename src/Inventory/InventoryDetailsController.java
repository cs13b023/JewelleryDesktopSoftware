/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory;

import javafx.animation.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
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
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author vinay kumar reddy
 */
public class InventoryDetailsController implements Initializable {

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
    private TextField InvDetails;
    @FXML
    private TextField InvWholeSaler;
    @FXML
    private TextField InvOverView;
    @FXML
    private Label RootLabel;
    @FXML
    private TilePane ItemsTilePane;
    @FXML
    private TableView InvTable;
    @FXML
    private TextField InvSearchAnything;
    @FXML
    private Button InvDelSelectedItem;
    @FXML
    private DatePicker InvSearchDate;
    @FXML
    private TilePane MainTilePane;
    @FXML
    private Pane RootPane;
    @FXML
    private ImageView ItemImage;
    @FXML
    private Label XL1;
    @FXML
    private Label YL1;
    @FXML
    private Label YL2;
    @FXML
    private Label XL2;
    @FXML
    private Label XL5;
    @FXML
    private Label YL5;
    @FXML
    private Label YL4;
    @FXML
    private Label XL4;
    @FXML
    private Label YL3;
    @FXML
    private Label XL7;
    @FXML
    private Label YL7;
    @FXML
    private Label YL6;
    @FXML
    private Label XL6;
    @FXML
    private PieChart PC1;
    @FXML
    private PieChart PC2;
    @FXML
    private PieChart PC3;
    @FXML
    private Label AL1;
    @FXML
    private Label TL1;
    @FXML
    private Label AL2;
    @FXML
    private Label TL2;
    @FXML
    private Label AL3;
    @FXML
    private Label TL3;
    @FXML
    private Label XL3;
    @FXML
    private TextField InvAddNew;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            /*  XL1.setText("Total Items:");
            XL2.setText("Total Metal Wt:");
            XL3.setText("Total Value(Today's Rate):");
            XL4.setText("Average Profit %:");
            XL5.setText("Weekly Demand:");
            XL6.setText("Weekly Revenue:");
            XL7.setText("Weekly Profit:");
            XL1.setVisible(true);
            XL2.setVisible(true);
            XL3.setVisible(true);
            XL4.setVisible(true);
            XL5.setVisible(true);
            XL6.setVisible(true);
            XL7.setVisible(true);
            */
            rootfun();
        } catch (SQLException ex) {
            Logger.getLogger(InventoryDetailsController.class.getName()).log(Level.SEVERE, null, ex);
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
    private void handleInventory(MouseEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("InventoryOverView.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       // app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    private void handleLoanClick(MouseEvent event) {
    }

    @FXML
    private void handleloyalty(MouseEvent event) {
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
    private void handleRootClicked(MouseEvent event) throws SQLException {
      
       
         rootfun();
    
    }
    public void  searchimplementation( LocalDate datetest) throws SQLException
    {
        
        String temp1=TL1.getText();
         String temp2=TL2.getText();
         String temp3=TL3.getText();
         String query;
         System.out.println(TL1.getText());
         System.out.println("got the bug");
        InvTable.getColumns().clear();
      InvTable.setEditable(true);
      String searchtype=InvSearchAnything.getText();
      if(!InvTable.getColumns().isEmpty())
        InvTable.getColumns().clear();
        if(datetest==null){
                if(temp1=="" || temp1==null)
                {   
                 query="select * from INVENTORY WHERE (TYPE LIKE '%"+searchtype+"%' OR DESIGN_NAME LIKE '%"+searchtype+"%' OR BARCODE LIKE '%"+searchtype+"%'  OR WHOLESALER_NAME LIKE '%"+searchtype+"%') "; 

                 System.out.println("hello world");
                }
                else if(temp2=="" || temp2==null)
                {
                     query="select * from INVENTORY WHERE MATERIAL='"+temp1+"' AND (TYPE LIKE '%"+searchtype+"%' OR DESIGN_NAME LIKE '%"+searchtype+"%' OR BARCODE LIKE '%"+searchtype+"%' OR WHOLESALER_NAME LIKE '%"+searchtype+"%') "; 
                }
                else if(temp3=="" || temp3==null)
                {
                     query="select * from INVENTORY WHERE MATERIAL='"+temp1+"' and type='"+temp2+"' AND (DESIGN_NAME LIKE '%"+searchtype+"%' OR BARCODE LIKE '%"+searchtype+"%' OR WHOLESALER_NAME LIKE '%"+searchtype+"%') ";
                }
                else
                {
                     query="select * from INVENTORY WHERE MATERIAL='"+temp1+"' and type='"+temp2+"' and design_name ='"+temp3+"' AND (DESIGN_NAME LIKE '%"+searchtype+"%' OR BARCODE LIKE '%"+searchtype+"%' OR WHOLESALER_NAME LIKE '%"+searchtype+"%') ";
                }
        }
        else
        {
            if(temp1=="" || temp1==null )
                {   
                 query="select * from INVENTORY WHERE DATE_OF_PURCHASE LIKE '"+datetest+"' (TYPE LIKE '%"+searchtype+"%' OR DESIGN_NAME LIKE '%"+searchtype+"%' OR BARCODE LIKE '%"+searchtype+"%'  OR WHOLESALER_NAME LIKE '%"+searchtype+"%') "; 

                 System.out.println("hello world");
                }
                else if(temp2=="" || temp2==null)
                {
                     query="select * from INVENTORY WHERE MATERIAL='"+temp1+"' AND DATE_OF_PURCHASE LIKE '"+datetest+"' AND (TYPE LIKE '%"+searchtype+"%' OR DESIGN_NAME LIKE '%"+searchtype+"%' OR BARCODE LIKE '%"+searchtype+"%' OR WHOLESALER_NAME LIKE '%"+searchtype+"%') "; 
                }
                else if(temp3=="" || temp3==null)
                {
                     query="select * from INVENTORY WHERE MATERIAL='"+temp1+"' and type='"+temp2+"' AND DATE_OF_PURCHASE LIKE '"+datetest+"' AND (DESIGN_NAME LIKE '%"+searchtype+"%' OR BARCODE LIKE '%"+searchtype+"%' OR WHOLESALER_NAME LIKE '%"+searchtype+"%') ";
                }
                else
                {
                     query="select * from INVENTORY WHERE MATERIAL='"+temp1+"' and type='"+temp2+"' and design_name ='"+temp3+"' AND DATE_OF_PURCHASE LIKE '"+datetest+"' AND (DESIGN_NAME LIKE '%"+searchtype+"%' OR BARCODE LIKE '%"+searchtype+"%' OR WHOLESALER_NAME LIKE '%"+searchtype+"%') ";
                }
            
            
            
        }
   
           
           
           SqlLogin.executeQuery(query,InvTable);
      
      InvTable.setItems(SqlLogin.data);
        
    }

    @FXML
    private void handleSearchAnything(KeyEvent event) throws SQLException {
        
    searchimplementation(null);
    }

    @FXML
    private void handleInvDeleteSelectedItem(ActionEvent event) {
    }

    @FXML
    private void handleInvSearchDate(ActionEvent event) throws SQLException {

      LocalDate date=InvSearchDate.getValue();
      if(!InvTable.getColumns().isEmpty())
        InvTable.getColumns().clear();
      if(date==null)
      {
        searchimplementation(null);
      }
      else
      {
           searchimplementation(date);
     // SqlLogin.executeQuery("select * from INVENTORY WHERE DATE_OF_PURCHASE LIKE '"+date+"'",InvTable);      
      }
   
    }

    
 
     public void tileDisplay1(String Query) throws SQLException{
         SqlLogin.executeNewContent(Query);
            System.out.println(Query);
             System.out.println(SqlLogin.data);
         ObservableList<ObservableList> data;
         data=SqlLogin.data;
         ItemsTilePane.getChildren().clear();
        ItemsTilePane.setHgap(10);
        ItemsTilePane.setVgap(10);
       System.out.println(data);
       System.out.println("inside td!");
        String name;
        try{
        for(int i=0;i<data.size();++i){
            VBox empTile=new VBox();
            int wstestid=Integer.valueOf((String)data.get(i).get(0));
            empTile.setId(String.valueOf(i));
            
          empTile.setOnMouseClicked(new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                    AL1.setText(">");
                    AL1.setVisible(true);
                    int val=Integer.parseInt(empTile.getId());
                    
                    TL1.setText((String)data.get(val).get(1));
                    TL1.setVisible(true);
                   // parameters.setvalue(empTile.getId());
     //             
                    try {
                        matfun();
                        tileDisplay2("select ID,TYPE from INV_TYPE");
                    } catch (SQLException ex) {
                        Logger.getLogger(InventoryDetailsController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
        });
            
            
            
            HBox descTile=new HBox();
            VBox desc = new VBox();
            Label matname=new Label();
            matname.setStyle("-fx-text-fill:red; -fx-font-size: 20px;");
            String mname=(String)data.get(i).get(1);
            matname.setText(mname);
            
           
            if(true){
             
                desc.getChildren().add(matname);
               //
               descTile.getChildren().add(desc);
                //empTile.applyCss();
                empTile.getChildren().add(descTile);
                ItemsTilePane.getChildren().add(empTile);
                System.out.println(ItemsTilePane.getChildren().size());
                
            }
            System.out.println("Dont Know!");
            }
            
        }
        catch(Exception e){
                System.out.println(e);
                System.out.println("shit!");
            }
        
    }
     
     public void tileDisplay2(String Query) throws SQLException{
          SqlLogin.executeNewContent(Query);
            System.out.println(Query);
             System.out.println(SqlLogin.data);
         ObservableList<ObservableList> data;
         data=SqlLogin.data;         
         ItemsTilePane.getChildren().clear();
        ItemsTilePane.setHgap(7);
        ItemsTilePane.setVgap(7);
       System.out.println(data);
       System.out.println("inside td!");
        String name;
        try{
        for(int i=0;i<data.size();++i){
            VBox empTile=new VBox();
            int wstestid=Integer.valueOf((String)data.get(i).get(0));
            empTile.setId(String.valueOf(i));
            
          empTile.setOnMouseClicked(new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                    AL2.setText(">");
                    AL2.setVisible(true);
                    int val=Integer.parseInt(empTile.getId());
                    
                    TL2.setText((String)data.get(val).get(1));
                    TL2.setVisible(true);
                   // parameters.setvalue(empTile.getId());
     //             
                    try {
                        typefun();
                        String temp1=TL1.getText();
                        String temp2=TL2.getText();
                        tileDisplay3("select ID,DESIGN_NAME from INV_STATISTICS where material='"+temp1+"' and type='"+temp2+"' ");
                    } catch (SQLException ex) {
                        Logger.getLogger(InventoryDetailsController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
        });
            
            
            
            HBox descTile=new HBox();
            VBox desc = new VBox();
            Label typename=new Label();
            typename.setStyle("-fx-text-fill:red; -fx-font-size: 20px;");
            String mname=(String)data.get(i).get(1);
            typename.setText(mname);
            
           
            if(true){
             
                desc.getChildren().add(typename);
               //
               descTile.getChildren().add(desc);
                //empTile.applyCss();
                empTile.getChildren().add(descTile);
                ItemsTilePane.getChildren().add(empTile);
                System.out.println(ItemsTilePane.getChildren().size());
                
            }
            System.out.println("Dont Know!");
            }
            
        }
        catch(Exception e){
                System.out.println(e);
                System.out.println("shit!");
            }
        
    }
     public void tileDisplay3(String Query) throws SQLException
    {
         SqlLogin.executeNewContent(Query);
            System.out.println(Query);
             System.out.println(SqlLogin.data);
         ObservableList<ObservableList> data;
         data=SqlLogin.data;         
         ItemsTilePane.getChildren().clear();
        ItemsTilePane.setHgap(7);
        ItemsTilePane.setVgap(7);
       System.out.println(data);
       System.out.println("inside td!");
        String name;
        try{
        for(int i=0;i<data.size();++i){
            VBox empTile=new VBox();
            int wstestid=Integer.valueOf((String)data.get(i).get(0));
            empTile.setId(String.valueOf(i));
            
          empTile.setOnMouseClicked(new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                    AL3.setText(">");
                    AL3.setVisible(true);
                    //TL3.setVisible(true);
                    int val=Integer.parseInt(empTile.getId());
                    
                    TL3.setText((String)data.get(val).get(1));
                    TL3.setVisible(true);
                    try {
                        // parameters.setvalue(empTile.getId());
                        designhandler();
                    } catch (SQLException ex) {
                        Logger.getLogger(InventoryDetailsController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   
                }
        });
            
            
            
            HBox descTile=new HBox();
            VBox desc = new VBox();
            Label typename=new Label();
            typename.setStyle("-fx-text-fill:red; -fx-font-size: 20px;");
            String mname=(String)data.get(i).get(1);
            typename.setText(mname);
            
           
            if(true){
             
                desc.getChildren().add(typename);
               //
               descTile.getChildren().add(desc);
                //empTile.applyCss();
                empTile.getChildren().add(descTile);
                ItemsTilePane.getChildren().add(empTile);
                System.out.println(ItemsTilePane.getChildren().size());
                
            }
            System.out.println("Dont Know!");
            }
            
        }
        catch(Exception e){
                System.out.println(e);
                System.out.println("shit!");
            }
    }
     
     
     
     public void designhandler() throws SQLException
    {
        ItemsTilePane.getChildren().clear();
        
    }
     
    public void refresh(String Query) throws SQLException
    {
        //emp.getChildren().clear();
      /*  String MatName;
        
         System.out.println("Inside refresh!!");
            SqlLogin.executeNewContent(Query);
            System.out.println(Query);
             System.out.println(SqlLogin.data);
        //tileDisplay1(SqlLogin.data);
            */
    }
    public void rootfun() throws SQLException
    {
        tileDisplay1("select ID,MATERIAL from INV_MAT");
        
      InvTable.setEditable(true);
      
      if(!InvTable.getColumns().isEmpty())
        InvTable.getColumns().clear();
      SqlLogin.executeQuery("select * from INVENTORY",InvTable);
          
      InvTable.setItems(SqlLogin.data);
        
      
          AL1.setVisible(false);
          TL1.setVisible(false);
          AL2.setVisible(false);
          TL2.setVisible(false);
          AL3.setVisible(false);
          TL3.setVisible(false);
        PC1.setData(InventoryPieGraphController.getChartData("select MATERIAL,SUM(QUANTITY) from INV_STATISTICS group by MATERIAL"));
       
        PC2.setData(InventoryPieGraphController.getSpecialChartData("select MATERIAL,SUM(profit) from SOLD_STATISTICS group by MATERIAL"));
         PC3.setData(InventoryPieGraphController.getChartData("select MATERIAL,SUM(NO_OF_SALES) from SOLD_STATISTICS group by MATERIAL"));
         //SqlLogin.executeNewContent("Select photo from inv_mat where material='gold'");
         //Image goldimg=(Image)SqlLogin.data.get(0).get(0);
         //ItemImage.setImage(goldimg);
          File file = new File("E:/Jewellery/Stock.png");
         //System.out.println((String)SqlLogin.data.get(0).get(0));
         Image abc = new Image(file.toURI().toString());
         //Image abc = new Image((String)SqlLogin.data.get(0).get(0));
        ItemImage.setImage(abc);
        
      //  particulars("root");
      
        
        SqlLogin.executeNewContent("Select sum(quantity) from INV_STATISTICS");
        String TotItems=(String)SqlLogin.data.get(0).get(0);
        YL1.setText(TotItems);
        
        SqlLogin.executeNewContent("Select sum(net_weight) from INVENTORY");
        String TotMetalWt=(String)SqlLogin.data.get(0).get(0);
        double tmw=Double.parseDouble(TotMetalWt);
        double kgtmw=tmw/1000;
        float kgtmw1=(float) kgtmw;
        YL2.setText(String.valueOf(kgtmw1)+"Kg");
        
        double gvalue=3000.0;
        double tvalue;
        tvalue=(gvalue*tmw);
        int tempval=(int) tvalue;
        YL3.setText("Rs: "+String.valueOf(tempval));
        
        SqlLogin.executeNewContent("Select sum(profit) from SOLD_STAT_DAY");
        String TotProfit=(String)SqlLogin.data.get(0).get(0);
        System.out.println(NumberFormat.getNumberInstance(Locale.US).format(35634646));
        ///System.out.println("dragions");
        YL4.setText(TotProfit);
        
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        int weekdayno=c.get(Calendar.DAY_OF_WEEK);
           
       DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
         Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -(weekdayno-2));
        Date date2 = cal.getTime();    
        String d2 = dateFormat.format(date2);
        LocalDate d1=LocalDate.now();
        System.out.println(d2);
          System.out.println(d1);
          SqlLogin.executeNewContent("Select sum(NO_OF_SALES),sum(Total_revenue),sum(profit) from SOLD_STAT_DAY where date between '"+d2+"' and '"+d1+"'");
          String WeeklyDemand=(String)SqlLogin.data.get(0).get(0);
        YL5.setText(WeeklyDemand+" Items");
        
         
          String WeeklyRevenue=(String)SqlLogin.data.get(0).get(1);
        YL6.setText("Rs: "+WeeklyRevenue);
        
         
          String WeeklyProfit=(String)SqlLogin.data.get(0).get(2);
        YL7.setText("Rs: "+WeeklyProfit);
        
      
      
      
      
      
        
        
       
        
    }
    public void particulars(String varname) throws SQLException
    {
      
        
    }
    public void matfun() throws SQLException
    {
         String temp1=TL1.getText();
         
         InvTable.setEditable(true);
      
      if(!InvTable.getColumns().isEmpty())
        InvTable.getColumns().clear();
        SqlLogin.executeQuery("select * from INVENTORY where material='"+temp1+"'",InvTable);
          
      InvTable.setItems(SqlLogin.data);
        
      
         
          PC1.setData(InventoryPieGraphController.getChartData("select type,sum(quantity) as quan from (select type ,(quantity) from inv_statistics where material='"+temp1+"')as temp group by type;"));
         PC2.setData(InventoryPieGraphController.getSpecialChartData("select type,SUM(profit) from SOLD_STATISTICS WHERE MATERIAL='"+temp1+"' group by type;"));
         PC3.setData(InventoryPieGraphController.getChartData("select type,SUM(NO_OF_SALES) from SOLD_STATISTICS WHERE MATERIAL='"+temp1+"' group by type;"));
         SqlLogin.executeNewContent("Select photo from inv_mat where material='"+temp1+"'");        
          File file = new File((String)SqlLogin.data.get(0).get(0));
         Image abc = new Image(file.toURI().toString());
         //Image abc = new Image((String)SqlLogin.data.get(0).get(0));
        ItemImage.setImage(abc);
        
       // particulars("material");
        
          
        SqlLogin.executeNewContent("Select sum(quantity) from inv_statistics where material='"+temp1+"'");
        String TotItems=(String)SqlLogin.data.get(0).get(0);
        if(TotItems!="null")
            YL1.setText(TotItems);
        else
            YL1.setText("0");
        SqlLogin.executeNewContent("Select sum(net_weight) from inventory where material='"+temp1+"'");
        String TotMetalWt=(String)SqlLogin.data.get(0).get(0);
        if(TotMetalWt!="null")
        {
            double tmw=Double.parseDouble(TotMetalWt);
            double kgtmw=tmw/1000;
            float kgtmw1=(float) kgtmw;
            YL2.setText(String.valueOf(kgtmw1)+"Kg");

            double gvalue=3000.0;
            double tvalue;
            tvalue=(gvalue*tmw);
            int tempval=(int) tvalue;
            YL3.setText("Rs: "+String.valueOf(tvalue));
        }
        else
        {
            YL2.setText("0 Kg");
            YL3.setText("Rs: 0.0");
        }

        SqlLogin.executeNewContent("Select sum(profit) from sold_statistics where material='"+temp1+"'");
        String TotProfit=(String)SqlLogin.data.get(0).get(0);
        if(TotProfit!="null")
            YL4.setText(TotProfit);
        else
            YL4.setText("0");
        
      
        
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        int weekdayno=c.get(Calendar.DAY_OF_WEEK);
           
       DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
         Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -(weekdayno-2));
        Date date2 = cal.getTime();    
        String d2 = dateFormat.format(date2);
        LocalDate d1=LocalDate.now();
        System.out.println(d2);
          System.out.println(d1);
          SqlLogin.executeNewContent("Select sum(NO_OF_SALES),sum(Total_revenue),sum(profit) from sold_statistics where date between '"+d2+"' and '"+d1+"'and material='"+temp1+"'");
          String WeeklyDemand=(String)SqlLogin.data.get(0).get(0);
       if(WeeklyDemand=="null")
          {
              YL5.setText("0 Items");
          }
          else
          {
            YL5.setText(WeeklyDemand+" Items");
          }
         
          String WeeklyRevenue=(String)SqlLogin.data.get(0).get(1);
          if(WeeklyRevenue=="null")
          {
              YL6.setText("0 Items");
          }
          else
          {
            YL6.setText(WeeklyRevenue+" Items");
          }
        
         
          String WeeklyProfit=(String)SqlLogin.data.get(0).get(2);
          if(WeeklyProfit=="null")
          {
              YL7.setText("0 Items");
          }
          else
          {
            YL7.setText(WeeklyProfit+" Items");
          }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
    
    public void typefun() throws SQLException
    {
         String temp1=TL1.getText();
         String temp2=TL2.getText();
         
          InvTable.setEditable(true);
      
      if(!InvTable.getColumns().isEmpty())
        InvTable.getColumns().clear();
       SqlLogin.executeQuery("select * from INVENTORY where material='"+temp1+"' and type='"+temp2+"'",InvTable);
          
      InvTable.setItems(SqlLogin.data);
        
         
         
         
         
         PC1.setData(InventoryPieGraphController.getChartData("select design_name,sum(quantity) from inv_statistics where material='"+temp1+"' and type='"+temp2+"' group by design_name;"));
         PC2.setData(InventoryPieGraphController.getSpecialChartData("select design_name,SUM(profit) from inv_STATISTICS where material='"+temp1+"' and type='"+temp2+"' group by design_name;"));
         PC3.setData(InventoryPieGraphController.getChartData("select design_name,SUM(sales) from inv_STATISTICS where material='"+temp1+"' and type='"+temp2+"' group by design_name;"));
         SqlLogin.executeNewContent("Select photo from inv_type where type='"+temp2+"'");        
          File file = new File((String)SqlLogin.data.get(0).get(0));
         Image abc = new Image(file.toURI().toString());
         //Image abc = new Image((String)SqlLogin.data.get(0).get(0));
        ItemImage.setImage(abc);
        
    //   particulars("type");
       
         
        SqlLogin.executeNewContent("Select sum(quantity) from inv_statistics  where material='"+temp1+"' and type='"+temp2+"' ");
        String TotItems=(String)SqlLogin.data.get(0).get(0);
        if(TotItems!=null)
            YL1.setText(TotItems);
        else
            YL1.setText("0");
        SqlLogin.executeNewContent("Select sum(net_weight) from inventory  where material='"+temp1+"' and type='"+temp2+"' ");
        String TotMetalWt=(String)SqlLogin.data.get(0).get(0);
       
        if(TotMetalWt=="null")
        {
            YL2.setText("0 Kg");
            YL3.setText("Rs: 0.0");
            
        }
        else
        {
            
            
            double tmw=Double.parseDouble(TotMetalWt);
            double kgtmw=tmw/1000;
            float kgtmw1=(float) kgtmw;
            YL2.setText(String.valueOf(kgtmw1)+"Kg");

            double gvalue=3000.0;
            double tvalue;
            tvalue=(gvalue*tmw);
            int tempval=(int) tvalue;
            YL3.setText("Rs: "+String.valueOf(tempval));
                    
        }
        
        SqlLogin.executeNewContent("Select sum(profit) from sold_statistics  where material='"+temp1+"' and type='"+temp2+"' ");
        String TotProfit=(String)SqlLogin.data.get(0).get(0);
        if(TotProfit!="null")
           YL4.setText(TotProfit);
        else
            YL4.setText("0.0");
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        int weekdayno=c.get(Calendar.DAY_OF_WEEK);
           
       DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
         Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -(weekdayno-2));
        Date date2 = cal.getTime();    
        String d2 = dateFormat.format(date2);
        LocalDate d1=LocalDate.now();
        System.out.println(d2);
          System.out.println(d1);
          SqlLogin.executeNewContent("Select sum(NO_OF_SALES),sum(Total_revenue),sum(profit) from sold_statistics where date between '"+d2+"' and '"+d1+"' and material='"+temp1+"' and type='"+temp2+"' ");
          String WeeklyDemand=(String)SqlLogin.data.get(0).get(0);
          if(WeeklyDemand=="null")
          {
              YL5.setText("0 Items");
          }
          else
          {
            YL5.setText(WeeklyDemand+" Items");
          }
         
          String WeeklyRevenue=(String)SqlLogin.data.get(0).get(1);
          if(WeeklyRevenue=="null")
          {
              YL6.setText("0 Items");
          }
          else
          {
            YL6.setText(WeeklyRevenue+" Items");
          }
        
         
          String WeeklyProfit=(String)SqlLogin.data.get(0).get(2);
          if(WeeklyProfit=="null")
          {
              YL7.setText("0 Items");
          }
          else
          {
            YL7.setText(WeeklyProfit+" Items");
          }
        
       
       
       
       
       
        
    }
    
    public void designfun() throws SQLException
    {
         String temp1=TL1.getText();
         String temp2=TL2.getText();
         String temp3=TL3.getText();
         
          InvTable.setEditable(true);
      
      if(!InvTable.getColumns().isEmpty())
        InvTable.getColumns().clear();
       SqlLogin.executeQuery("select * from INVENTORY where material='"+temp1+"' and type='"+temp2+"'  and design_name='"+temp3+"'",InvTable);
          
      InvTable.setItems(SqlLogin.data);
        
         
         
         
         
         //PC1.setData(InventoryPieGraphController.getChartData("select type,sum(quantity) as quan from (select type ,(quantity) from inv_statistics where material='"+temp1+"')as temp group by type;"));
         //PC2.setData(InventoryPieGraphController.getChartData("select MATERIAL,SUM(profit) from SOLD_STATISTICS group by MATERIAL"));
         //PC3.setData(InventoryPieGraphController.getChartData("select MATERIAL,SUM(NO_OF_SALES) from SOLD_STATISTICS group by MATERIAL"));
         /*SqlLogin.executeNewContent("Select photo from inv_type where type='"+temp2+"'");        
          File file = new File((String)SqlLogin.data.get(0).get(0));
         Image abc = new Image(file.toURI().toString());
         //Image abc = new Image((String)SqlLogin.data.get(0).get(0));
        ItemImage.setImage(abc);*/
        
     //  particulars("design");
       
       
         
        SqlLogin.executeNewContent("Select sum(quantity) from inv_statistics");
        String TotItems=(String)SqlLogin.data.get(0).get(0);
        if(TotItems!="null")
            YL1.setText(TotItems);
        else
            YL1.setText("0");
        SqlLogin.executeNewContent("Select sum(net_weight) from inventory");
        String TotMetalWt=(String)SqlLogin.data.get(0).get(0);
        if(TotMetalWt!="null")
        {
            double tmw=Double.parseDouble(TotMetalWt);
            double kgtmw=tmw/1000;
            float kgtmw1=(float) kgtmw;
            YL2.setText(String.valueOf(kgtmw1)+"Kg");

            double gvalue=3000.0;
            double tvalue;
            tvalue=(gvalue*tmw);
            int tempval=(int) tvalue;
            YL3.setText("Rs: "+String.valueOf(tvalue));
        }
        else
        {
        YL2.setText("0 Kg");
        YL3.setText("Rs: 0.0");
        
        }
        SqlLogin.executeNewContent("Select sum(profit) from sold_stat_day");
        String TotProfit=(String)SqlLogin.data.get(0).get(0);
        if(TotProfit!="null")
          YL4.setText(TotProfit);
        else
            YL4.setText("0.0");
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        int weekdayno=c.get(Calendar.DAY_OF_WEEK);
           
       DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
         Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -(weekdayno-2));
        Date date2 = cal.getTime();    
        String d2 = dateFormat.format(date2);
        LocalDate d1=LocalDate.now();
        System.out.println(d2);
          System.out.println(d1);
          SqlLogin.executeNewContent("Select sum(NO_OF_SALES),sum(Total_revenue),sum(profit) from sold_stat_day where date between '"+d2+"' and '"+d1+"'");
          String WeeklyDemand=(String)SqlLogin.data.get(0).get(0);
            if(WeeklyDemand=="null")
          {
              YL5.setText("0 Items");
          }
          else
          {
            YL5.setText(WeeklyDemand+" Items");
          }
         
          String WeeklyRevenue=(String)SqlLogin.data.get(0).get(1);
          if(WeeklyRevenue=="null")
          {
              YL6.setText("0 Items");
          }
          else
          {
            YL6.setText(WeeklyRevenue+" Items");
          }
        
         
          String WeeklyProfit=(String)SqlLogin.data.get(0).get(2);
          if(WeeklyProfit=="null")
          {
              YL7.setText("0 Items");
          }
          else
          {
            YL7.setText(WeeklyProfit+" Items");
          }
        
       
       
       
       
       
       
       
        
    }
    
    
    
    

    @FXML
    private void handleTL1(MouseEvent event) throws SQLException {
        
          AL2.setVisible(false);
          TL2.setVisible(false);
          AL3.setVisible(false);
          TL3.setVisible(false);
          tileDisplay2("select ID,TYPE from INV_TYPE");
          matfun();
        
      
    }

    @FXML
    private void handleTL2(MouseEvent event) throws SQLException {
         
          AL3.setVisible(false);
          TL3.setVisible(false);
           String temp1=TL1.getText();
           String temp2=TL2.getText();    
           tileDisplay3("select ID,DESIGN_NAME from INV_STATISTICS where material='"+temp1+"' and type='"+temp2+"' ");
    
           typefun();
    
    
    
    }
    
    

    @FXML
    private void handleTL3(MouseEvent event) throws SQLException {
        
        designfun();
        ItemsTilePane.getChildren().clear();
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
    private void handleOverView(MouseEvent event) throws IOException {
         Parent home_page_parent = FXMLLoader.load(getClass().getResource("InventoryOverView.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       // app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    private void handleInvAddNew(MouseEvent event) throws IOException {
         Parent home_page_parent = FXMLLoader.load(getClass().getResource("AddInventory.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       // app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
    
    
    
    
}
