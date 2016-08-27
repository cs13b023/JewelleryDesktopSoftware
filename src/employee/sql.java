/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;

/**
 *
 * @author rgsankar121
 */
public class sql {
    
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/test";
    
    static final String USER = "root";
    static final String PASS = "1234";
    
    static Connection conn=null;
    
    static sql sqlData= new sql();
    
    static ObservableList<ObservableList> data;
    static ObservableList<ObservableList> data1;

   
    
    private sql(){
        
    }
    
   
    static void connectDatabase() throws SQLException{
        
        try {
                Class.forName(JDBC_DRIVER);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(sql.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            System.out.println("Connecting to database");
            conn=DriverManager.getConnection(DB_URL,USER,PASS);
    }
    
    
    static String executeSearchdate(String query) throws SQLException {
        
        data=FXCollections.observableArrayList();
        Statement stmt=null;
        //System.out.println(query);
        
            try{
               
                sql.connectDatabase();      
                stmt=sql.conn.createStatement();
                ResultSet rs;
                rs = stmt.executeQuery(query);
                System.out.println(query);

                if(rs!=null)
                {
                    System.out.println(rs.getMetaData().getColumnName(1));
                    rs.next();
                    System.out.println(rs.getString(1));
                    //System.out.println("rev.sql.executeQuery()");
                        
                    String id[]=new String[rs.getMetaData().getColumnCount()-1];
                    int k=0;
                        
                    for(int i=2;i<=rs.getMetaData().getColumnCount();++i){
                        if(rs.getString(i).equals("1"))

                        {
                            //System.out.println("rev.sql.executeSearchdate()");
                            id[k]=rs.getMetaData().getColumnName(i);
                            k++;
                        }
                    
                    }
                    if(k!=0)
                    {
                        query = "Select * from employee where emp_id='"+id[k-1]+"'";
                        k--;
                        while(k!=0)
                        {
                            query+=" or emp_id='"+id[k-1]+"'";
                            k--;
                        }
                            }
                        System.out.println(query);
                    
                    
                }
                
                    rs.close();
                    stmt.close();
                    sql.conn.close();
            }
            catch(SQLException se)
                {
                    System.out.println(se);

                }
                
                finally{
              //finally block used to close resources
              try{
                 if(stmt!=null)
                    stmt.close();
              }catch(SQLException se2){
              }// nothing we can do
              try{
                 if(sql.conn!=null)
                    sql.conn.close();
              }catch(SQLException se){
              }//end finally try
     
            }
            return(query);
    }
    
    
    static void executeQuery(String query, TableView table) throws SQLException{
        
        data=FXCollections.observableArrayList();
        Statement stmt=null;
        //System.out.println(query);
        
            try{
               
                sql.connectDatabase();      
                stmt=sql.conn.createStatement();
                ResultSet rs;
                rs = stmt.executeQuery(query);
                
                //System.out.println(rs.getMetaData().getColumnCount());
                if(table!=null)
                {
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
                }
                //adding data to observable list
                while(rs.next()){
                    //System.out.println("rev.sql.executeQuery()");
                    ObservableList<String> row= FXCollections.observableArrayList();
                    for(int i=1;i<=rs.getMetaData().getColumnCount();++i){
                        if(rs.getString(i)!=null)
                        {row.add(rs.getString(i));
                            //System.out.println(rs.getString(i));
                        }
                        else
                            row.add("null");
                        
                    }
                    data.add(row);
                }
                    rs.close();
                    stmt.close();
                    sql.conn.close();
            }
            catch(SQLException se)
                {
                    System.out.println(se);

                }
                catch(Exception e)
                {
                    System.out.println("Class");

                }
                finally{
              //finally block used to close resources
              try{
                 if(stmt!=null)
                    stmt.close();
              }catch(SQLException se2){
              }// nothing we can do
              try{
                 if(sql.conn!=null)
                    sql.conn.close();
              }catch(SQLException se){
              }//end finally try
     
            }
        }

    static void executeQuery1(String query, TableView table) throws SQLException{
        
        data1 = FXCollections.observableArrayList();
        Statement stmt=null;
        //System.out.println(query);
        
            try{
               
                sql.connectDatabase();      
                stmt=sql.conn.createStatement();
                ResultSet rs;
                rs = stmt.executeQuery(query);

                if(table!=null)
                {
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
                }
                //adding data to observable list
                while(rs.next()){
                    //System.out.println("rev.sql.executeQuery()");
                    ObservableList<String> row= FXCollections.observableArrayList();
                    for(int i=1;i<=rs.getMetaData().getColumnCount();++i){
                        if(rs.getString(i)!=null)
                        {row.add(rs.getString(i));
                            //System.out.println(rs.getString(i));
                        }
                        else
                            row.add("null");
                        
                    }
                    data1.add(row);
                }
                    rs.close();
                    stmt.close();
                    sql.conn.close();
            }
            catch(SQLException se)
                {
                    System.out.println(se);

                }
                catch(Exception e)
                {
                    System.out.println("Class");

                }
                finally{
              //finally block used to close resources
              try{
                 if(stmt!=null)
                    stmt.close();
              }catch(SQLException se2){
              }// nothing we can do
              try{
                 if(sql.conn!=null)
                    sql.conn.close();
              }catch(SQLException se){
              }//end finally try
     
            }
        }
    
        static void executeQuery2(String query, TableView table) throws SQLException{
        
        data1 = FXCollections.observableArrayList();
        Statement stmt=null;
        //System.out.println(query);
        
            try{
               
                sql.connectDatabase();      
                stmt=sql.conn.createStatement();
                ResultSet rs;
                ResultSet rs1;
                rs = stmt.executeQuery(query);

                if(table!=null)
                {
                //adding columns
                for(int i=0;i<rs.getMetaData().getColumnCount();++i){
                    final int j=i;
                    TableColumn col=new TableColumn(rs.getMetaData().getColumnName(i+1));
                    if(i==1)
                    {
                        col.setText("name");
                    }
                    col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                        @Override
                        public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {                                                                                              
                            return new SimpleStringProperty(param.getValue().get(j).toString());                        
                        }                    
                    });
                    table.getColumns().addAll(col);
                }
                }
                //adding data to observable list
                while(rs.next()){
                    //System.out.println("rev.sql.executeQuery()");
                    ObservableList<String> row= FXCollections.observableArrayList();
                    for(int i=1;i<=rs.getMetaData().getColumnCount();++i){
                        if(i==2)
                        {
                            rs1=stmt.executeQuery("select name from customer where id='"+rs.getString(1)+"'");
                            row.add("name");
                            //System.out.println(rs1.getString(1));
                        }
                        else{
                        if(rs.getString(i)!=null)
                        {row.add(rs.getString(i));
                            //System.out.println(rs.getString(i));
                        }
                        else
                            row.add("null");
                        }
                    }
                    data1.add(row);
                }
                    rs.close();
                    stmt.close();
                    sql.conn.close();
            }
            catch(SQLException se)
                {
                    System.out.println(se);

                }
                catch(Exception e)
                {
                    System.out.println("Class");

                }
                finally{
              //finally block used to close resources
              try{
                 if(stmt!=null)
                    stmt.close();
              }catch(SQLException se2){
              }// nothing we can do
              try{
                 if(sql.conn!=null)
                    sql.conn.close();
              }catch(SQLException se){
              }//end finally try
     
            }
        }

