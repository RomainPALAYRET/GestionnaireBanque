module com.example.gestionnairebanque {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.gestionnairebanque to javafx.fxml;
    exports com.example.gestionnairebanque;
}