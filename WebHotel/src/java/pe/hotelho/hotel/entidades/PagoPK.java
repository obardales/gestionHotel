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
public class PagoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "idautorizacion")
    private int idautorizacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "correlativo")
    private int correlativo;

    public PagoPK() {
    }

    public PagoPK(int idautorizacion, int correlativo) {
        this.idautorizacion = idautorizacion;
        this.correlativo = correlativo;
    }

    public int getIdautorizacion() {
        return idautorizacion;
    }

    public void setIdautorizacion(int idautorizacion) {
        this.idautorizacion = idautorizacion;
    }

    public int getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(int correlativo) {
        this.correlativo = correlativo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idautorizacion;
        hash += (int) correlativo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PagoPK)) {
            return false;
        }
        PagoPK other = (PagoPK) object;
        if (this.idautorizacion != other.idautorizacion) {
            return false;
        }
        if (this.correlativo != other.correlativo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.hotelho.hotel.entidades.PagoPK[ idautorizacion=" + idautorizacion + ", correlativo=" + correlativo + " ]";
    }
    
}