    static void searchQuery(String query, TableView table) {
        
        table.getColumns().clear();
        data=FXCollections.observableArrayList();
        Statement stmt=null;
        
            try{
               
                sql.connectDatabase();      
                stmt=sql.conn.createStatement();
                ResultSet rs;
                rs = stmt.executeQuery(query);
                
                if(table!=null)
                {
                    //System.out.println("rev.sql.searchQuery()");
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
            }
                //adding data to observable list
                while(rs.next()){
                    //System.out.println("fsg");
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
                    stmt.close();
                    sql.conn.close();
            }
            catch(SQLException se)
                {
                    System.out.println("SQL");

                }
                catch(Exception e)
                {
                    System.out.println("Class");

                }
                finally{
              //finally block used to close resources
              try{
                 if(stmt!=null)
                    stmt.close();
              }catch(SQLException se2){
              }// nothing we can do
              try{
                 if(sql.conn!=null)
                    sql.conn.close();
              }catch(SQLException se){
              }//end finally try
     
            }
        
    }

    static void executeUpdate(String[] query)
    {
        Statement stmt=null;
        
            try{
               
                sql.connectDatabase();      
                stmt=sql.conn.createStatement();
                int i=0;
                //System.out.println("S");

                while(i<query.length)
                {

                //System.out.println("S2");
                stmt.executeUpdate(query[i]);
                i++;
                

                }
            }
            catch(SQLException se)
                {
                    System.out.println("SQL");

                }
                catch(Exception e)
                {
                    System.out.println("Class");

                }
                finally{
              //finally block used to close resources
              try{
                 if(stmt!=null)
                    stmt.close();
              }catch(SQLException se2){
              }// nothing we can do
              try{
                 if(sql.conn!=null)
                    sql.conn.close();
              }catch(SQLException se){
              }//end finally try
     
            }
    }
    
    
    
}
