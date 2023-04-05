package com.example.podstawyjava;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Progresja {
    public static void main(String[] args) {
        DecimalFormat df=new DecimalFormat();
        df.setMaximumFractionDigits(2);
        Scanner input=new Scanner(System.in);
        System.out.println("Podaj stawkę");
        double stawka=input.nextDouble();
        System.out.println("Podaj kurs");
        String kursWprowadzony=input.next();
        double kurs= Double.parseDouble(kursWprowadzony);
        double wygrana;
        System.out.println("Podaj ilosc etapow");
        int iloscEtapow=input.nextInt();
        double zysk;
        for(int i=0;i<iloscEtapow;i++){
            wygrana=stawka*kurs;
            int etap=i+1;
            zysk=wygrana-stawka;
            System.out.println("Etap:"+etap+" Wygrana:"+df.format(wygrana)+" Zysk:"+df.format(zysk));
            stawka=wygrana;
        }
    }
}

