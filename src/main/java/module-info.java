module com.fastevent.fastevent {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.fastevent.fastevent to javafx.fxml;
    exports com.fastevent.fastevent;
}