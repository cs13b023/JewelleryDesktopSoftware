/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sales;

/**
 *
 * @author vinay kumar reddy
*/
import java.io.File;
/*from  w w  w  . ja  va  2  s . co m*/
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextAreaBuilder;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBoxBuilder;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
 
public class FileChooserSample extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(final Stage primaryStage) {
        Group root = new Group();
         
        Button buttonLoad = new Button("Load");
        buttonLoad.setOnAction(new EventHandler<ActionEvent>(){
             @Override
            public void handle(ActionEvent arg0) {
                FileChooser fileChooser = new FileChooser();
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
                fileChooser.getExtensionFilters().add(extFilter);
                File file = fileChooser.showOpenDialog(primaryStage);
                System.out.println(file);
            }
        });
        VBox vBox = VBoxBuilder.create()
                .children(buttonLoad)
                .build();
        root.getChildren().add(vBox);
        primaryStage.setScene(new Scene(root, 500, 400));
        primaryStage.show();
    }

}
