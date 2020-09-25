package ar.org.centro8.curso.java.aplicaciones.test;

import ar.org.centro8.curso.java.aplicaciones.entities.Factura;
import ar.org.centro8.curso.java.aplicaciones.interfaces.I_ClienteRepository;
import ar.org.centro8.curso.java.aplicaciones.interfaces.I_FacturaRepository;
import ar.org.centro8.curso.java.aplicaciones.repositories.jpa.ClienteRepository;
import ar.org.centro8.curso.java.aplicaciones.repositories.jpa.FacturaRepository;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestFacturaRepository {
    public static void main(String[] args) {
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("JPAPU");
        I_FacturaRepository fr=new FacturaRepository(emf);
        I_ClienteRepository cr=new ClienteRepository(emf);
        
        
        System.out.println("**********************************************************\n");
        System.out.println("Agrego una nueva factura:");
        Factura factura=new Factura('A', 4, "13-08-2020", 1225.32, cr.getById(1));       
        fr.save(factura);
        System.out.println(factura+"\n");
        System.out.println("Recorro la lista:");
        fr.getAll().forEach(System.out::println);
        System.out.println("\n**********************************************************\n");        
        
        
        System.out.println("**********************************************************\n");
        System.out.println("Utilizo el buscador de IdCliente:\n");
        fr.getByIdCliente(1).forEach(System.out::println);
        System.out.println("\n**********************************************************\n");
        
        
        System.out.println("**********************************************************\n");
        System.out.println("Utilizo el buscador de letra y número:\n");
        System.out.println(fr.getByLetraNumero('A', 1));
        System.out.println("\n**********************************************************\n");
        
        
        System.out.println("**********************************************************\n");
        System.out.println("Elimino un registro (muestro la lista para corroborar:\n");
        fr.remove(fr.getById(6));
        fr.getAll().forEach(System.out::println);
        System.out.println("\n**********************************************************\n");
        
        
        System.out.println("**********************************************************\n");
        System.out.println("Actualizo un registro (muestro la lista para corroborar:\n");
        factura=fr.getById(2);
        if(factura!=null){
            factura.setMonto(15577.68);
            fr.update(factura);
        }
        fr.getAll().forEach(System.out::println);
        System.out.println("\n**********************************************************\n");  
        
        emf.close();
    }
}
