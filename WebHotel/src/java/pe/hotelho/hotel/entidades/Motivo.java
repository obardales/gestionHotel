/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.hotelho.hotel.entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "motivo", catalog = "hotelho", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Motivo.findAll", query = "SELECT m FROM Motivo m"),
    @NamedQuery(name = "Motivo.findByIdmotivo", query = "SELECT m FROM Motivo m WHERE m.idmotivo = :idmotivo"),
    @NamedQuery(name = "Motivo.findByDescripcion", query = "SELECT m FROM Motivo m WHERE m.descripcion = :descripcion"),
    @NamedQuery(name = "Motivo.findByEstado", query = "SELECT m FROM Motivo m WHERE m.estado = :estado")})
public class Motivo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmotivo")
    private Integer idmotivo;
    @Size(max = 30)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "estado")
    private Character estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmotivo")
    private Collection<Autorizacion> autorizacionCollection;

    public Motivo() {
    }

    public Motivo(Integer idmotivo) {
        this.idmotivo = idmotivo;
    }

    public Integer getIdmotivo() {
        return idmotivo;
    }

    public void setIdmotivo(Integer idmotivo) {
        this.idmotivo = idmotivo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
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
        hash += (idmotivo != null ? idmotivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Motivo)) {
            return false;
        }
        Motivo other = (Motivo) object;
        if ((this.idmotivo == null && other.idmotivo != null) || (this.idmotivo != null && !this.idmotivo.equals(other.idmotivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.hotelho.hotel.entidades.Motivo[ idmotivo=" + idmotivo + " ]";
    }
    
}
