package com.example.aprilproject.HibernateTools;

import com.example.aprilproject.Objects.Deposit;
import com.example.aprilproject.Objects.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class DepositService {
    Services serwis=new Services();
    double saldoUser=0;
    public void addDeposit(Deposit newDeposit){
        Session sesja=serwis.openSession();
        Transaction transakcja= sesja.beginTransaction();
        sesja.save(newDeposit);
        transakcja.commit();
        sesja.close();
    }
    public Deposit getDepositsByLogin(String id){
        Session sesja= serwis.openSession();
        //User user=new User();
        Deposit deposit=new Deposit();
        Transaction transaction=sesja.beginTransaction();
        String hql="FROM Deposit WHERE createdByUserID ='"+id+"'";
        Query query=sesja.createQuery(hql);
        //System.out.println(query.getResultList());
        List<Deposit> Wyniki=query.getResultList();
        //System.out.println(Wyniki.get(0));
        sesja.close();
        try{
            deposit=Wyniki.get(0);}
        catch(IndexOutOfBoundsException e){
            System.out.println("Nie ma depozytów");
        }
        return deposit;}
    public List<Deposit>getListDepositsByLogin(int id){
        Session sesja= serwis.openSession();
        //User user=new User();
        Deposit deposit=new Deposit();
        Transaction transaction=sesja.beginTransaction();
        String hql="FROM Deposit WHERE createdByUserID ='"+id+"'";
        Query query=sesja.createQuery(hql);
        //System.out.println(query.getResultList());
        List<Deposit> Wyniki=query.getResultList();
        //System.out.println(Wyniki.get(0));
        sesja.close();
        return Wyniki;
    }
    public void getSaldoValueDeposits(int id){
        double saldo=0;
        List<Deposit>wplaty=getListDepositsByLogin(id);
        for(int licznik=0;licznik<wplaty.size();licznik++){
            Deposit wplata=wplaty.get(licznik);
            saldo+=wplata.getValueOfDeposit();
        }
        System.out.println(saldo);
    }
    public double getSaldoUser(int id){
        double saldo=0;
        List<Deposit>wplaty=getListDepositsByLogin(id);
        for(int licznik=0;licznik<wplaty.size();licznik++){
            Deposit wplata=wplaty.get(licznik);
            saldo+=wplata.getValueOfDeposit();
        }return saldo;

    }
    public static void main(String[] args) {
        DepositService serwis=new DepositService();
        //System.out.println(serwis.getDepositsByLogin(String.valueOf(1)));
        //System.out.println(serwis.getListDepositsByLogin(String.valueOf(1)));
        //serwis.getSaldoValueDeposits(String.valueOf(1));
        //System.out.println(serwis.getSaldoUser(1));


    }
}
