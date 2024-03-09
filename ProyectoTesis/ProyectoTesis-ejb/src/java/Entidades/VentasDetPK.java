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
public class VentasDetPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_venta")
    private int idVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_producto")
    private int idProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_deposito")
    private int idDeposito;

    public VentasDetPK() {
    }

    public VentasDetPK(int idVenta, int idProducto, int idDeposito) {
        this.idVenta = idVenta;
        this.idProducto = idProducto;
        this.idDeposito = idDeposito;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdDeposito() {
        return idDeposito;
    }

    public void setIdDeposito(int idDeposito) {
        this.idDeposito = idDeposito;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idVenta;
        hash += (int) idProducto;
        hash += (int) idDeposito;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentasDetPK)) {
            return false;
        }
        VentasDetPK other = (VentasDetPK) object;
        if (this.idVenta != other.idVenta) {
            return false;
        }
        if (this.idProducto != other.idProducto) {
            return false;
        }
        if (this.idDeposito != other.idDeposito) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.VentasDetPK[ idVenta=" + idVenta + ", idProducto=" + idProducto + ", idDeposito=" + idDeposito + " ]";
    }
    
}
