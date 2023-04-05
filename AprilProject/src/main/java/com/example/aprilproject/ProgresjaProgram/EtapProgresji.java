package com.example.aprilproject.ProgresjaProgram;


import java.text.DecimalFormat;

public class EtapProgresji {
    DecimalFormat df=new DecimalFormat();
    public int getEtap() {
        return etap;
    }

    public void setEtap(int etap) {
        this.etap = etap;
    }


    public EtapProgresji(double stawka, double kurs, double wygrana, double zysk, int etap) {
        df.setMaximumFractionDigits(2);
        this.stawka = stawka;
        this.kurs = kurs;

        this.wygrana = wygrana;
        this.zysk = zysk;
        this.etap=etap;
        this.formatWygrana=df.format(wygrana);
        this.formatZysk=df.format(zysk);
    }

    double stawka;
    double kurs;
    double wygrana;
    double zysk;
    int etap;
    String formatWygrana;
    String formatZysk;

    public String getFormatWygrana() {
        return formatWygrana;
    }

    public void setFormatWygrana(String formatWygrana) {
        this.formatWygrana = formatWygrana;
    }

    public String getFormatZysk() {
        return formatZysk;
    }

    public void setFormatZysk(String formatZysk) {
        this.formatZysk = formatZysk;
    }

    @Override
    public String toString() {
        return "EtapProgresji{" +
                "stawka=" + stawka +
                ", kurs=" + kurs +
                ", wygrana=" + wygrana +
                ", zysk=" + zysk +
                '}';
    }

    public double getStawka() {
        return stawka;
    }

    public void setStawka(double stawka) {
        this.stawka = stawka;
    }

    public double getKurs() {
        return kurs;
    }

    public void setKurs(double kurs) {
        this.kurs = kurs;
    }



    public void setWygrana(double wygrana) {
        this.wygrana = wygrana;
    }

    public DecimalFormat getDf() {
        return df;
    }

    public void setDf(DecimalFormat df) {
        this.df = df;
    }

    public double getWygrana() {
        return wygrana;
    }

    public double getZysk() {
        return zysk;
    }

    public void setZysk(double zysk) {
        this.zysk = zysk;
    }

    public EtapProgresji() {
    }
}
