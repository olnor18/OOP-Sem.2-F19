/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.presentation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.SubScene;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Oliver
 */
public class MainFXMLController implements Initializable {

    @FXML
    private SubScene module;
    @FXML
    private VBox menu;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Side-menu
        menu.prefHeightProperty().bind(module.heightProperty());
        TranslateTransition menuTranslation = new TranslateTransition(Duration.millis(500), menu);
        menuTranslation.setFromX(-140);
        menuTranslation.setToX(0);
        menu.setOnMouseEntered(evt -> {
            menuTranslation.setRate(1);
            menuTranslation.play();
        });
        menu.setOnMouseExited(evt -> {
            menuTranslation.setRate(-1);
            menuTranslation.play();
        });
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("modules/dashboard/DashboardFXML.fxml"));
            Parent root = loader.load();
            module.setRoot(root);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }    
    
}
