/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sales;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
//import static javafxapplication4.PieFXMLController.getChartData;

/**
 *
 * @author vinay
 */
public class JavaFXApplication4 extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("OverView1.fxml"));
        
        System.out.println("hai:yo yo");
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
        
    }
    
}
