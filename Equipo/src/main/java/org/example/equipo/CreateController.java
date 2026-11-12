package org.example.equipo;

import Data.DAO;
import Data.EquipoMysqlDAO;
import Model.Equipo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
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
    @FXML
    private Button SalirButton;
    @FXML
    private Button guardarButton;
    //CONFIG TABLA

    @FXML
    private void guardar() {
        EquipoMysqlDAO dao = new EquipoMysqlDAO();
        DAO<Equipo> dao1 = new EquipoMysqlDAO();
        Equipo equipo = new Equipo();
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Guardado");
        alerta.setHeaderText("Se guardaron los cambuios correctamente");
        alerta.setContentText("Nombre:"+TextNombre.getText()+" ,Id:"+spinnerID.getValueFactory().getValue()+" ,Disponible:"+(CheckDisponible.isSelected()?"Si":"No")+" ,categoria:"+ChoiceCat.getSelectionModel().getSelectedItem());
        alerta.showAndWait();
        equipo = new Equipo(String.valueOf(spinnerID.getValueFactory().getValue()),TextNombre.getText(),ChoiceCat.getSelectionModel().getSelectedItem(),String.valueOf(CheckDisponible.isSelected()));
        dao.save(equipo);

    }
    @FXML
    private void onHelloButtonClick() {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setContentText("Saliendo");
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

}