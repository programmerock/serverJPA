package ar.org.centro8.curso.java.entities;

import ar.org.centro8.curso.java.entities.Detalle;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-09-18T11:34:46")
@StaticMetamodel(Articulo.class)
public class Articulo_ { 

    public static volatile SingularAttribute<Articulo, String> descripcion;
    public static volatile SingularAttribute<Articulo, Float> precio;
    public static volatile CollectionAttribute<Articulo, Detalle> detalleCollection;
    public static volatile SingularAttribute<Articulo, Integer> stockMin;
    public static volatile SingularAttribute<Articulo, Float> costo;
    public static volatile SingularAttribute<Articulo, Integer> stockMax;
    public static volatile SingularAttribute<Articulo, Integer> id;
    public static volatile SingularAttribute<Articulo, Integer> stock;

}