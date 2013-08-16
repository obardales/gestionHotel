/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.hotelho.hotel.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author obardales
 */
@Entity
@Table(name = "habitaciones", catalog = "hotelho", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Habitaciones.findAll", query = "SELECT h FROM Habitaciones h"),
    @NamedQuery(name = "Habitaciones.findByIdhabitaciones", query = "SELECT h FROM Habitaciones h WHERE h.idhabitaciones = :idhabitaciones"),
    @NamedQuery(name = "Habitaciones.findByNumero", query = "SELECT h FROM Habitaciones h WHERE h.numero = :numero"),
    @NamedQuery(name = "Habitaciones.findByDescripcion", query = "SELECT h FROM Habitaciones h WHERE h.descripcion = :descripcion"),
    @NamedQuery(name = "Habitaciones.findByCamas", query = "SELECT h FROM Habitaciones h WHERE h.camas = :camas"),
    @NamedQuery(name = "Habitaciones.findByMascamas", query = "SELECT h FROM Habitaciones h WHERE h.mascamas = :mascamas"),
    @NamedQuery(name = "Habitaciones.findByPrecio", query = "SELECT h FROM Habitaciones h WHERE h.precio = :precio"),
    @NamedQuery(name = "Habitaciones.findByIdautorizacion", query = "SELECT h FROM Habitaciones h WHERE h.idautorizacion = :idautorizacion")})
public class Habitaciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idhabitaciones")
    private Integer idhabitaciones;
    @Size(max = 10)
    @Column(name = "numero")
    private String numero;
    @Size(max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "camas")
    private Integer camas;
    @Column(name = "mascamas")
    private Integer mascamas;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio")
    private BigDecimal precio;
    @Column(name = "idautorizacion")
    private Integer idautorizacion;
    @JoinColumn(name = "idhabitacion_tipo", referencedColumnName = "idhabitacion_tipo")
    @ManyToOne(optional = false)
    private HabitacionTipo idhabitacionTipo;
    @JoinColumn(name = "idhabitacion_estado", referencedColumnName = "idhabitacion_estado")
    @ManyToOne(optional = false)
    private HabitacionEstado idhabitacionEstado;
    @JoinColumn(name = "idaseo", referencedColumnName = "idaseo")
    @ManyToOne(optional = false)
    private Aseo idaseo;
    @JoinColumn(name = "idpiso", referencedColumnName = "idpiso")
    @ManyToOne(optional = false)
    private Piso idpiso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idhabitaciones")
    private Collection<Autorizacion> autorizacionCollection;

    public Habitaciones() {
    }

    public Habitaciones(Integer idhabitaciones) {
        this.idhabitaciones = idhabitaciones;
    }

    public Integer getIdhabitaciones() {
        return idhabitaciones;
    }

    public void setIdhabitaciones(Integer idhabitaciones) {
        this.idhabitaciones = idhabitaciones;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCamas() {
        return camas;
    }

    public void setCamas(Integer camas) {
        this.camas = camas;
    }

    public Integer getMascamas() {
        return mascamas;
    }

    public void setMascamas(Integer mascamas) {
        this.mascamas = mascamas;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Integer getIdautorizacion() {
        return idautorizacion;
    }

    public void setIdautorizacion(Integer idautorizacion) {
        this.idautorizacion = idautorizacion;
    }

    public HabitacionTipo getIdhabitacionTipo() {
        return idhabitacionTipo;
    }

    public void setIdhabitacionTipo(HabitacionTipo idhabitacionTipo) {
        this.idhabitacionTipo = idhabitacionTipo;
    }

    public HabitacionEstado getIdhabitacionEstado() {
        return idhabitacionEstado;
    }

    public void setIdhabitacionEstado(HabitacionEstado idhabitacionEstado) {
        this.idhabitacionEstado = idhabitacionEstado;
    }

    public Aseo getIdaseo() {
        return idaseo;
    }

    public void setIdaseo(Aseo idaseo) {
        this.idaseo = idaseo;
    }

    public Piso getIdpiso() {
        return idpiso;
    }

    public void setIdpiso(Piso idpiso) {
        this.idpiso = idpiso;
    }

    @XmlTransient
    public Collection<Autorizacion> getAutorizacionCollection() {
        return autorizacionCollection;
    }

    public void setAutorizacionCollection(Collection<Autorizacion> autorizacionCollection) {
        this.autorizacionCollection = autorizacionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idhabitaciones != null ? idhabitaciones.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Habitaciones)) {
            return false;
        }
        Habitaciones other = (Habitaciones) object;
        if ((this.idhabitaciones == null && other.idhabitaciones != null) || (this.idhabitaciones != null && !this.idhabitaciones.equals(other.idhabitaciones))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.hotelho.hotel.entidades.Habitaciones[ idhabitaciones=" + idhabitaciones + " ]";
    }
    
}
