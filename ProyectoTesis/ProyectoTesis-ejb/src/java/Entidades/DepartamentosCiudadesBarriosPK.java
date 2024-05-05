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
public class DepartamentosCiudadesBarriosPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_departamento")
    private int idDepartamento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_barrio")
    private int idBarrio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_ciudad")
    private int idCiudad;

    public DepartamentosCiudadesBarriosPK() {
    }

    public DepartamentosCiudadesBarriosPK(int idDepartamento, int idBarrio, int idCiudad) {
        this.idDepartamento = idDepartamento;
        this.idBarrio = idBarrio;
        this.idCiudad = idCiudad;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public int getIdBarrio() {
        return idBarrio;
    }

    public void setIdBarrio(int idBarrio) {
        this.idBarrio = idBarrio;
    }

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idDepartamento;
        hash += (int) idBarrio;
        hash += (int) idCiudad;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DepartamentosCiudadesBarriosPK)) {
            return false;
        }
        DepartamentosCiudadesBarriosPK other = (DepartamentosCiudadesBarriosPK) object;
        if (this.idDepartamento != other.idDepartamento) {
            return false;
        }
        if (this.idBarrio != other.idBarrio) {
            return false;
        }
        if (this.idCiudad != other.idCiudad) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.DepartamentosCiudadesBarriosPK[ idDepartamento=" + idDepartamento + ", idBarrio=" + idBarrio + ", idCiudad=" + idCiudad + " ]";
    }
    
}
