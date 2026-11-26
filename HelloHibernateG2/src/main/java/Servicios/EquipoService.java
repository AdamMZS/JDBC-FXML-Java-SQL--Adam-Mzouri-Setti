package Servicios;

import models.Equipo;
import org.example.SessionFactoryProvider;
import org.hibernate.SessionFactory;
import repositories.EquipoRepository;

public class EquipoService {
    private final SessionFactory sessionFactory;
    private final EquipoRepository repoEquipo;

    public EquipoService(SessionFactory sf, EquipoRepository repo){
        this.sessionFactory=sf;
        this.repoEquipo=repo;
    }

    public void añadirNewEquipo(String nombreEquipo,String categoriaEq){
        if (nombreEquipo==null||categoriaEq==null) {
            return;
        }
        String name = nombreEquipo.trim();
        String categoria = categoriaEq.trim();
        if (name.isEmpty()||categoria.isEmpty()) {
            return;
        }
        Equipo equipo=new Equipo();
    sessionFactory.getCurrentSession().beginTransaction();
    equipo.setNombre(name);
    equipo.setCategoria(categoria);
    equipo.setDisponible(true);


    repoEquipo.save(equipo);
    sessionFactory.getCurrentSession().getTransaction().commit();
    }
}
