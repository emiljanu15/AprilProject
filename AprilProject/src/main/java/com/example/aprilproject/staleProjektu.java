package com.example.aprilproject;

import com.example.aprilproject.Objects.User;

public class staleProjektu {
    public static String uzytkownik;
    public static User loggedUser;
    public static double saldoUser=0;
    public static double saldoKonta;
    public static void ustawZalogowanegoUsera(User user){
        loggedUser=user;
        uzytkownik=loggedUser.getLogin();
    }
    public static void ustawZalogowanego(String nazwaUzytkownika){
        uzytkownik=nazwaUzytkownika;
    }
}
