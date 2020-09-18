package ar.org.centro8.curso.java.entities;

import ar.org.centro8.curso.java.entities.Cliente;
import ar.org.centro8.curso.java.entities.Detalle;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-09-18T11:34:46")
@StaticMetamodel(Factura.class)
public class Factura_ { 

    public static volatile SingularAttribute<Factura, String> fecha;
    public static volatile CollectionAttribute<Factura, Detalle> detalleCollection;
    public static volatile SingularAttribute<Factura, Double> monto;
    public static volatile SingularAttribute<Factura, Integer> numero;
    public static volatile SingularAttribute<Factura, Cliente> idCliente;
    public static volatile SingularAttribute<Factura, Integer> id;
    public static volatile SingularAttribute<Factura, Character> letra;

}