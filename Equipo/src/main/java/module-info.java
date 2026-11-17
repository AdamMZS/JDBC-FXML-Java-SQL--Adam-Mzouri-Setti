module org.example.equipo {

    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires jdk.compiler;
    requires java.sql;
    requires mysql.connector.j;
    requires java.naming;
    opens org.example.equipo to javafx.fxml;
    exports org.example.equipo;
    exports Model;
    opens Model to javafx.fxml;
}