/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author akshay
 */
//STEP 1. Import required packages


package Sales;
import java.sql.*;

public class JDBCSalesAndInventory {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost:3306/test3";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "cool1234";
   
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
      //String sql="CREATE TABLE S_INVENTORY(ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,BARCODE VARCHAR(20),IMAGE LONGBLOB,WHOLESALER_NAME VARCHAR(50),DATE_OF_PURCHASE DATE,MATERIAL VARCHAR(25),TYPE VARCHAR(25),DESIGN_NAME VARCHAR(25),SUB_ITEM VARCHAR(25),MAKING _CHARGES FLOAT,HALLMARK VARCHAR(20),PURITY FLOAT,NET_WEIGHT FLOAT,STONE_WEIGHT FLOAT,GROSS_WEIGHT FLOAT,BUYING_PRICE LONG,SELLING_PRICE LONG)";
     // stmt.executeUpdate(sql);
      // String sql1="CREATE TABLE STONE_DETAILS(ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,ORN_FK_ID INT,STONE_NAME VARCHAR(25),CLASS VARCHAR(25),CLARITY FLOAT,CUT FLOAT,PIECES FLOAT,WEIGHT FLOAT,WT_PER_GM FLOAT,CWP_TYPE,RATE LONG)";

     // stmt.executeUpdate(sql1);
      
   //  String sql2="ALTER TABLE STONE_DETAILS ADD CONSTRAINT FK_ORNID FOREIGN KEY (ORN_FK_ID) REFERENCES INVENTORY(ID)";
   //  stmt.executeUpdate(sql2);
// sql="ALTER TABLE paymentspartof ADD CONSTRAINT fk_chitspartofid FOREIGN KEY (chitfundid) REFERENCES chitspartof(id)";
      
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