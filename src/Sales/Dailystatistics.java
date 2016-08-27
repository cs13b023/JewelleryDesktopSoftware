package Sales;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
 
public class Dailystatistics extends Application {
   // LocalDate date=LocalDate.now();
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String datestring = dateFormat.format(date); 

  
   // final  String day1 = date;
        final static String p1 = "June";
    final static String p2 = "May";
    final static String p3 = "April";
    final static String p4 = "March";
    final static String p5 = "Febraury";
    final static String p6 = "January";
 
    @Override public void start(Stage stage) {
         
        stage.setTitle("Statistics");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> bc = 
            new BarChart<>(xAxis,yAxis);
        bc.setTitle("Summary");
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
        
        Scene scene  = new Scene(bc,800,600);
        bc.getData().addAll(series1, series2);
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}