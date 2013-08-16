/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.hotelho.hotel.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author obardales
 */
@Entity
@Table(name = "orden", catalog = "hotelho", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orden.findAll", query = "SELECT o FROM Orden o"),
    @NamedQuery(name = "Orden.findByIdautorizacion", query = "SELECT o FROM Orden o WHERE o.ordenPK.idautorizacion = :idautorizacion"),
    @NamedQuery(name = "Orden.findByIdorden", query = "SELECT o FROM Orden o WHERE o.ordenPK.idorden = :idorden"),
    @NamedQuery(name = "Orden.findByComanda", query = "SELECT o FROM Orden o WHERE o.comanda = :comanda"),
    @NamedQuery(name = "Orden.findByFecha", query = "SELECT o FROM Orden o WHERE o.fecha = :fecha"),
    @NamedQuery(name = "Orden.findByPrecio", query = "SELECT o FROM Orden o WHERE o.precio = :precio"),
    @NamedQuery(name = "Orden.findByCantidad", query = "SELECT o FROM Orden o WHERE o.cantidad = :cantidad"),
    @NamedQuery(name = "Orden.findByTotal", query = "SELECT o FROM Orden o WHERE o.total = :total"),
    @NamedQuery(name = "Orden.findByObservacion", query = "SELECT o FROM Orden o WHERE o.observacion = :observacion"),
    @NamedQuery(name = "Orden.findByEstado", query = "SELECT o FROM Orden o WHERE o.estado = :estado"),
    @NamedQuery(name = "Orden.findByUsuario", query = "SELECT o FROM Orden o WHERE o.usuario = :usuario"),
    @NamedQuery(name = "Orden.findByCorrelativo", query = "SELECT o FROM Orden o WHERE o.correlativo = :correlativo"),
    @NamedQuery(name = "Orden.findByMozo", query = "SELECT o FROM Orden o WHERE o.mozo = :mozo")})
public class Orden implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OrdenPK ordenPK;
    @Size(max = 15)
    @Column(name = "comanda")
    private String comanda;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio")
    private BigDecimal precio;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "total")
    private BigDecimal total;
    @Size(max = 50)
    @Column(name = "observacion")
    private String observacion;
    @Column(name = "estado")
    private Character estado;
    @Size(max = 10)
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "correlativo")
    private Integer correlativo;
    @Size(max = 10)
    @Column(name = "mozo")
    private String mozo;
    @JoinColumn(name = "idservicios", referencedColumnName = "idservicios")
    @ManyToOne(optional = false)
    private Servicios idservicios;
    @JoinColumn(name = "idautorizacion", referencedColumnName = "idautorizacion", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Autorizacion autorizacion;

    public Orden() {
    }

    public Orden(OrdenPK ordenPK) {
        this.ordenPK = ordenPK;
    }

    public Orden(int idautorizacion, int idorden) {
        this.ordenPK = new OrdenPK(idautorizacion, idorden);
    }

    public OrdenPK getOrdenPK() {
        return ordenPK;
    }

    public void setOrdenPK(OrdenPK ordenPK) {
        this.ordenPK = ordenPK;
    }

    public String getComanda() {
        return comanda;
    }

    public void setComanda(String comanda) {
        this.comanda = comanda;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Integer getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(Integer correlativo) {
        this.correlativo = correlativo;
    }

    public String getMozo() {
        return mozo;
    }

    public void setMozo(String mozo) {
        this.mozo = mozo;
    }

    public Servicios getIdservicios() {
        return idservicios;
    }

    public void setIdservicios(Servicios idservicios) {
        this.idservicios = idservicios;
    }

    public Autorizacion getAutorizacion() {
        return autorizacion;
    }

    public void setAutorizacion(Autorizacion autorizacion) {
        this.autorizacion = autorizacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ordenPK != null ? ordenPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orden)) {
            return false;
        }
        Orden other = (Orden) object;
        if ((this.ordenPK == null && other.ordenPK != null) || (this.ordenPK != null && !this.ordenPK.equals(other.ordenPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.hotelho.hotel.entidades.Orden[ ordenPK=" + ordenPK + " ]";
    }
    
}
