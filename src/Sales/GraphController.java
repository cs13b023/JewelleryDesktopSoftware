/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sales;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;

/**
 * FXML Controller class
 *
 * @author akshay
 */
/*public class GraphController implements Initializable {

    /**
     * Initializes the controller class.
     */
  /*  public Button btn_getData;
    public ProgressBar progressBar;
    public LineChart<String, Integer> lineChart;
     
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        try {
            // TODO Auto-generated method stu
            lineChart.getXAxis().setAutoRanging(true);
            lineChart.getYAxis().setAutoRanging(true);
            
            XYChart.Series series = new XYChart.Series<>();
           SqlLogin.executeQuery("select customerid,amonttaken from chitfundcustomerdetails",series);
             
            lineChart.getData().add(series);
        } catch (SQLException ex) {
            Logger.getLogger(GraphController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
    
*/