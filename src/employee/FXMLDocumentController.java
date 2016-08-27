/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee;

import java.awt.Color;
import static java.awt.Color.white;
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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.stage.Modality;
import javafx.stage.Stage;
import static javax.management.Query.value;

/**
 *
 * @author rgsankar121
 */
public class FXMLDocumentController implements Initializable {
    
    
        
    @FXML
    private TextField name;
    
    @FXML
    private TextField empid;
    
    @FXML
    private TextField ph;
    
    @FXML
    private TextField sal;
    
    @FXML
    private ImageView photo;
    
    @FXML
    private BarChart<String, Integer> ornament;

    @FXML
    private BarChart<String, Integer> customer;    
    
    @FXML
    private Button delete;
    
    
    @FXML
    private TextField search;
    
    @FXML 
    private ScrollPane scroll;
    
    
    @FXML
    public void handleSearch() throws SQLException
    {
        String id,name,ph;
        float sal;
        int attendance_count;
        
        emp.getChildren().clear();
        
        try {
            
            sql.executeQuery("select * from employee where name like '"+search.getText()+"%' or ph_no like '"+search.getText()+"%'" ,null);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        if(sql.data.isEmpty())
        {
            System.out.println("select * from emp_attendance where date='"+search.getText()+"'");
            sql.executeQuery(sql.executeSearchdate("select * from emp_attendance where date='"+search.getText()+"'"),null);
        }
        
        tileDisplay(sql.data);
        VBox addBox = new VBox();
        ImageView add = new ImageView(new Image(Employee.class.getResourceAsStream("img/add.png")));
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

    }
    
    @FXML
    private TextField home;
    
    @FXML
    public void handlehome() throws IOException
    {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/mastersoftnew/Home.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) (home).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
    
    @FXML 
    private TilePane emp;
       
    
    public void tileDisplay(ObservableList<ObservableList> data){
        //emp.setHgap(10);
        //emp.setVgap(10);
        ImageView page;
        
        String name;
        try{
        for(int i=0;i<data.size();++i){
            
            VBox empTile=new VBox();
            empTile.setId((String)data.get(i).get(0));
            empTile.setStyle("-fx-border-color: black;-fx-border-width: 2px;-fx-padding: 10;-fx-spacing: 8;");
            
            empTile.setOnMouseClicked((MouseEvent event) -> {
                parameters.setEmpId(empTile.getId());
                    String[] query = new String[1];
        query[0] = "Select * from employee where emp_id='"+parameters.getEmpId()+"'";
        System.out.println(query[0]);
        try {
            sql.executeQuery(query[0], null);
        } catch (SQLException ex) {
            Logger.getLogger(Edit_employeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(sql.data);
        
        empid.setText((String) sql.data.get(0).get(0));
        this.name.setText((String) sql.data.get(0).get(1));
        ph.setText((String) sql.data.get(0).get(2));
        sal.setText((String) sql.data.get(0).get(3));
        if(Employee.class.getResourceAsStream("img/"+empid.getText())!=null)
        {
            photo.setImage(new Image(Employee.class.getResourceAsStream("img/"+empid.getText())));
        }
        else
        {
            photo.setImage(new Image(Employee.class.getResourceAsStream("img/delete.jpeg")));
        
        }
        //System.out.println(ornament);
        ornament.getData().clear();
        customer.getData().clear();
        
        ornament.getData().add(BarGraphFXMLController.getChartData("Select type,"+empid.getText()+" from orn_rating"));
        customer.getData().add(BarGraphFXMLController.getChartData("Select type,"+empid.getText()+" from customer_rating"));
    
            });
            HBox descTile=new HBox();
            descTile.setSpacing(5);
            VBox desc = new VBox();
            Label empName=new Label();
            empName.setTextFill((Paint.valueOf("black")));
            Label empId=new Label();
            Label empPh=new Label();
            empId.setTextFill((Paint.valueOf("black")));
            empPh.setTextFill((Paint.valueOf("black")));
            
            name=(String)data.get(i).get(1);
            empName.setText(name);
            name=(String)data.get(i).get(0);
            empId.setText(name);
            name=(String) data.get(i).get(2);
            empPh.setText(name);
            //System.out.println(name);
            if(true){
                if(Employee.class.getResourceAsStream("img/"+data.get(i).get(0))==null)
                {
                    page= new ImageView(new Image(Employee.class.getResourceAsStream("img/delete.jpeg")));
                }
                else
                {
                    page= new ImageView(new Image(Employee.class.getResourceAsStream("img/"+data.get(i).get(0))));
                }
                page.setFitHeight(100);
                page.setFitWidth(100);
                page.setId((String) data.get(i).get(0));
                descTile.getChildren().add(page);
                desc.getChildren().add(empId);
                desc.getChildren().add(empName);
                desc.getChildren().add(empPh);
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
        emp.setStyle("-fx-padding:10;");
        refresh();
    }    
    
    public void refresh()
    {
        emp.getChildren().clear();
        String id,name,ph;
        float sal;
        int attendance_count;
        
        try {
            
            sql.executeQuery("select * from employee",null);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        tileDisplay(sql.data);

        VBox addBox = new VBox();
        ImageView add = new ImageView(new Image(Employee.class.getResourceAsStream("img/add.png")));
        add.setFitHeight(100);
        add.setFitWidth(100); 
        addBox.getChildren().add(add);        
        addBox.setOnMouseClicked((MouseEvent event) -> {
            Stage stage = new Stage();
            Object root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("add_employee.fxml"));
            } catch (IOException ex1) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex1);
            }
            stage.setScene(new Scene((Parent) root));            
            stage.setTitle("My modal window");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(addBox.getScene().getWindow());
            stage.showAndWait();
            refresh();
        });
        emp.getChildren().add(addBox);
    }
    

    @FXML
    public void handleDelete(ActionEvent event)
    {
        Stage stage = (Stage) delete.getScene().getWindow();
        System.out.println(stage.getTitle());
        String[] query = new String[4];
        
        query[0] = "Delete from employee where emp_id='"+parameters.getEmpId()+"'";
        query[1] = "alter table orn_rating drop column "+parameters.getEmpId();
        query[2] = "alter table emp_attendance drop column "+parameters.getEmpId();
        query[3] = "alter table customer_rating drop column "+parameters.getEmpId();
        //System.out.println(query[0]);
        sql.executeUpdate(query);
        
    }
    
    
    
}
