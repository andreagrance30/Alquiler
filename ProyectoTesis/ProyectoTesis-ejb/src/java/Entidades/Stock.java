/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Andrea Salinas
 */
@Entity
@Table(name = "stock")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stock.findAll", query = "SELECT s FROM Stock s"),
    @NamedQuery(name = "Stock.findByIdProducto", query = "SELECT s FROM Stock s WHERE s.stockPK.idProducto = :idProducto"),
    @NamedQuery(name = "Stock.findByIdDeposito", query = "SELECT s FROM Stock s WHERE s.stockPK.idDeposito = :idDeposito"),
    @NamedQuery(name = "Stock.findByExistencia", query = "SELECT s FROM Stock s WHERE s.existencia = :existencia")})
public class Stock implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stock")
    private List<PresupuestosClientesDet> presupuestosClientesDetList;

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StockPK stockPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "existencia")
    private BigInteger existencia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stock")
    private List<SolicitudesPedidosDet> solicitudesPedidosDetList;
    @JoinColumn(name = "id_deposito", referencedColumnName = "id_deposito", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Depositos depositos;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Productos productos;

    public Stock() {
    }

    public Stock(StockPK stockPK) {
        this.stockPK = stockPK;
    }

    public Stock(StockPK stockPK, BigInteger existencia) {
        this.stockPK = stockPK;
        this.existencia = existencia;
    }

    public Stock(int idProducto, int idDeposito) {
        this.stockPK = new StockPK(idProducto, idDeposito);
    }

    public StockPK getStockPK() {
        return stockPK;
    }

    public void setStockPK(StockPK stockPK) {
        this.stockPK = stockPK;
    }

    public BigInteger getExistencia() {
        return existencia;
    }

    public void setExistencia(BigInteger existencia) {
        this.existencia = existencia;
    }

    @XmlTransient
    public List<SolicitudesPedidosDet> getSolicitudesPedidosDetList() {
        return solicitudesPedidosDetList;
    }

    public void setSolicitudesPedidosDetList(List<SolicitudesPedidosDet> solicitudesPedidosDetList) {
        this.solicitudesPedidosDetList = solicitudesPedidosDetList;
    }

    public Depositos getDepositos() {
        return depositos;
    }

    public void setDepositos(Depositos depositos) {
        this.depositos = depositos;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
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
        return "Entidades.Stock[ stockPK=" + stockPK + " ]";
    }

    @XmlTransient
    public List<PresupuestosClientesDet> getPresupuestosClientesDetList() {
        return presupuestosClientesDetList;
    }

    public void setPresupuestosClientesDetList(List<PresupuestosClientesDet> presupuestosClientesDetList) {
        this.presupuestosClientesDetList = presupuestosClientesDetList;
    }
    
}
