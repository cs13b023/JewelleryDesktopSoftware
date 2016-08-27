/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sales;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * 
 * @author rgsankar121
 */
/*public class TilePaneController implements Initializable {
    
    @FXML
    private TextField search;
    @FXML 
    private TilePaneController emp = new TilePaneController();*/
       
    
  /* @FXML
    public void handleSearch() throws SQLException
    {
        String id,name,ph;
        float sal;
        int attendance_count;
        
        emp.getChildren().clear();
        
        try {
            
            sql.executeQuery("select * from employee where name like '"+search.getText()+"%'" ,null);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        if(sql.data.isEmpty())
        {
            System.out.println("select * from emp_attendance where date='"+search.getText()+"'");
            sql.executeSearchdate("select * from emp_attendance where date='"+search.getText()+"'");
        }
        
        tileDisplay(sql.data);
        VBox addBox = new VBox();
        ImageView add = new ImageView(new Image(Rev.class.getResourceAsStream("img/add.png")));
        add.setFitHeight(100);
        add.setFitWidth(100);    
        addBox.getChildren().add(add);
        addBox.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                search.clear();
                Stage stage = new Stage();
                Object root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("add_employee.fxml"));
                } catch (IOException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
                stage.setScene(new Scene((Parent) root));
                stage.setTitle("My modal window");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.initOwner(addBox.getScene().getWindow());
                stage.showAndWait();
                refresh();
            }
            
        });
        emp.getChildren().add(addBox);

    }*/
    
    
    
    /*public void tileDisplay(ObservableList<ObservableList> data){
        emp.setHgap(5);
        emp.setVgap(5);
        ImageView page = new ImageView();
        
        String name;
        try{
        for(int i=0;i<data.size();++i){
            VBox empTile=new VBox();
            empTile.setId((String)data.get(i).get(0));
            
            empTile.setOnMouseClicked(new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                    parameters.setEmpId(empTile.getId());
     //             
                    Stage stage = new Stage();
                    Object root = null;
                    try {
                        root = FXMLLoader.load(getClass().getResource("FXMLWholeSaler.fxml"));
                    } catch (IOException ex) {
                        Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    stage.setScene(new Scene((Parent) root));
                    parameters.setEmpId(empTile.getId());
     //               System.out.println(parameters.getEmpId());
                    stage.setTitle(empTile.getId());
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.initOwner(emp.getScene().getWindow());
                    stage.showAndWait();
                    refresh();
                }
        });
            HBox descTile=new HBox();
            VBox desc = new VBox();
            Label empName=new Label();
            Label empSal=new Label();
            Label empAtt=new Label();
            
            name=(String)data.get(i).get(1);
            empName.setText(name);
            name=(String)data.get(i).get(3);
            empSal.setText(name);
            name=(String) data.get(i).get(4);
            empAtt.setText(name);
            //System.out.println(name);
            if(true){
              //  page= new ImageView(new Image(Rev.class.getResourceAsStream("img/"+data.get(i).get(0))));
                page.setFitHeight(100);
                page.setFitWidth(100);
                page.setId((String) data.get(i).get(0));
                descTile.getChildren().add(page);
                desc.getChildren().add(empName);
                desc.getChildren().add(empSal);
                desc.getChildren().add(empAtt);
                descTile.getChildren().add(desc);
                //empTile.applyCss();
                empTile.getChildren().add(descTile);
                emp.getChildren().add(empTile);
                
            }
            }
            
        }
        catch(Exception e){
                System.out.println(e);
            }
        
    }

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        refresh();

    }    
    
    public void refresh()
    {
        emp.getChildren().clear();
        String id,name,ph;
        float sal;
        int attendance_count;
        
        sql.executeQuery("select * from WHOLESALER",null);
        tileDisplay(sql.data);

        VBox addBox = new VBox();
       // ImageView add = new ImageView(new Image(Rev.class.getResourceAsStream("img/add.png")));
       // add.setFitHeight(100);
        //add.setFitWidth(100); 
        //addBox.getChildren().add(add);        
        addBox.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                Stage stage = new Stage();
                Object root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("add_employee.fxml"));
                } catch (IOException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
                stage.setScene(new Scene((Parent) root));
                stage.setTitle("My modal window");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.initOwner(addBox.getScene().getWindow());
                stage.showAndWait();
                refresh();
            }
            
        });
        emp.getChildren().add(addBox);
        
    }
    
}*/