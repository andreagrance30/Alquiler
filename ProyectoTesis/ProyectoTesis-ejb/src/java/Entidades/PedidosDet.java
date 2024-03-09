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
@Table(name = "pedidos_det")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PedidosDet.findAll", query = "SELECT p FROM PedidosDet p"),
    @NamedQuery(name = "PedidosDet.findByIdPedido", query = "SELECT p FROM PedidosDet p WHERE p.pedidosDetPK.idPedido = :idPedido"),
    @NamedQuery(name = "PedidosDet.findByIdProducto", query = "SELECT p FROM PedidosDet p WHERE p.pedidosDetPK.idProducto = :idProducto"),
    @NamedQuery(name = "PedidosDet.findByIdDeposito", query = "SELECT p FROM PedidosDet p WHERE p.pedidosDetPK.idDeposito = :idDeposito"),
    @NamedQuery(name = "PedidosDet.findByCantidad", query = "SELECT p FROM PedidosDet p WHERE p.cantidad = :cantidad")})
public class PedidosDet implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PedidosDetPK pedidosDetPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private BigDecimal cantidad;
    @JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pedidos pedidos;
    @JoinColumns({
        @JoinColumn(name = "id_producto", referencedColumnName = "id_producto", insertable = false, updatable = false),
        @JoinColumn(name = "id_deposito", referencedColumnName = "id_deposito", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Stock stock;

    public PedidosDet() {
    }

    public PedidosDet(PedidosDetPK pedidosDetPK) {
        this.pedidosDetPK = pedidosDetPK;
    }

    public PedidosDet(PedidosDetPK pedidosDetPK, BigDecimal cantidad) {
        this.pedidosDetPK = pedidosDetPK;
        this.cantidad = cantidad;
    }

    public PedidosDet(int idPedido, int idProducto, int idDeposito) {
        this.pedidosDetPK = new PedidosDetPK(idPedido, idProducto, idDeposito);
    }

    public PedidosDetPK getPedidosDetPK() {
        return pedidosDetPK;
    }

    public void setPedidosDetPK(PedidosDetPK pedidosDetPK) {
        this.pedidosDetPK = pedidosDetPK;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public Pedidos getPedidos() {
        return pedidos;
    }

    public void setPedidos(Pedidos pedidos) {
        this.pedidos = pedidos;
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
        hash += (pedidosDetPK != null ? pedidosDetPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PedidosDet)) {
            return false;
        }
        PedidosDet other = (PedidosDet) object;
        if ((this.pedidosDetPK == null && other.pedidosDetPK != null) || (this.pedidosDetPK != null && !this.pedidosDetPK.equals(other.pedidosDetPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.PedidosDet[ pedidosDetPK=" + pedidosDetPK + " ]";
    }
    
}
