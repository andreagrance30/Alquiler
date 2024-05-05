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
@Table(name = "ventas_det")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VentasDet.findAll", query = "SELECT v FROM VentasDet v"),
    @NamedQuery(name = "VentasDet.findByIdVenta", query = "SELECT v FROM VentasDet v WHERE v.ventasDetPK.idVenta = :idVenta"),
    @NamedQuery(name = "VentasDet.findByIdProducto", query = "SELECT v FROM VentasDet v WHERE v.ventasDetPK.idProducto = :idProducto"),
    @NamedQuery(name = "VentasDet.findByIdDeposito", query = "SELECT v FROM VentasDet v WHERE v.ventasDetPK.idDeposito = :idDeposito"),
    @NamedQuery(name = "VentasDet.findByCantidad", query = "SELECT v FROM VentasDet v WHERE v.cantidad = :cantidad"),
    @NamedQuery(name = "VentasDet.findByPorcIva", query = "SELECT v FROM VentasDet v WHERE v.porcIva = :porcIva"),
    @NamedQuery(name = "VentasDet.findByPrecioUni", query = "SELECT v FROM VentasDet v WHERE v.precioUni = :precioUni")})
public class VentasDet implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VentasDetPK ventasDetPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private BigInteger cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "porc_iva")
    private BigInteger porcIva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_uni")
    private BigInteger precioUni;
    @JoinColumns({
        @JoinColumn(name = "id_producto", referencedColumnName = "id_producto", insertable = false, updatable = false),
        @JoinColumn(name = "id_deposito", referencedColumnName = "id_deposito", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Stock stock;
    @JoinColumn(name = "id_venta", referencedColumnName = "id_venta", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ventas ventas;

    public VentasDet() {
    }

    public VentasDet(VentasDetPK ventasDetPK) {
        this.ventasDetPK = ventasDetPK;
    }

    public VentasDet(VentasDetPK ventasDetPK, BigInteger cantidad, BigInteger porcIva, BigInteger precioUni) {
        this.ventasDetPK = ventasDetPK;
        this.cantidad = cantidad;
        this.porcIva = porcIva;
        this.precioUni = precioUni;
    }

    public VentasDet(int idVenta, int idProducto, int idDeposito) {
        this.ventasDetPK = new VentasDetPK(idVenta, idProducto, idDeposito);
    }

    public VentasDetPK getVentasDetPK() {
        return ventasDetPK;
    }

    public void setVentasDetPK(VentasDetPK ventasDetPK) {
        this.ventasDetPK = ventasDetPK;
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

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public Ventas getVentas() {
        return ventas;
    }

    public void setVentas(Ventas ventas) {
        this.ventas = ventas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ventasDetPK != null ? ventasDetPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentasDet)) {
            return false;
        }
        VentasDet other = (VentasDet) object;
        if ((this.ventasDetPK == null && other.ventasDetPK != null) || (this.ventasDetPK != null && !this.ventasDetPK.equals(other.ventasDetPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.VentasDet[ ventasDetPK=" + ventasDetPK + " ]";
    }
    
}
