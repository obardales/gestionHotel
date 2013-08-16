/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.hotelho.hotel.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author obardales
 */
@Entity
@Table(name = "stock", catalog = "hotelho", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stock.findAll", query = "SELECT s FROM Stock s"),
    @NamedQuery(name = "Stock.findByIdservicios", query = "SELECT s FROM Stock s WHERE s.stockPK.idservicios = :idservicios"),
    @NamedQuery(name = "Stock.findByIdalmacen", query = "SELECT s FROM Stock s WHERE s.stockPK.idalmacen = :idalmacen"),
    @NamedQuery(name = "Stock.findByStock", query = "SELECT s FROM Stock s WHERE s.stock = :stock")})
public class Stock implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StockPK stockPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "stock")
    private BigDecimal stock;
    @JoinColumn(name = "idalmacen", referencedColumnName = "idalmacen", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Almacen almacen;
    @JoinColumn(name = "idservicios", referencedColumnName = "idservicios", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Servicios servicios;

    public Stock() {
    }

    public Stock(StockPK stockPK) {
        this.stockPK = stockPK;
    }

    public Stock(StockPK stockPK, BigDecimal stock) {
        this.stockPK = stockPK;
        this.stock = stock;
    }

    public Stock(int idservicios, int idalmacen) {
        this.stockPK = new StockPK(idservicios, idalmacen);
    }

    public StockPK getStockPK() {
        return stockPK;
    }

    public void setStockPK(StockPK stockPK) {
        this.stockPK = stockPK;
    }

    public BigDecimal getStock() {
        return stock;
    }

    public void setStock(BigDecimal stock) {
        this.stock = stock;
    }

    public Almacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }

    public Servicios getServicios() {
        return servicios;
    }

    public void setServicios(Servicios servicios) {
        this.servicios = servicios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stockPK != null ? stockPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stock)) {
            return false;
        }
        Stock other = (Stock) object;
        if ((this.stockPK == null && other.stockPK != null) || (this.stockPK != null && !this.stockPK.equals(other.stockPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.hotelho.hotel.entidades.Stock[ stockPK=" + stockPK + " ]";
    }
    
}
