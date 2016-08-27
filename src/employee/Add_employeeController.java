/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author rgsankar121
 */
public class Add_employeeController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField rating;
    
    @FXML
    private TextField attendance;
    
    @FXML
    private TextField overview;

    private Stage stage = new Stage();
    
    @FXML
    public void handleAttendance() throws IOException
    {
        System.out.println("revolucian_gowri.Employee1Controller.handleAttendance()");
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("attendance.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) attendance).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
    
    @FXML
    public void handleRating() throws IOException
    {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("rating.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) rating).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
    
    @FXML
    public void handleOverview() throws IOException
    {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("employee_overview.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) overview).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
    
    @FXML
    private Button back;
    
    @FXML
    private TextField name;
    
    @FXML
    private TextField empid;
    
    @FXML
    private TextField phno;
    
    @FXML
    private TextField salary;
    
    @FXML
    private TextField att;
    
    @FXML 
    private Button add;
    
    @FXML 
    private void addemp(ActionEvent event) throws IOException
    {
        String Name = name.getText();
        String Empid = empid.getText();
        String Phno = phno.getText();
        float Salary = Float.parseFloat(salary.getText());
        int Att = Integer.parseInt(att.getText());
        
        String[] query = new String[7];
        
        query[0] = "INSERT INTO employee VALUES('" + Empid+"','"+Name+"','"+Phno+"',"+Salary+","+Att+")";
        query[1] = "ALTER TABLE emp_attendance ADD COLUMN "+Empid+ " int";
        query[2] = "ALTER TABLE orn_rating ADD COLUMN "+Empid+ " int";
        query[3] = "ALTER TABLE customer_rating ADD COLUMN "+Empid+ " int";
        query[4] = "update emp_attendance set "+Empid+"=0";
        query[5] = "update orn_rating set "+Empid+"=0";
        query[6] = "update customer_rating set "+Empid+"=0";
        
        sql.executeUpdate(query);
        stage = (Stage) add.getScene().getWindow();
        stage.close();
        
    }
    
    @FXML
    private void handleback(ActionEvent event) throws IOException
    {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("employee1.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
