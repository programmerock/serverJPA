package ar.org.centro8.curso.java.aplicaciones.test;

import ar.org.centro8.curso.java.aplicaciones.entities.Detalle;
import ar.org.centro8.curso.java.aplicaciones.entities.DetallePK;
import ar.org.centro8.curso.java.aplicaciones.interfaces.I_DetalleRepository;
import ar.org.centro8.curso.java.aplicaciones.repositories.jpa.DetalleRepository;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestDetalleRepository {
    public static void main(String[] args) {
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("JPAPU");
        I_DetalleRepository dr=new DetalleRepository(emf);
        
        System.out.println("**********************************************************\n");
        System.out.println("Agrego un nuevo detalle:");
        Detalle detalle = new Detalle(new DetallePK(4, 3), 314f, 41);       
        dr.save(detalle);
        System.out.println(detalle+"\n");
        System.out.println("Recorro la lista:");
        dr.getAll().forEach(System.out::println);
        System.out.println("\n**********************************************************\n");        
        
        
        System.out.println("**********************************************************\n");
        System.out.println("Utilizo el buscador de IdFactura:\n");
        dr.getByIdFactura(1).forEach(System.out::println);
        System.out.println("\n**********************************************************\n");
        
        
        System.out.println("**********************************************************\n");
        System.out.println("Utilizo el buscador de IdArticulo:\n");
        dr.getByIdArticulo(2).forEach(System.out::println);
        System.out.println("\n**********************************************************\n");
        
        
        System.out.println("**********************************************************\n");
        System.out.println("Utilizo el buscador de IdFactura y IdArticulo:\n");
        System.out.println(dr.getByIdFacturaIdArticulo(1, 1));
        System.out.println("\n**********************************************************\n");
        
        
        System.out.println("**********************************************************\n");
        System.out.println("Elimino un registro (muestro la lista para corroborar:\n");
        dr.remove(dr.getByIdFacturaIdArticulo(2, 3));
        dr.getAll().forEach(System.out::println);
        System.out.println("\n**********************************************************\n");
        
        
        System.out.println("**********************************************************\n");
        System.out.println("Actualizo un registro (muestro la lista para corroborar:\n");
        detalle=dr.getByIdFacturaIdArticulo(1, 1);
        if(detalle!=null){
            detalle.setPrecio(587.12f);
            detalle.setCantidad(25);
            dr.update(detalle);
        }
        dr.getAll().forEach(System.out::println);
        System.out.println("\n**********************************************************\n");  
        
        emf.close();
        
    }
}
