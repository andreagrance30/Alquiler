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
import javax.validation.constraints.Size;

/**
 *
 * @author Andrea Salinas
 */
@Embeddable
public class UsuariosSucursalesPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_sucursal")
    private int idSucursal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "id_usuario")
    private String idUsuario;

    public UsuariosSucursalesPK() {
    }

    public UsuariosSucursalesPK(int idSucursal, String idUsuario) {
        this.idSucursal = idSucursal;
        this.idUsuario = idUsuario;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idSucursal;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuariosSucursalesPK)) {
            return false;
        }
        UsuariosSucursalesPK other = (UsuariosSucursalesPK) object;
        if (this.idSucursal != other.idSucursal) {
            return false;
        }
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.UsuariosSucursalesPK[ idSucursal=" + idSucursal + ", idUsuario=" + idUsuario + " ]";
    }
    
}
