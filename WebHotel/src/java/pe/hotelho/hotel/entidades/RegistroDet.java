/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.hotelho.hotel.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author obardales
 */
@Entity
@Table(name = "registro_det", catalog = "hotelho", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RegistroDet.findAll", query = "SELECT r FROM RegistroDet r"),
    @NamedQuery(name = "RegistroDet.findByIdregistroCab", query = "SELECT r FROM RegistroDet r WHERE r.registroDetPK.idregistroCab = :idregistroCab"),
    @NamedQuery(name = "RegistroDet.findByOrden", query = "SELECT r FROM RegistroDet r WHERE r.registroDetPK.orden = :orden"),
    @NamedQuery(name = "RegistroDet.findByCantidad", query = "SELECT r FROM RegistroDet r WHERE r.cantidad = :cantidad"),
    @NamedQuery(name = "RegistroDet.findByPrecio", query = "SELECT r FROM RegistroDet r WHERE r.precio = :precio"),
    @NamedQuery(name = "RegistroDet.findByTotal", query = "SELECT r FROM RegistroDet r WHERE r.total = :total")})
public class RegistroDet implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RegistroDetPK registroDetPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cantidad")
    private BigDecimal cantidad;
    @Column(name = "precio")
    private BigDecimal precio;
    @Column(name = "total")
    private BigDecimal total;
    @JoinColumn(name = "idservicios", referencedColumnName = "idservicios")
    @ManyToOne(optional = false)
    private Servicios idservicios;
    @JoinColumn(name = "idregistro_cab", referencedColumnName = "idregistro_cab", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private RegistroCab registroCab;

    public RegistroDet() {
    }

    public RegistroDet(RegistroDetPK registroDetPK) {
        this.registroDetPK = registroDetPK;
    }

    public RegistroDet(int idregistroCab, int orden) {
        this.registroDetPK = new RegistroDetPK(idregistroCab, orden);
    }

    public RegistroDetPK getRegistroDetPK() {
        return registroDetPK;
    }

    public void setRegistroDetPK(RegistroDetPK registroDetPK) {
        this.registroDetPK = registroDetPK;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Servicios getIdservicios() {
        return idservicios;
    }

    public void setIdservicios(Servicios idservicios) {
        this.idservicios = idservicios;
    }

    public RegistroCab getRegistroCab() {
        return registroCab;
    }

    public void setRegistroCab(RegistroCab registroCab) {
        this.registroCab = registroCab;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (registroDetPK != null ? registroDetPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegistroDet)) {
            return false;
        }
        RegistroDet other = (RegistroDet) object;
        if ((this.registroDetPK == null && other.registroDetPK != null) || (this.registroDetPK != null && !this.registroDetPK.equals(other.registroDetPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.hotelho.hotel.entidades.RegistroDet[ registroDetPK=" + registroDetPK + " ]";
    }
    
}
