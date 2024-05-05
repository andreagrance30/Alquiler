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
public class CobrosFormasDetPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_cobro")
    private int idCobro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_transaccion_comercial")
    private int idTransaccionComercial;

    public CobrosFormasDetPK() {
    }

    public CobrosFormasDetPK(int idCobro, int idTransaccionComercial) {
        this.idCobro = idCobro;
        this.idTransaccionComercial = idTransaccionComercial;
    }

    public int getIdCobro() {
        return idCobro;
    }

    public void setIdCobro(int idCobro) {
        this.idCobro = idCobro;
    }

    public int getIdTransaccionComercial() {
        return idTransaccionComercial;
    }

    public void setIdTransaccionComercial(int idTransaccionComercial) {
        this.idTransaccionComercial = idTransaccionComercial;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCobro;
        hash += (int) idTransaccionComercial;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CobrosFormasDetPK)) {
            return false;
        }
        CobrosFormasDetPK other = (CobrosFormasDetPK) object;
        if (this.idCobro != other.idCobro) {
            return false;
        }
        if (this.idTransaccionComercial != other.idTransaccionComercial) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.CobrosFormasDetPK[ idCobro=" + idCobro + ", idTransaccionComercial=" + idTransaccionComercial + " ]";
    }
    
}
