package org.example;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryProvider {

    private final static SessionFactory sessionFactory= new Configuration()
    .configure()
    .buildSessionFactory();

    private SessionFactoryProvider(){

    }
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
