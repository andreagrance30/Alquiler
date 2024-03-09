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
public class NotasRemisionesDetCPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_producto")
    private int idProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_nota_remsion_c")
    private int idNotaRemsionC;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_deposito")
    private int idDeposito;

    public NotasRemisionesDetCPK() {
    }

    public NotasRemisionesDetCPK(int idProducto, int idNotaRemsionC, int idDeposito) {
        this.idProducto = idProducto;
        this.idNotaRemsionC = idNotaRemsionC;
        this.idDeposito = idDeposito;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdNotaRemsionC() {
        return idNotaRemsionC;
    }

    public void setIdNotaRemsionC(int idNotaRemsionC) {
        this.idNotaRemsionC = idNotaRemsionC;
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
        hash += (int) idProducto;
        hash += (int) idNotaRemsionC;
        hash += (int) idDeposito;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotasRemisionesDetCPK)) {
            return false;
        }
        NotasRemisionesDetCPK other = (NotasRemisionesDetCPK) object;
        if (this.idProducto != other.idProducto) {
            return false;
        }
        if (this.idNotaRemsionC != other.idNotaRemsionC) {
            return false;
        }
        if (this.idDeposito != other.idDeposito) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.NotasRemisionesDetCPK[ idProducto=" + idProducto + ", idNotaRemsionC=" + idNotaRemsionC + ", idDeposito=" + idDeposito + " ]";
    }
    
}
