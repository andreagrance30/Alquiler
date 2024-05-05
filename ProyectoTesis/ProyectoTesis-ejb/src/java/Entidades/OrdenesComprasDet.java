/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "ordenes_compras_det")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenesComprasDet.findAll", query = "SELECT o FROM OrdenesComprasDet o"),
    @NamedQuery(name = "OrdenesComprasDet.findByIdOrdenCompra", query = "SELECT o FROM OrdenesComprasDet o WHERE o.ordenesComprasDetPK.idOrdenCompra = :idOrdenCompra"),
    @NamedQuery(name = "OrdenesComprasDet.findByIdProducto", query = "SELECT o FROM OrdenesComprasDet o WHERE o.ordenesComprasDetPK.idProducto = :idProducto"),
    @NamedQuery(name = "OrdenesComprasDet.findByIdDeposito", query = "SELECT o FROM OrdenesComprasDet o WHERE o.ordenesComprasDetPK.idDeposito = :idDeposito"),
    @NamedQuery(name = "OrdenesComprasDet.findByCantidad", query = "SELECT o FROM OrdenesComprasDet o WHERE o.cantidad = :cantidad"),
    @NamedQuery(name = "OrdenesComprasDet.findByPorcIva", query = "SELECT o FROM OrdenesComprasDet o WHERE o.porcIva = :porcIva"),
    @NamedQuery(name = "OrdenesComprasDet.findByPrecioUni", query = "SELECT o FROM OrdenesComprasDet o WHERE o.precioUni = :precioUni")})
public class OrdenesComprasDet implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OrdenesComprasDetPK ordenesComprasDetPK;
    @Basic(optional = false)
  //  @NotNull
    @Column(name = "cantidad")
    private BigInteger cantidad;
    @Basic(optional = false)
   // @NotNull
    @Column(name = "porc_iva")
    private BigInteger porcIva;
    @Basic(optional = false)
  //  @NotNull
    @Column(name = "precio_uni")
    private BigInteger precioUni;
    @JoinColumn(name = "id_orden_compra", referencedColumnName = "id_orden_compra", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private OrdenesCompras ordenesCompras;
    @JoinColumn(name = "id_presupuesto", referencedColumnName = "id_presupuesto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Presupuestos idPresupuesto;
    @JoinColumns({
        @JoinColumn(name = "id_presupuesto", referencedColumnName = "id_presupuesto", insertable = false, updatable = false),
        @JoinColumn(name = "id_producto", referencedColumnName = "id_producto", insertable = false, updatable = false),
        @JoinColumn(name = "id_deposito", referencedColumnName = "id_deposito", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private PresupuestosDet presupuestosDet;
    @JoinColumns({
        @JoinColumn(name = "id_producto", referencedColumnName = "id_producto", insertable = false, updatable = false),
        @JoinColumn(name = "id_deposito", referencedColumnName = "id_deposito", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Stock stock;

    public OrdenesComprasDet() {
    }

    public OrdenesComprasDet(OrdenesComprasDetPK ordenesComprasDetPK) {
        this.ordenesComprasDetPK = ordenesComprasDetPK;
    }

    public OrdenesComprasDet(OrdenesComprasDetPK ordenesComprasDetPK, BigInteger cantidad, BigInteger porcIva, BigInteger precioUni) {
        this.ordenesComprasDetPK = ordenesComprasDetPK;
        this.cantidad = cantidad;
        this.porcIva = porcIva;
        this.precioUni = precioUni;
    }

    public OrdenesComprasDet(int idOrdenCompra, int idProducto, int idDeposito) {
        this.ordenesComprasDetPK = new OrdenesComprasDetPK(idOrdenCompra, idProducto, idDeposito);
    }

    public OrdenesComprasDetPK getOrdenesComprasDetPK() {
        return ordenesComprasDetPK;
    }

    public void setOrdenesComprasDetPK(OrdenesComprasDetPK ordenesComprasDetPK) {
        this.ordenesComprasDetPK = ordenesComprasDetPK;
    }

    public BigInteger getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigInteger cantidad) {
        this.cantidad = cantidad;
    }

    public BigInteger getPorcIva() {
        return porcIva;
    }

    public void setPorcIva(BigInteger porcIva) {
        this.porcIva = porcIva;
    }

    public BigInteger getPrecioUni() {
        return precioUni;
    }

    public void setPrecioUni(BigInteger precioUni) {
        this.precioUni = precioUni;
    }

    public OrdenesCompras getOrdenesCompras() {
        return ordenesCompras;
    }

    public void setOrdenesCompras(OrdenesCompras ordenesCompras) {
        this.ordenesCompras = ordenesCompras;
    }

    public Presupuestos getIdPresupuesto() {
        return idPresupuesto;
    }

    public void setIdPresupuesto(Presupuestos idPresupuesto) {
        this.idPresupuesto = idPresupuesto;
    }

    public PresupuestosDet getPresupuestosDet() {
        return presupuestosDet;
    }

    public void setPresupuestosDet(PresupuestosDet presupuestosDet) {
        this.presupuestosDet = presupuestosDet;
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
        hash += (ordenesComprasDetPK != null ? ordenesComprasDetPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenesComprasDet)) {
            return false;
        }
        OrdenesComprasDet other = (OrdenesComprasDet) object;
        if ((this.ordenesComprasDetPK == null && other.ordenesComprasDetPK != null) || (this.ordenesComprasDetPK != null && !this.ordenesComprasDetPK.equals(other.ordenesComprasDetPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.OrdenesComprasDet[ ordenesComprasDetPK=" + ordenesComprasDetPK + " ]";
    }
    
}
