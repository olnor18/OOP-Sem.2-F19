/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.presentation.modules.dashboard;

import com.jfoenix.controls.JFXListView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Oliver
 */
public class DashboardFXMLController implements Initializable {

    @FXML
    private Text name;
    @FXML
    private JFXListView<Label> activityView;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //activityView.getItems().add(new ActivityEntry("Login", new Date(), "Common login"));
        //activityView.getItems().add(new Label("hello"));
    }    
    
}
