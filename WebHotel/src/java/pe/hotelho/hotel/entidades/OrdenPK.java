/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.hotelho.hotel.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author obardales
 */
@Embeddable
public class OrdenPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "idautorizacion")
    private int idautorizacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idorden")
    private int idorden;

    public OrdenPK() {
    }

    public OrdenPK(int idautorizacion, int idorden) {
        this.idautorizacion = idautorizacion;
        this.idorden = idorden;
    }

    public int getIdautorizacion() {
        return idautorizacion;
    }

    public void setIdautorizacion(int idautorizacion) {
        this.idautorizacion = idautorizacion;
    }

    public int getIdorden() {
        return idorden;
    }

    public void setIdorden(int idorden) {
        this.idorden = idorden;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idautorizacion;
        hash += (int) idorden;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenPK)) {
            return false;
        }
        OrdenPK other = (OrdenPK) object;
        if (this.idautorizacion != other.idautorizacion) {
            return false;
        }
        if (this.idorden != other.idorden) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.hotelho.hotel.entidades.OrdenPK[ idautorizacion=" + idautorizacion + ", idorden=" + idorden + " ]";
    }
    
}
