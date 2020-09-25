package ar.org.centro8.curso.java.aplicaciones.interfaces;

import ar.org.centro8.curso.java.aplicaciones.entities.Factura;
import java.util.List;
import java.util.stream.Collectors;

public interface I_FacturaRepository {
    void save (Factura factura);
    void remove (Factura factura);
    void update (Factura factura);
    List<Factura> getAll();
    default Factura getById(Integer id){
        return getAll()
                .stream()
                .filter(f->f.getId()==id)
                .findFirst()
                .orElse(new Factura());
    }
    default List<Factura> getByIdCliente(Integer id){
        return getAll()
                .stream()
                .filter(f->f.getIdCliente().getId()==id)
                .collect(Collectors.toList());
    }
    default Factura getByLetraNumero(Character letra,Integer numero){
        return getAll()
                .stream()
                .filter(f->f.getLetra()==letra && f.getNumero()==numero)
                .findFirst()
                .orElse(new Factura());
    }
    
}
