package ar.org.centro8.curso.java.aplicaciones.test;

import ar.org.centro8.curso.java.aplicaciones.interfaces.I_ClienteRepository;
import ar.org.centro8.curso.java.aplicaciones.entities.Cliente;
import ar.org.centro8.curso.java.aplicaciones.repositories.jpa.ClienteRepository;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestClienteRepository {
    public static void main(String[] args) {
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("JPAPU");
        I_ClienteRepository cr=new ClienteRepository(emf);
        
        
        System.out.println("**********************************************************\n");
        System.out.println("Agrego un nuevo cliente:");
        Cliente cliente=new Cliente("Carla", "Ledesma", "DNI", "64596652", "San Martín 389", "");
        cr.save(cliente);
        System.out.println(cliente+"\n");
        System.out.println("Recorro la lista:");
        cr.getAll().forEach(System.out::println);
        System.out.println("\n**********************************************************\n");        
        
        
        System.out.println("**********************************************************\n");
        System.out.println("Utilizo el buscador de apellido:\n");
        cr.getLikeApellido("al").forEach(System.out::println);
        System.out.println("\n**********************************************************\n");
        
        
        System.out.println("**********************************************************\n");
        System.out.println("Utilizo el buscador de apellido y nombre:\n");
        cr.getLikeApellidoNombre("al","la").forEach(System.out::println);
        System.out.println("\n**********************************************************\n");
        
        
        System.out.println("**********************************************************\n");
        System.out.println("Elimino un registro (muestro la lista para corroborar:\n");
        cr.remove(cr.getById(21));
        cr.getAll().forEach(System.out::println);
        System.out.println("\n**********************************************************\n");
        
        
        System.out.println("**********************************************************\n");
        System.out.println("Actualizo un registro (muestro la lista para corroborar:\n");
        cliente=cr.getById(34);
        if(cliente!=null){
            cliente.setNombre("Analía");
            cliente.setApellido("Mendieta");
            cr.update(cliente);
        }
        cr.getAll().forEach(System.out::println);
        System.out.println("\n**********************************************************\n");  
        
        emf.close();
    }
}
