/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  Sales;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;


/**
 * FXML Controller class
 *
 * @author Vinod
 */
public class InventoryPieGraphController implements Initializable {
   // Scene scene = new Scene(new Group());

   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost:3306/owner_test";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "cool1234";
   
   static ObservableList<PieChart.Data> getChartData(String query) {
        
        ObservableList<PieChart.Data> answer = FXCollections.observableArrayList();

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
       while(rs.next()){
                //adding data on piechart data
                String a,b;
                int val;
                a=rs.getString(1);
                val=rs.getInt(2);
                b=a+"\n"+"("+NumberFormat.getNumberInstance(Locale.US).format(val)+")";
                
                answer.add(new PieChart.Data(b,rs.getInt(2)));
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
   }
   System.out.println("Goodbye!");
        return answer;
   }//end try
   
     static ObservableList<PieChart.Data> getSpecialChartData(String query) {
        
        ObservableList<PieChart.Data> answer = FXCollections.observableArrayList();

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
       while(rs.next()){
                //adding data on piechart data
                String a,b;
                int val;
                a=rs.getString(1);
                val=rs.getInt(2);
                b=a+"\n"+"(Rs: "+NumberFormat.getNumberInstance(Locale.US).format(val)+")";
                
                answer.add(new PieChart.Data(b,rs.getInt(2)));
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
        return answer;
    }    
    @FXML
    PieChart piechartMaterial=new PieChart();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    //piechartMaterial.setData(getChartData("select MATERIAL,count(*) from INVENTORY  group by MATERIAL"));
    }
}