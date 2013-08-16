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
@Table(name = "piso", catalog = "hotelho", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Piso.findAll", query = "SELECT p FROM Piso p"),
    @NamedQuery(name = "Piso.findByIdpiso", query = "SELECT p FROM Piso p WHERE p.idpiso = :idpiso"),
    @NamedQuery(name = "Piso.findByDescripcion", query = "SELECT p FROM Piso p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Piso.findByEstado", query = "SELECT p FROM Piso p WHERE p.estado = :estado")})
public class Piso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpiso")
    private Integer idpiso;
    @Size(max = 30)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "estado")
    private Character estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpiso")
    private Collection<Habitaciones> habitacionesCollection;

    public Piso() {
    }

    public Piso(Integer idpiso) {
        this.idpiso = idpiso;
    }

    public Integer getIdpiso() {
        return idpiso;
    }

    public void setIdpiso(Integer idpiso) {
        this.idpiso = idpiso;
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
    public Collection<Habitaciones> getHabitacionesCollection() {
        return habitacionesCollection;
    }

    public void setHabitacionesCollection(Collection<Habitaciones> habitacionesCollection) {
        this.habitacionesCollection = habitacionesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpiso != null ? idpiso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Piso)) {
            return false;
        }
        Piso other = (Piso) object;
        if ((this.idpiso == null && other.idpiso != null) || (this.idpiso != null && !this.idpiso.equals(other.idpiso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.hotelho.hotel.entidades.Piso[ idpiso=" + idpiso + " ]";
    }
    
}
