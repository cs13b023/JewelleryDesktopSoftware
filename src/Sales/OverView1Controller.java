/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sales;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.chart.PieChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author vinay
 */
public class OverView1Controller implements Initializable {

    @FXML
    private TextField SalesOverView;
    @FXML
    private TextField SalesInvoice;
    @FXML
    private TextField SalesSoldItems;
    @FXML
    private Label DailyStatistics;
    @FXML
    private Label WeeklyStatistics;
    @FXML
    private Label MonthlyStatistics;
    @FXML
    private LineChart DailyLineChart;
    @FXML
    private ComboBox StatisticsMaterial;
    @FXML
    private ComboBox  StatisticsType;
    @FXML
    private Separator dseparator;
    @FXML
    private Separator wseparator;
    @FXML
    private Separator mseparator;
    @FXML
    private PieChart PieChartRevenue;
    @FXML
    private PieChart PieChartProfit;
    @FXML
    private DatePicker SalesFromDate;
    @FXML
    private DatePicker SalesToDate;
   // private StackedBarChart SalesStackedBarChart;
    @FXML
    private BarChart SalesBarChart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        StatisticsMaterial.getItems().clear();
         StatisticsMaterial.getItems().addAll("All","GOLD","SILVER","DIAMOND","Other");
       
         StatisticsMaterial.getSelectionModel().selectedItemProperty().addListener(new  
ChangeListener<String>() 
{
public void changed(ObservableValue<? extends String> observable,String  
oldValue,String newValue) 
{
    // DesignName.getItems().clear();
    System.out.println("Value is::"+newValue);
       InvStringClass.setvalue(newValue);
}   
});
         
         
      
      
      
      
      
