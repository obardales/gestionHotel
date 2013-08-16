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
@Table(name = "aseo", catalog = "hotelho", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aseo.findAll", query = "SELECT a FROM Aseo a"),
    @NamedQuery(name = "Aseo.findByIdaseo", query = "SELECT a FROM Aseo a WHERE a.idaseo = :idaseo"),
    @NamedQuery(name = "Aseo.findByDescripcion", query = "SELECT a FROM Aseo a WHERE a.descripcion = :descripcion"),
    @NamedQuery(name = "Aseo.findByEstado", query = "SELECT a FROM Aseo a WHERE a.estado = :estado")})
public class Aseo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idaseo")
    private Integer idaseo;
    @Size(max = 30)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "estado")
    private Character estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idaseo")
    private Collection<Habitaciones> habitacionesCollection;

    public Aseo() {
    }

    public Aseo(Integer idaseo) {
        this.idaseo = idaseo;
    }

    public Integer getIdaseo() {
        return idaseo;
    }

    public void setIdaseo(Integer idaseo) {
        this.idaseo = idaseo;
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
        hash += (idaseo != null ? idaseo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aseo)) {
            return false;
        }
        Aseo other = (Aseo) object;
        if ((this.idaseo == null && other.idaseo != null) || (this.idaseo != null && !this.idaseo.equals(other.idaseo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.hotelho.hotel.entidades.Aseo[ idaseo=" + idaseo + " ]";
    }
    
}
