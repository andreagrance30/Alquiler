/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Andrea Salinas
 */

@Embeddable
public class SolicitudesPedidosDetPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_solicitud_pedido")
    private int idSolicitudPedido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_producto")
    private int idProducto;

    public SolicitudesPedidosDetPK() {
    }

    public SolicitudesPedidosDetPK(int idSolicitudPedido, int idProducto) {
        this.idSolicitudPedido = idSolicitudPedido;
        this.idProducto = idProducto;
    }

    public int getIdSolicitudPedido() {
        return idSolicitudPedido;
    }

    public void setIdSolicitudPedido(int idSolicitudPedido) {
        this.idSolicitudPedido = idSolicitudPedido;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idSolicitudPedido;
        hash += (int) idProducto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SolicitudesPedidosDetPK)) {
            return false;
        }
        SolicitudesPedidosDetPK other = (SolicitudesPedidosDetPK) object;
        if (this.idSolicitudPedido != other.idSolicitudPedido) {
            return false;
        }
        if (this.idProducto != other.idProducto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.SolicitudesPedidosDetPK[ idSolicitudPedido=" + idSolicitudPedido + ", idProducto=" + idProducto + " ]";
    }

}
