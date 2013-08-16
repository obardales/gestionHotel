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
@Table(name = "tipodoc", catalog = "hotelho", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipodoc.findAll", query = "SELECT t FROM Tipodoc t"),
    @NamedQuery(name = "Tipodoc.findByIdtipodoc", query = "SELECT t FROM Tipodoc t WHERE t.idtipodoc = :idtipodoc"),
    @NamedQuery(name = "Tipodoc.findByDescripcion", query = "SELECT t FROM Tipodoc t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "Tipodoc.findByCorto", query = "SELECT t FROM Tipodoc t WHERE t.corto = :corto"),
    @NamedQuery(name = "Tipodoc.findByEstado", query = "SELECT t FROM Tipodoc t WHERE t.estado = :estado")})
public class Tipodoc implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipodoc")
    private Integer idtipodoc;
    @Size(max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 15)
    @Column(name = "corto")
    private String corto;
    @Column(name = "estado")
    private Character estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtipodoc")
    private Collection<Cliente> clienteCollection;

    public Tipodoc() {
    }

    public Tipodoc(Integer idtipodoc) {
        this.idtipodoc = idtipodoc;
    }

    public Integer getIdtipodoc() {
        return idtipodoc;
    }

    public void setIdtipodoc(Integer idtipodoc) {
        this.idtipodoc = idtipodoc;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCorto() {
        return corto;
    }

    public void setCorto(String corto) {
        this.corto = corto;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<Cliente> getClienteCollection() {
        return clienteCollection;
    }

    public void setClienteCollection(Collection<Cliente> clienteCollection) {
        this.clienteCollection = clienteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipodoc != null ? idtipodoc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipodoc)) {
            return false;
        }
        Tipodoc other = (Tipodoc) object;
        if ((this.idtipodoc == null && other.idtipodoc != null) || (this.idtipodoc != null && !this.idtipodoc.equals(other.idtipodoc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.hotelho.hotel.entidades.Tipodoc[ idtipodoc=" + idtipodoc + " ]";
    }
    
}
