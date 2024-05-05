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
public class CobrosDetPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_cobro")
    private int idCobro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_cuenta_cobrar")
    private int idCuentaCobrar;

    public CobrosDetPK() {
    }

    public CobrosDetPK(int idCobro, int idCuentaCobrar) {
        this.idCobro = idCobro;
        this.idCuentaCobrar = idCuentaCobrar;
    }

    public int getIdCobro() {
        return idCobro;
    }

    public void setIdCobro(int idCobro) {
        this.idCobro = idCobro;
    }

    public int getIdCuentaCobrar() {
        return idCuentaCobrar;
    }

    public void setIdCuentaCobrar(int idCuentaCobrar) {
        this.idCuentaCobrar = idCuentaCobrar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCobro;
        hash += (int) idCuentaCobrar;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CobrosDetPK)) {
            return false;
        }
        CobrosDetPK other = (CobrosDetPK) object;
        if (this.idCobro != other.idCobro) {
            return false;
        }
        if (this.idCuentaCobrar != other.idCuentaCobrar) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.CobrosDetPK[ idCobro=" + idCobro + ", idCuentaCobrar=" + idCuentaCobrar + " ]";
    }
    
}
