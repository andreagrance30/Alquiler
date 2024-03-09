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
public class OrdenesTrabajosDetPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_orden_trabajo")
    private int idOrdenTrabajo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_empleado")
    private int idEmpleado;

    public OrdenesTrabajosDetPK() {
    }

    public OrdenesTrabajosDetPK(int idOrdenTrabajo, int idEmpleado) {
        this.idOrdenTrabajo = idOrdenTrabajo;
        this.idEmpleado = idEmpleado;
    }

    public int getIdOrdenTrabajo() {
        return idOrdenTrabajo;
    }

    public void setIdOrdenTrabajo(int idOrdenTrabajo) {
        this.idOrdenTrabajo = idOrdenTrabajo;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idOrdenTrabajo;
        hash += (int) idEmpleado;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenesTrabajosDetPK)) {
            return false;
        }
        OrdenesTrabajosDetPK other = (OrdenesTrabajosDetPK) object;
        if (this.idOrdenTrabajo != other.idOrdenTrabajo) {
            return false;
        }
        if (this.idEmpleado != other.idEmpleado) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.OrdenesTrabajosDetPK[ idOrdenTrabajo=" + idOrdenTrabajo + ", idEmpleado=" + idEmpleado + " ]";
    }
    
}