      DailyLineChart.setVisible(false);
        //((Group) scene.getRoot()).getChildren().add(chart);
       // stage.setScene(scene);
       // stage.show();
         
         
         //DailyLineChart.setData(SalesLineGraphController.getChartData("select MATERIAL,count(*) from INVENTORY  group by MATERIAL"));
    }    

    @FXML
    private void handleSalesInvoice(MouseEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("Invoice1.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       // app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    private void handleSalesSoldItems(MouseEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("SoldItems1.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
    public void donothing()
    {
        
         ObservableList<PieChart.Data> piechartrevenue =
                FXCollections.observableArrayList(
                new PieChart.Data("Necklace", 13),
                new PieChart.Data("Ring", 25),
                new PieChart.Data("Bangles", 10),
                new PieChart.Data("chain", 22),
                new PieChart.Data("Bracelett", 30));
        final PieChart chart1 = new PieChart(piechartrevenue);
        String temp1=InvStringClass.getvalue();
        chart1.setTitle(temp1+" Total Revenue ");
         //chart1.setStyle("-fx-font: 24 arial;");
        
        PieChartRevenue.getData().clear();
      PieChartRevenue.setData(piechartrevenue);
      
      ObservableList<PieChart.Data> piechartprofit =
                FXCollections.observableArrayList(
                new PieChart.Data("Necklace", 17),
                new PieChart.Data("Ring", 17),
                new PieChart.Data("Bangles", 14),
                new PieChart.Data("chain", 18),
                new PieChart.Data("Bracelett", 34));
        final PieChart chart2 = new PieChart(piechartprofit);
        String temp2=InvStringClass.getvalue();
        chart2.setTitle(temp2+" Total Profit ");
       
        PieChartProfit.getData().clear();
      PieChartProfit.setData(piechartprofit);
        
        
        
        
        
    }
    @FXML
    private void handleDailyStatistics(MouseEvent event) {
       /* DailyLineChart.getXAxis().setAutoRanging(true);
        DailyLineChart.getYAxis().setAutoRanging(true);
        LocalDate fromdate=SalesFromDate.getValue();
        LocalDate todate=SalesToDate.getValue();
        

        DailyLineChart.getData().add(SalesLineGraphController.getChartData("select DATE,NO_OF_SALES FROM SOLD_STATISTICS WHERE DATE BETWEEN '"+fromdate+"' and '"+todate+"'","Daily"));
    */
       dseparator.setVisible(true);
        wseparator.setVisible(false);
         mseparator.setVisible(false);
       
       
           DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String d1 = dateFormat.format(date); 
       // Calendar cal = Calendar.getInstance();
   // cal.add(Calendar.DATE, -7);
    //System.out.println("Date = "+ cal.get());
    System.out.println("hello everyone adhfgdgf");
    
     Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        Date date2 = cal.getTime();    
        String d2 = dateFormat.format(date2);
        
        cal.add(Calendar.DATE, -1);
        Date date3 = cal.getTime();    
        String d3 = dateFormat.format(date3);
        
        cal.add(Calendar.DATE, -1);
        Date date4 = cal.getTime();    
        String d4 = dateFormat.format(date4);
        
        cal.add(Calendar.DATE, -1);
        Date date5 = cal.getTime();    
        String d5 = dateFormat.format(date5);
        
        cal.add(Calendar.DATE, -1);
        Date date6 = cal.getTime();    
        String d6 = dateFormat.format(date6);
        
        cal.add(Calendar.DATE, -1);
        Date date7 = cal.getTime();    
        String d7 = dateFormat.format(date7);
        
        
         
    
      /*  final String p1 = datestring;
    final String p2 = "May";
    final String p3 = "April";
    final String p4 = "March";
    final String p5 = "Febraury";
    final String p6 = "January";*/

         
        //stage.setTitle("Statistics");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
       //final BarChart<String,Number> bc = 
            //new BarChart<>(xAxis,yAxis);
            String temp1=InvStringClass.getvalue();
       
        SalesBarChart.setTitle(temp1+" Summary");
        
        // SalesBarChart.setStyle("-fx-text-fill:green; -fx-font-size: 20px;");
        xAxis.setLabel("Date");       
        yAxis.setLabel("Value");
 
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("TotalRevenue");       
        series1.getData().add(new XYChart.Data(d7, 25601));
        series1.getData().add(new XYChart.Data(d6, 20148));
        series1.getData().add(new XYChart.Data(d5, 10000));
        series1.getData().add(new XYChart.Data(d4, 35407));
        series1.getData().add(new XYChart.Data(d3, 36254)); 
         series1.getData().add(new XYChart.Data(d2,24589)); 
          series1.getData().add(new XYChart.Data(d1,28589)); 
        
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Profit");
        series2.getData().add(new XYChart.Data(d7, 5740));
        series2.getData().add(new XYChart.Data(d6, 4194));
        series2.getData().add(new XYChart.Data(d5, 3263));
        series2.getData().add(new XYChart.Data(d4, 11732));
        series2.getData().add(new XYChart.Data(d3, 12484));  
         series2.getData().add(new XYChart.Data(d2, 5856));  
         series2.getData().add(new XYChart.Data(d1,7845));  
        
       /* XYChart.Series series3 = new XYChart.Series();
        series3.setName("2005");
        series3.getData().add(new XYChart.Data(austria, 45000.65));
        series3.getData().add(new XYChart.Data(brazil, 44835.76));
        series3.getData().add(new XYChart.Data(france, 18722.18));
        series3.getData().add(new XYChart.Data(italy, 17557.31));
        series3.getData().add(new XYChart.Data(usa, 92633.68));  */
       
      //  Scene scene  = new Scene(SalesStackedBarChart,800,600);
      SalesBarChart.getData().clear();
      SalesBarChart.getData().addAll(series1, series2);
        
        
        donothing();
        
        
        
        
        }

    @FXML
    private void handleWeeklyStatistics(MouseEvent event) {
        /*DailyLineChart.getXAxis().setAutoRanging(true);
        DailyLineChart.getYAxis().setAutoRanging(true);
        LocalDate fromdate=SalesFromDate.getValue();
        LocalDate todate=SalesToDate.getValue();
         DailyLineChart.getData().add(SalesLineGraphController.getChartData("select DATE,NO_OF_SALES FROM SOLD_STATISTICS WHERE DATE BETWEEN '"+fromdate+"' and '"+todate+"'","Weekly"));
       // DailyLineChart.getData().add(SalesLineGraphController.getChartData("select DATE,NO_OF_SALES FROM SOLD_STATISTICS","Weekly"));
    
        */
        dseparator.setVisible(false);
        wseparator.setVisible(true);
         mseparator.setVisible(false);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String d1 = dateFormat.format(date); 
       // Calendar cal = Calendar.getInstance();
   // cal.add(Calendar.DATE, -7);
    //System.out.println("Date = "+ cal.get());
    System.out.println("hello everyone adhfgdgf");
    
     Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -6);
        Date date2 = cal.getTime();    
        String d2 = dateFormat.format(date2);
        String t1=d2+" to "+d1;
        
        cal.add(Calendar.DATE, -1);
        Date date3 = cal.getTime();    
        String d3 = dateFormat.format(date3);
        
        
        cal.add(Calendar.DATE, -6);
        Date date4 = cal.getTime();    
        String d4 = dateFormat.format(date4);
        String t2=d4+" to "+d3;
        
        cal.add(Calendar.DATE, -1);
        Date date5 = cal.getTime();    
        String d5 = dateFormat.format(date5);
        
        cal.add(Calendar.DATE, -6);
        Date date6 = cal.getTime();    
        String d6 = dateFormat.format(date6);
        
        String t3=d6+" to "+d5;
        
        cal.add(Calendar.DATE, -1);
        Date date7 = cal.getTime();    
        String d7 = dateFormat.format(date7);
        
        cal.add(Calendar.DATE, -6);
        Date date8 = cal.getTime();    
        String d8 = dateFormat.format(date8);
        String t4=d8+" to "+d7;
        
        
         
    
      /*  final String p1 = datestring;
    final String p2 = "May";
    final String p3 = "April";
    final String p4 = "March";
    final String p5 = "Febraury";
    final String p6 = "January";*/

         
        //stage.setTitle("Statistics");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
       //final BarChart<String,Number> bc = 
            //new BarChart<>(xAxis,yAxis);
            String temp1=InvStringClass.getvalue();
      
        SalesBarChart.setTitle(temp1+" Summary");
        // SalesBarChart.setStyle("-fx-text-fill:green; -fx-font-size: 20px;");
        xAxis.setLabel("Week");       
        yAxis.setLabel("Value");
 
      /*  XYChart.Series series1 = new XYChart.Series();
        series1.setName("TotalRevenue");       
        series1.getData().add(new XYChart.Data(t4, 25601));
        series1.getData().add(new XYChart.Data(t3, 20148));
        series1.getData().add(new XYChart.Data(t2, 10000));
        series1.getData().add(new XYChart.Data(t1, 35407));
       
        
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Profit");
        series2.getData().add(new XYChart.Data(t4, 5740));
        series2.getData().add(new XYChart.Data(t3, 4194));
        series2.getData().add(new XYChart.Data(t2, 3263));
        series2.getData().add(new XYChart.Data(t1, 11732));*/
        
        
        
          XYChart.Series series1 = new XYChart.Series();
        series1.setName("TotalRevenue");       
        series1.getData().add(new XYChart.Data("week6",25231));
        series1.getData().add(new XYChart.Data("week5", 28407));
        series1.getData().add(new XYChart.Data("week4", 25601));
        series1.getData().add(new XYChart.Data("week3", 20148));
        series1.getData().add(new XYChart.Data("week2", 10000));
        series1.getData().add(new XYChart.Data("week1", 35407));
       
        
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Profit");
          series2.getData().add(new XYChart.Data("week6", 6840));
        series2.getData().add(new XYChart.Data("week5", 4568));
        series2.getData().add(new XYChart.Data("week4", 5740));
        series2.getData().add(new XYChart.Data("week3", 4194));
        series2.getData().add(new XYChart.Data("week2", 3263));
        series2.getData().add(new XYChart.Data("week1", 11732));
        
        
      
        
       /* XYChart.Series series3 = new XYChart.Series();
        series3.setName("2005");
        series3.getData().add(new XYChart.Data(austria, 45000.65));
        series3.getData().add(new XYChart.Data(brazil, 44835.76));
        series3.getData().add(new XYChart.Data(france, 18722.18));
        series3.getData().add(new XYChart.Data(italy, 17557.31));
        series3.getData().add(new XYChart.Data(usa, 92633.68));  */
       
      //  Scene scene  = new Scene(SalesStackedBarChart,800,600);
      SalesBarChart.getData().clear();
      SalesBarChart.getData().addAll(series1, series2);
        
        
        
        
        
        
        
          donothing();
        
        
        
        
        
        }

    @FXML
    private void handleMonthlyStatistics(MouseEvent event) {
        /*DailyLineChart.getXAxis().setAutoRanging(true);
        DailyLineChart.getYAxis().setAutoRanging(true);
        LocalDate fromdate=SalesFromDate.getValue();
        LocalDate todate=SalesToDate.getValue();
        //DailyLineChart.getData().add(SalesLineGraphController.getChartData("select DATE,NO_OF_SALES FROM SOLD_STATISTICS","Monthly"));
         DailyLineChart.getData().add(SalesLineGraphController.getChartData("select DATE,NO_OF_SALES FROM SOLD_STATISTICS WHERE DATE BETWEEN '"+fromdate+"' and '"+todate+"'","Monthly"));
    */
        dseparator.setVisible(false);
        wseparator.setVisible(false);
         mseparator.setVisible(true);
        
        
         DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String datestring = dateFormat.format(date); 

  
   // final  String day1 = date;
        final String p1 = "June";
    final String p2 = "May";
    final String p3 = "April";
    final String p4 = "March";
    final String p5 = "Febraury";
    final String p6 = "January";

         
        //stage.setTitle("Statistics");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
       //final BarChart<String,Number> bc = 
            //new BarChart<>(xAxis,yAxis);
            String temp1=InvStringClass.getvalue();
       
        SalesBarChart.setTitle(temp1+" Summary");
        xAxis.setLabel("Date");       
        yAxis.setLabel("Value");
 
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("TotalRevenue");       
        series1.getData().add(new XYChart.Data(p6, 25601));
        series1.getData().add(new XYChart.Data(p5, 20148));
        series1.getData().add(new XYChart.Data(p4, 10000));
        series1.getData().add(new XYChart.Data(p3, 35407));
        series1.getData().add(new XYChart.Data(p2, 36254)); 
         series1.getData().add(new XYChart.Data(p1,24589)); 
        
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Profit");
        series2.getData().add(new XYChart.Data(p6, 5740));
        series2.getData().add(new XYChart.Data(p5, 4194));
        series2.getData().add(new XYChart.Data(p4, 3263));
        series2.getData().add(new XYChart.Data(p3, 11732));
        series2.getData().add(new XYChart.Data(p2, 12484));  
         series2.getData().add(new XYChart.Data(p1, 5856));  
        
       /* XYChart.Series series3 = new XYChart.Series();
        series3.setName("2005");
        series3.getData().add(new XYChart.Data(austria, 45000.65));
        series3.getData().add(new XYChart.Data(brazil, 44835.76));
        series3.getData().add(new XYChart.Data(france, 18722.18));
        series3.getData().add(new XYChart.Data(italy, 17557.31));
        series3.getData().add(new XYChart.Data(usa, 92633.68));  */
       
      //  Scene scene  = new Scene(SalesStackedBarChart,800,600);
      SalesBarChart.getData().clear();
      SalesBarChart.getData().addAll(series1, series2);
        //stage.setScene(scene);
        //stage.show();
        
        
          donothing();
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
  

