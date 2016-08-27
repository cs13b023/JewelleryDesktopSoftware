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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author akshay
 */
public class PlanningController implements Initializable {

    @FXML
    private TextField Sales;
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
    private ScrollPane scrollpane1;
    @FXML
    private TextField LoansTextField1;
    @FXML
    private TextField OverviewTextField;
    @FXML
    private TextField InvoicesTextField;
    @FXML
    private TextField LoansTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    @SuppressWarnings("empty-statement")
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
           scrollpane1.setContent(null);
            String name;
             HBox hbox = new HBox();
              hbox.setSpacing(20);
            try {
            SqlLoginchit.executeQueryTiles("select Takername,Shopname,Amount,Rateofintrest from Assets");//change Assets to Liabilities
            } catch (SQLException ex) {
                Logger.getLogger(PlanningController.class.getName()).log(Level.SEVERE, null, ex);
            }
            for(int i=0;i<SqlLoginchit.data.size();++i){
                Pane pane = new Pane();
                pane.getStyleClass().add("Pane");
               VBox Names = new VBox();
                Names.setSpacing(10);
                HBox hbox2 = new HBox();
                 hbox2.setSpacing(10);
                Label EMI=new Label();
                 EMI.setStyle("-fx-text-fill:black; -fx-font-size: 15px;");
                 EMI.setText("EMI");
                 EMI.setPrefSize(70, 20);
                TextField EMIT=new TextField();
                 Label Lendername=new Label();
                 Lendername.setStyle("-fx-text-fill:black; -fx-font-size: 15px;");
                  name=(String)SqlLoginchit.data.get(i).get(0);
                 Lendername.setText(name);
                 Label Shopname=new Label();
                 Shopname.setStyle("-fx-text-fill:black; -fx-font-size: 15px;");
                 name=(String)SqlLoginchit.data.get(i).get(1);
                 Shopname.setText(name);
                 HBox hbox3=new HBox();
                 hbox3.setSpacing(10);
                 HBox hbox4=new HBox();
                 hbox4.setSpacing(10);
                 HBox hbox5=new HBox();
                 hbox5.setSpacing(10);
                 Label Amount= new Label();
                 Amount.setStyle("-fx-text-fill:black; -fx-font-size: 15px;");
                 name=(String)SqlLoginchit.data.get(i).get(2);
                 Amount.setText("Amount");
                 Amount.setPrefSize(70, 20);
                 TextField AmountT=new TextField();
                 AmountT.setText(name); 
                 Label Time= new Label();
                 Time.setStyle("-fx-text-fill:black; -fx-font-size: 15px;");
                 Time.setText("Time");
                 Time.setPrefSize(70, 20);
                 TextField TimeT=new TextField();
                 Label Intrest= new Label();
                 Intrest.setStyle("-fx-text-fill:black; -fx-font-size: 15px;");
                 Intrest.setText("Intrest");
                 Intrest.setPrefSize(70, 20);
                 TextField IntrestT=new TextField();
                 hbox3.getChildren().add(Amount);
                 hbox3.getChildren().add(AmountT);
                 hbox4.getChildren().add(Time);
                 hbox4.getChildren().add(TimeT);
                 hbox5.getChildren().add(Intrest);
                 hbox5.getChildren().add(IntrestT);
                 hbox2.getChildren().add(EMI);
                hbox2.getChildren().add(EMIT);
                Names.getChildren().add(hbox2);
                Names.getChildren().add(Lendername);
                Names.getChildren().add(Shopname);
                Names.getChildren().add(hbox3);
                Names.getChildren().add(hbox4);
                Names.getChildren().add(hbox5);
                pane.getChildren().add(Names);
                hbox.getChildren().add(pane);
                name=(String)SqlLoginchit.data.get(i).get(3);
                int r=Integer.parseInt(name);
                TimeT.setOnKeyPressed(new EventHandler<KeyEvent>() {
               @Override
               
               public void handle(KeyEvent keyEvent) {
               if (keyEvent.getCode() == KeyCode.ENTER)  {
                   String text = TimeT.getText();

            // do your thing...
                   System.out.println(text);
            // clear text
                   float y=Integer.parseInt(text);
                   float R = (float) (1.0*(r) / 100);
                   float e = (float) (Integer.parseInt(AmountT.getText()) * R * (Math.pow((1 + R), y)) / ((Math.pow((1 + R), y)) - 1));
                   float intrest=e*y-Integer.parseInt(AmountT.getText());
                   EMIT.setText(String.valueOf(e));
                   IntrestT.setText(String.valueOf(intrest));
        }
    }
});
                 EMIT.setOnKeyPressed(new EventHandler<KeyEvent>() {
               @Override
               
               public void handle(KeyEvent keyEvent) {
               if (keyEvent.getCode() == KeyCode.ENTER)  {
                   String text = EMIT.getText();

            // do your thing...
                   System.out.println(text);
            // clear text
                   double e=Double.parseDouble(text);
                   double R = (float) (1.0*(r) / 100);
                   double Amount=Integer.parseInt(AmountT.getText());
                   double y=Math.log10(e/(e-R*Amount))/Math.log10(1+R);
                   double intrest=e*y-Amount;
                   TimeT.setText(String.valueOf(y));
                   IntrestT.setText(String.valueOf(intrest));
        }
    }
});  
            }
            scrollpane1.setContent(hbox);
   
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
    private void handleInventory(MouseEvent event) {
    }

    @FXML
    private void handleLoanClick(MouseEvent event) {
    }

    @FXML
    private void handleloyalty(MouseEvent event) {
    }

    @FXML
    private void handleOverviewClick(MouseEvent event) {
    }
     
}
