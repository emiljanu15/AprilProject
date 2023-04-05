package com.example.aprilproject.Controllers;

import com.example.aprilproject.HibernateTools.UserService;
import com.example.aprilproject.MainApplication;
import com.example.aprilproject.Objects.User;
import com.example.aprilproject.WindowsManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class addUserController implements Initializable {

    @FXML
    private Button cancelButton;

    @FXML
    private TextField loginInput;

    @FXML
    private PasswordField passwordAgainInput;

    @FXML
    private PasswordField passwordInput;

    @FXML
    private Button saveButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cancelButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage stage= (Stage) cancelButton.getScene().getWindow();
                stage.close();
            }
        });
        saveButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String login=loginInput.getText();
                String password=passwordInput.getText();
                String passwordAgain=passwordAgainInput.getText();
                UserService serwisUser=new UserService();
                if(password.equals(passwordAgain)){
                    User addedUser=new User(login,password);
                    if(serwisUser.checkExistUser(addedUser.getLogin())==false){
                        serwisUser.addUserTest(addedUser);
                        WindowsManager.pokazAlert("Poprawnie dodano użytkownika:"+addedUser.getLogin());
;

                    }else{
                        WindowsManager.pokazAlert("Błąd taki użytkownik już istnieje");
                    }


                }else{
                    WindowsManager.pokazAlert("Błąd hasła się różnią");
                }
                //serwisUser.checkExistUser(login);
                }});

    }
}
