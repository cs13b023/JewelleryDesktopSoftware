/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sales;

import static java.lang.ProcessBuilder.Redirect.to;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import static java.time.Instant.now;
import java.time.LocalDate;
import static java.time.LocalDate.now;
import static java.time.LocalDate.now;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author vinay kumar reddy
 */
public class SoldItemsController implements Initializable {

    @FXML
    private TextField SalesOverView;
    @FXML
    private TextField SalesInvoice;
    @FXML
    private TextField SalesSoldItems;
    @FXML
    private ComboBox SIMaterialCombo;
    @FXML
    private TextField SISearchByAnything;
    @FXML
    private TableView SITable;
    @FXML
    private DatePicker SISearchDate;
    @FXML
    private Label DailyStatistics;
    @FXML
    private Label WeeklyStatistics;
    @FXML
    private Label MonthlyStatistics;
    @FXML
    private ComboBox StatisticsType;
    @FXML
    private Separator dseparator;
    @FXML
    private Separator wseparator;
    @FXML
    private Separator mseparator;
    @FXML
    private DatePicker SalesFromDate;
    @FXML
    private DatePicker SalesToDate;
    @FXML
    private BarChart SalesBarChart;
    @FXML
    private Button B6;
    @FXML
    private Button B5;
    @FXML
    private Button B4;
    @FXML
    private Button B3;
    @FXML
    private Button B2;
    @FXML
    private Button B1;
    @FXML
    private PieChart PieChartRevenue;
    @FXML
    private PieChart PieChartProfit;
    @FXML
    private Button GetDayGraph;
    @FXML
    private NumberAxis NA1;
    @FXML
    private CategoryAxis CA1;
    @FXML
    private LineChart SoldLineChart;
    @FXML
    private NumberAxis NA2;
    @FXML
    private CategoryAxis CA2;
    /**
     * Initializes the controller class.
     */
    
