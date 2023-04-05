package com.example.aprilproject.Controllers;

import com.example.aprilproject.HibernateTools.DepositService;
import com.example.aprilproject.Objects.Deposit;
import com.example.aprilproject.Objects.User;
import com.example.aprilproject.WindowsManager;
import com.example.aprilproject.staleProjektu;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class ListDepositController implements Initializable {


    @FXML
    private TableView<Deposit> depositTabela;
    ObservableList<Deposit> listaWynikow= FXCollections.observableArrayList();

    @FXML
    private Button addDepositButton;

    public void przygotujListe(){
        listaWynikow.clear();
        DepositService serwis=new DepositService();
        List<Deposit> deposits=serwis.getListDepositsByLogin(staleProjektu.loggedUser.getId());
        System.out.println(deposits.size());
        for(int licznik=0;licznik<deposits.size();licznik++){
            listaWynikow.add(deposits.get(licznik));
        }
        depositTabela.setItems(listaWynikow);
        depositTabela.refresh();
    }

    @FXML
    private TableColumn<Deposit, LocalDate> columnDataWplaty;

    @FXML
    private TableColumn<Deposit,Double> columnKwotaWplaty;

    @FXML
    private TableColumn<Deposit,String> columnMetodaWplaty;

    @FXML
    private Button deleteDepositButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        columnKwotaWplaty.setCellValueFactory(new PropertyValueFactory<Deposit,Double>("valueOfDeposit"));
        columnDataWplaty.setCellValueFactory(new PropertyValueFactory<Deposit,LocalDate>("dateOfDeposit"));

        columnMetodaWplaty.setCellValueFactory(new PropertyValueFactory<Deposit,String>("methodDeposit"));
        przygotujListe();



        addDepositButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    WindowsManager.noweOkno("Dodaj wpłatę","deposit-add-view.fxml");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
