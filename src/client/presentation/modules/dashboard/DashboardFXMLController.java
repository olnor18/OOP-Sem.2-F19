/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.presentation.modules.dashboard;

import client.presentation.CommunicationHandler;
import com.jfoenix.controls.JFXListView;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
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
    private JFXListView<ActivityEntry> activityView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        name.setText(CommunicationHandler.getInstance().getName());
        ActivityEntry[] ActivityEntries = new ActivityEntry[]{
            new ActivityEntry(("Login"), new Date(), "Common login"),
            new ActivityEntry(("Delete"), new Date(), "Everything"),
            new ActivityEntry(("Login"), new Date(), "Common login"),
            new ActivityEntry(("Delete"), new Date(), "Everything"),
            new ActivityEntry(("Login"), new Date(), "Common login"),
            new ActivityEntry(("Delete"), new Date(), "Everything"),
            new ActivityEntry(("Login"), new Date(), "Common login"),
            new ActivityEntry(("Delete"), new Date(), "Everything"),
            new ActivityEntry(("Login"), new Date(), "Common login"),
            new ActivityEntry(("Delete"), new Date(), "Everything"),
            new ActivityEntry(("Login"), new Date(), "Common login"),
            new ActivityEntry(("Delete"), new Date(), "Everything"),
            new ActivityEntry(("Login"), new Date(), "Common login"),
            new ActivityEntry(("Delete"), new Date(), "Everything"),
            new ActivityEntry(("Login"), new Date(), "Common login"),
            new ActivityEntry(("Delete"), new Date(), "Everything"),
            new ActivityEntry(("Login"), new Date(), "Common login"),
            new ActivityEntry(("Delete"), new Date(), "Everything"),
            new ActivityEntry(("Login"), new Date(), "Common login"),
            new ActivityEntry(("Delete"), new Date(), "Everything"),
            new ActivityEntry(("Create journal"), new Date(), "Frederik Hounsvwad awdawdawdad")
        };

        activityView.getItems().addAll(ActivityEntries);
        activityView.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                activityView.getSelectionModel().getSelectedItem().showPopup();
            }
        });

    }

}
