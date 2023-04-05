package com.example.aprilproject.ProgresjaProgram;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class ProgresjaController implements Initializable {

    @FXML
    private Button calculateButton;

    @FXML
    private Button clearPolaButton;

    @FXML
    private Button clearTableButton;

    @FXML
    private TableColumn<EtapProgresji ,Integer> columnEtap;

    @FXML
    private TableColumn<EtapProgresji ,Double> columnStawka;

    @FXML
    private TableColumn<EtapProgresji ,Double> columnWygrana;

    @FXML
    private TableColumn<EtapProgresji ,Double> columnZysk;

    @FXML
    private TextField etapyInput;

    @FXML
    private TextField kursInput;
    @FXML
    private TableView<EtapProgresji > tabela;

    @FXML
    private Pane okno;

    @FXML
    private TextField stawkaInput;
    ObservableList<EtapProgresji >lista=FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        stawkaInput.setText("20");
        etapyInput.setText("10");
        kursInput.setText("1.30");
        DecimalFormat df=new DecimalFormat();
        df.setMaximumFractionDigits(2);
        columnEtap.setCellValueFactory(new PropertyValueFactory<EtapProgresji ,Integer>("Etap"));
        columnStawka.setCellValueFactory(new PropertyValueFactory<EtapProgresji ,Double>("Stawka"));
        columnWygrana.setCellValueFactory(new PropertyValueFactory<EtapProgresji ,Double>("Wygrana"));
        columnZysk.setCellValueFactory(new PropertyValueFactory<EtapProgresji ,Double>("Zysk"));


        calculateButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                lista.clear();
                double stawka= Double.parseDouble(stawkaInput.getText());
                double kurs= Double.parseDouble(kursInput.getText());
                int etapy= Integer.parseInt(etapyInput.getText());
                double wygrana;
                double zysk;
                int etap=0;
                for(int i=0;i<etapy;i++){
                    wygrana=stawka*kurs;
                    double roundOff=Math.round(wygrana*100.0)/100.0;
                    wygrana=roundOff;
                    etap=i+1;


                    //System.out.println("Etap:"+etap+" Wygrana:"+df.format(wygrana)+" Zysk:"+df.format(zysk));
                    zysk=wygrana-stawka;
                    double roundOff2=Math.round(zysk*100.0)/100.0;
                    zysk=roundOff2;

                    lista.add(new EtapProgresji(stawka,kurs,wygrana,zysk,etap));
                    stawka=wygrana;
                }
                tabela.setItems(lista);




            }
        });


        clearPolaButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                etapyInput.clear();
                kursInput.clear();
                stawkaInput.clear();

            }
        });
        clearTableButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                lista.clear();

            }
        });
    }
}
