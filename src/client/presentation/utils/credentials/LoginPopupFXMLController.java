/*This is code written by Frederik Alexander Hounsvad
 * The use of this code in a non commercial and non exam environment is permitted
 */
package client.presentation.utils.credentials;

import client.presentation.CommunicationHandler;
import static client.presentation.LoginFXMLController.pWord;
import static client.presentation.LoginFXMLController.uName;
import com.google.common.hash.Hashing;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.ImageView;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hounsvad
 */
public class LoginPopupFXMLController implements Initializable {

    @FXML
    private JFXTextField username;
    @FXML
    private JFXPasswordField password;
    @FXML
    private Label message;
    @FXML
    private Pane loadpane;
    @FXML
    private ImageView loadblur;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadpane.setVisible(false);
        loadblur.setEffect(new GaussianBlur(5));
        username.textProperty().addListener((observable, oldValue, newValue)
                -> {
            if (!newValue.isEmpty() && username.getStyleClass().contains("wrong-credentials")) {
                username.getStyleClass().remove("wrong-credentials");
                password.getStyleClass().remove("wrong-credentials");
                message.setText("");
            }
        });

        password.textProperty().addListener((observable, oldValue, newValue)
                -> {
            if (!newValue.isEmpty() && password.getStyleClass().contains("wrong-credentials")) {
                username.getStyleClass().remove("wrong-credentials");
                password.getStyleClass().remove("wrong-credentials");
                message.setText("");
            }
        });
    }

    @FXML
    private void skip(ContextMenuEvent event) {
    }

    @FXML
    private void handleLoginButtonAction() {
        loadpane.setVisible(true);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                List<String[]> sqlReturn = CommunicationHandler.getInstance().sendQuery(new String[]{"login", username.getText(), Hashing.sha256().hashString(password.getText(), Charset.forName("UTF8")).toString()});
                if (sqlReturn != null && !sqlReturn.isEmpty()) {
                    uName = username.getText();
                    pWord = password.getText();
                    Platform.runLater(() -> {
                        loadMain();
                        closeStage();
                    });

                } else if (username.getText().isEmpty() || password.getText().isEmpty()) {
                    System.err.println("Please enter a username and a password!");
                    Platform.runLater(()
                            -> {
                        message.setText("Please enter a username and a password!");
                        username.getStyleClass().add("wrong-credentials");
                        password.getStyleClass().add("wrong-credentials");
                    });

                } else {
                    System.err.println("Wrong username or password!");
                    Platform.runLater(()
                            -> {
                        message.setText("Wrong username or password!");
                        password.setText("");
                        username.getStyleClass().add("wrong-credentials");
                        password.getStyleClass().add("wrong-credentials");
                    });

                }
                Platform.runLater(()
                        -> {
                    loadpane.setVisible(false);
                });

            }
        });
        t.start();
    }

    @FXML
    private void handleCancelButtonAction() {
        System.exit(0);
    }

    private void closeStage() {
        ((Stage) username.getScene().getWindow()).close();
    }

}
