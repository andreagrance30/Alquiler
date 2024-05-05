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
public class PresupuestosClientesDetPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_presupuesto_cliente")
    private int idPresupuestoCliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_producto")
    private int idProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_deposito")
    private int idDeposito;

    public PresupuestosClientesDetPK() {
    }

    public PresupuestosClientesDetPK(int idPresupuestoCliente, int idProducto, int idDeposito) {
        this.idPresupuestoCliente = idPresupuestoCliente;
        this.idProducto = idProducto;
        this.idDeposito = idDeposito;
    }

    public int getIdPresupuestoCliente() {
        return idPresupuestoCliente;
    }

    public void setIdPresupuestoCliente(int idPresupuestoCliente) {
        this.idPresupuestoCliente = idPresupuestoCliente;
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
        hash += (int) idPresupuestoCliente;
        hash += (int) idProducto;
        hash += (int) idDeposito;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PresupuestosClientesDetPK)) {
            return false;
        }
        PresupuestosClientesDetPK other = (PresupuestosClientesDetPK) object;
        if (this.idPresupuestoCliente != other.idPresupuestoCliente) {
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
        return "Entidades.PresupuestosClientesDetPK[ idPresupuestoCliente=" + idPresupuestoCliente + ", idProducto=" + idProducto + ", idDeposito=" + idDeposito + " ]";
    }
    
}
