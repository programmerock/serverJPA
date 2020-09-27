package ar.org.centro8.curso.java.aplicaciones.interfaces;

import ar.org.centro8.curso.java.aplicaciones.entities.Detalle;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public interface I_DetalleRepository {
    void save (Detalle detalle);
    void remove (Detalle detalle);
    void update (Detalle detalle);
    List<Detalle>getAll();
    default Detalle getByIdFacturaIdArticulo(int idFactura, int idArticulo){
        return getAll()
                .stream()
                .filter(d->d.getDetallePK().getIdFactura()==idFactura && d.getDetallePK().getIdArticulo()==idArticulo)
                .findFirst()
                .orElse(new Detalle());
    }
    default List<Detalle> getByIdFactura(int id){
        return getAll()
                .stream()
                .filter(d->d.getDetallePK().getIdFactura()==id)
                .collect(Collectors.toList());
    }
    default List<Detalle> getByIdArticulo(int id){
        return getAll()
                .stream()
                .filter(d->d.getDetallePK().getIdArticulo()==id)
                .collect(Collectors.toList());
    }
    
}
