/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chitfund;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author akshay
 */
public class AddchitController implements Initializable {

    /**
     * Initializes the controller class.
     */
   public TextField chitname;
   public TextField totalmembers;
   public TextField totalmonths;
   public TextField totalamount;
   public TextField installments;
   public TextField pooledamount;
   private VBox stack;
   
    public void addchit(ActionEvent event) throws SQLException{
      String Name=chitname.getText();
      String Totalmembers=totalmembers.getText();
      String Totalmonths=totalmonths.getText();
      String Totalamount=totalamount.getText();
      String Installments=installments.getText();
      String Pooledamount=pooledamount.getText();
      SqlLoginchit.executeUpdate("INSERT INTO `chitslist`VALUES(null,'"+Name+"','"+Totalmembers+"','"+Totalmonths+"','"+Totalamount+"','"+Installments+"','"+Pooledamount+"')");
  }
    public void gohome(ActionEvent event) throws SQLException, IOException{
      Parent home_page_parent = FXMLLoader.load(getClass().getResource("test.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
   } 
    
    @FXML
    private void handleHome(MouseEvent event) throws IOException {
         Parent home_page_parent = FXMLLoader.load(getClass().getResource("/mastersoftware/Home.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       // app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
        
        
    }

    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