    InvStringClass strobj1=new InvStringClass();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
        
    }    

    @FXML
    private void handleHome(MouseEvent event) {
    }

    @FXML
    private void handleSalesOverView(MouseEvent event) {
    }

    @FXML
    private void handleSalesInvoice(MouseEvent event) {
    }

    @FXML
    private void handleSISearch(KeyEvent event) {
    }

    @FXML
    private void handleSISearchDate(ActionEvent event) {
    }

    @FXML
    private void handleDailyStatistics(MouseEvent event) {
        SalesFromDate.setValue(null);
         SalesToDate.setValue(null);
        
        SoldLineChart.setVisible(false);
        SalesBarChart.setVisible(true);
         B5.setVisible(true);
        B6.setVisible(true);
         B4.setVisible(true);
        B3.setVisible(true);
         B2.setVisible(true);
        B1.setVisible(true);
        
         dseparator.setVisible(true);
        wseparator.setVisible(false);
         mseparator.setVisible(false);
       
       
           DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String d1 = dateFormat.format(date); 
        System.out.println(d1);
        B6.setText(d1);
       // Calendar cal = Calendar.getInstance();
   // cal.add(Calendar.DATE, -7);
    //System.out.println("Date = "+ cal.get());
    System.out.println("hello everyone adhfgdgf");
    
     Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        Date date2 = cal.getTime();    
        String d2 = dateFormat.format(date2);
        B5.setText(d2);
        
        cal.add(Calendar.DATE, -1);
        Date date3 = cal.getTime();    
        String d3 = dateFormat.format(date3);
        B4.setText(d3);
        
        cal.add(Calendar.DATE, -1);
        Date date4 = cal.getTime();    
        String d4 = dateFormat.format(date4);
        B3.setText(d4);
        
        cal.add(Calendar.DATE, -1);
        Date date5 = cal.getTime();    
        String d5 = dateFormat.format(date5);
        B2.setText(d5);
        
        cal.add(Calendar.DATE, -1);
        Date date6 = cal.getTime();    
        String d6 = dateFormat.format(date6);
        B1.setText(d6);
        
        
         SalesBarChart.getData().clear();
        SalesBarChart.setTitle("Daily Statistics");
        
        // SalesBarChart.setStyle("-fx-text-fill:green; -fx-font-size: 20px;");
        CA1.setLabel("Date");       
        NA1.setLabel("Profit/Revenue in Rs");
 
       XYChart.Series series1 = new XYChart.Series<>();
        XYChart.Series series2 = new XYChart.Series<>();
        series1=SqlLogin.getChartData("select date,profit from sold_stat_day where date between '"+d6+"' and '"+d1+"' order by date asc");
        series1.setName("Profit");
        series2=SqlLogin.getChartData("select date,total_revenue from sold_stat_day where date between '"+d6+"' and '"+d1+"' order by date asc");
         series2.setName("Revenue");
        SalesBarChart.getData().addAll(series1,series2);
         System.out.println(SqlLogin.data);
         System.out.println("worst!!!");
        // PieChartRevenue.getData().clear();
         //PieChartRevenue.setData(InventoryPieGraphController.getChartData("select MATERIAL,SUM(QUANTITY) from INV_STATISTICS group by MATERIAL"));
 
        
        strobj1.setvalue("Daily");
       
        
        
    }

    @FXML
    private void handleWeeklyStatistics(MouseEvent event) {
        B4.setVisible(true);
        B3.setVisible(true);
         B2.setVisible(true);
        B1.setVisible(true);
         SalesFromDate.setValue(null);
         SalesToDate.setValue(null);
        SoldLineChart.setVisible(false);
        SalesBarChart.setVisible(true);
         dseparator.setVisible(false);
        wseparator.setVisible(true);
         mseparator.setVisible(false);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String w1d2 = dateFormat.format(date); 
       // Calendar cal = Calendar.getInstance();
   // cal.add(Calendar.DATE, -7);
    //System.out.println("Date = "+ cal.get());
    System.out.println("hello everyone adhfgdgf");
    
         LocalDate now = LocalDate.now();
         TemporalField fieldISO = WeekFields.of(Locale.ENGLISH).dayOfWeek();
         LocalDate w1d1=now.with(fieldISO, 1).plusDays(1);
         //String w1d1 = dateFormat.format(dt1); 
         
          System.out.println("week1");
          System.out.println(w1d1);
           System.out.println(w1d2);
         
         
         //LocalDate =now.with(fieldISO, 1).plusDays(1);
    
     System.out.println("week2");
    LocalDate w2d1=w1d1.minusDays(7);
      LocalDate w2d2=w1d1.minusDays(1);
      System.out.println(w2d1);
           System.out.println(w2d2);
      
       System.out.println("week3");
    LocalDate w3d1=w2d1.minusDays(7);
      LocalDate w3d2=w2d1.minusDays(1);
      System.out.println(w3d1);
           System.out.println(w3d2);
      
           
        System.out.println("week4");
    LocalDate w4d1=w3d1.minusDays(7);
      LocalDate w4d2=w3d1.minusDays(1);
      System.out.println(w4d1);
           System.out.println(w4d2);
      
      
    
     
        System.out.println("week dude");
        B4.setText("ThisWeek");
        B3.setText("Week3");
        B2.setText("Week2");
        B1.setText("Week1");
        
       /* B4.setText(w1d1.toString()+"to"+w1d2.toString());
         B3.setText(w2d1.toString()+"to"+w2d2.toString());
          B2.setText(w3d1.toString()+"to"+w3d2.toString());
           B1.setText(w4d1.toString()+"to"+w4d2.toString());
           */
        B5.setVisible(false);
        B6.setVisible(false);
      // LocalDate now = LocalDate.now();
        // TemporalField fieldISO = WeekFields.of(Locale.ENGLISH).dayOfWeek();
        // LocalDate abc=now.with(fieldISO, 1).plusDays(1);
        //System.out.println(); // 2015-02-09 (Monday)

         strobj1.setvalue("Weekly");
         
          SalesBarChart.getData().clear();
        SalesBarChart.setTitle("Daily Statistics");
        
        // SalesBarChart.setStyle("-fx-text-fill:green; -fx-font-size: 20px;");
        CA1.setLabel("Week");       
        NA1.setLabel("Profit/Revenue in Rs");
 
     /* XYChart.Series series1 = new XYChart.Series<>();
        XYChart.Series series2 = new XYChart.Series<>();
        series1=SqlLogin.getChartData("select date,profit from sold_stat_day where date between '"+d6+"' and '"+d1+"' order by date asc");
        series1.setName("Profit");
        series2=SqlLogin.getChartData("select date,total_revenue from sold_stat_day where date between '"+d6+"' and '"+d1+"' order by date asc");
         series2.setName("Revenue");
        SalesBarChart.getData().addAll(series1,series2);
         System.out.println(SqlLogin.data);
         System.out.println("worst!!!");
         
         */
         
        
    }

    @FXML
    private void handleMonthlyStatistics(MouseEvent event) throws SQLException {
         B5.setVisible(true);
        B6.setVisible(true);
        B4.setVisible(true);
        B3.setVisible(true);
         B2.setVisible(true);
        B1.setVisible(true);
         SalesFromDate.setValue(null);
         SalesToDate.setValue(null);
        SoldLineChart.setVisible(false);
        SalesBarChart.setVisible(true);
        
        strobj1.setvalue("Monthly");
        
       
        SalesBarChart.getData().clear();
        SalesBarChart.setTitle("Monthly Statistics");
        
        // SalesBarChart.setStyle("-fx-text-fill:green; -fx-font-size: 20px;");
        CA1.setLabel("Month");       
        NA1.setLabel("Profit/Revenue in Rs");
        
        String[] monthlist = {"January",      
                        "February",
                        "March",        
                        "April",        
                        "May",          
                        "June",         
                        "July",         
                        "August",       
                        "September",    
                        "October",      
                        "November",     
                        "December"};
       String[] finalmonths = new String[6];
        
 
      XYChart.Series series1 = new XYChart.Series<>();
        XYChart.Series series2 = new XYChart.Series<>();
        series1=SqlLogin.getChartData("select MONTH(DATE),SUM(PROFIT) FROM SOLD_STAT_DAY GROUP BY YEAR(DATE),MONTH(DATE) order by month(date) asc");
        SqlLogin.executeNewContent("select MONTH(DATE),SUM(PROFIT) FROM SOLD_STAT_DAY GROUP BY YEAR(DATE),MONTH(DATE) order by month(date) asc");
       for(int p=0;p<SqlLogin.data.size();p++)
       {
           int tp=Integer.parseInt((String)SqlLogin.data.get(p).get(0));
           finalmonths[p]=monthlist[tp];
           
       }
        series1.setName("Profit");
        series2=SqlLogin.getChartData("select MONTH(DATE),SUM(TOTAL_REVENUE) FROM SOLD_STAT_DAY GROUP BY YEAR(DATE),MONTH(DATE) order by month(date) asc");
         series2.setName("Revenue");
        SalesBarChart.getData().addAll(series1,series2);
         System.out.println(SqlLogin.data);
         System.out.println("worst!!!");
        
        B6.setText(finalmonths[5]);
        B5.setText(finalmonths[4]);
        B4.setText(finalmonths[3]);
        B3.setText(finalmonths[2]);
        B2.setText(finalmonths[1]);
        B1.setText(finalmonths[0]);
        
        
        
        
        
        
        
        
        
        
        
    }

    @FXML
    private void handleDayGraph(ActionEvent event) {
         B5.setVisible(false);
        B6.setVisible(false);
         B4.setVisible(false);
        B3.setVisible(false);
         B2.setVisible(false);
        B1.setVisible(false);
        LocalDate sd=SalesFromDate.getValue();
        LocalDate ed=SalesToDate.getValue();
        SoldLineChart.setVisible(true);
        SalesBarChart.setVisible(false);
         SoldLineChart.getData().clear();
        SoldLineChart.getXAxis().setAutoRanging(true);
            SoldLineChart.getYAxis().setAutoRanging(true);
            SoldLineChart.setTitle("Type Statistics");
             CA2.setLabel("Day");       
        NA2.setLabel("Profit/Revenue in Rs");
 
     
            
       XYChart.Series series1 = new XYChart.Series<>();
        XYChart.Series series2 = new XYChart.Series<>();
        series1=SqlLogin.getChartData("select date,profit from sold_stat_day where date between '"+sd+"' and '"+ed+"' order by date asc ");
        series1.setName("Profit");
        series2=SqlLogin.getChartData("select date,total_revenue from sold_stat_day where date between '"+sd+"' and '"+ed+"' order by date asc");
         series2.setName("Revenue");
        SoldLineChart.getData().addAll(series1,series2);
         System.out.println(SqlLogin.data);
         System.out.println("worst!!!");
        // PieChartRevenue.getData().clear();
         //PieChartRevenue.setData(InventoryPieGraphController.getChartData("select MATERIAL,SUM(QUANTITY) from INV_STATISTICS group by MATERIAL"));
 
        
        strobj1.setvalue("DayWise");
       
        
    }

    @FXML
    private void handleB1(ActionEvent event) {
        String buttext;
        Object source = event.getSource();
        if (source instanceof Button) { //should always be true in your example
            Button clickedBtn = (Button) source; // that's the button that was clicked
            String butname=clickedBtn.getId();
             buttext=clickedBtn.getText();
        String temp=strobj1.getvalue();
        if(temp=="Daily")
        {
             PieChartRevenue.getData().clear();
         PieChartRevenue.setData(InventoryPieGraphController.getChartData("select TYPE,SUM(TOTAL_REVENUE) from SOLD_STATISTICS WHERE DATE='"+buttext+"' group by type"));
          PieChartProfit.getData().clear();
         PieChartProfit.setData(InventoryPieGraphController.getChartData("select TYPE,SUM(PROFIT) from SOLD_STATISTICS WHERE DATE='"+buttext+"' group by type"));
        }    
        if(temp=="Weekly")
        {
            String temp1=buttext.replace("to","and");
             PieChartRevenue.getData().clear();
         PieChartRevenue.setData(InventoryPieGraphController.getChartData("select TYPE,SUM(TOTAL_REVENUE) from SOLD_STATISTICS WHERE DATE between '"+temp1+"'  group by type"));
          PieChartProfit.getData().clear();
         PieChartProfit.setData(InventoryPieGraphController.getChartData("select TYPE,SUM(PROFIT) from SOLD_STATISTICS WHERE DATE between '"+temp1+"' group by type"));
        }
        
        if(temp=="Monthly")
        {
            /*String temp1=buttext.replace("to","and");
             PieChartRevenue.getData().clear();
         PieChartRevenue.setData(InventoryPieGraphController.getChartData("select TYPE,SUM(TOTAL_REVENUE) from SOLD_STATISTICS WHERE DATE between '"+temp1+"'  group by type"));
          PieChartProfit.getData().clear();
         PieChartProfit.setData(InventoryPieGraphController.getChartData("select TYPE,SUM(PROFIT) from SOLD_STATISTICS WHERE DATE between '"+temp1+"' group by type"));
        */
        }
            
        
        
        
        
        
        }
        
        
    }
    
    public void piegraphs(String buttext)
    {
         PieChartRevenue.getData().clear();
         PieChartRevenue.setData(InventoryPieGraphController.getChartData("select TYPE,SUM(TOTAL_REVENUE) from SOLD_STATISTICS WHERE DATE='"+buttext+"' group by type"));
          PieChartProfit.getData().clear();
         PieChartProfit.setData(InventoryPieGraphController.getChartData("select TYPE,SUM(PROFIT) from SOLD_STATISTICS WHERE DATE='"+buttext+"' group by type"));
    
    }
    
    
    
    

    
}
