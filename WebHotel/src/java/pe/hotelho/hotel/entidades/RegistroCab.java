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
@Table(name = "registro_cab", catalog = "hotelho", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RegistroCab.findAll", query = "SELECT r FROM RegistroCab r"),
    @NamedQuery(name = "RegistroCab.findByIdregistroCab", query = "SELECT r FROM RegistroCab r WHERE r.idregistroCab = :idregistroCab"),
    @NamedQuery(name = "RegistroCab.findByFecha", query = "SELECT r FROM RegistroCab r WHERE r.fecha = :fecha"),
    @NamedQuery(name = "RegistroCab.findByObservacion", query = "SELECT r FROM RegistroCab r WHERE r.observacion = :observacion"),
    @NamedQuery(name = "RegistroCab.findByEstado", query = "SELECT r FROM RegistroCab r WHERE r.estado = :estado"),
    @NamedQuery(name = "RegistroCab.findByControl", query = "SELECT r FROM RegistroCab r WHERE r.control = :control"),
    @NamedQuery(name = "RegistroCab.findByTotal", query = "SELECT r FROM RegistroCab r WHERE r.total = :total")})
public class RegistroCab implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idregistro_cab")
    private Integer idregistroCab;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 80)
    @Column(name = "observacion")
    private String observacion;
    @Column(name = "estado")
    private Character estado;
    @Size(max = 20)
    @Column(name = "control")
    private String control;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total")
    private BigDecimal total;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "registroCab")
    private Collection<RegistroDet> registroDetCollection;
    @JoinColumn(name = "ruc", referencedColumnName = "ruc")
    @ManyToOne(optional = false)
    private Proveedor ruc;
    @JoinColumn(name = "idalmacen", referencedColumnName = "idalmacen")
    @ManyToOne(optional = false)
    private Almacen idalmacen;

    public RegistroCab() {
    }

    public RegistroCab(Integer idregistroCab) {
        this.idregistroCab = idregistroCab;
    }

    public Integer getIdregistroCab() {
        return idregistroCab;
    }

    public void setIdregistroCab(Integer idregistroCab) {
        this.idregistroCab = idregistroCab;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public String getControl() {
        return control;
    }

    public void setControl(String control) {
        this.control = control;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @XmlTransient
    public Collection<RegistroDet> getRegistroDetCollection() {
        return registroDetCollection;
    }

    public void setRegistroDetCollection(Collection<RegistroDet> registroDetCollection) {
        this.registroDetCollection = registroDetCollection;
    }

    public Proveedor getRuc() {
        return ruc;
    }

    public void setRuc(Proveedor ruc) {
        this.ruc = ruc;
    }

    public Almacen getIdalmacen() {
        return idalmacen;
    }

    public void setIdalmacen(Almacen idalmacen) {
        this.idalmacen = idalmacen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idregistroCab != null ? idregistroCab.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegistroCab)) {
            return false;
        }
        RegistroCab other = (RegistroCab) object;
        if ((this.idregistroCab == null && other.idregistroCab != null) || (this.idregistroCab != null && !this.idregistroCab.equals(other.idregistroCab))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.hotelho.hotel.entidades.RegistroCab[ idregistroCab=" + idregistroCab + " ]";
    }
    
}
