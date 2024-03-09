/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Andrea Salinas
 */
@Entity
@Table(name = "vehiculos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehiculos.findAll", query = "SELECT v FROM Vehiculos v"),
    @NamedQuery(name = "Vehiculos.findByIdVehiculo", query = "SELECT v FROM Vehiculos v WHERE v.idVehiculo = :idVehiculo"),
    @NamedQuery(name = "Vehiculos.findByAnho", query = "SELECT v FROM Vehiculos v WHERE v.anho = :anho"),
    @NamedQuery(name = "Vehiculos.findByColor", query = "SELECT v FROM Vehiculos v WHERE v.color = :color"),
    @NamedQuery(name = "Vehiculos.findByNroChapa", query = "SELECT v FROM Vehiculos v WHERE v.nroChapa = :nroChapa"),
    @NamedQuery(name = "Vehiculos.findByNroChasis", query = "SELECT v FROM Vehiculos v WHERE v.nroChasis = :nroChasis")})
public class Vehiculos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_vehiculo")
    private Integer idVehiculo;
    @Column(name = "anho")
    private BigInteger anho;
    @Size(max = 255)
    @Column(name = "color")
    private String color;
    @Size(max = 255)
    @Column(name = "nro_chapa")
    private String nroChapa;
    @Size(max = 255)
    @Column(name = "nro_chasis")
    private String nroChasis;
    @JoinColumn(name = "id_marca", referencedColumnName = "id_marca")
    @ManyToOne
    private Marcas idMarca;
    @JoinColumn(name = "id_modelo", referencedColumnName = "id_modelo")
    @ManyToOne
    private Modelos idModelo;
    @OneToMany(mappedBy = "idVehiculo")
    private List<NotasRemisiones> notasRemisionesList;
    @OneToMany(mappedBy = "idVehiculo")
    private List<Intinerarios> intinerariosList;

    public Vehiculos() {
    }

    public Vehiculos(Integer idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public Integer getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Integer idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public BigInteger getAnho() {
        return anho;
    }

    public void setAnho(BigInteger anho) {
        this.anho = anho;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNroChapa() {
        return nroChapa;
    }

    public void setNroChapa(String nroChapa) {
        this.nroChapa = nroChapa;
    }

    public String getNroChasis() {
        return nroChasis;
    }

    public void setNroChasis(String nroChasis) {
        this.nroChasis = nroChasis;
    }

    public Marcas getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Marcas idMarca) {
        this.idMarca = idMarca;
    }

    public Modelos getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(Modelos idModelo) {
        this.idModelo = idModelo;
    }

    @XmlTransient
    public List<NotasRemisiones> getNotasRemisionesList() {
        return notasRemisionesList;
    }

    public void setNotasRemisionesList(List<NotasRemisiones> notasRemisionesList) {
        this.notasRemisionesList = notasRemisionesList;
    }

    @XmlTransient
    public List<Intinerarios> getIntinerariosList() {
        return intinerariosList;
    }

    public void setIntinerariosList(List<Intinerarios> intinerariosList) {
        this.intinerariosList = intinerariosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVehiculo != null ? idVehiculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehiculos)) {
            return false;
        }
        Vehiculos other = (Vehiculos) object;
        if ((this.idVehiculo == null && other.idVehiculo != null) || (this.idVehiculo != null && !this.idVehiculo.equals(other.idVehiculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Vehiculos[ idVehiculo=" + idVehiculo + " ]";
    }
    
}
