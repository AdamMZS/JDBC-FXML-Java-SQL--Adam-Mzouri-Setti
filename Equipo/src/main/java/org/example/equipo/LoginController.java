package org.example.equipo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController implements Initializable{


    @FXML
    private void callMainFx() {
        // Handle login button action here
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main-view.fxml"));
            Parent root=fxmlLoader.load();
            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private Button loginButton;

@Override
public void initialize(java.net.URL location, java.util.ResourceBundle resources) {
    loginButton.setOnAction(event -> callMainFx());
    }

}
