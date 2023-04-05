package com.example.aprilproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class WindowsManager {
    public static void pokazAlert(String trescAlertu) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, trescAlertu);
        alert.show();
    }


    public static void noweOkno(String nazwaOkna, String nazwaPlikuSzablonu) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource(nazwaPlikuSzablonu));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle(nazwaOkna);
        stage.setScene(scene);
        stage.show();
    }
    public static void pokazAlertPotwierdzajacy(String trescAlertu){
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION,trescAlertu);
        alert.show();
    }
}

