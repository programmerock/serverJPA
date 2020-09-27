package ar.org.centro8.curso.java.aplicaciones.rest;

import ar.org.centro8.curso.java.aplicaciones.entities.Factura;
import ar.org.centro8.curso.java.aplicaciones.repositories.jpa.ClienteRepository;
import ar.org.centro8.curso.java.aplicaciones.repositories.jpa.FacturaRepository;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/facturas/v1")
public class FacturaServicio {
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("JPAPU");
    @GET
    public String info(){
        return "Servicio de facturas activo";
    }
    
   /*
    http://localhost:8080/Server/facturas/v1/alta?letra=A&numero=16&fecha=12-05-2020&monto=5463&idCliente=2
    */ 
    
    @Path("alta")
    @GET
    public String alta(
            @QueryParam("letra") String letra,
            @QueryParam("numero") String numero,
            @QueryParam("fecha") String fecha,
            @QueryParam("monto") String monto,
            @QueryParam("idCliente") String idCliente
    ){
        FacturaRepository fr=new FacturaRepository(emf);
        ClienteRepository cr=new ClienteRepository(emf);
        Factura factura = new Factura(
                letra.charAt(0),
                Integer.parseInt(numero),
                fecha,
                Double.parseDouble(monto),
                cr.getById(Integer.parseInt(idCliente))
        );
        fr.save(factura);
        return factura.getId()+"";
    } 
    
    
    @Path("baja")
    @GET
    public String baja(@QueryParam("letra") String letra,@QueryParam("numero") String numero){
        try {
            FacturaRepository fr = new FacturaRepository(emf);
            fr.remove(fr.getByLetraNumero(letra.charAt(0), Integer.parseInt(numero)));
            return "true";
        } catch (Exception e) {
            return "false";
        }
    }
    
    
    @Path("getAll")
    @GET
    public String getAll(){
        String text="";
        FacturaRepository fr = new FacturaRepository(emf);
        for(Factura f:fr.getAll()) text+=f+"\n";
        return text;
    }
    
    
    @Path("getLikeCliente")
    @GET
    public String getLikeCliente(@QueryParam("idCliente") String idCliente){
        String text="";
        FacturaRepository fr = new FacturaRepository(emf);
        for(Factura f:fr.getByIdCliente(Integer.parseInt(idCliente))) 
            text+=f+"\n";
        return text;
    }
}
