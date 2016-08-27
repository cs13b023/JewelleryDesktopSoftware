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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
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
 * @author vinay kumar reddy
 */
public class TilePaneFun {
    
    public void tileDisplay(TilePane emp,ObservableList<ObservableList> data){
        emp.setHgap(5);
        emp.setVgap(5);
       System.out.println(data);
       System.out.println("inside td!");
        String name;
        try{
        for(int i=0;i<data.size();++i){
            VBox empTile=new VBox();
            int wstestid=Integer.valueOf((String)data.get(i).get(0));
            empTile.setId((String)data.get(i).get(0));
            
          /*  empTile.setOnMouseClicked(new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                    parameters.setvalue(empTile.getId());
     //             
                    Stage stage = new Stage();
                    Object root = null;
                    try {
                         System.out.println("Inside Try fun!!");
                        InvIDClass.setvalue(wstestid);
                            //int wsid= Integer.valueOf((String)data.get(i).get(0));
                        root = FXMLLoader.load(getClass().getResource("InventoryEditWholeSaler1.fxml"));
                    } catch (IOException ex) {
                        Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    stage.setScene(new Scene((Parent) root));
                    parameters.setvalue(empTile.getId());
     //               System.out.println(parameters.getEmpId());
                    stage.setTitle(empTile.getId());
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.initOwner(emp.getScene().getWindow());
                    stage.showAndWait();
                   refresh();
                }
        });*/
            HBox descTile=new HBox();
            VBox desc = new VBox();
            Label matname=new Label();
            matname.setStyle("-fx-text-fill:red; -fx-font-size: 20px;");
           
            if(true){
             
                desc.getChildren().add(matname);
               //
               descTile.getChildren().add(desc);
                //empTile.applyCss();
                empTile.getChildren().add(descTile);
                emp.getChildren().add(empTile);
                
            }
            System.out.println("Dont Know!");
            }
            
        }
        catch(Exception e){
                System.out.println(e);
                System.out.println("shit!");
            }
        
    }
    public void refresh(TilePane emp,String Query) throws SQLException
    {
        //emp.getChildren().clear();
        String MatName;
        
         System.out.println("Inside refresh!!");
            SqlLogin.executeNewContent(Query);
            System.out.println(Query);
             System.out.println(SqlLogin.data);
        tileDisplay(emp,SqlLogin.data);

    }
    
    
    
    
}

