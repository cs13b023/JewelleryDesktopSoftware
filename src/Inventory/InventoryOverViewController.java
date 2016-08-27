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
import java.util.Calendar;
import java.util.Date;
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
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author vinay kumar reddy
 */
public class InventoryOverViewController implements Initializable {

    @FXML
    private TextField Home;
    @FXML
    private TextField InvDetails;
    @FXML
    private TextField InvWholeSaler;
    @FXML
    private TextField InvOverView;
    @FXML
    private LineChart InvLineChart;
    @FXML
    private Button next;
    @FXML
    private Button Previous;
    @FXML
    private Label TotPieces;
    @FXML
    private Label Revenue;
    @FXML
    private Label Profit;
    @FXML
    private Button previous1;
    @FXML
    private Button next1;
    @FXML
    private Pane NotifyPane;
    @FXML
    private Button next2;
    @FXML
    private Button previous2;
    @FXML
    private BarChart BarChart1;
    @FXML
    private BarChart BarChart2;
    @FXML
    private NumberAxis NA1;
    @FXML
    private CategoryAxis CA1;
    @FXML
    private NumberAxis NA2;
    @FXML
    private CategoryAxis CA2;
    @FXML
    private NumberAxis NA3;
    @FXML
    private CategoryAxis CA3;
    @FXML
    private ImageView HSPImage;
    @FXML
    private Label Material;
    @FXML
    private Label DesignName;
    @FXML
    private Label Type;
     @FXML
    private ScrollPane ReStockSP;

