package ar.org.centro8.curso.java.aplicaciones.test;

import ar.org.centro8.curso.java.aplicaciones.entities.Articulo;
import ar.org.centro8.curso.java.aplicaciones.interfaces.I_ArticuloRepository;
import ar.org.centro8.curso.java.aplicaciones.repositories.jpa.ArticuloRepository;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestArticuloRepository {
    public static void main(String[] args) {
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("JPAPU");
        I_ArticuloRepository ar=new ArticuloRepository(emf);
        
        
        System.out.println("**********************************************************\n");
        System.out.println("Agrego un nuevo artículo:");
        Articulo articulo = new Articulo("Guantes negros", 75.32f, 175.50f, 120, 30, 200);
        ar.save(articulo);
        System.out.println(articulo+"\n");
        System.out.println("Recorro la lista:");
        ar.getAll().forEach(System.out::println);
        System.out.println("\n**********************************************************\n");        
        
        
        System.out.println("**********************************************************\n");
        System.out.println("Utilizo el buscador de descripción:\n");
         ar.getLikeDescripcion("remera").forEach(System.out::println);
        System.out.println("\n**********************************************************\n");
        
        
        System.out.println("**********************************************************\n");
        System.out.println("Elimino un registro (muestro la lista para corroborar:\n");
        ar.remove(ar.getById(8));
        ar.getAll().forEach(System.out::println);
        System.out.println("\n**********************************************************\n");
        
        
        System.out.println("**********************************************************\n");
        System.out.println("Actualizo un registro (muestro la lista para corroborar:\n");
        articulo=ar.getById(3);
        if(articulo!=null){
            articulo.setDescripcion("Remera roja y blanca");
            articulo.setPrecio(500f);
            ar.update(articulo);
        }
        ar.getAll().forEach(System.out::println);
        System.out.println("\n**********************************************************\n");  
        
        emf.close();
    }
}
