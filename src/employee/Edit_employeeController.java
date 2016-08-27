/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee;

import java.net.URL;
import java.sql.SQLException;
import java.time.Clock;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author rgsankar121
 */
public class Edit_employeeController implements Initializable {

    /**
     * Initializes the controller class.
     */
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
    public void handleDelete(ActionEvent event)
    {
        Stage stage = (Stage) delete.getScene().getWindow();
        System.out.println(stage.getTitle());
        String[] query = new String[4];
        
        query[0] = "Delete from employee where emp_id='"+stage.getTitle()+"'";
        query[1] = "alter table orn_rating drop column "+stage.getTitle();
        query[2] = "alter table emp_attendance drop column "+stage.getTitle();
        query[3] = "alter table customer_rating drop column "+stage.getTitle();
        //System.out.println(query[0]);
        sql.executeUpdate(query);
        stage.close();
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
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
        name.setText((String) sql.data.get(0).get(1));
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
        ornament.getData().add(BarGraphFXMLController.getChartData("Select type,"+empid.getText()+" from orn_rating"));
        customer.getData().add(BarGraphFXMLController.getChartData("Select type,"+empid.getText()+" from customer_rating"));
        
        System.out.println("Select type,"+empid.getText()+" from orn_rating");
        
         
    }    
    
}
