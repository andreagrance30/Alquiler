/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andrea Salinas
 */
@Entity
@Table(name = "intinerarios_det")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IntinerariosDet.findAll", query = "SELECT i FROM IntinerariosDet i"),
    @NamedQuery(name = "IntinerariosDet.findByEstado", query = "SELECT i FROM IntinerariosDet i WHERE i.estado = :estado"),
    @NamedQuery(name = "IntinerariosDet.findByIdOrdenTrabajo", query = "SELECT i FROM IntinerariosDet i WHERE i.intinerariosDetPK.idOrdenTrabajo = :idOrdenTrabajo"),
    @NamedQuery(name = "IntinerariosDet.findByIdIntinerario", query = "SELECT i FROM IntinerariosDet i WHERE i.intinerariosDetPK.idIntinerario = :idIntinerario")})
public class IntinerariosDet implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected IntinerariosDetPK intinerariosDetPK;
    @Size(max = 255)
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "id_intinerario", referencedColumnName = "id_intinerario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Intinerarios intinerarios;
    @JoinColumn(name = "id_orden_trabajo", referencedColumnName = "id_orden_trabajo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private OrdenesTrabajos ordenesTrabajos;

    public IntinerariosDet() {
    }

    public IntinerariosDet(IntinerariosDetPK intinerariosDetPK) {
        this.intinerariosDetPK = intinerariosDetPK;
    }

    public IntinerariosDet(int idOrdenTrabajo, int idIntinerario) {
        this.intinerariosDetPK = new IntinerariosDetPK(idOrdenTrabajo, idIntinerario);
    }

    public IntinerariosDetPK getIntinerariosDetPK() {
        return intinerariosDetPK;
    }

    public void setIntinerariosDetPK(IntinerariosDetPK intinerariosDetPK) {
        this.intinerariosDetPK = intinerariosDetPK;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Intinerarios getIntinerarios() {
        return intinerarios;
    }

    public void setIntinerarios(Intinerarios intinerarios) {
        this.intinerarios = intinerarios;
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
        hash += (intinerariosDetPK != null ? intinerariosDetPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IntinerariosDet)) {
            return false;
        }
        IntinerariosDet other = (IntinerariosDet) object;
        if ((this.intinerariosDetPK == null && other.intinerariosDetPK != null) || (this.intinerariosDetPK != null && !this.intinerariosDetPK.equals(other.intinerariosDetPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.IntinerariosDet[ intinerariosDetPK=" + intinerariosDetPK + " ]";
    }
    
}
