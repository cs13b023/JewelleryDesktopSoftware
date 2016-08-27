/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chitfund;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

/**
 *
 * @author akshay
 */
public class combobox {

    static void chitscombobox(ComboBox comboBox, ObservableList<String> data) {
         //To change body of generated methods, choose Tools | Templates.
         comboBox.getItems().clear();
         comboBox.setEditable(true);
         SqlLoginchit.executeQuery("select chitname from chitslist",data);
    }
}
