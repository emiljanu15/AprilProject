package com.example.aprilproject.Controllers;

import com.example.aprilproject.HibernateTools.DepositService;
import com.example.aprilproject.HibernateTools.UserService;
import com.example.aprilproject.Objects.User;
import com.example.aprilproject.WindowsManager;
import com.example.aprilproject.staleProjektu;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    WindowsManager okna=new WindowsManager();


    @FXML
    private Button addButtonDeposit;

    @FXML
    private Tab homePanel;

    @FXML
    private Button listDepositButton;

    @FXML
    private Button listUserButton;

    @FXML
    private Button loginButton;

    @FXML
    private TextField loginInput;
    String logonUser;

    @FXML
    private Tab logonPanel;
    @FXML
    private Button progressionProgramButton;

    @FXML
    private Button newUserButton;

    @FXML
    private PasswordField passwordInput;
    @FXML
    private TextField logonUserInput;
    @FXML
    private TextField sumAccountDisplay;
    @FXML
    private Button addWithdrawButton;

    @FXML
    private TabPane scenaGlowna;

    @FXML
    private Button exitButton;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //System.out.println("Kliknięto przycisk zaloguj");
                UserService serwis=new UserService();
                String login=loginInput.getText();
                String password=passwordInput.getText();
                if(serwis.checkExistUser(login)==true){
                    User testUser=serwis.getUserByLogin(login);
                    //System.out.println(testUser);
                    if(password.equals(testUser.getPassword())){
                        WindowsManager.pokazAlert("Poprawnie zalogowano");
                        homePanel.disableProperty().setValue(false);
                        scenaGlowna.getSelectionModel().selectNext();
                        logonPanel.getTabPane().getTabs().remove(logonPanel);
                        staleProjektu.ustawZalogowanegoUsera(testUser);
                        logonUser=staleProjektu.uzytkownik;
                        logonUserInput.setText(logonUser);
                        System.out.println(staleProjektu.loggedUser);
                        DepositService serwis2=new DepositService();
                        staleProjektu.saldoKonta=serwis2.getSaldoUser(staleProjektu.loggedUser.getId());
                        sumAccountDisplay.setText(staleProjektu.saldoKonta+" PLN");
                    }else{
                        WindowsManager.pokazAlert("Hasło nieprawidłowe");
                    }
                }
                else{
                    WindowsManager.pokazAlert("Nie ma takiego użytkownika");
                }
                //System.out.println(serwis.checkExistUser(login));
                //User loggingUser=serwis.getUserByLogin(login);

                /*homePanel.disableProperty().setValue(false);
                scenaGlowna.getSelectionModel().selectNext();
                logonPanel.getTabPane().getTabs().remove(logonPanel);
                logonUser=loginInput.getText();
                staleProjektu.ustawZalogowanego(logonUser);
                okna.pokazAlert("Pomyślnie zalogowano:"+logonUser);
                logonUserInput.setText(staleProjektu.uzytkownik);
                 */


            }
        });
        addButtonDeposit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    WindowsManager.noweOkno("Dodaj wpłatę","deposit-add-view.fxml");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        listDepositButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    WindowsManager.noweOkno("Lista wpłat","list-deposit-view.fxml");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        progressionProgramButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    WindowsManager.noweOkno("Program Progresja","progresja-view.fxml");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Platform.exit();
            }
        });
        newUserButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    WindowsManager.noweOkno("Dodaj uzytkownika","user-add-view.fxml");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        listUserButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    WindowsManager.noweOkno("Użytkownicy","list-user-view.fxml");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        });

    }
}
