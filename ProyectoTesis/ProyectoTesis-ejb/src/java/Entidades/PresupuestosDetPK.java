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
public class PresupuestosDetPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_presupuesto")
    private int idPresupuesto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_producto")
    private int idProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_deposito")
    private int idDeposito;

    public PresupuestosDetPK() {
    }

    public PresupuestosDetPK(int idPresupuesto, int idProducto, int idDeposito) {
        this.idPresupuesto = idPresupuesto;
        this.idProducto = idProducto;
        this.idDeposito = idDeposito;
    }

    public int getIdPresupuesto() {
        return idPresupuesto;
    }

    public void setIdPresupuesto(int idPresupuesto) {
        this.idPresupuesto = idPresupuesto;
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
        hash += (int) idPresupuesto;
        hash += (int) idProducto;
        hash += (int) idDeposito;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PresupuestosDetPK)) {
            return false;
        }
        PresupuestosDetPK other = (PresupuestosDetPK) object;
        if (this.idPresupuesto != other.idPresupuesto) {
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
        return "Entidades.PresupuestosDetPK[ idPresupuesto=" + idPresupuesto + ", idProducto=" + idProducto + ", idDeposito=" + idDeposito + " ]";
    }
    
}
