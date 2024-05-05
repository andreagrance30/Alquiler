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
public class ArqueosCajasDetPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_transaccion_comercial")
    private int idTransaccionComercial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_arqueo_caja")
    private int idArqueoCaja;

    public ArqueosCajasDetPK() {
    }

    public ArqueosCajasDetPK(int idTransaccionComercial, int idArqueoCaja) {
        this.idTransaccionComercial = idTransaccionComercial;
        this.idArqueoCaja = idArqueoCaja;
    }

    public int getIdTransaccionComercial() {
        return idTransaccionComercial;
    }

    public void setIdTransaccionComercial(int idTransaccionComercial) {
        this.idTransaccionComercial = idTransaccionComercial;
    }

    public int getIdArqueoCaja() {
        return idArqueoCaja;
    }

    public void setIdArqueoCaja(int idArqueoCaja) {
        this.idArqueoCaja = idArqueoCaja;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idTransaccionComercial;
        hash += (int) idArqueoCaja;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArqueosCajasDetPK)) {
            return false;
        }
        ArqueosCajasDetPK other = (ArqueosCajasDetPK) object;
        if (this.idTransaccionComercial != other.idTransaccionComercial) {
            return false;
        }
        if (this.idArqueoCaja != other.idArqueoCaja) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.ArqueosCajasDetPK[ idTransaccionComercial=" + idTransaccionComercial + ", idArqueoCaja=" + idArqueoCaja + " ]";
    }
    
}
