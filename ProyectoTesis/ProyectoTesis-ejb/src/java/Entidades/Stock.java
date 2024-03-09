/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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

    @Basic(optional = false)
    @NotNull
    @Column(name = "existencia")
    private BigDecimal existencia;

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StockPK stockPK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stock")
    private List<NotasCreditosDet> notasCreditosDetList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stock")
    private List<OrdenesComprasDet> ordenesComprasDetList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stock")
    private List<VentasDet> ventasDetList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stock")
    private List<NotasCreditosDetC> notasCreditosDetCList;
    @JoinColumn(name = "id_deposito", referencedColumnName = "id_deposito", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Depositos depositos;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Productos productos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stock")
    private List<NotasRemisionesDet> notasRemisionesDetList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stock")
    private List<NotasDebitosDet> notasDebitosDetList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stock")
    private List<NotasRemisionesDetC> notasRemisionesDetCList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stock")
    private List<PedidosDet> pedidosDetList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stock")
    private List<AjustesInventarios> ajustesInventariosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stock")
    private List<PresupuestosDet> presupuestosDetList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stock")
    private List<NotasDebitosDetC> notasDebitosDetCList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stock")
    private List<ComprasDet> comprasDetList;

    public Stock() {
    }

    public Stock(StockPK stockPK) {
        this.stockPK = stockPK;
    }

    public Stock(StockPK stockPK, BigDecimal existencia) {
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


    @XmlTransient
    public List<NotasCreditosDet> getNotasCreditosDetList() {
        return notasCreditosDetList;
    }

    public void setNotasCreditosDetList(List<NotasCreditosDet> notasCreditosDetList) {
        this.notasCreditosDetList = notasCreditosDetList;
    }

    @XmlTransient
    public List<OrdenesComprasDet> getOrdenesComprasDetList() {
        return ordenesComprasDetList;
    }

    public void setOrdenesComprasDetList(List<OrdenesComprasDet> ordenesComprasDetList) {
        this.ordenesComprasDetList = ordenesComprasDetList;
    }

    @XmlTransient
    public List<VentasDet> getVentasDetList() {
        return ventasDetList;
    }

    public void setVentasDetList(List<VentasDet> ventasDetList) {
        this.ventasDetList = ventasDetList;
    }

    @XmlTransient
    public List<NotasCreditosDetC> getNotasCreditosDetCList() {
        return notasCreditosDetCList;
    }

    public void setNotasCreditosDetCList(List<NotasCreditosDetC> notasCreditosDetCList) {
        this.notasCreditosDetCList = notasCreditosDetCList;
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

    @XmlTransient
    public List<NotasRemisionesDet> getNotasRemisionesDetList() {
        return notasRemisionesDetList;
    }

    public void setNotasRemisionesDetList(List<NotasRemisionesDet> notasRemisionesDetList) {
        this.notasRemisionesDetList = notasRemisionesDetList;
    }

    @XmlTransient
    public List<NotasDebitosDet> getNotasDebitosDetList() {
        return notasDebitosDetList;
    }

    public void setNotasDebitosDetList(List<NotasDebitosDet> notasDebitosDetList) {
        this.notasDebitosDetList = notasDebitosDetList;
    }

    @XmlTransient
    public List<NotasRemisionesDetC> getNotasRemisionesDetCList() {
        return notasRemisionesDetCList;
    }

    public void setNotasRemisionesDetCList(List<NotasRemisionesDetC> notasRemisionesDetCList) {
        this.notasRemisionesDetCList = notasRemisionesDetCList;
    }

    @XmlTransient
    public List<PedidosDet> getPedidosDetList() {
        return pedidosDetList;
    }

    public void setPedidosDetList(List<PedidosDet> pedidosDetList) {
        this.pedidosDetList = pedidosDetList;
    }

    @XmlTransient
    public List<AjustesInventarios> getAjustesInventariosList() {
        return ajustesInventariosList;
    }

    public void setAjustesInventariosList(List<AjustesInventarios> ajustesInventariosList) {
        this.ajustesInventariosList = ajustesInventariosList;
    }

    @XmlTransient
    public List<PresupuestosDet> getPresupuestosDetList() {
        return presupuestosDetList;
    }

    public void setPresupuestosDetList(List<PresupuestosDet> presupuestosDetList) {
        this.presupuestosDetList = presupuestosDetList;
    }

    @XmlTransient
    public List<NotasDebitosDetC> getNotasDebitosDetCList() {
        return notasDebitosDetCList;
    }

    public void setNotasDebitosDetCList(List<NotasDebitosDetC> notasDebitosDetCList) {
        this.notasDebitosDetCList = notasDebitosDetCList;
    }

    @XmlTransient
    public List<ComprasDet> getComprasDetList() {
        return comprasDetList;
    }

    public void setComprasDetList(List<ComprasDet> comprasDetList) {
        this.comprasDetList = comprasDetList;
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

    public BigDecimal getExistencia() {
        return existencia;
    }

    public void setExistencia(BigDecimal existencia) {
        this.existencia = existencia;
    }
    
}
