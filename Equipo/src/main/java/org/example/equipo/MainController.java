package org.example.equipo;
import Data.EquipoMysqlDAO;
import Model.Equipo;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
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
        cargarDatosTabla();
    }
    @FXML
    public void onActionTextLogin(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("create-view.fxml"));
            Parent root=fxmlLoader.load();
            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void cargarDatosTabla() {
        try {
            EquipoMysqlDAO equipoDAO = new EquipoMysqlDAO();
            List<Equipo> listaEquipos = equipoDAO.findAll();
            ObservableList<Equipo> datosObservable = FXCollections.observableArrayList(listaEquipos);
            TablaId.setItems(datosObservable);

            IdColumna.setCellValueFactory(cellData -> {
                Equipo equipo = cellData.getValue();
                return new SimpleStringProperty(equipo.getId().toString());
            });
            NombreColumna.setCellValueFactory(cellData -> {
                Equipo equipo = cellData.getValue();
                return new SimpleStringProperty(equipo.getNombre());
            });
            CategoriaColumna.setCellValueFactory(cellData -> {
                Equipo equipo = cellData.getValue();
                return new SimpleStringProperty(equipo.getCategoria());
            });
            DispColumna.setCellValueFactory(cellData -> {
                Equipo equipo = cellData.getValue();
                return new SimpleStringProperty(equipo.getDisponible());
            });
        } catch (Exception e) {
            System.out.println("ERROR DETECTADO:");
            e.printStackTrace();
        }
    }

}
