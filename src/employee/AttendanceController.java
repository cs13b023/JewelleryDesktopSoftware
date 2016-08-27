/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author rgsankar121
 */
public class AttendanceController implements Initializable {
    
    static HashMap<String, Boolean> attendance;

    @FXML
    private DatePicker date;
    
    @FXML
    private Button save;
    
    @FXML
    public void handlesave(ActionEvent event)
    {
        
    }
    
    
    /**
     * Initializes the controller class.
     */
    public static class Person {

        private BooleanProperty invited;

        private StringProperty firstName;
        
        private StringProperty empid;

         

        private Person(boolean invited, String fName,String id) {
            
            this.empid= new SimpleStringProperty(id);

            this.invited = new SimpleBooleanProperty(invited);

            this.firstName = new SimpleStringProperty(fName);

            this.invited = new SimpleBooleanProperty(invited);

            this.invited.addListener(new ChangeListener<Boolean>() {

                public void changed(ObservableValue<? extends Boolean> ov, Boolean t, Boolean t1) {

                    System.out.println(firstNameProperty().get() + " invited: " + t1);
                    attendance.put(empidProperty().get(), t1);
                    System.out.println(attendance);
                }

            });            

        }

        public BooleanProperty invitedProperty() { return invited; }
        public StringProperty firstNameProperty() { return firstName; }
        
        public StringProperty empidProperty() { return empid; }
        public void setFirstName(String firstName) { this.firstName.set(firstName); }
        public void setempid(String id) { this.empid.set(id); }

    }

 

    //CheckBoxTableCell for creating a CheckBox in a table cell

    public static class CheckBoxTableCell<S, T> extends TableCell<S, T> {

        private final CheckBox checkBox;

        private ObservableValue<T> ov;

 

        public CheckBoxTableCell() {

            this.checkBox = new CheckBox();

            this.checkBox.setAlignment(Pos.CENTER);

 

            setAlignment(Pos.CENTER);

            setGraphic(checkBox);

        } 

         

        @Override public void updateItem(T item, boolean empty) {

            super.updateItem(item, empty);

            if (empty) {

                setText(null);

                setGraphic(null);

            } else {

                setGraphic(checkBox);

                if (ov instanceof BooleanProperty) {

                    checkBox.selectedProperty().unbindBidirectional((BooleanProperty) ov);

                }

                ov = getTableColumn().getCellObservableValue(getIndex());

                if (ov instanceof BooleanProperty) {

                    checkBox.selectedProperty().bindBidirectional((BooleanProperty) ov);

                }

            }

        }

    }
    
    @FXML
    private TableView att;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
                date.setValue(LocalDate.now());
                attendance = new HashMap<String, Boolean>();
        // TODO
                ObservableList<Person> data = FXCollections.observableArrayList();
                
        try {
            sql.executeQuery("select name,emp_id from employee", null);
        } catch (SQLException ex) {
            Logger.getLogger(AttendanceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for (int i=0;i<sql.data.size();i++)
        {
            data.add(new Person(false, (String) sql.data.get(i).get(0),(String) sql.data.get(i).get(1)));
            attendance.put((String) sql.data.get(i).get(1), false);
        }
        
        TableColumn invitedCol = new TableColumn<Person, Boolean>();

        invitedCol.setText("Present");

        invitedCol.setMinWidth(50);

        invitedCol.setCellValueFactory(new PropertyValueFactory("invited"));

        invitedCol.setCellFactory(new Callback<TableColumn<Person, Boolean>, TableCell<Person, Boolean>>() {

 

            public TableCell<Person, Boolean> call(TableColumn<Person, Boolean> p) {

                return new CheckBoxTableCell<Person, Boolean>();

            }

        });

        //"First Name" column

        TableColumn firstNameCol = new TableColumn();

        firstNameCol.setText("Name");

        firstNameCol.setCellValueFactory(new PropertyValueFactory("firstName"));
        
        
        TableColumn empidCol = new TableColumn();

        empidCol.setText("Empid");

        empidCol.setCellValueFactory(new PropertyValueFactory("empid"));

 

        att.setItems(data);

        //Enabling editing

        att.setEditable(true);

        att.getColumns().addAll(invitedCol, firstNameCol, empidCol);

        

        
    }

    
}
