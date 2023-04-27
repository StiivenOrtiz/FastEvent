module com.fastevent.fastevent {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.fastevent.fastevent to javafx.fxml;
    exports com.fastevent.fastevent;
    exports com.fastevent.fastevent.Controladores;
    opens com.fastevent.fastevent.Controladores to javafx.fxml;
    exports com.fastevent.fastevent.Controladores.PantallaInicial.SesionNoIniciada;
    opens com.fastevent.fastevent.Controladores.PantallaInicial.SesionNoIniciada to javafx.fxml;
}