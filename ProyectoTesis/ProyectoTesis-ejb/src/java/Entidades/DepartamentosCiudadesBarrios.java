/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andrea Salinas
 */
@Entity
@Table(name = "departamentos_ciudades_barrios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DepartamentosCiudadesBarrios.findAll", query = "SELECT d FROM DepartamentosCiudadesBarrios d"),
    @NamedQuery(name = "DepartamentosCiudadesBarrios.findByIdDepartamento", query = "SELECT d FROM DepartamentosCiudadesBarrios d WHERE d.departamentosCiudadesBarriosPK.idDepartamento = :idDepartamento"),
    @NamedQuery(name = "DepartamentosCiudadesBarrios.findByIdBarrio", query = "SELECT d FROM DepartamentosCiudadesBarrios d WHERE d.departamentosCiudadesBarriosPK.idBarrio = :idBarrio"),
    @NamedQuery(name = "DepartamentosCiudadesBarrios.findByIdCiudad", query = "SELECT d FROM DepartamentosCiudadesBarrios d WHERE d.departamentosCiudadesBarriosPK.idCiudad = :idCiudad")})
public class DepartamentosCiudadesBarrios implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DepartamentosCiudadesBarriosPK departamentosCiudadesBarriosPK;
    @JoinColumn(name = "id_barrio", referencedColumnName = "id_barrio", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Barrios barrios;
    @JoinColumn(name = "id_ciudad", referencedColumnName = "id_ciudad", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ciudades ciudades;
    @JoinColumn(name = "id_departamento", referencedColumnName = "id_departamento", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Departamentos departamentos;

    public DepartamentosCiudadesBarrios() {
    }

    public DepartamentosCiudadesBarrios(DepartamentosCiudadesBarriosPK departamentosCiudadesBarriosPK) {
        this.departamentosCiudadesBarriosPK = departamentosCiudadesBarriosPK;
    }

    public DepartamentosCiudadesBarrios(int idDepartamento, int idBarrio, int idCiudad) {
        this.departamentosCiudadesBarriosPK = new DepartamentosCiudadesBarriosPK(idDepartamento, idBarrio, idCiudad);
    }

    public DepartamentosCiudadesBarriosPK getDepartamentosCiudadesBarriosPK() {
        return departamentosCiudadesBarriosPK;
    }

    public void setDepartamentosCiudadesBarriosPK(DepartamentosCiudadesBarriosPK departamentosCiudadesBarriosPK) {
        this.departamentosCiudadesBarriosPK = departamentosCiudadesBarriosPK;
    }

    public Barrios getBarrios() {
        return barrios;
    }

    public void setBarrios(Barrios barrios) {
        this.barrios = barrios;
    }

    public Ciudades getCiudades() {
        return ciudades;
    }

    public void setCiudades(Ciudades ciudades) {
        this.ciudades = ciudades;
    }

    public Departamentos getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(Departamentos departamentos) {
        this.departamentos = departamentos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (departamentosCiudadesBarriosPK != null ? departamentosCiudadesBarriosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DepartamentosCiudadesBarrios)) {
            return false;
        }
        DepartamentosCiudadesBarrios other = (DepartamentosCiudadesBarrios) object;
        if ((this.departamentosCiudadesBarriosPK == null && other.departamentosCiudadesBarriosPK != null) || (this.departamentosCiudadesBarriosPK != null && !this.departamentosCiudadesBarriosPK.equals(other.departamentosCiudadesBarriosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.DepartamentosCiudadesBarrios[ departamentosCiudadesBarriosPK=" + departamentosCiudadesBarriosPK + " ]";
    }
    
}
