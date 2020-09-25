package ar.org.centro8.curso.java.aplicaciones.test;

import ar.org.centro8.curso.java.aplicaciones.entities.Cliente;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TestJPA {
    public static void main(String[] args) {
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("JPAPU");
        EntityManager em=emf.createEntityManager();
        
//        System.out.println("**************************************************************\n");
//        System.out.println("Se creó un nuevo cliente en la base:");
//        Cliente cliente = new Cliente("Verónica", "Fernandez", "DNI", "26548325", "Independencia 1942", "");
//        em.getTransaction().begin();
//        em.persist(cliente);
//        em.getTransaction().commit();
//        System.out.println(cliente);
//        System.out.println("**************************************************************\n");
//        
        
//        
//        System.out.println("**************************************************************\n");
//        System.out.println("Busco clientes llamados marcelo");
//        Query query=em.createNamedQuery("Cliente.findByNombre");
//        query.setParameter("nombre", "marce");
//        query.getResultList().forEach(System.out::println);
//        System.out.println("**************************************************************\n");

        System.out.println("**************************************************************\n");
        System.out.println("Borrado de cliente id:9");
        em.getTransaction().begin();
        Query query=em.createNamedQuery("Cliente.findById");
        query.setParameter("id", 9);
//        em.remove(query.getSingleResult());
        em.getTransaction().commit();
        System.out.println("**************************************************************\n");
        
        System.out.println("**************************************************************\n");
        System.out.println("Actualizo el apellido del cliente de id 12");
        query=em.createNamedQuery("Cliente.findById");
        query.setParameter("id", 12);
        Cliente cliente=(Cliente)query.getSingleResult();
        if(cliente!=null){
            cliente.setApellido("Zanabria");
            cliente.setComentarios("Se cambió el apellido");
            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();
        }
        System.out.println("**************************************************************\n");
        
        System.out.println("**************************************************************\n");
        System.out.println("Recorro la lista de clientes:");
        em.createNamedQuery("Cliente.findAll").getResultList().forEach(System.out::println);
        System.out.println("**************************************************************\n");
        
        
        em.close();
        emf.close();
    }
}
