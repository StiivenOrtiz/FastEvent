module com.fastevent.fastevent {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;


    opens com.fastevent.fastevent to javafx.fxml;
    exports com.fastevent.fastevent;
    exports com.fastevent.fastevent.Controladores;
    opens com.fastevent.fastevent.Controladores to javafx.fxml;
    exports com.fastevent.fastevent.Controladores.SesionNoIniciada;
    opens com.fastevent.fastevent.Controladores.SesionNoIniciada to javafx.fxml;
    exports com.fastevent.fastevent.Controladores.SesionIniciada;
    opens com.fastevent.fastevent.Controladores.SesionIniciada to javafx.fxml;
}