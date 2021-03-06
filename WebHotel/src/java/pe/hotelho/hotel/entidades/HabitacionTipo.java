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
@Table(name = "habitacion_tipo", catalog = "hotelho", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HabitacionTipo.findAll", query = "SELECT h FROM HabitacionTipo h"),
    @NamedQuery(name = "HabitacionTipo.findByIdhabitacionTipo", query = "SELECT h FROM HabitacionTipo h WHERE h.idhabitacionTipo = :idhabitacionTipo"),
    @NamedQuery(name = "HabitacionTipo.findByDescripcion", query = "SELECT h FROM HabitacionTipo h WHERE h.descripcion = :descripcion"),
    @NamedQuery(name = "HabitacionTipo.findByEstado", query = "SELECT h FROM HabitacionTipo h WHERE h.estado = :estado")})
public class HabitacionTipo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idhabitacion_tipo")
    private Integer idhabitacionTipo;
    @Size(max = 30)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "estado")
    private Character estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idhabitacionTipo")
    private Collection<Habitaciones> habitacionesCollection;

    public HabitacionTipo() {
    }

    public HabitacionTipo(Integer idhabitacionTipo) {
        this.idhabitacionTipo = idhabitacionTipo;
    }

    public Integer getIdhabitacionTipo() {
        return idhabitacionTipo;
    }

    public void setIdhabitacionTipo(Integer idhabitacionTipo) {
        this.idhabitacionTipo = idhabitacionTipo;
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
        hash += (idhabitacionTipo != null ? idhabitacionTipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HabitacionTipo)) {
            return false;
        }
        HabitacionTipo other = (HabitacionTipo) object;
        if ((this.idhabitacionTipo == null && other.idhabitacionTipo != null) || (this.idhabitacionTipo != null && !this.idhabitacionTipo.equals(other.idhabitacionTipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.hotelho.hotel.entidades.HabitacionTipo[ idhabitacionTipo=" + idhabitacionTipo + " ]";
    }
    
}
