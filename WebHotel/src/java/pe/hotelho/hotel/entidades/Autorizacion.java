/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.hotelho.hotel.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author obardales
 */
@Entity
@Table(name = "autorizacion", catalog = "hotelho", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Autorizacion.findAll", query = "SELECT a FROM Autorizacion a"),
    @NamedQuery(name = "Autorizacion.findByIdautorizacion", query = "SELECT a FROM Autorizacion a WHERE a.idautorizacion = :idautorizacion"),
    @NamedQuery(name = "Autorizacion.findByFecha", query = "SELECT a FROM Autorizacion a WHERE a.fecha = :fecha"),
    @NamedQuery(name = "Autorizacion.findByFechaIni", query = "SELECT a FROM Autorizacion a WHERE a.fechaIni = :fechaIni"),
    @NamedQuery(name = "Autorizacion.findByFechaSal", query = "SELECT a FROM Autorizacion a WHERE a.fechaSal = :fechaSal"),
    @NamedQuery(name = "Autorizacion.findByEmpresa", query = "SELECT a FROM Autorizacion a WHERE a.empresa = :empresa"),
    @NamedQuery(name = "Autorizacion.findByTotal", query = "SELECT a FROM Autorizacion a WHERE a.total = :total"),
    @NamedQuery(name = "Autorizacion.findByPagos", query = "SELECT a FROM Autorizacion a WHERE a.pagos = :pagos"),
    @NamedQuery(name = "Autorizacion.findByEstado", query = "SELECT a FROM Autorizacion a WHERE a.estado = :estado"),
    @NamedQuery(name = "Autorizacion.findByObservacion", query = "SELECT a FROM Autorizacion a WHERE a.observacion = :observacion")})
public class Autorizacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idautorizacion")
    private Integer idautorizacion;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "fecha_ini")
    @Temporal(TemporalType.DATE)
    private Date fechaIni;
    @Column(name = "fecha_sal")
    @Temporal(TemporalType.DATE)
    private Date fechaSal;
    @Size(max = 50)
    @Column(name = "empresa")
    private String empresa;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total")
    private BigDecimal total;
    @Column(name = "pagos")
    private BigDecimal pagos;
    @Column(name = "estado")
    private Character estado;
    @Size(max = 100)
    @Column(name = "observacion")
    private String observacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "autorizacion")
    private Collection<Pago> pagoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "autorizacion")
    private Collection<Orden> ordenCollection;
    @JoinColumn(name = "usuario", referencedColumnName = "usuario")
    @ManyToOne(optional = false)
    private Usuario usuario;
    @JoinColumn(name = "idmotivo", referencedColumnName = "idmotivo")
    @ManyToOne(optional = false)
    private Motivo idmotivo;
    @JoinColumn(name = "idhabitaciones", referencedColumnName = "idhabitaciones")
    @ManyToOne(optional = false)
    private Habitaciones idhabitaciones;
    @JoinColumn(name = "idcliente", referencedColumnName = "idcliente")
    @ManyToOne(optional = false)
    private Cliente idcliente;

    public Autorizacion() {
    }

    public Autorizacion(Integer idautorizacion) {
        this.idautorizacion = idautorizacion;
    }

    public Integer getIdautorizacion() {
        return idautorizacion;
    }

    public void setIdautorizacion(Integer idautorizacion) {
        this.idautorizacion = idautorizacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(Date fechaIni) {
        this.fechaIni = fechaIni;
    }

    public Date getFechaSal() {
        return fechaSal;
    }

    public void setFechaSal(Date fechaSal) {
        this.fechaSal = fechaSal;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getPagos() {
        return pagos;
    }

    public void setPagos(BigDecimal pagos) {
        this.pagos = pagos;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @XmlTransient
    public Collection<Pago> getPagoCollection() {
        return pagoCollection;
    }

    public void setPagoCollection(Collection<Pago> pagoCollection) {
        this.pagoCollection = pagoCollection;
    }

    @XmlTransient
    public Collection<Orden> getOrdenCollection() {
        return ordenCollection;
    }

    public void setOrdenCollection(Collection<Orden> ordenCollection) {
        this.ordenCollection = ordenCollection;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Motivo getIdmotivo() {
        return idmotivo;
    }

    public void setIdmotivo(Motivo idmotivo) {
        this.idmotivo = idmotivo;
    }

    public Habitaciones getIdhabitaciones() {
        return idhabitaciones;
    }

    public void setIdhabitaciones(Habitaciones idhabitaciones) {
        this.idhabitaciones = idhabitaciones;
    }

    public Cliente getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Cliente idcliente) {
        this.idcliente = idcliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idautorizacion != null ? idautorizacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Autorizacion)) {
            return false;
        }
        Autorizacion other = (Autorizacion) object;
        if ((this.idautorizacion == null && other.idautorizacion != null) || (this.idautorizacion != null && !this.idautorizacion.equals(other.idautorizacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.hotelho.hotel.entidades.Autorizacion[ idautorizacion=" + idautorizacion + " ]";
    }
    
}
