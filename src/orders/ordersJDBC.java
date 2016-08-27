/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hemanth
 */
//STEP 1. Import required packages
import java.sql.*;

public class ordersJDBC {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost:3306/test";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "1234";
   
   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);

      //STEP 4: Execute a query
      System.out.println("Creating database...");
      stmt = conn.createStatement();
      String sql="CREATE TABLE orderlist(id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,Customer_name VARCHAR(50),Karigar_name VARCHAR(50),Total_cost INT,Delivery_date DATE)";
      stmt.executeUpdate(sql);
      sql="CREATE TABLE dispatchlist(id INT NOT NULL,Order_ID INT NOT NULL PRIMARY KEY,Karigar_name VARCHAR(50),Manufacturing_cost INT,Delivery_date DATE)";
      stmt.executeUpdate(sql);
      sql="CREATE TABLE deliverylist(id INT NOT NULL,Order__ID INT NOT NULL PRIMARY KEY,Customer_name VARCHAR(50),Ornament_cost INT,Mobile MEDIUMTEXT,Delivery_date DATE)";
      stmt.executeUpdate(sql);
      sql="CREATE TABLE karigarlist(id INT NOT NULL,Karigar_ID INT NOT NULL PRIMARY KEY,Karigar_name VARCHAR(20),Factory_name VARCHAR(50),rating INT,Punctuality INT,ThopeIn VARCHAR(20))";
      stmt.executeUpdate(sql); 
      System.out.println("Database created successfully...");
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
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Goodbye!");
}//end main
}//end JDBCExample