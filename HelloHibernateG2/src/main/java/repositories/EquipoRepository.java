package repositories;

import models.Equipo;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class EquipoRepository implements Repository<Equipo ,Long>{

    private SessionFactory sessionFactory;
    public EquipoRepository(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }
    @Override
    public Optional<Equipo> findById(Long id) {
        return Optional.ofNullable(sessionFactory.getCurrentSession().find(Equipo.class,id));
    }

    @Override
    public List<Equipo> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Equipo",Equipo.class)
                .list();
    }

    @Override
    public Equipo save(Equipo entity) {
        var session = sessionFactory.getCurrentSession();

        Equipo existente = null;
        if (entity.getId() != null) {
            existente = session.find(Equipo.class, entity.getId());
        }
        if (existente == null && entity.getNombre() != null) {
            existente = session.createQuery("from Equipo where nombre = :nombre", Equipo.class)
                    .setParameter("nombre", entity.getNombre())
                    .uniqueResultOptional()
                    .orElse(null);
        }

        if (existente != null) {
            return existente;
        }

        session.persist(entity);
        return entity;
    }

    @Override
    public void delete(Equipo entity) {

    }
}
