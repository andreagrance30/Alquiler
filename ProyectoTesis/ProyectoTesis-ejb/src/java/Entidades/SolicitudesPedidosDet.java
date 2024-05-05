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
@Table(name = "solicitudes_pedidos_det")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SolicitudesPedidosDet.findAll", query = "SELECT s FROM SolicitudesPedidosDet s"),
    @NamedQuery(name = "SolicitudesPedidosDet.findByIdSolicitudPedido", query = "SELECT s FROM SolicitudesPedidosDet s WHERE s.solicitudesPedidosDetPK.idSolicitudPedido = :idSolicitudPedido"),
    @NamedQuery(name = "SolicitudesPedidosDet.findByIdProducto", query = "SELECT s FROM SolicitudesPedidosDet s WHERE s.solicitudesPedidosDetPK.idProducto = :idProducto"),
    @NamedQuery(name = "SolicitudesPedidosDet.findByCantidad", query = "SELECT s FROM SolicitudesPedidosDet s WHERE s.cantidad = :cantidad")})
public class SolicitudesPedidosDet implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SolicitudesPedidosDetPK solicitudesPedidosDetPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private BigInteger cantidad;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Productos productos;
    @JoinColumn(name = "id_solicitud_pedido", referencedColumnName = "id_solicitud_pedido", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SolicitudesPedidos solicitudesPedidos;
    @JoinColumns({
        @JoinColumn(name = "id_producto", referencedColumnName = "id_producto", insertable = false, updatable = false),
        @JoinColumn(name = "id_deposito", referencedColumnName = "id_deposito")})
    @ManyToOne(optional = false)
    private Stock stock;

    public SolicitudesPedidosDet() {
    }

    public SolicitudesPedidosDet(SolicitudesPedidosDetPK solicitudesPedidosDetPK) {
        this.solicitudesPedidosDetPK = solicitudesPedidosDetPK;
    }

    public SolicitudesPedidosDet(SolicitudesPedidosDetPK solicitudesPedidosDetPK, BigInteger cantidad) {
        this.solicitudesPedidosDetPK = solicitudesPedidosDetPK;
        this.cantidad = cantidad;
    }

    public SolicitudesPedidosDet(int idSolicitudPedido, int idProducto) {
        this.solicitudesPedidosDetPK = new SolicitudesPedidosDetPK(idSolicitudPedido, idProducto);
    }

    public SolicitudesPedidosDetPK getSolicitudesPedidosDetPK() {
        return solicitudesPedidosDetPK;
    }

    public void setSolicitudesPedidosDetPK(SolicitudesPedidosDetPK solicitudesPedidosDetPK) {
        this.solicitudesPedidosDetPK = solicitudesPedidosDetPK;
    }

    public BigInteger getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigInteger cantidad) {
        this.cantidad = cantidad;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    public SolicitudesPedidos getSolicitudesPedidos() {
        return solicitudesPedidos;
    }

    public void setSolicitudesPedidos(SolicitudesPedidos solicitudesPedidos) {
        this.solicitudesPedidos = solicitudesPedidos;
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
        hash += (solicitudesPedidosDetPK != null ? solicitudesPedidosDetPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SolicitudesPedidosDet)) {
            return false;
        }
        SolicitudesPedidosDet other = (SolicitudesPedidosDet) object;
        if ((this.solicitudesPedidosDetPK == null && other.solicitudesPedidosDetPK != null) || (this.solicitudesPedidosDetPK != null && !this.solicitudesPedidosDetPK.equals(other.solicitudesPedidosDetPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.SolicitudesPedidosDet[ solicitudesPedidosDetPK=" + solicitudesPedidosDetPK + " ]";
    }
    
}
