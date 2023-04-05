package com.example.aprilproject.Controllers;

import com.example.aprilproject.HibernateTools.UserService;
import com.example.aprilproject.Objects.User;
import com.example.aprilproject.WindowsManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.util.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class ListUserController implements Initializable {

    @FXML
    private Button buttonAddUser;

    @FXML
    private Button buttonDeleteUser;
    @FXML
    private Button refreshButton;

    @FXML
    private Button buttonEditUser;
    ObservableList<User>listaWynikow= FXCollections.observableArrayList();

    @FXML
    private TableView<User> tableUsers;

    @FXML
    private TableColumn<User, Integer> kolumnaID;
    public void przygotujListe(){
        listaWynikow.clear();
        UserService serwis=new UserService();
        List<User>uzytkownicy=serwis.getAllUsers();
        System.out.println(uzytkownicy.size());
        for(int licznik=0;licznik<uzytkownicy.size();licznik++){
        listaWynikow.add(uzytkownicy.get(licznik));
       }
        tableUsers.setItems(listaWynikow);
        tableUsers.refresh();
    }
    public void printSelected(){
        TableView.TableViewSelectionModel selectedUser=tableUsers.getSelectionModel();
        User selection= (User) selectedUser.getSelectedItem();
        System.out.println("Zaznaczony to:"+selection.getLogin());

    }
    @FXML
    private TableColumn<User, String> kolumnaLogin;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        UserService serwis=new UserService();
        kolumnaID.setCellValueFactory(new PropertyValueFactory<User,Integer>("id"));
        kolumnaLogin.setCellValueFactory(new PropertyValueFactory<User,String>("login"));
        przygotujListe();

        buttonDeleteUser.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                printSelected();
                Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Czy jesteś pewien usunięcia?");
                Optional<ButtonType>result=alert.showAndWait();
                if(result.get()==ButtonType.OK){
                    TableView.TableViewSelectionModel selectedUser=tableUsers.getSelectionModel();
                    User selection= (User) selectedUser.getSelectedItem();
                    serwis.deleteUserByID(selection.getId());
                    WindowsManager.pokazAlert("Poprawnie usunięto");
                    przygotujListe();

                }
            }
        });
        refreshButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                przygotujListe();
            }
        });




        buttonAddUser.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    WindowsManager.noweOkno("Nowy użytkownik","user-add-view.fxml");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
