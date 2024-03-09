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
public class IntinerariosDetPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_orden_trabajo")
    private int idOrdenTrabajo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_intinerario")
    private int idIntinerario;

    public IntinerariosDetPK() {
    }

    public IntinerariosDetPK(int idOrdenTrabajo, int idIntinerario) {
        this.idOrdenTrabajo = idOrdenTrabajo;
        this.idIntinerario = idIntinerario;
    }

    public int getIdOrdenTrabajo() {
        return idOrdenTrabajo;
    }

    public void setIdOrdenTrabajo(int idOrdenTrabajo) {
        this.idOrdenTrabajo = idOrdenTrabajo;
    }

    public int getIdIntinerario() {
        return idIntinerario;
    }

    public void setIdIntinerario(int idIntinerario) {
        this.idIntinerario = idIntinerario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idOrdenTrabajo;
        hash += (int) idIntinerario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IntinerariosDetPK)) {
            return false;
        }
        IntinerariosDetPK other = (IntinerariosDetPK) object;
        if (this.idOrdenTrabajo != other.idOrdenTrabajo) {
            return false;
        }
        if (this.idIntinerario != other.idIntinerario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.IntinerariosDetPK[ idOrdenTrabajo=" + idOrdenTrabajo + ", idIntinerario=" + idIntinerario + " ]";
    }
    
}
