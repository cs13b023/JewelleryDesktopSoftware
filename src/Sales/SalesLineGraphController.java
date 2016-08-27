package Sales;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

 public class SalesLineGraphController implements Initializable{

    
    
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost:3306/owner_test";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "cool1234";
    @FXML
    private LineChart<String,Integer> lineChart;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stu
      //  lineChart.getXAxis().setAutoRanging(true);
       // lineChart.getYAxis().setAutoRanging(true);

       // lineChart.getData().add(getChartData("select CITY,count(*) from CUSTOMER  group by CITY"));
    }
    
    @FXML
    
   static  XYChart.Series  getChartData(String query,String type) {
        
        XYChart.Series series = new XYChart.Series<>();  

           Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      System.out.println("Creating statement...");
       stmt=conn.createStatement();
       ResultSet rs;
       rs = stmt.executeQuery(query);
       int i=0;
       if(type=="Daily")
       {
       while(rs.next()){
                //adding data on piechart data
                   //i++;
                series.getData().add(new XYChart.Data<>(rs.getString(1),rs.getInt(2)));
            }
       }
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Goodbye!");
        return series;
    }
}