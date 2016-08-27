/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sales;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;

/**
 *
 * @author sandukuttan
 */

//singleton
public class SqlLogin {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost:3306/owner_test";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "cool1234";
       static ObservableList<ObservableList> data;
   static void executeQuery(String query, TableView table) throws SQLException{
   Connection conn = null;
   Statement stmt = null;
      System.out.println("I am here");
  
   data=FXCollections.observableArrayList();
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

                //adding columns
                for(int i=0;i<rs.getMetaData().getColumnCount();++i){
                    final int j=i;
                    TableColumn col=new TableColumn(rs.getMetaData().getColumnName(i+1));
                    col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                        @Override
                        public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {                                                                                              
                            return new SimpleStringProperty(param.getValue().get(j).toString());                        
                        }                    
                    });
                    table.getColumns().addAll(col);
                }

                //adding data to observable list
                while(rs.next()){
                    ObservableList<String> row= FXCollections.observableArrayList();
                    for(int i=1;i<=rs.getMetaData().getColumnCount();++i){
                        if(rs.getString(i)!=null)
                            row.add(rs.getString(i));
                        else
                            row.add("null");
                    }
                    data.add(row);
                }
                    rs.close();
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
   }
  
   static void executeUpdate(String query){
       Connection conn = null;
   Statement stmt = null;
      System.out.println("I am here");
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
       stmt.executeUpdate(query);
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
      }//end finally try
   }//end try
   System.out.println("Goodbye!");
   }
    static void executeContent(String query, ObservableList<String> data) throws SQLException{
   Connection conn = null;
   Statement stmt = null;
      System.out.println("I am here");
  
  // data=FXCollections.observableArrayList();
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

              
                //adding data to observable list
                while(rs.next()){
         
                    data.add(rs.getString(1));
                }
                    rs.close();
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
   }
    static void executeInvQuery(String query, TableView table7) throws SQLException{
   Connection conn = null;
   Statement stmt = null;
      System.out.println("I am here");
  
   data=FXCollections.observableArrayList();
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

                

                //adding data to observable list
                while(rs.next()){
                    ObservableList<String> row= FXCollections.observableArrayList();
                    for(int i=1;i<=rs.getMetaData().getColumnCount();++i){
                        if(rs.getString(i)!=null)
                        {   System.out.println(rs.getString(i));
                            row.add(rs.getString(i));}
                        else
                            row.add("null");
                    }
                    data.add(row);
                    table7.setItems(SqlLogin.data);
                }
                    rs.close();
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
   }
  static void executeNewContent(String query) throws SQLException{
   Connection conn = null;
   Statement stmt = null;
      System.out.println("I am here");
  
  data=FXCollections.observableArrayList();
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

              
                //adding data to observable list
               while(rs.next()){
                    ObservableList<String> row= FXCollections.observableArrayList();
                    for(int i=1;i<=rs.getMetaData().getColumnCount();++i){
                        if(rs.getString(i)!=null)
                            row.add(rs.getString(i));
                        else
                            row.add("null");
                    }
                    data.add(row);
                }
                    rs.close();
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
   }
  static XYChart.Series  getChartData(String query) {
        
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
       while(rs.next()){
                //adding data on piechart data
                series.getData().add(new XYChart.Data<>(rs.getString(1),rs.getDouble(2)));
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