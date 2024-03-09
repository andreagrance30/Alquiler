/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andrea Salinas
 */
@Entity
@Table(name = "ordenes_trabajos_det")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenesTrabajosDet.findAll", query = "SELECT o FROM OrdenesTrabajosDet o"),
    @NamedQuery(name = "OrdenesTrabajosDet.findByIdOrdenTrabajo", query = "SELECT o FROM OrdenesTrabajosDet o WHERE o.ordenesTrabajosDetPK.idOrdenTrabajo = :idOrdenTrabajo"),
    @NamedQuery(name = "OrdenesTrabajosDet.findByIdEmpleado", query = "SELECT o FROM OrdenesTrabajosDet o WHERE o.ordenesTrabajosDetPK.idEmpleado = :idEmpleado"),
    @NamedQuery(name = "OrdenesTrabajosDet.findByEstado", query = "SELECT o FROM OrdenesTrabajosDet o WHERE o.estado = :estado")})
public class OrdenesTrabajosDet implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OrdenesTrabajosDetPK ordenesTrabajosDetPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Empleados empleados;
    @JoinColumn(name = "id_orden_trabajo", referencedColumnName = "id_orden_trabajo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private OrdenesTrabajos ordenesTrabajos;

    public OrdenesTrabajosDet() {
    }

    public OrdenesTrabajosDet(OrdenesTrabajosDetPK ordenesTrabajosDetPK) {
        this.ordenesTrabajosDetPK = ordenesTrabajosDetPK;
    }

    public OrdenesTrabajosDet(OrdenesTrabajosDetPK ordenesTrabajosDetPK, String estado) {
        this.ordenesTrabajosDetPK = ordenesTrabajosDetPK;
        this.estado = estado;
    }

    public OrdenesTrabajosDet(int idOrdenTrabajo, int idEmpleado) {
        this.ordenesTrabajosDetPK = new OrdenesTrabajosDetPK(idOrdenTrabajo, idEmpleado);
    }

    public OrdenesTrabajosDetPK getOrdenesTrabajosDetPK() {
        return ordenesTrabajosDetPK;
    }

    public void setOrdenesTrabajosDetPK(OrdenesTrabajosDetPK ordenesTrabajosDetPK) {
        this.ordenesTrabajosDetPK = ordenesTrabajosDetPK;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Empleados getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleados empleados) {
        this.empleados = empleados;
    }

    public OrdenesTrabajos getOrdenesTrabajos() {
        return ordenesTrabajos;
    }

    public void setOrdenesTrabajos(OrdenesTrabajos ordenesTrabajos) {
        this.ordenesTrabajos = ordenesTrabajos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ordenesTrabajosDetPK != null ? ordenesTrabajosDetPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenesTrabajosDet)) {
            return false;
        }
        OrdenesTrabajosDet other = (OrdenesTrabajosDet) object;
        if ((this.ordenesTrabajosDetPK == null && other.ordenesTrabajosDetPK != null) || (this.ordenesTrabajosDetPK != null && !this.ordenesTrabajosDetPK.equals(other.ordenesTrabajosDetPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.OrdenesTrabajosDet[ ordenesTrabajosDetPK=" + ordenesTrabajosDetPK + " ]";
    }
    
}
