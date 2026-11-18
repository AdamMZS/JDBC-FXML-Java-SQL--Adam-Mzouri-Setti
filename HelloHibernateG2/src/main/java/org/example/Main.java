package org.example;

import models.Equipo;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
/*      -configurar POM
        -Añadir anoctaciones a los modelos
        -Configurar Hibernate

 */
    var cfg= new Configuration().configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory();

        sessionFactory.inSession(session -> {;
            var equipos = session.createQuery("from Equipo", models.Equipo.class).list();
            for (var equipo : equipos) {
                System.out.println(equipo);
            }
        });
        sessionFactory.inSession( session->{
            Equipo e10 = session.find(Equipo.class, 10);
            e10.setNombre(e10.getNombre().toUpperCase());
            System.out.println(e10);
        });
        sessionFactory.inTransaction( session->{
            Equipo e10 = session.find(Equipo.class, 10);
            e10.setNombre(e10.getNombre().toUpperCase());
            System.out.println(e10);
            session.getTransaction().rollback();
        });
        Equipo equipo=new Equipo();
        equipo.setNombre("EQUIPO PRUEBA");
        equipo.setCategoria("Prueba");
        equipo.setDisponible(false);
        sessionFactory.inTransaction( session->{
            session.persist(equipo);
        });

        sessionFactory.inTransaction( session->{;
            Equipo e10 = session.find(Equipo.class, 10);
            session.remove(e10);
        });

    }
}
