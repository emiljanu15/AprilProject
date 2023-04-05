package com.example.aprilproject.HibernateTools;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.List;

public class Services {
    public Session openSession(){
        StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory sessionFactory=metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
        return session;
    }

    public static void main(String[] args) {
        System.out.println("TESTOWANIE SRODOWISKA");
        Services serwis=new Services();
        Session sesja=serwis.openSession();
        sesja.close();
        System.out.println("PRAWIDŁOWO");
    }

}
