package org.example.equipo;

import Model.Equipo;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private TableView<Equipo> TablaId;
    @FXML
    private TableColumn<Equipo, String> IdColumna;
    @FXML
    private TableColumn<Equipo, String> NombreColumna;
    @FXML
    private TableColumn<Equipo, String> CategoriaColumna;
    @FXML
    private TableColumn<Equipo, String> DispColumna;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        IdColumna.setCellValueFactory((line)->{
            Equipo equipo=line.getValue();
            Long id=Long.valueOf(equipo.getId());
            return new SimpleStringProperty(id.toString());
        });
    }
}
