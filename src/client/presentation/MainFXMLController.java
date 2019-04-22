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
import javafx.scene.SubScene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

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
    @FXML
    private GridPane menuGrid;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Side-menu
        menu.prefHeightProperty().bind(((AnchorPane) menu.getParent()).heightProperty());
        module.heightProperty().bind(menu.heightProperty());
        module.widthProperty().bind(((Pane) module.getParent()).widthProperty());
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

        //Set home path to dashboard
        getNodeFromGridPane(menuGrid, 0, 0).setOnMouseClicked((e) -> loadSubScene("modules/dashboard/DashboardFXML.fxml"));
        getNodeFromGridPane(menuGrid, 1, 0).setOnMouseClicked((e) -> loadSubScene("modules/dashboard/DashboardFXML.fxml"));

        getNodeFromGridPane(menuGrid, 0, 1).setOnMouseClicked((e) -> loadSubScene("modules/calendar/CalendarFXML.fxml"));
        getNodeFromGridPane(menuGrid, 1, 1).setOnMouseClicked((e) -> loadSubScene("modules/calendar/CalendarFXML.fxml"));
        
        //getNodeFromGridPane(menuGrid, 0, 1).setOnMouseClicked((e) -> loadSubScene("LoginFXML.fxml"));
        //getNodeFromGridPane(menuGrid, 1, 1).setOnMouseClicked((e) -> loadSubScene("LoginFXML.fxml"));

        loadSubScene("modules/dashboard/DashboardFXML.fxml");
        //loadSubScene("LoginFXML.fxml");
    }

    public void loadSubScene(String path) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
            Parent root = loader.load();
            module.setRoot(root);
            //module.setRoot(FXMLLoader.load(getClass().getResource(path)));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                return node;
            }
        }
        return null;
    }

}
