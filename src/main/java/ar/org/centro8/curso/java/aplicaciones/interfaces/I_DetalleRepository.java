package ar.org.centro8.curso.java.aplicaciones.interfaces;

import ar.org.centro8.curso.java.aplicaciones.entities.DetallePK;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public interface I_DetalleRepository {
    void save (DetallePK detallePK);
    void remove (DetallePK detallePK);
    void update (DetallePK detallePK);
    List<DetallePK>getAll();
    default DetallePK getByIdFacturaIdArticulo(int idFactura, int idArticulo){
        return getAll()
                .stream()
                .filter(d->d.getIdFactura()==idFactura && d.getIdArticulo()==idArticulo)
                .findFirst()
                .orElse(new DetallePK());
    }
    default List<DetallePK> getByIdFactura(int id){
        return getAll()
                .stream()
                .filter(d->d.getIdFactura()==id)
                .collect(Collectors.toList());
    }
    default List<DetallePK> getByIdArticulo(int id){
        return getAll()
                .stream()
                .filter(d->d.getIdArticulo()==id)
                .collect(Collectors.toList());
    }
    
}
