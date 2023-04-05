module com.example.aprilproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires java.naming;
    requires java.persistence;
    requires java.sql;
    requires antlr;


    opens com.example.aprilproject to javafx.fxml;
    opens com.example.aprilproject.Objects to org.hibernate.orm.core, javafx.base;
    exports com.example.aprilproject;
    opens com.example.aprilproject.ProgresjaProgram to javafx.fxml, javafx.base;
    exports com.example.aprilproject.Controllers;
    opens com.example.aprilproject.Controllers to javafx.fxml;
}