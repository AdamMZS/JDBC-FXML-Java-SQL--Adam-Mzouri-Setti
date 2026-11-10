package org.example.equipo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //spinner--> factory
        spinnerID.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1,100,1,1) {
        });
        //choice(table view,Listview) --> items-> selectionModel

        ObservableList<String> datos= FXCollections.observableArrayList();
        /* ChoiceCat.getItems().add("Laptop");
        ChoiceCat.getItems().add("Tablet");
        ChoiceCat.getItems().add("Desktop");
        ChoiceCat.getItems().add("Varios");
        ChoiceCat.getItems().addAll("Monitor","Hola");
        ChoiceCat.getSelectionModel().selectFirst();
        **/
        datos.addAll("Monitor","Desktop","Laptop","Tablet");
        ChoiceCat.setItems(datos);
    }
    @FXML
    private ChoiceBox<String> ChoiceCat;
    @FXML
    private Label welcomeText1;
    @FXML
    private TextField TextNombre;
    @FXML
    private CheckBox CheckDisponible;
    @FXML
    private Spinner<Integer> spinnerID;
    @FXML
    private Label welcomeText111;
    @FXML
    private Label welcomeText;
    @FXML
    private Label welcomeText11;






    //CONFIG TABLA

    private void guardar() {

        Alert alerta = new Alert(Alert.AlertType.INFORMATION);

        alerta.setTitle("Guardado");
        alerta.setHeaderText("Se guardaron los cambuios correctamente");
        alerta.setContentText("Nombre:"+TextNombre.getText()+" ,Id:"+spinnerID.getValueFactory().getValue()+" ,Disponible:"+(CheckDisponible.isSelected()?"Si":"No")+" ,categoria:"+ChoiceCat.getSelectionModel().getSelectedItem());
        alerta.showAndWait();

    }
    @FXML
    private void onHelloButtonClick() {

        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setContentText("Saliendo");
        alerta.showAndWait();
        alerta.close();
    }

}