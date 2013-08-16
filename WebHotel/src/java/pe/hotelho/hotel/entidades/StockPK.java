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
public class StockPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "idservicios")
    private int idservicios;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idalmacen")
    private int idalmacen;

    public StockPK() {
    }

    public StockPK(int idservicios, int idalmacen) {
        this.idservicios = idservicios;
        this.idalmacen = idalmacen;
    }

    public int getIdservicios() {
        return idservicios;
    }

    public void setIdservicios(int idservicios) {
        this.idservicios = idservicios;
    }

    public int getIdalmacen() {
        return idalmacen;
    }

    public void setIdalmacen(int idalmacen) {
        this.idalmacen = idalmacen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idservicios;
        hash += (int) idalmacen;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StockPK)) {
            return false;
        }
        StockPK other = (StockPK) object;
        if (this.idservicios != other.idservicios) {
            return false;
        }
        if (this.idalmacen != other.idalmacen) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.hotelho.hotel.entidades.StockPK[ idservicios=" + idservicios + ", idalmacen=" + idalmacen + " ]";
    }
    
}
