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
public class RegistroDetPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "idregistro_cab")
    private int idregistroCab;
    @Basic(optional = false)
    @NotNull
    @Column(name = "orden")
    private int orden;

    public RegistroDetPK() {
    }

    public RegistroDetPK(int idregistroCab, int orden) {
        this.idregistroCab = idregistroCab;
        this.orden = orden;
    }

    public int getIdregistroCab() {
        return idregistroCab;
    }

    public void setIdregistroCab(int idregistroCab) {
        this.idregistroCab = idregistroCab;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idregistroCab;
        hash += (int) orden;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegistroDetPK)) {
            return false;
        }
        RegistroDetPK other = (RegistroDetPK) object;
        if (this.idregistroCab != other.idregistroCab) {
            return false;
        }
        if (this.orden != other.orden) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.hotelho.hotel.entidades.RegistroDetPK[ idregistroCab=" + idregistroCab + ", orden=" + orden + " ]";
    }
    
}
