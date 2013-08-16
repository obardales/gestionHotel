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
@Table(name = "habitacion_estado", catalog = "hotelho", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HabitacionEstado.findAll", query = "SELECT h FROM HabitacionEstado h"),
    @NamedQuery(name = "HabitacionEstado.findByIdhabitacionEstado", query = "SELECT h FROM HabitacionEstado h WHERE h.idhabitacionEstado = :idhabitacionEstado"),
    @NamedQuery(name = "HabitacionEstado.findByDescripcion", query = "SELECT h FROM HabitacionEstado h WHERE h.descripcion = :descripcion"),
    @NamedQuery(name = "HabitacionEstado.findByColor", query = "SELECT h FROM HabitacionEstado h WHERE h.color = :color"),
    @NamedQuery(name = "HabitacionEstado.findByEstado", query = "SELECT h FROM HabitacionEstado h WHERE h.estado = :estado")})
public class HabitacionEstado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idhabitacion_estado")
    private Integer idhabitacionEstado;
    @Size(max = 30)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 15)
    @Column(name = "color")
    private String color;
    @Column(name = "estado")
    private Character estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idhabitacionEstado")
    private Collection<Habitaciones> habitacionesCollection;

    public HabitacionEstado() {
    }

    public HabitacionEstado(Integer idhabitacionEstado) {
        this.idhabitacionEstado = idhabitacionEstado;
    }

    public Integer getIdhabitacionEstado() {
        return idhabitacionEstado;
    }

    public void setIdhabitacionEstado(Integer idhabitacionEstado) {
        this.idhabitacionEstado = idhabitacionEstado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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
        hash += (idhabitacionEstado != null ? idhabitacionEstado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HabitacionEstado)) {
            return false;
        }
        HabitacionEstado other = (HabitacionEstado) object;
        if ((this.idhabitacionEstado == null && other.idhabitacionEstado != null) || (this.idhabitacionEstado != null && !this.idhabitacionEstado.equals(other.idhabitacionEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.hotelho.hotel.entidades.HabitacionEstado[ idhabitacionEstado=" + idhabitacionEstado + " ]";
    }
    
}
