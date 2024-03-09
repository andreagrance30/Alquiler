/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Andrea Salinas
 */
@Entity
@Table(name = "empleados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleados.findAll", query = "SELECT e FROM Empleados e"),
    @NamedQuery(name = "Empleados.findByIdEmpleado", query = "SELECT e FROM Empleados e WHERE e.idEmpleado = :idEmpleado"),
    @NamedQuery(name = "Empleados.findByFechaNacimiento", query = "SELECT e FROM Empleados e WHERE e.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Empleados.findBySalario", query = "SELECT e FROM Empleados e WHERE e.salario = :salario"),
    @NamedQuery(name = "Empleados.findByEstado", query = "SELECT e FROM Empleados e WHERE e.estado = :estado")})
public class Empleados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_empleado")
    private Integer idEmpleado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "salario")
    private BigInteger salario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpleado")
    private List<Pedidos> pedidosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpleado")
    private List<Usuarios> usuariosList;
    @JoinColumn(name = "id_cargo", referencedColumnName = "id_cargo")
    @ManyToOne(optional = false)
    private Cargos idCargo;
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_persona", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Personas personas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleados")
    private List<OrdenesTrabajosDet> ordenesTrabajosDetList;
    @OneToMany(mappedBy = "idEmpleado")
    private List<NotasRemisiones> notasRemisionesList;

    public Empleados() {
    }

    public Empleados(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Empleados(Integer idEmpleado, Date fechaNacimiento, BigInteger salario, String estado) {
        this.idEmpleado = idEmpleado;
        this.fechaNacimiento = fechaNacimiento;
        this.salario = salario;
        this.estado = estado;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public BigInteger getSalario() {
        return salario;
    }

    public void setSalario(BigInteger salario) {
        this.salario = salario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<Pedidos> getPedidosList() {
        return pedidosList;
    }

    public void setPedidosList(List<Pedidos> pedidosList) {
        this.pedidosList = pedidosList;
    }

    @XmlTransient
    public List<Usuarios> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
    }

    public Cargos getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Cargos idCargo) {
        this.idCargo = idCargo;
    }

    public Personas getPersonas() {
        return personas;
    }

    public void setPersonas(Personas personas) {
        this.personas = personas;
    }

    @XmlTransient
    public List<OrdenesTrabajosDet> getOrdenesTrabajosDetList() {
        return ordenesTrabajosDetList;
    }

    public void setOrdenesTrabajosDetList(List<OrdenesTrabajosDet> ordenesTrabajosDetList) {
        this.ordenesTrabajosDetList = ordenesTrabajosDetList;
    }

    @XmlTransient
    public List<NotasRemisiones> getNotasRemisionesList() {
        return notasRemisionesList;
    }

    public void setNotasRemisionesList(List<NotasRemisiones> notasRemisionesList) {
        this.notasRemisionesList = notasRemisionesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpleado != null ? idEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleados)) {
            return false;
        }
        Empleados other = (Empleados) object;
        if ((this.idEmpleado == null && other.idEmpleado != null) || (this.idEmpleado != null && !this.idEmpleado.equals(other.idEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Empleados[ idEmpleado=" + idEmpleado + " ]";
    }
    
}
