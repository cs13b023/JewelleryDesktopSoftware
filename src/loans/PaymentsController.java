/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loans;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author akshay
 */
public class PaymentsController implements Initializable {

    @FXML
    private TextField Orders;
    @FXML
    private TextField employee;
    @FXML
    private TextField Girvi;
    @FXML
    private TextField Loans;
    @FXML
    private TextField loyalty;
    @FXML
    private DatePicker datefrom;
    @FXML
    private DatePicker dateto;
    @FXML
    private TextField name;
    @FXML
    private TableView table2;
    @FXML
    private CheckBox assetscb;
    @FXML
    private CheckBox liabilitiescb;
    ObservableList<ObservableList>  data2;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        data2=FXCollections.observableArrayList();
      table2.setEditable(true);
     if(!table2.getColumns().isEmpty())
        table2.getColumns().clear();
        try {
            SqlLoginchit.executeQuery3("select assets.customer,assetspayments.amount,assetspayments.dateofpayment,assetspayments.paymentmode from assetspayments inner join assets on assets.id=assetspayments.assetsid",data2);
        } catch (SQLException ex) {
            Logger.getLogger(PaymentsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(data2);
      
      String colName = null;
        for(int i=0;i<4;++i){
                    final int j=i;
                     if(i==0)
                        colName="Name";
                    else if(i==1)
                        colName="Amount";
                    else if(i==2)
                        colName="Dateofpayment";
                    else if(i==3)
                        colName="Paymentmode";
                    
                    TableColumn col=new TableColumn(colName);
                    col.setMinWidth(100);
                    col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {                                                                                              
                    return new SimpleStringProperty(param.getValue().get(j).toString());                        
                        }                    
                    });
      
      table2.getColumns().addAll(col);
      
        }
          try {
            SqlLoginchit.executeQuery3("select liabilities.customer,liabilitiespayments.amount,liabilitiespayments.dateofpayment,liabilitiespayments.paymentmode from liabilitiespayments inner join liabilities on liabilities.id=liabilitiespayments.liabilitiesid",data2);
        } catch (SQLException ex) {
            Logger.getLogger(PaymentsController.class.getName()).log(Level.SEVERE, null, ex);
        }
       table2.setItems(data2);
       assetscb.setSelected(true);
       liabilitiescb.setSelected(true);
    }    

    @FXML
    private void handleHome(MouseEvent event) {
    }

    @FXML
    private void handleSales(MouseEvent event) {
    }

    @FXML
    private void handleOrders(MouseEvent event) {
    }

    @FXML
    private void handleemployee(MouseEvent event) {
    }

    @FXML
    private void handlechits(MouseEvent event) {
    }

    @FXML
    private void handleGirviClick(MouseEvent event) {
    }

    @FXML
    private void handleLoanClick(MouseEvent event) {
    }

    @FXML
    private void handleloyalty(MouseEvent event) {
    }

    @FXML
    private void handleActiveChit(MouseEvent event) {
    }

    @FXML
    private void handleMember(MouseEvent event) {
    }

    @FXML
    private void handleNewChit(MouseEvent event) {
    }

    @FXML
    private void searchdate(ActionEvent event) {
        name.setText(null); 
        table2.setEditable(true);
     if(!table2.getColumns().isEmpty())
        table2.getColumns().clear();
      String colName = null;
        for(int i=0;i<4;++i){
                    final int j=i;
                     if(i==0)
                        colName="Name";
                    else if(i==1)
                        colName="Amount";
                    else if(i==2)
                        colName="Dateofpayment";
                    else if(i==3)
                        colName="Paymentmode";
                    
                    TableColumn col=new TableColumn(colName);
                    col.setMinWidth(100);
                    col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {                                                                                              
                    return new SimpleStringProperty(param.getValue().get(j).toString());                        
                        }                    
                    });
      
      table2.getColumns().addAll(col);
      
        }
     if(assetscb.isSelected()==true && liabilitiescb.isSelected()==true){  
        data2=FXCollections.observableArrayList();
         try {
            SqlLoginchit.executeQuery3("select Assets.Takername,EMIassets.Amount,EMIassets.Dateofpayment,EMIassets.Paymentmode from EMIassets inner join Assets on Assets.id=EMIassets.Assetsid where Dateofpayment between '"+datefrom.getValue()+"' and '"+dateto.getValue()+"'",data2);
        } catch (SQLException ex) {
            Logger.getLogger(PaymentsController.class.getName()).log(Level.SEVERE, null, ex);
         }
         try {
            SqlLoginchit.executeQuery3("select Liabilities.Lendername,EMIliabilities.Amount,EMIliabilities.Dateofpayment,EMIliabilities.Paymentmode from EMIliabilities inner join Liabilities on Liabilities.id=EMIliabilities.Liabilitiesid where Dateofpayment between '"+datefrom.getValue()+"' and '"+dateto.getValue()+"'",data2);
        } catch (SQLException ex) {
            Logger.getLogger(PaymentsController.class.getName()).log(Level.SEVERE, null, ex);
        }    
       table2.setItems(data2);
     }
     else if(assetscb.isSelected()==true && liabilitiescb.isSelected()==false){
          data2=FXCollections.observableArrayList();
         try {
            SqlLoginchit.executeQuery3("select Assets.Takername,EMIassets.Amount,EMIassets.Dateofpayment,EMIassets.Paymentmode from EMIassets inner join Assets on Assets.id=EMIassets.Assetsid where Dateofpayment between '"+datefrom.getValue()+"' and '"+dateto.getValue()+"'",data2);
        } catch (SQLException ex) {
            Logger.getLogger(PaymentsController.class.getName()).log(Level.SEVERE, null, ex);
         }
         table2.setItems(data2);
     }
     else if(assetscb.isSelected()==false && liabilitiescb.isSelected()==true){
         data2=FXCollections.observableArrayList();
         try {
            SqlLoginchit.executeQuery3("select Liabilities.Lendername,EMIliabilities.Amount,EMIliabilities.Dateofpayment,EMIliabilities.Paymentmode from EMIliabilities inner join Liabilities on Liabilities.id=EMIliabilities.Liabilitiesid where Dateofpayment between '"+datefrom.getValue()+"' and '"+dateto.getValue()+"'",data2);
        } catch (SQLException ex) {
            Logger.getLogger(PaymentsController.class.getName()).log(Level.SEVERE, null, ex);
        }    
       table2.setItems(data2);
     }
    }

    @FXML
    private void searchname() {
        datefrom.setValue(null);
        dateto.setValue(null);
        table2.setEditable(true);
     if(!table2.getColumns().isEmpty())
        table2.getColumns().clear();
      String colName = null;
        for(int i=0;i<4;++i){
                    final int j=i;
                     if(i==0)
                        colName="Name";
                    else if(i==1)
                        colName="Amount";
                    else if(i==2)
                        colName="Dateofpayment";
                    else if(i==3)
                        colName="Paymentmode";
                    
                    TableColumn col=new TableColumn(colName);
                    col.setMinWidth(100);
                    col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {                                                                                              
                    return new SimpleStringProperty(param.getValue().get(j).toString());                        
                        }                    
                    });
      
      table2.getColumns().addAll(col);
      
        }
      if(assetscb.isSelected()==true && liabilitiescb.isSelected()==true){
          data2=FXCollections.observableArrayList();
          try {
            SqlLoginchit.executeQuery3("select Assets.Takername,EMIassets.Amount,EMIassets.Dateofpayment,EMIassets.Paymentmode from EMIassets inner join Assets on Assets.id=EMIassets.Assetsid where Assets.Takername like '%"+name.getText()+"%'",data2);
        } catch (SQLException ex) {
            Logger.getLogger(PaymentsController.class.getName()).log(Level.SEVERE, null, ex);
         }
         try {
            SqlLoginchit.executeQuery3("select Liabilities.Lendername,EMIliabilities.Amount,EMIliabilities.Dateofpayment,EMIliabilities.Paymentmode from EMIliabilities inner join Liabilities on Liabilities.id=EMIliabilities.Liabilitiesid where Liabilities.Lendername like '%"+name.getText()+"%'",data2);
        } catch (SQLException ex) {
            Logger.getLogger(PaymentsController.class.getName()).log(Level.SEVERE, null, ex);
        }
         System.out.println(data2);
       table2.setItems(data2);
    }
      else if(assetscb.isSelected()==true && liabilitiescb.isSelected()==false){
            data2=FXCollections.observableArrayList();
          try {
            SqlLoginchit.executeQuery3("select Assets.Takername,EMIassets.Amount,EMIassets.Dateofpayment,EMIassets.Paymentmode from EMIassets inner join Assets on Assets.id=EMIassets.Assetsid where Assets.Takername like '%"+name.getText()+"%'",data2);
        } catch (SQLException ex) {
            Logger.getLogger(PaymentsController.class.getName()).log(Level.SEVERE, null, ex);
         }
          table2.setItems(data2); 
      }
      else if(assetscb.isSelected()==false && liabilitiescb.isSelected()==true){
           data2=FXCollections.observableArrayList();
          System.out.println(name.getText());
           try {
            SqlLoginchit.executeQuery3("select Liabilities.Lendername,EMIliabilities.Amount,EMIliabilities.Dateofpayment,EMIliabilities.Paymentmode from EMIliabilities inner join Liabilities on Liabilities.id=EMIliabilities.Liabilitiesid where Liabilities.Lendername like '%"+name.getText()+"%'",data2);
        } catch (SQLException ex) {
            Logger.getLogger(PaymentsController.class.getName()).log(Level.SEVERE, null, ex);
        }
       table2.setItems(data2); 
      }
    }
    public void handleassets(ActionEvent event){
      table2.setEditable(true);
     if(!table2.getColumns().isEmpty())
        table2.getColumns().clear();
      String colName = null;
        for(int i=0;i<4;++i){
                    final int j=i;
                     if(i==0)
                        colName="Name";
                    else if(i==1)
                        colName="Amount";
                    else if(i==2)
                        colName="Dateofpayment";
                    else if(i==3)
                        colName="Paymentmode";
                    
                    TableColumn col=new TableColumn(colName);
                    col.setMinWidth(100);
                    col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {                                                                                              
                    return new SimpleStringProperty(param.getValue().get(j).toString());                        
                        }                    
                    });
      
      table2.getColumns().addAll(col);
      
        }
        if(assetscb.isSelected()==true && liabilitiescb.isSelected()==true){
             data2=FXCollections.observableArrayList();
            try {
            SqlLoginchit.executeQuery3("select Assets.Takername,EMIassets.Amount,EMIassets.Dateofpayment,EMIassets.Paymentmode from EMIassets inner join Assets on Assets.id=EMIassets.Assetsid",data2);
        } catch (SQLException ex) {
            Logger.getLogger(PaymentsController.class.getName()).log(Level.SEVERE, null, ex);
        } 
          try {
            SqlLoginchit.executeQuery3("select Liabilities.Lendername,EMIliabilities.Amount,EMIliabilities.Dateofpayment,EMIliabilities.Paymentmode from EMIliabilities inner join Liabilities on Liabilities.id=EMIliabilities.Liabilitiesid",data2);
        } catch (SQLException ex) {
            Logger.getLogger(PaymentsController.class.getName()).log(Level.SEVERE, null, ex);
        }
       table2.setItems(data2);
    }
        else if(assetscb.isSelected()==true && liabilitiescb.isSelected()==false){
            data2=FXCollections.observableArrayList();
            try {
            SqlLoginchit.executeQuery3("select Assets.Takername,EMIassets.Amount,EMIassets.Dateofpayment,EMIassets.Paymentmode from EMIassets inner join Assets on Assets.id=EMIassets.Assetsid",data2);
        } catch (SQLException ex) {
            Logger.getLogger(PaymentsController.class.getName()).log(Level.SEVERE, null, ex);
        } 
           table2.setItems(data2); 
        }
        else if(assetscb.isSelected()==false && liabilitiescb.isSelected()==true){
            data2=FXCollections.observableArrayList();
              try {
            SqlLoginchit.executeQuery3("select Liabilities.Lendername,EMIliabilities.Amount,EMIliabilities.Dateofpayment,EMIliabilities.Paymentmode from EMIliabilities inner join Liabilities on Liabilities.id=EMIliabilities.Liabilitiesid",data2);
        } catch (SQLException ex) {
            Logger.getLogger(PaymentsController.class.getName()).log(Level.SEVERE, null, ex);
        }
       table2.setItems(data2);
        }
        else{
            data2=FXCollections.observableArrayList();
            table2.setItems(data2);
        }
    }
}
