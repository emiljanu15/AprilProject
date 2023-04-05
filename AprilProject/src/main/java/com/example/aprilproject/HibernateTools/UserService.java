package com.example.aprilproject.HibernateTools;

import com.example.aprilproject.Objects.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class UserService {
    private Query query;
    List<User>Wyniki;
    List<User>userResults;
    Services serwis=new Services();
    public void addUserTest(User user){
        if(checkExistUser(user.getLogin())==false){
            Session sesja= serwis.openSession();
            Transaction transaction = sesja.beginTransaction();
            sesja.save(user);
            transaction.commit();
            sesja.getSessionFactory().close();
            sesja.close();
            System.out.println("Poprawnie dodano uzytkownika:");
            System.out.println(user.toString());
                    }
        else{
            System.out.println("Błąd nie można stworzyć takiego samego użytkownika");
        }

    }
    public boolean checkExistUser(String testLogin){
        Session sesja= serwis.openSession();
        User user=new User();
        Transaction transaction=sesja.beginTransaction();
        String hql="FROM User WHERE login ='"+testLogin+"'";
        Query query=sesja.createQuery(hql);
        //System.out.println(query.getResultList());
        Wyniki=query.getResultList();
        System.out.println(Wyniki.isEmpty());
        if(Wyniki.isEmpty() == true){
            System.out.println("NIE ISTNIEJE");
            System.out.println("Można tworzyć użytkownika");
            return false;

        }else{
            System.out.println("UWAGA Taki użytkownik istnieje w systemie");
            //WindowsManager.pokazAlert("UWAGA Taki użytkownik istnieje w systemie");
            return true;

        }
    }
    public User getUserByLogin(String login){
        Session sesja= serwis.openSession();
        User user=new User();
        Transaction transaction=sesja.beginTransaction();
        String hql="FROM User WHERE login ='"+login+"'";
        Query query=sesja.createQuery(hql);
        //System.out.println(query.getResultList());
        List<User>Wyniki=query.getResultList();
        //System.out.println(Wyniki.get(0));
        sesja.close();
        try{
            user=Wyniki.get(0);}
        catch(IndexOutOfBoundsException e){
            System.out.println("Nie ma takiego użytkownika");
        }
        return user;
    }
    public List<User>getAllUsers(){
        Session sesja=serwis.openSession();
        Transaction transaction=sesja.beginTransaction();
        String hql="FROM User";
        Query query=sesja.createQuery(hql);
        userResults=query.getResultList();
        sesja.close();
        return (java.util.List<User>) userResults;
    }
    public void printAllUsers(){
        UserService serwisTestowy=new UserService();
        serwisTestowy.getAllUsers();
        //System.out.println(serwisTestowy.userResults.size());
        for(int licznik=0;licznik<serwisTestowy.userResults.size();licznik++){
            System.out.println(serwisTestowy.userResults.get(licznik));
        }

    }
    public void deleteUserByID(Integer id){
        Session sesja=serwis.openSession();
        Transaction transakcja=sesja.beginTransaction();
        User user=(User)sesja.get(User.class,id);
        sesja.delete(user);
        transakcja.commit();
        sesja.close();
        System.out.println("POPRAWNIE USUNIETO Uzytkownika:"+user.getLogin());

    }
    public void updateUserLogin(String login,String loginUpdate){
        Session sesja= serwis.openSession();
        User user=new User();
        Transaction transaction=sesja.beginTransaction();
        String hql="FROM User WHERE login ='"+login+"'";
        Query query=sesja.createQuery(hql);
        //System.out.println(query.getResultList());
        List<User>Wyniki=query.getResultList();
        System.out.println(Wyniki.get(0));
        user=Wyniki.get(0);
        System.out.println(user.getLogin());
        //zmiana na Kamil
        user.setLogin(loginUpdate);
        transaction.commit();
        sesja.close();
    }
    public static void main(String[] args) {
        UserService serwisTestowy=new UserService();
        //UserService serwisTestowy=new UserService();
        //serwisTestowy.getUserByLogin("Emil");
        //serwisTestowy.addUserTest(new User("Kamil","Jan"));
        //serwisTestowy.checkExistUser("Emil1");
        //serwisTestowy.printAllUsers();
        //serwisTestowy.deleteUserByID(2);
        //serwisTestowy.updateUserLogin("Kamil","Emil");
        serwisTestowy.printAllUsers();
        }


}
