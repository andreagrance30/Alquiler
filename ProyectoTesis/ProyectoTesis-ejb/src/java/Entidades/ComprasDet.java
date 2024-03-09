/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andrea Salinas
 */
@Entity
@Table(name = "compras_det")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ComprasDet.findAll", query = "SELECT c FROM ComprasDet c"),
    @NamedQuery(name = "ComprasDet.findByIdCompra", query = "SELECT c FROM ComprasDet c WHERE c.comprasDetPK.idCompra = :idCompra"),
    @NamedQuery(name = "ComprasDet.findByIdProducto", query = "SELECT c FROM ComprasDet c WHERE c.comprasDetPK.idProducto = :idProducto"),
    @NamedQuery(name = "ComprasDet.findByIdDeposito", query = "SELECT c FROM ComprasDet c WHERE c.comprasDetPK.idDeposito = :idDeposito"),
    @NamedQuery(name = "ComprasDet.findByPorcIva", query = "SELECT c FROM ComprasDet c WHERE c.porcIva = :porcIva"),
    @NamedQuery(name = "ComprasDet.findByCantidad", query = "SELECT c FROM ComprasDet c WHERE c.cantidad = :cantidad"),
    @NamedQuery(name = "ComprasDet.findByPrecioUni", query = "SELECT c FROM ComprasDet c WHERE c.precioUni = :precioUni")})
public class ComprasDet implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ComprasDetPK comprasDetPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "porc_iva")
    private BigDecimal porcIva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private BigDecimal cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_uni")
    private BigDecimal precioUni;
    @JoinColumn(name = "id_compra", referencedColumnName = "id_compra", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Compras compras;
    @JoinColumns({
        @JoinColumn(name = "id_producto", referencedColumnName = "id_producto", insertable = false, updatable = false),
        @JoinColumn(name = "id_deposito", referencedColumnName = "id_deposito", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Stock stock;

    public ComprasDet() {
    }

    public ComprasDet(ComprasDetPK comprasDetPK) {
        this.comprasDetPK = comprasDetPK;
    }

    public ComprasDet(ComprasDetPK comprasDetPK, BigDecimal porcIva, BigDecimal cantidad, BigDecimal precioUni) {
        this.comprasDetPK = comprasDetPK;
        this.porcIva = porcIva;
        this.cantidad = cantidad;
        this.precioUni = precioUni;
    }

    public ComprasDet(int idCompra, int idProducto, int idDeposito) {
        this.comprasDetPK = new ComprasDetPK(idCompra, idProducto, idDeposito);
    }

    public ComprasDetPK getComprasDetPK() {
        return comprasDetPK;
    }

    public void setComprasDetPK(ComprasDetPK comprasDetPK) {
        this.comprasDetPK = comprasDetPK;
    }

    public BigDecimal getPorcIva() {
        return porcIva;
    }

    public void setPorcIva(BigDecimal porcIva) {
        this.porcIva = porcIva;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioUni() {
        return precioUni;
    }

    public void setPrecioUni(BigDecimal precioUni) {
        this.precioUni = precioUni;
    }

    public Compras getCompras() {
        return compras;
    }

    public void setCompras(Compras compras) {
        this.compras = compras;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (comprasDetPK != null ? comprasDetPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComprasDet)) {
            return false;
        }
        ComprasDet other = (ComprasDet) object;
        if ((this.comprasDetPK == null && other.comprasDetPK != null) || (this.comprasDetPK != null && !this.comprasDetPK.equals(other.comprasDetPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.ComprasDet[ comprasDetPK=" + comprasDetPK + " ]";
    }
    
}
