package com.example.aprilproject.Controllers;

import com.example.aprilproject.HibernateTools.DepositService;
import com.example.aprilproject.Objects.Deposit;
import com.example.aprilproject.WindowsManager;
import com.example.aprilproject.staleProjektu;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.SubScene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import static antlr.build.ANTLR.root;

public class DepositAddingController implements Initializable {

    @FXML
    private Button addButton;
    String[]metodyWplat=new String[3];


    @FXML
    private Button cancelButton;

    @FXML
    private DatePicker depositDateInput;



    @FXML
    private TextField depositInput;

    @FXML
    private ChoiceBox<String> depositType;

    @FXML
    private AnchorPane oknoDeposit;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        metodyWplat[0]="Paysafecard";
        metodyWplat[1]="Konto";
        metodyWplat[2]="Revolut";

        depositType.getItems().addAll(metodyWplat);
        cancelButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage okno= (Stage) cancelButton.getScene().getWindow();
                okno.close();
            }
        });
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                double valueOfDeposit= Double.parseDouble(depositInput.getText());
                LocalDate dateOfDeposit=depositDateInput.getValue();
                String methodOfDeposit=depositType.getValue();
                /*System.out.println("Kwota:"+valueOfDeposit);
                System.out.println("Data:"+dateOfDeposit.toString());
                System.out.println("Metoda:"+methodOfDeposit);
                System.out.println("Uzytkownik:"+staleProjektu.loggedUser.getLogin());

                System.out.println("ID uzytkownika:"+staleProjektu.loggedUser.getId());
                 */
                Deposit newDeposit=new Deposit(valueOfDeposit,dateOfDeposit,staleProjektu.loggedUser.getId(),methodOfDeposit);
                System.out.println(newDeposit.toString());
                DepositService serwis=new DepositService();
                serwis.addDeposit(newDeposit);
                WindowsManager.pokazAlert("Poprawnie dodano wpłatę");

            }
        });

    }
}
