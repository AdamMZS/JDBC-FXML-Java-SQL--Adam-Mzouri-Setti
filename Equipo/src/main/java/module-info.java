module org.example.equipo {

    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires jdk.compiler;

    opens org.example.equipo to javafx.fxml;
    exports org.example.equipo;
    exports Model;
    opens Model to javafx.fxml;
}