package ar.org.centro8.curso.java.aplicaciones.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "facturas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f"),
    @NamedQuery(name = "Factura.findById", query = "SELECT f FROM Factura f WHERE f.id = :id"),
    @NamedQuery(name = "Factura.findByLetra", query = "SELECT f FROM Factura f WHERE f.letra = :letra"),
    @NamedQuery(name = "Factura.findByNumero", query = "SELECT f FROM Factura f WHERE f.numero = :numero"),
    @NamedQuery(name = "Factura.findByFecha", query = "SELECT f FROM Factura f WHERE f.fecha = :fecha"),
    @NamedQuery(name = "Factura.findByMonto", query = "SELECT f FROM Factura f WHERE f.monto = :monto")})
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "letra")
    private Character letra;
    @Basic(optional = false)
    @Column(name = "numero")
    private int numero;
    @Column(name = "fecha")
    private String fecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto")
    private Double monto;
    @JoinColumn(name = "idCliente", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cliente idCliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "factura")
    private Collection<Detalle> detalleCollection;

    public Factura() {
    }

    public Factura(Integer id) {
        this.id = id;
    }

    public Factura(Integer id, Character letra, int numero) {
        this.id = id;
        this.letra = letra;
        this.numero = numero;
    }

    public Factura(Character letra, int numero, String fecha, Double monto, Cliente idCliente) {
        this.letra = letra;
        this.numero = numero;
        this.fecha = fecha;
        this.monto = monto;
        this.idCliente = idCliente;
    }

    public Factura(Integer id, Character letra, int numero, String fecha, Double monto, Cliente idCliente) {
        this.id = id;
        this.letra = letra;
        this.numero = numero;
        this.fecha = fecha;
        this.monto = monto;
        this.idCliente = idCliente;
    }    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Character getLetra() {
        return letra;
    }

    public void setLetra(Character letra) {
        this.letra = letra;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    @XmlTransient
    public Collection<Detalle> getDetalleCollection() {
        return detalleCollection;
    }

    public void setDetalleCollection(Collection<Detalle> detalleCollection) {
        this.detalleCollection = detalleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Factura{" + "id=" + id + ", letra=" + letra + ", numero=" + numero + ", fecha=" + fecha 
                + ", monto=" + monto + ", idCliente=" + idCliente + '}';
    }

    
    
}