    ObservableList<ObservableList> testdata;
    @FXML
    private TextField InvAddNew;
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
            // TODO
            testdata=FXCollections.observableArrayList();
            call1();
            
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            String d1 = dateFormat.format(date);
            // Calendar cal = Calendar.getInstance();
            // cal.add(Calendar.DATE, -7);
            //System.out.println("Date = "+ cal.get());
            System.out.println("hello everyone adhfgdgf");
            System.out.println(d1);
            
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, -15);
            Date date2 = cal.getTime();
            String d2 = dateFormat.format(date2);
            System.out.println(d2);
            try {
                InvInt.setvalue(1);
                SqlLogin.executeNewContent("select type,material,design_name,sum(no_of_sales) as totalsales,sum(total_revenue),sum(profit) as total from (select * from SOLD_STATISTICS where date between '"+d2+"' and '"+d1+"') as temp group by design_name,type,material order by totalsales desc limit 5");
            } catch (SQLException ex) {
                Logger.getLogger(InventoryOverViewController.class.getName()).log(Level.SEVERE, null, ex);
            }
            testdata=SqlLogin.data;
            /*
            try {
                hsphandler(1);
            } catch (SQLException ex) {
                Logger.getLogger(InventoryOverViewController.class.getName()).log(Level.SEVERE, null, ex);
            }*/
            System.out.println(testdata);
            
            
            
        try {
            SqlLogin.executeNewContent("select type,material,date_of_purchase,net_weight,gross_weight from INVENTORY order by date_of_purchase desc limit 3");
        } catch (SQLException ex) {
            Logger.getLogger(InventoryOverViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
            System.out.println(SqlLogin.data);
            System.out.println("inside td!");
            String name,name1,name2;
          // ReStockSP.setContent(null);
           // String name;
            VBox Names = new VBox();
            Names.setSpacing(10);
           
            for(int i=0;i<SqlLogin.data.size();++i){
               
                
                Pane pane = new Pane();
                pane.getStyleClass().add("Pane");
                HBox main=new HBox();
                 VBox left=new VBox();
                 //HBox right=new HBox();
                left.setPrefSize(150,50);
               // main.setPrefSize(200,50);
               // main.set
                //right.
                //main.setMinSize(200, 15);
                main.autosize();
               // main.getChildren().
                // main.setPrefWidth(500);
                Label Type = new Label();
                Type.setStyle("-fx-text-fill:black; -fx-font-size: 15px;");
                Type.setPrefSize(260,20);
                name1=(String)SqlLogin.data.get(i).get(0);
                 name2=(String)SqlLogin.data.get(i).get(1);
                 name=name2+"-"+name1;
                System.out.println(name);
                System.out.println("come on");
               // int ID = Integer.parseInt((String)SqlLogin.data.get(i).get(0));
                Type.setText(name);
                
              
                
                Label dt = new Label();
                dt.setStyle("-fx-text-fill:black; -fx-font-size: 15px;");
                dt.setPrefSize(260,20);
                name=(String)SqlLogin.data.get(i).get(2);
                System.out.println(name);
                System.out.println("come on");
               // int ID = Integer.parseInt((String)SqlLogin.data.get(i).get(0));
                dt.setText(name);
                
                 Label os = new Label();
                os.setStyle("-fx-text-fill:black; -fx-font-size: 15px;");
                dt.setPrefSize(260,20);
                name=(String)SqlLogin.data.get(i).get(3);
                System.out.println(name);
                System.out.println("come on");
               // int ID = Integer.parseInt((String)SqlLogin.data.get(i).get(0));
                os.setText(name);
                
                 Label ns = new Label();
                ns.setStyle("-fx-text-fill:black; -fx-font-size: 15px;");
                ns.setPrefSize(260,20);
                name=(String)SqlLogin.data.get(i).get(4);
                System.out.println(name);
                System.out.println("come on");
               // int ID = Integer.parseInt((String)SqlLogin.data.get(i).get(0));
                ns.setText(name);
                
                
                
                
                
                left.getChildren().addAll(Type,dt);
               // right.getChildren().addAll(os,ns);
                main.getChildren().addAll(left,os,ns);
                pane.getChildren().addAll(main);
                Names.getChildren().add(pane);
            }
            ReStockSP.setContent(Names);
            
            
            
            
            
            
            
            
            
            
            
       
        
        
        
        
        
        
        
        
        
        
    }    

    @FXML
    private void handleHome(MouseEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/mastersoftnew/Home.fxml"));
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
    private void handleAddInventory(MouseEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("AddInventory.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       // app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
        
    }

    @FXML
    private void handlenext(ActionEvent event) {
    int val=InvIDClass.getvalue();
    if(val==1)
    {
        call2();
    }
    else if(val==2)
    {
        call3();
    }
    
    
    
    
    
    }
       

    @FXML
    private void handlePrevious(ActionEvent event) {
        
    int val=InvIDClass.getvalue();
    if(val==2)
    {
        call1();
    }
    else if(val==3)
    {
        call2();
    }
        
        
        
    }

    @FXML
    private void handleprevious1(ActionEvent event) throws SQLException {
      int a= InvInt.getvalue();
      if(a>1)
      {
          a--;
          InvInt.setvalue(a);
      }
          hsphandler(a);
        
    }

    @FXML
    private void handlenext1(ActionEvent event) throws SQLException {
       int v= InvInt.getvalue();
       if(v<5)
       {
            v++;    
            InvInt.setvalue(v);
       }
       hsphandler(v);
        
    }
    public void hsphandler(int value) throws SQLException
    {
        
        String temp=(String)testdata.get(value-1).get(0);
       System.out.println(temp);
         Material.setText((String)testdata.get(value-1).get(1));
       Type.setText(temp);
       DesignName.setText((String)testdata.get(value-1).get(2));
       TotPieces.setText((String)testdata.get(value-1).get(3));
       Revenue.setText((String)testdata.get(value-1).get(4));
       Profit.setText((String)testdata.get(value-1).get(5));
       //SqlLogin.executeNewContent("Select photo from inv_type where type='"+temp+"'");    
       File file = new File("E:/Jewellery/Types/"+temp+".png");
         Image abc = new Image(file.toURI().toString());
         //Image abc = new Image((String)SqlLogin.data.get(0).get(0));
        HSPImage.setImage(abc);
       
       
    }

    @FXML
    private void handlenext2(ActionEvent event) {
    }

    @FXML
    private void handleprevious2(ActionEvent event) {
    }
    public void call2()
    {
        System.out.println("Inside2");
        InvIDClass.setvalue(2);
        BarChart1.setVisible(false);
        BarChart2.setVisible(false);
        InvLineChart.setVisible(true);
         InvLineChart.getData().clear();
        InvLineChart.getXAxis().setAutoRanging(true);
            InvLineChart.getYAxis().setAutoRanging(true);
            InvLineChart.setTitle("Type Statistics");
             CA1.setLabel("Type");       
        NA1.setLabel("Quantity");
 
          XYChart.Series series1 = new XYChart.Series<>();
          series1=SqlLogin.getChartData("select type,sum(quantity) as quan from (select type ,(quantity) from inv_statistics)as temp group by type;");
          series1.setName("Type");
            // SqlLogin.execute("select customerid,amonttaken from chitfundcustomerdetails");
            InvLineChart.getData().add(series1); 
            //InvLineChart.getData().add(series);
        
    }
    public void call1()
    {
        System.out.println("Inside1");
        InvIDClass.setvalue(1);
        
        BarChart1.setVisible(true);
        BarChart2.setVisible(false);
        InvLineChart.setVisible(false);
        BarChart1.getData().clear();
        BarChart1.setTitle("Type Statistics");
        
        // SalesBarChart.setStyle("-fx-text-fill:green; -fx-font-size: 20px;");
        CA2.setLabel("Type");       
        NA2.setLabel("Quantity");
 
       
       // BarChart1.getData().clear();
       // BarChart1.getData().add();
       XYChart.Series series1 = new XYChart.Series<>();
        series1=SqlLogin.getChartData("select type,sum(quantity) as quan from (select type ,(quantity) from INV_STATISTICS)as temp group by type;");
        series1.setName("Type");
        BarChart1.getData().add(series1);
         System.out.println(SqlLogin.data);
         System.out.println("worst!!!");
        
    }
    public void call3()
    {
        System.out.println("Inside3");
        InvIDClass.setvalue(3);
        BarChart1.setVisible(false);
        BarChart2.setVisible(false);
        InvLineChart.setVisible(true);
        InvLineChart.getData().clear();
        InvLineChart.getXAxis().setAutoRanging(true);
            InvLineChart.getYAxis().setAutoRanging(true);
            InvLineChart.setTitle("Gold&Silver Rates Statistics");
             CA1.setLabel("Day");       
        NA1.setLabel("Price in Rs:");
         XYChart.Series series1 = new XYChart.Series<>();
          XYChart.Series series2 = new XYChart.Series<>();
          
           String query1="select day,gold_rate from rates group by day";
          String query2="select day,silver_rate from rates group by day";
            series1=SqlLogin.getChartData(query1);
            series2=SqlLogin.getChartData(query2);
            series1.setName("GoldRate");
          series2.setName("SilverRate");
            InvLineChart.getData().addAll(series1,series2); 
           
    }

}
