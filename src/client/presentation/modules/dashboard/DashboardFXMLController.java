/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.presentation.modules.dashboard;

import static client.presentation.utils.StringUtils.getBoldString;
import com.jfoenix.controls.JFXListView;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
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
public class DashboardFXMLController implements Initializable
{

    @FXML
    private Text name;
    @FXML
    private JFXListView<ActivityEntry> activityView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        ActivityEntry[] ActivityEntries = new ActivityEntry[]
        {
            new ActivityEntry(getBoldString("Login"), new Date(), "Common login"),
            new ActivityEntry(getBoldString("Delete"), new Date(), "Everything"),
            new ActivityEntry(getBoldString("Login"), new Date(), "Common login"),
            new ActivityEntry(getBoldString("Delete"), new Date(), "Everything"),
            new ActivityEntry(getBoldString("Login"), new Date(), "Common login"),
            new ActivityEntry(getBoldString("Delete"), new Date(), "Everything"),
            new ActivityEntry(getBoldString("Login"), new Date(), "Common login"),
            new ActivityEntry(getBoldString("Delete"), new Date(), "Everything"),
            new ActivityEntry(getBoldString("Login"), new Date(), "Common login"),
            new ActivityEntry(getBoldString("Delete"), new Date(), "Everything"),
            new ActivityEntry(getBoldString("Login"), new Date(), "Common login"),
            new ActivityEntry(getBoldString("Delete"), new Date(), "Everything"),
            new ActivityEntry(getBoldString("Login"), new Date(), "Common login"),
            new ActivityEntry(getBoldString("Delete"), new Date(), "Everything"),
            new ActivityEntry(getBoldString("Login"), new Date(), "Common login"),
            new ActivityEntry(getBoldString("Delete"), new Date(), "Everything"),
            new ActivityEntry(getBoldString("Login"), new Date(), "Common login"),
            new ActivityEntry(getBoldString("Delete"), new Date(), "Everything"),
            new ActivityEntry(getBoldString("Login"), new Date(), "Common login"),
            new ActivityEntry(getBoldString("Delete"), new Date(), "Everything"),
            new ActivityEntry(getBoldString("Create journal"), new Date(), "Frederik Hounsvwad awdawdawdad")
        };

        activityView.getItems().addAll(ActivityEntries);
        activityView.setOnMouseClicked(new EventHandler<MouseEvent>()
        {

            @Override
            public void handle(MouseEvent event)
            {
                activityView.getSelectionModel().getSelectedItem().showPopup();
            }
        });

    }

}
