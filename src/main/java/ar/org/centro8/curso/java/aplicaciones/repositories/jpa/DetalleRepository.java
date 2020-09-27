package ar.org.centro8.curso.java.aplicaciones.repositories.jpa;

import ar.org.centro8.curso.java.aplicaciones.entities.Detalle;
import ar.org.centro8.curso.java.aplicaciones.interfaces.I_DetalleRepository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class DetalleRepository implements I_DetalleRepository{
    EntityManagerFactory emf;

    public DetalleRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }    

    @Override
    public void save(Detalle detalle) {
        if (detalle==null) return;
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(detalle);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void remove(Detalle detalle) {
        if (detalle==null) return;
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(em.merge(detalle));
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void update(Detalle detalle) {
        if (detalle==null) return;
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(em.merge(detalle));
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Detalle> getAll() {
        List<Detalle> list=new ArrayList();
        EntityManager em=emf.createEntityManager();
        list=(List<Detalle>)em.createNamedQuery("Detalle.findAll").getResultList(); 
        em.close();
        return list;
    }
    
}
